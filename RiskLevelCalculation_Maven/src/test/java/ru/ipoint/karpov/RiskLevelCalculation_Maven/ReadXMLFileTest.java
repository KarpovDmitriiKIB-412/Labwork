package ru.ipoint.karpov.RiskLevelCalculation_Maven;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

public class ReadXMLFileTest {
	
	private ReadXMLFile ReadXML_File;
	private String FILE_NAME = "TestFileXML.xml";		//имя test-xml файла
	
	@Before
    public void init() { ReadXML_File = new ReadXMLFile(FILE_NAME); }
    @After
    public void tearDown() { ReadXML_File = null; }

    //тест метода чтения из файла массива Уровней ущерба
	@Test
	public void testGetLevelOfDamage_List() {

		//массив из стрех уровней ущерба соответствующие тест-файлу
				LevelOfDamage[] lvl_D_list = {
					(new LevelOfDamage(1,"Малый ущерб","abc")), 
						(new LevelOfDamage(2,"Средний ущерб","abc")), 
							(new LevelOfDamage(3,"Большой ущерб","abc"))	};				
		//этот массив должен соответствовать массиву, который прочитает из файла метод
				
		
		LevelOfDamage[] lvl_D_list_TEST = ReadXML_File.GetLevelOfDamage_List();
		
		//сравнивает объекты	
		for(int i=0; i< lvl_D_list.length; i++)
		{
			assertEquals(lvl_D_list[i].getId(), lvl_D_list_TEST[i].getId());
			assertEquals(lvl_D_list[i].getName(), lvl_D_list_TEST[i].getName());
			assertEquals(lvl_D_list[i].getDescription(), lvl_D_list_TEST[i].getDescription());
		}
	}

	 //тест метода чтения из файла массива Уровней вер-ти атаки
	@Test
	public void testGetLevelOfAttackProbability_List() {

		//массив из стрех уровней вероятности атаки
		LevelOfAttackProbability[] lvl_P_list = {
				(new LevelOfAttackProbability(1,"Низкая вероятность","abc")), 
					(new LevelOfAttackProbability(2,"Средняя вероятность","abc")), 
						(new LevelOfAttackProbability(3,"Высокая вероятность","abc"))	};				
		//этот массив должен соответствовать массиву, который прочитает из файла метод
				
		
		LevelOfAttackProbability[] lvl_P_list_TEST = ReadXML_File.GetLevelOfAttackProbability_List();
		
		//сравнивает объекты
		for(int i=0; i< lvl_P_list.length; i++)
		{
			assertEquals(lvl_P_list[i].getId(), lvl_P_list_TEST[i].getId());
			assertEquals(lvl_P_list[i].getName(), lvl_P_list_TEST[i].getName());
			assertEquals(lvl_P_list[i].getDescription(), lvl_P_list_TEST[i].getDescription());
		}
	}

	
	 //тест метода чтения из файла массива Уровней риска
	@Test
	public void testGetRiskLevel_List() {

		//массив из стрех уровней риска
				RiskLevel[] lvl_R_list = {
						(new RiskLevel(1,"Низкий риск","abc")), 
							(new RiskLevel(2,"Средний риск","abc")), 
								(new RiskLevel(3,"Высокий риск","abc"))	};				
		//этот массив должен соответствовать массиву, который прочитает из файла метод
				
		
		RiskLevel[] lvl_R_list_TEST = ReadXML_File.GetRiskLevel_List();
		
		//сравнивает объекты
		for(int i=0; i< lvl_R_list.length; i++)
		{
			assertEquals(lvl_R_list[i].getId(), lvl_R_list_TEST[i].getId());
			assertEquals(lvl_R_list[i].getName(), lvl_R_list_TEST[i].getName());
			assertEquals(lvl_R_list[i].getDescription(), lvl_R_list_TEST[i].getDescription());
		}
	}

	//Тест Метода чтения Уровня риска по идентификаторам УровняУщерба и УровняВероятности из файла
	@Test
	public void testGet_RiskLevelByIds() {
		
		//в соответствии с тестовым xml файлом параметры:
		//id уровня ущерба (2-"Средний") и id уровня вер-ти атаки (2-"Средняя")
		
		int Id_risk = ReadXML_File.Get_RiskLevelByIds(2, 2);
		//метод должен был вернуть id: "2" - "Средний риск"
		//проверяем
		
		//сравнивает результаты
		assertEquals(2, Id_risk);
	}

}

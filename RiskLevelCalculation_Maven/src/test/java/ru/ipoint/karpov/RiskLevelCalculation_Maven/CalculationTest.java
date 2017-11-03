package ru.ipoint.karpov.RiskLevelCalculation_Maven;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
	Данный тест-класс тестирует работу класса Calculation
*/

public class CalculationTest {

	private Calculation calculation;
	
	
	@Before
    public void init() 
	{
		//Создание необходимых объектов для теста
		
		//массив из стрех уровней ущерба
		LevelOfDamage[] lvl_D_list = {
			(new LevelOfDamage(1,"Малый ущерб"," ")), 
				(new LevelOfDamage(2,"Средний ущерб"," ")), 
					(new LevelOfDamage(3,"Большой ущерб"," "))	};
		
		//массив из стрех уровней вероятности атаки
		LevelOfAttackProbability[] lvl_P_list = {
				(new LevelOfAttackProbability(1,"Низкая вероятность"," ")), 
					(new LevelOfAttackProbability(2,"Средняя вероятность"," ")), 
						(new LevelOfAttackProbability(3,"Высокая вероятность"," "))	};
		
		//массив из стрех уровней риска
		RiskLevel[] lvl_R_list = {
				(new RiskLevel(1,"Низкий риск"," ")), 
					(new RiskLevel(2,"Средний риск"," ")), 
						(new RiskLevel(3,"Высокий риск"," "))	};
		
		
		calculation = new Calculation(lvl_D_list, lvl_P_list, lvl_R_list);
	}
	
    @After
    public void tearDown() { calculation = null; }
	
    
   
    //тест метода поиска объекта Уровня риска в массиве по его ID
	@Test
	public void testSearch_LevelOfRisk() {

		RiskLevel lvl_D = calculation.Search_LevelOfRisk(3);
		
		assertSame(lvl_D, calculation.lvl_R_List[2]);
	}

    
	//тест метода поиска объекта Уровня ущерба в массиве  по его наименованию
	@Test
	public void testSearch_LevelOfDamage() {
		
		LevelOfDamage lvl_D = calculation.Search_LevelOfDamage("Малый ущерб");
		
		assertSame(lvl_D, calculation.lvl_D_List[0]);
	}

	
	//тест метода поиска объекта Уровня вер-ти атаки в массиве по его наименованию
	@Test
	public void testSearch_LevelOfAttackProbability() {

		LevelOfAttackProbability lvl_D = calculation.Search_LevelOfAttackProbability("Средняя вероятность");
		
		assertSame(lvl_D, calculation.lvl_P_List[1]);
	}

	


}

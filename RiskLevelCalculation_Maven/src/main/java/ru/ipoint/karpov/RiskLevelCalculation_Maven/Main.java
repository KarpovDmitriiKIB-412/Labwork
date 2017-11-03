package ru.ipoint.karpov.RiskLevelCalculation_Maven;

//import GUI;
//import ReadXMLFile;



public class Main {

	
	public static void main(String[] args) 
	{
		String FILE_NAME = "TableLevelRisk.xml";	//имя файла		
		
		//Чтение xml файла
		ReadXMLFile XML_Reader = new ReadXMLFile(FILE_NAME);
		
		//Чтение списка "Уровня ущерба" из файла	(см. класс ReadXMLFile)
		LevelOfDamage[] lvl_D_List = XML_Reader.GetLevelOfDamage_List();
        
     	//Чтение списка "Уровня вероятности проведения атаки" из файла	(см. класс ReadXMLFile)
		LevelOfAttackProbability[] lvl_P_List = XML_Reader.GetLevelOfAttackProbability_List(); 
		
		//Чтение списка "Уровня риска" из файла	(см. класс ReadXMLFile)
		RiskLevel[] lvl_R_List = XML_Reader.GetRiskLevel_List(); 
		
		//Создаем объект класса Calculation для последующиего нахождения Уровня риска
		Calculation calculation = new Calculation(lvl_D_List, lvl_P_List, lvl_R_List);
	
		//Создание формы
		GUI app = new GUI(calculation);
		app.setVisible(true);
		
	
		
		return;
	}
	
}

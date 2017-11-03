package ru.ipoint.karpov.RiskLevelCalculation_Maven;
 
//import LevelOfAttackProbability;
//import LevelOfDamage;
//import ReadXMLFile;
//import RiskLevel;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



//Класс «ReadXMLFile»
//предназначен для работы с XML файлом "TableLevelRisk.xml" (файл находится в корне проекта)
//чтение файла проиходит с помощью средства (входит в стандартную JDK) - DOM — Document Object Model


public class ReadXMLFile
{
	private static String FILE_NAME;		//имя файла
	
	private static LevelOfDamage[] lvl_D_List;				//массив для хранения уровней ущерба
	private static LevelOfAttackProbability[] lvl_P_List;	//массив для хранения уровней вероятности
	private static RiskLevel[] lvl_R_List;	//массив для хранения уровней вероятности
	
	private Document doc; //объект Document для нашего XML-файла
	
	public ReadXMLFile(String FILE_NAME_)
	{
		try {
			
			FILE_NAME = FILE_NAME_;
			 
          // Строим объектную модель исходного XML файла
          final File xmlFile = new File(System.getProperty("user.dir")   + File.separator + FILE_NAME);
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder db = dbf.newDocumentBuilder();
           doc = db.parse(xmlFile);

          // Выполнять нормализацию не обязательно, но рекомендуется
          doc.getDocumentElement().normalize();                                 
          
      }
		//обработка возможного исключения при парсинге xml файла
		catch (ParserConfigurationException | SAXException   | IOException ex)
		{
          Logger.getLogger(ReadXMLFile.class.getName())
                  .log(Level.SEVERE, null, ex);
      }

	}
	
	// метод возврата массива уровней ущерба
	public LevelOfDamage[] GetLevelOfDamage_List()
	{
		//Чтение "Уровня ущерба" из файла	(см. метод ниже)
        Get_LevelOfDamage();
        
		return lvl_D_List;
	}
	
	// метод возврата массива уровней вероятности
	public LevelOfAttackProbability[] GetLevelOfAttackProbability_List()
	{
     	//Чтение "Уровня вероятности проведения атаки" из файла		(см. метод ниже)
        Get_LevelOfAttackProbability(); 
        
		return lvl_P_List;
	}
	
	// метод возврата массива уровней вероятности
		public RiskLevel[] GetRiskLevel_List()
		{
			Get_RiskLevel();
			return lvl_R_List;
		}
	
	//Метод чтения Уровня ущерба из файла
	private void Get_LevelOfDamage( )
	{		
		// Получаем все узлы с именем "LevelOfDamage" из файла
      NodeList nodeList = doc.getElementsByTagName("LevelOfDamage");

      int size = nodeList.getLength();		//кол-во узлов с данным именем
      lvl_D_List = new LevelOfDamage [size];	//инициализация массива Уровней ущерба 

      for (int i = 0; i < nodeList.getLength(); i++) {
          // Выводим информацию по каждому из найденных элементов
          Node node = nodeList.item(i);
          
          if (Node.ELEMENT_NODE == node.getNodeType()) {
          
          	Element element = (Element) node;
          	//получение данных по соответствующим тегам из файла xml
          	String id = element.getElementsByTagName("id").item(0).getTextContent();
          	String Name = element.getElementsByTagName("Name").item(0).getTextContent();
          	String Description = element.getElementsByTagName("Description").item(0).getTextContent();
          	int Id = Integer.parseInt(id);
          	
          	//создаем объект класса Уровень ущерба и добавляем его в соответствующий массив
          	LevelOfDamage lvl_D = new LevelOfDamage(Id, Name, Description);
          	
          	lvl_D_List[i] = lvl_D;
          }
      }
	}
	
	//Метод чтения Уровня вероятности проведения атаки из файла
	private void Get_LevelOfAttackProbability( )
	{
		// Получаем все узлы с именем "LevelOfAttackProbability"
      NodeList nodeList = doc.getElementsByTagName("LevelOfAttackProbability");

      int size = nodeList.getLength();					//кол-во узлов с данным именем
      lvl_P_List = new LevelOfAttackProbability [size];	//инициализация массива Уровней вер-ти

      for (int i = 0; i < nodeList.getLength(); i++) {
          // Выводим информацию по каждому из найденных элементов
          Node node = nodeList.item(i);
          
          if (Node.ELEMENT_NODE == node.getNodeType()) {
          
          	Element element = (Element) node;
          	//получение данных по соответствующим тегам файла xml
          	String id = element.getElementsByTagName("id").item(0).getTextContent();
          	String Name = element.getElementsByTagName("Name").item(0).getTextContent();
          	String Description = element.getElementsByTagName("Description").item(0).getTextContent();
          	int Id = Integer.parseInt(id);
          	
          	//создаем объект класса Уровень вер-ти проведения атаки и добавляем его в соответствующий массив
          	LevelOfAttackProbability lvl_P = new LevelOfAttackProbability(Id, Name, Description);
          	
          	lvl_P_List[i] = lvl_P;
          }
      }
	}
	
	
	//Метод чтения Уровня риска из файла
		private void Get_RiskLevel( )
		{
			// Получаем все узлы с именем "LevelOfAttackProbability"
	      NodeList nodeList = doc.getElementsByTagName("LevelOfRisk");

	      int size = nodeList.getLength();					//кол-во узлов с данным именем
	      lvl_R_List = new RiskLevel [size];	//инициализация массива Уровней вер-ти

	      for (int i = 0; i < nodeList.getLength(); i++) {
	          // Выводим информацию по каждому из найденных элементов
	          Node node = nodeList.item(i);
	          
	          if (Node.ELEMENT_NODE == node.getNodeType()) {
	          
	          	Element element = (Element) node;
	          	//получение данных по соответствующим тегам файла xml
	          	String id = element.getElementsByTagName("id").item(0).getTextContent();
	          	String Name = element.getElementsByTagName("Name").item(0).getTextContent();
	          	String Description = element.getElementsByTagName("Description").item(0).getTextContent();
	          	int Id = Integer.parseInt(id);
	          	
	          	//создаем объект класса Уровень риска и добавляем его в соответствующий массив
	          	RiskLevel lvl_R = new RiskLevel(Id, Name, Description);
	          	
	          	lvl_R_List[i] = lvl_R;
	          }
	      }
		}
		
		
		//Метод чтения Уровня риска по идентификаторам УровняУщерба и УровняВероятности
		public int Get_RiskLevelByIds(int Damage_ID, int Probability_ID)
		{
							
			// Получаем все узлы с именем "LevelOfRisk"
	      NodeList nodeList = doc.getElementsByTagName("Level");

	      for (int i = 0; i < nodeList.getLength(); i++) {
	          // Выводим информацию по каждому из найденных элементов
	          Node node = nodeList.item(i);
	          
	          if (Node.ELEMENT_NODE == node.getNodeType()) {
	          
	          	Element element = (Element) node;
	          	//читаем IDs Уровня ущерба и Уровня вер-ти атаки	          		          		    
	          	String str_lvl_D_ID = element.getElementsByTagName("LvlOfDamage_ID").item(0).getTextContent();
	              int lvl_D_ID = Integer.parseInt(str_lvl_D_ID);
	              
	              String str_lvl_P_ID = element.getElementsByTagName("LvlOfAttackProbability_ID").item(0).getTextContent();
	              int lvl_P_ID = Integer.parseInt(str_lvl_P_ID);
	              
	              //если найдено соответствие ids LvlOfDamage и LvlOfAttackProbability, 
	              //то найден нужный объект уровня риска и возвращаем его
	          	if(Damage_ID == lvl_D_ID && Probability_ID == lvl_P_ID)
	          	{         	
	          		String id_R = element.getElementsByTagName("LvlOfRisk_ID").item(0).getTextContent();
	          		int Id_R = Integer.parseInt(id_R);
	          		
	          		return Id_R;
	          	}
	          	
	           }
	        }        
	      return 0;
		}
		
/*	
	//Метод чтения Уровня риска по идентификаторам УровняУщерба и УровняВероятности
	public RiskLevel Get_RiskLevel(int Damage_ID, int Probability_ID)
	{
		RiskLevel risk_Lvl = new RiskLevel();
			
		// Получаем все узлы с именем "LevelOfRisk"
      NodeList nodeList = doc.getElementsByTagName("LevelOfRisk");

      for (int i = 0; i < nodeList.getLength(); i++) {
          // Выводим информацию по каждому из найденных элементов
          Node node = nodeList.item(i);
          
          if (Node.ELEMENT_NODE == node.getNodeType()) {
          
          	Element element = (Element) node;
          	//читаем данные уровня риска
          	String id = element.getElementsByTagName("id").item(0).getTextContent();
          	String Name = element.getElementsByTagName("Name").item(0).getTextContent();
          	String Description = element.getElementsByTagName("Description").item(0).getTextContent();
    
          	String str_lvl_D_ID = element.getElementsByTagName("LvlOfDamage").item(0).getTextContent();
              int lvl_D_ID = Integer.parseInt(str_lvl_D_ID);
              
              String str_lvl_P_ID = element.getElementsByTagName("LvlOfAttackProbability").item(0).getTextContent();
              int lvl_P_ID = Integer.parseInt(str_lvl_P_ID);
              
              //если найдено соответствие ids LvlOfDamage и LvlOfAttackProbability, 
              //то найден нужный объект уровня риска и возвращаем его
          	if(Damage_ID == lvl_D_ID && Probability_ID == lvl_P_ID)
          	{         	
          		int Id = Integer.parseInt(id);
          		risk_Lvl = new RiskLevel(Id, Name, Description);
          		
          		return risk_Lvl;
          	}
          	
           }
        }        
      return risk_Lvl;
	}
	

	
	
	
	//Поиск объекта Уровня ущерба по его имени	(не чувтсвителен к регистру)
	public static LevelOfDamage Search_LevelOfDamage(String str_lvl_damage)
	{
		for(int i=0; i < lvl_D_List.length; i++)
		{
			if(str_lvl_damage.equalsIgnoreCase(lvl_D_List[i].getName()))		//сравнение строк без учета регистра
			{
				return lvl_D_List[i];
			}
		}
		
		LevelOfDamage lvl_damage = new LevelOfDamage();
		return lvl_damage;
	}
	
	//Поиск объекта Уровня вероятности проведения атаки по его имени (не чувтсвителен к регистру)
	public static LevelOfAttackProbability Search_LevelOfAttackProbability(String str_lvl_probability)
	{
		for(int i=0; i < lvl_P_List.length; i++)
		{			
			if(str_lvl_probability.equalsIgnoreCase(lvl_P_List[i].getName()))		//сравнение строк без учета регистра
			{
				return lvl_P_List[i];
			}
		}
		LevelOfAttackProbability lvl_probability = new LevelOfAttackProbability();
		return lvl_probability;
	}
*/	
	
}

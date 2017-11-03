//package ru.j4web.examples.java.xml;
 
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


//����� �ReadXMLFile�
// ������������ ��� ������ � XML ������ "TableLevelRisk.xml" (���� ��������� � ����� �������)
//������ ����� ��������� � ������� �������� (������ � ����������� JDK) - DOM � Document Object Model


public class ReadXMLFile
{
	private static final String FILE_NAME = "TableLevelRisk.xml";	//��� �����
	
	private static LevelOfDamage[] lvl_D_List;				//������ ��� �������� ������� ������
	private static LevelOfAttackProbability[] lvl_P_List;	//������ ��� �������� ������� �����������
	
	private Document doc; //������ Document ��� ������ XML-�����
	
	public ReadXMLFile()
	{
		try {
			 
            // ������ ��������� ������ ��������� XML �����
            final File xmlFile = new File(System.getProperty("user.dir")   + File.separator + FILE_NAME);
             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
             doc = db.parse(xmlFile);
 
            // ��������� ������������ �� �����������, �� �������������
            doc.getDocumentElement().normalize();

            //������ "������ ������" �� �����	(��. ����� ����)
            Get_LevelOfDamage();
            
         	//������ "������ ����������� ���������� �����" �� �����		(��. ����� ����)
            Get_LevelOfAttackProbability();                        
            
        }
		//��������� ���������� ���������� ��� �������� xml �����
		catch (ParserConfigurationException | SAXException   | IOException ex)
		{
            Logger.getLogger(ReadXMLFile.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
 
	}
	
	// ����� �������� ������� ������� ������
	public LevelOfDamage[] GetLevelOfDamage()
	{
		return lvl_D_List;
	}
	
	// ����� �������� ������� ������� �����������
	public LevelOfAttackProbability[] GetLevelOfAttackProbability()
	{
		return lvl_P_List;
	}
	
	//����� ������ ������ ������ �� �����
	private void Get_LevelOfDamage( )
	{		
		// �������� ��� ���� � ������ "LevelOfDamage" �� �����
        NodeList nodeList = doc.getElementsByTagName("LevelOfDamage");

        int size = nodeList.getLength();		//���-�� ����� � ������ ������
        lvl_D_List = new LevelOfDamage [size];	//������������� ������� ������� ������ 

        for (int i = 0; i < nodeList.getLength(); i++) {
            // ������� ���������� �� ������� �� ��������� ���������
            Node node = nodeList.item(i);
            
            if (Node.ELEMENT_NODE == node.getNodeType()) {
            
            	Element element = (Element) node;
            	//��������� ������ �� ��������������� ����� �� ����� xml
            	String id = element.getElementsByTagName("id").item(0).getTextContent();
            	String Name = element.getElementsByTagName("Name").item(0).getTextContent();
            	String Description = element.getElementsByTagName("Description").item(0).getTextContent();
            	int Id = Integer.parseInt(id);
            	
            	//������� ������ ������ ������� ������ � ��������� ��� � ��������������� ������
            	LevelOfDamage lvl_D = new LevelOfDamage(Id, Name, Description);
            	
            	lvl_D_List[i] = lvl_D;
            }
        }
	}
	
	//����� ������ ������ ����������� ���������� ����� �� �����
	private void Get_LevelOfAttackProbability( )
	{
		// �������� ��� ���� � ������ "LevelOfAttackProbability"
        NodeList nodeList = doc.getElementsByTagName("LevelOfAttackProbability");

        int size = nodeList.getLength();					//���-�� ����� � ������ ������
        lvl_P_List = new LevelOfAttackProbability [size];	//������������� ������� ������� ���-��

        for (int i = 0; i < nodeList.getLength(); i++) {
            // ������� ���������� �� ������� �� ��������� ���������
            Node node = nodeList.item(i);
            
            if (Node.ELEMENT_NODE == node.getNodeType()) {
            
            	Element element = (Element) node;
            	//��������� ������ �� ��������������� ����� ����� xml
            	String id = element.getElementsByTagName("id").item(0).getTextContent();
            	String Name = element.getElementsByTagName("Name").item(0).getTextContent();
            	String Description = element.getElementsByTagName("Description").item(0).getTextContent();
            	int Id = Integer.parseInt(id);
            	
            	//������� ������ ������ ������� ���-�� ���������� ����� � ��������� ��� � ��������������� ������
            	LevelOfAttackProbability lvl_P = new LevelOfAttackProbability(Id, Name, Description);
            	
            	lvl_P_List[i] = lvl_P;
            }
        }
	}
	
	
	//����� ������ ������ ����� �� ��������������� ������������ � �����������������
	public RiskLevel Get_RiskLevel(int Damage_ID, int Probability_ID)
	{
		RiskLevel risk_Lvl = new RiskLevel();
			
		// �������� ��� ���� � ������ "LevelOfRisk"
        NodeList nodeList = doc.getElementsByTagName("LevelOfRisk");

        for (int i = 0; i < nodeList.getLength(); i++) {
            // ������� ���������� �� ������� �� ��������� ���������
            Node node = nodeList.item(i);
            
            if (Node.ELEMENT_NODE == node.getNodeType()) {
            
            	Element element = (Element) node;
            	//������ ������ ������ �����
            	String id = element.getElementsByTagName("id").item(0).getTextContent();
            	String Name = element.getElementsByTagName("Name").item(0).getTextContent();
            	String Description = element.getElementsByTagName("Description").item(0).getTextContent();
      
            	String str_lvl_D_ID = element.getElementsByTagName("LvlOfDamage").item(0).getTextContent();
                int lvl_D_ID = Integer.parseInt(str_lvl_D_ID);
                
                String str_lvl_P_ID = element.getElementsByTagName("LvlOfAttackProbability").item(0).getTextContent();
                int lvl_P_ID = Integer.parseInt(str_lvl_P_ID);
                
                //���� ������� ������������ ids LvlOfDamage � LvlOfAttackProbability, 
                //�� ������ ������ ������ ������ ����� � ���������� ���
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
	

	
	
	
	//����� ������� ������ ������ �� ��� �����	(�� ������������ � ��������)
	public static LevelOfDamage Search_LevelOfDamage(String str_lvl_damage)
	{
		for(int i=0; i < lvl_D_List.length; i++)
		{
			if(str_lvl_damage.equalsIgnoreCase(lvl_D_List[i].getName()))		//��������� ����� ��� ����� ��������
			{
				return lvl_D_List[i];
			}
		}
		
		LevelOfDamage lvl_damage = new LevelOfDamage();
		return lvl_damage;
	}
	
	//����� ������� ������ ����������� ���������� ����� �� ��� ����� (�� ������������ � ��������)
	public static LevelOfAttackProbability Search_LevelOfAttackProbability(String str_lvl_probability)
	{
		for(int i=0; i < lvl_P_List.length; i++)
		{			
			if(str_lvl_probability.equalsIgnoreCase(lvl_P_List[i].getName()))		//��������� ����� ��� ����� ��������
			{
				return lvl_P_List[i];
			}
		}
		LevelOfAttackProbability lvl_probability = new LevelOfAttackProbability();
		return lvl_probability;
	}
	
	
}

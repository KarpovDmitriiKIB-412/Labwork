import java.awt.*;


public class Main {

	
	public static void main(String[] args) 
	{
		//Чтение xml файла
		ReadXMLFile XML_Reader = new ReadXMLFile();
	
		//Создание формы
		GUI app = new GUI(XML_Reader);
		app.setVisible(true);
		
	
		
		return;
	}
	
}

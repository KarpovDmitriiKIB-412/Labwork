import java.awt.*;


public class Main {

	
	public static void main(String[] args) 
	{
		//������ xml �����
		ReadXMLFile XML_Reader = new ReadXMLFile();
	
		//�������� �����
		GUI app = new GUI(XML_Reader);
		app.setVisible(true);
		
	
		
		return;
	}
	
}

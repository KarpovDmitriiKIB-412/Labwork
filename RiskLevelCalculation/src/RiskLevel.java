import java.awt.*;
import java.awt.event.*;
import java.lang.*;


//Класс «Уровень риска информационной безопасности»

public class RiskLevel {
	private int Id;
	private String Name;
	private String Description;
	
	public RiskLevel()
	{
		Id = 0;
		Name = " ";
		Description = " ";
	}
	
	public RiskLevel(int id, String name, String description)
	{
		Id = id;
		Name = name;
		Description = description;
	}
	
	
	public void setId(String id)
	{
		try {
            Id = Integer.parseInt(id);
        } 
		catch (Exception e) {
        	System.out.println("Ошибка присвоения Id");
        }
	}
	
	public void setId(int id)
	{
		Id = id;
	}
	
	public void setName(String name)
	{
		Name  = name;
	}	
	
	public void setDescription(String description)
	{
		Description  = description;
	}
	
	public int getId()
	{
		return Id;
	}
	
	public String getName()
	{
		return Name;
	}

	public String getDescription()
	{
		return   Description;
	}
	
}

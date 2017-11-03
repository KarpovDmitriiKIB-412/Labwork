package ru.ipoint.karpov.RiskLevelCalculation_Maven;

public class Calculation {

	public static LevelOfDamage[] lvl_D_List;				//массив для хранения уровней ущерба
	public static LevelOfAttackProbability[] lvl_P_List;	//массив для хранения уровней вероятности
	public static RiskLevel[] lvl_R_List;	//массив для хранения уровней вероятности
		
	Calculation(LevelOfDamage[] lvl_D_List_, LevelOfAttackProbability[] lvl_P_List_, RiskLevel[] lvl_R_List_)
	{		
		lvl_D_List = lvl_D_List_;
		lvl_P_List = lvl_P_List_;
		lvl_R_List = lvl_R_List_;		
	}
	
	//Метод чтения Уровня риска id
		public RiskLevel Search_LevelOfRisk(int ID)
		{				

	      for (int i = 0; i < lvl_R_List.length; i++) 
	      {
	          	if(lvl_R_List[i].getId() == ID)
	          	{          			          		
	          		return lvl_R_List[i];
	          	}           
	       }     
	      RiskLevel lvl_risk = new RiskLevel();
	      return lvl_risk;
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
}

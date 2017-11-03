package ru.ipoint.karpov.RiskLevelCalculation_Maven;
/*
import Dialog;
import LevelOfAttackProbability;
import LevelOfDamage;
import ReadXMLFile;
import RiskLevel;
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Oct 21 17:38:44 GMT+03:00 2017
 */



/**
 * @author Dmitrii Karpov
 */
public class GUI extends JFrame {
	

//	private ReadXMLFile XML_Reader;
	private Calculation calculation;
	
	public GUI(Calculation cal) 	{

		initComponents();
		
		//получение ссылка на объект хранящий прочитанные данные из xml файла
		calculation = cal;
		

		
		//void метод Set Visible False для объектов textPain, пока они не понадобятся (см. метод ниже)
		SetVisibleFalse();
	}

	//Обработка события нажатия на кнопку
	private void button1ActionPerformed(ActionEvent e) {
		
		//void метод Set Visible False для объектов textPain; при каждом нажатии кнопки они "исчезают" и появляются когда нужны
		SetVisibleFalse();
		
		String str_lvl_d = textField1.getText();	//получения уровня ущерба
		String str_lvl_p = textField2.getText();	//получения уровня вероятности
		
		
		//Поиск объектов Уровня ущерба и Уровня вероятности атаки по их именам
		LevelOfDamage lvl_damage = calculation.Search_LevelOfDamage(str_lvl_d);
		LevelOfAttackProbability lvl_probability = calculation.Search_LevelOfAttackProbability(str_lvl_p);
				
		//Обработка данных полученных из формы
		//получение объекта Уровень риска по этим данным
		//сначала читаем из XML файла ID Уровня риска, соответсвующего параметрам уровня ущерба и уровня вер-ти атаки		
		ReadXMLFile ReadXML = new ReadXMLFile("TableLevelRisk.xml");
		int ID_R = ReadXML.Get_RiskLevelByIds(lvl_damage.getId(), lvl_probability.getId());
		//далее поиск по полученному ID Уровня риска его объект
		RiskLevel lvl_risc = calculation.Search_LevelOfRisk(ID_R);

		//Вывод уровня риска (см. метод ниже)
		SetRisc(lvl_risc);
		
		//а вот и textPain`s. в них выводится описание объектов (если таковые существуют и найдены) нулевого id у реальных (непустых) объектов быть не должно.
		if(lvl_damage.getId() != 0)
		{
			textPane1.setVisible(true);
			textPane1.setText(lvl_damage.getDescription());
		}
		
		if(lvl_probability.getId() != 0)
		{
			textPane2.setVisible(true);		
			textPane2.setText(lvl_probability.getDescription());
		}
		

	}

	
	//Вывод уровня риска
	public void SetRisc(RiskLevel lvl_risc)
	{
		if(lvl_risc.getId() == 0)
		{
			textField3.setText("Совпадений не найдено");
			textPane3.setVisible(true);
			textPane3.setText("Возможно неправильно введены данные в полях \"Уровень риска\" и \"Уровень вероятности проведения атаки\".\n"
					+ "Посмотрите в Справке правильность написания." );
			return;
		}
		textField3.setText(lvl_risc.getName());
		textPane3.setVisible(true);
		String Description = lvl_risc.getDescription();
		if(Description.equals(" ") || Description.equals(""))
		{
			textPane3.setText("Пусто. Нет описания объекта");
		}
		else	textPane3.setText(Description);
	}

	
	//обработка нажатия на элемент главного меню "Справка" -> "Уровни ущерба и вероятности атаки"
	//для просмотра списка уровней прочитанных из файла и последующего правильного написания их в полях ввода (поиск уровней не чувтсвителен к регистру, но очевидно, что чувствителен к ошибкам в написании слов) 
	private void menuItem1ActionPerformed(ActionEvent e) {
	
		//В качестве параметров передаются: список уровней ущерба и список уровней вер-ти атаки
		Dialog dg = new Dialog(calculation.lvl_D_List, calculation.lvl_P_List);
		dg.setVisible(true);
	}

	
	//void метод Set Visible False для объектов textPain; "прячет" их, пока они не понадобятся
	void SetVisibleFalse()
	{
		textPane1.setVisible(false);
		textPane2.setVisible(false);
		textPane3.setVisible(false);
	}






	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Dmitrii Karpov
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		label1 = new JLabel();
		textField1 = new JTextField();
		textPane1 = new JTextPane();
		label2 = new JLabel();
		textField2 = new JTextField();
		textPane2 = new JTextPane();
		button1 = new JButton();
		label4 = new JLabel();
		textField3 = new JTextField();
		textPane3 = new JTextPane();

		//======== this ========
		setTitle("\u041e\u043f\u0440\u0435\u0434\u0435\u043b\u0435\u043d\u0438\u0435 \u0443\u0440\u043e\u0432\u043d\u044f \u0440\u0438\u0441\u043a\u0430 \u0418\u0411");
		Container contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("\u0421\u043f\u0440\u0430\u0432\u043a\u0430");

				//---- menuItem1 ----
				menuItem1.setText("\u0423\u0440\u043e\u0432\u043d\u0438 \u0443\u0449\u0435\u0440\u0431\u0430 \u0438 \u0432\u0435\u0440\u043e\u044f\u0442\u043d\u043e\u0441\u0442\u0438 \u0430\u0442\u0430\u043a\u0438");
				menuItem1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menuItem1ActionPerformed(e);
					}
				});
				menu1.add(menuItem1);
			}
			menuBar1.add(menu1);
		}
		setJMenuBar(menuBar1);

		//---- label1 ----
		label1.setText("\u0423\u0440\u043e\u0432\u0435\u043d\u044c \u0443\u0449\u0435\u0440\u0431\u0430:");
		contentPane.add(label1, "cell 0 5");
		contentPane.add(textField1, "cell 1 5 8 1");

		//---- textPane1 ----
		textPane1.setEditable(false);
		contentPane.add(textPane1, "cell 0 6 9 1");

		//---- label2 ----
		label2.setText("\u0423\u0440\u043e\u0432\u0435\u043d\u044c \u0432\u0435\u0440\u043e\u044f\u0442\u043d\u043e\u0441\u0442\u0438 \u0430\u0442\u0430\u043a\u0438:");
		contentPane.add(label2, "cell 0 9");
		contentPane.add(textField2, "cell 1 9 8 1");

		//---- textPane2 ----
		textPane2.setEditable(false);
		contentPane.add(textPane2, "cell 0 10 9 1");

		//---- button1 ----
		button1.setText("Calculation");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button1ActionPerformed(e);
			}
		});
		contentPane.add(button1, "cell 6 13");

		//---- label4 ----
		label4.setText("\u0423\u0440\u043e\u0432\u0435\u043d\u044c \u0440\u0438\u0441\u043a\u0430:");
		contentPane.add(label4, "cell 0 16");
		contentPane.add(textField3, "cell 1 16 8 1");

		//---- textPane3 ----
		textPane3.setEditable(false);
		contentPane.add(textPane3, "cell 0 17 9 1");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Dmitrii Karpov
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JLabel label1;
	private JTextField textField1;
	private JTextPane textPane1;
	private JLabel label2;
	private JTextField textField2;
	private JTextPane textPane2;
	private JButton button1;
	private JLabel label4;
	private JTextField textField3;
	private JTextPane textPane3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}

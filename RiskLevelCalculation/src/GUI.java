import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import info.clearthought.layout.*;

import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Oct 21 17:38:44 GMT+03:00 2017
 */



/**
 * @author Dmitrii Karpov
 */
public class GUI extends JFrame {
	

	private ReadXMLFile XML_Reader;
	
	public GUI(ReadXMLFile XML_Reader_file) 	{

		initComponents();
		
		//��������� ������ �� ������ �������� ����������� ������ �� xml �����
		XML_Reader = XML_Reader_file;
		
		//void ����� Set Visible False ��� �������� textPain, ���� ��� �� ����������� (��. ����� ����)
		SetVisibleFalse();
	}

	//��������� ������� ������� �� ������
	private void button1ActionPerformed(ActionEvent e) {
		
		//void ����� Set Visible False ��� �������� textPain; ��� ������ ������� ������ ��� "��������" � ���������� ����� �����
		SetVisibleFalse();
		
		String str_lvl_d = textField1.getText();	//��������� ������ ������
		String str_lvl_p = textField2.getText();	//��������� ������ �����������
		
		
		//����� �������� ������ ������ � ������ ����������� ����� �� �� ������
		LevelOfDamage lvl_damage = XML_Reader.Search_LevelOfDamage(str_lvl_d);
		LevelOfAttackProbability lvl_probability = XML_Reader.Search_LevelOfAttackProbability(str_lvl_p);
				
		//��������� ������ ���������� �� ����� � ��������� ������� ������� ����� �� ���� ������
		RiskLevel lvl_risc = XML_Reader.Get_RiskLevel(lvl_damage.getId(), lvl_probability.getId());

		//����� ������ ����� (��. ����� ����)
		SetRisc(lvl_risc);
		
		//� ��� � textPain`s. � ��� ��������� �������� �������� (���� ������� ���������� � �������) �������� id � �������� (��������) �������� ���� �� ������.
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

	
	//����� ������ �����
	public void SetRisc(RiskLevel lvl_risc)
	{
		if(lvl_risc.getId() == 0)
		{
			textField3.setText("���������� �� �������");
			textPane3.setVisible(true);
			textPane3.setText("�������� ����������� ������� ������ � ����� \"������� �����\" � \"������� ����������� ���������� �����\".\n"
					+ "���������� � ������� ������������ ���������." );
			return;
		}
		textField3.setText(lvl_risc.getName());
		textPane3.setVisible(true);
		String Description = lvl_risc.getDescription();
		if(Description.equals(" ") || Description.equals(""))
		{
			textPane3.setText("�����. ��� �������� �������");
		}
		else	textPane3.setText(Description);
	}

	
	//��������� ������� �� ������� �������� ���� "�������" -> "������ ������ � ����������� �����"
	//��� ��������� ������ ������� ����������� �� ����� � ������������ ����������� ��������� �� � ����� ����� (����� ������� �� ������������ � ��������, �� ��������, ��� ������������ � ������� � ��������� ����) 
	private void menuItem1ActionPerformed(ActionEvent e) {
		
		LevelOfDamage[] lvl_D_List = XML_Reader.GetLevelOfDamage();
		LevelOfAttackProbability[] lvl_P_List = XML_Reader.GetLevelOfAttackProbability();
		
		Dialog dg = new Dialog(lvl_D_List, lvl_P_List);
		dg.setVisible(true);
	}

	
	//void ����� Set Visible False ��� �������� textPain; "������" ��, ���� ��� �� �����������
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

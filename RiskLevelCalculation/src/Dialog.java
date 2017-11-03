import java.awt.*;

import javax.swing.*;
//import org.jdesktop.swingx.*;
/*
 * Created by JFormDesigner on Tue Oct 31 22:38:29 GMT+03:00 2017
 */



/**
 * @author Dmitrii Karpov
 */
public class Dialog extends JFrame {
	public Dialog(LevelOfDamage[] lvl_D_List, LevelOfAttackProbability[] lvl_P_List) {
		initComponents();
		
		String LD = " ";
		LD += "Качественная шкала оценки уровня ущерба:\n";
		LD += "____________________________________________________\n";
		LD += "\t" + "Id" + "\t" + "Уровень" + "\n\n";
		for(int i=0; i< lvl_D_List.length; i++)
		{
			LD += "\t" + lvl_D_List[i].getId();
			LD += "\t" + lvl_D_List[i].getName();
			LD += "\n";
		}
		LD += "\n\n";
		
		String LP = " ";
		LP += "Качественная шкала оценки вероятности провещения атаки:\n";
		LP += "__________________________________________________________\n";
		LP += "\t" + "Id" + "\t" + "Уровень" + "\n\n";
		for(int i=0; i< lvl_P_List.length; i++)
		{
			LP += "\t" + lvl_P_List[i].getId();
			LP += "\t" + lvl_P_List[i].getName();
			LP += "\n";
		}
		
		textPane1.setText(LD + LP);
		
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Dmitrii Karpov
		textPane1 = new JTextPane();

		//======== this ========
		setTitle("\u0421\u043f\u0440\u0430\u0432\u043a\u0430");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout());
		contentPane.add(textPane1);
		setSize(455, 395);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Dmitrii Karpov
	private JTextPane textPane1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}

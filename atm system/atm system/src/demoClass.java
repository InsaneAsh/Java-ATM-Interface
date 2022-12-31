import javax.swing.*;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.time.format.*;
import java.time.LocalDateTime;
public class demoClass extends JFrame{
	

	/*
	 * demoClass(){ JLabel jl = new JLabel("My label Ashutosh Rathore");
	 * jl.setBounds(240,30,50,20); add(jl);
	 * 
	 * //JOptionPane.showMessageDialog(frame, "this is my first Dialog box"); Dialog
	 * d = new Dialog(frame, "Dialog example", true); d.setLayout(new FlowLayout());
	 * 
	 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	 * LocalDateTime now = LocalDateTime.now(); String timem = dtf.format(now);
	 * 
	 * JButton jb1 = new JButton(timem); jb1.setBounds(500,500,200,300); d.add(jb1);
	 * 
	 * d.setVisible(true); d.setSize(600,600);
	 * //d.setDefaultOperationClose(EXIT_ON_CLOSE); add(d);
	 * 
	 * setLayout(null); setVisible(true);
	 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setBounds(500,300,1200,600);
	 * 
	 * 
	 * }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		 LocalDateTime now = LocalDateTime.now(); 
		 String timem = dtf.format(now);
		 System.out.println(timem);
		
	}

}

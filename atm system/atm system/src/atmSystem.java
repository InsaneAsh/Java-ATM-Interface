import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class atmSystem extends JFrame{
	JLabel jlName, jlPin, jlDisplay, jlWrong;
	JButton jbOkay, jbCancel,jbBalance, jbTransactionHistory, jbWithdraw, jbDeposit, jbQuit;
	JTextField jtfName, jtfPin, jtfDisplay;
	JFrame frame;
	JMenu menu;
	JMenuItem addAccount, back;
	double balance = 100;
	String history = "";
	String transaction = "<html>";
	public static int id = 0;
	static int counter = 0;
	static newAccount newArray[] = new newAccount[10];
	atmSystem(){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		JMenuBar menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		addAccount = new JMenuItem("Add Account");
		addAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,"Do you want to add new Account");
				JDialog jd = new JDialog(frame, "Add Account");
				JLabel name = new JLabel("Enter Name :-");
				name.setBounds(40,20,120,20);
				jd.add(name);
				
				JTextField jtfName = new JTextField();
				jtfName.setBounds(140,20,150,20);
				jd.add(jtfName);
				
				JLabel jlPin = new JLabel("Enter Pin :- ");
				jlPin.setBounds(40,60,120,20);
				jd.add(jlPin);
				
				JTextField jtfPin = new JTextField();
				jtfPin.setBounds(140,60,150,20);
				jd.add(jtfPin);
				
				JButton jbOkay = new JButton("Create");
				jbOkay.setBounds(40,120,120,20);
				jd.add(jbOkay);
				jbOkay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String name = jtfName.getText();
						int pin = Integer.parseInt(jtfPin.getText());
						newAccount nA = new newAccount();
						nA.setName(name);
						nA.setPin(pin);
						newArray[atmSystem.counter] = nA;
						atmSystem.counter++;
						JOptionPane.showMessageDialog(null,"succesfully created");
						
					}
				});
				
				JButton jbCancel = new JButton("Cancel");
				jbCancel.setBounds(160,120,120,20);
				jd.add(jbCancel);
				jbCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(ABORT);
					}
				});
				
				jd.setLayout(null);
				jd.setBounds(600,500,400,400);
				jd.setVisible(true);
			}
		});
		back =  new JMenuItem("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfDisplay.setEnabled(false);
				jbTransactionHistory.setEnabled(false);
				jbWithdraw.setEnabled(false);
				jbDeposit.setEnabled(false);
				jbBalance.setEnabled(false);
				jbQuit.setEnabled(false);
				jbOkay.setEnabled(true);
				jbCancel.setEnabled(true);
				jtfDisplay.setText("");
				jtfPin.setText("");
				jtfName.setEnabled(true);
				jtfPin.setEnabled(true);
			}
		});
		
		menu.add(addAccount);
		menu.add(back);
		menuBar.add(menu);
		
		jlWrong = new JLabel();
		jlWrong.setBounds(50,180,500,100);
		jlWrong.setFont(new Font("Verdana", Font.PLAIN, 18));
		jlWrong.setForeground(Color.BLACK);
		add(jlWrong);
		
		jlName = new JLabel("Enter your Name :-");
		jlName.setBounds(10,20,190,60);
		//jlName.setBackground(Color.RED);
		jlName.setForeground(Color.BLACK);
		jlName.setFont(new Font("Verdana",Font.PLAIN,18));
		add(jlName);
		
		jtfName = new JTextField();
		jtfName.setBounds(200,40,200,30);
		add(jtfName);
		
		
		jlPin = new JLabel("Enter your PIN :-");
		jlPin.setForeground(Color.BLACK);
		jlPin.setFont(new Font("Verdana", Font.PLAIN, 18));
		jlPin.setBounds(10,80,190,60);
		add(jlPin);
		
		jtfPin = new JTextField();
		jtfPin.setBounds(200,100,200,30);
		add(jtfPin);
		
		jbCancel = new JButton("Cancel");
		jbCancel.setBounds(230,160,80,30);
		add(jbCancel);
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		
		jlDisplay = new JLabel("Welcome ");
		jlDisplay.setFont(new Font("Verdana", Font.PLAIN, 18));
		jlDisplay.setForeground(Color.BLACK);
		jlDisplay.setBounds(720,10,250,30);
		add(jlDisplay);
		
		jbOkay = new JButton("Submit");
		jbOkay.setBounds(90,160,80,30);
		add(jbOkay);
		jbOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String)jtfName.getText().trim();
				System.out.println(name);
				int pin = Integer.parseInt(jtfPin.getText());
				boolean flag = checkNameAndPin(name, pin);
				if(flag == true) {
					jlDisplay.setText("Welcome " + name);
					jtfDisplay.setEnabled(true);
					jbTransactionHistory.setEnabled(true);
					jbWithdraw.setEnabled(true);
					jbDeposit.setEnabled(true);
					jbBalance.setEnabled(true);
					jbQuit.setEnabled(true);
					jbOkay.setEnabled(false);
					jbCancel.setEnabled(false);
					jtfName.setText("");
					jtfPin.setText("");
					jtfName.setEnabled(false);
					jtfPin.setEnabled(false);
				}
				else {
					jlWrong.setText("**You entered wrong ID or Pin");
				}	
			}
		});
		
		jtfDisplay = new JTextField();
		jtfDisplay.setBounds(600,50,500,70);
		jtfDisplay.setEnabled(false);
		add(jtfDisplay);
		
		jbBalance = new JButton("Balance");
		jbBalance.setBounds(600, 190, 200, 30);
		jbBalance.setEnabled(false);
		add(jbBalance);
		jbBalance.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jtfDisplay.setText("Your current balance is "+balance);
				history += "<div>Your balance is " + balance + "Time :- " + dtf.format(now) +"</div><div></div>"; 
				transaction += history ;
			}
		});
		
		jbDeposit = new JButton("Deposit");
		jbDeposit.setBounds(900, 190, 200, 30);
		jbDeposit.setEnabled(false);
		add(jbDeposit);
		jbDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double deposit = Double.parseDouble(JOptionPane.showInputDialog("Enter your amoount you want to deposit"));
				balance =  deposit + balance;
				jtfDisplay.setText("Your current balance is " + balance);
				history += "<div>You deposited balance is " + deposit + "Time :- " + dtf.format(now) + "</div><div></div>"; 
				transaction +=  history;
			}
		});
		
		jbWithdraw = new JButton("Withdraw");
		jbWithdraw.setBounds(600, 250, 200, 30);
		jbWithdraw.setEnabled(false);
		add(jbWithdraw);
		jbWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double newBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount which you want to withdraw "));
				if(newBalance  > balance) {
					JOptionPane.showMessageDialog(null, "Sorry, your current balance is less than your current balance");
				}
				else {
					balance -= newBalance;
					history += "<div>You withdraw " + newBalance + "Time :- "+ dtf.format(now) + "</div><div></div>"; 
					transaction += history;
					jtfDisplay.setText("Your current amount is " + balance);
				}
			}
		});
		
		jbTransactionHistory = new JButton("Transaction History");
		jbTransactionHistory.setBounds(900, 250, 200,30);
		jbTransactionHistory.setEnabled(false);
		add(jbTransactionHistory);
		jbTransactionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog jdTH = new JDialog(frame, "Transaction History");
				JLabel jlHistory = new JLabel();
				jlHistory.setText(transaction);
				jlHistory.setBounds(10,20,500,500);
				jdTH.add(jlHistory);
				
				jdTH.setLayout(null);
				jdTH.setVisible(true);
				jdTH.setBounds(600,500,600,600);
			}
		});
		
		jbQuit = new JButton("Quit");
		jbQuit.setBounds(650, 350, 400, 30);
		jbQuit.setEnabled(false);
		add(jbQuit);
		jbQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		
		setJMenuBar(menuBar);
		getContentPane().setBackground(Color.getHSBColor(180,100,100));
		setTitle("Automated Tallor Machine");
		setLayout(null);
		setBounds(500,300,1200,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new atmSystem();
	}
	
	public static boolean checkNameAndPin(String name, int pin) {
		String objName;
		int objPin;
		if(name.equals("Ashutosh Rathore") && pin == 9084) {
			System.out.println("welcome ashutosh rathore");
			return true;
		}
		else {
			for(int i = 0;i<newArray.length;i++) {
				objName = newArray[i].getName();
				objPin = newArray[i].getPin();
				if(name.equals(objName) && pin == objPin) {
					return true;
				}
			}
		}
		return false;
	}
}


class newAccount{
	String name;
	int pin;
	
	public void setId() {
		atmSystem.id += 1; 
	}
	
	public int getId() {
		return atmSystem.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getName() {
		return this.name;
	}
	public int getPin() {
		return this.pin;
	}
}

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	JTextField resultField;
	JButton[] opButtons = new JButton[16];
	JButton clearButton = new JButton("Çå¿Õ");
	String buttonName[] = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", ".", "=", "/"};
		
	public MainFrame(){
		this.setTitle("¼ÆËãÆ÷");
		this.setBounds(200, 200, 300, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new FlowLayout());
		resultField = new JTextField(19);
		resultField.setHorizontalAlignment(JTextField.RIGHT);
		resultPanel.add(resultField);
		resultPanel.add(clearButton);
		this.add(resultPanel, BorderLayout.NORTH);
		
		JPanel operationPanel = new JPanel();
		operationPanel.setLayout(new GridLayout(4, 4));
		for (int i = 0; i < 16; i++){
			opButtons[i] = new JButton(buttonName[i]);
			operationPanel.add(opButtons[i]);
		}
		this.add(operationPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	class ButtonClick implements ActionListener{
		double number1, number2;
		String operate;
		String temp;
		String textFieldVal;
		
		public ButtonClick(){
			clearButton.addActionListener(this);
			for (int i = 0; i < 16; i++){
				opButtons[i].addActionListener(this);
			}
		}
		
		public void actionPerformed(ActionEvent e){
			temp = e.getActionCommand();
			System.out.println("Clicked " + temp);
			
			if (temp == "+" || temp == "-" || temp == "*" || temp == "/"){
				number1 = Double.valueOf(resultField.getText()).doubleValue();
				operate = temp;
				textFieldVal = "";
				String temp2;
				temp2 = e.getActionCommand();
				if (temp2 == "1" || temp2 == "2" || temp2 == "3" || temp2 == "4" || temp2 == "5" || temp2 == "." 
						|| temp2 == "6" || temp2 == "7" || temp2 == "8" || temp2 == "9" || temp2 == "0"){
					textFieldVal = textFieldVal + temp;
					resultField.setText(textFieldVal);
				}
			}
			
			if (temp == "1" || temp == "2" || temp == "3" || temp == "4" || temp == "5" || temp == "." 
					|| temp == "6" || temp == "7" || temp == "8" || temp == "9" || temp == "0"){
				textFieldVal = temp;
				resultField.setText(textFieldVal);
			}
			
			if (temp == "="){
				number2 = Double.valueOf(resultField.getText()).doubleValue();
				double result = 0;
				if (operate == "+"){
					result = number1 + number2;
					resultField.setText("" + result);
					System.out.println("result = " + result);
				}
				if (operate == "-"){
					result = number1 - number2;
					resultField.setText("" + result);
					System.out.println("result = " + result);
				}
				if (operate == "*"){
					result = number1 * number2;
					resultField.setText("" + result);
					System.out.println("result = " + result);
				}
				if (operate == "/"){
					result = number1 / number2;
					resultField.setText("" + result);
					System.out.println("result = " + result);
				}
				number1 = result;
				number2 = 0;
				operate = "";
				temp = "";
				textFieldVal = "";
			}
			
			if (temp == "Çå¿Õ"){
				number1 = 0;
				number2 = 0;
				operate = "";
				temp = "";
				textFieldVal = "";
				resultField.setText("");
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mainFrame = new MainFrame();
		MainFrame.ButtonClick buttonClick = mainFrame.new ButtonClick();
	}

}

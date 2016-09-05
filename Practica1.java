import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Practica1 extends JPanel implements ActionListener{
	private JLabel[] labels = new JLabel[5];
	private JTextField[] texts = new JTextField[5];
	private JLabel[] results = new JLabel[5];
	private JLabel[] languages = new JLabel[5];
	String[] descrip = new String[]{"String with even number of 1's.",
								  "String without a 1 followed by a 0.",
								  "String that ends with 1.",
								  "String without \"abab\".",
								  "String with even a's and three b's."};

	String[] lang = new String[]{"∑ = {0,1}",
								"∑ = {0,1}",
								"∑ = {0,1}",
								"∑ = {a,b}",
								"∑ = {a,b}"};

	private Timer t;
	
	
	public Practica1(){
		super();
		this.setPreferredSize(new Dimension(300, 500));
		
		for(int i=0; i<5; i++){
			this.labels[i] = new JLabel("Problem "+(i+1)+": "+descrip[i]);
			this.add(this.labels[i]);
			this.labels[i].setBounds(10, 90*i, 350, 20);
			
			this.languages[i] = new JLabel(lang[i]);
			this.add(this.languages[i]);
			this.languages[i].setBounds(75, 90*i+20, 100, 20);
			
			this.texts[i] = new JTextField();
			this.add(this.texts[i]);
			this.texts[i].setBounds(10, 90*i+45, 200, 20);
			this.texts[i].addActionListener(this);
			
			this.results[i] = new JLabel("");
			this.add(this.results[i]);
			this.results[i].setBounds(220, 90*i+45, 100, 20);
		}
		setLayout(null);
	}

	public boolean problem1(String s){
		int cont = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '1'){
				cont++;
			}
		}
		return (cont%2 == 0);
	}

	public boolean problem2(String s){
		boolean cero = false, uno = false;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '1'){
				uno = true;
			}
			else if(uno){
				if(s.charAt(i) == '0'){
					cero = true;
				}
			}
		}
		return !(cero && uno);
	}

	public boolean problem3(String s){
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '1'){
				return (i == s.length()-1);
			}
		}
		return false;
	}

	public boolean problem4(String s){
		for (int i=0; i<s.length()-3; i++) {
			if(s.substring(0, i+4).equals("abab")){
				return false;
			}
		}
		return true;
	}

	public boolean problem5(String s){
		int a = 0, b = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == 'a'){
				a++;
			}
			else if(s.charAt(i) == 'b'){
				b++;
			}
		}
		return (a%2==0 && b%3==0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.texts[0]){
			this.results[0].setText(this.problem1(this.texts[0].getText())+"");
			t = new Timer(500, new ActionListener(){public void actionPerformed(ActionEvent e){results[0].setText("");}});
		}
		else if(e.getSource() == this.texts[1]){
			this.results[1].setText(this.problem2(this.texts[1].getText())+"");
			t = new Timer(500, new ActionListener(){public void actionPerformed(ActionEvent e){results[1].setText("");}});
		}
		else if(e.getSource() == this.texts[2]){
			this.results[2].setText(this.problem3(this.texts[2].getText())+"");
			t = new Timer(500, new ActionListener(){public void actionPerformed(ActionEvent e){results[2].setText("");}});
		}
		else if(e.getSource() == this.texts[3]){
			this.results[3].setText(this.problem4(this.texts[3].getText())+"");
			t = new Timer(500, new ActionListener(){public void actionPerformed(ActionEvent e){results[3].setText("");}});
		}
		else{
			this.results[4].setText(this.problem5(this.texts[4].getText())+"");
			t = new Timer(500, new ActionListener(){public void actionPerformed(ActionEvent e){results[4].setText("");}});
		}
		t.setRepeats(false);
        t.start();
	}

}
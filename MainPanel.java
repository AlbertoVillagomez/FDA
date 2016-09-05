import java.awt.Dimension;
import javax.swing.JFrame;

public class MainPanel extends JFrame{
	private Practica1 p;
	
	public MainPanel(){
		super("AFD's");
		this.setPreferredSize(new Dimension(300, 500));
		this.setResizable(false);
		this.setLocation(200, 100);
		
		this.p = new Practica1();
		this.add(this.p);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainPanel();
	}
}
import javax.swing.JFrame;
import javax.swing.JPanel;
import listener.InstructionListener;
import ui.FireEmblePanel;


public class Main {
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		JPanel fireEmble = new FireEmblePanel();
		frame.getContentPane().add(fireEmble);
		frame.setLocation(50, 100);
		frame.setTitle("ÎÆÕÂÍâ´«");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		InstructionListener il = new InstructionListener(fireEmble);
		frame.addKeyListener(il);
		
	}
}

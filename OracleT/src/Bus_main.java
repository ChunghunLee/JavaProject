
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bus_main extends JPanel { 

	private JLabel label = new JLabel(); 
	 private ImageIcon icon;
	
	public Bus_main()
	{
		super();
		init();
	}
	private void init()
	{
		URL path = getClass().getResource("mainimg.png");
		icon = new ImageIcon(path);
		
		label.setIcon(icon);
		this.add(label);
		
	}
}

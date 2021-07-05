package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	ImageIcon icone;
	
	public View (String title) {
		super(title);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		this.icone = new ImageIcon("img/util/icon.jpeg");
		setIconImage(this.icone.getImage());
	}

}

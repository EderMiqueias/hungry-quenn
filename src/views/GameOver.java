package views;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOver extends View{
	private static final long serialVersionUID = 1L;
	JLabel backgroundLabel;
	
	TKey tkey;

	public GameOver() {
		super("Game Over");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		
		this.backgroundLabel = new JLabel(new ImageIcon("img/util/game_over.png"));
		this.backgroundLabel.setBounds(0, 0, this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight());
		
		tkey = new TKey();
		addKeyListener(tkey);
		
		setSize(this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight());
		
		add(this.backgroundLabel);
		setVisible(true);
	}

	private class TKey extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			case KeyEvent.VK_ENTER:
				new Fase1();
				GameOver.this.setVisible(false);
				break;
			}
		}
	}
}

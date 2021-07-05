package views;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mensagem extends View {
	private static final long serialVersionUID = 1L;
	JLabel backgroundLabel;

	TKey tkey;

	public Mensagem(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);

		tkey = new TKey();
		addKeyListener(tkey);

		setVisible(true);
	}

	private class TKey extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_ENTER) {
				Mensagem.this.setVisible(false);
				Mensagem.this.dispose();
			}
		}
	}
}

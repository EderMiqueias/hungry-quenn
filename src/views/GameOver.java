package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameOver extends Mensagem {
	private static final long serialVersionUID = 1L;

	public GameOver() {
		super("Game Over");

		this.backgroundLabel = new JLabel(new ImageIcon("img/util/game_over.png"));
		this.backgroundLabel.setBounds(0, 0, this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight());

		setSize(this.backgroundLabel.getIcon().getIconWidth(), this.backgroundLabel.getIcon().getIconHeight());

		add(this.backgroundLabel);
	}
}

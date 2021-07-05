package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Parabens extends Mensagem {
	private static final long serialVersionUID = 1L;

	public Parabens() {
		super("Parabéns!");

		this.backgroundLabel = new JLabel(new ImageIcon("img/util/parabens.png"));
		this.backgroundLabel.setBounds(0, 0, this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight());

		setSize(this.backgroundLabel.getIcon().getIconWidth(), this.backgroundLabel.getIcon().getIconHeight());

		add(this.backgroundLabel);
	}
}

package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends View {
	private static final long serialVersionUID = 1L;

	JLabel titleLabel;
	JButton nivel1Button, nivel2Button;

	Fase fase1, fase2;

	public Menu() {
		super("HungryQuenn - Seleção de Nivel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.titleLabel = new JLabel("Selecione o Nivel:");
		this.titleLabel.setBounds(20, 50, 200, 50);

		this.nivel1Button = new JButton("Nivel 1");
		this.nivel1Button.setBounds(20, 100, 200, 50);
		this.nivel1Button.addActionListener(new ButtonHandlerNivel1());

		this.nivel2Button = new JButton("Nivel 2");
		this.nivel2Button.setBounds(20, 180, 200, 50);
		this.nivel2Button.addActionListener(new ButtonHandlerNivel2());

		add(this.titleLabel);
		add(this.nivel1Button);
		add(this.nivel2Button);

		setSize(250, 320);
		setVisible(true);
	}

	private class ButtonHandlerNivel1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (Menu.this.fase1 == null) {
				Menu.this.fase1 = new Fase1();
				return;
			}
			if (!Menu.this.fase1.isDisplayable())
				Menu.this.fase1 = new Fase1();
		}
	}
	
	private class ButtonHandlerNivel2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (Menu.this.fase2 == null) {
				Menu.this.fase2 = new Fase2();
				return;
			}
			if (!Menu.this.fase2.isDisplayable())
				Menu.this.fase2 = new Fase2();
		}
	}

}

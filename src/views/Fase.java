package views;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.cargas.Folha;
import models.cargas.Semente;
import models.personagens.Formiga;
import models.personagens.Rainha;
import models.personagens.Sapo;

public abstract class Fase extends View{
	private static final long serialVersionUID = 1L;
	
	Formiga formiga;
	Rainha rainha;
	
	ArrayList<Sapo> saposLista = new ArrayList<Sapo>();
	ArrayList<Semente> folhasLista = new ArrayList<Semente>();
	ArrayList<Folha> sementesLista = new ArrayList<Folha>();
	
	JLabel backgroundLabel;
	ImageIcon icone;

	TKey tkey;

	public Fase(String title, String backgroundURL) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.backgroundLabel = new JLabel(new ImageIcon(backgroundURL));
		this.backgroundLabel.setBounds(0, 0, this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight());
		
		this.icone = new ImageIcon("img/icon.png");
		setIconImage(this.icone.getImage());
		
		tkey = new TKey();
		addKeyListener(tkey);
		
		setSize(this.backgroundLabel.getIcon().getIconWidth(), this.backgroundLabel.getIcon().getIconHeight());
		setVisible(false);
	}
	
	public void encerrar() {
		String msg = "Deseja Sair do HungryQueen?";
		int opcao = JOptionPane.showConfirmDialog(null, msg, msg, JOptionPane.YES_NO_OPTION);
		if (opcao == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	private class TKey extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				encerrar();
		}
	}

}

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
	private final int borderHeight = 28;
	
	Formiga formiga;
	Rainha rainha;
	
	ArrayList<Sapo> saposLista = new ArrayList<Sapo>();
	ArrayList<Folha> folhasLista = new ArrayList<Folha>();
	ArrayList<Semente> sementesLista = new ArrayList<Semente>();
	
	JLabel backgroundLabel;
	ImageIcon icone;

	TKey tkey;

	public Fase(String title, String backgroundURL) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setUndecorated(true);
		
		this.backgroundLabel = new JLabel(new ImageIcon(backgroundURL));
		this.backgroundLabel.setBounds(0, 0, this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight());
		
		this.icone = new ImageIcon("img/icon.png");
		setIconImage(this.icone.getImage());
		
		this.formiga = new Formiga(50, 100);
		this.rainha = new Rainha(10, 10);
		
		add(this.formiga.label);
		add(this.rainha.label);
		
		tkey = new TKey();
		addKeyListener(tkey);
		
		setSize(this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight() + borderHeight);
		setVisible(false);
	}
	
	public void addSapo(Sapo sapo) {
		this.saposLista.add(sapo);
		this.add(sapo.label);
	}
	
	public void addFolha(Folha folha) {
		this.folhasLista.add(folha);
		this.add(folha.label);
	}
	
	public void addSemente(Semente semente) {
		this.sementesLista.add(semente);
		this.add(semente.label);
	}
	
	public void encerrar() {
		String msg = "Deseja Sair do HungryQueen?";
		int opcao = JOptionPane.showConfirmDialog(null, msg, msg, JOptionPane.YES_NO_OPTION);
		if (opcao == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	private class TKey extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				encerrar();
				break;
			case KeyEvent.VK_UP:
				Fase.this.formiga.turnUp();
				break;
			case KeyEvent.VK_RIGHT:
				Fase.this.formiga.turnRight();
				break;
			case KeyEvent.VK_DOWN:
				Fase.this.formiga.turnDown();
				break;
			case KeyEvent.VK_LEFT:
				Fase.this.formiga.turnLeft();
				break;
			default:
				break;
			}
		}
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				Fase.this.formiga.movimentar(10, Fase.this.getContentPane().getWidth(),
						Fase.this.getContentPane().getHeight() - Fase.this.borderHeight);
			}
		}
	}

}

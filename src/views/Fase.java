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
import models.enums.Direcao;
import models.personagens.Formiga;
import models.personagens.Rainha;
import models.personagens.Sapo;

public abstract class Fase extends View{
	private static final long serialVersionUID = 1L;
	protected final int borderHeight = 28;
	
	Formiga formiga;
	Rainha rainha;
	
	ArrayList<Sapo> saposLista = new ArrayList<Sapo>();
	ArrayList<Folha> folhasLista = new ArrayList<Folha>();
	ArrayList<Semente> sementesLista = new ArrayList<Semente>();
	
	protected JLabel backgroundLabel;

	TKey tkey;

	public Fase(String title, String backgroundURL) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setUndecorated(true);
		
		this.backgroundLabel = new JLabel(new ImageIcon(backgroundURL));
		this.backgroundLabel.setBounds(0, 0, this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight());
		
		this.formiga = new Formiga(50, 100, this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight() + borderHeight);
		this.rainha = new Rainha(10, 10, this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight() + borderHeight);
		
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
	
	public void addSapo(int posX, int posY, Direcao direcao, int velocidade, int limI, int limF) {
		Sapo sapo = new Sapo(posX, posY, this.backgroundLabel.getIcon().getIconWidth(),
				this.backgroundLabel.getIcon().getIconHeight() + this.borderHeight);
		sapo.start(this.formiga, this, direcao, velocidade, limI, limF);
		this.saposLista.add(sapo);
		this.add(sapo.label);
	}
	
	public void addFolha(int posX, int posY) {
		Folha folha = new Folha(posX, posY, this.folhasLista);
		folha.start(this.rainha);
		this.folhasLista.add(folha);
		this.add(folha.label);
	}
	
	public void addFolha(Folha folha) {
		this.folhasLista.add(folha);
		this.add(folha.label);
	}
	
	public void removeFolha(Folha folha) {
		if (this.folhasLista.contains(folha)) {
			this.folhasLista.remove(folha);
		}
	}
	
	public void addSemente(int posX, int posY) {
		Semente semente = new Semente(posX, posY, this.sementesLista);
		semente.start(this.rainha);
		this.sementesLista.add(semente);
		this.add(semente.label);
	}
	
	public void addSemente(Semente semente) {
		this.sementesLista.add(semente);
		this.add(semente.label);
	}
	
	public void removeSemnete(Semente semente) {
		if (this.sementesLista.contains(semente)) {
			this.sementesLista.remove(semente);
		}
	}
	
	public void encerrar() {
		String msg = "Deseja Sair do HungryQueen?";
		int opcao = JOptionPane.showConfirmDialog(null, msg, msg, JOptionPane.YES_NO_OPTION);
		if (opcao == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	public void finalizar() {
		this.rainha.emMovimento = false;
		this.formiga.emMovimento = false;
		
		for (Sapo sapo : this.saposLista) {
			sapo.emMovimento = false;
			sapo.atacar.continuar = false;
		}
		
		this.setVisible(false);
		this.dispose();
	}
	
	public void toggleCarga() {
		if(this.formiga.carregando == null) {
			Folha pegouFolha = pegarFolha();
			if (pegouFolha == null)
				pegarSemente();
		} else {
			this.formiga.soltarCarga();
		}
	}
	
	public Folha pegarFolha() {
		for(Folha folha : this.folhasLista) {
			if (this.formiga.retangulo.intersects(folha.retangulo)) {
				this.formiga.pegarFolha(folha);
				folha.toggleCarga();
				return folha;
			}
		}
		return null;
	}
	
	public Semente pegarSemente() {
		for(Semente semente: this.sementesLista) {
			if (this.formiga.retangulo.intersects(semente.retangulo)) {
				this.formiga.pegarSemente(semente);
				semente.toggleCarga();
				return semente;
			}
		}
		return null;
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
			case KeyEvent.VK_ENTER:
				Fase.this.toggleCarga();
				break;
			default:
				break;
			}
		}
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				Fase.this.formiga.movimentar(30);
			}
		}
	}

}

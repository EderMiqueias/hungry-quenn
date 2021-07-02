package models.personagens;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Formiga extends Personagem{
	public boolean carregada = false;

	public Formiga(int posX, int posY) {
		super(posX, posY);
		this.soltarCarga();
		this.imagem = this.rightImg;
		this.label = new JLabel(this.imagem);
		this.tamanho = new Dimension(this.imagem.getIconWidth(), this.imagem.getIconWidth());
	}
	
	public void pegarFolha() {
		this.upImg = new ImageIcon("img/ant_leaf/up1.png");
		this.rightImg = new ImageIcon("img/ant_leaf/right1.png");
		this.downImg = new ImageIcon("img/ant_leaf/down1.png");
		this.leftImg = new ImageIcon("img/ant_leaf/left1.png");
		this.carregada = true;
	}
	
	public void pegarSemente() {
		this.upImg = new ImageIcon("img/ant_seed/up1.png");
		this.rightImg = new ImageIcon("img/ant_seed/right1.png");
		this.downImg = new ImageIcon("img/ant_seed/down1.png");
		this.leftImg = new ImageIcon("img/ant_seed/left1.png");
		this.carregada = true;
	}
	
	public void soltarCarga() {
		this.upImg = new ImageIcon("img/ant_none/up1.png");
		this.rightImg = new ImageIcon("img/ant_none/right1.png");
		this.downImg = new ImageIcon("img/ant_none/down1.png");
		this.leftImg = new ImageIcon("img/ant_none/left1.png");
		this.carregada = false;
	}

}

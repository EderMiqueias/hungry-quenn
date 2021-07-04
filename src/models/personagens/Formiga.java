package models.personagens;

import javax.swing.ImageIcon;

import models.cargas.Carga;
import models.cargas.Folha;
import models.cargas.Semente;

public class Formiga extends Personagem{
	public Carga carregando = null;

	public Formiga(int posX, int posY, int limX, int limY) {
		super(posX, posY, limX, limY);
		this.emMovimento = true;
		this.setImgsDefault();
		
		this.imagem = this.rightImg;
		
		this.updateLabelImage();
	}
	
	public void pegarFolha(Folha folha) {
		this.upImg = new ImageIcon("img/ant_leaf/up1.png");
		this.rightImg = new ImageIcon("img/ant_leaf/right1.png");
		this.downImg = new ImageIcon("img/ant_leaf/down1.png");
		this.leftImg = new ImageIcon("img/ant_leaf/left1.png");
		this.carregando = folha;
		this.updateCargaImage();
	}
	
	public void pegarSemente(Semente semente) {
		this.upImg = new ImageIcon("img/ant_seed/up1.png");
		this.rightImg = new ImageIcon("img/ant_seed/right1.png");
		this.downImg = new ImageIcon("img/ant_seed/down1.png");
		this.leftImg = new ImageIcon("img/ant_seed/left1.png");
		this.carregando = semente;
		this.updateCargaImage();
	}
	
	public void soltarCarga() {
		if (this.carregando != null) {
			this.carregando.soltar(this.posX, this.posY);
			this.carregando = null;
			
			this.upImg = new ImageIcon("img/ant_none/up1.png");
			this.rightImg = new ImageIcon("img/ant_none/right1.png");
			this.downImg = new ImageIcon("img/ant_none/down1.png");
			this.leftImg = new ImageIcon("img/ant_none/left1.png");
			this.updateCargaImage();
		}
	}
	
	public void updateCargaImage() {
		switch (this.direcao) {
		case UP:
			this.imagem = this.upImg;
			break;
		case RIGHT:
			this.imagem = this.rightImg;
			break;
		case DOWN:
			this.imagem = this.downImg;
			break;
		case LEFT:
			this.imagem = this.leftImg;
			break;
		default:
			break;
		}
		this.updateLabelImage();
	}

	@Override
	public void setImgsDefault() {
		this.upImg = new ImageIcon("img/ant_none/up1.png");
		this.rightImg = new ImageIcon("img/ant_none/right1.png");
		this.downImg = new ImageIcon("img/ant_none/down1.png");
		this.leftImg = new ImageIcon("img/ant_none/left1.png");
	}
}

package models.personagens;

import javax.swing.ImageIcon;

import models.Ator;
import models.enums.Direcao;

public abstract class Personagem extends Ator {
	public boolean emMovimento;
	public Direcao direcao;
	
	public ImageIcon leftImg, rightImg, upImg, downImg;
	
	public Personagem(int posX, int posY) {
		super(posX, posY);
		this.emMovimento = false;
		this.direcao = Direcao.RIGHT;
	}
	
	public abstract void setImgsDefault();

	public void turnUp() {
		this.direcao = Direcao.UP;
		this.imagem = this.upImg;
		this.updateLabelImage();
	}
	
	public void turnRight() {
		this.direcao = Direcao.RIGHT;
		this.imagem = this.rightImg;
		this.updateLabelImage();
	}
	
	public void turnDown() {
		this.direcao = Direcao.DOWN;
		this.imagem = this.downImg;
		this.updateLabelImage();
	}
	
	public void turnLeft() {
		this.direcao = Direcao.LEFT;
		this.imagem = this.leftImg;
		this.updateLabelImage();
	}
	
	public void movimentar(int velocidade, int limX, int limY) {
		if (this.emMovimento) {
			switch (this.direcao) {
			case UP:
				if(this.posY - velocidade > 0)
					this.posY -= velocidade;
				break;
			case RIGHT:
				if(this.posX + velocidade + this.retangulo.width < limX)
					this.posX += velocidade;
				break;
			case DOWN:
				if(this.posY + velocidade + this.retangulo.height < limY)
					this.posY += velocidade;
				break;
			case LEFT:
				if(this.posX - velocidade > 0)
					this.posX -= velocidade;
				break;
			default:
				break;
			}
			this.updateBounds();
		}
	}

}

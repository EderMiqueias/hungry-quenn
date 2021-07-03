package models.personagens;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import models.enums.Direcao;

public abstract class Personagem {
	public int posX, posY;
	public boolean emMovimento;
	public Dimension tamanho;
	public Direcao direcao;
	
	public ImageIcon imagem;
	public ImageIcon leftImg, rightImg, upImg, downImg;
	public JLabel label;
	
	public Personagem(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.direcao = Direcao.RIGHT;
		this.label = new JLabel();
	}
	
	public void setLabelBounds() {
		this.label.setBounds(posX, posY, this.imagem.getIconWidth(), this.imagem.getIconHeight());
	}
	
	public void setLabelImage() {
		this.label.setIcon(this.imagem);
		this.tamanho = new Dimension(this.imagem.getIconWidth(), this.imagem.getIconWidth());
		this.setLabelBounds();
	}

	public void turnUp() {
		this.direcao = Direcao.UP;
		this.imagem = this.upImg;
		this.setLabelImage();
	}
	
	public void turnRight() {
		this.direcao = Direcao.RIGHT;
		this.imagem = this.rightImg;
		this.setLabelImage();
	}
	
	public void turnDown() {
		this.direcao = Direcao.DOWN;
		this.imagem = this.downImg;
		this.setLabelImage();
	}
	
	public void turnLeft() {
		this.direcao = Direcao.LEFT;
		this.imagem = this.leftImg;
		this.setLabelImage();
	}
	
	public void movimentar(int velocidade, int limX, int limY) {
		if (true) {
			switch (this.direcao) {
			case UP:
				if(this.posY - velocidade > 0)
					this.posY -= velocidade;
				break;
			case RIGHT:
				if(this.posX + velocidade + this.tamanho.width < limX)
					this.posX += velocidade;
				break;
			case DOWN:
				if(this.posY + velocidade + this.tamanho.height < limY)
					this.posY += velocidade;
				break;
			case LEFT:
				if(this.posX - velocidade > 0)
					this.posX -= velocidade;
				break;
			default:
				break;
			}
			this.setLabelBounds();
		}
	}

}

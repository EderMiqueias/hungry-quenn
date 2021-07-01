package models.personagens;

import javax.swing.ImageIcon;

import models.enums.Direcao;

public class Personagem {
	public int posX, posY;
	public Direcao direcao;
	public ImageIcon imagem;
	public ImageIcon leftImg, rightImg, upImg, downImg;
	
	public Personagem(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.direcao = Direcao.RIGHT;
	}

	public void turnUp() {
		this.direcao = Direcao.UP;
		this.imagem = this.upImg;
	}
	
	public void turnRight() {
		this.direcao = Direcao.RIGHT;
		this.imagem = this.rightImg;
	}
	
	public void turnDown() {
		this.direcao = Direcao.DOWN;
		this.imagem = this.downImg;
	}
	
	public void turnLeft() {
		this.direcao = Direcao.LEFT;
		this.imagem = this.leftImg;
	}

}

package models.personagens;

import javax.swing.ImageIcon;

public class Sapo extends Personagem {

	public Sapo(int posX, int posY) {
		super(posX, posY);
		this.upImg = new ImageIcon("img/frog/up1.png");
		this.rightImg = new ImageIcon("img/frog/right1.png");
		this.downImg = new ImageIcon("img/frog/down1.png");
		this.leftImg = new ImageIcon("img/frog/left1.png");
		this.imagem = this.rightImg;
	}

}

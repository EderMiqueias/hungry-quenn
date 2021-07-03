package models.personagens;

import javax.swing.ImageIcon;

public class Rainha extends Personagem {

	public Rainha(int posX, int posY) {
		super(posX, posY);
		this.setImgsDefault();

		this.imagem = this.rightImg;
		
		this.updateLabelImage();
	}

	@Override
	public void setImgsDefault() {
		this.upImg = new ImageIcon("img/quenn/up1.png");
		this.rightImg = new ImageIcon("img/quenn/right1.png");
		this.downImg = new ImageIcon("img/quenn/down1.png");
		this.leftImg = new ImageIcon("img/quenn/left1.png");
	}

}

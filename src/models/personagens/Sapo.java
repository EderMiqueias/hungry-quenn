package models.personagens;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sapo extends Personagem {

	public Sapo(int posX, int posY) {
		super(posX, posY);
		
		this.upImg = new ImageIcon("img/frog/up1.png");
		this.rightImg = new ImageIcon("img/frog/right1.png");
		this.downImg = new ImageIcon("img/frog/down1.png");
		this.leftImg = new ImageIcon("img/frog/left1.png");
		
		this.imagem = this.rightImg;
		this.label = new JLabel(this.imagem);
		
		this.tamanho = new Dimension(this.imagem.getIconWidth(), this.imagem.getIconWidth());
	}

}

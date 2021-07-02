package models.personagens;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Rainha extends Personagem {

	public Rainha(int posX, int posY) {
		super(posX, posY);
		
		this.upImg = new ImageIcon("img/quenn/up1.png");
		this.rightImg = new ImageIcon("img/quenn/right1.png");
		this.downImg = new ImageIcon("img/quenn/down1.png");
		this.leftImg = new ImageIcon("img/quenn/left1.png");
		
		this.imagem = this.rightImg;
		this.label = new JLabel(this.imagem);
		
		this.tamanho = new Dimension(this.imagem.getIconWidth(), this.imagem.getIconWidth());
	}

}

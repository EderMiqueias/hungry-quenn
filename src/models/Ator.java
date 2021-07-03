package models;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ator {
	public int posX, posY;
	public ImageIcon imagem;
	public JLabel label;
	public Rectangle retangulo;
	
	public Ator(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.label = new JLabel();
		this.retangulo = new Rectangle();
	}
	
	public void updateBounds() {
		this.label.setBounds(this.posX, this.posY, this.imagem.getIconWidth(), this.imagem.getIconHeight());
		this.retangulo.setBounds(this.posX, this.posY, this.imagem.getIconWidth(), this.imagem.getIconHeight());
	}
	
	public void updateLabelImage() {
		this.label.setIcon(this.imagem);
		this.retangulo.setSize(this.imagem.getIconWidth(), this.imagem.getIconHeight());
		this.updateBounds();
	}
}

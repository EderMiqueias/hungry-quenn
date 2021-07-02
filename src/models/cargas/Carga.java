package models.cargas;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carga {
	public int posX, posY;
	public ImageIcon imagem;
	public JLabel label;
	public Dimension tamanho;
	
	public Carga(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
}

package models.cargas;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Folha extends Carga{

	public Folha(int posX, int posY) {
		super(posX, posY);
		
		this.imagem = new ImageIcon("img/loads/leaf.png");
		this.label = new JLabel(this.imagem);
		
		this.tamanho = new Dimension(this.imagem.getIconWidth(), this.imagem.getIconWidth());
		
		this.setLabelBounds();
	}
}

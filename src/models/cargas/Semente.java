package models.cargas;

import javax.swing.ImageIcon;

public class Semente extends Carga{

	public Semente(int posX, int posY) {
		super(posX, posY);
		
		this.imagem = new ImageIcon("img/loads/seed.png");
		this.retangulo.setSize(this.imagem.getIconWidth(), this.imagem.getIconHeight());	
		
		this.updateLabelImage();
	}
}

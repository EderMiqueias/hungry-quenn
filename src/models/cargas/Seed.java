package models.cargas;

import javax.swing.ImageIcon;

public class Seed extends Carga{

	public Seed(int posX, int posY) {
		super(posX, posY);
		this.imagem = new ImageIcon("img/loads/seed.png");
	}
}

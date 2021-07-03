package models.cargas;

import models.Ator;

public class Carga extends Ator{
	
	public Carga(int posX, int posY) {
		super(posX, posY);
	}
	
	public void soltar(int posX, int posY) {
		this.moverPara(posX, posY);
		this.toggleCarga();
	}
	
	public void moverPara(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.updateBounds();
	}
	
	public void toggleCarga() {
		this.label.setVisible(!this.label.isVisible());
	}
}

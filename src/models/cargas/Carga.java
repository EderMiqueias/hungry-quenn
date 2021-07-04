package models.cargas;

import javax.swing.JOptionPane;

import models.Ator;
import models.personagens.Rainha;

public abstract class Carga extends Ator{
	public PossoComer possoComer;
	
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
	
	public void devorarCarga() {
//		ponto morto definido em -999
		this.label.setVisible(false);
		this.label = null;
		this.retangulo = null;
		this.imagem = null;
		
		this.posX = -999;
		this.posY = -999;
		
		this.autoRemove();
		this.possoComer.continuar = false;
	}
	
	public void start(Rainha rainha) {
		this.possoComer = new PossoComer(rainha);
		this.possoComer.start();
	}
	
	public abstract void autoRemove();
	
	private class PossoComer extends Thread {
		Rainha rainha;
		Carga carga;
		public boolean continuar;
		
		public PossoComer(Rainha rainha) {
			this.carga = Carga.this;
			this.rainha = rainha;
			
			this.continuar = true;
		}
		
		public void run() {
			synchronized (this) {
				while (this.continuar) {
					if (this.rainha.retangulo.intersects(this.carga.retangulo)) {
						this.carga.devorarCarga();
					}
					try {
						Thread.sleep(1000);
					}
					catch (InterruptedException e) {
						JOptionPane.showMessageDialog(null, "Erro ao executar, o jogo será finalizado!");
						System.exit(0);
					}
				}
			}
		}
	}
}

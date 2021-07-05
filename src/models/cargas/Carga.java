package models.cargas;

import javax.swing.JOptionPane;

import models.Ator;
import models.personagens.Rainha;
import views.Fase;

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
	
	public void devorarCarga(Fase fase) {
//		ponto morto definido em -999
		this.label.setVisible(false);
		this.label = null;
		this.retangulo = null;
		this.imagem = null;
		
		this.posX = -999;
		this.posY = -999;
		
		this.autoRemove(fase);
		this.possoComer.continuar = false;
	}
	
	public void start(Rainha rainha, Fase fase) {
		this.possoComer = new PossoComer(rainha, fase);
		this.possoComer.start();
	}
	
	public abstract void autoRemove(Fase fase);
	
	private class PossoComer extends Thread {
		Rainha rainha;
		Fase fase;
		Carga carga;
		public boolean continuar;
		
		public PossoComer(Rainha rainha, Fase fase) {
			this.carga = Carga.this;
			this.rainha = rainha;
			this.fase = fase;
			
			this.continuar = true;
		}
		
		public void run() {
			synchronized (this) {
				while (this.continuar) {
					if (this.rainha.retangulo.intersects(this.carga.retangulo)) {
						this.carga.devorarCarga(this.fase);
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

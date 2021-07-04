package models.personagens;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import models.enums.Direcao;

public class Sapo extends Personagem {
	Atacar atacar;

	public Sapo(int posX, int posY, int limX, int limY) {
		super(posX, posY, limX, limY);
		this.setImgsDefault();
		
		this.imagem = this.rightImg;
		
		this.updateLabelImage();
	}
	
	public void start(Formiga formiga, Direcao direcao, int velocidade, int limI, int limF) {
		this.atacar = new Atacar(formiga);
		this.atacar.start();
		
		this.turnToDirection(direcao);
		
		this.movimentoVaiVolta = new Personagem.MovimentoVaiVolta(velocidade, limI, limF);
		this.movimentoVaiVolta.start();
	}
	
	public void ataque() {
		System.out.println("yoink!");
	}

	@Override
	public void setImgsDefault() {
		this.upImg = new ImageIcon("img/frog/up1.png");
		this.rightImg = new ImageIcon("img/frog/right1.png");
		this.downImg = new ImageIcon("img/frog/down1.png");
		this.leftImg = new ImageIcon("img/frog/left1.png");
	}
	
	private class Atacar extends Thread {
		Formiga formiga;
		Sapo sapo;
		public boolean continuar;
		
		public Atacar(Formiga formiga) {
			this.sapo = Sapo.this;
			this.formiga = formiga;
			
			this.continuar = true;
		}
		
		public void run() {
			synchronized (this) {
				while (this.continuar) {
					if (this.sapo.retangulo.intersects(this.formiga.retangulo)) {
						this.sapo.ataque();
					}
					try {
						Thread.sleep(200);
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

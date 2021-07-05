package models.personagens;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import models.enums.Direcao;
import views.Fase;
import views.GameOver;

public class Sapo extends Personagem {
	public Atacar atacar;

	public Sapo(int posX, int posY, int limX, int limY) {
		super(posX, posY, limX, limY);
		this.setImgsDefault();
		
		this.imagem = this.rightImg;
		
		this.updateLabelImage();
	}
	
	public void start(Formiga formiga, Fase fase, Direcao direcao, int velocidade, int limI, int limF) {
		this.atacar = new Atacar(formiga, fase);
		this.atacar.start();
		
		this.turnToDirection(direcao);
		
		this.movimentoVaiVolta = new Personagem.MovimentoVaiVolta(velocidade, limI, limF);
		this.movimentoVaiVolta.start();
	}
	
	public void ataque(Fase fase) {
		new GameOver();
		fase.finalizar();
	}

	@Override
	public void setImgsDefault() {
		this.upImg = new ImageIcon("img/frog/up1.png");
		this.rightImg = new ImageIcon("img/frog/right1.png");
		this.downImg = new ImageIcon("img/frog/down1.png");
		this.leftImg = new ImageIcon("img/frog/left1.png");
	}
	
	public class Atacar extends Thread {
		Formiga formiga;
		Sapo sapo;
		Fase fase;
		public boolean continuar;
		
		public Atacar(Formiga formiga, Fase fase) {
			this.sapo = Sapo.this;
			this.formiga = formiga;
			
			this.fase = fase;
			
			this.continuar = true;
		}
		
		public void run() {
			synchronized (this) {
				while (this.continuar) {
					if (this.sapo.retangulo.intersects(this.formiga.retangulo)) {
						this.sapo.ataque(this.fase);
					}
					try {
						Thread.sleep(50);
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

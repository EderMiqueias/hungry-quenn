package models.personagens;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.Ator;
import models.enums.Direcao;

public abstract class Personagem extends Ator {
	public boolean emMovimento;
	public Direcao direcao;

	public ImageIcon leftImg, rightImg, upImg, downImg;

	public Personagem(int posX, int posY) {
		super(posX, posY);
		this.emMovimento = false;
		this.direcao = Direcao.RIGHT;
	}

	public abstract void setImgsDefault();

	public void turnUp() {
		this.direcao = Direcao.UP;
		this.imagem = this.upImg;
		this.updateLabelImage();
	}

	public void turnRight() {
		this.direcao = Direcao.RIGHT;
		this.imagem = this.rightImg;
		this.updateLabelImage();
	}

	public void turnDown() {
		this.direcao = Direcao.DOWN;
		this.imagem = this.downImg;
		this.updateLabelImage();
	}

	public void turnLeft() {
		this.direcao = Direcao.LEFT;
		this.imagem = this.leftImg;
		this.updateLabelImage();
	}
	
	public void turnSelf() {
		switch (this.direcao) {
		case UP:
			this.turnDown();
			break;
		case RIGHT:
			this.turnLeft();
			break;
		case DOWN:
			this.turnUp();
			break;
		case LEFT:
			this.turnRight();
			break;
		}
	}

	public void movimentar(int velocidade, int limX, int limY) {
		if (this.emMovimento) {
			switch (this.direcao) {
			case UP:
				if (this.posY - velocidade > 0)
					this.posY -= velocidade;
				break;
			case RIGHT:
				if (this.posX + velocidade + this.retangulo.width < limX)
					this.posX += velocidade;
				break;
			case DOWN:
				if (this.posY + velocidade + this.retangulo.height < limY)
					this.posY += velocidade;
				break;
			case LEFT:
				if (this.posX - velocidade > 0)
					this.posX -= velocidade;
				break;
			}
			this.updateBounds();
		}
	}

	public class MovimentoVaiVolta extends Thread {
		public int velocidade, limX, limY, limI, limF;
		boolean continuar;

		JLabel label;
		Personagem personagem;

		public MovimentoVaiVolta(int velocidade, int limI, int limF, int limX, int limY) {
			super();
			this.personagem = Personagem.this;
			this.label = Personagem.this.label;

			this.velocidade = velocidade;
			this.limI = limI;
			this.limF = limF;
			this.limY = limY;
			this.limX = limX;
			this.continuar = true;
			this.personagem.emMovimento = true;
		}

		public void run() {
			synchronized (this) {
				while (this.continuar) {
					do {
						this.personagem.movimentar(this.velocidade, this.limX, this.limY);
						try {
							Thread.sleep(100);
						}
						catch (InterruptedException e) {
							JOptionPane.showMessageDialog(null, "Erro ao executar, o jogo será finalizado!");
							System.exit(0);
						}
					} while (this.condicao());
					this.personagem.turnSelf();
				}
			}
		}
		
		private boolean condicao() {
			if (this.personagem.direcao == Direcao.LEFT || this.personagem.direcao == Direcao.RIGHT)
				return this.personagem.posX > this.limI && this.personagem.posX < this.limF;
			else
				return this.personagem.posY > this.limI && this.personagem.posY < this.limF;
		}
	}

}

package views;

import models.enums.Direcao;

public class Fase1 extends Fase {
	private static final long serialVersionUID = 1L;
	int velocidadeSapos;

	public Fase1() {
		super("HungryQuenn Nivel 1", "img/maps/fase1.png");
		this.velocidadeSapos = 10;
		
		this.addSapo(300, 300, Direcao.RIGHT, this.velocidadeSapos, 200, 400);
		this.addSapo(620, 250, Direcao.DOWN, this.velocidadeSapos, 50, 400);
		this.addSapo(500, 100, Direcao.LEFT, this.velocidadeSapos, 100, 500);
		this.addSapo(740, 350, Direcao.UP, this.velocidadeSapos, 300, 700);
		this.addSapo(900, 220, Direcao.LEFT, this.velocidadeSapos, 500, 900);
		this.addSapo(1050, 600, Direcao.LEFT, this.velocidadeSapos, 400, 1050);
		this.addSapo(620, 650, Direcao.UP, this.velocidadeSapos, 150, 700);
		this.addSapo(100, 320, Direcao.RIGHT, this.velocidadeSapos, 50, 300);
		this.addSapo(840, 400, Direcao.DOWN, this.velocidadeSapos, 350, 550);
		this.addSapo(960, 540, Direcao.LEFT, this.velocidadeSapos, 730, 960);
		
		this.addFolha(750, 600);
		this.addFolha(150, 350);
		
		this.addSemente(1000, 100);
		this.addSemente(650, 400);

		this.rainha.movimentoVaiVolta.start();
		
		add(this.backgroundLabel);
		setVisible(true);
	}

}

package views;

import java.awt.Color;

import models.enums.Direcao;

public class Fase2 extends Fase {
	private static final long serialVersionUID = 1L;
	int velocidadeSapos;

	public Fase2() {
		super("HungryQuenn Nivel 2", "img/maps/fase2.png");
		this.velocidadeSapos = 12;
		this.cargasRestantesLabel.setForeground(Color.WHITE);
		
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
		this.addFolha(450, 160);
		this.addFolha(500, 550);
		
		this.addSemente(400, 600);
		this.addSemente(650, 400);
		this.addSemente(50, 400);

		this.rainha.movimentoVaiVolta.start();
		
		add(this.backgroundLabel);
		setVisible(true);
	}

}

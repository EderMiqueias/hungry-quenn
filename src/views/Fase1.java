package views;

import models.personagens.Sapo;

public class Fase1 extends Fase {
	private static final long serialVersionUID = 1L;

	public Fase1() {
		super("HungryQuenn Nivel 1", "img/maps/fase1.png");
		
		this.addSapo(new Sapo(300, 300));
		this.addSapo(new Sapo(620, 250));
		this.addSapo(new Sapo(500, 100));
		this.addSapo(new Sapo(740, 350));
		this.addSapo(new Sapo(900, 220));
		this.addSapo(new Sapo(1050, 600));
		this.addSapo(new Sapo(620, 650));
		this.addSapo(new Sapo(100, 320));
		this.addSapo(new Sapo(840, 400));
		this.addSapo(new Sapo(960, 540));
		
		this.addFolha(750, 600);
		this.addFolha(150, 350);
		
		this.addSemente(1000, 100);
		this.addSemente(650, 400);
		
		this.rainha.movimentoVaiVolta.start();
		
		add(this.backgroundLabel);
		setVisible(true);
	}

}

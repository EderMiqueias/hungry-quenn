package models.enums;

public enum Direcao {
	UP(1),
	RIGHT(2),
	DOWN(3),
	LEFT(4);
	
	private int numero;

	Direcao(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
}

package models.cargas;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Folha extends Carga{
	ArrayList<Folha> folhasLista;

	public Folha(int posX, int posY, ArrayList<Folha> folhasLista) {
		super(posX, posY);
		this.folhasLista = folhasLista;
		
		this.imagem = new ImageIcon("img/loads/leaf.png");
		this.retangulo.setSize(this.imagem.getIconWidth(), this.imagem.getIconHeight());
		
		this.updateLabelImage();
	}

	@Override
	public void autoRemove() {
		this.folhasLista.remove(this);
	}
}

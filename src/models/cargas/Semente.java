package models.cargas;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Semente extends Carga{
	ArrayList<Semente> sementesLista;

	public Semente(int posX, int posY, ArrayList<Semente> sementesLista) {
		super(posX, posY);
		this.sementesLista = sementesLista;
		
		this.imagem = new ImageIcon("img/loads/seed.png");
		this.retangulo.setSize(this.imagem.getIconWidth(), this.imagem.getIconHeight());	
		
		this.updateLabelImage();
	}
	
	@Override
	public void autoRemove() {
		this.sementesLista.remove(this);
	}
}

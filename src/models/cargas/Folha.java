package models.cargas;

import javax.swing.ImageIcon;

import views.Fase;

public class Folha extends Carga{

	public Folha(int posX, int posY) {
		super(posX, posY);
		
		this.imagem = new ImageIcon("img/loads/leaf.png");
		this.retangulo.setSize(this.imagem.getIconWidth(), this.imagem.getIconHeight());
		
		this.updateLabelImage();
	}

	@Override
	public void autoRemove(Fase fase) {
		fase.removeFolha(this);
	}
}

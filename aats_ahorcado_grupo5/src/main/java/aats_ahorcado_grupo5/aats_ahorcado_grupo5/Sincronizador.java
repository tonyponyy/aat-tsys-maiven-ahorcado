package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

public class Sincronizador {
	
	private Teclado tcl;
	private PalabraSecreta ps;
	private Imagen img;
	private Vista_ahorcado va;
	
	
	public Sincronizador(Teclado tcl, PalabraSecreta ps, Imagen img, Vista_ahorcado va) {
		super();
		this.tcl = tcl;
		this.ps = ps;
		this.img = img;
		this.va = va;
	}


	public Teclado getTcl() {
		return tcl;
	}


	public PalabraSecreta getPs() {
		return ps;
	}


	public Imagen getImg() {
		return img;
	}


	public Vista_ahorcado getVa() {
		return va;
	}
	
}

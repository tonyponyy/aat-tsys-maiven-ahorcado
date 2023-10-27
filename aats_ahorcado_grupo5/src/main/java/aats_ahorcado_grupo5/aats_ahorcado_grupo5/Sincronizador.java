package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

public class Sincronizador {
	
	private Teclado tcl;
	private PalabraSecreta ps;
	private Imagen img;
	private Vista_ahorcado va;
	private Menu mnu;
	
	
	public Sincronizador(Teclado tcl, PalabraSecreta ps, Imagen img, Menu mnu, Vista_ahorcado va) {
		super();
		this.tcl = tcl;
		this.ps = ps;
		this.img = img;
		this.mnu = mnu;
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

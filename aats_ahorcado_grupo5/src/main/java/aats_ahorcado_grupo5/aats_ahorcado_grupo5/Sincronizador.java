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
		
		this.img.setSincro(this);
		this.tcl.setSincro(this);
	}


	public Teclado getTeclado() {
		return tcl;
	}


	public PalabraSecreta getPalabraSecreta() {
		return ps;
	}


	public Imagen getImagen() {
		return img;
	}


	public Vista_ahorcado getVistaAhorcado() {
		return va;
	}
	
}

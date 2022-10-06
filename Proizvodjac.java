package gui.energetskisistem;

import java.awt.Color;

public abstract class Proizvodjac extends Parcela implements Runnable{

	protected int vreme;
	protected Baterija baterija;
	//protected boolean work;
	
	public Proizvodjac(char o, Color bgc,int vreme,Baterija bat) {
		super(o, bgc);
		this.vreme=vreme;
		this.baterija=bat;
		
	}
	
	public long VremeProizvodnje() {
		
		long x= (long) (Math.random()*300);
		return this.vreme+x;
		
	}
	/*@Override
	public void run() {
		try {
			while(!nit.isInterrupted()) {
				synchronized (nit) {
					while(!work) {
						wait();
					}
				}
			
				nit.sleep(VremeProizvodnje());
				//Proizvedi();
				nit.sleep(300);
				this.setForeground(Color.RED);
			}
		} catch (InterruptedException e) {}
	}*/

	public abstract void zaustavi();

	public abstract void pokreni();
	
}

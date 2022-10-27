package gui.energetskisistem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;

public class Hidroelektrana extends Proizvodjac {

	private int BrOkrVodPov;
	protected boolean work;
	Thread nit;
	
	public Hidroelektrana(char o, Color bgc, int vreme, Baterija bat) {
		super('H', Color.BLUE, 1500, bat);
		BrOkrVodPov=0;
	}

	public void postaviBrVod(int x) {
		this.BrOkrVodPov=x;
	}

	@Override
	public void run() {
		try {
			while(!nit.isInterrupted()) {
				synchronized (this) {
					while(!work) {
						this.wait();
					}
				}
			
				nit.sleep(VremeProizvodnje());
				boolean pom=Proizvedi();
				nit.sleep(300);
				if(pom) {
					this.setForeground(Color.RED);
					this.revalidate();
				}
				else {
					this.setForeground(Color.WHITE);
					this.revalidate();
				}
			}
		} catch (InterruptedException e) {}
	}
	
	public boolean Proizvedi() {
		
		this.BrOkrVodPov=0;
		int poz=this.roditelj.Povrsi.indexOf(this);
		int ipoz,jpoz,i,j;
		int ipom,brojac=0,brRes=0;
		int jpom,index;
		
		//System.out.println("redovi: "+this.roditelj.redovi+", kolone: "+this.roditelj.kolone+", pozicija trazenog: "+poz);
		ipoz=poz/this.roditelj.redovi;
		jpoz=poz%this.roditelj.redovi;
		//i=ipoz-1;
		//j=jpoz-1;
		brojac=0;
		ipom=ipoz-1;
		jpom=jpoz-1;
		
		//System.out.println("i:" +ipoz+", j:" +jpoz+"; ipomz: "+ipom+", jpom: "+jpom);
		while(true) {
			//if(!((p.id==this.id )|| (p instanceof Hidroelektrana))) {
			if(brRes>2)break;
			if(ipom<0) {brRes++;jpom=jpoz-1;ipom+=1;}
			else if(ipom>this.roditelj.redovi-1) {
				brRes++;jpom=jpoz-1;ipom+=1;brojac=0;
			}
			else {
			if(jpom<0) {jpom+=1;brojac++;}
			else if(jpom>this.roditelj.kolone-1) {jpom+=1;brojac++;}
			
			else {
				try {
					if(!(ipom==ipoz && jpom==jpoz)) {
						index=ipom*this.roditelj.redovi+jpom;	
						if(this.roditelj.Povrsi.get(index).oznaka=='~') {
							this.BrOkrVodPov+=1;
						}
					}
				jpom++;
				brojac++;	
				}
				catch(IndexOutOfBoundsException e) { jpom++;
					brojac++;	}
			}
			}
			if(brojac>2) {
				brRes++;jpom=jpoz-1;ipom+=1;brojac=0;
			}	
		}
		
		if(this.BrOkrVodPov>0)return true;
		return false;
	}

	@Override
	public synchronized void zaustavi() {
		work=false;
		notify();
	}

	@Override
	public synchronized void pokreni() {
		work=true;
		notify();
	}
	
	@Override
	public void populateWindow() {
		
		this.setBackground(pozadinskaBoja);
		this.setAlignment(Label.CENTER);
		Font font=new Font(Font.SERIF, Font.BOLD, 14);
		this.setFont(font);
		this.setForeground(Color.WHITE);
		this.setText("H");
	}

	@Override
	protected void dodajVelicinu( ) {
		this.setPreferredSize(new Dimension(500/this.roditelj.kolone,380/this.roditelj.redovi));
	}
	
}

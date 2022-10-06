package gui.energetskisistem;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;

public class Plac extends Panel {

	protected int redovi,kolone;
	int broj=dohvatiBr();
	ArrayList<Parcela> Povrsi=new ArrayList<>();
	Parcela poslKliknut;
	Panel sadrzaj;
	
	public Plac(int red,int kol) {
		this.redovi=red;
		this.kolone=kol;
		
		Inicijalizacija(this.redovi,this.kolone);
		setVisible(true);
	}



	private void Inicijalizacija(int x,int y) {

		GridLayout layout = new GridLayout(x, y);
		layout.setHgap(0);
		layout.setVgap(0);
		
		this.sadrzaj=new Panel(layout);
		this.sadrzaj.setBounds(700, 300, 500, 400);
		this.sadrzaj.setMaximumSize(new Dimension(500,400));
		//this.sadrzaj.setSize(500-(y-1)*5,400-(x-1)*5);
		//this.sadrzaj.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Parcela povrsi;
		int i=0;
		
		while(i<x*y) {
			
			double r=Math.random()*10;
			if(r<=3) {
				Panel parc=new Panel();
				povrsi=new VodenaPovrs('~',Color.CYAN);
				parc.add(povrsi) ;
				this.Povrsi.add(povrsi);
				int pom=this.Povrsi.indexOf(povrsi);
				this.Povrsi.get(pom).dodajRoditelja(this);
				this.Povrsi.get(pom).dodajVelicinu();
				sadrzaj.add(parc);
			}
			else {
				Panel parc=new Panel();
				povrsi=new TravnataPovrs('"',Color.GREEN);
				parc.add(povrsi);
				this.Povrsi.add(povrsi);
				int pom=this.Povrsi.indexOf(povrsi);
				this.Povrsi.get(pom).dodajRoditelja(this);
				this.Povrsi.get(pom).dodajVelicinu();
				sadrzaj.add(parc);
			}
			
			//add(sadrzaj);
			this.revalidate();
			i++;
		}
		
		add(sadrzaj);
		this.revalidate();
		//setPreferredSize(getMaximumSize());
		//setPreferredSize(new Dimension(400,400));
	}
	
	public void NapraviHidro(Parcela p,int i,Baterija b) {
		Panel parc=new Panel();
		this.revalidate();
		Hidroelektrana pp=new Hidroelektrana('H', Color.BLUE, 1500, b);
		parc.add(pp);
		//this.Povrsi.remove(p);
		pp.id=this.Povrsi.get(i).id;
		this.Povrsi.set(i, pp);
		this.Povrsi.get(i).dodajRoditelja(this);
		this.Povrsi.get(i).dodajVelicinu();
		sadrzaj.remove(i);
		sadrzaj.add(parc, i);
		//remove(sadrzaj);
		add(sadrzaj);
		this.revalidate();
		//pp=(Hidroelektrana) this.Povrsi.get(i);
		//pp.nit.start();
		//pp.pokreni();
		
	}
	
	public int dohvatiBr() {
		return this.redovi*this.kolone;
	}
	
	public void ZaustaviProizvodjace() {
		for(Parcela p:Povrsi) {
			if(p instanceof Hidroelektrana) {
				((Hidroelektrana) p).zaustavi();
			}
		}
	}
	
	public void PoslednjaKliknutaParcela(Parcela p) {
		this.poslKliknut=p;
	}
	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append("[");
		for(Parcela p:Povrsi) {
			sb.append(p);
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
	
}

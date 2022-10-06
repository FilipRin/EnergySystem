package gui.energetskisistem;

public class Baterija {

	private int kolEnergije,kapacitet;
	
	public Baterija(int kap) {
		this.kapacitet=kap;
		this.kolEnergije=this.kapacitet;
	}
	
	public void dodajEnergiju(int x) {
		if(this.kolEnergije+x>this.kapacitet) {
			this.kolEnergije=this.kapacitet;
		}
		else {this.kolEnergije+=x;}
	}
	
	public void isprazniBateriju() {
		this.kolEnergije=0;
	}
	
	public boolean JePuna() {
		if(this.kolEnergije==this.kapacitet) return true;
		return false;
	}
	
}

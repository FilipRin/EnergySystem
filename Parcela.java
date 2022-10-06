package gui.energetskisistem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Parcela extends Label {

	int id;
	private static int br=0;
	protected char oznaka;
	protected Color pozadinskaBoja;
	public Plac roditelj;
	protected boolean izabrana=false;
	
	public Parcela(char o,Color bgc) {
		this.id=this.br;
		this.br++;
		this.oznaka=o;
		this.pozadinskaBoja=bgc;
		populateWindow();
		this.revalidate();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Parcela.this.izabrana=true;
				if(roditelj!=null) {
					roditelj.PoslednjaKliknutaParcela(Parcela.this);
				}
				for(Parcela p:Parcela.this.roditelj.Povrsi) {
					p.setFont(new Font(Font.SERIF, Font.BOLD, 14));
				}
				Parcela.this.setFont(new Font(Font.SERIF, Font.BOLD, 20));
			}
		});
		this.setVisible(true);
	}

	public void PromeniPozadinskuBoju(Color c) {
		this.pozadinskaBoja=c;
	}
	
	public abstract void populateWindow() ;

	public void dodajRoditelja(Plac p) {
		this.roditelj=p;
	}
	
	protected abstract void dodajVelicinu();
	
	
}

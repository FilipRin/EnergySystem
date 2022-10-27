package gui.energetskisistem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;

public class VodenaPovrs extends Parcela {

	int velicina;
	
	public VodenaPovrs(char o, Color bgc) {
		super('~', Color.CYAN);
		
		populateWindow();
	}
	
	public void proslediVel(int x) {
		this.velicina=x;
	}
	
	@Override
	public void populateWindow() {
		
		this.setBackground(pozadinskaBoja);
		this.setAlignment(Label.CENTER);
		Font font=new Font(Font.SERIF, Font.BOLD, 14);
		this.setFont(font);
		this.setForeground(Color.WHITE);
		this.setText("~");
		
	}
	
	public void dodajVelicinu() {
		this.setPreferredSize(new Dimension(500/this.roditelj.kolone,380/this.roditelj.redovi));
	}
	

}

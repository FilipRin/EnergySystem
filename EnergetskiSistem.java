package gui.energetskisistem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame {

	private Baterija baterija;
	private Plac plac;
	Hidroelektrana h;
	
	
	public EnergetskiSistem(int red,int kol,int kap) {
		
		setBounds(700, 200,500,500);
		setResizable(false);
		setTitle("Energetski sistem");
		setSize(500,500);
		
		this.plac=new Plac(red,kol);
		this.baterija=new Baterija(kap);
		
		populateWindow();
		this.revalidate();
		pack();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				for(Parcela p: plac.Povrsi ) {
					if(p instanceof Hidroelektrana || p instanceof Proizvodjac) {
						if(((Hidroelektrana) p).nit!=null)
						((Hidroelektrana) p).nit.interrupt();
					}
				}
				dispose();
			}
		});
		setVisible(true);
	}
	
	private void populateWindow() {
		
		Button dugme=new Button("Dodaj");
		Panel gornji=new Panel();
		GridLayout layout = new GridLayout(0, 1);
		layout.setHgap(0);
		layout.setVgap(0);
		Panel pom=new Panel();
		
		dugme.addActionListener((ae)->{
			if(plac.poslKliknut==null) {}
			else {
			for(int i=0;i<plac.Povrsi.size();i++) {
				if(plac.Povrsi.get(i).id==plac.poslKliknut.id) {
					//Hidroelektrana pro= new Hidroelektrana('H', Color.BLUE, 1500, baterija);
					//plac.Povrsi.set(i, pro);
					plac.NapraviHidro(plac.Povrsi.get(i),i, baterija);
					h=(Hidroelektrana) plac.Povrsi.get(i);
					
					if(h.nit!=null) {h.nit.interrupt();}
					
					h.nit=new Thread(h);
					h.nit.start();
					h.pokreni();
					break;
				}
			}
			
			//System.out.println(plac.Povrsi);
			}
		});
		gornji.add(dugme);
		add(gornji,BorderLayout.NORTH);
				
		pom.add(plac);
		add(pom,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new EnergetskiSistem(5,5,10);
	}

}

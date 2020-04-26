package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Point;
import modele.Trait;

public class VueDessin extends JPanel implements Observer
{

	/**
	 * Modele en cours
	 */
	private DessinModele model;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// Fond blanc
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		if (this.model != null) {

			// Affiche figure
			for (FigureColoree fc : this.model.getLfg()) {
				fc.affiche(g);
			}

			// Affiche traits
			for (Trait t : this.model.getTraits()) {
				t.affiche(g);
			}

			// Affiche les points
			if (this.model.getFigureEnCours() != null) {
				g.setColor(this.model.getFigureEnCours().getCouleur());
				for (Point points : model.getPoints_cliques()) {
					points.affiche(g);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable obs, Object o)
	{
		this.model = (DessinModele) obs;
		this.repaint();
	}

}

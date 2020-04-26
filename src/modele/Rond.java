package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Rond extends FigureColoree
{

	/**
	 * Cercle courant
	 */
	protected Ellipse2D cercle;

	/**
	 * Construteur
	 */
	public Rond()
	{
		super();
		this.cercle = new Ellipse2D.Double();
		this.tab_mem = new Point[this.nbPoints()];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.FigureColoree#nbPoints()
	 */
	@Override
	public int nbPoints()
	{
		return 2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.FigureColoree#estDedans(int, int)
	 */
	@Override
	public boolean estDedans(int x, int y)
	{
		return this.cercle.contains(x, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.FigureColoree#affiche(java.awt.Graphics)
	 */
	@Override
	public void affiche(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		g.setColor(this.couleur);
		g2.fill(this.cercle); // Dessine le cercle

		if (this.selected) { // S'il est selectionne

			final int t = this.TAILLE_CARRE_SELECTION;

			int rayon = (int) (this.cercle.getWidth() / 2);
			Point tab0 = this.tab_mem[0];

			// Affiche les 4 points
			g.fillRect(tab0.getX() + rayon, tab0.getY(), t, t);
			g.fillRect(tab0.getX() - rayon - t, tab0.getY(), t, t);
			g.fillRect(tab0.getX(), tab0.getY() + rayon, t, t);
			g.fillRect(tab0.getX(), tab0.getY() - rayon - t, t, t);

			// Dessine le contour
			g.setColor(Color.black);
			g2.draw(this.cercle);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.FigureColoree#modifierPoints(java.util.ArrayList)
	 */
	@Override
	public void modifierPoints(ArrayList<Point> points)
	{
		Point point0 = points.get(0);
		Point point1 = points.get(1);

		int rayon = (int) point0.distance(point1);
		int diametre = rayon * 2;

		this.cercle.setFrame(point0.getX() - rayon, point0.getY() - rayon, diametre, diametre);
		this.tab_mem[0] = point0;
		this.tab_mem[1] = point1;
	}

}

package modele;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Polygone extends FigureColoree
{
	/**
	 * Polygone courant
	 */
	protected Polygon polygone;

	/**
	 * Nombre de points
	 */
	private int nbPoints;

	/**
	 * Construteur
	 */
	public Polygone(int nbPoints)
	{
		super();

		this.tab_mem = new Point[nbPoints];
		this.nbPoints = nbPoints;

		this.polygone = new Polygon();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.FigureColoree#affiche(java.awt.Graphics)
	 */
	@Override
	public void affiche(Graphics g)
	{
		g.setColor(this.couleur);
		g.fillPolygon(this.polygone);

		if (this.selected) { // Dessine les points
			g.setColor(this.couleur);
			g.drawPolygon(this.polygone);

			for (int i = 0; i < this.polygone.npoints; i++) {
				g.setColor(this.getCouleur());

				// Les points:
				final int t = this.TAILLE_CARRE_SELECTION;
				int pointX = this.polygone.xpoints[i] - (t / 2);
				int pointY = this.polygone.ypoints[i] - (t / 2);

				g.fillRect(pointX, pointY, t, t);
			}
		}
	}

	/**
	 * @return Le nombre de clics
	 */
	public int nbClics()
	{
		return this.nbPoints();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.FigureColoree#modifierPoints(java.util.ArrayList)
	 */
	@Override
	public void modifierPoints(ArrayList<Point> points)
	{
		this.polygone = new Polygon();

		// Pour chaque point:
		for (int i = 0; i < points.size(); i++) {
			Point pointCourant = points.get(i);

			this.polygone.addPoint(pointCourant.getX(), pointCourant.getY());
			this.tab_mem[i] = points.get(i);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.FigureColoree#estDedans(int, int)
	 */
	@Override
	public boolean estDedans(int x, int y)
	{
		return this.polygone.contains(x, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.FigureColoree#nbPoints()
	 */
	@Override
	public int nbPoints()
	{
		return this.nbPoints;
	}

}

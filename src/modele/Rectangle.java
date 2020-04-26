package modele;

import java.awt.Polygon;
import java.util.ArrayList;

public class Rectangle extends Polygone
{

	/**
	 * Construteur
	 */
	public Rectangle()
	{
		super(2);
		this.tab_mem = new Point[this.nbPoints()]; // 2 points
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.Quadrilatere#nbPoints()
	 */
	@Override
	public int nbPoints()
	{
		return 2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.Polygone#modifierPoints(java.util.ArrayList)
	 */
	@Override
	public void modifierPoints(ArrayList<Point> points)
	{
		this.polygone = new Polygon();

		// Ajoute les points dans l'ordre
		Point point0 = points.get(0);
		Point point1 = points.get(1);

		polygone.addPoint(point0.getX(), point0.getY());
		polygone.addPoint(point0.getX(), point1.getY());
		polygone.addPoint(point1.getX(), point1.getY());
		polygone.addPoint(point1.getX(), point0.getY());

		// Ajoute les points en memoire
		this.tab_mem[0] = point0;
		this.tab_mem[1] = point1;
	}

}

package modele;

import java.awt.Graphics;

public class Point
{
	/**
	 * Abscisse du point
	 */
	private int x;
	/**
	 * Ordonnee du point
	 */
	private int y;

	/**
	 * Constructeur
	 * 
	 * @param x
	 *            Abscisse du point
	 * @param y
	 *            Ordonnee du point
	 */
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Calcule la distance entre 2 points
	 * 
	 * @param point
	 *            Autre point
	 * @return La distance
	 */
	public double distance(Point point)
	{
		double p1 = (point.x - this.x) * (point.x - this.x);
		double p2 = (point.y - this.y) * (point.y - this.y);

		return Math.sqrt(p1 + p2);
	}

	/**
	 * Recupere X
	 * 
	 * @return X
	 */
	public int rendreX()
	{
		return this.x;
	}

	/**
	 * Recupere Y
	 * 
	 * @return Y
	 */
	public int rendreY()
	{
		return this.y;
	}

	/**
	 * Incremente X
	 * 
	 * @param i
	 *            Incrementation
	 */
	public void incrementerX(int i)
	{
		this.x += i;
	}

	/**
	 * Incremente Y
	 * 
	 * @param i
	 *            Incrementation
	 */
	public void incrementerY(int i)
	{
		this.y += i;
	}

	/**
	 * Modifie X
	 * 
	 * @param i
	 *            Incrementation
	 */
	public void modifierX(int i)
	{
		this.x = i;
	}

	/**
	 * Modifie Y
	 * 
	 * @param i
	 *            Incrementation
	 */
	public void modifierY(int i)
	{
		this.y = i;
	}

	/**
	 * Translate le point
	 * 
	 * @param dx
	 *            Abscisse
	 * @param dy
	 *            Ordonnee
	 */
	public void translation(int dx, int dy)
	{
		this.x += dx;
		this.y += dy;
	}

	/**
	 * @return X
	 */
	public int getX()
	{
		return this.x;
	}

	/**
	 * @return Y
	 */
	public int getY()
	{
		return this.y;
	}

	/**
	 * Affiche le point
	 * 
	 * @param g
	 *            Composant graphique
	 */
	public void affiche(Graphics g)
	{
		final int taille = FigureColoree.TAILLE_CARRE_SELECTION;
		g.fillRect(this.getX() - (taille / 2), this.getY() - (taille / 2), taille, taille);
	}
}

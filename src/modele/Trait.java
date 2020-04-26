package modele;

import java.awt.Color;
import java.awt.Graphics;

public class Trait
{

	/**
	 * Ancien X
	 */
	private int ancienX;
	/**
	 * Ancien Y
	 */
	private int ancienY;
	/**
	 * Nouveau X
	 */
	private int nouveauX;
	/**
	 * Nouveau Y
	 */
	private int nouveauY;
	/**
	 * La couleur
	 */
	private Color couleur;

	/**
	 * @param x1
	 *            Ancien X
	 * @param y1
	 *            Ancien Y
	 * @param x2
	 *            Nouveau X
	 * @param y2
	 *            Nouveau Y
	 * @param couleur
	 *            La couleur du trait
	 */
	public Trait(int x1, int y1, int x2, int y2, Color couleur)
	{
		this.ancienX = x1;
		this.nouveauX = x2;
		this.ancienY = y1;
		this.nouveauY = y2;
		this.couleur = couleur;
	}

	/**
	 * @return Nouveau X
	 */
	public int getAncienX()
	{
		return ancienX;
	}

	/**
	 * @return Ancien Y
	 */
	public int getAncienY()
	{
		return ancienY;
	}

	/**
	 * @return Nouveau X
	 */
	public int getNouveauX()
	{
		return nouveauX;
	}

	/**
	 * @return Nouveau Y
	 */
	public int getNouveauY()
	{
		return nouveauY;
	}

	/**
	 * @return La couleur
	 */
	public Color getCouleur()
	{
		return couleur;
	}

	/**
	 * Affiche le trait
	 * 
	 * @param g
	 *            Composant graphique
	 */
	public void affiche(Graphics g)
	{
		g.setColor(this.getCouleur());
		g.drawLine(this.getAncienX(), this.getAncienY(), this.getNouveauX(), this.getNouveauY());
	}
}

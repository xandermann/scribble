package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class FigureColoree
{

	/**
	 * Taille du carre
	 */
	public final static int TAILLE_CARRE_SELECTION = 6;
	/**
	 * Savoir si la figure est selectionnee
	 */
	protected boolean selected;
	/**
	 * La couleur de la figure
	 */
	protected Color couleur;
	/**
	 * La liste de point
	 */
	protected Point[] tab_mem;

	/**
	 * Constructeur
	 */
	public FigureColoree()
	{
		this.couleur = Color.black;
		this.selected = false;
		this.tab_mem = new Point[0];
	}

	/**
	 * @return Le nombre de points
	 */
	public abstract int nbPoints();

	/**
	 * Modifie un point
	 * 
	 * @param points_cliques
	 *            Point pour definir la figure
	 */
	public abstract void modifierPoints(ArrayList<Point> points_cliques);

	/**
	 * Affiche la figure
	 * 
	 * @param g
	 *            Graphics
	 */
	public abstract void affiche(Graphics g);

	/**
	 * Selectionne la figure ou deselectionne
	 */
	public void selectionne()
	{
		this.selected = true;
	}

	public void deSelectionne()
	{
		this.selected = false;
	}

	/**
	 * Change la couleur
	 * 
	 * @param c
	 *            Couleur courante
	 */
	public void changCouleur(Color c)
	{
		this.couleur = c;
	}

	/**
	 * Recupere la couleur
	 * 
	 * @return Couleur de la figure
	 */
	public Color getCouleur()
	{
		return this.couleur;
	}

	/**
	 * @param x
	 *            X
	 * @param y
	 *            Y
	 * @return Si la figure est dedans
	 */
	public abstract boolean estDedans(int x, int y);

	/**
	 * Translate la figure
	 * 
	 * @param x
	 *            X
	 * @param y
	 *            Y
	 */
	public void translation(int x, int y)
	{
		for (Point point : this.tab_mem) {
			point.translation(x, y);
		}
	}

}

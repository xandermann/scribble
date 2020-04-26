package modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class DessinModele extends Observable
{

	/**
	 * Nombre de clique de la souris
	 */
	private int nbClic;
	/**
	 * Tableau de point cliques
	 */
	private ArrayList<Point> points_cliques;
	/**
	 * Figure en cours
	 */
	private FigureColoree figureEnCours;
	/**
	 * Liste de toutes les figures
	 */
	private ArrayList<FigureColoree> lfg;
	/**
	 * Couleur actuelle
	 */
	private Color couleur;

	/**
	 * Constructeur du modele DessinModele
	 */
	public DessinModele()
	{
		this.lfg = new ArrayList<FigureColoree>();
		this.points_cliques = new ArrayList<Point>();
		this.traits = new ArrayList<Trait>();

		this.figureEnCours = null;
		this.couleur = null;

		this.action = 0;
		this.nbClic = 0;
	}

	/**
	 * Ajoute une figureColoree
	 * 
	 * @param fc
	 *            Figure Coloree
	 */
	public void ajoute(FigureColoree fc)
	{
		this.lfg.add(fc);
	}

	/**
	 * Change la couleur de la figure
	 * 
	 * @param fc
	 *            Figure choisie
	 * @param color
	 *            Couleur choisie
	 */
	public void changeCoul(FigureColoree fc, Color color)
	{
		fc.changCouleur(color);
		this.couleur = color;

		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Defini la couleur
	 * 
	 * @param c
	 *            la couleur
	 */
	public void setCouleur(Color c)
	{
		this.couleur = c;
	}

	/**
	 * Construit la figure
	 * 
	 * @param fc
	 *            Figure choisie
	 */
	public void construit(FigureColoree fc)
	{
		this.points_cliques = new ArrayList<Point>();

		this.figureEnCours = fc;

		this.nbClic = 0;
		this.action = 0;
	}

	/**
	 * Ajoute un point
	 * 
	 * @param x
	 *            Les abscisses
	 * @param y
	 *            Les ordonnees
	 */
	public void ajoutePt(int x, int y)
	{

		// On ajoute un point
		this.points_cliques.add(new Point(x, y));

		// Change le clic, ajoute et reste pour la prochaine figure
		this.nbClic++;
		if (this.nbClic == this.figureEnCours.nbPoints()) {
			this.nbClic = 0; // Reset le clic

			this.figureEnCours.modifierPoints(this.points_cliques); // Modifie les points
			this.points_cliques = new ArrayList<Point>(); // Creer un nouveau ArrayList
			this.lfg.add(this.figureEnCours); // Ajoute la figure
		}

		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Recupere les clics
	 * 
	 * @return les clics
	 */
	public int getNbClic()
	{
		return this.nbClic;
	}

	/**
	 * Defini les clics
	 * 
	 * @param c
	 *            les clics
	 */
	public void setNbClic(int c)
	{
		this.nbClic += c;
	}

	/**
	 * Recupere la liste des figures
	 * 
	 * @return lfg
	 */
	public ArrayList<FigureColoree> getLfg()
	{
		return this.lfg;
	}

	/**
	 * Recupere les figures en cours
	 * 
	 * @return Les figures en cours
	 */
	public FigureColoree getFigureEnCours()
	{
		return this.figureEnCours;
	}

	/**
	 * Defini la figure en cours
	 * 
	 * @param figure
	 *            Figure en cours
	 */
	public void setFigureEnCours(FigureColoree figure)
	{
		this.figureEnCours = figure;
	}

	public void setLfg(ArrayList<FigureColoree> fc)
	{
		this.lfg = fc;
	}

	// MANIPULATION

	/**
	 * ID de l'action
	 */
	private int action;

	/**
	 * @return L'action
	 */
	public int getAction()
	{
		return this.action;
	}

	public boolean estSelectionnee()
	{
		return this.figureEnCours.selected;
	}

	/**
	 * Selectionne la figure
	 * 
	 * @param fc
	 *            La figure
	 */
	public void selectionne(FigureColoree fc)
	{
		fc.selectionne();
		this.setFigureEnCours(fc);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Deselectionne
	 * 
	 * @param fc
	 *            La figure
	 */
	public void deSelectionne(FigureColoree fc)
	{
		fc.deSelectionne();
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Change l'action
	 * 
	 * @param i
	 */
	public void setAction(int i)
	{
		this.action = i;
	}

	/**
	 * Translate la figure
	 * 
	 * @param figureEnCours
	 *            La figure en cours
	 * @param x
	 *            X
	 * @param y
	 *            Y
	 */
	public void translationFigureEnCours(int x, int y)
	{
		this.figureEnCours.translation(x, y);

		// Transforme en ArrayList pour cette fonction
		this.figureEnCours.modifierPoints(new ArrayList<Point>(Arrays.asList(this.figureEnCours.tab_mem)));

		setChanged();
		notifyObservers();

	}

	// TRAITS

	/**
	 * Liste des traits
	 */
	private ArrayList<Trait> traits;

	/**
	 * @return Les traits
	 */
	public ArrayList<Trait> getTraits()
	{
		return this.traits;
	}

	/**
	 * Dessine le trait
	 * 
	 * @param x1
	 *            Ancien X
	 * @param y1
	 *            Ancien Y
	 * @param x2
	 *            Nouveau X
	 * @param y2
	 *            Nouveau Y
	 */
	public void dessineTrait(int x1, int y1, int x2, int y2)
	{
		this.traits.add(new Trait(x1, y1, x2, y2, this.couleur));

		setChanged();
		notifyObservers();

	}

	/**
	 * @return Les points cliques
	 */
	public ArrayList<Point> getPoints_cliques()
	{
		return this.points_cliques;
	}

}

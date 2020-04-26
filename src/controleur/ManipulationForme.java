package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import modele.DessinModele;
import modele.FigureColoree;

public class ManipulationForme implements MouseListener, MouseMotionListener
{

	/**
	 * Modele courant
	 */
	private DessinModele modele;

	/**
	 * Ancien X
	 */
	private int ancienX;
	/**
	 * Ancien Y
	 */
	private int ancienY;

	/**
	 * Constructeur
	 * 
	 * @param m
	 *            Modele en cours
	 */
	public ManipulationForme(DessinModele m)
	{
		this.modele = m;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{

		// Si action est bonne et clique gauche
		if (this.modele.getAction() == PanneauChoix.MANIPULATION && SwingUtilities.isLeftMouseButton(e)) {

			// On cree une liste
			ArrayList<FigureColoree> listeFigureSelectionnee = new ArrayList<FigureColoree>();

			// Pour chaque figure, on teste les coordonnees, si elles sont ok on ajoute a la
			// liste
			for (int i = 0; i < this.modele.getLfg().size(); i++) {
				FigureColoree figureCourante = this.modele.getLfg().get(i);

				if (figureCourante.estDedans(e.getX(), e.getY())) {
					listeFigureSelectionnee.add(figureCourante);
				}
			}

			// Si la liste n'est pas vide on effecture des operations
			if (listeFigureSelectionnee.size() != 0) {
				FigureColoree figureSelectionnee = listeFigureSelectionnee.get(listeFigureSelectionnee.size() - 1);
				this.passeAu1erPlan(figureSelectionnee);
				this.selectionneFigure(figureSelectionnee);
				this.modele.setFigureEnCours(figureSelectionnee);
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		this.ancienX = e.getX();
		this.ancienY = e.getY();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		if (this.modele.getAction() == PanneauChoix.MANIPULATION && SwingUtilities.isLeftMouseButton(e)) {

			int cliqueCourantX = e.getX();
			int cliqueCourantY = e.getY();

			if (this.modele.getFigureEnCours() != null) { // Il y a une figure en cours
				if (this.modele.getFigureEnCours().estDedans(e.getX(), e.getY())) { // Le curseur est dedans

					if (this.modele.estSelectionnee()) {

						int diffX = cliqueCourantX - this.ancienX;
						int diffY = cliqueCourantY - this.ancienY;

						this.modele.translationFigureEnCours(diffX, diffY);

						// Puis on ajuste les cliques
						this.ancienX = cliqueCourantX;
						this.ancienY = cliqueCourantY;
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * Passe la figure au premier plan
	 * 
	 * @param figure
	 *            Figure en cours
	 */
	public void passeAu1erPlan(FigureColoree figure)
	{
		this.modele.getLfg().remove(figure);
		this.modele.getLfg().add(figure);
	}

	/**
	 * Deselectionne tout
	 * 
	 * @param figure
	 *            Figure en cours
	 */
	public void selectionneFigure(FigureColoree figure)
	{
		this.modele.selectionne(figure);
		for (FigureColoree figureColoree : this.modele.getLfg()) {
			if (figureColoree != figure) {
				this.modele.deSelectionne(figureColoree);
			}
		}
	}

}

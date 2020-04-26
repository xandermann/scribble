package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import modele.DessinModele;

public class Traceur implements MouseListener, MouseMotionListener
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
	 * Modele courant
	 */
	private DessinModele modele;

	/**
	 * Constructeur
	 * 
	 * @param m
	 *            Modele courant
	 */
	public Traceur(DessinModele m)
	{
		this.modele = m;
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
		if (this.modele.getAction() == PanneauChoix.MAIN_LEVE) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				int avantX = e.getX();
				int avantY = e.getY();
				this.modele.dessineTrait(avantX, avantY, ancienX, ancienY);
				this.ancienX = avantX;
				this.ancienY = avantY;
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
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0)
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
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		if (modele.getAction() == PanneauChoix.MAIN_LEVE) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				ancienX = e.getX();
				ancienY = e.getY();
			}
		}

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

}

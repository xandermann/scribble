package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import controleur.FabriquantFigures;
import controleur.ManipulationForme;
import controleur.PanneauChoix;
import controleur.Traceur;
import modele.DessinModele;
import vue.VueDessin;

public class Fenetre
{

	/**
	 * Creer une fenetre pour l'application
	 * 
	 * @param titre
	 *            Titre de la fenetre
	 * @param largeur
	 *            Largeur de la fenetre
	 * @param hauteur
	 *            Hauteur de la fenetre
	 */
	public Fenetre(String titre, int largeur, int hauteur)
	{

		// Objets:
		JFrame frame = new JFrame(titre);

		// Modeles
		DessinModele dessinModele = new DessinModele();

		// Vues
		VueDessin vueDessin = new VueDessin();

		// Controlleurs
		FabriquantFigures fabriquantFigures = new FabriquantFigures(dessinModele);
		PanneauChoix panneauChoix = new PanneauChoix(dessinModele);
		ManipulationForme manipulationForme = new ManipulationForme(dessinModele);
		Traceur traceur = new Traceur(dessinModele);

		// Ajouts
		dessinModele.addObserver(vueDessin);

		vueDessin.addMouseListener(fabriquantFigures);
		vueDessin.addMouseListener(manipulationForme);
		vueDessin.addMouseMotionListener(manipulationForme);

		vueDessin.addMouseListener(traceur);
		vueDessin.addMouseMotionListener(traceur);

		vueDessin.setPreferredSize(new Dimension(largeur, hauteur));

		// Ajoute a la fenetre
		frame.setSize(new Dimension(largeur, hauteur));
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panneauChoix, BorderLayout.NORTH);
		frame.getContentPane().add(vueDessin, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Le main de l'application
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Fenetre f = new Fenetre("SCRIBBLE MVC PROJET - hublau2u", 800, 800);
	}

}

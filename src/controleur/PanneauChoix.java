package controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Polygone;
import modele.Rectangle;
import modele.Rond;

/**
 * Menu de l'application
 */
public class PanneauChoix extends JPanel
{

	/**
	 * Constante pour la nouvelle figure
	 */
	public static final int NOUVELLE_FIGURE = 0;
	/**
	 * Constante pour la main leve
	 */
	public static final int MAIN_LEVE = 1;
	/**
	 * Constante pour la manipulation
	 */
	public static final int MANIPULATION = 2;

	/**
	 * Modele qui contient les dessins
	 */
	private DessinModele dessinModele;

	/**
	 * Figure Coloree en cours de modification
	 */
	private FigureColoree figureColoree;

	/**
	 * Constructeur de la classe
	 * 
	 * @param dessin
	 *            Modele
	 */
	public PanneauChoix(DessinModele dessin)
	{
		this.dessinModele = dessin;
		this.setLayout(new BorderLayout());

		JPanel haut = new JPanel();
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton nouvelleFigure = new JRadioButton("Nouvelle figure");
		JRadioButton mainLevee = new JRadioButton("Trace a main levee");
		JRadioButton manipulation = new JRadioButton("Manipulations");

		buttonGroup.add(nouvelleFigure);
		buttonGroup.add(mainLevee);
		buttonGroup.add(manipulation);

		haut.add(nouvelleFigure);
		haut.add(mainLevee);
		haut.add(manipulation);

		// LE BAS:
		JPanel bas = new JPanel();

		String[] figures =
		{ "Quadriletere", "Triangle", "Rectangle", "Rond", "5", "6", "7", "8", "9", "10", "11", "12" };
		JComboBox<String> JCfigures = new JComboBox<String>(figures);
		JCfigures.setMaximumRowCount(figures.length);

		bas.add(JCfigures);

		String[] couleurs =
		{ "Noir", "Rouge", "Vert", "Bleu", "Jaune", "Gris", "Magenta", "Rose", "Aleatoire" };
		JComboBox<String> JCcouleurs = new JComboBox<String>(couleurs);
		JCcouleurs.setMaximumRowCount(couleurs.length);

		bas.add(JCcouleurs);

		// AJOUT
		this.add(haut, BorderLayout.NORTH);
		this.add(bas, BorderLayout.CENTER);

		// LISTENER HAUT
		nouvelleFigure.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JCfigures.setEnabled(true);
				JCcouleurs.setEnabled(true);

				nouvelleFigure.setSelected(true);
				figureColoree = creerFigure(JCfigures.getSelectedIndex());
				figureColoree.changCouleur(determineCouleur(JCcouleurs.getSelectedIndex()));
				dessinModele.construit(figureColoree);
			}
		});
		mainLevee.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JCfigures.setEnabled(false);
				JCcouleurs.setEnabled(true);

				dessinModele.setCouleur(determineCouleur(JCcouleurs.getSelectedIndex()));
				figureColoree = creerFigure(JCfigures.getSelectedIndex());
				figureColoree.changCouleur(determineCouleur(JCcouleurs.getSelectedIndex()));
				dessinModele.construit(figureColoree);

				dessinModele.setAction(PanneauChoix.MAIN_LEVE);
			}
		});
		manipulation.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JCfigures.setEnabled(false);
				JCcouleurs.setEnabled(false);

				dessinModele.setAction(PanneauChoix.MANIPULATION);
			}
		});

		// LISTENER BAS
		JCfigures.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				FigureColoree fc = PanneauChoix.this.creerFigure(JCfigures.getSelectedIndex());
				PanneauChoix.this.dessinModele.construit(fc);
			}
		});

		JCcouleurs.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Color c = PanneauChoix.this.determineCouleur(JCcouleurs.getSelectedIndex());
				dessinModele.changeCoul(dessinModele.getFigureEnCours(), c);
			}
		});

		// DEBUT, PAR DEFAUT
		nouvelleFigure.setSelected(true);
		this.figureColoree = this.creerFigure(JCfigures.getSelectedIndex());
		this.figureColoree.changCouleur(this.determineCouleur(JCcouleurs.getSelectedIndex()));
		this.dessinModele.construit(figureColoree);

	}

	/**
	 * @param idFig
	 *            ID de la figure
	 * @return La figure selectionnee
	 */
	private FigureColoree creerFigure(int idFig)
	{
		FigureColoree fig;

		switch (idFig)
		{
			case 0:
				// fig = new Quadrilatere();
				fig = new Polygone(4);
				break;

			case 1:
				// fig = new Triangle();
				fig = new Polygone(3);
				break;

			case 2:
				fig = new Rectangle();
				break;

			case 3:
				fig = new Rond();
				break;

			case 4:
				fig = new Polygone(5);
				break;

			case 5:
				fig = new Polygone(6);
				break;

			case 6:
				fig = new Polygone(7);
				break;

			case 7:
				fig = new Polygone(8);
				break;

			case 8:
				fig = new Polygone(9);
				break;

			case 9:
				fig = new Polygone(10);
				break;

			case 10:
				fig = new Polygone(11);
				break;

			case 11:
				fig = new Polygone(12);
				break;

			default:
				fig = new Polygone(4);
				break;
		}

		return fig;
	}

	/**
	 * @param idCouleur
	 *            ID de la couleur
	 * @return La couleur selectionnee
	 */
	private Color determineCouleur(int idCouleur)
	{
		Color col;

		switch (idCouleur)
		{
			case 0:
				col = Color.BLACK;
				break;
			case 1:
				col = Color.RED;
				break;
			case 2:
				col = Color.GREEN;
				break;
			case 3:
				col = Color.BLUE;
				break;
			case 4:
				col = Color.YELLOW;
				break;
			case 5:
				col = Color.GRAY;
				break;
			case 6:
				col = Color.MAGENTA;
				break;
			case 7:
				col = Color.PINK;
				break;
			case 8:
				Random rand = new Random();
				col = new Color(rand.nextInt(0xFFFFFF));
				break;

			default:
				col = Color.BLACK;
				break;
		}

		return col;
	}

}

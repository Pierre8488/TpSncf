package tpsncf;

import java.util.Scanner;

import domain.Train;

import java.util.Date;

import service.CarteReductionService;
import service.Connexion;
import service.EtapeService;
import service.GareService;
import service.TrainService;


public class Sncf {

	private Scanner scan;
	private Connexion connexion;
	private GareService gareService;
	private TrainService trainService;
	private EtapeService etapeService;
	private CarteReductionService carteReductionService;

	public Sncf() {
		this.scan = new Scanner(System.in);
		this.connexion = new Connexion();
		this.gareService = new GareService();
		this.trainService = new TrainService();
		this.carteReductionService = new CarteReductionService();
		this.etapeService = new EtapeService();
		this.connexion.initConnexion();
		this.connexion.initSchema();
		this.gareService.initDefaultValue(this.connexion.getConn());
		this.carteReductionService.initDefaultValue(this.connexion.getConn());
		this.trainService.initDefaultValue(this.connexion.getConn());
		this.etapeService.initDefaultValue(this.connexion.getConn());
	}

	public void mainMenu() {
		while (true) {
			System.out.println(
					"Menu SNCF:\n 1 - Gestion des trains \n 2 - Gestion des réservations\n 3 - Gestion des gares\n 9 - Quitter\n");
			int chx = scan.nextInt();
			switch (chx) {
			case 1:
				trainMenu();
				break;
			case 2:

				break;
			case 3:
				gareMenu();
				break;
			case 9:
				scan.close();
				this.connexion.deconnexion();
				return;
			}
		}
	}

	private void trainMenu() {
		while (true) {
			System.out.println(
					"Gestion des trains:\n 1 - Creation d'un train \n 2 - Suppression d'un train \n 3 - Affichage des trains \n 4 - Retour\n");
			int chx1 = scan.nextInt();
			switch (chx1) {
			case 1:
				System.out.println("Creation d'un train");
				System.out.println("Nouvelle gare de départ :" );
				long chx2 = scan.nextInt();
				
				System.out.println("Nouvelle date de départ (AAAA,MM,JJ):" );
				int annee=  scan.nextInt();
				int mois=scan.nextInt();
				int jour=scan.nextInt();
				Date chx3 = new Date(annee,mois,jour);
				
				System.out.println("Nouveau numéro de train :" );
				String chx4 = scan.next();
				
				System.out.println("Nombre de place du nouveau train :" );
				int chx5 = scan.nextInt();
				
				System.out.println("Type du nouveau train (TGV ou TER):" );
				String chx6 = scan.next();
				
				Train train = new Train(chx2, chx3, chx4, chx5, chx6);
				
				trainService.CreateTrain(connexion.getConn(),train);
				
				break;
			case 2:
				System.out.println("Suppression d'un train");
				long id = scan.nextLong();
				etapeService.deleteEtapeOfTrain(this.connexion.getConn(), id);
				trainService.deleteTrain(this.connexion.getConn(), id);
				break;
			case 3:
				System.out.println("liste train");
				trainService.getAllTrain(this.connexion.getConn()).stream()
				.forEach(t -> System.out.println(t.toString()));
				
				/*System.out.println("liste gare");
				gareService.getAllGare(this.connexion.getConn()).stream()
						.forEach(g -> System.out.println(g.toString()));
				break;*/
				
				break;
			case 4:
				return;
			}
		}
	}

	private void gareMenu() {
		while (true) {
			System.out.println(
					"Gestion des Gares:\n 1 - Creation d'une gare \n 2 - Suppression d'une gare \n 3 - Affichage des gares \n 4 - Retour\n");
			int chx1 = scan.nextInt();
			switch (chx1) {
			case 1:
				System.out.println("Creation d'une gare");
				break;
			case 2:
				System.out.println("Suppression d'un gare, Entrez son id : ");
				long id = scan.nextLong();
				gareService.deleteGare(this.connexion.getConn(), id);
				break;
			case 3:
				System.out.println("liste gare");
				gareService.getAllGare(this.connexion.getConn()).stream()
						.forEach(g -> System.out.println(g.toString()));
				break;
			case 4:
				return;
			}
		}
	}
}

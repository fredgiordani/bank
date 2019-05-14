package com.aston.bank;

import java.util.Hashtable;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main( String[] args )
	{
		System.out.println("--------------------------------------A---------------------------");
		Compte compte1  = new Compte(1,1000);
		Compte compte2  = new Compte(2,2000);
		Compte compte3  = new Compte(3,3000);
		Compte compte4  = new Compte(4,4000);
		Compte compte5  = new Compte(5,5000);
		Compte compte6  = new Compte(6,6000);

		compte1.ajouter(100);
		try {
			compte2.retirer(2500);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(compte1.toString());
		System.out.println(compte2.toString());

		System.out.println("--------------------------------------B---------------------------");

		//ArrayList<Compte> comptes1 = new ArrayList<Compte>();
		//ArrayList<Compte> comptes2 = new ArrayList<Compte>();
		Map<Integer, Compte> listeComptes = new Hashtable<Integer, Compte>();

		Client client1 = new Client("Giordani", "Fred", 1, 40);
		Client client2 = new Client("Giordani", "Fred", 1, 40);
		Client client3 = new Client("Giordano", "Frud", 2, 40, listeComptes );

		try {
			client1.ajouterCompte(compte1);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			client1.ajouterCompte(compte2);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			client1.ajouterCompte(compte3);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			client1.ajouterCompte(compte4);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			client1.ajouterCompte(compte5);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			client1.ajouterCompte(compte6);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		client3.getListeComptes().put(1, compte1);
		client3.getListeComptes().put(2, compte2);
		client3.getListeComptes().put(3, compte3);
		client3.getListeComptes().put(4, compte4);



		System.out.println("--------------------------------------C---------------------------");

		try {
			System.out.println(client1.getCompte(8).toString());
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("ce compte n'existe pas");

		}


		CompteRemuneree compte7  = new CompteRemuneree(7,1000,0.2);
		CompteRemuneree compte8  = new CompteRemuneree(8,3000, 0.3);
		CompteASeuil compte9  = new CompteASeuil(9,3000, 500);
		CompteASeuil compte10  = new CompteASeuil(10,3000, 1000);

		System.out.println(compte7.getClass());
		System.out.println(compte8 instanceof CompteRemuneree);

		if(compte8 instanceof CompteRemuneree) {
			System.out.println("le compte 8 est un compte remuneree");
		}


		try {
			client2.ajouterCompte(compte7);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			client2.ajouterCompte(compte8);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			client2.ajouterCompte(compte9);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			client2.ajouterCompte(compte10);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Compte compte : client2.getComptes()) {
			if(compte instanceof CompteRemuneree) {
				System.out.println(compte.toString());
				((CompteRemuneree) compte).verserInterets();
				System.err.println(compte.toString());
			}
		}

		CompteASeuilRemuneree compte11  = new CompteASeuilRemuneree(11,1000,0.2,200);
		CompteASeuilRemuneree compte12  = new CompteASeuilRemuneree(12,2000,0.3,500);
		CompteASeuilRemuneree compte13  = new CompteASeuilRemuneree(13,3000,0.2,600);
		CompteASeuilRemuneree compte14  = new CompteASeuilRemuneree(14,4000,0.2,1000);


		compte11.verserInterets();
		System.out.println(compte11.toString());
		compte11.retirer(1100);

	}
}

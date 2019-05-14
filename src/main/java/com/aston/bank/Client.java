package com.aston.bank;

import java.util.ArrayList;
import java.util.Map;

public class Client {

	private String nom;
	private String prenom;
	private int numero;
	private int age;
	private ArrayList<Compte> comptes;
	private Map<Integer, Compte> listeComptes;

	public Client(String nom, String prenom, int numero, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.age = age;
		this.comptes = new ArrayList<Compte>();
	}

	public Client(String nom, String prenom, int numero, int age, Map<Integer, Compte> listeComptes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.age = age;
		this.listeComptes = listeComptes;
	}

	public String getNom() {
		return this.nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return this.prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public int getNumero() {
		return this.numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public int getAge() {
		return this.age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public ArrayList<Compte> getComptes() {
		return this.comptes;
	}



	public void setComptes(ArrayList<Compte> comptes) {
		this.comptes = comptes;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [nom=");
		builder.append(this.nom);
		builder.append(", prenom=");
		builder.append(this.prenom);
		builder.append(", numero=");
		builder.append(this.numero);
		builder.append(", age=");
		builder.append(this.age);
		builder.append(", comptes=");
		builder.append(this.comptes);
		builder.append("]");
		return builder.toString();
	}

	public void ajouterCompte(Compte compte) throws BanqueException {

		if(this.comptes.size() <=5) {
			this.comptes.add(compte);
		}else {
			throw new BanqueException("vous ne pouvez pas ajouter de compte");
		}

	}

	public Compte getCompte(int numerocompte) {

		return this.comptes.get(numerocompte);

	}

	public Map<Integer, Compte> getListeComptes() {
		return this.listeComptes;
	}

	public void setListeComptes(Map<Integer, Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
}

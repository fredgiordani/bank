package com.aston.bank;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

public class Client {

	private int Id;
	private String nom;
	private String prenom;
	private boolean sex;
	Timestamp derniereConnection;
	Date dateDeNaissance;
	String adresse;
	int codePostal;
	String telephone;
	private int numero;
	private int age;
	private ArrayList<Compte> comptes;
	private Map<Integer, Compte> listeComptes;

	public Client(int Id, String nom, String prenom, boolean sex, Timestamp derniereConnection, Date dateDeNaissance, String adresse,int codePostal, String telephone) {
		super();
		this.setId(Id);
		this.nom = nom;
		this.prenom = prenom;
		this.setSex(sex);
		this.derniereConnection = derniereConnection;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.comptes = new ArrayList<Compte>();
	}

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

	public Timestamp getDerniereConnection() {
		return this.derniereConnection;
	}

	public void setDerniereConnection(Timestamp derniereConnection) {
		this.derniereConnection = derniereConnection;
	}

	public Date getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the sex
	 */
	public boolean isSex() {
		return this.sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.Id = id;
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
		builder.append("Client [Id=");
		builder.append(this.Id);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append(", prenom=");
		builder.append(this.prenom);
		builder.append(", sex=");
		builder.append(this.sex);
		builder.append(", derniereConnection=");
		builder.append(this.derniereConnection);
		builder.append(", dateDeNaissance=");
		builder.append(this.dateDeNaissance);
		builder.append(", adresse=");
		builder.append(this.adresse);
		builder.append(", codePostal=");
		builder.append(this.codePostal);
		builder.append(", telephone=");
		builder.append(this.telephone);
		builder.append(", numero=");
		builder.append(this.numero);
		builder.append(", age=");
		builder.append(this.age);
		builder.append(", comptes=");
		builder.append(this.comptes);
		builder.append(", listeComptes=");
		builder.append(this.listeComptes);
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

package com.aston.bank;

public class Compte {

	private int numero;
	protected double solde;

	public Compte(int numero, double solde) {
		this.numero = numero;
		this.solde = solde;
	}



	public int getNumero() {
		return this.numero;
	}



	private void setNumero(int numero) {
		this.numero = numero;
	}



	public double getSolde() {
		return this.solde;
	}



	protected void setSolde(double solde) {
		this.solde = solde;
	}



	public void ajouter(double montant) {
		this.solde += montant;
	}

	public void retirer(double montant) throws BanqueException {
		if(this.solde - montant < 0){
			throw new BanqueException("pas de decouvert autorisé");
		}else {
			this.solde -= montant;
		}
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [numero=");
		builder.append(this.numero);
		builder.append(", solde=");
		builder.append(this.solde);
		builder.append("]");
		return builder.toString();
	}


}

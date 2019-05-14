package com.aston.bank;

public class CompteASeuil extends Compte implements ICompteASeuil{

	private double seuil;

	public CompteASeuil(int numero, double solde, double seuil) {
		super(numero, solde);
		this.seuil = seuil;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompteASeuil [seuil=");
		builder.append(this.seuil);
		builder.append(", solde=");
		builder.append(this.solde);
		builder.append(", getNumero()=");
		builder.append(this.getNumero());
		builder.append(", getSolde()=");
		builder.append(this.getSolde());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append(", getClass()=");
		builder.append(this.getClass());
		builder.append(", hashCode()=");
		builder.append(this.hashCode());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void retirer(double montant) throws BanqueException {

		if((this.getSolde() - montant) < this.seuil) {
			throw new BanqueException("pas de decouvert autorisé");
		}else {
			this.setSolde(this.getSolde() - montant);
		}

	}

	@Override
	public double getSeuil() {
		// TODO Auto-generated method stub
		return this.seuil;
	}

	@Override
	public void setSeuil(double seuil) {
		// TODO Auto-generated method stub
		this.seuil = seuil;
	}


}


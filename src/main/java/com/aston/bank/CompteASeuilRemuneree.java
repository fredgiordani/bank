package com.aston.bank;

public class CompteASeuilRemuneree extends CompteRemuneree implements ICompteASeuil{

	private double seuil;

	public CompteASeuilRemuneree(int numero, double solde, double taux, double seuil) {
		super(numero, solde, taux);
		this.seuil = seuil;
	}

	@Override
	public double getSeuil() {
		// TODO Auto-generated method stub
		return this.seuil;
	}

	@Override
	public void setSeuil(double seuil) {
		this.seuil = seuil;

	}

	@Override
	public void retirer(double montant) {
		if((this.getSolde() - montant) > this.seuil) {
			this.setSolde(this.getSolde() - montant);
		}else {
			System.out.println("operation impossible");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompteASeuilRemuneree [seuil=");
		builder.append(this.seuil);
		builder.append(", solde=");
		builder.append(this.solde);
		builder.append(", getSeuil()=");
		builder.append(this.getSeuil());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append(", calculerInterets()=");
		builder.append(this.calculerInterets());
		builder.append(", getTaux()=");
		builder.append(this.getTaux());
		builder.append(", getNumero()=");
		builder.append(this.getNumero());
		builder.append(", getSolde()=");
		builder.append(this.getSolde());
		builder.append(", getClass()=");
		builder.append(this.getClass());
		builder.append(", hashCode()=");
		builder.append(this.hashCode());
		builder.append("]");
		return builder.toString();
	}


}

package com.aston.bank;

public class CompteRemuneree extends Compte implements ICompteremuneree{

	private double taux;

	public CompteRemuneree(int numero, double solde,double taux) {
		super(numero, solde);
		this.taux = taux;

		// TODO Auto-generated constructor stub
	}


	public CompteRemuneree(int numero, double solde) {
		super(numero, solde);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompteRemuneree [taux=");
		builder.append(this.taux);
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
	public double calculerInterets(){
		double interets;
		interets = this.taux * this.getSolde();
		return interets;

	}

	@Override
	public void verserInterets(){

		this.setSolde(this.solde + this.calculerInterets());


	}


	@Override
	public double getTaux() {
		// TODO Auto-generated method stub
		return this.taux;
	}


	@Override
	public void setTaux(double taux) {
		this.taux = taux;

	}





}

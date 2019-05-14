package com.aston.bank;

public interface ICompteASeuil {

	public void retirer(double montant) throws BanqueException;
	public double getSeuil();
	public void setSeuil(double seuil);

}

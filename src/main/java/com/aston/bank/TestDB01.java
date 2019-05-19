package com.aston.bank;

import java.sql.*;

public class TestDB01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // Nom du driver pour acceder a la base de donnees.
	    // Lire la documentation associee a sa base de donnees pour le connaitre
	    final String dbDriver = "com.mysql.cj.jdbc.Driver"; // Nom long d'une classe
	    // URL d'access a la base de donnees.
	    final String dbUrl = "jdbc:mysql://localhost/banque?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"; // banque est le nom de la base
	    // Login d'access a la base de donnees.
	    final String dbLogin = "root"; // Ou "SA" en HSQL
	    // Mot de passe d'access a la base de donnees.
	    final String dbPwd = ""; // Ou "" en HSQL

	    try {
			Class.forName(dbDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection connection = null;
		Statement request = null;
		ResultSet resultat = null;
		
		 try {
		      connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
		      request = connection.createStatement();
		      resultat = request.executeQuery("SELECT nom, prenom FROM `utilisateur` ");
		      
		      while (resultat.next()) {
		          String nom = resultat.getString("nom");
		          String prenom = resultat.getString("prenom");
		          System.out.println(nom + " " + prenom);
		        }} catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		          if (resultat != null) {
		            try {
		              resultat.close();
		            } catch (SQLException e) {
		              e.printStackTrace();
		            }
		          }
		          if (request != null) {
		            try {
		              request.close();
		            } catch (SQLException e) {
		              e.printStackTrace();
		            }
		          }
		          if (connection != null) {
		            try {
		              connection.close();
		            } catch (SQLException e) {
		              e.printStackTrace();
		            }
	}

}
	}
		 }

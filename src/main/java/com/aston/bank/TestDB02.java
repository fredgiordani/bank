package com.aston.bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

public class TestDB02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Nom du driver pour acceder a la base de donnees.
		// Lire la documentation associee a sa base de donnees pour le connaitre
		final String dbDriver = "com.mysql.cj.jdbc.Driver"; // Nom long d'une classe
		// URL d'access a la base de donnees.
		final String dbUrl = "jdbc:mysql://localhost/banque?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"; // banque
		// est
		// le
		// nom
		// de
		// la
		// base
		// Login d'access a la base de donnees.
		final String dbLogin = "root"; // Ou "SA" en HSQL
		// Mot de passe d'access a la base de donnees.
		final String dbPwd = ""; // Ou "" en HSQL

		try {
			Class.forName(dbDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ArrayList<Client> clients = new ArrayList<Client>();
		Connection connection = null;
		Statement request = null;
		ResultSet resultat = null;

		try {
			connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
			request = connection.createStatement();
			resultat = request.executeQuery("SELECT * FROM `utilisateur` ");

			while (resultat.next()) {
				int id = resultat.getInt("id");
				String login = resultat.getString("login");
				String password = resultat.getString("password");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				boolean sex = resultat.getBoolean("sex");
				String sexe;
				if (sex) {
					sexe = "femme";
				} else {
					sexe = "homme";
				}
				Timestamp derniereConnection = resultat.getTimestamp("derniereConnection");
				Date dateDeNaissance = resultat.getDate("dateDeNaissance");
				String adresse = resultat.getString("adresse");
				int codePostal = resultat.getInt("codePostal");
				String telephone = resultat.getString("telephone");

				// System.out.println(id + " " + login + " " + password + " " +nom + " " +
				// prenom + " " + sexe + " " + dateDeNaissance + " " +
				// " "+ derniereConnection + " " +
				// adresse + " " + codePostal + " " + telephone);

				Client client = new Client(id, nom, prenom, sex, derniereConnection, dateDeNaissance, adresse,
						codePostal, telephone);
				// clients.add(client);



				try {
					Date anniversaire = client.getDateDeNaissance();
					Calendar c = Calendar.getInstance();
					c.setTime(anniversaire);
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH) + 1;
					int date = c.get(Calendar.DATE);
					LocalDate l1 = LocalDate.of(year, month, date);
					LocalDate now1 = LocalDate.now();
					Period diff1 = Period.between(l1, now1);
					System.out.println("age: " + diff1.getYears() + " years");
					client.setAge(diff1.getYears());
				} catch (NullPointerException e) {
					e.getStackTrace();
				}


				clients.add(client);
			}

			System.out.println(clients);
			System.out.println(clients.get(0).getAge());
			System.out.println(clients.get(1).getAge());
			System.out.println(clients.get(2).getAge());

		} catch (SQLException e) {
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

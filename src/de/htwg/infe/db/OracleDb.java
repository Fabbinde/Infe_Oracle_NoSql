package de.htwg.infe.db;

import de.htwg.infe.auth.Authentification;

public class OracleDb {

	Authentification auth;
	
	public OracleDb(String host, String port, String store) {
		auth = new Authentification(host, port, store);
		auth.init();
	}
	
	public void inserKeyValue(String key, String value) {
		
	}
}

package de.htwg.infe.auth;

import oracle.kv.FaultException;
import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;

public class Authentification {

	private String host;
	private String port;
	private String store;
	private KVStoreConfig kconfig;
	private KVStore kvstore;
	private boolean isConnected;
	
	public Authentification(String _host, String _port, String _store) {
		// TODO Auto-generated constructor stub
		this.host = _host;
		this.port = _port;
		this.store = _store;
	}
	
	public void init() {
		kconfig = new KVStoreConfig(store, host + ":" + port);
		try {
			kvstore = KVStoreFactory.getStore(kconfig);
		} catch (FaultException e) {
			System.out.println("FaultException " + getClass() + ":" + e.getMessage());
			isConnected = false;
		}
		catch (Exception e) {
			System.out.println("Exception " + getClass() + ":" + e.getMessage());
		}
		isConnected = true;
		System.out.println("Mit " + host + " verbunden!");
	}

	public boolean isConnected() {
		return isConnected;
	}
	
	
}

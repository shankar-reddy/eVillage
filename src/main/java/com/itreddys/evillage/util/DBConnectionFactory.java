package com.itreddys.evillage.util;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.itreddys.evillage.dao.impl.AccountDAOImpl;
import com.itreddys.evillage.exception.eVillageException;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class DBConnectionFactory {
	private static final Logger logger_c = Logger.getLogger(AccountDAOImpl.class);
	private static String server = "localhost";
	private static Integer port = 27017;

	public DB getConnection() throws eVillageException {
		MongoClient mongo = null;
		try {
			mongo = new MongoClient(new ServerAddress(server, port));
		} catch (UnknownHostException e) {
			logger_c.error("Getting the DB Connection : " + e.getMessage());
			return null;
		}

		/**** Get database ****/
		// if database doesn't exists, MongoDB will create it for you
		DB db = mongo.getDB("eVillageTest");

		return db;
	}
}

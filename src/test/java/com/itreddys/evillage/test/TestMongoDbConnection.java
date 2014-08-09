/**
 * Author : Sankara Reddy Telukutla
 * Aug 4, 2014  7:57:09 PM
 * 
 */
package com.itreddys.evillage.test;

import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
/**
 * 
 */
public class TestMongoDbConnection {
	private static String server = "localhost";
	private static Integer port = 27017;
	private static String dbUser = "eVillage";
	private static String dbPassword = "eVillage";
	public static void main(String[] args) throws UnknownHostException {

			/**** Connect to MongoDB ****/
			MongoClient mongo =null;
			try {
				mongo = new MongoClient(new ServerAddress(server, port));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("eVillageTest");

			/** Authenticate Database now. **/
			//boolean auth = db.authenticate("eVillage", "eVillage".toCharArray());

			//if(auth){
				/**** Get collection / table from 'eVillageTest' ****/
				// if collection doesn't exists, MongoDB will create it for you
				DBCollection table = db.getCollection("user");

				/**** Insert ****/
				// create a document to store key and value
				BasicDBObject document = new BasicDBObject();

				document.put("name", "Shankar");
				document.put("age", 30);
				document.put("createdDate", new Date());
				table.insert(document);

				/**** Find and display ****/
				BasicDBObject searchQuery = new BasicDBObject();
				searchQuery.put("name", "Shankar");

				DBCursor cursor = table.find(searchQuery);

				while (cursor.hasNext()) {
					System.out.println(cursor.next());
				}

 
				System.out.println(table.getCount());
				/**** Update ****/
				// search document where name="mkyong" and update it with new values
				BasicDBObject query = new BasicDBObject();
				query.put("name", "Shankar");

				BasicDBObject newDocument = new BasicDBObject();
				newDocument.put("name", "Shankar-updated");

				BasicDBObject updateObj = new BasicDBObject();
				updateObj.put("$set", newDocument);

				table.update(query, updateObj);


				/**** Find and display ****/
				BasicDBObject searchQuery2 
				= new BasicDBObject().append("name", "Shankar-updated");

				DBCursor cursor2 = table.find(searchQuery2);

				while (cursor2.hasNext()) {
					System.out.println(cursor2.next());
				}


				/**** Done ****/
				System.out.println("Done");
}}
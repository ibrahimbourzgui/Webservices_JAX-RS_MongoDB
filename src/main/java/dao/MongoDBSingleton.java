package dao;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;

public class MongoDBSingleton {
	private static MongoDBSingleton mDbSingleton;
	private static MongoClient mongoClient;
	private static MongoDatabase db;
	private static final String dbHost= "127.0.0.1";
	private static final int dbPort= 27017;
	private static final String dbName= "dbContact";
	
	private MongoDBSingleton()
	{
		
	};
	public static MongoDBSingleton getInstance() {
		if(mDbSingleton==null) {
			mDbSingleton= new MongoDBSingleton();
		}
		return mDbSingleton;
	}
	public MongoDatabase getTestdb() {
		if(mongoClient==null)
		{
			try {
				mongoClient= new MongoClient(new ServerAddress(dbHost, dbPort));
			} catch(Exception e){
				return null;
			}
		}
		MongoDatabase db= mongoClient.getDatabase(dbName);
		return db;
	}
}

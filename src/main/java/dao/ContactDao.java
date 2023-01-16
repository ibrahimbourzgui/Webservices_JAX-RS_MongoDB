package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Filters.eq;

public class ContactDao {
	protected Contact getContact(ResultSet rs) throws SQLException{
		Contact c=new Contact();
		return c;
	}
	public int createContact(Contact c) throws SQLException
	{

		return 0;
	}
	public boolean updateContact(Contact c) throws SQLException
	{
		return true;
	}
	public boolean deleteContact(ObjectId id) throws SQLException
	{
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		MongoDatabase db= dbSingleton.getTestdb();
		MongoCollection<Document> collection=db.getCollection("contacts");
		DeleteResult result= collection.deleteOne(eq("_id",id));
		if(result.getDeletedCount()==1)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public Contact getContact(ObjectId id) throws SQLException
	{
		Contact contact=null;
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		MongoDatabase db= dbSingleton.getTestdb();
		MongoCollection<Document> collection=db.getCollection("contacts");
		Document doc= collection.find(eq("_id",id)).first();
		if(doc==null)
		{
			System.out.println("dos not exist");
		}
		else {
			Gson gson= new Gson();
			contact= gson.fromJson(doc.toJson(), Contact.class);
		}
		return contact;
	}
	
	
	public List<Contact> getAllContact() throws SQLException
	{
		List<Contact> lstcontact=new ArrayList<Contact>();
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		MongoDatabase db= dbSingleton.getTestdb();
		FindIterable<Document> collection=db.getCollection("contacts").find();
		MongoCursor<Document> iterator= collection.iterator();
		while(iterator.hasNext())
		{
			Document doc= iterator.next();
			Gson gson=new Gson();
			lstcontact.add(gson.fromJson(doc.toJson(), Contact.class));
		}
		return lstcontact;
	}
	
	
}

package services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.soap.SOAPException;

import org.bson.types.ObjectId;

import dao.Contact;
import dao.ContactDao;

@Path("/lesContacts")
public class ServiceContact {
	private ContactDao dao= null;
	public ServiceContact() {
		dao= new ContactDao();
		try {
			System.out.println(dao.getAllContact());
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@GET @Path("/getContact/{id}") @Produces(MediaType.APPLICATION_JSON)
	public Contact getContactById(@PathParam("id") ObjectId id) throws SOAPException, Exception
	{
		Contact c= dao.getContact(id);
		if(c== null)
		{
			throw new SOAPException("Aucun Contact.....");
		}
		return c;
	}
	@GET @Path("/deleteContact/{id}") @Produces(MediaType.APPLICATION_JSON)
	public boolean deleteContact(@PathParam("id") ObjectId id) throws SOAPException, Exception
	{
		return dao.deleteContact(id);
	}
	
	@GET @Path("/getContacts") @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Contact> getAllContact() throws SOAPException, Exception
	{
		List<Contact> lstContacts= dao.getAllContact();
		if(lstContacts==null)
		{
			throw new SOAPException("pas de Contact...");
		}
		return lstContacts;
	}
}

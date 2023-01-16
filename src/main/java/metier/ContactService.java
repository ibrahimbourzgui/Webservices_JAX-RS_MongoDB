package metier;

import org.bson.types.ObjectId;

import dao.Contact;

public interface ContactService {
	public boolean addContact(Contact c);
	public boolean deleteContact(ObjectId id);
	public Contact getContact(ObjectId id);
	public Contact[] getAllContact();
}

package metier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;

import dao.Contact;

public class ContactServiceImp implements ContactService {
	private static Map<ObjectId, Contact> contacts= new HashMap<ObjectId, Contact>();

	@Override
	public boolean addContact(Contact c) {
		if(contacts.get(c.get_id())!= null)
		{
			return false;
		}
		contacts.put(c.get_id(), c);
		return true;
	}

	@Override
	public boolean deleteContact(ObjectId id) {
		if(contacts.get(id)==null)
		{
			return false;
		}
		contacts.remove(id);
		return true;
	}

	@Override
	public Contact getContact(ObjectId id) {
		return contacts.get(id);
	}

	@Override
	public Contact[] getAllContact() {
		Set<ObjectId> ids=contacts.keySet();
		Contact[] c = new Contact[ids.size()];
		int i= 0;
		for( ObjectId id : ids)
		{
			c[i] = contacts.get(id);
			i++;
		}
		return c;
	}

}

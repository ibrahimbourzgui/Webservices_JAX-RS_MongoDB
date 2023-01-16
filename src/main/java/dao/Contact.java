package dao;

import org.bson.types.ObjectId;

public class Contact {
	ObjectId _id;
	String nom;
	String tel;
	String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Contact(ObjectId _id, String nom, String tel, String email) {
		super();
		this._id = _id;
		this.nom = nom;
		this.tel = tel;
		this.email=email;
	}
	
	
}

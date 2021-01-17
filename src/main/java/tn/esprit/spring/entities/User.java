package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;   
	
	private String FirstName;
	
	private String Lastname;
	private String Email;
	private String Password;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String phoneNumber;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user",fetch=FetchType.EAGER) 
	private Set<WishList> wishLists;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="userId")
	private Set<Reclamation> Reclamation;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Ad> Ad;
	*/
	
	public Long getId() {
		return id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Set<WishList> getWishLists() {
		return wishLists;
	}
	public void setWishLists(Set<WishList> wishLists) {
		this.wishLists = wishLists;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public User(Long id, String firstName, String lastname, Date dateNaissance, String email, String password) {
		super();
		this.id = id;
		FirstName = firstName;
		Lastname = lastname;
		this.dateNaissance = dateNaissance;
		Email = email;
		Password = password;
	}
	
	public User(String firstName, String email, String password) {
		super();
		FirstName = firstName;
		Email = email;
		Password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", FirstName=" + FirstName + ", Lastname=" + Lastname + ", dateNaissance="
				+ dateNaissance + ", Email=" + Email + ", Password=" + Password + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	//youssef

	@OneToMany(mappedBy="idUser",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Commande> commandes;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private  LigneCommande ligneCommande;

	
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	
	

}

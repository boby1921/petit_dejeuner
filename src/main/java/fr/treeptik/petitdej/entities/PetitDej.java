package fr.treeptik.petitdej.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
@Entity
public class PetitDej implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="ne doit  pas etre vide")
	private Date datePetitDej;
	@NotNull(message="ne doit  pas etre vide")
	private Long prix;
	@Enumerated(EnumType.STRING)
	private Type type;
	private String Description;
	@OneToOne
	private Membre organisateur;
	@ManyToMany
	private List<Membre> participants;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPrix() {
		return prix;
	}
	public void setPrix(Long prix) {
		this.prix = prix;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Membre getOrganisateur() {
		return organisateur;
	}
	public void setOrganisateur(Membre organisateur) {
		this.organisateur = organisateur;
	}
	public List<Membre> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Membre> participants) {
		this.participants = participants;
	}
	public Date getDatePetitDej() {
		return datePetitDej;
	}
	public void setDatePetitDej(Date datePetitDej) {
		this.datePetitDej = datePetitDej;
	}
	
}

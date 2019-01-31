package metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity // --> import javax.persistence.Entity; 
@Table(name = "etudiant", uniqueConstraints={@UniqueConstraint(name="nom_prenom", columnNames={"Nom", "Prénom"})} )
public class Student implements Serializable{ 
     private static final long serialVersionUID = 1L; 
                                             //juste pour avoir un code unique sha 
	@Id // clé primaire 
	@GeneratedValue(strategy=GenerationType.AUTO) //génération automatique 
	private long studentId; 
	@Column(name="Nom", length=10, nullable=false) //Change nom de colonne, maximum 10 caractères, valeur null impossible
	private String nom;
	@Column(name="Prénom")//Change nom de colonne
	private String prenom;
	@Column(name="Note")//Change nom de colonne
	private int note;
	@Column(name="Age")//Change nom de colonne
	private int age;
		
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// Méthode toString pour l'affichage des résultats des requêtes paramétrées
	@Override
	public String toString() {
		return ("nom="+nom+", prénom="+prenom+", age="+age+", note="+note);
	}
}

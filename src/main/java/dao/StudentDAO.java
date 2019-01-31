package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Student;


public class StudentDAO { 
	
	EntityManagerFactory emf;

	public void addStudent(Student student) { //ajout l'�tudiant dans la BDD
		//1. Instanciation de la persistence.xml 1 fois, attention jpaProjetPU est le name du PU  
			emf = Persistence.createEntityManagerFactory("projetJPAPU");
		//2.Construction d'un entity manager pour effectuer les op�rations CRUD et transaction 
			EntityManager em = emf.createEntityManager(); 
		//3. Ouverture d'une transaction: 
			EntityTransaction tx = em.getTransaction(); 
			tx.begin(); 
			try{ 
		//4. persistence de mon object student 
			em.persist(student);//le traitement se fera toujours dans une transaction 
		//5. commit de la transaction : validation du traitement 
			tx.commit(); 
			}catch(Exception e) { 
		//Annuler les traitements 
			   if (tx != null) { 
					tx.rollback();  //annuler la transaction s'il y a une exception 
					e.printStackTrace();   //print 
			   } 
			 }finally{ //6. dans tous les cas on ferme 
				 em.close(); 
				 emf.close(); 
			 } 
       }
	
	// Requ�te param�tr�e qui filtre sur le nom DUBOIS
	public List<Student> listStudent(String nom) {
		emf = Persistence.createEntityManagerFactory("projetJPAPU");
		EntityManager em = emf.createEntityManager(); 
		Query query = em.createQuery("select student from Student student where nom=?1"); 
		query.setParameter(1, nom);
		List<Student> listStudent = query.getResultList();
		return listStudent;
	}
	
	// Requ�te param�tr�e qui donne la liste des �tudiants
	public List<Student> getStudents() {
		emf = Persistence.createEntityManagerFactory("projetJPAPU");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select s from Student s",Student.class); 
		List<Student> listStudent = query.getResultList();
		return listStudent;
	}
	
	// Requ�te param�tr�e pour mise � jour des donn�es
	public void updateStudents(long studentId, String nom, String pr�nom, int age, int note) {
		emf = Persistence.createEntityManagerFactory("projetJPAPU");
		EntityManager em = emf.createEntityManager();
		
		Student stud = em.find(Student.class, studentId);
		
		em.getTransaction().begin();
		stud.setNom(nom);
		stud.setPrenom(pr�nom);
		stud.setAge(age);
		stud.setNote(note);
		em.getTransaction().commit();
	}
	
	// Requ�te param�tr�e pour suppression des donn�es
	public void deleteStudents(long studentId) {
		emf = Persistence.createEntityManagerFactory("projetJPAPU");
		EntityManager em = emf.createEntityManager();
		
		Student stud = em.find(Student.class, studentId);
		
		em.getTransaction().begin();
		em.remove(stud);
		em.getTransaction().commit();
	}
}
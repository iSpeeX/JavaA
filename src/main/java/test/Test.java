package test;

import java.util.List;

import dao.StudentDAO;
import metier.*;

public class Test {

    public static void main(String[] args) {

    	Student etud1 = new Student();
        etud1.setNom("DUBOIS");
        etud1.setPrenom("Marie");
        etud1.setNote(13);
        etud1.setAge(23);

        Student etud2 = new Student();
        etud2.setNom("DUPONT");
        etud2.setPrenom("Pierre");
        etud2.setNote(8);
        etud2.setAge(21);

        Student etud3 = new Student();
        etud3.setNom("DUBOIS");
        etud3.setPrenom("Paul");
        etud3.setNote(14);
        etud3.setAge(19);

        Student etud4 = new Student();
        etud4.setNom("PERREZ");
        etud4.setPrenom("Antoinette");
        etud4.setNote(9);
        etud4.setAge(20);

        StudentDAO studDao = new StudentDAO();
        studDao.addStudent(etud1);
        studDao.addStudent(etud2);
        studDao.addStudent(etud3);
        studDao.addStudent(etud4);
        
        // Utilisation de la requête paramétrée qui filtre sur le nom DUBOIS
        List<Student> list_stud = studDao.listStudent("DUBOIS");
        for (Student stud :list_stud) {
        	System.out.println(stud);
        }
        
        // Utilisation de la requête paramétrée qui donne la liste des étudiants
        List<Student> get_stud = studDao.getStudents();
        for (Student stud2 :get_stud) {
        	System.out.println(stud2);
        }
        
        // Utilisation de la requête paramétrée qui met à jour les données de la base
        studDao.updateStudents(97, "FOUCHER", "Mathieu", 25, 19);
        
        // Utilisation de la requête paramétrée qui supprime des données
        studDao.deleteStudents(96);
    }
}
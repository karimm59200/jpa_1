package org.example.demo;

import org.example.entity.ToDoList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Demo1 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("todolist");

    public static void main(){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        ToDoList toDo1 = new ToDoList("faire les courses" , false);
        System.out.println("Id de la tache : "+ toDo1.getId() );
        em.persist(toDo1);
        System.out.println("Id de la tache  après persist :" + toDo1.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void remove(){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        ToDoList todo = em.find(ToDoList.class, 1L);
        em.remove(todo);


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public static void createQuery(){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        ToDoList toDo2 = new ToDoList("faire plus une séance de sport", false);
        ToDoList toDo3 = new ToDoList("faire la vaisselle", false);
        ToDoList toDo4 = new ToDoList("faire le ménage", false);
        ToDoList toDo5 = new ToDoList("faire le repassage", false);

        em.persist(toDo2);
        em.persist(toDo3);
        em.persist(toDo4);
        em.persist(toDo5);

        List<ToDoList> toDoListList = null;

        toDoListList = em.createQuery("select t from ToDoList t", ToDoList.class).getResultList();

        for(ToDoList t:toDoListList){
            System.out.println(t);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();

    }





}

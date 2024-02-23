package org.example.messageDAO;

import org.example.entity.Message;
import org.example.ui.UIMessageMenu;
import org.example.util.UtilEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MessageDAO {

    private static EntityManager getEntityManager() {
        return UtilEntity.getEntityManager();
    }

    private static void beginTransaction(EntityManager em, EntityTransaction transaction) {
        transaction = em.getTransaction();
        transaction.begin();
    }

    private static void commitTransaction(EntityTransaction transaction) {
        if (transaction != null && transaction.isActive()) {
            transaction.commit();
        }
    }

    private static void rollbackTransaction(EntityTransaction transaction) {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
    }

    public static void createMessageDB(Message message) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();


            em.persist(message);

            transaction.commit();

            System.out.println("El mensaje se ha creado " + message.getAuthorMessage());

            UIMessageMenu.showMessageMenu();
        } catch (Exception e) {
            rollbackTransaction(transaction);
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void readMessages() {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        List<Message> messages;

        try {
            transaction.begin();

            messages = em.createQuery("SELECT m FROM Message m", Message.class).getResultList();

            transaction.commit();

            for (Message message : messages) {
                System.out.println("ID: " + message.getIdMessage());
                System.out.println("Author: " + message.getAuthorMessage());
                System.out.println("Message: " + message.getMessage());
                System.out.println("Created At: " + message.getCreatedAt());
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            rollbackTransaction(transaction);
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void deleteMessage(int idMessage) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Message messageToDelete = em.find(Message.class, idMessage);

            if (messageToDelete != null) {
                em.remove(messageToDelete);
                transaction.commit();
                System.out.println("El mensaje con ID " + idMessage + " se ha eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún mensaje con ID " + idMessage);
            }
        } catch (Exception e) {
            rollbackTransaction(transaction);
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void updateMessage(Integer idMessage, String newMessageText) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            beginTransaction(em, transaction);

            Message messageToUpdate = em.find(Message.class, idMessage);

            if (messageToUpdate != null) {
                messageToUpdate.setMessage(newMessageText);
                commitTransaction(transaction);
                System.out.println("El mensaje con ID " + idMessage + " se ha actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún mensaje con ID " + idMessage);
            }

        } catch (Exception e) {
            rollbackTransaction(transaction);
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}



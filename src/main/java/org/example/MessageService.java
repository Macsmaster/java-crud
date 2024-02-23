package org.example;

import org.example.entity.Message;
import org.example.messageDAO.MessageDAO;

import java.util.Scanner;

public class MessageService {

    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add your message");
        String message = sc.nextLine();
        System.out.println("Your name");

        String author = sc.nextLine();

        Message newMessage = new Message();
        newMessage.setAuthorMessage(author);
        newMessage.setMessage(message);

        MessageDAO.createMessageDB(newMessage);
    }

    public static void getMessages() {
        MessageDAO.readMessages();

    }

    public static void updateMessage() {
        MessageDAO.readMessages();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresé el id del mensaje que quiere módificar");
        String id = sc.nextLine();


        int selectedId = Integer.parseInt(id);

        System.out.println("Ingresa el mensaje:");
        String message = sc.nextLine();
        MessageDAO.updateMessage(selectedId, message);






    }

    public static void deleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mensajes");

        MessageDAO.readMessages();
        System.out.println("Ingresa el ID para eliminar el mensaje");
        String id = sc.nextLine();

        int selectedId = Integer.parseInt(id);

        MessageDAO.deleteMessage(selectedId);
    }


}

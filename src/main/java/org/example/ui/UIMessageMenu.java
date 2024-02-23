package org.example.ui;
import org.example.MessageService;
import java.util.Scanner;

public class UIMessageMenu {

    public static void showMessageMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Menu Messages");
            System.out.println("Welcome ");
            System.out.println("1. Get messages");
            System.out.println("2. Create message");
            System.out.println("3. Update message");
            System.out.println("4. Delete message");
            System.out.println("0. logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 1:
                    MessageService.getMessages();
                    break;
                case 2:
                    MessageService.createMessage();
                    break;
                case 3:
                    MessageService.updateMessage();
                    break;
                case 4:
                    MessageService.deleteMessage();
                    break;
                case 0:
                    break;

            }

        } while(response != 0);
    }

}

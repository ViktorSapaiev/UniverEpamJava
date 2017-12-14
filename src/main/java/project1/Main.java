package project1;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    private static Client client = new Client(1,"Джон Сноу",200000.0, LocalDate.now(), "Винтерфел", "Старк.коорп.","Король севера", 400000.0);
    private static BankWorker bankWorker = new BankWorker();

    public static void main(String[] args) throws IOException {
     /*   Readers reader = new Readers();
        UserInterface ui = new UserInterface(client,bankWorker);
        MainMenu menu = new MainMenu();
        System.out.print(menu.show());
        ui.ui(reader.readInt());*/
    }
}

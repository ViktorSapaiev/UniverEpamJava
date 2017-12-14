package project1;

public class UserInterface {
    private Client client;
    private BankWorker bankWorker;


    UserInterface(Client client, BankWorker bankWorker) {
        this.client = client;
        this.bankWorker = bankWorker;
    }

    public void ui(int key){
        if (key == 3) {
            printProfile();
        }
    }
    private void printProfile() {
        System.out.println(client.getProfile());
    }

}
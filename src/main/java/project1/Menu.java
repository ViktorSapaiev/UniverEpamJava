package project1;


import java.io.IOException;

public enum Menu {
    CreditPropose(1,"Показать все кредитные предложения"),
    SearchCredit(2,"Поиск кредитного предложения"),
    LookProfile(3,"Просмотреть профиль"),
    Exit(4,"Выйти");



    private void showMainMenu() {
         System.out.println(
                 "############ Главное меню ############\n" +
                 CreditPropose.id + CreditPropose.description +"\n" +
                 SearchCredit.id + SearchCredit.description +"\n" +
                 LookProfile.id + LookProfile.description +"\n" +
                 Exit.id + Exit.description +"\n"
         );

    }



    private int id;
    private String description;

    Menu(int id, String description) {
        this.id = id;
        this.description = description;
    }


}

import com.hdh.model.Branch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputMenu = new Scanner(System.in);

        boolean cont = true;

        do {
            System.out.println("Select function from [1 -6]");
            System.out.println(" Func 1: ABC \n Func 2: ABC \n Func 3: ABC .... \n Func 6: Log out");

            int chooseInt = inputMenu.nextInt();
            switch (chooseInt) {
                case 1:
                    System.out.println("Implement function 1");
                    break;
                case 2:
                    System.out.println("Implement function 2");
                    break;
                case 3:
                    System.out.println("Implement function 3");
                    break;
                case 4:
                    System.out.println("Implement function 4");
                    break;
                case 5:
                    System.out.println("Implement function 5");
                    break;
                case 6:
                    System.out.println("Log out");
                    cont = false;
                    break;
                default:
                    System.out.println("Bạn nhập sai, yêu cầu chọn lại!!!");
                    break;
            }
        } while (cont);

    }
}
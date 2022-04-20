import com.hdh.model.Branch;
import database.BaseDatabase;
import database.BranchDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BranchDatabase branchDatabase = new BranchDatabase();


        Scanner inputMenu = new Scanner(System.in);

        boolean cont = true;

        do {
            System.out.println("Select function from [1 -6]");
            System.out.println(
                    "  ------- Func 1: Get all list branch \n " +
                            " ------- Func 2:  Add branch \n " +
                            " ------- Func 3: ABC .... \n " +
                            " ------- Func 6: Log out \n" +
                            "---------------------------");

            int chooseInt = inputMenu.nextInt();
            switch (chooseInt) {
                case 1:
                    branchDatabase.getAll().forEach((key, value) -> System.out.println(key + " : " + value.toString()));
                    break;
                case 2:
                    Branch branchNew = new Branch();
                    System.out.println("Request to enter branch information!!!");
                    branchNew.inputInfoBranch();
                    branchDatabase.create(branchNew);
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
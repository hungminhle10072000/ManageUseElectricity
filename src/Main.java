import com.hdh.service.BranchService;
import com.hdh.service.FormUseService;
import com.hdh.service.InitDatabaseService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BranchService branchService = new BranchService();
        FormUseService formUseService = new FormUseService();

        Scanner inputMenu = new Scanner(System.in);
        boolean cont = true;

        do {
            System.out.println("Select function from [1 -6]");
            System.out.println(
                    "  ------- Func 1:  Get all list branch \n " +
                            " ------- Func 2:  Add branch \n " +
                            " ------- Func 3:  Delete branch by id\n " +
                            " ------- Func 4:  Update branch have id\n " +
                            " ------- Func 5:  List form use electric and unit price\n " +
                            " ------- Func 6:  Enter form use electric and unit price\n " +
                            " ------- Func 7:  Delete form use by id\n " +
                            " ------- Func 8:  Update form use have id\n " +
                            " ------- Func 9: Log out \n" +
                            "---------------------------\n");

            int chooseInt = inputMenu.nextInt();
            switch (chooseInt) {
                case 1:
                    InitDatabaseService.branchDatabase.getAll().forEach((key, value) -> System.out.println(key + " : " + value.toString()));
                    break;
                case 2:
                    InitDatabaseService.branchDatabase.create(branchService.createObjectBranch());
                    break;
                case 3:
                    branchService.deleteBranchById();
                    break;
                case 4:
                    branchService.updateBranch();
                case 5:
                    InitDatabaseService.formUseDatabase.getAll().forEach((key, value) -> System.out.println(value.toString()));
                    break;
                case 6:
                    InitDatabaseService.formUseDatabase.create(formUseService.createObjectFormUse());
                    break;
                case 7:
                    formUseService.deleteFormUseById();
                    break;
                case 8:
                    formUseService.updateFormUse();
                    break;
                case 9:
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
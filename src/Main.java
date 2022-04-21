import com.hdh.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BranchService branchService = new BranchService();
        FormUseService formUseService = new FormUseService();
        CustomerService customerService = new CustomerService();
        ContractService contractService = new ContractService();
        InitDatabaseService.initData();

        Scanner inputMenu = new Scanner(System.in);
        boolean cont = true;

        do {
            System.out.println();
            System.out.println(
                    "-------------------------------------------------------------------- \n" + "Select function from [1 -6]\n" +
                            "  ------- Func 1: Get all branch \n " +
                            " ------- Func 2:  Add branch \n " +
                            " ------- Func 3:  Delete branch\n " +
                            " ------- Func 4:  Update branch\n " +
                            " ------- Func 5:  Get all form use\n " +
                            " ------- Func 6:  Add form use\n " +
                            " ------- Func 7:  Delete form use\n " +
                            " ------- Func 8:  Update form use\n " +
                            " ------- Func 9:  Add customer\n " +
                            " ------- Func 10: Get all customer\n " +
                            " ------- Func 11: Update customer\n " +
                            " ------- Func 12: Delete customer\n " +
                            " ------- Func 13: Find customer\n " +
                            " ------- Func 14: Find branch\n " +
                            " ------- Func 15: Find form use\n " +
                            " ------- Func 16: Add contract\n " +
                            " ------- Func 17: Get all contract\n " +
                            " ------- Func 18: Find contract\n " +
                            " ------- Func 14: Log out \n" +
                            "-------------------------------------------------------------------- \n");

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
                    customerService.addCustomer();
                    break;
                case 10:
                    customerService.getAllCustomer();
                    break;
                case 12:
                    customerService.deleteCustomerById();
                    break;
                case 13:
                    customerService.checkInfoCustomer();
                    break;
                case 14:
                    branchService.findBranchbyId();
                    break;
                case 15:
                    formUseService.findFormUse();
                    break;
                case 16:
                    contractService.addContract();
                    break;
                case 17:
                    contractService.getAllContract();
                    break;
                case 18:
                    contractService.findInfoContract();
                    break;
                case 19:
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
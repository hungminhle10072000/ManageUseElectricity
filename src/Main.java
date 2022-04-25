import com.hdh.model.ElectricMeter;
import com.hdh.model.NoteBook;
import com.hdh.service.*;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InitDatabaseService.initData();
        Main main = new Main();
        main.mainMenu(main);
        System.out.println("Application has been shut down");
    }

    private Main mainMenu(Main main) {
        System.out.println("Welcome to the  electric use manage application");
        boolean cont = true;

        do {
            System.out.println("[1] Manage branch");
            System.out.println("[2] Manage customer");
            System.out.println("[3] Manage form use");
            System.out.println("[4] Manage contract");
            System.out.println("[5] Manage electric meter");
            System.out.println("[6] Manage note book");
            System.out.println("[7] Manage invoie");
            System.out.println("[8] Exit");


            System.out.print("Insert selection: ");
            int chooseInt = scanner.nextInt();


            switch (chooseInt) {
                case 1:
                    return main.menuBranch(main);
                case 3:
                    return main.menuFormUse(main);
                case 2:
                    return main.menuCustomer(main);
                case 4:
                    return main.menuContract(main);
                case 5:
                    return main.menuElectricMeter(main);
                case 6:
                    return main.menuNoteBook(main);
                case 7:
                    return main.menuInvoice(main);
                case 8:
                    cont = false;
                    break;
                default:
                    System.out.println("The selection was invalid!");
            }

        } while (cont);
        return main;
    }

    private Main menuInvoice(Main main) {
        System.out.println("-------------------------------------------------------------------- \n" + "Welcome to the function of invoice: ");

        int selection;

        InvoiceService invoiceService = new InvoiceService();
        do {
            System.out.println(
                    "  ------- Func 1:  Issue an invoice \n " +
                            "  ------- Func 2:  Get all invoice by month and year \n " +
                            "  ------- Func 3:  Update status of invoice \n " +
                            "  ------- Func 4:  Find invoice \n " +
//                            "  ------- Func 5:  Delete invoice \n " +
                            " ------- Func 7:  Go back\n ");
            System.out.print("Insert selection: ");
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    invoiceService.issueAnInvoice();
                    break;
                case 2:
                    invoiceService.getAllInvoiceMonthYear();
                    break;
                case 3:
                    invoiceService.updateStatus();
                    break;
                case 4:
                    invoiceService.findInvoice();
                    break;
                case 5:
                    invoiceService.deleteInvoice();
                    break;
                case 7:
                    return main.mainMenu(main);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 8);
        return main;
    }

    private Main menuBranch(Main main) {
        BranchService branchService = new BranchService();

        System.out.println("-------------------------------------------------------------------- \n" + "Welcome to the function of branch: ");

        int selection;

        do {
            System.out.println(
                    "  ------- Func 1:  Get all branch \n " +
                            " ------- Func 2:  Add branch \n " +
                            " ------- Func 3:  Delete branch\n " +
                            " ------- Func 4:  Update branch\n " +
                            " ------- Func 5:  Find branch by ID\n " +
                            " ------- Func 6:  Find branch by nameBranch\n " +
                            " ------- Func 7:  Go back\n ");
            System.out.print("Insert selection: ");
            selection = scanner.nextInt();

            System.out.println("\n--------------------------------------------------------------------");
            switch (selection) {
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
                    break;
                case 5:
                    branchService.findBranchbyId();
                    break;
                case 6:
                    branchService.findBranchByName();
                    break;
                case 7:
                    return main.mainMenu(main);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 8);
        return main;
    }

    private Main menuFormUse(Main main) {
        FormUseService formUseService = new FormUseService();

        System.out.println("-------------------------------------------------------------------- \n" + "Welcome to the function of form use: ");

        int selection;

        do {
            System.out.println(
                    "  ------- Func 1:  Get all form use \n " +
                            " ------- Func 2:  Add form use \n " +
                            " ------- Func 3:  Delete form use\n " +
                            " ------- Func 4:  Update form use\n " +
                            " ------- Func 5:  Find form use by id\n " +
                            " ------- Func 6:  Find form use by nameForm\n " +
                            " ------- Func 7:  Go back\n ");
            System.out.print("Insert selection: ");
            selection = scanner.nextInt();
            System.out.println("\n--------------------------------------------------------------------");
            switch (selection) {
                case 1:
                    InitDatabaseService.formUseDatabase.getAll().forEach((key, value) -> System.out.println(value.toString()));
                    break;
                case 2:
                    InitDatabaseService.formUseDatabase.create(formUseService.createObjectFormUse());
                    break;
                case 3:
                    formUseService.deleteFormUseById();
                    break;
                case 4:
                    formUseService.updateFormUse();
                    break;
                case 5:
                    formUseService.findFormUse();
                    break;
                case 6:
                    formUseService.findFormUseByNameForm();
                    break;
                case 7:
                    return main.mainMenu(main);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 8);
        return main;
    }

    private Main menuCustomer(Main main) {
        CustomerService customerService = new CustomerService();

        System.out.println("-------------------------------------------------------------------- \n" + "Welcome to the function of customer: ");

        int selection;

        do {
            System.out.println(
                    "  ------- Func 1:  Get all customer \n " +
                            " ------- Func 2:  Add customer \n " +
                            " ------- Func 3:  Delete customer\n " +
                            " ------- Func 4:  Update customer\n " +
                            " ------- Func 5:  Find customer by ID\n " +
                            " ------- Func 6:  Find customer by Name\n " +
                            " ------- Func 7:  Go back\n ");
            System.out.print("Insert selection: ");
            selection = scanner.nextInt();
            System.out.println("\n--------------------------------------------------------------------");
            switch (selection) {
                case 1:
                    customerService.getAllCustomer();
                    break;
                case 2:
                    customerService.addCustomer();
                    break;
                case 3:
                    customerService.deleteCustomerById();
                    break;
                case 4:
                    customerService.updateCustomer();
                    break;
                case 5:
                    customerService.checkInfoCustomer();
                    break;
                case 6:
                    customerService.findCustomerByName();
                    break;
                case 7:
                    return main.mainMenu(main);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 8);
        return main;
    }

    private Main menuContract(Main main) {
        ContractService contractService = new ContractService();

        System.out.println("-------------------------------------------------------------------- \n" + "Welcome to the function of contract: ");

        int selection;

        do {
            System.out.println(
                    "  ------- Func 1:  Get all contract \n " +
                            " ------- Func 2:  Add contract \n " +
                            " ------- Func 3:  Delete contract\n " +
                            " ------- Func 4:  Update contract\n " +
                            " ------- Func 5:  Find contract\n " +
                            " ------- Func 6:  Go back\n ");
            System.out.print("Insert selection: ");
            selection = scanner.nextInt();
            System.out.println("\n--------------------------------------------------------------------");
            switch (selection) {
                case 1:
                    contractService.getAllContract();
                    break;
                case 2:
                    contractService.addContract();
                    break;
                case 3:
                    contractService.deleteContract();
                    break;
                case 4:
                    contractService.updateContract();
                    break;
                case 5:
                    contractService.findInfoContract();
                    break;
                case 6:
                    return main.mainMenu(main);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 7);
        return main;
    }

    private Main menuElectricMeter(Main main) {
        ElectricMeterService electricMeterService = new ElectricMeterService();

        System.out.println("-------------------------------------------------------------------- \n" + "Welcome to the function of contract: ");

        int selection;

        do {
            System.out.println(
                    "  ------- Func 1:  Get all electric meter \n " +
                            " ------- Func 2:  Add electric meter \n " +
                            " ------- Func 3:  Delete electric meter\n " +
                            " ------- Func 4:  Update electric meter\n " +
                            " ------- Func 5:  Find electric meter by ID\n " +
                            " ------- Func 6:  Find electric meter by type\n " +
                            " ------- Func 7:  Go back\n ");
            System.out.print("Insert selection: ");
            selection = scanner.nextInt();
            System.out.println("\n--------------------------------------------------------------------");
            switch (selection) {
                case 1:
                    electricMeterService.getAllElecticMeter();
                    break;
                case 2:
                    electricMeterService.addElectricMeter();
                    break;
                case 3:
                    electricMeterService.deleteElectricMeter();
                    break;
                case 4:
                    electricMeterService.updateElectricMeter();
                    break;
                case 5:
                    electricMeterService.findInfoElectricMeter();
                    break;
                case 6:
                    electricMeterService.findElectricMeterByType();
                    break;
                case 7:
                    return main.mainMenu(main);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 8);
        return main;
    }

    private Main menuNoteBook(Main main) {
        NoteBookService noteBookService = new NoteBookService();

        System.out.println("-------------------------------------------------------------------- \n" + "Welcome to the function of notebook: ");
        int selection;

        do {
            System.out.println(
                    "  ------- Func 1:  Get all record of notebook \n " +
                            " ------- Func 2:  Add  record of notebook \n " +
                            " ------- Func 3:  Find record of notebook\n " +
                            " ------- Func 4:  Update record of notebook\n " +
                            " ------- Func 5:  Delete record of notebook\n " +
                            " ------- Func 7:  Go back\n ");
            System.out.print("Insert selection: ");
            selection = scanner.nextInt();
            System.out.println("\n--------------------------------------------------------------------");
            switch (selection) {
                case 1:
                    noteBookService.getAllRecordNoteBook();
                    break;
                case 2:
                    noteBookService.addNoteBook();
                    break;
                case 3:
                    noteBookService.findNoteBook();
                    break;
                case 4:
                    noteBookService.updateNoteBook();
                    break;
                case 5:
                    noteBookService.deleteRecordNoteBook();
                    break;
                case 7:
                    return main.mainMenu(main);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 8);
        return main;
    }
}


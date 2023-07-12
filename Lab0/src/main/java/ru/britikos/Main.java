package ru.britikos;


import ru.britikos.BankAccount.*;
import ru.britikos.Banks.Bank;
import ru.britikos.Banks.CentralBank;
import ru.britikos.Clients.Client;
import ru.britikos.Clients.Name;
import ru.britikos.Clients.Passport;
import ru.britikos.Handlers.CreditHandler;
import ru.britikos.Handlers.DebitHandler;
import ru.britikos.Handlers.DepositeHandler;
import ru.britikos.Handlers.Receiver;
import ru.britikos.Transactions.CreditTransaction;
import ru.britikos.Transactions.DebitTransaction;
import ru.britikos.Transactions.DepositTransaction;

import java.util.Date;
import java.util.Scanner;

/**
 * Лабораторная работа 1
 * Банки
 * Предметная область
 *
 * Есть несколько Банков, которые предоставляют финансовые услуги по операциям с деньгами.
 *
 * В банке есть Счета и Клиенты. У клиента есть имя, фамилия, адрес и номер паспорта
 * (имя и фамилия обязательны, остальное – опционально).
 * @author Бритикова Элиза
 * @version 1.0
 */

public class Main {
    public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome");
        CentralBank mainbank = CentralBank.getInstance();
        boolean flag = true;
        Bank bank = new Bank();
        Client client = new Client();
        Account score;
        while (flag){
            Menu();
            int choose = in.nextInt();

            switch (choose){
                case 1:
                    System.out.println("Enter name Bank");
                    String name = in.nextLine();
                    System.out.println("Enter credit procent");
                    float credit = in.nextFloat();
                    System.out.println("Enter debit procent");
                    float debit = in.nextFloat();
                    System.out.println("Enter min deposite procent");
                    float debit1 = in.nextFloat();
                    System.out.println("Enter medium deposite procent");
                    float debit2 = in.nextFloat();
                    System.out.println("Enter max deposite procent");
                    float debit3 = in.nextFloat();
                    bank = mainbank.createBank(name,credit,debit,new float[]{debit1, debit2, debit3});
                    mainbank.addBank(bank);
                    System.out.println("Sucssesfuly");
                    break;
                case 2:
                    System.out.println("Enter your firstName");
                    String firstName = in.nextLine();
                    System.out.println("Enter your secondName");
                    String secondName = in.nextLine();
                    System.out.println("Enter your seria passport");
                    int seria = in.nextInt();
                    System.out.println("Enter your number passport");
                    int number = in.nextInt();
                    System.out.println("Enter your birthDAY");
                    String birth = in.nextLine();
                    client = mainbank.createClient(new Name(firstName,secondName),new Date(birth), new Passport(seria,number));
                    mainbank.addClient(client,bank);
                    System.out.println("Sucssesfuly");
                    break;
                case 3:
                    System.out.println("Enter Client Id");
                    long idClient= in.nextLong();
                    client = mainbank.findClient(idClient);
                    System.out.println("Enter StartDAY");
                    String start = in.nextLine();
                    System.out.println("Enter EndDAY");
                    String end = in.nextLine();
                    System.out.println("Enter your sum");
                    double startSum = in.nextDouble();
                    System.out.println("Enter Bank ID");
                    long id = in.nextLong();
                    bank = mainbank.findBank(id);
                    System.out.println("Which account you want created?");
                    System.out.println("1. Credit");
                    System.out.println("2. Deposite");
                    System.out.println("3. Debite");
                    int choose_score = in.nextInt();
                    switch (choose_score){
                        case 1:
                            score = mainbank.addAccount(new Credit(id, new Date(start), new Date(end), startSum,bank),client );
                            break;
                        case 2:
                            score = mainbank.addAccount(new Deposit(id, new Date(start), new Date(end), startSum,bank), client);
                            break;
                        case 3:
                            score = mainbank.addAccount(new Debit(id, new Date(start), new Date(end), startSum,bank),client );
                            break;
                        default:
                            System.out.println("Invalid symbol");
                    }
                    System.out.println("Sucssesfuly");
                    break;
                case 4:
                    System.out.println("Enter id Score from transfer");
                    long idFrom = in.nextLong();
                    System.out.println("Enter id Score to transfer");
                    long idTo = in.nextLong();
                    System.out.println("Enter money to transfer ");
                    double sumTransfer = in.nextDouble();
                    System.out.println("Enter Bank ID");
                    long idBank = in.nextLong();
                    score = mainbank.findAccount(idFrom);
                    switch (score.type){
                        case Credit:
                            score.owner.addTransaction(new CreditTransaction(mainbank.getId(),sumTransfer, score,mainbank.findAccount(idTo),score.bank));
                            break;
                        case Debit:
                            score.owner.addTransaction(new DebitTransaction(mainbank.getId(),sumTransfer, score,mainbank.findAccount(idTo),score.bank));
                            break;
                        case Deposite:
                            score.owner.addTransaction(new DepositTransaction(mainbank.getId(),sumTransfer, score,mainbank.findAccount(idTo),score.bank));
                            break;
                        default:
                            System.out.println("Invalid symbol");
                    }
                    System.out.println("Sucssesfuly");
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
        System.out.println("Goodbay!");
        return;
    }

    public void Menu(){
        System.out.println("       Menu:");
        System.out.println("1. Create bank");
        System.out.println("2. Create Client");
        System.out.println("3. Create Account");
        System.out.println("4. Create Transaction");
        System.out.println("5. Exist");
        System.out.println("Choose line and write number");
    }
}

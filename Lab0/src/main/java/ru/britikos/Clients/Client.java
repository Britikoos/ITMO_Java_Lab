package ru.britikos.Clients;



import ru.britikos.Transactions.Transaction;

import java.util.Date;

public class Client {
    public long id;
    public Name fullName;
    public Date birthDay;
    public Passport passport;

    /**
     * Метод добавляет транзакцию.
     * @param transfer
     */
    public void addTransaction(Transaction transfer) {
        transfer.addTransaction();
        System.out.println("Trasaction complited Sucsses");
    }

    /**
     * Метод удаляет транзакцию.
     * @param transfer
     */
    public void deleteTransaction(Transaction transfer){
        transfer.deleteTransaction();
        System.out.println("Trasaction deleted Sucsses");
    }

}

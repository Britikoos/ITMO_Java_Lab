package ru.britikos.Transactions;



import ru.britikos.BankAccount.Account;
import ru.britikos.Banks.Bank;

import java.util.Date;

public class DepositTransaction extends Transaction{
    /**
     * Конструктор
     * @param id
     * @param money
     * @param scoreFrom
     * @param scoreTo
     * @param bank
     */
    public DepositTransaction(long id, double money, Account scoreFrom, Account scoreTo, Bank bank) {
        super(id, money, scoreFrom, scoreTo, bank);
    }

    public Date data = new Date();
    @Override
    public void check() {
        if(scoreFrom.endDay.before(data))
            isCorrect = true;
        else {
            isCorrect = false;
            System.out.println("Time your score not ready yet");
        }

    }

    /**
     * Метод, добавляющий транзакцию.
     */
    @Override
    public void addTransaction() {
        check();
        scoreFrom.money -= money;
        scoreTo.money += money;
        System.out.println();
    }

    /**
     * Метод, удаляющий транзакцию.
     */
    @Override
    public void deleteTransaction() {
        check();
        scoreTo.money -= money;
        scoreFrom.money += money;
    }
}

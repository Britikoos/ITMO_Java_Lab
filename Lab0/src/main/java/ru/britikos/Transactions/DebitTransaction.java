package ru.britikos.Transactions;


import ru.britikos.BankAccount.Account;
import ru.britikos.Banks.Bank;

public class DebitTransaction extends Transaction{
    /**
     * Конструктор
     * @param id
     * @param money
     * @param scoreFrom
     * @param scoreTo
     * @param bank
     */
    public DebitTransaction(long id, double money, Account scoreFrom, Account scoreTo, Bank bank) {
        super(id, money, scoreFrom, scoreTo, bank);
    }

    /**
     * Метод, проверяющий корректность транзакции.
     */
    @Override
    public void check() {
        if(scoreFrom.money >= money)
            isCorrect = true;
        else {
            isCorrect = false;
            System.out.println("On your score not exists money");
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
    }

    /**
     * Метод, удаляющий транзакцию.
     */
    @Override
    public void deleteTransaction() {
        scoreTo.money -= money;
        scoreFrom.money += money;
    }
}

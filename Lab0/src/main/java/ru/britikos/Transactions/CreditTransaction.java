package ru.britikos.Transactions;


import ru.britikos.BankAccount.Account;
import ru.britikos.Banks.Bank;

public class CreditTransaction extends Transaction{
    /**
     * Конструктор
     * @param id
     * @param money
     * @param scoreFrom
     * @param scoreTo
     * @param bank
     */
    public CreditTransaction(long id, double money, Account scoreFrom, Account scoreTo, Bank bank) {
        super(id, money, scoreFrom, scoreTo, bank);
    }

    /**
     * Метод, проверяющий корректность транзакции.
     */
    @Override
    public void check() {

    }

    /**
     * Метод, добавляющий транзакцию.
     */
    @Override
    public void addTransaction() {
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

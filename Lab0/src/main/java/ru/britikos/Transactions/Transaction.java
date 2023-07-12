package ru.britikos.Transactions;


import ru.britikos.BankAccount.Account;
import ru.britikos.Banks.Bank;

/**
 * ### Операции и транзакции
 *
 * Каждый счет должен предоставлять механизм **снятия**, **пополнения** и **перевода** денег
 * (то есть счетам нужны некоторые идентификаторы).
 *
 * Еще обязательный механизм, который должны иметь банки - **отмена транзакций**.
 * Если вдруг выяснится, что транзакция была совершена злоумышленником, то такая транзакция должна быть отменена.
 * Отмена транзакции подразумевает возвращение банком суммы обратно. Транзакция не может быть повторно отменена.
 *
 * Счёта должны хранить в себе историю совершённых над ними транзакций.
 */
public abstract class Transaction {
    /**
     * Конструктор создающий транзакции
     * @param id
     * @param money
     * @param scoreFrom
     * @param scoreTo
     * @param bank
     */
    public Transaction(long id, double money, Account scoreFrom, Account scoreTo, Bank bank ){
        this.money = money;
        this.number = id;
        this.scoreFrom = scoreFrom;
        this.scoreTo = scoreTo;
        this.bank = bank;
    }
    public long number;
    public double money;
    public Account scoreFrom;
    public Account scoreTo;
    public Bank bank;
    public boolean isCorrect = false;

    /**
     * Метод, проверяющий корректность транзакции.
     */
    public abstract void check();

    /**
     * Метод, добавляющий транзакцию.
     */
    public abstract void addTransaction();

    /**
     * Метод, удаляющий транзакцию.
     */
    public abstract void deleteTransaction();
}

package ru.britikos.BankAccount;



import ru.britikos.Banks.Bank;
import ru.britikos.Clients.Client;

import java.util.Date;

/**
 * Кредитный счет – имеет кредитный лимит, в рамках которого можно уходить в минус (в плюс тоже можно).
 * Процента на остаток нет. Есть фиксированная комиссия за использование, если клиент в минусе.
 */
public class Credit extends Account{
    /**
     * Конструктор
     * @param startDay
     * @param endDay
     * @param creditSum
     * @param bank
     */
    public Credit(long id,Date startDay,Date endDay, double creditSum, Bank bank){
        this.id = id;
        this.money = creditSum;
        this.endDay = endDay;
        this.startDay = startDay;
        this.bank = bank;
        this.comissionMoney = bank.creditPersents;
        this.type = TypeScore.Credit;
    }

    /**
     * Метод, который начисляет проценты на счет
     */
    @Override
    public void accrualOfInterest(){
        if(money < 0)
            money -= money*(comissionMoney/356);
    }

    @Override
    public void setClient(Client owner){
        this.owner = owner;
    }
}

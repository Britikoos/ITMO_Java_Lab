package ru.britikos.BankAccount;



import ru.britikos.Banks.Bank;
import ru.britikos.Clients.Client;

import java.util.Date;

/**
 * Дебетовый счет – обычный счет с фиксированным процентом на остаток.
 * Деньги можно снимать в любой момент, в минус уходить нельзя. Комиссий нет.
 */
public class Debit extends Account{
    /**
     * Конструктор с параметрами
     * @param id
     * @param startDay
     * @param endDay
     * @param startSum
     * @param bank
     */
    public Debit(long id, Date startDay,Date endDay,double startSum, Bank bank){
        this.money = startSum;
        this.endDay = endDay;
        this.startDay = startDay;
        this.bank = bank;
        comissionMoney = bank.debitPersents;
        this.type = TypeScore.Debit;
    }
    /**
     * Метод, который начисляет проценты на счет
     */
    @Override
    public void accrualOfInterest(){
        if(money > 0)
            money += comissionMoney;
    }

    @Override
    public void setClient(Client owner){
        this.owner = owner;
    }
}

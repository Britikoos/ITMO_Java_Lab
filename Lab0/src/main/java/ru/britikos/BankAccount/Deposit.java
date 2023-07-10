package ru.britikos.BankAccount;



import ru.britikos.Banks.Bank;
import ru.britikos.Clients.Client;

import java.util.Date;

/**
 * Депозитный счет – счет, с которого нельзя снимать и переводить деньги до тех пор, пока не закончится его срок (пополнять можно). Процент на остаток зависит от изначальной суммы, например, если открываем депозит до 50 000 р. - 3%,
 * если от 50 000 р. до 100 000 р. - 3.5%, больше 100 000 р. - 4%. Комиссий нет.
 * Проценты должны задаваться для каждого банка свои.
 */

public class Deposit extends Account{

    /**
     * Конструктор с параметрами
     * @param id
     * @param startDay
     * @param endDay
     * @param startSum
     * @param bank
     */
    public Deposit(long id, Date startDay, Date endDay,double startSum, Bank bank){
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.money = startSum;
        this.bank = bank;
        setPercent();
        this.type = TypeScore.Deposite;
    }

    /**
     * Метод, который определяет процент в зависимости от суммы вклада.
     */
    public void setPercent() {
        if(money < 50000)
            comissionMoney = bank.DepositePersents[0];
        if (money > 50000 && money < 100000)
            comissionMoney = bank.DepositePersents[1];
        if (money > 100000)
            comissionMoney = bank.DepositePersents[2];
    }

    /**
     * Метод, который начисляет проценты на счет
     */
    @Override
    public void accrualOfInterest(){
            money += money*(comissionMoney/365);
    }

    @Override
    public void setClient(Client owner){
        this.owner = owner;
    }

}

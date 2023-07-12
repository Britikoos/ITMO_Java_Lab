package ru.britikos.BankAccount;
import ru.britikos.Banks.Bank;
import ru.britikos.Clients.Client;
import ru.britikos.TimeMachine.PersonalTimeMachine;

import java.util.Date;

/**
 * Абстрактный метод на основе которого мы создаем разные типы платежных аккаунтов.
 * Счета бывают трёх видов: Дебетовый счет, Депозит и Кредитный счет. Каждый счет принадлежит какому-то клиенту.
 */
public abstract class Account {

    public long id;
    public double money;
    public Bank bank;
    public Date startDay;
    public Date endDay;
    public float comissionMoney = 0;
    public Client owner;
    public PersonalTimeMachine timeTravel;
    public TypeScore type;
    /**
     * Метод, который начисляет проценты на счет
     */
    public abstract void accrualOfInterest();

    public abstract void setClient(Client owner);
    /**
     * Метод показывающий состояние счета в любую дату.
     * @param EndData
     * @return
     */
    public double goToFuture(Date EndData){
        timeTravel = new PersonalTimeMachine(money, startDay, comissionMoney);
        return timeTravel.startMachine(EndData);
    }
}

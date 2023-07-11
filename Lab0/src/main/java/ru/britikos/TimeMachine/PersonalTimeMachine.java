
package ru.britikos.TimeMachine;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Класс помогающий показать состояние счета в определенный день.
 */
public class PersonalTimeMachine {
    /**
     * Конструктор
     * @param money
     * @param startDay
     * @param comissionMoney
     */
    public PersonalTimeMachine(double money, Date startDay, float comissionMoney){
        futureMoney = money;
        this.startDay = startDay;
        this.comissionMoney = comissionMoney;
    }
    public double futureMoney;
    public Date startDay;
    public float comissionMoney;

    /**
     * Метод, показывающий состояние счета в определенную дата.
     * @param EndDate
     * @return
     */
    public double startMachine(Date EndDate){
        long NumDay = TimeUnit.DAYS.convert(Math.abs(startDay.getTime() - EndDate.getTime()), TimeUnit.MILLISECONDS);
        futureMoney = (futureMoney * (comissionMoney/365) * NumDay);
        System.out.println("Остаток на вашем счете равен");
        System.out.println((int)futureMoney);
        return futureMoney;
    }
}

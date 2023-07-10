import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ru.britikos.BankAccount.Debit;
import ru.britikos.BankAccount.Deposit;
import ru.britikos.Banks.Bank;
import ru.britikos.Banks.CentralBank;
import ru.britikos.Clients.Client;
import ru.britikos.Clients.Name;
import ru.britikos.Clients.Passport;
import ru.britikos.Transactions.DebitTransaction;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BankTest {
    public CentralBank mainBank;
    @Test
    public void TestSystems(){
        CentralBank mainBank = CentralBank.getInstance();
        Bank sber = mainBank.createBank("SberBank", 3.1F, 400.0F, new float[]{3.0F, 3.5F, 4.0F});
        mainBank.addBank(sber);
        Client el = mainBank.createClient(new Name("Элиза","Бритикова"), new Date(17032003), new Passport(4523, 234567));
        mainBank.addClient(el, sber);
        Deposit score1 = new Deposit(1, new Date(), new Date(13012025), 100000, sber);
        mainBank.addAccount(score1, el);

        Assertions.assertEquals("SberBank",mainBank.Banks.get(0).name);

        Assertions.assertEquals("Элиза", mainBank.Clients.get(0).fullName.firstName);

        Assertions.assertEquals("Бритикова", sber.Clients.get(0).fullName.secondName);

        assertEquals(1, mainBank.Accounts.size());
    }

    @Test
    public void TestTransaction(){
        CentralBank mainBank = CentralBank.getInstance();
        Bank sber = mainBank.createBank("SberBank", 3.1F, 400.0F, new float[]{3.0F, 3.5F, 4.0F});
        mainBank.addBank(sber);
        Client el = mainBank.createClient(new Name("Элиза","Бритикова"), new Date(17032003), new Passport(4523, 234567));
        mainBank.addClient(el, sber);
        Deposit score1 = new Deposit(1, new Date(), new Date(13012025), 100000, sber);
        mainBank.addAccount(score1, el);;

        Debit score2 = new Debit(2, new Date(), new Date(13012025), 100000, sber);
        DebitTransaction transfer1  = new DebitTransaction(1, 10230, score1, score2,sber);
        el.addTransaction(transfer1);

        Assertions.assertEquals(89770, score1.money);
        Assertions.assertEquals(110230, score2.money);

        el.deleteTransaction(transfer1);
        assertEquals((int)score1.money, (int)score2.money);

    }

    @Test
    public void TestTimeMachine(){
        CentralBank mainBank = CentralBank.getInstance();
        Bank sber = mainBank.createBank("SberBank", 3.1F, 400.0F, new float[]{3.0F, 3.5F, 4.0F});
        mainBank.addBank(sber);
        Client el = mainBank.createClient(new Name("Элиза","Бритикова"), new Date(17032003), new Passport(4523, 234567));
        mainBank.addClient(el, sber);
        Deposit score1 = new Deposit(1, new Date(), new Date(13012025), 100000, sber);
        mainBank.addAccount(score1, el);

        Assertions.assertEquals(2142137, score1.goToFuture(new Date(9072024)), 100);
    }

}


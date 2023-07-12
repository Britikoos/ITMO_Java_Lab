package ru.britikos.Banks;

public class BankBuilder extends Builder {
    Bank bank = new Bank();

    @Override
    public void setName(String Name) {
        bank.name = Name;
    }
    @Override
    public void setId(long id){bank.id = id;}
    @Override
    public void setCreditPercents(float Percents) {
        bank.creditPersents = Percents;
    }

    @Override
    public void setDebitPercents(float Percents) {
        bank.debitPersents = Percents;
    }

    @Override
    public void setDepositePercents(float[] Percents) {
        bank.DepositePersents = Percents;
    }

    @Override
    public Bank getResult() {
        return bank;
    }
}

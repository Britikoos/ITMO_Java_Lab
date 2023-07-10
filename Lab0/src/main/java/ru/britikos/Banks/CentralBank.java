package ru.britikos.Banks;



import ru.britikos.BankAccount.Account;
import ru.britikos.Clients.Client;
import ru.britikos.Clients.ClientBuilder;
import ru.britikos.Clients.Name;
import ru.britikos.Clients.Passport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Центральный банк
 *
 * Регистрацией всех банков, а также взаимодействием между банками занимается центральный банк.
 * Он должен управлять банками (предоставлять возможность создать банк) и предоставлять необходимый функционал,
 * чтобы банки могли взаимодействовать с другими банками (например, можно реализовать переводы между банками через него).
 * Он также занимается уведомлением других банков о том, что нужно начислять остаток или комиссию -
 * для этого механизма не требуется создавать таймеры и завязываться на реальное время.
 */
public class CentralBank {
    /**
     * Паттерн одиночка
     */
    private static CentralBank instance;

    private CentralBank(){}

    /**
     *
     * @return
     */
    public static CentralBank getInstance(){
        if(instance == null){
            instance = new CentralBank();
        }
        return instance;
    }
    public long id =0;
    public List<Client> Clients = new ArrayList();
    public List<Account> Accounts = new ArrayList();
    public List<Bank> Banks = new ArrayList();

    /**
     * Метод создает клиента.
     * @param fullName
     * @param Birth
     * @param number
     * @return
     */
    public Client createClient(Name fullName, Date Birth, Passport number){
        ClientBuilder builder = new ClientBuilder();
        builder.setBirthDay(Birth);
        builder.setFullName(fullName);
        builder.setPassport(number);
        return builder.getResult();
    }

    /**
     * Метод добавляет клиента в банковскую систему.
     * @param owner
     * @param bank
     * @return
     */
    public Client addClient(Client owner, Bank bank){
        bank.addClient(owner);
        Clients.add(owner);
        return owner;
    }

    /**
     * Метод создает банк в банковской системе.
     * @param name
     * @param credit
     * @param debit
     * @param deposit
     * @return
     */
    public Bank createBank(String name,float credit, float debit, float[] deposit ){
        BankBuilder builder = new BankBuilder();
        builder.setName(name);
        builder.setId(++id);
        builder.setCreditPercents(credit);
        builder.setDebitPercents(debit);
        builder.setDepositePercents(deposit);
        return builder.getResult();
    }

    /**
     * Метод добавляет банк в банковскую систему.
     * @param bank
     */
    public void addBank(Bank bank) {
        if (!Banks.contains(bank))
            Banks.add(bank);
        else {
            try {
                throw new Exception("This bank already exists");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Метод доавляет аккаунт в банковскую систему.
     * @param account
     */
    public Account addAccount(Account account, Client owner){
        account.bank.createAccount(account);
        Accounts.add(account);
        account.setClient(owner);
        return account;
    }

    public Bank findBank(long id){
        for(int i =0 ; i < Banks.size(); i++){
            if(Banks.get(i).id == id)
                return Banks.get(i);
        }
        return Banks.get(0);
    }

    public Account findAccount(long id){
        for(int i =0 ; i < Accounts.size(); i++){
            if(Accounts.get(i).id == id)
                return Accounts.get(i);
        }
        return Accounts.get(0);
    }

    public Client findClient(long id){
        for(int i =0 ; i < Clients.size(); i++){
            if(Clients.get(i).id == id)
                return Clients.get(i);
        }
        return Clients.get(0);
    }

    public long getId(){
        return id++;
    }
    /**
     * Метод списывает проценты.
     */
    public void accrualOfInterest(){
        for( int i = 0; i < Accounts.size(); i++)
            Accounts.get(i).accrualOfInterest();
    }
}

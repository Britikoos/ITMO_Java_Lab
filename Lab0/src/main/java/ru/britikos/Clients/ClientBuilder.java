package ru.britikos.Clients;

import java.util.Date;

public class ClientBuilder extends Builder{
    Client owner = new Client();

    @Override
    public void setId(long id){
        owner.id = id;
    }
    @Override
    public void setFullName(Name fullName){
        owner.fullName = fullName;
    }

    @Override
    public void setPassport(Passport passport){
        owner.passport = passport;
    }
    @Override
    public void setBirthDay(Date birth){
        owner.birthDay = birth;
    }
    @Override
    public Client getResult(){
        return owner;
    }
}

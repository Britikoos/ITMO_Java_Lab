package ru.britikos.Clients;

import java.util.Date;

abstract class Builder {
    public abstract  void setId(long id);
    public abstract void setFullName(Name fullName);
    public abstract void setPassport(Passport passport);
    public abstract void setBirthDay(Date birth);
    public abstract Client getResult();
}
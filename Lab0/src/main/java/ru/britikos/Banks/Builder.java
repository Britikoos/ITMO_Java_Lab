package ru.britikos.Banks;

abstract class Builder {
    public abstract void setName(String name);
    public abstract void setId(long id);
    public abstract void setCreditPercents(float percents);
    public abstract void setDebitPercents(float percents);
    public abstract void setDepositePercents(float[] percents);
    public abstract Bank getResult();
}

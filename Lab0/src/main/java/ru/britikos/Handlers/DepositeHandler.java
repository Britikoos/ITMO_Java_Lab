package ru.britikos.Handlers;

public classDepositeHandler extends Handler{
    @Override
    public void Handle(Receiver receiver)
    {
        if (receiver.DepositeA == true)
            System.out.println("Выполняем банковский перевод");
        else if (getSuccessor() != null)
            getSuccessor().Handle(receiver);
    }
}

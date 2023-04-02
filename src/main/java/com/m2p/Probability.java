package com.m2p;

public class Probability {

    private final double probabilityValue;


    public Probability(double probabilityValue)
    {
        this.probabilityValue = probabilityValue;
    }

    @Override
    public boolean equals(Object probabilityObject)
    {
        if(this == probabilityObject)
        {
            return true;
        }
        if(probabilityObject == null || getClass() != probabilityObject.getClass())
        {
            return false;
        }
        return probabilityValue == ((Probability)probabilityObject).probabilityValue;
    }

    public Probability and(Probability anotherEvent)
    {
        return new Probability(this.probabilityValue * anotherEvent.probabilityValue);
    }

    public Probability not()
    {
        return new Probability(1-this.probabilityValue);
    }

    public Probability or(Probability anotherEvent) {

        return (this.not()).and(anotherEvent.not()).not();
    }
}

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
        if(getClass() != probabilityObject.getClass())
        {
            return false;
        }
        return probabilityValue == ((Probability)probabilityObject).probabilityValue;
    }

    public Probability and(Probability event)
    {
        return new Probability(probabilityValue * event.probabilityValue);
    }

    public Probability not()
    {
        return new Probability(1-probabilityValue);
    }
}

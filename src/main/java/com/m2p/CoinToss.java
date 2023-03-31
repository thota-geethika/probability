package com.m2p;

public class CoinToss {

    private final double tossProbability;

    public CoinToss(double tossProbability)
    {
        this.tossProbability = tossProbability;
    }

    @Override
    public boolean equals(Object object)
    {
        return tossProbability == ((CoinToss)object).tossProbability;
    }
}

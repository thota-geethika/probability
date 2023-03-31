package com.m2p;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CoinTossTest {

    @Test
    void toReturnEqualityWhenProbabilityOfHeadsIsComparedToProbabilityOfTails()
    {
        CoinToss HeadsProbability = new CoinToss(0.5);
        CoinToss TailsProbability = new CoinToss(0.5);

        assertThat(HeadsProbability,is(equalTo(TailsProbability)));
    }
}

package com.m2p;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ProbabilityTest {

    @Test
    void toReturnEqualityWhenProbabilityOfHeadsIsComparedToProbabilityOfTailsInACoinToss()
    {
        Probability HeadsProbabilityInACoinToss = new Probability(0.5);
        Probability TailsProbabilityInACoinToss = new Probability(0.5);

        assertThat(HeadsProbabilityInACoinToss,is(equalTo(TailsProbabilityInACoinToss)));
    }

    @Test
    void toReturnProbabilityAsOneWhenOccurringOfTwoEventsIsCertain()
    {
        Probability probabilityOfOneEventToHappenCertainly = new Probability(1);
        Probability probabilityOfAnotherEventToHappenCertainly = new Probability(1);

        Probability twoCertainEventsOccurringTogether = new Probability(1);

        assertThat(twoCertainEventsOccurringTogether,is(equalTo(probabilityOfOneEventToHappenCertainly.and(probabilityOfAnotherEventToHappenCertainly))));
    }

    // The probability of getting head in one toss is independent of getting toss in another toss
    @Test
    void toReturnZeroPointTwoFiveWhenHeadsOccurInOneTossAndHeadsOccurInAnotherToss()
    {
        Probability probabilityOfHeadsInOneToss = new Probability(0.5);
        Probability probabilityOfHeadsInAnotherToss = new Probability(0.5);

        Probability eventsOccurringTogether = new Probability(0.25);

        assertThat(eventsOccurringTogether,is(equalTo(probabilityOfHeadsInOneToss.and(probabilityOfHeadsInAnotherToss))));
    }

    @Test
    void toReturnOneWhenProbabilityOfAnEventNotOccurringIsCertain()
    {
        Probability probabilityThatEventDoNotHappenCertainly = new Probability(1);

        Probability probabilityOfEventNotOccurring = new Probability(0);

        assertThat(probabilityOfEventNotOccurring,is(equalTo(probabilityThatEventDoNotHappenCertainly.not())));
    }

    @Test
    void toReturnZeroPointSixWhenTheProbabilityOfAnEventOccurringIsZeroPointFour()
    {
        Probability probabilityOfAnEventOccurring = new Probability(0.4);

        Probability probabilityOfAnEventNotOccurring = new Probability(0.6);

        assertThat(probabilityOfAnEventNotOccurring,is(equalTo(probabilityOfAnEventOccurring.not())));
    }
}

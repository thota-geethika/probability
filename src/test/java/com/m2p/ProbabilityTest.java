package com.m2p;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class ProbabilityTest {

    private static final Probability certainEventProbability = new Probability(1);
    private static final Probability impossibleEventProbability = new Probability(0);
    private static final Probability headsProbabilityInACoinToss = new Probability(0.5);
    private static final Probability tailsProbabilityInACoinToss = new Probability(0.5);


    @Nested
    class ProbabilityEquality {
        @Test
        void toReturnEqualityWhenProbabilityOfHeadsIsComparedToProbabilityOfTailsInACoinToss()
        {

            assertThat(headsProbabilityInACoinToss, is(equalTo(tailsProbabilityInACoinToss)));
        }

        @Test
        void toCheckInEqualityWhenProbabilityOfHeadsInACoinTossIsComparedWithNullValue()
        {
            assertThat(headsProbabilityInACoinToss,is(not(equalTo(null))));
        }

        @Test
        void toCheckInEqualityWhenProbabilityOfHeadsInACoinTossIsComparedWithGettingOneInADiceRoll()
        {
            Probability probabilityOfGettingOneInADiceRoll = new Probability(0.16);

            assertThat(headsProbabilityInACoinToss,is(not(equalTo(probabilityOfGettingOneInADiceRoll))));
        }

        @Test
        void toCheckInEqualityWhenProbabilityOfHeadsInACoinTossIsComparedWithAPrimitiveValue()
        {
            double probabilityOfTailInACoinToss = 0.5;

            assertThat(headsProbabilityInACoinToss,is(not(equalTo(probabilityOfTailInACoinToss))));
        }
    }
    @Nested
    class And {
        @Test
        void toGetACertainEventWhenTwoCertainEventsAreHappeningTogether() {
            Probability anotherCertainEventProbability = new Probability(1);

            assertThat(certainEventProbability, is(equalTo(certainEventProbability.and(anotherCertainEventProbability))));
        }

        // The probability of getting head in one toss is independent of getting toss in another toss
        @Test
        void toReturnZeroPointTwoFiveWhenHeadsOccurInOneTossAndHeadsOccurInAnotherToss() {
            Probability probabilityOfHeadsInOneToss = new Probability(0.5);
            Probability probabilityOfHeadsInAnotherToss = new Probability(0.5);

            Probability eventsOccurringTogether = new Probability(0.25);

            assertThat(eventsOccurringTogether, is(equalTo(probabilityOfHeadsInOneToss.and(probabilityOfHeadsInAnotherToss))));
        }
    }

    @Nested
    class Not {
        @Test
        void toGetAnImpossibleEventProbabilityWhenACertainEventIsNotHappening()
        {
            assertThat(certainEventProbability.not(), is(equalTo(impossibleEventProbability)));
        }

        @Test
        void toReturnZeroPointSixWhenTheProbabilityOfAnEventOccurringIsZeroPointFour() {
            Probability probabilityOfAnEventOccurring = new Probability(0.4);

            Probability probabilityOfAnEventNotOccurring = new Probability(0.6);

            assertThat(probabilityOfAnEventNotOccurring, is(equalTo(probabilityOfAnEventOccurring.not())));
        }
    }

    @Nested
    class Or
    {

        @Test
        void toGetACertainEventWhenACertainEventOrAnImpossibleEventIsHappening()
        {
            assertThat(certainEventProbability.or(impossibleEventProbability),is(equalTo(certainEventProbability)));
        }
        @Test
        void toReturnZeroPointSevenFiyveWhenEitherHeadsOrTailsInACoinTossIsHappening()
        {
            Probability probabilityOfEitherHeadsOrTailsInACoinToss = new Probability(0.75);

            assertThat(headsProbabilityInACoinToss.or(tailsProbabilityInACoinToss),is(equalTo(probabilityOfEitherHeadsOrTailsInACoinToss)));
        }
    }
}

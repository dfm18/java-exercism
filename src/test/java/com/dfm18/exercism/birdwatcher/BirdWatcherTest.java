package com.dfm18.exercism.birdwatcher;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BirdWatcherTest {

    private BirdWatcher birdWatcher;

    private static final int DAY1 = 0;
    private static final int DAY2 = 2;
    private static final int DAY3 = 5;
    private static final int DAY4 = 3;
    private static final int DAY5 = 7;
    private static final int DAY6 = 8;
    private static final int TODAY = 4;

    @BeforeEach
    void setUp() {
        int[] birdsPerDay = { DAY1, DAY2, DAY3, DAY4, DAY5, DAY6, TODAY };
        birdWatcher = new BirdWatcher(birdsPerDay);
    }

    @Test
    @DisplayName("The getLastWeek method correctly returns last week's counts")
    public void itTestGetLastWeek() {
        assertThat(birdWatcher.getLastWeek()).containsExactly(DAY1, DAY2, DAY3, DAY4, DAY5, DAY6, TODAY);
    }

    @Test
    @DisplayName("The getToday method correctly returns today's counts")
    public void itTestGetToday() {
        assertThat(birdWatcher.getToday()).isEqualTo(TODAY);
    }

    @Test
    @DisplayName("The incrementTodaysCount method correctly increments today's counts")
    public void itIncrementTodaysCount() {
        birdWatcher.incrementTodaysCount();
        assertThat(birdWatcher.getToday()).isEqualTo(TODAY + 1);
    }

    @Test
    @DisplayName("The hasDayWithoutBirds method returns true when day had no visits")
    public void itHasDayWithoutBirds() {
        assertThat(birdWatcher.hasDayWithoutBirds()).isTrue();
    }

    @Test
    @DisplayName("The hasDayWithoutBirds method returns false when no day had zero visits")
    public void itShouldNotHaveDaysWithoutBirds() {
        birdWatcher = new BirdWatcher(new int[] { 1, 2, 5, 3, 7, 8, 4 });
        assertThat(birdWatcher.hasDayWithoutBirds()).isFalse();
    }

    @Test
    @DisplayName("The getCountForFirstDays method returns correct visits' count for given number of days")
    public void itTestGetCountForFirstDays() {
        assertThat(birdWatcher.getCountForFirstDays(4)).isEqualTo(DAY1 + DAY2 + DAY3 + DAY4);
    }

    @Test
    @DisplayName("The getCountForFirstDays method returns overall count when number of days is higher than array size")
    public void itTestGetCountForMoreDaysThanTheArraySize() {
        assertThat(birdWatcher.getCountForFirstDays(10)).isEqualTo(DAY1 + DAY2 + DAY3 + DAY4 + DAY5 + DAY6 + TODAY);
    }

    @Test
    @DisplayName("The getBusyDays method returns the correct count of busy days")
    public void itTestGetCountForBusyDays() {
        assertThat(birdWatcher.getBusyDays()).isEqualTo(3);
    }

    @Test
    @DisplayName("The getBusyDays method correctly returns zero in case of no busy days")
    public void itShouldNotHaveBusyDays() {
        birdWatcher = new BirdWatcher(new int[] { 1, 2, 3, 3, 2, 1, 4 });
        assertThat(birdWatcher.getBusyDays()).isEqualTo(0);
    }
}

package com.dfm18.exercism.cookyourlasagna;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LasagnaTest {

    @Test
    @DisplayName("Implemented the expectedMinutesInOven method")
    void implemented_expectedMinutesInOven() throws NoSuchMethodException {
        Method method = Lasagna.class.getMethod("expectedMinutesInOven");

        assertThat(method).isNotNull();
        assertThat(Modifier.isPublic(method.getModifiers())).isTrue();
        assertThat(method.getReturnType()).isEqualTo(int.class);
    }

    @Test
    @DisplayName("The expectedMinutesInOven method returns the correct value")
    void expectedMinutesInOven_returns_correct_value() {
        assertThat(new Lasagna().expectedMinutesInOven()).isEqualTo(40);
    }

    @Test
    @DisplayName("Implemented the remainingMinutesInOven method")
    void implemented_remainingMinutesInOven() throws NoSuchMethodException {
        Method method = Lasagna.class.getMethod("remainingMinutesInOven", int.class);

        assertThat(method).isNotNull();
        assertThat(Modifier.isPublic(method.getModifiers())).isTrue();
        assertThat(method.getReturnType()).isEqualTo(int.class);
    }

    @Test
    @DisplayName("The remainingMinutesInOven method calculates and returns the correct value")
    void remainingMinutesInOven_calculates_and_returns_correct_value() {
        assertThat(new Lasagna().remainingMinutesInOven(25)).isEqualTo(15);
    }

    @Test
    @DisplayName("Implemented the preparationTimeInMinutes method")
    void implemented_preparationTimeInMinutes() throws NoSuchMethodException {
        Method method = Lasagna.class.getMethod("preparationTimeInMinutes", int.class);

        assertThat(method).isNotNull();
        assertThat(Modifier.isPublic(method.getModifiers())).isTrue();
        assertThat(method.getReturnType()).isEqualTo(int.class);
    }

    @Test
    @DisplayName("The preparationTimeInMinutes method calculates the correct value for single layer")
    void preparationTimeInMinutes_returns_correct_value_for_one_layer() {
        assertThat(new Lasagna().preparationTimeInMinutes(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("The preparationTimeInMinutes method calculates the correct value for multiple layers")
    void preparationTimeInMinutes_returns_correct_value_for_multiple_layers() {
        assertThat(new Lasagna().preparationTimeInMinutes(4)).isEqualTo(8);
    }

    @Test
    @DisplayName("Implemented the totalTimeInMinutes method")
    void implemented_totalTimeInMinutes() throws NoSuchMethodException {
        Method method = Lasagna.class.getMethod("totalTimeInMinutes", int.class, int.class);

        assertThat(method).isNotNull();
        assertThat(Modifier.isPublic(method.getModifiers())).isTrue();
        assertThat(method.getReturnType()).isEqualTo(int.class);
    }

    @Test
    @DisplayName("The totalTimeInMinutes method calculates the correct value for single layer")
    void totalTimeInMinutes_returns_correct_value_for_one_layer() {
        assertThat(new Lasagna().totalTimeInMinutes(1, 30)).isEqualTo(32);
    }

    @Test
    @DisplayName("The totalTimeInMinutes method calculates the correct value for multiple layers")
    void totalTimeInMinutes_returns_correct_value_for_multiple_layers() {
        assertThat(new Lasagna().totalTimeInMinutes(4, 8)).isEqualTo(16);
    }

}

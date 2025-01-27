package com.dfm18.exercism.karlslanguages;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LanguageListTest {

    private LanguageList languageList;

    @BeforeEach
    void setUp() {
        languageList = new LanguageList();
    }

    @Test
    @DisplayName("The isEmpty method returns true when the list contains no languages")
    public void empty() {
        assertThat(languageList.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("The isEmpty method returns false after adding a language to the list")
    public void nonEmpty() {
        languageList.addLanguage("Java");
        assertThat(languageList.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("The removeLanguage method correctly removes a language from the list")
    public void removeLanguage() {
        languageList.addLanguage("Java");
        languageList.removeLanguage("Java");
        assertThat(languageList.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("The firstLanguage method returns the first language that was added to the list")
    public void firstLanguage() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");
        assertThat(languageList.firstLanguage()).isEqualTo("Java");
    }

    @Test
    @DisplayName("The count method returns the number of languages in the list")
    public void countThree() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");
        assertThat(languageList.count()).isEqualTo(3);
    }

    @Test
    @DisplayName("The count method returns 0 when the list is empty")
    public void countEmpty() {
        assertThat(languageList.count()).isEqualTo(0);
    }

    @Test
    @DisplayName("The containsLanguage method returns true when the language is in the list")
    public void containsLanguage() {
        languageList.addLanguage("Java");
        assertThat(languageList.containsLanguage("Java")).isTrue();
    }

    @Test
    @DisplayName("The containsLanguage method returns false when the language is not in the list")
    public void doesNotContainLanguage() {
        languageList.addLanguage("Kotlin");
        assertThat(languageList.containsLanguage("Java")).isFalse();
    }

    @Test
    @DisplayName("The isExciting method returns true when the list contains Java")
    public void excitingLanguageListWithJava() {
        languageList.addLanguage("Java");
        assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    @DisplayName("The isExciting method returns true when the list contains Kotlin")
    public void excitingLanguageListWithKotlin() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Kotlin");
        assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    @DisplayName("The isExciting method returns false when the list contains neither Java nor Kotlin")
    public void boringLanguageList() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");
        assertThat(languageList.isExciting()).isFalse();
    }
}

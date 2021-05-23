package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.lang.IllegalArgumentException;

public class ConfigTest {

    @Test
    public void whenPairWithoutCommentAndWithoutEmptyLines() {
        String path = "./data/pair_without_comment_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.getNumOfLinesInConfig(), is(5));
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }

    @Test
    public void whenPairWithCommentAndWithoutEmptyLines() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.getNumOfLinesInConfig(), is(5));
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }

    @Test
    public void whenPairWithoutCommentAndWithEmptyLines() {
        String path = "./data/pair_with_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.getNumOfLinesInConfig(), is(5));
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithInvalidKeyThenException() {
        String path = "./data/pair_with_invalid_key.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithInvalidValueThenException() {
        String path = "./data/pair_with_invalid_value.properties";
        Config config = new Config(path);
        config.load();
    }
}
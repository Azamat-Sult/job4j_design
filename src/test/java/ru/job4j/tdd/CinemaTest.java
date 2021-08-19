package ru.job4j.tdd;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class CinemaTest {

    /*@Test
    public void whenBuyThenTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void whenBuyThenNoSuchAccount() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Test
    public void whenBuyThenSeatIsBusy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Test
    public void whenBuyThenWrongDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Test
    public void whenFindThenFound() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D(), new Session3D())));
    }

    @Test
    public void whenFindThenNotFound() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertTrue(sessions.isEmpty());
    }

    @Test
    public void whenAddSessionThenNewSession() {
        Cinema cinema = new Cinema3D();
        Session newSession = new Session3D();
        cinema.add(newSession);
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Collections.singletonList(newSession)));
    }

    @Test
    public void whenAddSessionThenSessionAlreadyExist() {
        Cinema cinema = new Cinema3D();
        Session newSession = new Session3D();
        cinema.add(newSession);
        cinema.add(newSession);
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.size(), is(1));
    }*/
}

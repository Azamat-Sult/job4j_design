package ru.job4j.ood.isp.example1;

public class OldPhone implements Phone {

    @Override
    public void call() {
        // call
    }

    @Override
    public void sendSMS() {
        // unsupported
    }

    @Override
    public void navigate() {
        // unsupported
    }

    @Override
    public void surfInternet() {
        // unsupported
    }
}

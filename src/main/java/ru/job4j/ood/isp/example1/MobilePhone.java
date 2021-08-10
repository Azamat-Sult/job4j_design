package ru.job4j.ood.isp.example1;

public class MobilePhone implements Phone {

    @Override
    public void call() {
        // call
    }

    @Override
    public void sendSMS() {
        // send sms
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

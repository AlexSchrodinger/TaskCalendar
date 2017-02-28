package ru.bernarsoft.common.utilities;

public class Notificator {

    public static void notifyAdminEnter(String email) {
        MailSender.sendMail(email, "Welcome Admin!");
    }
}
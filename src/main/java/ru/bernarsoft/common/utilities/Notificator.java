package ru.bernarsoft.common.utilities;

import org.springframework.stereotype.Component;

@Component
public class Notificator {

    public void notifyAdminEnter(String email) {
        MailSender.sendMail(email, "Welcome Admin!");
    }
}
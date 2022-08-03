package com.example.codeup.springblog.services;

import com.example.codeup.springblog.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Post post, String subject) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(subject);
        String body = "Thank you for posting to your Spring Blog The title of your post is:" +
                " " + post.getTitle() + ". If this was not you, contact customer support." ;
        msg.setText(body);

        try {
            this.emailSender.send(msg);

        } catch(MailException mex) {
            System.out.println(mex.getMessage());
        }
    }

}

package chandu.mailerFrame.mailservice.service;



import chandu.mailerFrame.mailservice.Model.MailDto;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailServiceImpl  implements  MailService  {



    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    private SimpleMailMessage message = new SimpleMailMessage();



    @Override
    public void sendMail(MailDto mailDto) {



       mailSender.setHost(mailDto.getHost());
       mailSender.setPort(mailDto.getPort());
       mailSender.setUsername(mailDto.getUserName());
        mailSender.setPassword(mailDto.getPassword());



        message.setTo(mailDto.getTo());
        message.setSubject(mailDto.getFrom());
        message.setText(mailDto.getContent());

       // System.out.println(mailSender.getJavaMailProperties());
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

       // System.out.println(mailSender.getJavaMailProperties());


        mailSender.setJavaMailProperties(props);
        try {
            mailSender.send(message);
        }
        catch (Exception e)
        {
           System.out.println("Unable to send mail:");
           e.printStackTrace();
        }


       }


}

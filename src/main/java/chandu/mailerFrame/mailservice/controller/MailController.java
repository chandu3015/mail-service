package chandu.mailerFrame.mailservice.controller;


import chandu.mailerFrame.mailservice.Model.MailDto;
import chandu.mailerFrame.mailservice.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mailer")
public class MailController {


    private MailService mailService;

    public MailController(MailService mailService)
    {
        this.mailService = mailService;
    }

    @PostMapping
    @ResponseStatus
    public void handlePost(@RequestBody MailDto mailDto)
    {
      mailService.sendMail(mailDto);
    }


}

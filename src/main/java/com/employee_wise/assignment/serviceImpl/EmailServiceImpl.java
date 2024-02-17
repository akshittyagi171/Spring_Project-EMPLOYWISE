package com.employee_wise.assignment.serviceImpl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.employee_wise.assignment.constants.ErrorCodeEnum;
import com.employee_wise.assignment.entity.EmailDetails;
import com.employee_wise.assignment.exceptions.EmployeeException;
import com.employee_wise.assignment.response.EmailResponse;
import com.employee_wise.assignment.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
 

@Service
public class EmailServiceImpl implements EmailService {
 
    @Autowired private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}") private String sender;
 
    public EmailResponse sendSimpleMail(EmailDetails details)
    {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.recipient());
            mailMessage.setText(details.msgBody());
            mailMessage.setSubject(details.subject());
 
            javaMailSender.send(mailMessage);
            return new EmailResponse(details.recipient(),"Email is Successfully sent to Recipent.");
        }
        catch (Exception e) {
        	throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
					ErrorCodeEnum.MAIL_NOT_SENT.getErrorCode(),
					ErrorCodeEnum.MAIL_NOT_SENT.getErrorMessage());
        }
    }
 
    public EmailResponse sendMailWithAttachment(EmailDetails details)
    {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.recipient());
            mimeMessageHelper.setText(details.msgBody());
            mimeMessageHelper.setSubject(details.subject());
 
            FileSystemResource file = new FileSystemResource(new File(details.attachment()));
 
            mimeMessageHelper.addAttachment(file.getFilename(), file);

            javaMailSender.send(mimeMessage);
            return new EmailResponse(details.recipient(),"Email with provided Attachment is Successfully sent to Recipent.");
        }
        catch (MessagingException e) {
        	throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
					ErrorCodeEnum.MAIL_NOT_SENT.getErrorCode(),
					ErrorCodeEnum.MAIL_NOT_SENT.getErrorMessage());
        }
    }
}

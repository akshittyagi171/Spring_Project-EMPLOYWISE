package com.employee_wise.assignment.service;

import com.employee_wise.assignment.entity.EmailDetails;
import com.employee_wise.assignment.response.EmailResponse;

public interface EmailService {
    EmailResponse sendSimpleMail(EmailDetails details);
    EmailResponse sendMailWithAttachment(EmailDetails details);
}

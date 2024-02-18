package com.employee_wise.assignment.entity;

public record EmailDetails (
        String recipient,
        String msgBody,
        String subject,
        String attachment
) implements NonNullCopier<EmailDetails>{}

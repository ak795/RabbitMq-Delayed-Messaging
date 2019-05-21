package com.retryRabbitMq.retryRabbitMq.controllers;

import com.retryRabbitMq.retryRabbitMq.pojos.Employee;
import com.retryRabbitMq.retryRabbitMq.services.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class SendController {

    @Autowired
    RabbitMqSender rabbitMqSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {
        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitMqSender.send(emp);

        return "Message sent to RabbitMQ successfully";
    }
}

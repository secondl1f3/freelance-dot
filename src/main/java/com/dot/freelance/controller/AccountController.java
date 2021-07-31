package com.dot.freelance.controller;

import com.dot.freelance.exception.NotFoundException;
import com.dot.freelance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController{

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Object getById(@PathVariable("id") String id) {
        try {
            return buildResponseGeneralSuccess(accountService.getById(id));
        } catch (NotFoundException e) {
            return buildResponseNotFound(e.getMessage());
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }
}

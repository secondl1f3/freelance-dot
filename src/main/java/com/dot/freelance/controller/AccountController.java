package com.dot.freelance.controller;

import com.dot.freelance.domain.Account;
import com.dot.freelance.dto.AccountDto;
import com.dot.freelance.exception.BadRequestException;
import com.dot.freelance.exception.NotFoundException;
import com.dot.freelance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController{

    @Autowired
    private AccountService accountService;

    @PostMapping("")
    public Object create(@Valid @RequestBody Account account){
        try {
            account.setIsDisabled(false);
            accountService.create(account);
            return buildResponseDataCreated();
        } catch (NotFoundException e) {
            return buildResponseNotFound(e.getMessage());
        } catch (BadRequestException e) {
            return buildResponseBadRequest(e.getMessage());
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }
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

    @GetMapping("")
    public Object getAll() {
        try {
            return buildResponseGeneralSuccess(accountService.getAllAccount());
        } catch (NotFoundException e) {
            return buildResponseNotFound(e.getMessage());
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }
}

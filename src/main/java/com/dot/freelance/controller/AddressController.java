package com.dot.freelance.controller;

import com.dot.freelance.dto.AddressDto;
import com.dot.freelance.exception.BadRequestException;
import com.dot.freelance.exception.ForbiddenException;
import com.dot.freelance.exception.NotFoundException;
import com.dot.freelance.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController{

    @Autowired
    private AddressService addressService;

    @PostMapping("")
    private Object create(@Valid @RequestBody AddressDto addressDto){
        try {
            addressService.create(addressDto);
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
            return buildResponseGeneralSuccess(addressService.getById(id));
        } catch (NotFoundException e) {
            return buildResponseNotFound(e.getMessage());
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }

    @GetMapping("")
    public Object getAll() {
        try {
            return buildResponseGeneralSuccess(addressService.getAllAddress());
        } catch (NotFoundException e) {
            return buildResponseNotFound(e.getMessage());
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Object updateAddress(@PathVariable("id") String id, @Valid @RequestBody AddressDto addressDto) {
        try {
            addressService.update(id, addressDto);
            return buildResponseGeneralSuccess();
        } catch (NotFoundException e) {
            return buildResponseNotFound(e.getMessage());
        } catch (BadRequestException e) {
            return buildResponseBadRequest(e.getMessage());
        } catch (ForbiddenException e){
            return buildResponseForbidden(e.getMessage());
        } catch (Exception e) {
            return buildResponseGeneralError(e.getMessage());
        }
    }
}

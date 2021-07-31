package com.dot.freelance.controller;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@ControllerAdvice
public abstract class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private ApplicationContext appCtx;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final int MAX_SIZE_PER_PAGE = 100;

    public static final String PAGE_PARAM_NOTES = "the value is absolute (non negative)";
    public static final String SIZE_PARAM_NOTES = "max value is 100";

    public static final int BOOLEAN_FALSE = 0;
    public static final int BOOLEAN_TRUE = 1;

    @Getter(value = AccessLevel.PRIVATE)
    private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Setter(value = AccessLevel.PRIVATE)
    @Getter(value = AccessLevel.PRIVATE)
    private Matcher matcher;

    @Setter(value = AccessLevel.PRIVATE)
    @Getter(value = AccessLevel.PRIVATE)
    private ResponseEntity<Object> response = null;

    public static final String RESPONSE_MESSAGE_LOGIN_ACCOUNT_NOT_FOUND = "The Logged In Account Not Found";

    public ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
		return new ResponseEntity<>(image, HttpStatus.OK);
	}
    
    public ResponseEntity<BufferedImage> NotFoundResponse() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<Object> buildResponseGeneralSuccess() {
        return buildResponseGeneralSuccess(null);
    }

    public ResponseEntity<Object> buildResponseDataCreated() {
        return buildResponseDataCreated(null);
    }


    public ResponseEntity<Object> buildResponseGeneralSuccess(Object data) {
        setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, ResponseStatus.GENERAL_SUCCESS), HttpStatus.OK));
        return this.response;
    }

    public ResponseEntity<Object> buildResponseDataCreated(Object data) {
        setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, ResponseStatus.DATA_CREATED), HttpStatus.CREATED));
        return this.response;
    }

    public ResponseEntity<Object> ok(Object data) {
        return buildResponseGeneralSuccess(data);
    }

    public ResponseEntity<Object> buildResponseGeneralError(Object data) {
        setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, ResponseStatus.GENERAL_ERROR), HttpStatus.INTERNAL_SERVER_ERROR));
        return this.response;
    }

    public ResponseEntity<Object> buildResponseNotFound(Object data) {
        setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, ResponseStatus.GENERAL_NOT_FOUND), HttpStatus.NOT_FOUND));
        return this.response;
    }

    public ResponseEntity<Object> buildResponseBadRequest(Object data) {
        setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, ResponseStatus.GENERAL_WARN), HttpStatus.BAD_REQUEST));
        return this.response;
    }

    public ResponseEntity<Object> buildResponseForbidden(Object data) {
        setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, ResponseStatus.FORBIDDEN), HttpStatus.FORBIDDEN));
        return this.response;
    }


    public boolean validEmail(final String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public int safetifyPage(int page) {
        return Math.abs(page);
    }

    public int safetifySize(int size) {
        if (size < 0)
            return Math.abs(size);

        if (size > MAX_SIZE_PER_PAGE)
            return MAX_SIZE_PER_PAGE;

        return size;
    }


    public static final DateFormat DATA_TABLE_DATE_FMT = new SimpleDateFormat("dd MMM yyyy");

    public Date fromDataTableToDate(String datePickerString) {
        Date result = null;
        try {
            result = DATA_TABLE_DATE_FMT.parse(datePickerString);
        } catch (ParseException e) {
            log.error("", e);
        }
        return result;
    }


}

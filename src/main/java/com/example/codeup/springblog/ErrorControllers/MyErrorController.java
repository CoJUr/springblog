package com.example.codeup.springblog.ErrorControllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

//    @RequestMapping("/error")
//    public String handleError() {
//        //do something like logging
//        return "error";
//    }
    //server now handles calls to the /error path     mapping specified as property: server.error.path=/error
    //triggering a 404 now returns the 404.html page

    //now lets make it so handleError() displays specific error pages for different error codes - namely 500 and 404


@RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
    //now lets make it so handleError() displays specific error pages for different error codes - namely 500 and 404
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if (status != null) {
        Integer statusCode = Integer.valueOf(status.toString());

        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            return "error-404";
            //now for a 404 error we get the error-404.html page
        }

        else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return "error-500";
        }
    }
    return "error";
    }
}

//https://www.baeldung.com/spring-boot-custom-error-page


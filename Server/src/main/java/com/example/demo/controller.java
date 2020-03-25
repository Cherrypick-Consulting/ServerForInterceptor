package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

@RestController
public class controller {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getResponse")
    public String getResponse(@RequestHeader HttpHeaders headers){
        if (headers.containsKey("px_interceptor_test_did_captcha_solved") &&
                headers.get("px_interceptor_test_did_captcha_solved").get(0).equals("true")){
            return "ok";
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
}

package com.example.PreServe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {



    /**
     * 파트너 가입 기능.
     */
    @PostMapping("/partner")
    public void signUpPartner() {}


    /**
     * 매장이용자 가입기능.
     */
    @PostMapping("/customer")
    public void signUpCustomer() {}

    /**
     * 점장은 어플리케이션 시작 시점에 그냥 삽입되는 유저로 들어가게한다.
     */

}

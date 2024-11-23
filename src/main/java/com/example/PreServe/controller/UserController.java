package com.example.PreServe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * =================== 점장 ========================
     */


    /**
     * 점장(매장의 관리자)이 매장 정보를 등록
     */
    @PostMapping("/manager")
    public void registerStoreInfo() {}



    /**
     * ================== 파트너 ========================
     */

    /**
     *점주 예약 정보 확인
     */
    @GetMapping("/partner")
    public void checkReservation() {}




    /**
     * ================= 매장 이용자 ======================
     */

    /**
     * 매장 이용자가 매장검색 및 상세정보를 확인하는 기능
     */
    @GetMapping("/customer/search")
    public void searchStore() {}


    /**
     * 매장 이용자가 예약한 이후, 예약 10분전에 도착하여 키오스크를 통해서 방문 확인을 진행하는 기능
     */
    @PostMapping("/customer/confirm")
    public void reserveConfirm() {}


    /**
     * 예약 완료 후 사용 이후에 리뷰를 작성하는 기능
     */
    @PostMapping("/customer/review")
    public void postReview() {}

}

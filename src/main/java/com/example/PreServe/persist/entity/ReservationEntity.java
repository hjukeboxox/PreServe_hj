package com.example.PreServe.persist.entity;

import com.example.PreServe.model.Customer;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "RESERVATION")
public class ReservationEntity {


    private StoreInfoEntity storeInfo; //매장현재 모든 가능테이블 및 매장기타 정보 포링키 받아오기
    private Customer customer; //유저 정보 포링키 받아오기(회원가입이 필요임 안돼있으면 예약안됌)

    private LocalDateTime reserveDateTime;
    private int table; //예약 테이블수
    private boolean userConfirm; //매장 10분전 도착여부

    /**
     *아래 필요시 빌더로 생성
     */

    //public ReservationEntity() {}


}

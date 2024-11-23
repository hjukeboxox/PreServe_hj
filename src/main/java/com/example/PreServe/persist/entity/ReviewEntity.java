package com.example.PreServe.persist.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
@Entity(name = "REVIEW")
public class ReviewEntity {


    private int reviewNum; //평점
    private String reviewContent; //한줄리뷰내용
    private ReservationEntity reservation; //Reservation 내용 받아오기

    @JsonSerialize(using = LocalDateTimeSerializer.class) //직렬화 지정
    @JsonDeserialize(using = LocalDateTimeDeserializer.class) //역직렬화 지정
    private LocalDateTime reviewDate;


    /**
     *아래 필요시 빌더로 생성
     */

    //public ReviewEntity() {}


}

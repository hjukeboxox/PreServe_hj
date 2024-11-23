package com.example.PreServe.persist.entity;

import com.example.PreServe.model.Partner;
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
@Entity(name = "STOREINFO")
public class StoreInfoEntity {

    /**
     * 현재 매장 예약가능상황.
     */

    private Partner partner;  //partner 정보 받기

    @JsonSerialize(using = LocalDateTimeSerializer.class) //직렬화 지정
    @JsonDeserialize(using = LocalDateTimeDeserializer.class) //역직렬화 지정
    private LocalDateTime dateTime;
    private int availableTables;  // ->사용자가 테이블 1 예약하면 availableTables -1 줄어는 로직.


    /**
     *아래 필요시 빌더로 생성
     */

    //public StoreInfoEntity() {}

}

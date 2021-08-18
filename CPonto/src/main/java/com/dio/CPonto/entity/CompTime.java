package com.dio.CPonto.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
//@Entity Annotation allows to create the table atomaticaly on the db. Comes along with the @id on the PK

//here we have a composed primary key (movement id and user id), so We used this class inside a class to solve the problem
public class CompTime {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class CompTimeId implements Serializable {
        private long compTimeid;
        private long movimentId;
        private long userId;
    }

    @Id
    @EmbeddedId
    private CompTimeId id;
    private LocalDateTime workDate;
    private BigDecimal hoursQuantity;
    private BigDecimal hoursBalance;
}

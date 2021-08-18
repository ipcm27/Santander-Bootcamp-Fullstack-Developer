package com.dio.CPonto.entity;

import lombok.*;

import javax.persistence.*;
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
public class Movement {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovementId implements Serializable{
        private long movimentId;
        private long userId;
    }

    @EmbeddedId
    @Id
    private MovementId movementId;
    private LocalDateTime beginDate;
    private LocalDateTime EndDate;
    private BigDecimal period;
    @ManyToOne
    private Event event;
    @ManyToOne
    private Calendar calendar;






}

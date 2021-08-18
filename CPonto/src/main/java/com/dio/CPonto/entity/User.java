package com.dio.CPonto.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class User {

    @Id
    private long id;
    private String name;
    @ManyToOne
    private UserType userType;
    @ManyToOne
    private Company company;
    @ManyToOne
    private AccessLevel accessLevel;
    @ManyToOne
    private WorkLoad workLoad;
    private BigDecimal delayTolerance;
    private LocalDateTime beginOfWork;
    private LocalDateTime endOfWork;
}

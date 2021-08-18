package com.dio.CPonto.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
//@Entity Annotation allows to create the table atomaticaly on the db. Comes along with the @id on the PK
public class Calendar {

    @Id
    private long id;
    @ManyToOne
    private DataKind dataKind;
    private String description;
    private LocalDateTime holiday;

}

package com.dio.CPonto.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
//@Entity Annotation allows to create the table atomaticaly on the db. Comes along with the @id on the PK
public class WorkLoad {
    @Id
    private long id;
    private String description;
}

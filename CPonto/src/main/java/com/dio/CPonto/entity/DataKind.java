package com.dio.CPonto.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
//@Entity Annotation allows to create the table atomaticaly on the db. Comes along with the @id on the PK

public class DataKind {

    @Id
    private long id;
    private String description;
}

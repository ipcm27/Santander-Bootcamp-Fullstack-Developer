package com.dio.CPonto.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
//@Entity Annotation allows to create the table automatically on the db. Comes along with the @id on the PK
public class WorkLoad {
    @Id
    private Long id;
    private String description;
}

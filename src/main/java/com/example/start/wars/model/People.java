package com.example.start.wars.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by jpcs1 on 30/06/17.
 */
@Entity
@Data
// para las notaciones createDate lastmodifiedDate
//@EntityListeners({AuditingEntityListener.class})
public class People {
    @Id
    @GeneratedValue
    private Long id;

    //@CreatedDate
    //private LocalDateTime created;
    //@LastModifiedDate
    //private LocalDateTime edited;

    private String name;
    private String birthYear;
    private String gender;
    private String height;
    private String mass;
    private String eyeColor;
    private String hairColor;
    private String skinColor;

}

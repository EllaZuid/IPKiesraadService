package com.KiesraadService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column
    private long id;

    @Column
    private String abbreviation;

    @Column
    private String name;

    @Column
    private Date date;

    @ManyToMany
    private List<Party> parties;

    public long getId() {
        return id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
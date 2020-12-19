package com.ankat.model.db1;

import com.ankat.model.base.BaseEntity;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "USER")
@Table(name = "USER", schema = "db1")
public class User extends BaseEntity {

    @Id
    @Column(name = "USR_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrId;

    @Column(name = "USR_NAME")
    private String usrName;

    @Column(name = "USR_AGE")
    private Integer usrAge;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

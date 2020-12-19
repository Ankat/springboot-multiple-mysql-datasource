package com.ankat.model.db2;

import com.ankat.model.base.BaseEntity;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "EMPLOYEE")
@Table(name = "EMPLOYEE", schema = "db2")
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID", updatable = false, nullable = false)
    private Long empId;

    @Column(name = "EMP_NAME")
    private Long empName;

    @Column(name = "EMP_SAL")
    private Long empSal;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

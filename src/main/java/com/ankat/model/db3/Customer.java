package com.ankat.model.db3;

import com.ankat.model.base.BaseEntity;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CUSTOMER")
@Table(name = "CUSTOMER", schema = "db3")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUST_ID", updatable = false, nullable = false)
    private Long custId;

    @Column(name = "CUST_NAME")
    private Long custName;

    @Column(name = "CUST_MOBILE_NO", length = 10)
    private String custMobileNo;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

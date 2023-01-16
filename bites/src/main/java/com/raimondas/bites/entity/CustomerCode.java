package com.raimondas.bites.entity;

import com.raimondas.bites.entity.constraint.NumberConstraint;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@NumberConstraint.List({@NumberConstraint(personalCode = "personalCode", companyCode = "companyCode",
        companyName = "companyName")})
public class CustomerCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String personalCode;

    @Column
    private String companyCode;

    @Column
    private String companyName;

    @OneToOne(mappedBy = "customerCode")
    private Customer customer;

    public CustomerCode() {
    }

    public CustomerCode(Long id, String personalCode, String companyCode, String companyName) {
        this.id = id;
        this.personalCode = personalCode;
        this.companyCode = companyCode;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerCode)) return false;
        CustomerCode that = (CustomerCode) o;
        return getId().equals(that.getId()) && getCompanyName().equals(that.getCompanyName()) && getCompanyCode().equals(that.getCompanyCode()) && getPersonalCode().equals(that.getPersonalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCompanyName(), getCompanyCode(), getPersonalCode());
    }

    @Override
    public String toString() {
        return "CustomerCode{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", personalCode='" + personalCode + '\'' +
                '}';
    }
}

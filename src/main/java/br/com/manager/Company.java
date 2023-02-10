package br.com.manager;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class Company {

    private Integer id;
    private String name;
    private Date openDate = new Date();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
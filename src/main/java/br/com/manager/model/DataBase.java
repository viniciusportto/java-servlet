package br.com.manager.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataBase {

    private static List<Company> companiesList = new ArrayList<>();
    private static Integer sequentialKey = 1;

    static {
        Company company = new Company();
        company.setId(sequentialKey++);
        company.setName("Google");

        Company company2 = new Company();
        company2.setId(sequentialKey++);
        company2.setName("Amazon");

        companiesList.add(company);
        companiesList.add(company2);
    }

    public void addCompany(Company company) {
        company.setId(DataBase.sequentialKey++);
        companiesList.add(company);
    }

    public List<Company> getCompanies() {
        return DataBase.companiesList;
    }

    public void deleteCompany(Integer id) {
        Iterator<Company> it = companiesList.iterator();

        while (it.hasNext()) {
            Company comp = it.next();
            if (comp.getId() == id) {
                it.remove();
            }
        }
    }

    public Company searchCompanyToId(Integer id) {
        for (Company company : companiesList) {
            if (company.getId() == id) {
                return company;
            }
        }
        return null;
    }
}
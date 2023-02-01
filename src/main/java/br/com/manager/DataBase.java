package br.com.manager;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static List<Company> companiesList = new ArrayList<>();

    static {
        Company company = new Company();
        company.setName("Google");
        Company company2 = new Company();
        company2.setName("Amazon");
        companiesList.add(company);
        companiesList.add(company2);
    }

    public void addCompany(Company company) {
        companiesList.add(company);
    }

    public List<Company> getCompanies(){
        return DataBase.companiesList;
    }

}

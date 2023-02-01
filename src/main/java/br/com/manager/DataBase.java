package br.com.manager;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static List<Company> companiesList = new ArrayList<>();

    public void addCompany(Company company) {
        companiesList.add(company);
    }

    public List<Company> getCompanies(){
        return DataBase.companiesList;
    }

}

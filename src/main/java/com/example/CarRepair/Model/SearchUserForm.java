package com.example.CarRepair.Model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SearchUserForm {


    private String searchInput;

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }
}

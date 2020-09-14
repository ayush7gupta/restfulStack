package com.datastructures.models;

import org.hibernate.validator.constraints.NotBlank;

public class InputCriteria {

    @NotBlank(message = "input can't empty!")
    String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
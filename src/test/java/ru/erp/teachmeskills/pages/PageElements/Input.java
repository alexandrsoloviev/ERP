package ru.erp.teachmeskills.pages.PageElements;

import static com.codeborne.selenide.Selenide.$;

public class Input {

    public void setValueInInput(String placeholder,String value){
        $("[placeholder="+placeholder+"]").setValue(value);
    }

    public void clearInput(String placeholder){
        $("[placeholder="+placeholder+"]").clear();
    }
}

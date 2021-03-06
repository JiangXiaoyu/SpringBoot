package com.bbbbb.pay.form;

import com.bbbbb.common.framework.data.annotation.Condition;
import com.bbbbb.common.framework.data.annotation.MatchMode;
import com.bbbbb.common.framework.form.PaginationForm;

import lombok.Data;

	
@Data
public class BankSerchPageForm extends PaginationForm {
    @Condition(match = MatchMode.GE)
    private String name;

    @Override
    public String[] getSearchFields() {
        return new String[] {"name"};
    }

}

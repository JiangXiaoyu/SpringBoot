package com.bwoil.pay.form;

import com.bwoil.common.framework.data.annotation.Condition;
import com.bwoil.common.framework.data.annotation.MatchMode;
import com.bwoil.common.framework.data.annotation.Operation;
import com.bwoil.common.framework.form.BaseQueryForm;

import lombok.Data;

@Data
public class BankSearchForm extends BaseQueryForm {

    @Condition(match = MatchMode.GE, operation = Operation.OR, groupName="1")
    private String name;

    @Override
    public String[] getSearchFields() {
        return new String[] {"name"};
    }
}

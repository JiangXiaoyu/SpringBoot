package com.bbbbb.pay.form;

import com.bbbbb.common.framework.data.annotation.Condition;
import com.bbbbb.common.framework.data.annotation.MatchMode;
import com.bbbbb.common.framework.data.annotation.Operation;
import com.bbbbb.common.framework.form.BaseQueryForm;

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

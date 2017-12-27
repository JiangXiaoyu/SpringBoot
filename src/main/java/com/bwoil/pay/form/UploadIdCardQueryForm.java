package com.bwoil.pay.form;

import com.bwoil.common.framework.data.annotation.Condition;
import com.bwoil.common.framework.data.annotation.MatchMode;
import com.bwoil.common.framework.form.BaseQueryForm;

import lombok.Data;

public class UploadIdCardQueryForm extends BaseQueryForm {

    @Condition(match = MatchMode.GE)
    private String name;

    @Override
    public String[] getSearchFields() {
        return new String[] {"name"};
    }
}

package com.bbbbb.pay.form;

import com.bbbbb.common.framework.data.annotation.Condition;
import com.bbbbb.common.framework.data.annotation.MatchMode;
import com.bbbbb.common.framework.form.BaseQueryForm;

import lombok.Data;

public class UploadIdCardQueryForm extends BaseQueryForm {

    @Condition(match = MatchMode.GE)
    private String name;

    @Override
    public String[] getSearchFields() {
        return new String[] {"name"};
    }
}

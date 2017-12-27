package com.bwoil.pay.form;

import javax.validation.constraints.NotNull;

import com.bwoil.common.framework.data.annotation.Condition;
import com.bwoil.common.framework.data.annotation.MatchMode;
import com.bwoil.common.framework.form.BaseQueryForm;

public class PayAccountQueryForm extends BaseQueryForm {

	@Condition(match = MatchMode.EQ)
	@NotNull
    private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

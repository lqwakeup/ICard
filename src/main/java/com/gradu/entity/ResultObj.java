package com.gradu.entity;

import java.io.Serializable;

public class ResultObj{
    private String recode;
    private Object desc;

    public String getRecode() {
        return recode;
    }

    public void setRecode(String recode) {
        this.recode = recode;
    }

    public Object getDesc() {
        return desc;
    }

    public void setDesc(Object desc) {
        this.desc = desc;
    }
}

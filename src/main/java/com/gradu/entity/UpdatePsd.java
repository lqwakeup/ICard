package com.gradu.entity;

public class UpdatePsd {
    private String oldPsd;
    private String psd;
    private Integer recode;
    private String desc;

    public Integer getRecode() {
        return recode;
    }

    public void setRecode(Integer recode) {
        this.recode = recode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOldPsd() {
        return oldPsd;
    }

    public void setOldPsd(String oldPsd) {
        this.oldPsd = oldPsd;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
}

package com.binge.sx2.commons;

import java.util.List;
import java.util.Map;

public class AjaxResult {
    private Boolean success;
    private String message;
    private Page page;

    private Map<String, List<Object>> map;
    private Object data;

    public Map<String, List<Object>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Object>> map) {
        this.map = map;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

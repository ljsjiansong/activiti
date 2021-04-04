package com.ljs.activity.UEL;

import java.io.Serializable;
import java.util.Date;

public class Holiday implements Serializable{
    // id
    private Integer id;
    // 请假人
    private String holidayName;
    // 开始时间
    private Date startDay;
    // 结束时间
    private Date endDay;
    // 请假天数
    private Float num;
    // 请假事由
    private String reason;
    // 请假类型
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Float getNum() {
        return num;
    }

    public void setNum(Float num) {
        this.num = num;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

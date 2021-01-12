package com.example.libweb.api.model;

import com.example.libweb.api.model.enums.ValidFlagEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *通用实体类
 * @author kangwei
 */
@Data
public class BaseDTO {

    /**
     * 临时字段1
     */
    private  String tmp1;
    /**
     * 临时字段2
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private  String tmp2;
    /**
     * 入库时间
     */
    private  Date createDate;
    /**
     * 最近更新时间
     */
    private Date updateDate;

    /**
     * 数据的合法性
     */

    private ValidFlagEnum validFlag;


}

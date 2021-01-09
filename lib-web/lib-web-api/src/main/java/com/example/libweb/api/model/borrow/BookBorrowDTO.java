package com.example.libweb.api.model.borrow;

import com.example.libweb.api.model.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书实体类
 * @author kangwei
 */
@Data
public class BookBorrowDTO extends BaseDTO {

    /**
     * 借书id
     */
    private Integer borrowId;
    /**
     * 用户id
     */
    private  Integer userId;
    /**
     * 用户名
     */
    private  String userName ;
    /**
     * 书籍id
     */
    private Integer bookId;
    /**
     * 书籍名
     */
    private String bookName;
    /**
     * 借书数量
     */
    private Integer borrowCount;
    /**
     * 借书价格
     */
    private  BigDecimal bookPrice;
    /**
     * 借书开始时间
     */
    private Date startDate;
    /**
     * 借书结束时间
     */
    private Date endDate;
    /**
     * 实际交易金额
     */
    private BigDecimal tradeFee;
}

package com.example.libweb.api.model.book;

import com.example.demo.api.model.BaseDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 书籍实体类
 */
@Data
public class BookDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -1410926149661455361L;
    /**
     * 书籍id
     */
    private int bookId;
    /**
     * 书籍名称
     */
    private  String bookName;
    /**
     * 书籍价格
     */
    private BigDecimal bookPrice;
    /**
     * 书籍作者
     */
    private  String bookAuthor;
    /**
     * 书籍出版社
     */
    public String bookPublish;
    /**
     * 书籍图片
     */
    public String bookImg;

    /**
     * 出版时间
     */
    private Date publishDate;

    private BookClassDTO bookClassDTO;
}

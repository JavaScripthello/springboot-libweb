package com.example.libweb.api.model.book;

import com.example.libweb.api.model.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 书籍实体类
 * @author kangwei
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BookDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -1410926149661455361L;
    /**
     * 书籍id
     */
    private Integer bookId;
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
    private String bookPublish;
    /**
     * 书籍图片
     */
    private String bookImg;

    /**
     * 书籍数量
     */

    private  Integer bookCount;
    /**
     * 出版时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;

    /**
     * 书籍分类id
     */
    private Integer bookClassId;

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublish='" + bookPublish + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", bookCount=" + bookCount +
                ", publishDate=" + publishDate +
                ", bookClassId=" + bookClassId +
                '}';
    }
}

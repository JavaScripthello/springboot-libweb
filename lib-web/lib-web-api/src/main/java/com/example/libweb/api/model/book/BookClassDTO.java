package com.example.libweb.api.model.book;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class BookClassDTO extends  BookDTO implements Serializable {

    private static final long serialVersionUID = -8292121912942946254L;
    /**
     * 书籍分类id
     */
    public int bookClassId;
    /**
     * 分类名称
     */
    private String bookClassName;


    @Override
    public String toString() {
        return "BookClassDTO{" +
                "bookClassId=" + bookClassId +
                ", bookClassName='" + bookClassName + '\'' +
                '}';
    }


}

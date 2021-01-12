package com.example.libweb.dao.mapper.reback;

import com.example.libweb.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 还书接口类
 * @author kangwei
 */
@Mapper
public interface ReturnBookMapper {

    /**
     * 还书操作
     * @param bookBorrowDTO
     * @return
     */
    int returnBorrowBookInfo(BookBorrowDTO bookBorrowDTO);
}

package com.example.libweb.api.model.service.reback;

import com.example.libweb.api.model.borrow.BookBorrowDTO;
import com.example.libweb.api.model.constants.ResultDTO;

/**
 * 还书业务处理接口
 * @author kangwei
 */
public interface ReturnBorrowBookService {
    /**
     * 还书操作
     * @param bookBorrowDTO
     * @return
     */
    ResultDTO returnBorrowBookInfo(BookBorrowDTO bookBorrowDTO);
}

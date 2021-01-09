package com.example.libweb.api.model.service.borrow;


import com.example.libweb.api.model.constants.ResultDTO;

import java.util.Date;

/**
 * 借书还书接口
 * @author kangwei
 */
public interface BookBorrowService {


    /**
     *新增借书操作
     * @param bookId
     * @param bookName
     * @param startDate
     * @param endDate
     * @param borrowCount
     * @param userId
     * @param userName
     * @param vipFlag
     * @return
     */
    ResultDTO insertBorrow(Integer bookId, String bookName, Date startDate, Date endDate, Integer borrowCount, Integer userId,String userName, boolean vipFlag);
}

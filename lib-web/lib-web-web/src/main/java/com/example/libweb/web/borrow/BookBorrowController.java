package com.example.libweb.web.borrow;

import com.alibaba.fastjson.JSONObject;
import com.example.libweb.api.model.constants.ResultDTO;
import com.example.libweb.api.model.service.borrow.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author kangwei
 */
@RestController
@RequestMapping("/borrow")
public class BookBorrowController {

    @Autowired(required = false)
    private BookBorrowService bookBorrowService;


    @RequestMapping("/doBorrow")
    public ResultDTO doBorrow(@RequestBody JSONObject jsonObject){
        Integer bookId =  jsonObject.getInteger("bookId");
        String bookName = jsonObject.getString("bookName");
        Date startDate = jsonObject.getDate("startDate");
        Date endDate = jsonObject.getDate("endDate");
        Integer borrowCount = jsonObject.getInteger("borrowCount");
        boolean vipFlag = jsonObject.getBoolean("vipFlag");
        //获取用户信息 1是session 2 是前端页面传值
        Integer userId = jsonObject.getInteger("userId");
        String  userName = jsonObject.getString("userName");
        return bookBorrowService.insertBorrow(bookId,bookName,startDate,endDate,borrowCount,userId,userName,vipFlag);
    }

}

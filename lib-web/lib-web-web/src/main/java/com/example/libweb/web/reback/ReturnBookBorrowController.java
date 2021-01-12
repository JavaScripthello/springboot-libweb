package com.example.libweb.web.reback;

import com.example.libweb.api.model.borrow.BookBorrowDTO;
import com.example.libweb.api.model.constants.ResultDTO;
import com.example.libweb.api.model.enums.HTTPCode;
import com.example.libweb.api.model.service.reback.ReturnBorrowBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 还书控制层
 * @author kangwei
 */
@RestController
@RequestMapping("/doReturn")
public class ReturnBookBorrowController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReturnBorrowBookService returnBorrowBookService;


    /**
     * 还书方法
     * @param bookBorrowDTO
     * @return
     */
    @RequestMapping("/doReturn")
    public ResultDTO doReturn(@RequestBody BookBorrowDTO bookBorrowDTO){
        try {

            return returnBorrowBookService.returnBorrowBookInfo(bookBorrowDTO);
        }catch (Exception e){
            logger.error("系统错误"+e);
            return new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统异常");
        }

    }
}

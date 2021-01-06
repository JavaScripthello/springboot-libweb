package com.example.libweb.web.borrow;

import com.example.libweb.api.model.constants.ResultDTO;
import com.example.libweb.api.model.service.borrow.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kangwei
 */
@Controller
@RequestMapping("/borrow")
public class BookBorrowController {

    @Autowired(required = false)
    private BookBorrowService bookBorrowService;

    @RequestMapping("/doBorrow")
    public ResultDTO doBorrow(){
     return null;
    }

}

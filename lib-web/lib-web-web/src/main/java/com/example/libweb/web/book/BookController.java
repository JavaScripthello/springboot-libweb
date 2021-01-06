package com.example.libweb.web.book;

import com.example.libweb.api.model.book.BookDTO;
import com.example.libweb.api.model.constants.ResultDTO;
import com.example.libweb.api.model.enums.HTTPCode;
import com.example.libweb.api.model.service.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书籍控制层
 * @author kangwei
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 根据书籍名称模糊查询书籍信息
     * @param bookDTO
     * @return 返回查询的书籍集合
     */
    @RequestMapping("/findListBookByName")
    public ResultDTO findListBookByName(@RequestBody BookDTO bookDTO){
        try {
            return bookService.findListBookByName(bookDTO.getBookName());
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }

    /**
     * 根据书籍编号查询书籍
     * @param bookDTO
     * @return 返回查询到的书籍实体
     */
    @RequestMapping("/findBookById")
    public ResultDTO findBookById(@RequestBody BookDTO bookDTO){
        try {
            return bookService.findBookById(bookDTO.getBookId());
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }

    /**
     * 添加书籍
     * @param bookDTO
     * @return
     */
    @RequestMapping("/insertBook")
    public ResultDTO insertBook(@RequestBody BookDTO bookDTO){
        try {
            return bookService.insertBook(bookDTO);
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }

    /**
     * 更新书籍信息
     * @param bookDTO
     * @return
     */
    @RequestMapping("/updateBook")
    public  ResultDTO updateBook(@RequestBody BookDTO bookDTO){
        try {
            return bookService.updateBook(bookDTO);
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }

    /**
     * 删出书籍信息
     * @param bookDTO
     * @return
     */
    @RequestMapping("/deleteBook")
    public ResultDTO deleteBook(@RequestBody BookDTO bookDTO){
        try {
            return bookService.deleteBook(bookDTO.getBookId());
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }

}

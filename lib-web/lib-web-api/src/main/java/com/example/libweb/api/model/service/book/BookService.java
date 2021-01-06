package com.example.libweb.api.model.service.book;

import com.example.libweb.api.model.book.BookDTO;
import com.example.libweb.api.model.constants.ResultDTO;

import java.util.List;

/**
 * 书籍处理接口
 * @author kangwei
 */
public interface BookService {

    /**
     * 根据书籍名称模糊查询书籍信息
     * @param bookName
     * @return 返回书籍信息的集合
     */
    ResultDTO findListBookByName(String bookName);

    /**
     * 根据书籍编号查询书籍信息
     * @param bookId
     * @return 返回查询书籍实体类
     */
    ResultDTO findBookById(Integer bookId);

    /**
     * 添加书籍
     * @param bookDTO
     * @return 返回添加书籍受影响行数
     */
    ResultDTO insertBook(BookDTO bookDTO);

    /**
     * 根据书籍实体类中书籍id更新书籍信息
     * @param bookDTO
     * @return 返回更新书籍受影响行数
     */
    ResultDTO updateBook(BookDTO bookDTO);

    /**
     * 根据书籍编号删除书
     * @param bookId
     * @return 返回删除书籍受影响行数
     */
    ResultDTO deleteBook(Integer bookId);
}

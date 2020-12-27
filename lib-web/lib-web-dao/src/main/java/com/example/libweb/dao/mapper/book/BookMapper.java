package com.example.libweb.dao.mapper.book;

import com.example.libweb.api.model.book.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 根据书籍名称模糊查询书籍信息
     * @param bookName
     * @return 返回书籍信息的集合
     */
    List<BookDTO> findListBookByName(String bookName);

    /**
     * 根据书籍编号查询书籍信息
     * @param bookId
     * @return 返回查询书籍实体类
     */
    BookDTO findBookById(Integer bookId);

    /**
     * 添加书籍
     * @param bookDTO
     * @return 返回添加书籍受影响行数
     */
    int insertBook(BookDTO bookDTO);

    /**
     * 根据书籍实体类中书籍id更新书籍信息
     * @param bookDTO
     * @return 返回更新书籍受影响行数
     */
    int updateBook(BookDTO bookDTO);

    /**
     * 根据书籍编号删除书
     * @param bookId
     * @return 返回删除书籍受影响行数
     */
    int deleteBook(Integer bookId);
}

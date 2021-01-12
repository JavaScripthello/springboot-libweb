package com.example.libweb.dao.mapper.borrow;

import com.example.libweb.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 借书还书接口
 * @author kangwei
 */
@Mapper
public interface BookBorrowsMapper {
    /**
     *添加借书记录
     * @param bookBorrowDTO
     * @return
     */
     Integer insertBorrow(BookBorrowDTO bookBorrowDTO) ;

    /**
     * 查找借书书籍信息
     * @param bookId
     * @return
     */
     BookBorrowDTO findBorrowBookInfo(Integer bookId);

    int updateBookBorrow(BookBorrowDTO localBorrowBook);
}

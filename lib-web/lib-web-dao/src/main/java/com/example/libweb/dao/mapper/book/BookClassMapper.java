package com.example.libweb.dao.mapper.book;

import com.example.libweb.api.model.book.BookClassDTO;
import com.example.libweb.api.model.constants.ResultDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookClassMapper {

    /**
     * 根据书籍分类名称模糊查询书籍
     * @param BookClassName 书籍分类名称
     * @return数据集
     */
    List<BookClassDTO> findListByName(String BookClassName);

    /**
     * 添加书籍
     * @param bookClassDTO 书籍实体类
     * @return 返回受影响行数
     */
    int  insert(BookClassDTO bookClassDTO);

    /**
     * 更新书籍
     * @param bookClassDTO 书籍实体类
     * @return返回受影响行数
     */
    int update(BookClassDTO bookClassDTO);

    /**
     * 删除书籍
     * @param bookClassId 书籍编号
     * @return 返回删除行数
     */
    int delete(Integer bookClassId);

    /**
     * 根据书籍id查询书
     * @param bookClassId 书籍编号
     * @return 返回查找到书籍或者是null
     */
    BookClassDTO findByBookId(Integer bookClassId);
}

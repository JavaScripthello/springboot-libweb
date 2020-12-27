package com.example.libweb.api.model.service.book;

import com.example.libweb.api.model.book.BookClassDTO;
import com.example.libweb.api.model.constants.ResultDTO;

public interface BookClassService {

    /**
     * 根据书籍分类名称模糊查询书籍
     * @param BookClassName 书籍分类名称
     * @return 数据集
     */
    ResultDTO findListByName(String BookClassName);

    /**
     * 添加书籍
     * @param bookClassDTO 书籍实体类
     * @return 返回受影响行数
     */
    ResultDTO insert(BookClassDTO bookClassDTO);

    /**
     * 更新书籍
     * @param bookClassDTO 书籍实体类
     * @return 返回受影响行数
     */
    ResultDTO update(BookClassDTO bookClassDTO);

    /**
     * 删除书籍
     * @param bookClassId 书籍编号
     * @return 返回删除行数
     */
    ResultDTO delete(Integer bookClassId);

    /**
     * 根据书籍id查询书
     * @param bookClassId 书籍编号
     * @return 返回查找到书籍或者是null
     */
    ResultDTO findByBookId(Integer bookClassId);
}

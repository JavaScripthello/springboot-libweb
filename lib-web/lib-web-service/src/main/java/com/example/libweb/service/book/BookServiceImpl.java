package com.example.libweb.service.book;

import com.example.libweb.api.model.book.BookDTO;
import com.example.libweb.api.model.constants.ResultDTO;
import com.example.libweb.api.model.enums.HTTPCode;
import com.example.libweb.api.model.service.book.BookService;
import com.example.libweb.dao.mapper.book.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 书籍业务处理实现类
 * @author kangwei
 */
@Service
public class BookServiceImpl implements BookService {

    //注入mapper接口
    @Autowired(required = false)
    private BookMapper bookMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *根据书籍模糊名称查询书籍
     * @param bookName
     * @return 返回书籍集合
     */
    @Override
    public ResultDTO findListBookByName(String bookName) {
        logger.info("入参"+bookName);
        if (StringUtils.isEmpty(bookName)){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"书籍名称不能为空");
        }
        List<BookDTO> list = bookMapper.findListBookByName(bookName);
        if(CollectionUtils.isEmpty(list)){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"暂无书籍");
        }
        logger.info("出参"+list);
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"查询成功",list);
    }

    /**
     * 书籍编号查询书籍信息
     * @param bookId
     * @return 返回书籍信息实体
     */
    @Override
    public ResultDTO findBookById(Integer bookId) {
        logger.info("入参"+bookId);
        if (00==bookId){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"书籍名称不能为0");
        }
        BookDTO bookDTO = bookMapper.findBookById(bookId);
        if(null==bookDTO){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"该书籍不存在");
        }
        logger.info("出参"+bookId);
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"查询成功",bookDTO);
    }

    /**
     * 添加书籍信息
     * @param bookDTO
     */
    @Override
    public ResultDTO insertBook(BookDTO bookDTO) {
        logger.info("入参"+bookDTO);
        if (StringUtils.isEmpty(bookDTO.getBookName())){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"书籍名称不能为空");
        }
        int rows = bookMapper.insertBook(bookDTO);
        if(rows<=0){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"添加书籍操作失败");
        }
        logger.info("出参"+bookDTO);
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"添加成功");
    }

    /**
     * 更新书籍信息
     * @param bookDTO
     */
    @Override
    public ResultDTO updateBook(BookDTO bookDTO) {
        logger.info("入参"+bookDTO);
        if(0==bookDTO.getBookId()){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"书籍id不能为0");
        }
        int rows = bookMapper.updateBook(bookDTO);
        if(rows<=0){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"更新书籍操作失败");
        }
        logger.info("出参"+bookDTO);
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"更新操作成功");
    }

    /**
     * 删出书籍
     * @param bookId
     */
    @Override
    public ResultDTO deleteBook(Integer bookId) {
        logger.info("入参"+bookId);
        if(0==bookId){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"书籍id不能为0");
        }
        int rows = bookMapper.deleteBook(bookId);
        if(rows<=0){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"删出书籍操作失败");
        }
        logger.info("出参"+bookId);
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"删出操作成功");
    }
}

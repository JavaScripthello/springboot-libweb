package com.example.libweb.service.book;

import com.example.libweb.api.model.book.BookClassDTO;
import com.example.libweb.api.model.constants.ResultDTO;
import com.example.libweb.api.model.enums.HTTPCode;
import com.example.libweb.api.model.service.book.BookClassService;
import com.example.libweb.dao.mapper.book.BookClassMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


import java.util.List;

@Service
public class BookClassServiceImpl implements BookClassService {

    @Autowired(required = false)
    private BookClassMapper bookClassMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 根据分类名称查询数据
     * @param bookClassName 书籍分类名称
     * @return 返回数据集
     */
    @Override
    public ResultDTO findListByName(String bookClassName) {
        logger.info("入参"+bookClassName);
         //非空判断
        if(StringUtils.isEmpty(bookClassName)){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"分类名称不能为空");
        }
         //bookClassMapper调用findListByName()方法
         //业务查询

        List<BookClassDTO > list = bookClassMapper.findListByName(bookClassName);
         //非空判断
        if(CollectionUtils.isEmpty(list)){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"没有查询到分类数据");
        }
        logger.info("出参"+list);
         //返回查询数据集
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"查询成功",list);
    }

    /**
     * 添加书籍分类
     * @param bookClassDTO 书籍实体类
     * @return 返回数据集
     */
    @Override
    public ResultDTO insert(BookClassDTO bookClassDTO) {
         //非空判断
       if(StringUtils.isEmpty(bookClassDTO.getBookClassName())){
           return  new ResultDTO(HTTPCode.FAIL.getCode(),"分类名称不能为空");
       }
       int  infullenceNumbers = bookClassMapper.insert(bookClassDTO);
         // 判断业务操作返回数据的真实性
       if(infullenceNumbers<=0){
           return  new ResultDTO(HTTPCode.FAIL.getCode(),"新增失败");
       }
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"新增成功");
    }

    /**
     * 更新书籍分类
     * @param bookClassDTO 书籍实体类
     */
    @Override
    public ResultDTO update(BookClassDTO bookClassDTO) {
         //非0判断
        if(0==bookClassDTO.getBookClassId()){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"分类id不能为0");
        }
        //执行操作
        int infullenceNumbers = bookClassMapper.update(bookClassDTO);
       //判断业务操作返回数据的真实性
        if(infullenceNumbers<=0){
            return new ResultDTO(HTTPCode.FAIL.getCode(),"更新操作失败");
        }
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"更新操作成功");
    }

    /**
     * 删除分类
     * @param bookClassId 书籍编号
     * @return
     */
    @Override
    public ResultDTO delete(Integer bookClassId) {
         //非0判断
        if(0==bookClassId){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"分类id不能为0");
        }
         //业务操作
        int  infullenceNumbers = bookClassMapper.delete(bookClassId);
         // 判断业务操作返回数据的真实性
        if(infullenceNumbers<=0){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"删除失败");
        }

        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"删除成功");
    }

    /**
     * 根据非类id查询分类
     * @param bookClassId 书籍编号
     * @return 返回查询数据
     */
    @Override
    public ResultDTO findByBookId(Integer bookClassId) {
         //非0判断
        if(0==bookClassId){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"分类id不能为0");
        }
        BookClassDTO bookClassDTO = bookClassMapper.findByBookId(bookClassId);
         //非空判断
        if(null==bookClassDTO){
            return new ResultDTO(HTTPCode.FAIL.getCode(),"没有查询到相应数据");
        }
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"查询成功",bookClassDTO);
    }
}

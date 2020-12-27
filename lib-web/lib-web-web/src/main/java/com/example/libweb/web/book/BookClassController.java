package com.example.libweb.web.book;

import com.example.libweb.api.model.book.BookClassDTO;
import com.example.libweb.api.model.constants.ResultDTO;
import com.example.libweb.api.model.enums.HTTPCode;
import com.example.libweb.api.model.enums.ValidFlagEnum;
import com.example.libweb.api.model.service.book.BookClassService;
import com.example.libweb.service.book.BookClassServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookClass")
public class BookClassController {

    @Autowired
    private BookClassService bookClassService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据分类名模糊查询分类
     * @param bookClassName
     * @return
     */
    @RequestMapping("findListByName")
    public ResultDTO findListByName(String bookClassName){
        try {
            return bookClassService.findListByName(bookClassName);
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }

    /**
     * 添加分类
     * @param bookClassDTO
     * @return
     */
    @RequestMapping("/insert")
    public ResultDTO insert(BookClassDTO bookClassDTO){
        try {
            bookClassDTO.setValidFlag(ValidFlagEnum.ENABLE);
            return bookClassService.insert(bookClassDTO);
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }

    /**
     * 更新分类
     * @param bookClassDTO
     * @return
     */
    @RequestMapping("/update")
    public ResultDTO update(BookClassDTO bookClassDTO){
        try {
            return bookClassService.update(bookClassDTO);
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }

    /**
     * 删除分类
     * @param bookClassId
     * @return
     */
    @RequestMapping("/delete")
    public ResultDTO delete(int bookClassId){
        try {
            return bookClassService.delete(bookClassId);
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }

    /**
     * 根据分类id查询分类
     * @param bookClassId
     * @return
     */
    @RequestMapping("/findByBookId")
    public ResultDTO findByBookId(int bookClassId){
        try {
            return bookClassService.findByBookId(bookClassId);
        }catch (Exception e){
            logger.error("系统错误"+e);
            return  new ResultDTO(HTTPCode.EXCEPTION.getCode(),"系统错误");
        }
    }
}

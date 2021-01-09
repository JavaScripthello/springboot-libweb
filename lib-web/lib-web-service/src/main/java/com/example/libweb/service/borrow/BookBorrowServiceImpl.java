package com.example.libweb.service.borrow;

import com.example.libweb.api.model.book.BookDTO;
import com.example.libweb.api.model.borrow.BookBorrowDTO;
import com.example.libweb.api.model.constants.ResultDTO;
import com.example.libweb.api.model.enums.HTTPCode;
import com.example.libweb.api.model.enums.ValidFlagEnum;
import com.example.libweb.api.model.service.borrow.BookBorrowService;
import com.example.libweb.dao.mapper.book.BookMapper;
import com.example.libweb.dao.mapper.borrow.BookBorrowsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书还书实现类
 * @author kangwei
 */
@Service
public class BookBorrowServiceImpl implements BookBorrowService {
    @Autowired(required = false)
    private BookBorrowsMapper bookBorrowMapper;
    @Autowired(required = false)
    private BookMapper bookMapper;

    /**
     * 新增借书记录
     * @param bookId
     * @param bookName
     * @param startDate
     * @param endDate
     * @param borrowCount
     * @param userId
     * @param userName
     * @param vipFlag
     * @return
     */
    @Override
    public ResultDTO insertBorrow(Integer bookId, String bookName, Date startDate, Date endDate, Integer borrowCount,Integer userId, String userName ,boolean vipFlag) {
        if (bookId==0){
            return  new ResultDTO(HTTPCode.FAIL.getCode(),"书籍编号不能为0");
        }
        //根据书籍id查书籍信息
        BookDTO bookDTO =bookMapper.findBookById(bookId);
        if (null == bookDTO){
            return  new  ResultDTO(HTTPCode.FAIL.getCode(),"书库没有该书籍");
        }
        //获取当前书库中书籍数量
        Integer  bookCount = bookDTO.getBookCount();
        if (bookCount<=0){
            return  new  ResultDTO(HTTPCode.FAIL.getCode(),"该书籍比较畅销,已经借完");
        }
        if (borrowCount<=0){
            return  new  ResultDTO(HTTPCode.FAIL.getCode(),"借书数量不能小于等于0");
        }
        if (bookCount<borrowCount){
            return  new  ResultDTO(HTTPCode.FAIL.getCode(),"借书数量不能大于当前书籍数量"+bookCount);
        }
        if (startDate.after(endDate)){
            return  new  ResultDTO(HTTPCode.FAIL.getCode(),"借书开始时间不能大于结束时间"+bookCount);
        }
        //执行借书操作
        int result = doInsertBorrowRecord(startDate,endDate,bookDTO,bookName,userId,userName,vipFlag,borrowCount);

        if (result<=0){
            return new ResultDTO(HTTPCode.FAIL.getCode(),"借书失败");
        }
        //借书成功，减少书籍数量，更新书籍信息
        bookDTO.setBookCount(bookCount - borrowCount);
        bookDTO.setUpdateDate(new Date());
        bookMapper.updateBook(bookDTO);
        return  new ResultDTO(HTTPCode.SUCCESS.getCode(),"借书成功");
    }

    /**
     * 执行借书操作
     * @param startDate
     * @param endDate
     * @param bookDTO
     * @param bookName
     * @param userId
     * @param userName
     * @param vipFlag
     * @param borrowCount
     * @return
     */
    private int  doInsertBorrowRecord(Date startDate, Date endDate, BookDTO bookDTO, String bookName, Integer userId, String userName, boolean vipFlag, Integer borrowCount) {
        //计算借书天数
        Long day = (endDate.getTime()-startDate.getTime()) /(24*60*60*1000);
        //借书操作
        BookBorrowDTO bookBorrowDTO = new BookBorrowDTO();
        //书籍id
        bookBorrowDTO.setBookId(bookDTO.getBookId());
        //书名
        bookBorrowDTO.setBookName(bookName);
        //用户id
        bookBorrowDTO.setUserId(userId);
        //借书人
        bookBorrowDTO.setUserName(userName);
        //借书数量
        bookBorrowDTO.setBorrowCount(borrowCount);
        //借书开始时间
        bookBorrowDTO.setStartDate(startDate);
        //借书结束时间
        bookBorrowDTO.setEndDate(endDate);
        //借书操作时间
        bookBorrowDTO.setCreateDate(new Date());
        //数据合法性
        bookBorrowDTO.setValidFlag(ValidFlagEnum.ENABLE);
        //计算价格
        BigDecimal bookPrice = bookDTO.getBookPrice();
        //借书价格
        bookBorrowDTO.setBookPrice(bookPrice);
        //总价格
        long totalPrice =  bookPrice.intValue() * day;
        if (vipFlag){
            bookBorrowDTO.setTradeFee(new BigDecimal("0.0"));
        }
        bookBorrowDTO.setTradeFee(new BigDecimal(totalPrice));
        //执行插入
        Integer  result =  bookBorrowMapper.insertBorrow(bookBorrowDTO);
       return result;
    }

}

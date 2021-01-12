package com.example.libweb.service.reback;

import com.example.libweb.api.model.book.BookDTO;
import com.example.libweb.api.model.borrow.BookBorrowDTO;
import com.example.libweb.api.model.constants.ResultDTO;
import com.example.libweb.api.model.enums.HTTPCode;
import com.example.libweb.api.model.enums.ValidFlagEnum;
import com.example.libweb.api.model.service.reback.ReturnBorrowBookService;
import com.example.libweb.dao.mapper.book.BookMapper;
import com.example.libweb.dao.mapper.borrow.BookBorrowsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author kangwei
 */
@Service
public class ReturnBorrowBookServiceImpl implements ReturnBorrowBookService {

    @Autowired(required = false)
    private BookMapper bookMapper;

    @Autowired(required = false)
    private BookBorrowsMapper bookBorrowsMapper;
    /**
     * 还书操作
     * @param bookBorrowDTO
     * @return
     */
    @Override
    public ResultDTO returnBorrowBookInfo(BookBorrowDTO bookBorrowDTO) {
        Integer bookId = bookBorrowDTO.getBookId();
        if (0>=bookId){
            return new ResultDTO(HTTPCode.FAIL.getCode(),"书籍id不能为空");
        }
        BookDTO bookDTO = bookMapper.findBookById(bookId);
        if (null==bookDTO){
            return new ResultDTO(HTTPCode.FAIL.getCode(),"没有该书籍信息");
        }
        //还书数量
        Integer reBackCount = bookBorrowDTO.getBorrowCount();
//        查询还书信息
      BookBorrowDTO  localBorrowBook = bookBorrowsMapper.findBorrowBookInfo(bookId);
      if (null==localBorrowBook){
          return new ResultDTO(HTTPCode.FAIL.getCode(),"没有借书信息，请联系管理员或图书管理员");
      }
      //借书数量
      Integer borrowCount = localBorrowBook.getBorrowCount();
      if (0==borrowCount){
          return new ResultDTO(HTTPCode.FAIL.getCode(),"书籍已经还完");
      }
      //获取已经还书的数量
//        int tmp1Count = Integer.parseInt(null==localBorrowBook.getTmp1()?"0":localBorrowBook.getTmp1());
//        if (tmp1Count==borrowCount){
//            return new ResultDTO(HTTPCode.FAIL.getCode(),"还书完成，无需还书");
//        }
//        还书数量和借书数量逻辑判断
      if (reBackCount> borrowCount){
          return new ResultDTO(HTTPCode.FAIL.getCode(),"还书数量大于借书数量，请核对信息");
      }else if (reBackCount.equals(borrowCount)){
          int newTmp1Count=0;
          //跟新书籍信息
          if (null!=localBorrowBook.getTmp1()){
               newTmp1Count = Integer.parseInt(localBorrowBook.getTmp1());
          }
          localBorrowBook.setBorrowCount(0);
          //如果之前已经还了书籍，但是还没还完情况
          localBorrowBook.setTmp1(String.valueOf(reBackCount+newTmp1Count));
          //操作时间
          //String patter = String.valueOf(new Date());
          localBorrowBook.setTmp2(String.valueOf(new Date()));
          //
          localBorrowBook.setValidFlag(ValidFlagEnum.DISABLE);
          //
          bookBorrowsMapper.updateBookBorrow(localBorrowBook);
          //更新书籍信息
          bookDTO.setBookCount(bookDTO.getBookCount()+reBackCount);
          //更新时间
          bookDTO.setUpdateDate(new Date());
          bookMapper.updateBook(bookDTO);
      }else {
          //添加还书数量，减少借书数量
          //减少借书数量
          localBorrowBook.setBorrowCount(localBorrowBook.getBorrowCount()-reBackCount);
          //如果之前已经还了书籍，但是还没还完情况
          int newTmp1Count = Integer.parseInt(localBorrowBook.getTmp1());
          //
          localBorrowBook.setTmp1(String.valueOf(reBackCount+newTmp1Count));
          //操作时间
          localBorrowBook.setTmp2(String.valueOf(new Date()));
          //
          bookBorrowsMapper.updateBookBorrow(localBorrowBook);
          //更新书籍信息
          bookDTO.setBookCount(bookDTO.getBookCount()+reBackCount);
          bookDTO.setUpdateDate(new Date());
         bookMapper.updateBook(bookDTO);
      }
        return new ResultDTO(HTTPCode.SUCCESS.getCode(),"归还成功");
    }
}

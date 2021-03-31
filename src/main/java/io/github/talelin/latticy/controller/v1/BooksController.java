package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupMeta;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.latticy.dto.books.CreateOrUpdateBooksDTO;
import io.github.talelin.latticy.model.BooksDO;
import io.github.talelin.latticy.service.BooksServices;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
@Validated
public class BooksController {
    @Autowired
    private BooksServices booksServices;

    @GetMapping("/{id}")
    public BooksDO getBook(@PathVariable(value = "id") @Positive(message = "id必须为正整数") Long id){
        BooksDO book=booksServices.getById(id);
        if(null==book){
            throw new NotFoundException("book not found",10210);
        }
        return book;
    }

    @PostMapping("")
    public CreatedVO createBook(@RequestBody @Validated CreateOrUpdateBooksDTO createOrUpdateBooksDTO){
        boolean flag=booksServices.createBook(createOrUpdateBooksDTO);
        return new CreatedVO(10212);
    }
    @GetMapping("/getall")
    public List<BooksDO> getAllBools(){
        List<BooksDO> booksDOList=booksServices.getAllBooks();
        if(booksDOList.size()<1)
            throw new NotFoundException("not found any data",10211);
        return  booksDOList;
    }

    @DeleteMapping("/{id}")
    @GroupMeta(permission = "删除书籍",module ="书籍" ,mount = true)
    @GroupRequired
    public DeletedVO deleteBook(@PathVariable("id") @Positive(message = "{id}") Long id){
        BooksDO booksDO=booksServices.getById(id);
        if(null==booksDO)
            throw new NotFoundException("book not found",10210);
        boolean rs=booksServices.deleteById(booksDO.getId());
        return new DeletedVO(10213);
    }
}

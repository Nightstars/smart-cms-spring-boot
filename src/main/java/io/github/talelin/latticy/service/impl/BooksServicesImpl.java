package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.books.CreateOrUpdateBooksDTO;
import io.github.talelin.latticy.mapper.BookMapper;
import io.github.talelin.latticy.mapper.BooksMapper;
import io.github.talelin.latticy.model.BookDO;
import io.github.talelin.latticy.model.BooksDO;
import io.github.talelin.latticy.service.BooksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServicesImpl implements BooksServices {
    @Autowired
    private BooksMapper booksMapper;

    @Override
    public BooksDO getById(Long id) {
        return booksMapper.selectById(id);
    }

    @Override
    public boolean createBook(CreateOrUpdateBooksDTO createOrUpdateBooksDTO) {
        BooksDO booksDO=new BooksDO();
        booksDO.setAuthor(createOrUpdateBooksDTO.getAuthor());
        booksDO.setTitle(createOrUpdateBooksDTO.getTitle());
        booksDO.setImage(createOrUpdateBooksDTO.getImage());
        booksDO.setSummary(createOrUpdateBooksDTO.getSummary());
        return booksMapper.insert(booksDO)>0;
    }

    @Override
    public List<BooksDO> getAllBooks() {
        return booksMapper.selectList(null);
    }
}

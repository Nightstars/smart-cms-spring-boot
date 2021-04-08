package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.books.CreateOrUpdateBooksDTO;
import io.github.talelin.latticy.model.BookDO;
import io.github.talelin.latticy.model.BooksDO;

import java.util.List;

public interface BooksServices {
    BooksDO getById(Long id);
    boolean createBook(CreateOrUpdateBooksDTO createOrUpdateBooksDTO);
    List<BooksDO> getAllBooks();
    boolean deleteById(Long id);
    boolean updateBook(BooksDO booksDO, CreateOrUpdateBooksDTO model);
}

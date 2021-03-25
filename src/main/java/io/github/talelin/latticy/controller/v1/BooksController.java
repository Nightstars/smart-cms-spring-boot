package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.model.BooksDO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/books")
@Validated
public class BooksController {

    @GetMapping("/{id}")
    public BooksDO getBook(@PathVariable(value = "id") @Positive(message = "id必须为正整数") Long id){
        return null;
    }
}

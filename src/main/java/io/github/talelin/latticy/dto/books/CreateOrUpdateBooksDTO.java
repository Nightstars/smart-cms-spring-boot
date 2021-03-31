package io.github.talelin.latticy.dto.books;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CreateOrUpdateBooksDTO {
    @NotEmpty(message = "{books.title.no-empty}")
    @Size(max = 50, message = "{books.title.max-size}")
    private String title;

    @NotEmpty(message = "{books.author.no-empty}")
    @Size(max = 50, message = "{books.author.max-size}")
    private String author;

    @NotEmpty(message = "{books.summary.no-empty}")
    @Size(max = 1000, message = "{books.summary.max-size}")
    private String summary;

    @Size(max = 100, message = "{books.image.max-length}")
    private String image;
}

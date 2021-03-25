package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.BooksDO;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksMapper extends BaseMapper<BooksDO> {
}

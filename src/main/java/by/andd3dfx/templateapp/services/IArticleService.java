package by.andd3dfx.templateapp.services;

import by.andd3dfx.templateapp.dto.ArticleDto;
import by.andd3dfx.templateapp.dto.ArticleUpdateDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IArticleService {

    ArticleDto create(ArticleDto articleDto);

    ArticleDto get(String id);

    void update(String id, ArticleUpdateDto articleUpdateDto);

    void delete(String id);

    Slice<ArticleDto> getAll(Pageable pageable);
}

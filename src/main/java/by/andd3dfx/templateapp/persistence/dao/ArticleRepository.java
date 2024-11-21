package by.andd3dfx.templateapp.persistence.dao;

import by.andd3dfx.templateapp.persistence.entities.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

/**
 * Check these <a href="https://docs.spring.io/spring-data/redis/docs/3.1.6/reference/html/#query-by-example">docs</a>
 */
@Repository
public interface ArticleRepository extends CrudRepository<Article, String>, QueryByExampleExecutor<Article> {

}

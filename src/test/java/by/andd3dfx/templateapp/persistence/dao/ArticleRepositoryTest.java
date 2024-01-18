package by.andd3dfx.templateapp.persistence.dao;

import by.andd3dfx.templateapp.IntegrationTestInitializer;
import by.andd3dfx.templateapp.persistence.entities.Article;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ContextConfiguration(initializers = IntegrationTestInitializer.class)
@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository repository;

    private Article one;
    private Article four;
    private Article three;
    private Article two;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
        one = buildArticle("Ivan", "one", LocalDateTime.parse("2010-12-03T10:15:30"));
        two = buildArticle("Semen", "two", LocalDateTime.parse("2012-12-03T10:15:30"));
        three = buildArticle("Ivan", "three", LocalDateTime.parse("2012-12-03T10:15:30"));
        four = buildArticle("Vasily", "four", LocalDateTime.parse("2011-12-03T10:15:30"));
        repository.saveAll(Arrays.asList(one, four, three, two));
    }

    @AfterEach
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void findAll_withPageNSizeNSorting() {
        var result = repository.findAll(
                Example.of(new Article()),
                PageRequest.of(0, 3, Sort.by("summary"))
        );

        assertThat("Wrong records amount", result.getNumberOfElements(), is(3));
        var articles = result.getContent();
        assertThat(articles.get(0), is(four));
        assertThat(articles.get(1), is(one));
        assertThat(articles.get(2), is(three));
    }

    private static Article buildArticle(String title, String summary, LocalDateTime timestamp) {
        Article article = new Article();
        article.setTitle(title);
        article.setSummary(summary);
        article.setText("any text");
        article.setTimestamp(timestamp);
        article.setAuthor("Some author");
        return article;
    }
}
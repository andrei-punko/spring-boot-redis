package by.andd3dfx.templateapp;

import by.andd3dfx.templateapp.persistence.dao.ArticleRepository;
import by.andd3dfx.templateapp.persistence.entities.Article;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootRedisApp implements InitializingBean {

    @Autowired
    ArticleRepository articleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApp.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        populateDb();
    }

    private void populateDb() {
        var article = Article.builder()
                .id("1")
                .author("Isaac Sirin")
                .title("Слова Подвижнические")
                .summary("Изложение аскетического опыта")
                .build();
        var article2 = Article.builder()
                .id("2")
                .author("Epiktet")
                .title("В чем наше благо")
                .summary("Творения философа-стоика 1го века")
                .build();
        var article3 = Article.builder()
                .id("3")
                .author("John Sonmez")
                .title("Путь программиста")
                .summary("Книга о разных аспектах жизни программиста")
                .build();
        var article4 = Article.builder()
                .id("4")
                .author("Ignaty Brianchaninov")
                .title("Отечник")
                .summary("Собрание изречений святых Отцов")
                .build();
        var article5 = Article.builder()
                .id("5")
                .author("Egor Gaidar")
                .title("Гибель империи")
                .summary("Рассказ о распаде СССР")
                .build();

        articleRepository.saveAll(List.of(article, article2, article3, article4, article5));
    }
}

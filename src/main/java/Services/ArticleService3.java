package Services;


import Model.Article3;
import repository.Article3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService3 {

    private final Article3Repository articleRepository;

    @Autowired
    public ArticleService3(Article3Repository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article3> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article3> findById(Integer id) {
        return articleRepository.findById(id);
    }

    public Article3 save(Article3 article3) {
        return articleRepository.save(article3);
    }

    public void deleteById(Integer id) {
        articleRepository.deleteById(id);
    }
}
package Controller;

import Model.Article3;
import Services.ArticleService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleController3 {

    private final ArticleService3 articleService3;

    @Autowired
    public ArticleController3(ArticleService3 articleService3) {
        this.articleService3 = articleService3;
    }

    @GetMapping
    public ResponseEntity<List<Article3>> getAllArticles() {
        List<Article3> article3s = articleService3.findAll();
        return new ResponseEntity<>(article3s, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article3> getArticleById(@PathVariable Integer id) {
        Optional<Article3> article = articleService3.findById(id);
        return article.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Article3> createArticle(@RequestBody Article3 article3) {
        Article3 savedArticle3 = articleService3.save(article3);
        return new ResponseEntity<>(savedArticle3, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article3> updateArticle(@PathVariable Integer id, @RequestBody Article3 article3) {
        Optional<Article3> existingArticle = articleService3.findById(id);
        if (existingArticle.isPresent()) {
            article3.setIdart(id);
            Article3 updatedArticle3 = articleService3.save(article3);
            return new ResponseEntity<>(updatedArticle3, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Integer id) {
        Optional<Article3> existingArticle = articleService3.findById(id);
        if (existingArticle.isPresent()) {
            articleService3.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
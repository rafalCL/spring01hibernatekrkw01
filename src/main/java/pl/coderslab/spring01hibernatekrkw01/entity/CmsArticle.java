package pl.coderslab.spring01hibernatekrkw01.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.spring01hibernatekrkw01.validator.Draft;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cmsarticles")
public class CmsArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = {Default.class, Draft.class}, message = "Title must not be empty")
    private String title;

    @NotBlank(groups = {Draft.class}, message = "Key words must not be empty")
    private String keyWords;

    @NotBlank(message = "Contents must not be empty")
    private String contents;

    public CmsArticle(){

    }

    public CmsArticle(String title, String keyWords, String contents) {
        this.title = title;
        this.keyWords = keyWords;
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "CmsArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}

package pl.coderslab.spring01hibernatekrkw01.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01hibernatekrkw01.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw01.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw01.entity.Author;
import pl.coderslab.spring01hibernatekrkw01.entity.Publisher;

public class StringAuthorConverter
        implements Converter<String, Author> {
    @Autowired
    private AuthorDao ad;

    @Override
    public Author convert(String s) {
        return ad.findById(Integer.parseInt(s));
    }
}

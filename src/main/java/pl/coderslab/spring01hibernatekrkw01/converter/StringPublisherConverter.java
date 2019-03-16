package pl.coderslab.spring01hibernatekrkw01.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01hibernatekrkw01.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw01.entity.Publisher;

public class StringPublisherConverter
        implements Converter<String, Publisher> {
    @Autowired
    private PublisherDao pd;

    @Override
    public Publisher convert(String s) {
        return pd.findById(Integer.parseInt(s));
    }
}

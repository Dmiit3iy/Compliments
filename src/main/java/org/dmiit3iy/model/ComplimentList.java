package org.dmiit3iy.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Data
@Component
@ConfigurationProperties(prefix = "compliments-settings")
public class ComplimentList {
    private List<Compliment> list;

    public Compliment getRandom() {
        Random random = new Random();
        int x = random.nextInt(list.size());
        return list.get(x);
    }

    public Compliment getById(int id) throws IndexOutOfBoundsException{

            return list.get(id);

    }
}

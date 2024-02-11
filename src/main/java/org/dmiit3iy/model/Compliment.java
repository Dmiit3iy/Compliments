package org.dmiit3iy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Compliment {
    private static long count = 1;
    private long id;
    private String compliment;

    public Compliment() {
        this.id = count++;
    }
}

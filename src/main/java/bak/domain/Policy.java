package bak.domain;

import lombok.Data;

@Data
public class Policy {
    Integer id;
    String name;
    String type;
    String document;
    String form;
    String organ;
    String text;
    String viadata;

    public Policy(Integer id, String name, String type, String document, String form, String organ, String text, String viadata) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.document = document;
        this.form = form;
        this.organ = organ;
        this.text = text;
        this.viadata = viadata;
    }

    public Policy() {
    }
}

package org.acme.model;

public class MultiLingualText {
    public String de;
    public String en;
    public String fr;
    public String it;

    MultiLingualText(String de, String en, String fr, String it) {
        this.de = de;
        this.en = en;
        this.fr = fr;
        this.it = it;
    }

    public String getDe() {
        return de;
    }

    public String getEn() {
        return en;
    }

    public String getFr() {
        return fr;
    }

    public String getIt() {
        return it;
    }
}

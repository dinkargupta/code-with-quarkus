package org.acme.model;

public class Nutrient {
    public int perDay;
    public int perHundred;
    public int perPortion;
    public String unit;
    public MultiLingualText namedTranslations;

    public int getPerDay() {
        return perDay;
    }

    public void setPerDay(int perDay) {
        this.perDay = perDay;
    }

    public int getPerHundred() {
        return perHundred;
    }

    public void setPerHundred(int perHundred) {
        this.perHundred = perHundred;
    }

    public int getPerPortion() {
        return perPortion;
    }

    public void setPerPortion(int perPortion) {
        this.perPortion = perPortion;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public MultiLingualText getNamedTranslations() {
        return namedTranslations;
    }

    public void setNamedTranslations(MultiLingualText namedTranslations) {
        this.namedTranslations = namedTranslations;
    }
}

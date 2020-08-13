package org.acme.model;

import java.time.LocalDate;
import java.util.List;

public class Food {
    public int id;
    public String barcode;
    public String country;
    public LocalDate createdat;
    public int portionquantity;
    public String portion_unit;
    public int quantity;
    public String status;
    public String unit;
    public LocalDate updatedat;
    public MultiLingualText displayNameTranslations;
    public MultiLingualText ingredientsTranslations;
    public MultiLingualText nameTranslations;
    public List<Nutrient> nutrients;
    public List<Object> images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDate createdat) {
        this.createdat = createdat;
    }

    public int getPortionquantity() {
        return portionquantity;
    }

    public void setPortionquantity(int portionquantity) {
        this.portionquantity = portionquantity;
    }

    public String getPortion_unit() {
        return portion_unit;
    }

    public void setPortion_unit(String portion_unit) {
        this.portion_unit = portion_unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDate getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDate updatedat) {
        this.updatedat = updatedat;
    }

    public MultiLingualText getDisplayNameTranslations() {
        return displayNameTranslations;
    }

    public void setDisplayNameTranslations(MultiLingualText displayNameTranslations) {
        this.displayNameTranslations = displayNameTranslations;
    }

    public MultiLingualText getIngredientsTranslations() {
        return ingredientsTranslations;
    }

    public void setIngredientsTranslations(MultiLingualText ingredientsTranslations) {
        this.ingredientsTranslations = ingredientsTranslations;
    }

    public MultiLingualText getNameTranslations() {
        return nameTranslations;
    }

    public void setNameTranslations(MultiLingualText nameTranslations) {
        this.nameTranslations = nameTranslations;
    }

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }
}

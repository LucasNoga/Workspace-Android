package noga.td2.android.iutsd.vegetablesoup;

/*
 * SoupIngredients.java
 * Noga Lucas
 * 27/02/16
 */

/**Un ingredient*/
public class SoupIngredient {


    /**le nom de l'ingredients*/
    private String ingredient;

    /**la quantite de l'ingredient*/
    private String quantity;


    /**Constructeurs avec une chaine de caractere et une quantite pour rajouter un ingredient*/
    public SoupIngredient(String ingredient) {
        this.ingredient = ingredient;
        this.quantity = "0";
    }
    public SoupIngredient(String ingredient, String quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }


    /**accesseur pour le nom de l'ingredient*/
    public String getIngredient() {
        return ingredient;
    }


    /**accesseur pour la quantite*/
    public String getQuantity() {
        return quantity;
    }
}


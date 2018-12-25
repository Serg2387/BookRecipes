package mainacademy.recipesapp;

// for loading and storing single records
// may be used in arrays

@SuppressWarnings("unused")
public class RecipeData {
    // getters/setters not needed, used in arrays
    public int id;
    public String recipeName;
    public String recipeCategory;
    public String recipeIngredients;
    public String recipeInstructions;

    public RecipeData(int _id, String _name, String _cat, String _ing, String _inst){
        id = _id;
        recipeName = _name;
        recipeCategory = _cat;
        recipeIngredients = _ing;
        recipeInstructions = _inst;
    }
}

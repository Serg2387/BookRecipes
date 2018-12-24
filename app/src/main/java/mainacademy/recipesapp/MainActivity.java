package mainacademy.recipesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.util.Objects;


@SuppressWarnings("unused")
public class MainActivity extends Common {

    private TextView _textView1;

    public MainActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);
        menuID = R.menu.main_menu;
        setContentView(R.layout.activity_main);


        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);

        _textView1 = findViewById(R.id.textView1);
        Objects.requireNonNull(_textView1).setText("");

        final Button bakeryC = findViewById(R.id.bakeryBTN);
        Objects.requireNonNull(bakeryC).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // load bakery recipes
                displayRecipes(getResources().getString(R.string.bakeryTitle));
            }
        });
        final Button dishesC = findViewById(R.id.dishesBTN);
        Objects.requireNonNull(dishesC).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // load dishes recipes
                displayRecipes(getResources().getString(R.string.dishesTitle));
            }
        });
        final Button saladsC = findViewById(R.id.saladsBTN);
        Objects.requireNonNull(saladsC).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // load salads recipes
                displayRecipes(getResources().getString(R.string.saladsTitle));
            }
        });
        final Button soupsC = findViewById(R.id.soupsBTN);
        Objects.requireNonNull(soupsC).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // load soups recipes
                displayRecipes(getResources().getString(R.string.soupTitle));
            }
        });
    }


    private void displayRecipes(String _cat){
        // check to make sure there are recipes in the category clicked on
        RecipeDatabase rdb = new RecipeDatabase(this);
        int cnt = rdb.GetRecipeCount(_cat);

        if(cnt >0) {

            Intent recipeView = new Intent(this, RecipePagerActivity.class);
            recipeView.putExtra("category", _cat);
            this.startActivity(recipeView);
        }else{
            Alert ad = new Alert(getResources().getString(R.string.notice),
                    getResources().getString(R.string.loadError),
                    this);
            ad.show();
        }
    }



    //------------------------------------------------------
    @Override
    protected void onDestroy(){
        super.onDestroy();
        _textView1 = null;
        System.gc();
    }
}

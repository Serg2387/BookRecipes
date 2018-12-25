package mainacademy.recipesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public abstract class Common extends AppCompatActivity {
    int menuID = R.menu.main_menu; // default

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(menuID, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homeAsUp:
                finish();
                break;
            case R.id.action_addrecipe:
                // open add screen
                addNewRecipe(null);
                break;
            case R.id.action_delete_recipe:
                //open delete admin
                deleteRecipe(null);
                break;
            case R.id.action_admin:
                addNewRecipe(this.getCurrentFocus());
                break;
            case R.id.action_admin_delete:
                deleteRecipe(this.getCurrentFocus());
                break;
            default:
                // if we got here, the user's action was not recognized.
                // invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

    public void addNewRecipe(View v) {
        Intent admin = new Intent(this, RecipeAdmin.class);
        this.startActivity(admin);
    }

    public void deleteRecipe(View v) {
        Intent adminD = new Intent(this, DeleteRecipeActivity.class);
        this.startActivity(adminD);
    }
}

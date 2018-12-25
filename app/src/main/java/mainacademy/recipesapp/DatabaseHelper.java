package mainacademy.recipesapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Recipes";
    private static final int DATABASE_VERSION = 2;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "CREATE TABLE recipes " +
            "( _id INTEGER PRIMARY KEY,recipeName text,recipeCategory TEXT," +
            "recipeIngredients TEXT, recipeInstructions TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        database.execSQL("DROP TABLE IF EXISTS recipes");
        onCreate(database);
    }


}

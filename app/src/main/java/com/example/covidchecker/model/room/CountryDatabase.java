package com.example.covidchecker.model.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {RoomCountry.class, RoomFavorite.class, RoomGlobal.class}, version = 9, exportSchema = false)
public abstract class CountryDatabase extends RoomDatabase {

    private static CountryDatabase sInstance;
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    @VisibleForTesting
    public static final String DATABASE_NAME = "DATABASEKU";

    public abstract RoomCountryDao roomCountryDao();
    public abstract RoomFavoriteDao roomFavoriteDao();
    public abstract RoomGlobalDao roomGlobalDao();

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private void updateDatabaseCreated(final Context context){
        if (context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }

    public static CountryDatabase buildDatabase(final Context context){
        return Room.databaseBuilder(context, CountryDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        CountryDatabase database = CountryDatabase.getInstance(context);
                        database.setDatabaseCreated();
                    }
                }).allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    public static CountryDatabase getInstance(final Context context) {
        if (sInstance == null){
            synchronized (CountryDatabase.class){
                if (sInstance == null){
                    sInstance = buildDatabase(context);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

}

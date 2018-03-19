package com.dibby.bebek.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dibby.bebek.pojo.Gejala;
import com.dibby.bebek.pojo.Penyakit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dibby on 14/02/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "diagnosa";

    // Contacts table name
    private static final String TABLE_GEJALA = "gejala";
    private static final String TABLE_PENYAKIT = "penyakit";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_ANGKA = "angka";
    private static final String KEY_NAMA = "nama";

    private static final String KEY_NO = "no";
    private static final String KEY_NAME = "name";
    private static final String KEY_JELAS = "jelas";
    private static final String KEY_CEGAH = "cegah";
    private static final String KEY_SOLUSI = "solusi";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_GEJALA_TABLE = "CREATE TABLE " + TABLE_GEJALA + "("
                + KEY_ID + " TEXT PRIMARY KEY, "
                + KEY_NAMA + " TEXT, "
                + KEY_ANGKA + " DOUBLE" + ")";
        db.execSQL(CREATE_GEJALA_TABLE);
        String CREATE_PENYAKIT_TABLE = "CREATE TABLE " + TABLE_PENYAKIT + "("
                + KEY_NO + " TEXT PRIMARY KEY, "
                + KEY_NAME + " TEXT, "
                + KEY_JELAS + " TEXT, "
                + KEY_CEGAH + " TEXT, "
                + KEY_SOLUSI + " TEXT" + ")";
        db.execSQL(CREATE_PENYAKIT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GEJALA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PENYAKIT);
        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    public void onDelete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_GEJALA);
        db.execSQL("delete from "+ TABLE_PENYAKIT);
    }

    // Adding new contact
    public void addGejala(Gejala gejala) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, gejala.getID());
        values.put(KEY_NAMA, gejala.getNama()); // Contact Name
        values.put(KEY_ANGKA, gejala.getAngka()); // Contact Name
        // Inserting Row
        db.insert(TABLE_GEJALA, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public Gejala getGejala(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_GEJALA, new String[] { KEY_ID,
                        KEY_NAMA, KEY_ANGKA }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Gejala gejala = new Gejala(cursor.getString(0), cursor.getString(1),
                Double.parseDouble(cursor.getString(2)));
        // return contact
        return gejala;
    }

    // Getting All Contacts
    public List<Gejala> getAllGejala() {
        List<Gejala> gejalaList = new ArrayList<Gejala>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_GEJALA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Gejala gejala = new Gejala();
                gejala.setID(cursor.getString(0));
                gejala.setNama(cursor.getString(1));
                gejala.setAngka(Double.parseDouble(cursor.getString(2)));
                // Adding contact to list
                gejalaList.add(gejala);
            } while (cursor.moveToNext());
        }

        // return contact list
        return gejalaList;
    }

    // Updating single contact
    public int updateGejala(Gejala gejala) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, gejala.getNama());
        values.put(KEY_ANGKA, gejala.getAngka());
        // updating row
        return db.update(TABLE_GEJALA, values, KEY_ID + " = ?",
                new String[] { String.valueOf(gejala.getID()) });
    }

    // Deleting single contact
    public void deleteGejala(Gejala gejala) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GEJALA, KEY_ID + " = ?",
                new String[] { String.valueOf(gejala.getID()) });
        db.close();
    }


    // Getting contacts Count
    public int getGejalaCount() {
        String countQuery = "SELECT  * FROM " + TABLE_GEJALA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }





    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void addPenyakit(Penyakit penyakit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NO, penyakit.getNo());
        values.put(KEY_NAME, penyakit.getName()); // Contact Name
        values.put(KEY_JELAS, penyakit.getJelas()); // Contact Phone
        values.put(KEY_CEGAH, penyakit.getCegah()); // Contact Name
        values.put(KEY_SOLUSI, penyakit.getSolusi()); // Contact Name
        // Inserting Row
        db.insert(TABLE_PENYAKIT, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public Penyakit getPenyakit(String no) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PENYAKIT, new String[] { KEY_NO,
                        KEY_NAME, KEY_JELAS, KEY_CEGAH, KEY_SOLUSI }, KEY_NO + "=?",
                new String[] { String.valueOf(no) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Penyakit penyakit = new Penyakit(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4));
        // return contact
        return penyakit;
    }

    // Getting All Contacts
    public List<Penyakit> getAllPenyakit() {
        List<Penyakit> penyakitList = new ArrayList<Penyakit>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PENYAKIT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Penyakit penyakit = new Penyakit();
                penyakit.setNo(cursor.getString(0));
                penyakit.setName(cursor.getString(1));
                penyakit.setJelas(cursor.getString(2));
                penyakit.setCegah(cursor.getString(3));
                penyakit.setSolusi(cursor.getString(4));
                // Adding contact to list
                penyakitList.add(penyakit);
            } while (cursor.moveToNext());
        }

        // return contact list
        return penyakitList;
    }

    // Updating single contact
    public int updatePenyakit(Penyakit penyakit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, penyakit.getName());
        values.put(KEY_JELAS, penyakit.getJelas());
        values.put(KEY_CEGAH, penyakit.getCegah());
        values.put(KEY_SOLUSI, penyakit.getSolusi());
        // updating row
        return db.update(TABLE_PENYAKIT, values, KEY_NO + " = ?",
                new String[] { String.valueOf(penyakit.getNo()) });
    }

    // Deleting single contact
    public void deletePenyakit(Penyakit penyakit) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PENYAKIT, KEY_NO + " = ?",
                new String[] { String.valueOf(penyakit.getNo()) });
        db.close();
    }


    // Getting contacts Count
    public int getPenyakitCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PENYAKIT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}

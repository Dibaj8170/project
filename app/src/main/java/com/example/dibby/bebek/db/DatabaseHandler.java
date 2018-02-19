package com.example.dibby.bebek.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dibby.bebek.pojo.Gejala;
import com.example.dibby.bebek.pojo.Penyakit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dibby on 14/02/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
    private static final String TABLE_PENYAKIT = "penyakit";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_ANGKA = "angka";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_KET = "Ket";

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
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_NAMA + " TEXT, "
                + KEY_KET + " TEXT, "
                + KEY_ANGKA + " DOUBLE" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        String CREATE_PENYAKIT_TABLE = "CREATE TABLE " + TABLE_PENYAKIT + "("
                + KEY_NO + " TEXT, "
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PENYAKIT);
        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    public void onDelete(SQLiteDatabase db) {
        db.execSQL("delete from "+ TABLE_CONTACTS);
        db.execSQL("delete from "+ TABLE_PENYAKIT);
    }

    // Adding new contact
    public void addContact(Gejala contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, contact.getNama()); // Contact Name
        values.put(KEY_KET, contact.getKet()); // Contact Phone
        values.put(KEY_ANGKA, contact.getAngka()); // Contact Name
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Gejala getContact(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAMA, KEY_KET, KEY_ANGKA }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Gejala contact = new Gejala(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                Double.parseDouble(cursor.getString(3)));
        // return contact
        return contact;
    }

    // Getting All Contacts
    public List<Gejala> getAllContacts() {
        List<Gejala> contactList = new ArrayList<Gejala>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Gejala contact = new Gejala();
                contact.setID(cursor.getString(0));
                contact.setNama(cursor.getString(1));
                contact.setKet(cursor.getString(2));
                contact.setAngka(Double.parseDouble(cursor.getString(3)));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Updating single contact
    public int updateContact(Gejala contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, contact.getNama());
        values.put(KEY_KET, contact.getKet());
        values.put(KEY_ANGKA, contact.getAngka());
        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    // Deleting single contact
    public void deleteContact(Gejala contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
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
        values.put(KEY_NAME, penyakit.getName()); // Contact Name
        values.put(KEY_JELAS, penyakit.getJelas()); // Contact Phone
        values.put(KEY_CEGAH, penyakit.getCegah()); // Contact Name
        values.put(KEY_SOLUSI, penyakit.getSolusi()); // Contact Name
        // Inserting Row
        db.insert(TABLE_PENYAKIT, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Penyakit getPenyakit(String no) {
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

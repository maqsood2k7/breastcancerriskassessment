package com.cyberxcoder.breastcancerriskassessment;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "cancerdb.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "patients";

    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String AGE_COL = "age";
    private static final String GENDER_COL = "gender";
    private static final String PHONE_COL = "phone";
    private static final String HASANYONEINFAMILY_COL = "hasanyoneinfamily";
    private static final String MATERNALORPATERNALGRANDMOTHERORAUNT_COL = "maternalorpaternalgrandmotheroraunt";
    private static final String MOTHERORSISTER_COL = "motherorsister";
    private static final String MOTHERANDSISTER_COL = "motherandsister";
    private static final String MOTHERANDTWOSISTERS_COL = "motherandtwosisters";
    private static final String DIDYOUHAVEBREASTCANCER_COL = "didyouhavebreastcancer";
    private static final String AGEOFGIVINGBIRTH_COL = "ageofgivingbirth";
    private static final String MENSTURATIONAGE_COL = "mensturationage";
    private static final String MENOPAUSEAGE_COL = "menopauseage";
    private static final String BODYSTRUCTURE_COL = "bodystructure";
    private static final String DOYOUBREASTFEED_COL = "doyoubreastfeed";
    private static final String LUMPS_COL = "lumps";
    private static final String NIPPLEDISCHARGE_COL = "nippledischarge";
    private static final String PRIORBREASTINJURY_COL = "priorbreastinjury";
    private static final String REDNESSORSWELLING_COL = "rednessorswelling";
    private static final String TENDERNESSORPAIN_COL = "tendernessorpain";
    private static final String CONTRACEPTIVES_COL = "contraceptives";
    private static final String LARGEBREASTS_COL = "largebreasts";
    private static final String OTHERS_COL = "others";

    public DBHandler(Context contex) {
        super(contex, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT, "
                + GENDER_COL + " TEXT, "
                + AGE_COL + " TEXT, "
                + PHONE_COL + " TEXT, "
                + HASANYONEINFAMILY_COL + " TEXT, "
                + MATERNALORPATERNALGRANDMOTHERORAUNT_COL + " TEXT, "
                + MOTHERORSISTER_COL + " TEXT, "
                + MOTHERANDSISTER_COL + " TEXT, "
                + MOTHERANDTWOSISTERS_COL + " TEXT, "
                + DIDYOUHAVEBREASTCANCER_COL + " TEXT, "
                + AGEOFGIVINGBIRTH_COL + " TEXT, "
                + MENSTURATIONAGE_COL + " TEXT, "
                + MENOPAUSEAGE_COL + " TEXT, "
                + BODYSTRUCTURE_COL + " TEXT, "
                + DOYOUBREASTFEED_COL + " TEXT, "
                + LUMPS_COL + " TEXT, "
                + NIPPLEDISCHARGE_COL + " TEXT, "
                + PRIORBREASTINJURY_COL + " TEXT, "
                + REDNESSORSWELLING_COL + " TEXT, "
                + TENDERNESSORPAIN_COL + " TEXT, "
                + CONTRACEPTIVES_COL + " TEXT, "
                + LARGEBREASTS_COL + " TEXT, "
                + OTHERS_COL + " TEXT)";

        db.execSQL(query);
    }

    public long addPatientRecord(String name,
                                 String age,
                                 String gender,
                                 String phone,
                                 String hasAnyoneInFamily,
                                 String maternalOrPaternalGrandMotherOrAunt,
                                 String motherOrSister,
                                 String motherAndSister,
                                 String motherAndTwoSisters,
                                 String didYouHaveBreastCancer,
                                 String ageOfGivingBirth,
                                 String mensturationAge,
                                 String menopauseAge,
                                 String bodyStructure,
                                 String doYouBreastFeed,
                                 String lumps,
                                 String nippledischarge,
                                 String priorbreastinjury,
                                 String rednessorswelling,
                                 String tendernessorpain,
                                 String contraceptives,
                                 String largebreasts,
                                 String others)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(GENDER_COL, age);
        values.put(AGE_COL, gender);
        values.put(PHONE_COL, phone);
        values.put(HASANYONEINFAMILY_COL, hasAnyoneInFamily);
        values.put(MATERNALORPATERNALGRANDMOTHERORAUNT_COL, maternalOrPaternalGrandMotherOrAunt);
        values.put(MOTHERORSISTER_COL, motherOrSister);
        values.put(MOTHERANDSISTER_COL, motherAndSister);
        values.put(MOTHERANDTWOSISTERS_COL, motherAndTwoSisters);
        values.put(DIDYOUHAVEBREASTCANCER_COL, didYouHaveBreastCancer);
        values.put(AGEOFGIVINGBIRTH_COL, ageOfGivingBirth);
        values.put(MENSTURATIONAGE_COL, mensturationAge);
        values.put(MENOPAUSEAGE_COL, menopauseAge);
        values.put(BODYSTRUCTURE_COL, bodyStructure);
        values.put(DOYOUBREASTFEED_COL, doYouBreastFeed);
        values.put(LUMPS_COL, lumps);
        values.put(NIPPLEDISCHARGE_COL, nippledischarge);
        values.put(PRIORBREASTINJURY_COL, priorbreastinjury);
        values.put(REDNESSORSWELLING_COL, rednessorswelling);
        values.put(TENDERNESSORPAIN_COL, tendernessorpain);
        values.put(CONTRACEPTIVES_COL, contraceptives);
        values.put(LARGEBREASTS_COL, largebreasts);
        values.put(OTHERS_COL, others);

        long id = db.insert(TABLE_NAME, null, values);
        db.close();

        return id;
    }

    public long addPatientRecord(String name,
                                 String age,
                                 String gender,
                                 String phone,
                                 String hasAnyoneInFamily,
                                 String maternalOrPaternalGrandMotherOrAunt,
                                 String motherOrSister,
                                 String motherAndSister,
                                 String motherAndTwoSisters,
                                 String didYouHaveBreastCancer,
                                 String ageOfGivingBirth,
                                 String mensturationAge,
                                 String menopauseAge,
                                 String bodyStructure,
                                 String doYouBreastFeed)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(GENDER_COL, age);
        values.put(AGE_COL, gender);
        values.put(PHONE_COL, phone);
        values.put(HASANYONEINFAMILY_COL, hasAnyoneInFamily);
        values.put(MATERNALORPATERNALGRANDMOTHERORAUNT_COL, maternalOrPaternalGrandMotherOrAunt);
        values.put(MOTHERORSISTER_COL, motherOrSister);
        values.put(MOTHERANDSISTER_COL, motherAndSister);
        values.put(MOTHERANDTWOSISTERS_COL, motherAndTwoSisters);
        values.put(DIDYOUHAVEBREASTCANCER_COL, didYouHaveBreastCancer);
        values.put(AGEOFGIVINGBIRTH_COL, ageOfGivingBirth);
        values.put(MENSTURATIONAGE_COL, mensturationAge);
        values.put(MENOPAUSEAGE_COL, menopauseAge);
        values.put(BODYSTRUCTURE_COL, bodyStructure);
        values.put(DOYOUBREASTFEED_COL, doYouBreastFeed);

        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public void updatePatientRecord(long id, String lumps,
                                    String nippledischarge,
                                    String priorbreastinjury,
                                    String rednessorswelling,
                                    String tendernessorpain,
                                    String contraceptives,
                                    String largebreasts,
                                    String others)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(LUMPS_COL, lumps);
        values.put(NIPPLEDISCHARGE_COL, nippledischarge);
        values.put(PRIORBREASTINJURY_COL, priorbreastinjury);
        values.put(REDNESSORSWELLING_COL, rednessorswelling);
        values.put(TENDERNESSORPAIN_COL, tendernessorpain);
        values.put(CONTRACEPTIVES_COL, contraceptives);
        values.put(LARGEBREASTS_COL, largebreasts);
        values.put(OTHERS_COL, others);

        db.update(TABLE_NAME, values, ID_COL + " = " + id, null);
    }

    public String[] selectPatientRecord(long id, String reportType) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        String[] data = null;

        if(reportType.equals("half")){
            cur = db.query(TABLE_NAME, new String[]{NAME_COL, GENDER_COL, AGE_COL, PHONE_COL, HASANYONEINFAMILY_COL, MATERNALORPATERNALGRANDMOTHERORAUNT_COL, MOTHERORSISTER_COL, MOTHERANDSISTER_COL, MOTHERANDTWOSISTERS_COL, DIDYOUHAVEBREASTCANCER_COL, AGEOFGIVINGBIRTH_COL, MENSTURATIONAGE_COL, MENOPAUSEAGE_COL, BODYSTRUCTURE_COL, DOYOUBREASTFEED_COL}, ID_COL + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
            if(cur!=null) {
                cur.moveToFirst();
                data = new String[]{cur.getString(0), cur.getString(1), cur.getString(2), cur.getString(3), cur.getString(4), cur.getString(5), cur.getString(6), cur.getString(7), cur.getString(8), cur.getString(9), cur.getString(10), cur.getString(11), cur.getString(12), cur.getString(13), cur.getString(14)};
            }
        }
        else if(reportType.equals("full")) {
            cur = db.query(TABLE_NAME, new String[]{NAME_COL, GENDER_COL, AGE_COL, PHONE_COL, HASANYONEINFAMILY_COL, MATERNALORPATERNALGRANDMOTHERORAUNT_COL, MOTHERORSISTER_COL, MOTHERANDSISTER_COL, MOTHERANDTWOSISTERS_COL, DIDYOUHAVEBREASTCANCER_COL, AGEOFGIVINGBIRTH_COL, MENSTURATIONAGE_COL, MENOPAUSEAGE_COL, BODYSTRUCTURE_COL, DOYOUBREASTFEED_COL, LUMPS_COL, NIPPLEDISCHARGE_COL, PRIORBREASTINJURY_COL, REDNESSORSWELLING_COL, TENDERNESSORPAIN_COL, CONTRACEPTIVES_COL, LARGEBREASTS_COL, OTHERS_COL}, ID_COL + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
            if(cur!=null) {
                cur.moveToFirst();
                data = new String[]{cur.getString(0), cur.getString(1), cur.getString(2), cur.getString(3), cur.getString(4), cur.getString(5), cur.getString(6), cur.getString(7), cur.getString(8), cur.getString(9), cur.getString(10), cur.getString(11), cur.getString(12), cur.getString(13), cur.getString(14), cur.getString(15), cur.getString(16), cur.getString(17), cur.getString(18), cur.getString(19), cur.getString(20), cur.getString(21), cur.getString(22)};
            }
        }

        assert cur != null;
        cur.close();
        return data;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

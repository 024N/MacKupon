package oz.mac.kupon.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

import oz.mac.kupon.Model.KuponModel;
import oz.mac.kupon.Model.MacModel;

public class DBHelper extends SQLiteOpenHelper {

    private String TAG = "SQLiteOpenHelper";

    private static final String DATABASE_NAME = "mackupon";
    // Contacts table name
    private static final String TABLE_MACLAR = "maclarTablo";
    private static final String TABLE_KUPONLAR = "kuponlarTablo";

    String macSQL = "CREATE TABLE "
            + TABLE_MACLAR + "(id INTEGER PRIMARY KEY, "
            + "saat TEXT, "
            + "tarih TEXT, "
            + "evSahibiTakim TEXT, "
            + "konukTakim TEXT, "
            + "macTahmini TEXT, "
            + "oran TEXT, "
            + "diger TEXT, "
            + "documentID TEXT" + ")";

    String kuponSQL = "CREATE TABLE "
            + TABLE_KUPONLAR + "(id INTEGER PRIMARY KEY, "
            + "kuponTarih TEXT, "
            + "mac1 TEXT, "
            + "mac2 TEXT, "
            + "mac3 TEXT, "
            + "mac4 TEXT, "
            + "mac5 TEXT, "
            + "mac6 TEXT, "
            + "mac7 TEXT, "
            + "mac8 TEXT, "
            + "mac9 TEXT, "
            + "toplam TEXT, "
            + "documentID TEXT" + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        Log.d("DBHelper", "Mac SQL : " + macSQL);
        Log.d("DBHelper", "Kupon SQL : " + kuponSQL);

        database.execSQL(macSQL);
        database.execSQL(kuponSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_MACLAR);
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_KUPONLAR);

        onCreate(database);
    }

    @Override
    public void onDowngrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        onUpgrade(database, oldVersion, newVersion);
    }

    public void insertMaclar(MacModel macModel, String documentID) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("saat", macModel.getSaat());
        values.put("tarih", macModel.getTarih());
        values.put("evSahibiTakim", macModel.getEvSahibiTakim());
        values.put("konukTakim", macModel.getKonukTakim());
        values.put("macTahmini", macModel.getMacTahmini());
        values.put("oran", macModel.getOran());
        values.put("diger", macModel.getDiger());
        values.put("documentID", documentID);

        db.insert(TABLE_MACLAR, null, values);
    }

    public void insertKuponlar(KuponModel kuponModel, String documentID) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("kuponTarih", kuponModel.getKuponTarih());
        values.put("mac1", kuponModel.getMac1());
        values.put("mac2", kuponModel.getMac2());
        values.put("mac3", kuponModel.getMac3());
        values.put("mac4", kuponModel.getMac4());
        values.put("mac5", kuponModel.getMac5());
        values.put("mac6", kuponModel.getMac6());
        values.put("mac7", kuponModel.getMac7());
        values.put("mac8", kuponModel.getMac8());
        values.put("mac9", kuponModel.getMac9());
        values.put("toplam", kuponModel.getToplam());
        values.put("documentID", documentID);

        db.insert(TABLE_KUPONLAR, null, values);
    }

    public void createTables(){
        SQLiteDatabase db = this.getWritableDatabase();
        onCreate(db);
    }

    public void deleteMaclar() {
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete("maclarTablo", null, null);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MACLAR);
    }

    public void deleteKuponlar() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KUPONLAR);
    }

    public ArrayList<MacModel> getAllMac() {
        ArrayList<MacModel> maclar = new ArrayList<MacModel>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_MACLAR,
                new String[]{"id", "saat", "tarih", "evSahibiTakim", "konukTakim", "macTahmini", "oran", "diger", "documentID"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            MacModel macModel = new MacModel();
            macModel.setSaat(cursor.getString(1));
            macModel.setTarih(cursor.getString(2));
            macModel.setEvSahibiTakim(cursor.getString(3));
            macModel.setKonukTakim(cursor.getString(4));
            macModel.setMacTahmini(cursor.getString(5));
            macModel.setOran(cursor.getString(6));
            macModel.setDiger(cursor.getString(7));
            macModel.setDocumentID(cursor.getString(8));

            maclar.add(macModel);
        }
        db.close();
        return maclar;
    }

    public ArrayList<KuponModel> getAllKupon() {
        ArrayList<KuponModel> kuponlar = new ArrayList<KuponModel>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_KUPONLAR,
                new String[]{"id", "kuponTarih", "mac1", "mac2", "mac3", "mac4", "mac5", "mac6", "mac7", "mac8", "mac9", "toplam", "documentID"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            KuponModel kuponModel = new KuponModel();
            kuponModel.setKuponTarih(cursor.getString(1));
            kuponModel.setMac1(cursor.getString(2));
            kuponModel.setMac2(cursor.getString(3));
            kuponModel.setMac3(cursor.getString(4));
            kuponModel.setMac4(cursor.getString(5));
            kuponModel.setMac5(cursor.getString(6));
            kuponModel.setMac6(cursor.getString(7));
            kuponModel.setMac7(cursor.getString(8));
            kuponModel.setMac8(cursor.getString(9));
            kuponModel.setMac9(cursor.getString(10));
            kuponModel.setToplam(cursor.getString(11));
            kuponModel.setDocumentID(cursor.getString(12));

            kuponlar.add(kuponModel);
        }
        db.close();
        return kuponlar;
    }
}
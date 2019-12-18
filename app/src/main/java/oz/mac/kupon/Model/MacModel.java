package oz.mac.kupon.Model;

import java.io.Serializable;

import androidx.annotation.Keep;

@Keep
public class MacModel  implements Serializable {

    private String saat;
    private String tarih;
    private String evSahibiTakim;
    private String konukTakim;
    private String macTahmini;
    private String oran;
    private String diger;
    private String documentID;

    public MacModel() {
    }

    public MacModel(String saat, String tarih, String evSahibiTakim, String konukTakim, String macTahmini, String oran, String diger, String documentID) {
        this.saat = saat;
        this.tarih = tarih;
        this.evSahibiTakim = evSahibiTakim;
        this.konukTakim = konukTakim;
        this.macTahmini = macTahmini;
        this.oran = oran;
        this.diger = diger;
        this.documentID = documentID;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getEvSahibiTakim() {
        return evSahibiTakim;
    }

    public void setEvSahibiTakim(String evSahibiTakim) {
        this.evSahibiTakim = evSahibiTakim;
    }

    public String getKonukTakim() {
        return konukTakim;
    }

    public void setKonukTakim(String konukTakim) {
        this.konukTakim = konukTakim;
    }

    public String getMacTahmini() {
        return macTahmini;
    }

    public void setMacTahmini(String macTahmini) {
        this.macTahmini = macTahmini;
    }

    public String getOran() {
        return oran;
    }

    public void setOran(String oran) {
        this.oran = oran;
    }

    public String getDiger() {
        return diger;
    }

    public void setDiger(String diger) {
        this.diger = diger;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    @Override
    public String toString() {
        return "MacModel{" +
                "saat='" + saat + '\'' +
                ", tarih='" + tarih + '\'' +
                ", evSahibiTakim='" + evSahibiTakim + '\'' +
                ", konukTakim='" + konukTakim + '\'' +
                ", macTahmini='" + macTahmini + '\'' +
                ", oran='" + oran + '\'' +
                ", diger='" + diger + '\'' +
                ", documentID='" + documentID + '\'' +
                '}';
    }
}
package oz.mac.kupon.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Keep;

@Keep
public class KuponModel implements Serializable {

    private String kuponTarih;
    private String toplam;
    private String mac1;
    private String mac2;
    private String mac3;
    private String mac4;
    private String mac5;
    private String mac6;
    private String mac7;
    private String mac8;
    private String mac9;
    private String documentID;

    public KuponModel() {
    }

    public KuponModel(String kuponTarih, String toplam, String mac1, String mac2, String mac3, String mac4, String mac5, String mac6, String mac7, String mac8, String mac9, String documentID) {
        this.kuponTarih = kuponTarih;
        this.toplam = toplam;
        this.mac1 = mac1;
        this.mac2 = mac2;
        this.mac3 = mac3;
        this.mac4 = mac4;
        this.mac5 = mac5;
        this.mac6 = mac6;
        this.mac7 = mac7;
        this.mac8 = mac8;
        this.mac9 = mac9;
        this.documentID = documentID;
    }

    public String getKuponTarih() {
        return kuponTarih;
    }

    public void setKuponTarih(String kuponTarih) {
        this.kuponTarih = kuponTarih;
    }

    public String getToplam() {
        return toplam;
    }

    public void setToplam(String toplam) {
        this.toplam = toplam;
    }

    public String getMac1() {
        return mac1;
    }

    public void setMac1(String mac1) {
        this.mac1 = mac1;
    }

    public String getMac2() {
        return mac2;
    }

    public void setMac2(String mac2) {
        this.mac2 = mac2;
    }

    public String getMac3() {
        return mac3;
    }

    public void setMac3(String mac3) {
        this.mac3 = mac3;
    }

    public String getMac4() {
        return mac4;
    }

    public void setMac4(String mac4) {
        this.mac4 = mac4;
    }

    public String getMac5() {
        return mac5;
    }

    public void setMac5(String mac5) {
        this.mac5 = mac5;
    }

    public String getMac6() {
        return mac6;
    }

    public void setMac6(String mac6) {
        this.mac6 = mac6;
    }

    public String getMac7() {
        return mac7;
    }

    public void setMac7(String mac7) {
        this.mac7 = mac7;
    }

    public String getMac8() {
        return mac8;
    }

    public void setMac8(String mac8) {
        this.mac8 = mac8;
    }

    public String getMac9() {
        return mac9;
    }

    public void setMac9(String mac9) {
        this.mac9 = mac9;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    @Override
    public String toString() {
        return "KuponModel{" +
                "kuponTarih='" + kuponTarih + '\'' +
                ", toplam='" + toplam + '\'' +
                ", mac1='" + mac1 + '\'' +
                ", mac2='" + mac2 + '\'' +
                ", mac3='" + mac3 + '\'' +
                ", mac4='" + mac4 + '\'' +
                ", mac5='" + mac5 + '\'' +
                ", mac6='" + mac6 + '\'' +
                ", mac7='" + mac7 + '\'' +
                ", mac8='" + mac8 + '\'' +
                ", mac9='" + mac9 + '\'' +
                ", documentID='" + documentID + '\'' +
                '}';
    }
}
package org.ivz.pmdm.aurbano.concesionario;

import android.os.Parcel;
import android.os.Parcelable;

public class Coche implements Parcelable{

    private int ref;
    private String titulo;
    private String desc;
    private String url;
    private String img;
    private int precio;
    private String comb;
    private int km;
    private String cambio;
    private int potencia;
    private int npuertas;
    private String color;
    private int año;

    public Coche() {
    }

    public Coche(int ref, String titulo, String desc, String url, String img, int precio, String comb, int km, String cambio, int potencia, int npuertas, String color, int año) {
        this.ref = ref;
        this.titulo = titulo;
        this.desc = desc;
        this.url = url;
        this.img = img;
        this.precio = precio;
        this.comb = comb;
        this.km = km;
        this.cambio = cambio;
        this.potencia = potencia;
        this.npuertas = npuertas;
        this.color = color;
        this.año = año;
    }

    protected Coche(Parcel in){
        ref = in.readInt();
        titulo = in.readString();
        desc = in.readString();
        url = in.readString();
        img = in.readString();
        precio = in.readInt();
        comb = in.readString();
        km = in.readInt();
        cambio = in.readString();
        potencia = in.readInt();
        npuertas = in.readInt();
        color = in.readString();
        año = in.readInt();
    }

    public static final Creator<Coche> CREATOR = new Parcelable.Creator<Coche>() {
        @Override
        public Coche createFromParcel(Parcel in) {
            return new Coche(in);
        }

        @Override
        public Coche[] newArray(int size) {
            return new Coche[size];
        }
    };

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getComb() {
        return comb;
    }

    public void setComb(String comb) {
        this.comb = comb;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getNpuertas() {
        return npuertas;
    }

    public void setNpuertas(int npuertas) {
        this.npuertas = npuertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeInt(ref);
        parcel.writeString(titulo);
        parcel.writeString(desc);
        parcel.writeString(url);
        parcel.writeString(img);
        parcel.writeInt(precio);
        parcel.writeString(comb);
        parcel.writeInt(km);
        parcel.writeString(cambio);
        parcel.writeInt(potencia);
        parcel.writeInt(npuertas);
        parcel.writeString(color);
        parcel.writeInt(año);
    }
}

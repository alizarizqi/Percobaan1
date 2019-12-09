/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java_hotel_system;

/**
 *
 * @author user
 */
public class ModelHotel {
    private String nama;
    private String satuan;
    private double harga;

    public ModelHotel(String nama, String satuan, double harga) {
        this.nama = nama;
        this.satuan = satuan;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return this.nama;
    }

    /**
     * @return the namaBarang
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param namaBarang the namaBarang to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the satuan
     */
    public String getSatuan() {
        return satuan;
    }

    /**
     * @param satuan the satuan to set
     */
    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    /**
     * @return the harga
     */
    public double getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    //menambahkan unit testing
    
     public String messageFormat(){
        String message = String.format("Hai %s, you have message from %s."
                + "\nThe message as follows : %s", this.nama
                , this.satuan, this.harga);
        return message;
    }
    
    public void showMessage(){
        System.out.println(messageFormat());
    }
    
}

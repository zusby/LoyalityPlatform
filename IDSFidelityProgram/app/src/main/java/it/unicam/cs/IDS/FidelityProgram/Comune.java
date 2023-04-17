package it.unicam.cs.IDS.FidelityProgram;

public class Comune {
    private String zipcode;
    private String city;
    private String province;

    public Comune(String zipcode, String city, String province) {
        this.zipcode = zipcode;
        this.city = city;
        this.province = province;
    }
    public Comune(String province, String zipcode) {
        this.province = province;
        this.zipcode = zipcode;
    }


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}

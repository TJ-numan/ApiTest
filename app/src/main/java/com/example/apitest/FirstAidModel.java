package com.example.apitest;

public class FirstAidModel {

    int  Idmodel ;
    String HospitalCodemodel;
    String HospitalNamemodel;
    String Districmodel;
    String HospitalAddressmodel;


    public FirstAidModel(int idmodel, String hospitalCodemodel, String hospitalNamemodel,String hospitalAddressmodel) {
        Idmodel = idmodel;
        HospitalCodemodel = hospitalCodemodel;
        HospitalNamemodel = hospitalNamemodel;
        HospitalAddressmodel = hospitalAddressmodel;
    }

    public int getIdmodel() {
        return Idmodel;
    }

    public String getHospitalCodemodel() {
        return HospitalCodemodel;
    }

    public String getHospitalNamemodel() {
        return HospitalNamemodel;
    }

    public String getHospitalAddressmodel() {
        return HospitalAddressmodel;
    }
}

package com.example.apitest;

public class FirstAidModel {

    int  Idmodel ;
    String HospitalCodemodel;
    String HospitalNamemodel;

    public FirstAidModel(int idmodel, String hospitalCodemodel, String hospitalNamemodel) {
        Idmodel = idmodel;
        HospitalCodemodel = hospitalCodemodel;
        HospitalNamemodel = hospitalNamemodel;
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
    //
//
//    public int getIdmodel() {
//        return Idmodel;
//    }
//
//    public String getHospitalCode() {
//        return HospitalCodemodel;
//    }
//
//    public String getHospitalName() {
//        return HospitalNamemodel;
//    }
//



}

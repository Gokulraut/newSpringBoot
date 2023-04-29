package com.csi.constants;

public class EmployeeConstant {
    public static final String SIGNIUP = "/signUp";
    public static final String SIGNIIN = "/signIn/{empEmailId}/{empPassword}";
    public static final String GETALLDATA = "/getAllData";
    public static final String GETDATABYID = "/getDataById/{empId}";
    public static final String UPDATE = "/update/{empId}";
    public static final String DELETEBYID = "/deleteById/{empId}";
    public static final String DELETEALLDATA = "/deleteAllData";
    public static final String SAVEBULKOFDATA = "/savebulkofdata";
    public static final String GETDATABYANYINPUT = "/getdatabyanyinput/{input}";
    public static final String SORTBYNAME = "/SORTBYNAME";
    public static final String SORTBYDOB = "/sortBydob";
    public static final String SORTBYEMPID = "/sortByempId";
    public static final String CHECKLOANELIGIBLITY = "/checkloanEligibility/{empId}";
    public static final String SORTBYSALARY = "/sortbySalary";

    public static final String FILTERBYSALARY = "/FilterbySalary/{empSalary}";
    public static final String GETDATABYDOB = "/getdatabydob/{empDob}";
    public static final String GETDATABYEMAIL = "/getdatabyemailId/{empEmailId}";
    public static final String GETDATABYCONTACT = "/getdatabycontact/{empContact}";
    public static final String GETDATABYFIRSTNAME = "/grtdatabyName/{empFirstName}";
    public static final String GETDATABYNAMEs = "/grtdatabyName/{empFirstName}/{empLastName}";
    public static final String GETDATABYSALARY= "/grtdatabySalary/{empSalary}";
    public static final String SEARCHDATABYID= "/searchdatabyId/{empId}";

}

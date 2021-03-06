package com.hrms.utils;

import net.minidev.json.JSONObject;

public class apiPayloadConstants {
    public static String createEmployeeBody(){

        JSONObject obj=new JSONObject();
        obj.put("emp_firstname","Elias");
        obj.put("emp_lastname","Alvial");
        obj.put("emp_middle_name","Y");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2021-02-27");
        obj.put("emp_status","Employee");
        obj.put("emp_job_title","Cloud Architect");

        return obj.toString();

    }
}

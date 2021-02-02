package com.hrms.testbase;

import com.hrms.pages.*;
import io.cucumber.java.bs.A;

public class PageInitializer extends BaseClass{
    public static LoginPage loginPage;
    public static DashBoardPage dashBoardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeListPage employeeListPage;
    public static PersonalDetailPage personalDetailPage;
    public static PIMConfigurationPage pimConfigurationPage;

    public static void initializePageObjects(){
        loginPage=new LoginPage();
        dashBoardPage=new DashBoardPage();
        addEmployeePage=new AddEmployeePage();
        employeeListPage=new EmployeeListPage();
        personalDetailPage=new PersonalDetailPage();
        pimConfigurationPage=new PIMConfigurationPage();

    }
}

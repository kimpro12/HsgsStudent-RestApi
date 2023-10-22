package com.HsgsStudent.Rest;

import com.HsgsStudent.Data.Data;
import com.HsgsStudent.Data.DataSort;
import com.HsgsStudent.Data.ProcessData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class RestApi {
    final String FILEDATANAME_V1 = "datav1.txt";

    @GetMapping("/v1/getinfo")
    public ArrayList<Data> getFullInfomation(@RequestParam(name = "firstname") String firstname,
                                             @RequestParam(name = "midname") String midname,
                                             @RequestParam(name = "lastname") String lastname,
                                             @RequestParam(name = "day") String day,
                                             @RequestParam(name = "month") String month,
                                             @RequestParam(name = "year") String year,
                                             @RequestParam(name = "lop") String lop,
                                             @RequestParam(name = "hechuyen") String hechuyen) {
        ProcessData process = new ProcessData();
        ArrayList<Data> data = process.getDataFromFile(FILEDATANAME_V1);
        ArrayList<String> listmidname = process.convertMidnameToListMidName(midname);
        if (firstname.equalsIgnoreCase("null")) firstname = null;
        if (midname.equalsIgnoreCase("null")) listmidname = null;
        if (lastname.equalsIgnoreCase("null")) lastname = null;
        if (day.equalsIgnoreCase("null")) day = null;
        if (month.equalsIgnoreCase("null")) month = null;
        if (year.equalsIgnoreCase("null")) year = null;
        if (lop.equalsIgnoreCase("null")) lop = null;
        if (hechuyen.equalsIgnoreCase("null")) hechuyen = null;
        ArrayList<Data> dataAfterProcess = process.processData(firstname, listmidname, lastname, day, month, year, lop, hechuyen, data);
        dataAfterProcess.sort(new DataSort());
        return dataAfterProcess;
    }
}


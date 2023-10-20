package com.HsgsStudent.Data;

import com.HsgsStudent.Rest.RestApi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class ProcessData {
    public ArrayList<String> convertMidnameToListMidName(String midname) {
        String[] listmidname = midname.split(" ");
        ArrayList<String> ret = new ArrayList<>(Arrays.asList(listmidname));
        return ret;
    }

    public boolean customEqual(String str1, String str2) {
        Collator collator = Collator.getInstance(new Locale("vi"));
        collator.setStrength(Collator.PRIMARY);
        return collator.compare(str1, str2) == 0;
    }

    public boolean customEqual(ArrayList<String> list1, ArrayList<String> list2) {
        Collator collator = Collator.getInstance(new Locale("vi"));
        collator.setStrength(Collator.PRIMARY);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!customEqual(list1.get(i), list2.get(i))) return false;
        }
        return true;
    }

    public ArrayList<Data> getDataFromFile(String filePath) {
        ArrayList<Data> ans = new ArrayList<>();
        try {
            // Get the class loader
            ClassLoader classLoader = RestApi.class.getClassLoader();
            // Load the file as a resource
            InputStream inputStream = classLoader.getResourceAsStream(filePath);
            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                // Read and print each line in the text file
                while ((line = bufferedReader.readLine()) != null) {
                    String[] t = line.split("\\|");
                    Data idk = new Data();
                    String[] name = t[0].split(" ");
                    idk.setFirstname(name[0]);
                    ArrayList<String> listmidname = new ArrayList<>(Arrays.asList(name).subList(1, name.length));
                    idk.setMidname(listmidname);
                    idk.setLastname(t[1]);
                    String[] daymonthyear = t[2].split("/");
                    idk.setDay(daymonthyear[0]);
                    idk.setMonth(daymonthyear[1]);
                    idk.setYear(daymonthyear[2]);
                    String[] lophechuyen = t[3].split(" ");
                    idk.setLop(lophechuyen[0]);
                    idk.setHechuyen(lophechuyen[1]);
                    ans.add(idk);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }
    public ArrayList<Data> processData(String firstname, ArrayList<String> midname, String lastname,
                                       String day, String month, String year, String lop,
                                       String hechuyen, ArrayList<Data> listdata) {
        ArrayList<Data> ret = new ArrayList<>();
        for (Data data : listdata) {
            if (firstname != null) if (!customEqual(firstname, data.getFirstname())) continue;
            if (midname != null) if (!customEqual(midname, data.getMidname())) continue;
            if (lastname != null) if (!customEqual(lastname, data.getLastname())) continue;
            if (day != null) if (!customEqual(day, data.getDay())) continue;
            if (month != null) if (!customEqual(month, data.getMonth())) continue;
            if (year != null) if (!customEqual(year, data.getYear())) continue;
            if (lop != null) if (!customEqual(lop, data.getLop())) continue;
            if (hechuyen != null) if (!customEqual(hechuyen, data.getHechuyen())) continue;
            ret.add(data);
        }
        return ret;
    }
}

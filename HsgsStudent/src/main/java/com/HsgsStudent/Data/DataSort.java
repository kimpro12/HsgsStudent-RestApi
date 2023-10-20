package com.HsgsStudent.Data;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class DataSort implements Comparator<Data> {
    public int compare(Data data, Data other) {
        Collator collator = Collator.getInstance(new Locale("vi", "VN"));
        int lastNameComp = collator.compare(data.getLastname(), other.getLastname());
        int firstNameComp = collator.compare(data.getFirstname(), other.getFirstname());
        if (lastNameComp != 0) {
            return lastNameComp;
        }
        if (firstNameComp != 0) {
            return firstNameComp;
        }
        ArrayList<String> midName = data.getMidname();
        ArrayList<String> othermidName = other.getMidname();
        for (int i = 0, j = 0; i < midName.size() && j < othermidName.size(); i++, j++) {
            int idk = collator.compare(midName.get(i), othermidName.get(i));
            if (idk != 0) {
                return idk;
            }
        }
        return 0;
    }
}

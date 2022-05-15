/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import sun.font.SunFontManager;

/**
 *
 * @author Le Van Hieu CE160866
 */
public class DateValidator {
    public static boolean isDateValid(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
}

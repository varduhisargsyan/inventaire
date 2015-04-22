package org.sp.librairie.inventaire.test;

import org.sp.librairie.inventaire.dao.*;

import org.sp.librairie.inventaire.model.*;
import org.sp.librairie.inventaire.service.CategoryService;
import org.sp.librairie.inventaire.util.STATUS;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by varduhi on 9/17/2014.
 */
public class Boot {


    private  static Date parseToDate(String dateString) {
        Date date = null;
        if (dateString != null && !dateString.trim().isEmpty()) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            try {
                date = dateFormatter.parse(dateString);
                System.out.println(date);

            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }
        return date;
    }

    public static void main(String[] args) throws Exception {


        ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"file:D:/inventaire/src/main/webapp/WEB-INF/spring-config.xml"});

        BookDao bookDao=(BookDao)context.getBean("bookDao");
        CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");

for(int i=2; i<=39; i++) {
    Category category=categoryDao.getCategoryWithBooks(i);

}

}}
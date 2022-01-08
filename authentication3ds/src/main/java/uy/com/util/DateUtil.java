/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uy.com.controller.UserRestController;

/**
 *
 * @author jesus
 */
@Component
public class DateUtil {

    static final Logger log = Logger.getLogger(DateUtil.class.getName());

    @Value("jms.jwt.timezone")
    private String jmsJwtTimeZone;
    
     @Value("jms.jwt.timezone.date.format")
    private String jmsJwtTimeZoneDateformat;

    private SimpleDateFormat simpleDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone(jmsJwtTimeZone));
        return sdf;
    }

    public String getDateString() {
        Date now = new Date();
        return simpleDateFormat().format(now);
    }

    public long getDateMillis() {

        Date now = new Date();
        String strDate = simpleDateFormat().format(now);
        Date strNow = new Date();

        try {
            strNow = simpleDateFormat().parse(strDate);
        } catch (ParseException ex) {
            log.warning(ex.getMessage());
        }
        return strNow.getTime();
    }

}

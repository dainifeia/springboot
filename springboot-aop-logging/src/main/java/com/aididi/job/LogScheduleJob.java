package com.aididi.job;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuzexiang
 * @Date: 2018-9-29 0029
 * @Description:
 */
@Component
@Log4j2
public class LogScheduleJob {

    @Scheduled(fixedRate = 2*1000)
    public void testLogging(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("Sysdate Date:"+sdf.format(date));
        log.info("----DEBUG----");
        log.info("now:"+date.getTime());

    }
}

package com.group15.msm.message.response;

import lombok.Getter;
import org.springframework.http.ResponseEntity;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 21-11-2019
 * Time: 09:28
 */
public class DataResponse {

    public static ResponseEntity<Object> getData(Object body) {
        return ResponseEntity.ok(new Data(body));
    }
    @Getter
    private static class Data {
        private Object myData ;
        private String version="1.0";
        private Data(Object data) {
            this.myData = data;
        }
    }
}

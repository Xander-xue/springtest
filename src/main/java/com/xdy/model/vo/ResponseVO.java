package com.xdy.model.vo;
/**
 * Created by kun on 2017/5/26.
 */

import java.io.Serializable;

public class ResponseVO implements Serializable {
    private static final long serialVersionUID = -8145865776285690954L;
    private static final int DEFAULT_STATUS_CODE = 200;
    private static final String DEFAULT_MESSAGE = "success";
    private int status_code;
    private String message;
    private Object data;
    private long timestamp;

    private ResponseVO(int status_code, String message, Object data) {
        super();
        this.status_code = status_code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public static ResponseVOBuilder response() {
        return new ResponseVOBuilder();
    }

    public static ResponseVOBuilder response(int status_code, String message) {
        return new ResponseVOBuilder(status_code, message);
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "status_code=" + status_code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResponseVOBuilder {
        private int status_code = DEFAULT_STATUS_CODE;
        private String message = DEFAULT_MESSAGE;
        private Object data;
        private long timestamp;

        public ResponseVOBuilder() {
            super();
        }

        public ResponseVOBuilder(int status_code, String message) {
            super();
            this.status_code = status_code;
            this.message = message;
            this.timestamp = System.currentTimeMillis();
        }

        public ResponseVOBuilder setStatus_code(int status_code) {
            this.status_code = status_code;
            return this;
        }

        public ResponseVOBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ResponseVOBuilder setData(Object data) {
            this.data = data;
            return this;
        }

        public ResponseVO build() {
            return new ResponseVO(status_code, message, data);
        }
    }
}
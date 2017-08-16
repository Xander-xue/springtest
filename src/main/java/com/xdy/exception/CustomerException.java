package com.xdy.exception;

/**
 * User: xuedaiyao
 * Date: 2017/8/11
 * Time: 15:17
 * Description: 自定义运行异常
 */

public class CustomerException extends RuntimeException {
    private static final long serialVersionUID = -1835206418558868797L;
    private String errorMsg;
    private int errorCode;

    public CustomerException() {
        super();
    }

    public CustomerException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public CustomerException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "WzDaiException{" +
                "errorMsg='" + errorMsg + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}

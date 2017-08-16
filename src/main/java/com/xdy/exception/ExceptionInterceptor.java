package com.xdy.exception;

import com.xdy.model.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * User: xuedaiyao
 * Date: 2017/8/11
 * Time: 15:17
 * Description: 全局异常拦截器
 */

@RestControllerAdvice
public class ExceptionInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionInterceptor.class);
    private static final String ERROR_DESC = "error occurred.";

    /**
     * 处理自定义异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = CustomerException.class)
    public ResponseVO handleCustomException(CustomerException ex) {
        if (ex.getErrorCode() == 401) {
            return createModelAndView(HttpServletResponse.SC_UNAUTHORIZED, ERROR_DESC, ex.getErrorMsg());
        } else {
            return createModelAndView(HttpServletResponse.SC_BAD_REQUEST, ERROR_DESC, ex.getErrorMsg());
        }
    }

    /**
     * 处理其它异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseVO handleAllException(Exception ex) {
        ex.printStackTrace();
        logger.error("未知异常：", ex);
        return createModelAndView(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ERROR_DESC, ex.getMessage());
    }

    private ResponseVO createModelAndView(int status_code, String message, String errormsg) {
        ResponseVO response = ResponseVO.response(status_code, message).setMessage(errormsg).setData(null)
                .build();
        return response;
    }
}

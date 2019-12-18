package com.blogger.bloggerservice.filter;


import com.blogger.bloggerservice.response.ResultVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apple
 * @date 19/3/18
 */
@ControllerAdvice
public class ExpetionHandle {

    private static final Log LOG = LogFactory.getLog(ExpetionHandle.class);

    /**
     * 返回Validated错误
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultVo handleRespException(BindException e) {
        BindingResult bindingResult = ((BindException)e).getBindingResult();
        StringBuilder errMsg = new StringBuilder();
        for (int i = 0 ; i < bindingResult.getFieldErrors().size() ; i++) {
            if(i > 0) {
                errMsg.append(",");
            }
            FieldError error = bindingResult.getFieldErrors().get(i);
            errMsg.append(error.getDefaultMessage());
        }

        return ResultVo.fail(errMsg);
    }
}

package cn.trawe.operation.base.third.common.config;

import cn.trawe.operation.base.third.msg.ErrorCode;
import cn.trawe.operation.base.third.msg.ResultBody;
import cn.trawe.pay.common.exception.TraweServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;

/**
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = TraweServiceException.class)
    public ResultBody handleTraweServiceException(Exception e) {
        log.info("服务异常" ,e);
        return ResultBody.failed().msg(e.getMessage());
    }


    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return BaseResponse
     */
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public ResultBody validExceptionHandler(Exception e) {

        List<FieldError> fieldErrors = null;
        if (e instanceof BindException) {
            fieldErrors = ((BindException) e).getBindingResult().getFieldErrors();
        } else if (e instanceof MethodArgumentNotValidException) {
            fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
        }
        StringBuilder message = new StringBuilder();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return ResultBody.failed().code(ErrorCode.BAD_REQUEST.getCode()).msg(message.toString());
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return BaseResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultBody handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArr[1]).append(violation.getMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return  ResultBody.failed().code(ErrorCode.BAD_REQUEST.getCode()).msg(message.toString());
    }


    @ExceptionHandler(value = ValidationException.class)
    public ResultBody handleValidationException(Exception e) {
        log.info("参数校验异常" ,e);
        return ResultBody.failed().code(ErrorCode.BAD_REQUEST.getCode()).msg(e.getMessage());
    }


    @ExceptionHandler(value = Exception.class)
    public ResultBody handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return ResultBody.failed();
    }


}

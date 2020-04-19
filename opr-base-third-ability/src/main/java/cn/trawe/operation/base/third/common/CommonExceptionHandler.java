package cn.trawe.operation.base.third.common;

import java.util.List;

import cn.trawe.operation.base.third.common.vo.response.IssueBaseResponse;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

	/**
	 * 校验错误拦截处理
	 *
	 * @param exception 错误信息集合
	 * @return 错误信息
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public IssueBaseResponse<?> validationBodyException(MethodArgumentNotValidException exception) {
		IssueBaseResponse<?> response = new IssueBaseResponse<String>();
		response.setCode(1);

		StringBuilder str = new StringBuilder();
		BindingResult result = exception.getBindingResult();
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			errors.forEach(p -> {
				FieldError fieldError = (FieldError) p;
				str.append(fieldError.getDefaultMessage()).append(";");
//				str.append(fieldError.getDefaultMessage()).append("：").append(fieldError.getRejectedValue()).append(";");
			});
		}
		response.setMsg(str.toString());
//        String message = exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
//		log.info(message);
		return response;
	}

	/**
	 * 参数类型转换错误
	 *
	 * @param exception 错误
	 * @return 错误信息
	 */ 
	@ExceptionHandler(HttpMessageConversionException.class)
	public IssueBaseResponse<?> parameterTypeException(HttpMessageConversionException exception) {
		log.error(exception.getCause().getLocalizedMessage());
		IssueBaseResponse<?> response = new IssueBaseResponse<String>();
		response.setCode(1);
		response.setMsg("参数类型转换异常！");
		return response;

	}
}

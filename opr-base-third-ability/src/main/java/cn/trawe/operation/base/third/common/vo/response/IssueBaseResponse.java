package cn.trawe.operation.base.third.common.vo.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "发行基础响应类")
@Getter
@Setter
public class IssueBaseResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 响应码 0-成功 1-失败
	 */
	@ApiModelProperty(value = "响应码 0-成功 1-失败", required = true)
	public Integer code;

	/**
	 * 响应说明
	 */
	@ApiModelProperty(value = "响应说明", required = true)
	public String msg;

	/**
	 * 响应信息
	 */
	@ApiModelProperty(value = "响应信息", required = true)
	public T data;

}

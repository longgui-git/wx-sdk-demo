package cn.trawe.operation.base.third.common.webservice;

import cn.trawe.operation.base.third.common.webservice.resp.HeadResp;
import lombok.Data;

@Data
public class WServiceResponse<T> {

	private HeadResp headResp;

	private T body;

}

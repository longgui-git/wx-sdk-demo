package cn.trawe.operation.base.third.common.webservice;

import cn.trawe.operation.base.third.common.webservice.req.HeadReq;
import lombok.Data;

@Data
public class WServiceRequest<T> {

	private HeadReq headReq;

	private T body;

}

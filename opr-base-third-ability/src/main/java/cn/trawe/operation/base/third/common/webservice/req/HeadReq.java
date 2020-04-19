package cn.trawe.operation.base.third.common.webservice.req;
import cn.trawe.operation.base.third.common.config.WebServiceConfig;
import org.apache.commons.codec.digest.DigestUtils;
import lombok.Data;

@Data
public class HeadReq {

	private String wechatacct;

	private String moduleid;

	private String keyboat;

	private String appid;

	private String type;

	public HeadReq() {
		super();
	}

	public HeadReq(String wechatacct, String moduleid, String type) {
		super();
		this.wechatacct = wechatacct;
		this.keyboat = DigestUtils.md5Hex(wechatacct + WebServiceConfig.webserviceAppID).toUpperCase();
		this.moduleid = moduleid;
		this.type = type;
		this.appid = WebServiceConfig.webserviceAppID;
	}

}

package cn.trawe.operation.base.third.common.utils;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import cn.trawe.operation.base.third.common.config.WebServiceConfig;
import cn.trawe.operation.base.third.common.webservice.WServiceRequest;
import cn.trawe.operation.base.third.common.webservice.WServiceResponse;
import cn.trawe.operation.base.third.common.webservice.req.*;
import cn.trawe.operation.base.third.common.webservice.resp.*;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import cn.trawe.utils.ValidateUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlUtil {

	public static String vehicleValidateReqXml(WServiceRequest<ValidateVehicleReq> req) {
		Document document = DocumentHelper.createDocument();// 创建Document
		Element root = document.addElement("query");// 添加根节点
		// 在根节点下添加head节点
		Element head = root.addElement("head");
		head.addElement("wechatacct").addText(req.getHeadReq().getWechatacct());
		head.addElement("moduleid").addText(req.getHeadReq().getModuleid());
		head.addElement("keyboat").addText(req.getHeadReq().getKeyboat());
		head.addElement("appid").addText(req.getHeadReq().getAppid());
		head.addElement("type").addText(req.getHeadReq().getType());
		// 在根节点下添加body节点
		Element body = root.addElement("body");
		body.addElement("vehplate").addText(req.getBody().getVehplate());
		body.addElement("vehcolor").addText(req.getBody().getVehcolor());

		return docToXmlStr(document);
	}

	public static String bankNoValidateReqXml(WServiceRequest<ValidateBankNoReq> req) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("query");
		Element head = root.addElement("head");
		head.addElement("wechatacct").addText(req.getHeadReq().getWechatacct());
		head.addElement("moduleid").addText(req.getHeadReq().getModuleid());
		head.addElement("keyboat").addText(req.getHeadReq().getKeyboat());
		head.addElement("appid").addText(req.getHeadReq().getAppid());
		head.addElement("type").addText(req.getHeadReq().getType());
		Element body = root.addElement("body");
		body.addElement("vehplate").addText(req.getBody().getVehplate());
		body.addElement("vehcolor").addText(req.getBody().getVehcolor());
		body.addElement("bankno").addText(req.getBody().getBankno());
		body.addElement("bankcardno").addText(req.getBody().getBankcardno());
		body.addElement("bankcardname").addText(req.getBody().getBankcardname());
		body.addElement("bankmobile").addText(req.getBody().getBankmobile());
		body.addElement("sxsjh").addText(req.getBody().getSxsjh());

		return docToXmlStr(document);
	}

	public static String smsCodeValidateReqXml(WServiceRequest<ValidateSMSCodeReq> req) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("query");
		Element head = root.addElement("head");
		head.addElement("wechatacct").addText(req.getHeadReq().getWechatacct());
		head.addElement("moduleid").addText(req.getHeadReq().getModuleid());
		head.addElement("keyboat").addText(req.getHeadReq().getKeyboat());
		head.addElement("appid").addText(req.getHeadReq().getAppid());
		head.addElement("type").addText(req.getHeadReq().getType());
		Element body = root.addElement("body");
		body.addElement("bankno").addText(req.getBody().getBankno());
		body.addElement("bankcardno").addText(req.getBody().getBankcardno());
		body.addElement("mobilecode").addText(req.getBody().getMobilecode());
		body.addElement("bankserialno").addText(req.getBody().getBankserialno());

		return docToXmlStr(document);
	}

	public static String orderSaveReqXml(WServiceRequest<OrderSaveReq> req) {
		Document document = DocumentHelper.createDocument();// 创建Document
		Element root = document.addElement("query");// 添加根节点
		Element head = root.addElement("head");
		head.addElement("wechatacct").addText(req.getHeadReq().getWechatacct());
		head.addElement("moduleid").addText(req.getHeadReq().getModuleid());
		head.addElement("keyboat").addText(req.getHeadReq().getKeyboat());
		head.addElement("appid").addText(req.getHeadReq().getAppid());
		head.addElement("type").addText(req.getHeadReq().getType());
		Element body = root.addElement("body");
		body.addElement("step_status").addText(replaceNullToString(req.getBody().getStep_status()));
		body.addElement("veh_color").addText(replaceNullToString(req.getBody().getVeh_color()));
		body.addElement("veh_plate").addText(replaceNullToString(req.getBody().getVeh_plate()));
		body.addElement("user_mobile").addText(replaceNullToString(req.getBody().getUser_mobile()));
		body.addElement("ucid").addText(replaceNullToString(req.getBody().getUcid()));
		body.addElement("pay_amt").addText(replaceNullToString(req.getBody().getPay_amt()));
		body.addElement("bank_card_no").addText(replaceNullToString(req.getBody().getBank_card_no()));
		body.addElement("bank_card_name").addText(replaceNullToString(req.getBody().getBank_card_name()));
		body.addElement("vehcustclass").addText(replaceNullToString(req.getBody().getVeh_cust_class()));
		body.addElement("user_id").addText(replaceNullToString(req.getBody().getUser_id()));
		body.addElement("mail_cust_name").addText(replaceNullToString(req.getBody().getMail_cust_name()));
		body.addElement("region").addText(replaceNullToString(req.getBody().getRegion()));
		body.addElement("user_name").addText(replaceNullToString(req.getBody().getUser_name()));
		body.addElement("cert_id").addText(replaceNullToString(req.getBody().getCert_id()));
		body.addElement("bank_no").addText(replaceNullToString(req.getBody().getBank_no()));
		body.addElement("pay_type").addText(replaceNullToString(req.getBody().getPay_type()));
		body.addElement("card_flag").addText(replaceNullToString(req.getBody().getCard_flag()));
		body.addElement("card_type").addText(replaceNullToString(req.getBody().getCard_type()));
		body.addElement("mail_addr").addText(replaceNullToString(req.getBody().getMail_addr()));
		body.addElement("come_type").addText(replaceNullToString(req.getBody().getCome_type()));
		body.addElement("is_add").addText(replaceNullToString(req.getBody().getIs_add()));
		body.addElement("cust_no").addText(replaceNullToString(req.getBody().getCust_no()));
		body.addElement("cert_img_id").addText(replaceNullToString(req.getBody().getCert_img_id()));
		body.addElement("driving_img_id").addText(replaceNullToString(req.getBody().getDriving_img_id()));
		body.addElement("vehicle_img_id").addText(replaceNullToString(req.getBody().getVehicle_img_id()));
		body.addElement("package_no").addText(replaceNullToString(req.getBody().getPackage_no()));
		body.addElement("package_cycle").addText(replaceNullToString(req.getBody().getPackage_cycle()));
		body.addElement("assist_status").addText(replaceNullToString(req.getBody().getAssist_status()));
		body.addElement("user_manager_no").addText(replaceNullToString(req.getBody().getUser_manager_no()));
		body.addElement("veh_engine_standby6").addText(replaceNullToString(req.getBody().getVeh_engine_standby6()));
		body.addElement("verify_key").addText(replaceNullToString(req.getBody().getVerify_key()));

		body.addElement("vehsizel").addText(replaceNullToString(req.getBody().getVehsizel()));
		body.addElement("axisnum").addText(replaceNullToString(req.getBody().getAxisnum()));
		body.addElement("tonseat").addText(replaceNullToString(req.getBody().getTonseat()));
		body.addElement("vehengine").addText(replaceNullToString(req.getBody().getVehengine()));
		body.addElement("totalmass").addText(replaceNullToString(req.getBody().getTotalmass()));
		body.addElement("vehicletype").addText(replaceNullToString(req.getBody().getVehicletype()));

		return docToXmlStr(document);
	}

	public static String progressQueryReqXml(WServiceRequest<ProgressQueryReq> req) {
		Document document = DocumentHelper.createDocument();// 创建Document
		Element root = document.addElement("query");// 添加根节点
		Element head = root.addElement("head");
		head.addElement("wechatacct").addText(req.getHeadReq().getWechatacct());
		head.addElement("moduleid").addText(req.getHeadReq().getModuleid());
		head.addElement("keyboat").addText(req.getHeadReq().getKeyboat());
		head.addElement("appid").addText(req.getHeadReq().getAppid());
		head.addElement("type").addText(req.getHeadReq().getType());
		Element body = root.addElement("body");
		body.addElement("user_id").addText(replaceNullToString(req.getBody().getUser_id()));
		body.addElement("veh_plate").addText(req.getBody().getVeh_plate());
		body.addElement("veh_color").addText(req.getBody().getVeh_color());

		return docToXmlStr(document);
	}

	public static String imageUploadReqXml(WServiceRequest<ImageUploadReq> req) {
		Document document = DocumentHelper.createDocument();// 创建Document
		Element root = document.addElement("query");// 添加根节点
		Element head = root.addElement("head");
		head.addElement("wechatacct").addText(req.getHeadReq().getWechatacct());
		head.addElement("moduleid").addText(req.getHeadReq().getModuleid());
		head.addElement("keyboat").addText(req.getHeadReq().getKeyboat());
		head.addElement("appid").addText(req.getHeadReq().getAppid());
		head.addElement("type").addText(req.getHeadReq().getType());
		Element body = root.addElement("body");
		body.addElement("ucid").addText(req.getBody().getUcid());
		body.addElement("step_status").addText(replaceNullToString(req.getBody().getStep_status()));
		body.addElement("cert_img_id").addText(replaceNullToString(req.getBody().getCert_img_id()));
		body.addElement("driving_img_id").addText(replaceNullToString(req.getBody().getDriving_img_id()));
		body.addElement("vehicle_img_id").addText(replaceNullToString(req.getBody().getVehicle_img_id()));
		body.addElement("veh_engine_standby6").addText(replaceNullToString(req.getBody().getVeh_engine_standby6()));
		body.addElement("veh_sideways_id").addText(replaceNullToString(req.getBody().getVeh_sideways_id()));
		body.addElement("veh_registration_id").addText(replaceNullToString(req.getBody().getVeh_registration_id()));
		body.addElement("veh_head_id").addText(replaceNullToString(req.getBody().getVeh_head_id()));
		body.addElement("road_transport_id").addText(replaceNullToString(req.getBody().getRoad_transport_id()));

		return docToXmlStr(document);
	}

	public static String docToXmlStr(Document document) {
		StringWriter sw = null;
		try {
			sw = new StringWriter();
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("GBK");
			format.setNewlines(false);
			format.setNewLineAfterDeclaration(false);
			format.setIndent(false);
			XMLWriter xmlWriter = new XMLWriter(sw, format);
			xmlWriter.write(document);
			return sw.toString();
		} catch (Exception e) {
			log.error("DOC转XML报文异常：{}", e.getMessage());
		} finally {
			try {
				if (null != sw)
					sw.close();
			} catch (Exception e) {
				log.error("关闭StringWriter异常：{}", e.getMessage());
			}
		}
		return "";
	}

	/**
	 * 解析响应xml报文 (通用)
	 * 
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static WServiceResponse parseRespXml(String xml) {
		WServiceResponse rsp = new WServiceResponse();
		try {
			Document doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element root = doc.getRootElement(); // 获取根节点
			HeadResp headResp = new HeadResp();
			headResp.setRescode(root.attributeValue("rescode"));
			headResp.setResmsg(root.attributeValue("resmsg"));
			rsp.setHeadResp(headResp);
			return rsp;
		} catch (Exception e) {
			log.error("解析通用响应xml报文异常：{}", e.getMessage());
		}
		return null;
	}

	/**
	 * 解析【校验车辆】响应xml报文
	 * 
	 * @param xml
	 * @return
	 */
	public static WServiceResponse<ValidateVehicleResp> parseTruckValidateRespXml(String xml) {
		WServiceResponse<ValidateVehicleResp> rsp = new WServiceResponse<ValidateVehicleResp>();
		try {
			Document doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element root = doc.getRootElement(); // 获取根节点
			HeadResp headResp = new HeadResp();
			headResp.setRescode(root.attributeValue("rescode"));
			headResp.setResmsg(root.attributeValue("resmsg"));
			rsp.setHeadResp(headResp);
			if (WebServiceConfig.respSuccessCode.equals(headResp.getRescode())) {
				Element row = root.element("row");
				if (row == null) {
					return rsp;
				}
				ValidateVehicleResp result = new ValidateVehicleResp();
				result.setUcid(row.elementText("ucid"));
				result.setWhetherData(row.elementText("whether_data"));
				result.setVerifyKey(row.elementText("verify_key"));
				result.setCardName(row.elementText("cardname"));
				result.setOwnerIdNum(row.elementText("owneridnum"));
				result.setAddress(row.elementText("address"));
				result.setVehSizeL(vehSize(row.elementText("vehsizel")));
				result.setVehSizeW(vehSize(row.elementText("vehsizew")));
				result.setVehSizeH(vehSize(row.elementText("vehsizeh")));
				result.setOverallDimension(
						result.getVehSizeL() + "*" + result.getVehSizeW() + "*" + result.getVehSizeH());
				result.setAxisNum(row.elementText("axisnum"));
				result.setRegisterDate(row.elementText("zcsj"));
				result.setVin(row.elementText("vehengine"));
				result.setVehicleType(row.elementText("vehicletype"));
				result.setEngineNo(row.elementText("enginenum"));
				result.setIssueDate(row.elementText("issuedate"));
				result.setApprovedCount(row.elementText("approvedcount"));
				result.setApprovedLoad(row.elementText("permittedweight"));
				result.setSeats(row.elementText("tonseat"));
				result.setGrossMass(row.elementText("totalmass"));
				result.setModel(row.elementText("vehmark"));

				rsp.setBody(result);
			}
			return rsp;
		} catch (Exception e) {
			log.error("【车牌发行信息校验】解析响应xml报文异常：{}", e.getMessage());
		}
		return null;
	}

	/**
	 * 解析【验证银行卡号】响应xml报文
	 * 
	 * @param xml
	 * @return
	 */
	public static WServiceResponse<ValidateBankNoResp> parseBankNoValidateRespXml(String xml) {
		WServiceResponse<ValidateBankNoResp> rsp = new WServiceResponse<ValidateBankNoResp>();
		try {
			Document doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element root = doc.getRootElement(); // 获取根节点
			HeadResp headResp = new HeadResp();
			headResp.setRescode(root.attributeValue("rescode"));
			headResp.setResmsg(root.attributeValue("resmsg"));
			rsp.setHeadResp(headResp);
			if (WebServiceConfig.respSuccessCode.equals(headResp.getRescode())) {
				Element row = root.element("row");
				if (row == null) {
					return rsp;
				}
				ValidateBankNoResp result = new ValidateBankNoResp();
				result.setIsadd(row.elementText("is_add"));
				result.setCardphone(row.elementText("cardphone"));
				result.setBankSerialNo(row.elementText("bankserialno"));
				rsp.setBody(result);
			}
			return rsp;
		} catch (Exception e) {
			log.error("【验证银行卡号并银行发送短信验证码】解析响应xml报文异常：{}", e.getMessage());
		}
		return null;
	}

	/**
	 * 解析【录入信息保存】响应xml报文
	 * 
	 * @param xml
	 * @return
	 */
	public static WServiceResponse<OrderSaveResp> parseOrderSaveRespXml(String xml) {
		WServiceResponse<OrderSaveResp> rsp = new WServiceResponse<OrderSaveResp>();
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element root = doc.getRootElement();
			HeadResp headResp = new HeadResp();
			headResp.setRescode(root.attributeValue("rescode"));
			headResp.setResmsg(root.attributeValue("resmsg"));
			rsp.setHeadResp(headResp);
			if (WebServiceConfig.respSuccessCode.equals(headResp.getRescode())) {
				Element row = root.element("row");
				if (row == null) {
					return rsp;
				}
				OrderSaveResp result = new OrderSaveResp();
				result.setBankshopno(row.elementText("bankshopno"));
				result.setOrderno(row.elementText("orderno"));
				result.setUcid(row.elementText("ucid"));
				rsp.setBody(result);
			}
			return rsp;
		} catch (Exception e) {
			log.error("【货车客户录入信息保存】解析响应xml报文异常：{}", e.getMessage());
		}
		return null;
	}

	/**
	 * 解析【申请实时状态】响应xml报文
	 * 
	 * @param xml
	 * @return
	 */
	public static WServiceResponse<List<ProgressQueryResp>> parseProgressQueryRespXml(String xml) {
		WServiceResponse<List<ProgressQueryResp>> rsp = new WServiceResponse<List<ProgressQueryResp>>();
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element root = doc.getRootElement();
			HeadResp headResp = new HeadResp();
			headResp.setRescode(root.attributeValue("rescode"));
			headResp.setResmsg(root.attributeValue("resmsg"));
			rsp.setHeadResp(headResp);
			if (WebServiceConfig.respSuccessCode.equals(headResp.getRescode())) {
				List<ProgressQueryResp> list = new ArrayList<ProgressQueryResp>();
				@SuppressWarnings("unchecked")
				List<Element> rowList = root.elements("row");
				for (Element row : rowList) {
					ProgressQueryResp progress = new ProgressQueryResp();
					progress.setUcid(row.elementText("ucid"));
					progress.setStepStatus(row.elementText("step_status"));
					progress.setStatusText(row.elementText("status_text"));
					progress.setVehPlate(row.elementText("veh_plate"));
					progress.setVehColor(row.elementText("veh_color"));
					progress.setBankCardNo(row.elementText("bank_card_no"));
					progress.setExpress(row.elementText("express"));
					progress.setExpressNo(row.elementText("express_no"));
					progress.setAppErr(row.elementText("app_err"));
					list.add(progress);
				}
				rsp.setBody(list);
			}
			return rsp;
		} catch (Exception e) {
			log.error("【办理进度查询】解析响应xml报文异常：{}", e.getMessage());
		}
		return null;
	}

	public static String replaceNullToString(String str) {
		return str == null ? "" : str.trim();
	}

	public static String vehSize(String str) {
		return ValidateUtil.isEmpty(str) ? "0" : str.trim();
	}

}

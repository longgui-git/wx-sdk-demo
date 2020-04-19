package cn.trawe.operation.base.third;

import java.io.IOException;
import java.util.Base64;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

//import cn.trawe.wechat.chongqing.common.constants.ImageTypeEnum;
//import cn.trawe.wechat.chongqing.common.db.entity.EtcIssusOrder;
//import cn.trawe.wechat.chongqing.common.db.mapper.EtcIssueOrderMapper;
//import cn.trawe.wechat.chongqing.common.utils.FileUtil;
//import cn.trawe.wechat.chongqing.common.vo.response.IssueBaseResponse;
//import cn.trawe.wechat.chongqing.common.webservice.req.ValidateVehicleReq;
//import cn.trawe.wechat.chongqing.service.EtcIssueService;
//import cn.trawe.wechat.chongqing.service.InterfaceService;
//import cn.trawe.wechat.chongqing.service.SmsSendService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTests {

//	@Autowired
//	EtcIssueService issueService;
//
//	@Autowired
//	private EtcIssueOrderMapper orderMapper;
//
//	@Autowired
//	private SmsSendService smsService;
//
//	@Autowired
//	private InterfaceService interfaceService;
//
////	@Test
//	public void order() {
//		System.out.println("===============================");
//		EtcIssusOrder order = orderMapper.selectById(12);
//		System.out.println("order:" + order);
//	}
//
////	@Test
//	public void vheicleVal() {
//		System.out.println("===============================");
//		ValidateVehicleReq reqObject = new ValidateVehicleReq();
//		reqObject.setVehplate("京AXT837");
//		reqObject.setVehcolor(String.valueOf(0));
//		IssueBaseResponse<?> valVehicle = interfaceService.valVehicle(reqObject, 2);
//		System.out.println(JSON.toJSONString(valVehicle));
//	}
//
////	@Test
//	public void upload() throws IOException {
//		System.out.println("===============================");
//		String fileToBase64 = FileUtil.fileToBase64("E:\\data\\test\\123456.jpg");
////		System.out.println(fileToBase64);
////		System.out.println(fileToBase64.length());
////		FileUtil.base64ToFile(fileToBase64, "E:\\data\\test\\good3.png");
//		byte[] decode = Base64.getDecoder().decode(fileToBase64);
//		System.out.println("decode：" + decode.length);
//
//		int sqrt = (int) Math.sqrt(decode.length);
//		System.out.println("sqrt："+ sqrt);
//
//		byte[] compressImage = FileUtil.compressImage(decode, 1000);
//		System.out.println("compressImage：" + compressImage.length);
//
//		String resourcesid = interfaceService.uploadVehicleOwnerImage(ImageTypeEnum.IDCARD_FRONT, "wx00002", fileToBase64);
//		System.out.println(ImageTypeEnum.IDCARD_FRONT.getDesc() + ":" + resourcesid);
////		String resourcesid2 = interfaceService.uploadVehicleOwnerImage(ImageTypeEnum.VEHICLE_FRONT, "TR1234", decode);
////		System.out.println(ImageTypeEnum.VEHICLE_FRONT.getDesc() + ":" + resourcesid2);
////		String resourcesid3 = interfaceService.uploadVehicleOwnerImage(ImageTypeEnum.VEHICLE_SIDEWAYS, "TR1234", decode);
////		System.out.println(ImageTypeEnum.VEHICLE_SIDEWAYS.getDesc() + ":" + resourcesid3);
////		String resourcesid4 = interfaceService.uploadVehicleOwnerImage(ImageTypeEnum.VEHICLE_REGISTRATION, "TR1234", decode);
////		System.out.println(ImageTypeEnum.ROAD_TRANSPORT.getDesc() + ":" + resourcesid4);
////		String resourcesid5 = interfaceService.uploadVehicleOwnerImage(ImageTypeEnum.ROAD_TRANSPORT, "TR1234", decode);
////		System.out.println(ImageTypeEnum.ROAD_TRANSPORT.getDesc() + ":" + resourcesid5);
////		String resourcesid6 = interfaceService.uploadVehicleOwnerImage(ImageTypeEnum.VEHICLE_HEAD, "TR1234", decode);
////		System.out.println(ImageTypeEnum.VEHICLE_HEAD.getDesc() + ":" + resourcesid6);
//
//	}
//
//	@Test
//	public void upload2() throws IOException {
//		System.out.println("===============================");
//		String fileToBase64 = FileUtil.fileToBase64("E:\\data\\test\\good.jpg");
//		String fileToBase642 = FileUtil.fileToBase64("E:\\data\\test\\good.jpg");
//
//		byte[] decode1 = Base64.getDecoder().decode(fileToBase64);
//		System.out.println("decode1：" + decode1.length);
//		byte[] decode2 = Base64.getDecoder().decode(fileToBase642);
//		System.out.println("decode2：" + decode2.length);
//
//		System.out.println(decode1.length);
//		System.out.println(decode2.length);
//		String resourcesid = interfaceService.uploadDrivingImage(ImageTypeEnum.DRIVING_LICENSE, "TR6044", fileToBase64,
//				fileToBase642);
//		System.out.println(resourcesid);
//	}
//
////	@Test
//	public void sms() throws Exception {
//		smsService.send("13161997647");
//	}

}

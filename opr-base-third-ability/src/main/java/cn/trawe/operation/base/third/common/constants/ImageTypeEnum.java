package cn.trawe.operation.base.third.common.constants;

import lombok.Getter;

@Getter
public enum ImageTypeEnum {

	IDCARD_FRONT(1, "UploadUserImg", "markflag", "身份证正面"),

	DRIVING_LICENSE(2, "UploadTravelImg", "veh_plate", "行驶证"),

	VEHICLE_FRONT(3, "UploadCarImg", "veh_plate", "车辆前45度图片"),

	VEHICLE_SIDEWAYS(4, "UploadSidewaysImg", "veh_plate", "车辆侧身照"),

	VEHICLE_REGISTRATION(5, "UploadRegistrationImg", "veh_plate", "车辆登记证书"),

	ROAD_TRANSPORT(6, "UploadTransportImg", "veh_plate", "道路运输证"),

	VEHICLE_HEAD(7, "UploadHeadImg", "veh_plate", "车头照");

	private int type;

	private String path;

	private String key;

	private String desc;

	ImageTypeEnum(int type, String path, String key, String desc) {
		this.type = type;
		this.path = path;
		this.key = key;
		this.desc = desc;
	}

}

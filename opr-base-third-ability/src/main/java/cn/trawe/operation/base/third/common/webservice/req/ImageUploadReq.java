package cn.trawe.operation.base.third.common.webservice.req;

import lombok.Data;

@Data
public class ImageUploadReq {
	
	private String ucid;

	private String step_status;
	
	private String cert_img_id;
	
	private String driving_img_id;
	
	private String vehicle_img_id;
	
	private String veh_engine_standby6;
	
	private String veh_sideways_id;
	
	private String veh_registration_id;
	
	private String veh_head_id;
	
	private String road_transport_id;
	
}

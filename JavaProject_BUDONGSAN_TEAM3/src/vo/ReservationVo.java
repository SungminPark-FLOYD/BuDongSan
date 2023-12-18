package vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReservationVo {

		 private int reserv_no;
		 private String mem_no;
		 private String mem_nick;
		 private String mem_id;
		 private String addr;
		 private String pro_no;
		 private String pro_price;
		 private String agent_name;
		 private Date reserv_date;
		 private String agent_phone;
		 private String del_yn;
		 private String agent_no;
	
}

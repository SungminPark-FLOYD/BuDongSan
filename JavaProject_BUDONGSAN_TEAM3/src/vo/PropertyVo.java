package vo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PropertyVo {
	private String pro_no;
	private String pro_tp_name;
	private String sale_name;
	private String addr;
	private BigDecimal pro_size;
	private String pro_tag;
	private String pro_price;
	private String pro_content;
	private String agent_no;
}

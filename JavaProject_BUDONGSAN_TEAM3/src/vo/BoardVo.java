package vo;

import lombok.Data;

@Data
public class BoardVo {
	 private int board_no;
	 private String manager_no;
	 private String manager_nick;
	 private String board_title;
	 private String board_content;
	 private String board_date;
	 private int board_count;
	 private String del_yn;
}

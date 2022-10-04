package main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainDTO {
	
	private Long id;
	private String title;
	private String manager_eamil;
	private String company_name;
	private String company_registration_number;
	private String director_name;
	private String main_number;
	private String telemarketing_report_number;
	private String supplementary_number;
	private String business_zip_code;
	private String business_address;
	private String info_manager_name;
	private String info_manager_email;
	private String membership_reserves;
	private String membership_level;
	private String create_datetime;

}

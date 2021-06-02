package kr.happyjob.study.dashboard.model;




public class ProductCategoryDTO {

	private String detail_code;
	private String detail_name;
	
	public ProductCategoryDTO(ProductCategoryVO vo) {
		this.detail_code = vo.getDetail_code();
		this.detail_name = vo.getDetail_name();
		
	}

	public String getDetail_code() {
		return detail_code;
	}

	public void setDetail_code(String detail_code) {
		this.detail_code = detail_code;
	}

	public String getDetail_name() {
		return detail_name;
	}

	public void setDetail_name(String detail_name) {
		this.detail_name = detail_name;
	}
}

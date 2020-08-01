package liability.domain;

public class Liability {

	private String liability_name;
	private String user_id;
	private String value;
	public String getLiability_name() {
		return liability_name;
	}
	public void setLiability_name(String liability_name) {
		this.liability_name = liability_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Liability [liability_name=" + liability_name + ", user_id=" + user_id + ", value=" + value + "]";
	}
	
	
}

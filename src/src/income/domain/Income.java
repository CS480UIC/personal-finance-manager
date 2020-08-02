package income.domain;

public class Income {
	/*
	 * Corresponds to the income table
	 */
	
	private String income_id;
	private String user_id;
	private String username; 
	private String in_date;
	private String description;
	private String amount;
	private String tags;
	
	public String getIncome_id() {
		return income_id;
	}
	public void setIncome_id(String income_id) {
		this.income_id = income_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIn_date() {
		return in_date;
	}
	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		return "Income [income_id=" + income_id + ", user_id=" + user_id + ", in_date=" + in_date + ", description="
				+ description + ", amount=" + amount + ", tags=" + tags + "]";
	}
	
	

}

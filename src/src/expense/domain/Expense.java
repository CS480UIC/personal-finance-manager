package expense.domain;

public class Expense {
	private String expense_id;
	private String user_id;
	private String month;
	private String description;
	private String amount;
	private String tags;
	public String getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(String expense_id) {
		this.expense_id = expense_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
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
		return "Expense [expense_id=" + expense_id + ", user_id=" + user_id + ", ex_date=" + month + ", description="
				+ description + ", amount=" + amount + ", tags=" + tags + "]";
	}
	
	

}

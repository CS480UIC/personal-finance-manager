package balancesheet.domain;

public class LossMonths {
	private String curr_month;
	private String curr_balance;
	private String prev_month;
	private String prev_balance;
	private String decrease;
	public String getCurr_month() {
		return curr_month;
	}
	public void setCurr_month(String curr_month) {
		this.curr_month = curr_month;
	}
	public String getCurr_balance() {
		return curr_balance;
	}
	public void setCurr_balance(String curr_balance) {
		this.curr_balance = curr_balance;
	}
	public String getPrev_month() {
		return prev_month;
	}
	public void setPrev_month(String prev_month) {
		this.prev_month = prev_month;
	}
	public String getPrev_balance() {
		return prev_balance;
	}
	public void setPrev_balance(String prev_balance) {
		this.prev_balance = prev_balance;
	}
	public String getDecrease() {
		return decrease;
	}
	public void setDecrease(String decrease) {
		this.decrease = decrease;
	}
	
	@Override
	public String toString() {
		return "LossMonths [curr_month=" + curr_month + ", curr_balance=" + curr_balance + ", prev_month=" + prev_month
				+ ", prev_balance=" + prev_balance + ", decrease=" + decrease + "]";
	}
	
	

}

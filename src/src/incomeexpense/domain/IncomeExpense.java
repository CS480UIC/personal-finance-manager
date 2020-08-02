package incomeexpense.domain;

public class IncomeExpense {
	private String in_amt;
	private String ex_amt;
	private String diff;
	private String month;
	public String getIn_amt() {
		return in_amt;
	}
	public void setIn_amt(String in_amt) {
		this.in_amt = in_amt;
	}
	public String getEx_amt() {
		return ex_amt;
	}
	public void setEx_amt(String ex_amt) {
		this.ex_amt = ex_amt;
	}
	public String getDiff() {
		return diff;
	}
	public void setDiff(String diff) {
		this.diff = diff;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	@Override
	public String toString() {
		return "IncomeExpense [in_amt=" + in_amt + ", ex_amt=" + ex_amt + ", diff=" + diff + ", month=" + month + "]";
	}
	
	
	

}

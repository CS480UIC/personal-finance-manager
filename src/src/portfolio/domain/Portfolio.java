package portfolio.domain;

public class Portfolio {
	
	private String user_id;
	private String symbol;
	private String quantity;
	private String buy_price;
	private String investment;
	private String current_price;
	private String equity;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(String buy_price) {
		this.buy_price = buy_price;
	}
	public String getInvestment() {
		return investment;
	}
	public void setInvestment(String investment) {
		this.investment = investment;
	}
	public String getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(String current_price) {
		this.current_price = current_price;
	}
	public String getEquity() {
		return equity;
	}
	public void setEquity(String equity) {
		this.equity = equity;
	}
	
	@Override
	public String toString() {
		return "Portfolio [user_id=" + user_id + ", symbol=" + symbol + ", quantity=" + quantity + ", buy_price="
				+ buy_price + ", investment=" + investment + ", current_price=" + current_price + ", equity=" + equity
				+ "]";
	}
	
	
	
}

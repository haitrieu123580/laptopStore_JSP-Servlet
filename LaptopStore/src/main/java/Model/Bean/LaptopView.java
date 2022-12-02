package Model.Bean;

public class LaptopView {
	private String lapId;
	private String lapName;
	private String companyName;
	private String cardName;
	private int price; 
	private int amount;
	public String getLapName() {
		return lapName;
	}
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getLapId() {
		return lapId;
	}
	public void setLapId(String lapId) {
		this.lapId = lapId;
	}
	
}

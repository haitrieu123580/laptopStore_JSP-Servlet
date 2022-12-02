package Model.Bean;

public class LaptopBean {
	private String lapID;
	private String lapName;
	private String companyId;
	private String cardId;
	private int price;
	private int amount;
	public String getLapID() {
		return lapID;
	}
	public void setLapID(String lapID) {
		this.lapID = lapID;
	}
	public String getLapName() {
		return lapName;
	}
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
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
}


public class Customer {
    private String customerNo="";
    private String salutation="";
    private String firstName="";
    private String lastName="";
    private String email="";
	private String address1="";
	private String address2="";
	private String postbox="";
	private String zip="";
	private String city="";
	private String country="";
	private String birthday="";
	private String phone ="";
	private String phoneMobile="";
	private String customerCardNo="";
	private String creationDate="";
	private String checkDateTime="";
	private String checkResult="";
	private String lastOrderTime="";
     
    public String getCustomerNo() {
		return customerNo;
	}


	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}


	public String getSalutation() {
		return salutation;
	}


	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getPostbox() {
		return postbox;
	}


	public void setPostbox(String postbox) {
		this.postbox = postbox;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPhoneMobile() {
		return phoneMobile;
	}


	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}


	public String getCustomerCardNo() {
		return customerCardNo;
	}


	public void setCustomerCardNo(String customerCardNo) {
		this.customerCardNo = customerCardNo;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public String getCheckDateTime() {
		return checkDateTime;
	}


	public void setCheckDateTime(String checkDateTime) {
		this.checkDateTime = checkDateTime;
	}


	public String getCheckResult() {
		return checkResult;
	}


	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}


	public String getLastOrderTime() {
		return lastOrderTime;
	}


	public void setLastOrderTime(String lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}


	@Override
    public String toString() {
        return this.customerNo +","+ this.lastName+","+this.firstName + "," + this.salutation +"," + this.email+ "," +this.address1+ "," +this.address2+ "," +this.postbox+","+this.zip+","+this.city+","+this.country+ "," +this.birthday+ "," + this.phone+ "," +this.phoneMobile+ "," +this.customerCardNo+ "," +this.creationDate+ "," +this.checkDateTime+ "," +this.checkResult+ "," +this.lastOrderTime ;
    }
     
}
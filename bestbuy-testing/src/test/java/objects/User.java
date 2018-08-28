package objects;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	@JsonProperty("testAccount")
	private boolean testAccount;
	@JsonProperty("salutation")
	private String salutation;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("mobilePhoneNumber")
	private String mobilePhoneNumber;
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	@JsonProperty("externalId")
	private String externalId;
	@JsonProperty("email")
	private String email;
	@JsonProperty("address")
	private Address address;
	@JsonProperty("consumerProducts")
	private List<Product> consumerProducts;

	public void setTestAccount(boolean testAccount) {
		this.testAccount = testAccount;
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

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Product> getConsumerProducts() {
		return consumerProducts;
	}

	public void setConsumerProducts(List<Product> consumerProducts) {
		this.consumerProducts = consumerProducts;
	}

	public static User createMobilcomUserHotline() {
		Address userAddress = new Address();
		Address deliveryAddress = new Address();

		userAddress.setCountry("DE");
		userAddress.setZip("10117");
		userAddress.setCity("Berlin");
		userAddress.setStreet("Mohrenstr.");
		userAddress.setHouseNumber("34");
		userAddress.setAdditionalAddress("test");

		deliveryAddress.setSalutation("Ms");
		deliveryAddress.setFirstName("Jack");
		deliveryAddress.setName("Johnson");
		deliveryAddress.setCompanyName("Smartfrog");
		deliveryAddress.setPhoneNumber("5894375943");
		deliveryAddress.setMobilePhoneNumber("097436545");
		deliveryAddress.setCountry("DE");
		deliveryAddress.setZip("10117");
		deliveryAddress.setCity("Berlin");
		deliveryAddress.setStreet("Mohrenstr.");
		deliveryAddress.setAdditionalAddress("test");
		deliveryAddress.setHouseNumber("34");

		List<Product> userProducts = new ArrayList<Product>();
		Product product = new Product();
		userProducts.add(product);
		product.setExternalContractId(String.valueOf(System.currentTimeMillis()));
		product.setProductName("LeasePackage_mobilcom");
		product.setFulfillment(true);
		product.setMacAddress(null);
		product.setDeliverAddress(deliveryAddress);

		User mobilcomUser = new User();
		mobilcomUser.setTestAccount(true);
		mobilcomUser.setSalutation("Mr");
		mobilcomUser.setFirstName("Inessa");
		mobilcomUser.setLastName("Last Name");
		mobilcomUser.setMobilePhoneNumber("017634567");
		mobilcomUser.setPhoneNumber("677899");
		mobilcomUser.setExternalId(String.valueOf(System.currentTimeMillis()));
		//mobilcomUser.setEmail("test.user+" + System.currentTimeMillis() + "@smartfrog.com");
		
		mobilcomUser.setEmail("test.user+" + System.currentTimeMillis() + "@yopmail.com");

		mobilcomUser.setAddress(userAddress);
		mobilcomUser.setConsumerProducts(userProducts);
		return mobilcomUser;
	}

	public static User createMobilcomUserRetail(String cameraMacAddress) {
		Address userAddress = new Address();
		Address deliveryAddress = new Address();

		userAddress.setCountry("DE");
		userAddress.setZip("10117");
		userAddress.setCity("Berlin");
		userAddress.setStreet("Mohrenstr.");
		userAddress.setHouseNumber("34");
		userAddress.setAdditionalAddress("test");

		deliveryAddress.setSalutation("Ms");
		deliveryAddress.setFirstName("Inessa");
		deliveryAddress.setName("Johnson");
		deliveryAddress.setCompanyName("Smartfrog");
		deliveryAddress.setPhoneNumber("5894375943");
		deliveryAddress.setMobilePhoneNumber("097436545");
		deliveryAddress.setCountry("DE");
		deliveryAddress.setZip("10117");
		deliveryAddress.setCity("Berlin");
		deliveryAddress.setStreet("Mohrenstr.");
		deliveryAddress.setAdditionalAddress("test");
		deliveryAddress.setHouseNumber("34");

		List<Product> userProducts = new ArrayList<Product>();
		Product product = new Product();
		userProducts.add(product);
		product.setExternalContractId(String.valueOf(System.currentTimeMillis()));
		product.setProductName("LeasePackage_test_product");
		product.setFulfillment(false);
		product.setMacAddress(cameraMacAddress);
		product.setDeliverAddress(deliveryAddress);

		User mobilcomUser = new User();
		mobilcomUser.setTestAccount(true);
		mobilcomUser.setSalutation("Mr");
		mobilcomUser.setFirstName("Test");
		mobilcomUser.setLastName("User");
		mobilcomUser.setMobilePhoneNumber("017634567");
		mobilcomUser.setPhoneNumber("677899");
		mobilcomUser.setExternalId(String.valueOf(System.currentTimeMillis()));
		mobilcomUser.setEmail("test.inessa+" + System.currentTimeMillis() + "@yopmail.com");
		mobilcomUser.setAddress(userAddress);
		mobilcomUser.setConsumerProducts(userProducts);
		return mobilcomUser;
	}
}

package data;
public class Company {

		private String companyName;
		private Address companyAddress;
		
		
		public Company(){
			companyAddress = new Address();
		}
		
		public String getName() {
			return companyName;
		}
		
		public void setName(String name) {
			this.companyName = name;
		}
		
		
		public Address getCompanyAddress(){
			
			return companyAddress;
		}
		
		public void setCompanyAdressCountry(String companyCountry) {
			this.getCompanyAddress().setCountry(companyCountry);
		}
		public void setCompanyAdressCity(String companyCity ) {
			this.getCompanyAddress().setCity(companyCity);
		}
		public void setCompanyAdressStreet(String companyStreet) {
			this.getCompanyAddress().setStreet(companyStreet);
		}
		public void setCompanyAdressNumber(String companyNumber) {
			this.getCompanyAddress().setStreetNumber(Integer.parseInt(companyNumber));
		}
}

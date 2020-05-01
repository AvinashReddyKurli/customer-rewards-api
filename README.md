# customer-rewards
customer rewards API using Spring Boot

To run the application follow the below details:
1. Right click one the CustomerRewardsApplication.java and Run As -> Java Application
2. Once spring boot app is up and running go to the Postman tool
3. Use the URL: http://localhost:8080/customerrewardscalculator/customers/rewards
4. Select the HTTP type: GET
5. Click on the Authorization tab and provide the 
	Username: admin
	password: password
6. Click on the Send button to run rest call
7. If user provide invalid username/password then service will return the 401-unauthorized error
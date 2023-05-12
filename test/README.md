# Code-challenge
This codechallenge is made of a simple API that fulfills certain requirements.
* **For using via postman or other request sorftware its required to setup basicAuth since
i used spring security, the configured user for the mock is user: admin, pass: admin.
i left the whole postman collection i used exported on the project root.**

![image](https://user-images.githubusercontent.com/131601026/233862806-474fc973-e927-479e-85f6-493b4d0e285b.png)

## How to run
````
mvn spring-boot:run
````
## How to TEST
````
mvn test
````

## API DOCS
Theres an accesible api made with openapi3 swagger, check the url with the server open: http://localhost:8080/swagger-ui/index.html#/
![image](https://user-images.githubusercontent.com/131601026/233854742-f79aa7bf-a8a3-4c84-a968-3b7512c6b125.png)
 
 # Data Management
 I choosed to use a H2 inmemory database to keep the software independent of any external services.
 
 Since the input data DTOS dont have to match with the db fields (in this case it is), i created
 constants both for input fields and for jpa columns.
 
   ## TransactionEntity
 
 # Mapping
 The dtos can be mapped to JPA objects and those can be mapped back to Dtos to allow easy and clean
 testing and coding witouth the need of using jsonObjects and such all the time.
 
 # Testing
 Theres one test per functionality and requirement of the project with some extra detailing possible
 errors, like pk duplicated on the entity and such.
 
 The test where made with MockMvc and SpringTest Junit classes, the test data is loaded from sql file fixtures
 created beforehand.

 ## TransactionController
 ### Methods
  #### getStatus
  This endpoint, based on the payload and some business rules, will return the status and additional information for a specific transaction.
  
  * Since this method return fields vary i choose to output a jsonObject
	 this way unlike with dtos that unused fields would appear but empty they just dont
	 get added.
  * Both reference and channel are mandatory.
  #### create
  This endpoint, based on the payload and some business rules, will return the status and additional information for a specific transaction.
  
  * Since this method return fields vary i choose to output a jsonObject.
	 this way unlike with dtos that unused fields would appear but empty they just dont
	 get added.
  * The amount cannot be less than 0.
  * The id Reference is optional and is calculated if not passed.
  * The reference field is a 6 digit string and since its a pk that needs to be calculated i choose to make it a Hex16 String Identifier, for this i use the **ReferenceGenerator class**.
  * iban field is mandatory.
  * amount field is mandatory.

  #### search
  This endpoint searches for transactions.
  * It can return a list since the iban is not primary.
  * If you search a unexisting transaction it returns 409 Conflict.
  * iban is mandatory.
 ## TransactionService
 Here are all the methods called by the controller and it handles the repository for updates, searches and such.
 
 ### save
 First Maps the TransactionDTO object from the request to a TransactionEntity, then proceeds to create (save) that entity if it checks it doesnt exist already (pk)
 and if it does returns 409 response.
 
 ### getStatus
 This endpoint, based on the payload and some business rules, will return the status and additional information for a specific transaction.
 * Channel must be CLIENT, ATM or INTERNAL
 * Channel is mandatory
 * Reference is mandatory
  
 ## TransactionMapper
 Maps Dtos towards the entity JPA objects and from those towards the Dtos.
 
 ## ReferenceGenerator
 Class used to generate the reference field if it doesnt exist or pads the reference with ceros until its a 6 length string.
 
 ## ValueOfEnum
 Custom annotation created to only allow certain values when passing certain parameters from the requests while creating the dtos.
 
 # JAVADOC
 Javadoc added for the TransactionEntity class, can be checked in de doc folder, opening the index.html file.
 ![image](https://user-images.githubusercontent.com/131601026/233855634-abc15116-79bb-47c6-b9a3-4cf0c98d33a7.png)


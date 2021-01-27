Architectural selection:
```````````````````````
Spring Boot with Spring REST is selected for API development. The reasons are:
1. Spring provides rich features for REST Mapping methods implementation for the API
2. Provides supports to H2 database
3. Spring JPA can be integrated easily to persist data to the database
4. Spring boot provides an inbuild TomCat container
5. Provision for Integration with Spring Security for authorization

Functionalities done:
````````````````````
1. create using JSON input
2. update using Id and JSON input
3. delete using Id
4. retrieve using Id, count, name, ingrediant (one ingrediant), instruction (one instruction), ingrediants (comma separated ingrediants), instructions (comma separated instructions)
5. Secured using authorization process

Required functionalities not done:
`````````````````````````````````
Retrive using createdDate and Junit

Build the project:
`````````````````
1. import the maven project to an IDE
2. perform: mvn clean install
3. run the jar file created in the target folder using command "java -jar recipes-0.0.1-SNAPSHOT.jar" (or) in IDE run as SpringBoot application. {Junit is disabled in pom.xml}

Prerequisite: the application should be started and running

H2 database console details:
```````````````````````````
URL: http://localhost:8080/h2-console
it will be redirected to url: http://localhost:8080/h2-console/login.jsp?jsessionid=7f0769028cfb6a89c7f64e438124c96e

Details to be entered:
`````````````````````
JDBC URL: jdbc:h2:file:~/h2database/recipesdb
User Name: sa
Password: password
Click on "Connect" button

The H2 database console is available.

Query: SELECT * FROM RECIPES 
click on "Run", query is executed and results are displayed.

Note: The H2 database "recipesdb" is stored as a file in the location "C:\Users\<user name>\h2database" {for Windows OS system}


Tool used to test API: Postman

Authroization credentials to be given in Postman:
````````````````````````````````````````````````
TYPE: Basic Auth
Username: admin
Password: nimda

EndPoint URIs: 
```````````````
1. create a new recipe: http://localhost:8080/api/assignment/recipes/add  {POST method: Add the recipe to be added in Postman request Body->raw-JSON}
Sample input:
{
    "recipeName": "Veg Pizza - Pan",
    "indicator": "V",
    "ingrediants": "crust, cheese, potato",
    "instructions": "1. Prepare crust; 2. Add toppings; 3. Add cheese; 4. Bake ; 5. Serve",
    "count": 1
}

2. get all the availabe recipe: http://localhost:8080/api/assignment/recipes/getAll

3. update a recipe: http://localhost:8080/api/assignment/recipes/updateById/<Id> {POST method: Add the recipe to be updated in Postman request Body->raw-JSON}
Sample URI: http://localhost:8080/api/assignment/recipes/updateById/2
Sample input:
{
    "recipeName": "Veg Pizza - Pan",
    "indicator": "V",
    "ingrediants": "crust, cheese, tomato",
    "instructions": "1. Prepare crust; 2. Add toppings; 3. Add cheese; 4. Bake ; 5. Serve",
    "count": 1
}

4: delete a recipe: http://localhost:8080/api/assignment/recipes/deleteById/<Id> {DELETE method}
Sample URI: http://localhost:8080/api/assignment/recipes/deleteById/2

5. get a recipe by id: http://localhost:8080/api/assignment/recipes/getById/<Id>
Sample URI: http://localhost:8080/api/assignment/recipes/getById/2

6. get a recipe by number of people: http://localhost:8080/api/assignment/recipes/getByNumberOfPeople/<numberOfPeople>
Sample URI: http://localhost:8080/api/assignment/recipes/getByNumberOfPeople/4

7. get a recipe by indicator: http://localhost:8080/api/assignment/recipes/getByIndicator/<indicator>
Sample URI: http://localhost:8080/api/assignment/recipes/getByIndicator/V

8. get a recipe by recipe name: http://localhost:8080/api/assignment/recipes/getByRecipeName/<recipeName>
Sample URI: http://localhost:8080/api/assignment/recipes/getByRecipeName/Pizza

9. get a recipe by a single ingrediant: http://localhost:8080/api/assignment/recipes/getByIngrediant/<ingrediant>
Sample URI: http://localhost:8080/api/assignment/recipes/getByIngrediant/cheese

10. get a recipe by a single instruction: http://localhost:8080/api/assignment/recipes/getByInstruction/<instruction>
Sample URI: http://localhost:8080/api/assignment/recipes/getByInstruction/prepare

11. get a recipes by list of comma separated ingrediants: http://localhost:8080/api/assignment/recipes/getByIngrediants/<ingrediants>
Sample URI: http://localhost:8080/api/assignment/recipes/getByIngrediants/egg,tomato,rice

12. get recipes by list of comma separated instructions: http://localhost:8080/api/assignment/recipes/getByInstructions/<instructions>
Sample URI: http://localhost:8080/api/assignment/recipes/getByInstructions/fry,bake

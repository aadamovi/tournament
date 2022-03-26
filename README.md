**Golf tournament service**

Application accepts events from sourceA and sourceB with corresponding payload structure. 

Application stores the data in CouchbaseDB. Therefore, prior to starting the application CouchbaseDB instance needs 
to be started and configured to have a `tournament` bucket to store the documents.

Run `mvn clean install ` to make sure the tests pass and project is built.
Application can be run in Intellij IDE via the standard Run option or using the springboot maven plugin.
For example using `mvn spring-boot:run`

No specific environment is configured in application.yml, hence no specific profile needs to be specified on startup.

Tournament events are recorded by using a standard POST call that can be sent into the application via Postman 
or any other http client.

Tournament endpoint with `/tournament` path on port `8080` is to be used. Here is an example: `localhost:8080/tournament`

Source must be sent as a Header along with the payload. Every source is associated with a certain type of the payload 
structure.
 
An example of a test session is stored in the code base as `test.postman_collection.json`. 
This can be exported into Postman tool and use to trigger POST requests.
 
Code also contains an integration test that is written using the Testcontainers and starts up an instance of CouchbaseDb.
Therefore, that can be used instead of starting up the actual application with CouchbaseDb.


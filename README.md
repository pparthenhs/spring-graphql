# spring-graphql
This service combines spring with graphQl. In more details is has the 
following logic it has two entities Cars and Owners with relation (n:1), 
this information are stored into mongodb, using spring Hibernate. The user 
can interact with  the system using the following url using graphQl UI:

```
<SERVER_URL> : <SERVER_PORT> /graphiql
```

or using the graphQl REST endpoint :

```
<SERVER_URL> : <SERVER_PORT> /graphql?query={query}
```
On query you must send the graphQL JSON with information you want to retrieve.

> to see which functionality system support please visit Documentation explorer 
at graphQl UI on your server.

### Prerequisites

* mvn 
* git 
* java 1.8
* docker
* docker-compose

### Start the service:
1. Download project

```
git clone <project_URL>
``` 
 
2. Build project 

```
cd spring-graphQL
mvn clean install
``` 
 
3. Execute on development mode 

```
docker-compose up --build
``` 

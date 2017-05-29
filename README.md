# Research project to play around Spring Cloud

Mainly about how to implement microservices configuration server easily with history.
I use Git (GitHub) as repo for versioning here.

Also introduce some security approach for memories.

## Built With

* Spring Boot/Cloud/UI (Controller)
* Thymeleaf

## Encryption

Needs to be updated %JAVA_HOME%/jre/lib/security
with JCE from http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

Symmetric encryption setup:
1. Add encrypt.key to bootstrap.properties for ConfigServer
2. Start it
3. Hit (POSTMAN) localhost:8888/encrypt with:
	- POST!!!
	- Authorization! BasicAuth and credentials
	- Raw body with a value for encryption	
4. Verify it in reverse order with localhost:8888/decrypt
5. Put the value to consuming resources (for example to stations application.properties) with prefix {cipher}
- connstring={cipher}0451e73a03f065842bb65d0c0a5bd97743d5c40eebc80a97872d8445bbbfc6c2ced5229e73ea2ebe5c45a172d63cb5f3f99edcc29aea08a777e6df1ffcb893367f0883b276771c910ae6f40057d33a89
6. Verify that ConfigServer serve it converted from for example localhost:8888/s1rates/default


## Usage

SpringTool Suite.

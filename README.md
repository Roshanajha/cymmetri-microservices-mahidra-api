# cymmetri-microservices-mahindra-api

This is a sample application developed to demonstrates-
  - audit-service configuration
  - audig-logging 
  - search 
    - Dynamic-filter support
    - Paging and sorting
  

This application have following APIs
- Save User API: This api create and update user entity.
    - This API captures audit-events and log to audit by consuming audit-service-apis.
  
- List User API: This api list users based on configured filters.

#### Save User
```
URL: http://localhost:8080/user

Method: POST

Request: 
{
  "firstName": "Nilesh",
  "lastName": "Yadav",
  "email": "nhy@xyz.com",
}
```
#### List User API
```
URL: http://localhost:8080/user/list

Method: POST

Request:
{
  "filter": {
    "email": "",
    "firstName": "",
    "from": "",
    "to": ""
  },
  "keywoard": "",
  "pageNumber": 0,
  "pageSize": 0,
  "sortDirection": "ASC",
  "sortOn": []
}
```

#### Enable Common config

Following is the directory structure for common config -
```
com
    └── cymmetri
        ├── common
        │   ├── audit
        │   ├── CymmetriAutoConfig.java
        │   ├── mongo
        │   ├── search
        │   ├── session
        │   └── SwaggerConfig.java
        └── ms
```

This common-config can be enabled by importing CymmetriAutoConfig for example -
```
@SpringBootApplication
@Import({ CymmetriAutoConfig.class })
public class AuditSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditSampleApplication.class, args);
	}
}
```
#### Setup Audit Service
Configure following property at ``application.properties``

```
cymmetri.audit.uri=<path of audit service>
```
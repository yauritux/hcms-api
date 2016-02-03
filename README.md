# README #

This README would normally document whatever steps are necessary to get your application up and running.

* * *

## How do I get set up? ##

1. Install PostgreSQL in your local environment (suppose you've already known about how to do this)
1. Login to PostgreSQL and create new database named `hcms`. Leave it empty for now.
1. Configuration 
   >* install and configure `JAVA_HOME` path in your local environment.
1. Dependencies 
   >* **Gradle 2+**
   >* **JDK/JRE 8**
1. Execute DDL Scripts (Import database tables)
   >* You can do this simply just by running command `gradle flywayMigrate -i` from the terminal (console) within `hcms-core` directory.
1. Database configuration
   >* please adjust the db connection to match your local DB configuration. You can do this by replacing the database property values which can be found in `hrms-api/hrms-rest-api/src/main/resources/application.properties` file.
1. How to run tests
   >* `gradle testClasses`
1. Deployment instructions

    + run as **spring-boot** application
        * open the terminal/console
        * `cd` to `hcms-api`
        * execute as 'spring-boot' application simply by running `gradle bootRun`
    + deploy as **war** 
        * build the **war** simply by running the command `gradle clean build`, then deploy that war to preconfigured web container such as **tomcat**, **jetty**, or any other web/servlet container. 


* * *

### Contribution guidelines ###

1. API Uses

    #### Login ####

    > Example of Request : 

     `curl -i -H 'Content-Type: application/json' -X POST -d '{"username": "yauritux", "password":"test123"}' http://localhost:8080/api/login`

    > Example of Response : 

    `{
        "data":
        {
            "status": "LOGGED_IN",
            "_links":
            {
                "self":
                {
                    "href": "http://localhost:8080/api/login"
                },
                "user_resource":
                {
                    "href": "http://localhost:8080/api/user/yauri.attamimi"
                }
            },
            "logged_in_time": 1435735220926,
            "current_user": "yauritux",
            "auth_token": "67f9d917a60f713299ebd46de8a09e795ebbbbd4103e9ce89dcde421b14b5dd3a738de626a547fd668822c905d795602e5e161577d946b1d2c5b56955b18728a"
        },
        "apiVersion": "1.0.0"
    }`
    
    Subsequently, you need to provide the `username` and it's `auth_token` in every API call.  

* * *
### Writing tests ###
There's only one rule to write your unit test. i.e. name of the method should be written in 3 parts, and each part is splitted by underscore character ('_') as shown below:

`public void part1_part2_part3()`

* part1 represents the name of the method which is under testing
* part2 represents the scenario / test case
* part3 represents the expected result

e.g. : `public void findRoleByName_existingName_roleObjectIsReturned()`

* * *
### Code review ###
    > <<EMPTY>>

* * *
### Other guidelines ###
    > <<EMPTY>>

* * *
### Who do I talk to? ###

1. Repo owner or admin : [yauritux@gmail.com](mailto:yauritux@gmail.com)
=======

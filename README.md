# README #

This README would normally document whatever steps are necessary to get your application up and running.

* * *

## How do I get set up? ##

1. Setup the database in your local environment (suppose you've already known about how to do this)
1. Configuration 
   >* install and configure `JAVA_HOME` path in your local environment.
1. Dependencies 
   >* **Gradle 2+**
   >* **JDK/JRE 8**
1. Database configuration
   >* please adjust the db connection to match your local DB configuration. You can do this by replacing the database property values which can be found in `hrms-api/hrms-rest-api/src/main/resources/application.properties` file.
1. How to run tests
   >* `gradle testClasses`
1. Deployment instructions

    + run as **spring-boot** application
        * open the terminal/console
        * `cd` to `hcm`
        * execute as 'spring-boot' application simply by running `gradle bootRun`
    + deploy as **war** 
        * build the **war** simply by running the command `gradle clean build`, then deploy that war to preconfigured web container such as **tomcat**, **jetty**, or any other web/servlet container. 


* * *

### Contribution guidelines ###

1. API Uses

    #### Login ####

    > Example of Request : 

     `curl -i -H 'Content-Type: application/json' -X POST -d '{"username": "532231", "password":"532231"}' http://localhost:8080/api/login`

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
            "current_user": "532231",
            "auth_token": "67f9d917a60f713299ebd46de8a09e795ebbbbd4103e9ce89dcde421b14b5dd3a738de626a547fd668822c905d795602e5e161577d946b1d2c5b56955b18728a"
        },
        "apiVersion": "2.1.0"
    }`

    #### Create new IPT ####

    > Example of Request:

     `curl -i -H 'Content-Type: application/json' -H 'X-Auth-Token: 67f9d917a60f713299ebd46de8a09e795ebbbbd4103e9ce89dcde421b14b5dd3a738de626a547fd668822c905d795602e5e161577d946b1d2c5b56955b18728a' -d '{"period_seq": 7}' http://localhost:8080/api/pms/ipt/ipts`

    > Example of Response : 

    `{
        "data":
        {
           ......
        },
        "apiVersion": "2.1.0",
        "message": null,
        "page": null
    }`


* * *
### Writing tests ###
    > <<EMPTY>>

* * *
### Code review ###
    > <<EMPTY>>

* * *
### Other guidelines ###
    > <<EMPTY>>

* * *
### Who do I talk to? ###

1. Repo owner or admin : [yauritux@gmail.com](mailto:yauritux@gmail.com)

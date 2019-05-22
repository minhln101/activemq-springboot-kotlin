# ActiveMQ with Spring Boot in Kotlin
## Requirements:
#### Dependencies:
 - spring-boot-starter-activemq: org.springframework.boot
 - activemq-broker: org.apache.activemq
#### Run Application:
 - install activeMq
 - run active mq
 - go to http://localhost:8161/admin/
 - login with username and password: admin
 - deploy application, run application
 #### Send and Receive
 - choose "Send To" in in Operations of row "inbound.queue"
 - choose "Destination" as "inbound.queue" with type Queue/ Topic
 - text some message in text box "Message body" then "Send"
 
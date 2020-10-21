# JWT Token with Spring Boot in Kotlin

I had the issue to use JWT tokens in my current application. While there is a lot of information about it in java, I was missing an easy step by step tutorial for kotlin. And since I prefere kotlin over java a lot, I will provide this tutorial myself.

I used [this](https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/) tutorial as base for my implementation.

Because there are a lot information about [jwt](https://auth0.com/docs/tokens/json-web-tokens) and validation, I will not explain what a JSON Web Token is.

## Getting started

```bash
git clone https://github.com/auryn31/spring-kotlin-jwt.git
git checkout tags/v0.1
mvn clean compile exec:java
```

```bash
# add a new task
curl localhost:8080/api/task/add -i -X POST -d '{"description": "buy milk"}' -H "Content-Type: application/json"

# get the task
curl localhost:8080/api/task
# response
[{"description":"buy milk","done":false,"id":1}]

# delete task
curl localhost:8080/api/task/1 -X DELETE
```


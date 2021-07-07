# REST Assured Workshop
> Exercise yourself with REST Assured

| Exercise       | Status             | Exercise       | Status             |
| -------------- | ---------          | -------------- | ---------          |
| JSON Response validation        | :white_check_mark: | Hamcrest matchers        | :white_check_mark: |
| XML Response validation        | :white_check_mark: | Specification        | :white_check_mark: |
| Logging        | :white_check_mark: | Response extraction        | :white_check_mark: |
| Parameterization        | :white_check_mark: | Serialization        | :white_check_mark: |
| Deserialization        | :white_check_mark: |
___

### Dockerized JSON Server
```shell
docker-compose up -d
```
or
```shell
npm i -g json-server
json-server --watch src/test/resources/serialization.json
```
http://0.0.0.0:3000/posts

---

https://www.jsonschema2pojo.org/



### setup
1. Go to `IntelliJ IDEA > Preferences > Plugins`
2. Search and install plugin `Maven Archetype Catalogs`
3. Go to `IntelliJ IDEA > Preferences` and search `Maven`
4. Select `Maven Archetype Catalogs` and add this repository https://repo1.maven.org/maven2/archetype-catalog.xml
5. Go to `IntelliJ IDEA > New > Project...`
6. Select `Create from archetype > org.apache.maven.archetypes:maven-archetype-quickstart` and create a new project

> **Library Used**:
>
> rest-assured

##### Note:
- Java JDK version 8 or higher is required for using JUnit 5
- JUnit Jupiter (Aggregator) is the best dependency to add to your project in order to have access to all the JUnit 5 features
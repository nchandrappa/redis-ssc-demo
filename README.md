## Getting Started

This is a simple session state caching demo using spring data redis with time-to-live enabled.

### Configuration

You might need to modify redis hostname and ttl value to match your needs.

```
$ cat src/main/resources/application.properties

app.host=127.0.0.1
app.ttl=5             //seconds to expire
```

### Run App

```
mvn spring-boot:run
```

Then you can access the UI at http://locahost:8080

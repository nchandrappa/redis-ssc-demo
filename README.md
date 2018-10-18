## Getting Started

This is a simple session state caching demo using spring data redis with time-to-live enabled.


### Configuration

You might need to modify ttl value to match your needs.

```
$ cat src/main/resources/application.properties

app.ttl=5             //seconds to expire
```

### Deploying the App onto CloudFounfry

* Create YugaByte Service
* Update YB service in manifest.yml
* cf push

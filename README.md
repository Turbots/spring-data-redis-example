Custom Redis connection timeouts using Spring Boot
---

- Start a local Redis server using Docker, for example:

``` bash
docker run --name rabo-redis -p 6379:6379 -d redis
```

- Start up the Spring Boot application from your IDE or using Maven:

```bash
mvn spring-boot:run
```

- The output should look something like this:

```bash
2021-04-30 17:18:28.754  INFO 56597 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 11.0.10 on dhubau-a01.vmware.com with PID 56597 (/Users/dhubau/workspace/spring-data-redis-example/target/classes started by dhubau in /Users/dhubau/workspace/spring-data-redis-example)
2021-04-30 17:18:28.756  INFO 56597 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2021-04-30 17:18:29.027  INFO 56597 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2021-04-30 17:18:29.029  INFO 56597 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2021-04-30 17:18:29.079  INFO 56597 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 40 ms. Found 1 Redis repository interfaces.
2021-04-30 17:18:29.525  INFO 56597 --- [           main] o.s.s.c.ThreadPoolTaskScheduler          : Initializing ExecutorService 'taskScheduler'
2021-04-30 17:18:29.538  INFO 56597 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.011 seconds (JVM running for 1.244)
2021-04-30 17:18:30.558  INFO 56597 --- [   scheduling-1] com.example.demo.SimpleBatch             : Storing Employee e9e06538-0055-4c2d-aaa3-5527a9060bac
```

- Play with the options in the `com/example/demo/DemoApplication.java` class to try out different timeouts.

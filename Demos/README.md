# GroupDocs.Comparison for Java Demos

GroupDocs.Comparison for Java Demo projects.

All web demos run on `http://localhost:8080/comparison/` and provide document comparison with upload, download, file tree browsing, and result preview support.

> **Demo only — not for production use.** Web demos in this folder illustrate GroupDocs.Comparison API capabilities. They lack production-grade security controls. Use them locally for evaluation and build your own hardened service for deployment.

| Demo | Framework | Language | Run command |
|------|-----------|----------|-------------|
| [Spring](Spring) | Spring Boot 2.6 | Java | `mvn clean spring-boot:run` |
| [Dropwizard](Dropwizard) | Dropwizard | Java | `mvn clean compile exec:java` |
| [Javalin](Javalin) | Javalin | Kotlin | `./gradlew run` |
| [Ktor](Ktor) | Ktor | Kotlin | `./gradlew run` |
| [Micronaut](Micronaut) | Micronaut | Kotlin | `./gradlew run` |
| [Compose](Compose) | Compose Desktop | Kotlin | `./gradlew run` |

The [Compose](Compose) demo is a standalone desktop application (not a web app).

The [Spring](Spring) and [Dropwizard](Dropwizard) demos include basic path security via `PathSecurityUtils` (path traversal checks, file name sanitization, HTTP/HTTPS-only upload URLs). Other Kotlin demos use partial path checks via `PathManager`. These measures reduce common path-based risks but do not replace authentication, authorization, or a full security review.

See the [main README](../README.md) for Docker images and getting started instructions.

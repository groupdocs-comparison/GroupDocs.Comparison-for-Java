
# Document Comparison Java Library

GroupDocs.Comparison for Java is a [Document Comparison API](https://products.groupdocs.com/comparison/java) that provides the ability to detect differences between source and target files for changes at paragraph, word and character levels as well as can identify styling and formatting changes. The API supports over [50 document types](https://docs.groupdocs.com/comparison/java/supported-document-formats/) from popular categories such as Microsoft Office, OpenOffice, AutoCAD, Visio, images, programming, PDF & more.

<p align="center">
  <a title="Download complete GroupDocs.Comparison for Java source code" href="https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/archive/master.zip"> 
    <img src="https://camo.githubusercontent.com/11839cd752a2d367f3149c7bee1742b68e4a4d37/68747470733a2f2f7261772e6769746875622e636f6d2f4173706f73654578616d706c65732f6a6176612d6578616d706c65732d64617368626f6172642f6d61737465722f696d616765732f646f776e6c6f61645a69702d427574746f6e2d4c617267652e706e67" data-canonical-src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" style="max-width:100%;">
  </a>
</p>

Directory | Description
--------- | -----------
[Demos](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Demos)  | GroupDocs.Comparison for Java Dropwizard and Spring Demo projects.
[Examples](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly.

## Important: Demo Applications Only

The projects in the [Demos](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Demos) folder and the Docker images published as [`groupdocs/comparison`](https://hub.docker.com/r/groupdocs/comparison) are **sample applications** intended to demonstrate [GroupDocs.Comparison for Java](https://products.groupdocs.com/comparison/java) features.

They are **not** production-ready services and must **not** be exposed to the public internet without additional hardening.

Before using a demo in any shared or production-like environment:

- Run it on `localhost` or a trusted private network only
- Do not publish Docker containers directly to the internet without authentication, a reverse proxy, and network restrictions
- Treat file upload, browse, compare, and download features as untrusted input — validate and sandbox file paths in your own integration
- Add authentication, authorization, rate limiting, and logging appropriate for your security requirements
- Keep GroupDocs.Comparison and all dependencies up to date

The Spring and Dropwizard demos include basic path security via `PathSecurityUtils` (path traversal checks, file name sanitization, HTTP/HTTPS-only upload URLs). Invalid paths return HTTP 403 (`Access denied`). This reduces common path-based risks but does not replace a full security review.

For production integrations, use the library ([Examples](Examples), [documentation](https://docs.groupdocs.com/comparison/java/)) and implement your own secure document storage and API layer instead of deploying these demos as-is.

## Demos

All web demos run on `http://localhost:8080/comparison/` and provide document comparison with upload, download, file tree browsing, and result preview support.

| Demo | Framework | Language | Build | Version |
|------|-----------|----------|-------|---------|
| [Spring](Demos/Spring) | Spring Boot 2.6 | Java | `mvn clean spring-boot:run` | 26.5 |
| [Dropwizard](Demos/Dropwizard) | Dropwizard | Java | `mvn clean compile exec:java` | 26.5 |
| [Javalin](Demos/Javalin) | Javalin | Kotlin | `./gradlew run` | 26.5 |
| [Ktor](Demos/Ktor) | Ktor | Kotlin | `./gradlew run` | 26.5 |
| [Micronaut](Demos/Micronaut) | Micronaut | Kotlin | `./gradlew run` | 26.5 |
| [Compose](Demos/Compose) | Compose Desktop | Kotlin | `./gradlew run` | 26.5 |

The [Compose](Demos/Compose) demo is a standalone desktop application (not a web app).

## Docker

Pre-built Docker images are available on [Docker Hub](https://hub.docker.com/r/groupdocs/comparison).

```bash
docker pull groupdocs/comparison:latest
docker run -p 8080:8080 groupdocs/comparison:latest
```

**Security notice:** Docker images ship with demo defaults (e.g. upload and browse enabled, no authentication). Use them for local evaluation only. Do not expose port `8080` to untrusted networks without adding authentication, path validation, and other security controls required by your organization.

Available image tags follow the pattern `{version}-java-{jdk}-bullseye-{framework}`:

| Tag | JDK | Framework |
|-----|-----|-----------|
| `{ver}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{ver}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{ver}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |
| `{ver}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{ver}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{ver}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |

The `latest` tag points to the `openjdk18-bullseye-spring` variant.

The [Docker Hub repository overview](https://hub.docker.com/r/groupdocs/comparison) is generated from [`docs/docker-hub-overview.md`](docs/docker-hub-overview.md) when the [Publish Docker Images](.github/workflows/docker-publish.yml) workflow runs with **Push** enabled.

Images are built and published via the [Publish Docker Images](.github/workflows/docker-publish.yml) GitHub Actions workflow (manual dispatch). Set repository secrets `DOCKERHUB_USERNAME` and `DOCKERHUB_TOKEN` before pushing.

## Compare Documents via Java

- Accept or reject document changes.
- [Adjust comparison sensitivity](https://docs.groupdocs.com/comparison/java/adjusting-comparison-sensitivity/).
- Compare multiple documents at a time.
- Get change coordinates on the document.
- Set document metadata on save.
- Set password for resultant document.
- [Generate preview of document pages](https://docs.groupdocs.com/comparison/java/generate-document-pages-preview/).

## Get Started with GroupDocs.Comparison for Java

GroupDocs.Comparison for Java requires J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already.

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-comparison), so simply [configure](https://docs.groupdocs.com/comparison/java/installation/) your Maven project to fetch the dependencies automatically.

## Compare 2 PDF Documents

```java
try (Comparer comparer = new Comparer("source.pdf")) {
    comparer.add("target.pdf");
    comparer.compare("result.pdf");
}
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/comparison/java) | [Documentation](https://docs.groupdocs.com/comparison/java/) | [Demos](https://products.groupdocs.app/comparison/family) | [API Reference](https://apireference.groupdocs.com/java/comparison) | [Examples](https://github.com/groupdocs-comparison/GroupDocs.comparison-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/comparison/) | [Search](https://search.groupdocs.com/) | [Free Support](https://forum.groupdocs.com/c/comparison) | [Temporary License](https://purchase.groupdocs.com/temporary-license)

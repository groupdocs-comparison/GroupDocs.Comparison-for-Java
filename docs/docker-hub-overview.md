### GroupDocs Document Comparison API

[Product Page](https://products.groupdocs.com/comparison/java) | [Docs](https://docs.groupdocs.com/comparison/java/) | [Demos](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/comparison) | [Examples](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/comparison/) | [Free Support](https://forum.groupdocs.com/c/comparison) | [Temporary License](https://purchase.groupdocs.com/temporary-license)

**GroupDocs.Comparison Demos** are applications that demonstrate powerful features of [GroupDocs.Comparison for Java](https://products.groupdocs.com/comparison/java) distributed as Docker images. Compare **DOCX, PDF, PPT, XLS**, and over [50 document formats](https://docs.groupdocs.com/comparison/java/supported-document-formats/) without additional dependencies. Use these images as-is or customize and integrate them into your own project.

**Note:** without a license the application runs in trial mode. [Purchase a license](https://purchase.groupdocs.com/comparison/java) or request a [temporary license](https://purchase.groupdocs.com/temporary-license).

## Security Notice

These Docker images ship **sample/demo applications** — not production-ready services.

- Intended for **local development and evaluation** only
- Demo defaults enable upload, browse, and download; **no authentication** is included
- Do **not** expose port `8080` to untrusted networks without authentication, a reverse proxy, path validation, and other controls required by your organization
- For production, use the [GroupDocs.Comparison library](https://docs.groupdocs.com/comparison/java/) and implement your own secure document storage and API layer

Source code: [GroupDocs.Comparison-for-Java](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java)

## Document Comparison Demo Features

- Clean, modern and intuitive design
- Easily switchable colour theme
- Responsive design and mobile support
- HTML and image modes
- Fully customizable navigation panel
- Compare documents and multi-compare several documents
- Compare password-protected documents
- Upload documents and display clearly visible differences
- Download and print comparison results
- Smooth document scrolling and preloaded pages for faster rendering
- Multi-language support for displaying errors
- Cross-browser and cross-platform support

## Available Docker Images

Six images are published for each GroupDocs.Comparison for Java release: three Spring and three Dropwizard variants.

Tag format: `{version}-java-{jdk}-bullseye-{framework}`

Example: `{{VERSION}}-java-openjdk8-bullseye-dropwizard` — GroupDocs.Comparison for Java **{{VERSION}}**, Eclipse Temurin 8, Debian Bullseye, Dropwizard.

| Tag | JDK | Framework |
| --- | --- | --- |
| `{{VERSION}}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{{VERSION}}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{{VERSION}}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |
| `{{VERSION}}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{{VERSION}}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{{VERSION}}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |

The `latest` tag points to the `{{VERSION}}-java-openjdk18-bullseye-spring` variant when published with the **latest** workflow option.

## How to Run

Pull and run a Dropwizard image:

```shell
docker run -p 8080:8080 --name comparison --rm groupdocs/comparison:{{VERSION}}-java-openjdk8-bullseye-dropwizard
# Open http://localhost:8080/comparison/ in your browser.
```

Bind volumes for sample files and license:

```shell
docker run -p 8080:8080 --name comparison --rm \
  -v "C:/DocumentSamples/:/home/groupdocs/app/DocumentSamples" \
  -v "C:/Licenses/:/home/groupdocs/app/Licenses" \
  groupdocs/comparison:{{VERSION}}-java-openjdk8-bullseye-dropwizard
```

The sample reads license files from the mounted `Licenses` directory and lists documents from `DocumentSamples`.

## Comparison Configuration Options

Environment variables:

| Variable | Description | Default |
| --- | --- | --- |
| `LIC_PATH` | Path to directory with license file | `/home/groupdocs/app/Licenses` |
| `DOWNLOAD_ON` | Enable download button in UI | `true` |
| `UPLOAD_ON` | Enable file upload | `true` |
| `PRINT_ON` | Enable print | `true` |
| `BROWSE_ON` | Enable document browse dialog | `true` |
| `RIGHTCLICK_ON` | Enable right-click context menu | `false` |
| `FILES_DIR` | Directory for uploaded files | `/home/groupdocs/app/DocumentSamples` |
| `RESULT_DIR` | Directory for comparison result files | `/home/groupdocs/app/DocumentSamples` |
| `HOST_ADDRESS` | Host name or IP for the server instance | (empty) |

## See Also

- [View documents](https://products.groupdocs.com/viewer/java) with GroupDocs.Viewer
- [Sign documents](https://products.groupdocs.com/signature/java) with GroupDocs.Signature
- [Annotate documents](https://products.groupdocs.com/annotation/java) with GroupDocs.Annotation

[Product Page](https://products.groupdocs.com/comparison/java) | [Docs](https://docs.groupdocs.com/comparison/java/) | [Demos](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/comparison) | [Examples](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/comparison/) | [Free Support](https://forum.groupdocs.com/c/comparison) | [Temporary License](https://purchase.groupdocs.com/temporary-license)

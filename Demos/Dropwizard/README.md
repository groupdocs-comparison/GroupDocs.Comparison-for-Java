![GroupDocs.Comparison](https://raw.githubusercontent.com/groupdocs-comparison/groupdocs-comparison.github.io/master/resources/image/banner.png "GroupDocs.Comparison")
# GroupDocs.Comparison for Java Dropwizard Example
New GroupDocs.Comparison for Java Dropwizard UI Example
###### version 23.1

[![Build Status](https://travis-ci.org/groupdocs-comparison/GroupDocs.Comparison-for-Java-Dropwizard.svg?branch=master)](https://travis-ci.org/groupdocs-comparison/GroupDocs.Comparison-for-Java-Dropwizard)
[![Maintainability](https://api.codeclimate.com/v1/badges/bd15712ebdd04405b1ea/maintainability)](https://codeclimate.com/github/groupdocs-comparison/GroupDocs.Comparison-for-Java-Dropwizard/maintainability)
[![GitHub license](https://img.shields.io/github/license/groupdocs-comparison/GroupDocs.Comparison-for-Java-Dropwizard.svg)](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Demos/Dropwizard/blob/master/LICENSE)

## System Requirements
- Java 8+ (JDK 1.8+)
- Maven 3


## Compare documents with Java API

**GroupDocs.Comparison for Java** is a library that allows you to **compare PDF, DOCX, PPT, XLS,** and over 90 other document formats. With GroupDocs.Comparison for Java you will be able to compare two or more files, perform style and text comparison and generate a detailed report with changes.

This application allows you to compare multiple documents and can be used as a standalone application or integrated as part of your project.

**Note:** without a license application will run in trial mode, purchase [GroupDocs.Comparison for Java license](https://purchase.groupdocs.com/order-online-step-1-of-8.aspx) or request [GroupDocs.Comparison for Java temporary license](https://purchase.groupdocs.com/temporary-license).


## Demo Video

<p align="center">
  <a title="Document comparison for JAVA " href="https://www.youtube.com/watch?v=82RuvtV2qpw"> 
    <img src="https://raw.githubusercontent.com/groupdocs-comparison/groupdocs-comparison.github.io/master/resources/image/comparison.gif" width="100%" style="width:100%;">
  </a>
</p>


## Features
#### GroupDocs.Comparison
- Clean, modern and intuitive design
- Easily switchable colour theme (create your own colour theme in 5 minutes)
- Responsive design
- Mobile support (open application on any mobile device)
- HTML and image modes
- Fully customizable navigation panel
- Compare documents
- Multi-compare several documents
- Compare password protected documents
- Upload documents
- Display clearly visible differences
- Download comparison results
- Print comparison results
- Smooth document scrolling
- Preload pages for faster document rendering
- Multi-language support for displaying errors
- Cross-browser support (Safari, Chrome, Opera, Firefox)
- Cross-platform support (Windows, Linux, MacOS)


## How to run

You can run this sample by one of following methods

#### Build from source

Download [source code](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/archive/refs/heads/master.zip) from GitHub or clone this repository.

```bash
git clone https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java.git
cd GroupDocs.Comparison-for-Java/Demos/Dropwizard
mvn clean compile exec:java
## Open http://localhost:8080/comparison/ in your favorite browser.
```

#### Binary release (with all dependencies)

Download [latest release](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/releases/latest) from [releases page](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/releases).

**Note**: This method is **recommended** for running this sample behind firewall.

```bash
curl -J -L -o release.tar.gz https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/releases/download/v23.1/groupdocs-comparison-dropwizard-23.1.0.tar.gz
tar -xvzf release.tar.gz
cd release
java -jar comparison-1.8.6.jar configuration.yaml
## Open http://localhost:8080/comparison/ in your favorite browser.
```

#### Docker image
Use [docker](https://hub.docker.com/r/groupdocs/comparison) image.

There are 3 Dropwizard images available on Docker Hub.
1. `<VERSION>-java-openjdk8-bullseye-dropwizard` - based on OpenJDK 8 and Debian Bullseye
2. `<VERSION>-java-openjdk11-bullseye-dropwizard` - based on OpenJDK 11 and Debian Bullseye
3. `<VERSION>-java-openjdk18-bullseye-dropwizard` - based on OpenJDK 18 and Debian Bullseye

Each can be used to run GroupDocs.Comparison for Java Dropwizard sample

Example:

```bash
docker run -p 8080:8080 --name my-comparison --rm groupdocs/comparison:23.1-java-openjdk8-bullseye-dropwizard
## Open http://localhost:8080/comparison/ in your favorite browser.
```

## Configuration
For all methods above you can adjust settings in `configuration.yml`. By default in this sample will lookup for license file in `./Licenses` folder, so you can simply put your license file in that folder or specify relative/absolute path by setting `licensePath` value in `configuration.yml`. 

### Comparison configuration options

| Option                             | Type    |   Default value   | Description                                                                                                                                  |
| ---------------------------------- | ------- |:-----------------:|:---------------------------------------------------------------------------------------------------------------------------------------------|
| **`filesDirectory`**               | String  | `DocumentSamples` | Files directory path. Indicates where uploaded and predefined files are stored. It can be absolute or relative path                          |
| **`fontsDirectory`**               | String  |                   | Path to custom fonts directory.                                                                                                              |
| **`defaultDocument`**              | String  |                   | Absolute path to default document that will be loaded automaticaly.                                                                          |
| **`preloadPageCount`**             | Integer |        `0`        | Indicate how many pages from a document should be loaded, remaining pages will be loaded on page scrolling.Set `0` to load all pages at once |
| **`multiComparing`**               | String  |      `true`       | Enable/disable multi comparing feature                                                                                                       |
| **`sessionTimeout`**               | Integer |       `600`       | Timeout, after which session will expire. Session expiration will remove files that were cached for the user                                 |

#### Caching details
Cache files will be deleted when session expires (see sessionTimeout option). **Note:** cache files will be deleted for current user. For user, who left the site forever, cache files WILL NOT be deleted. They must be deleted manually, or additional functionality must be implemented to do it.

#### Developer Notes

Run next command to build image of sample project and put it to local Docker instance
```shell
docker build -t groupdocs_comparison_dropwizard_sample ./
```

Run next command to run the image as Docker container
```shell
docker run -p 8080:8080 --name my-comparer --rm groupdocs_comparison_dropwizard_sample
```

To pass environment variables use parameter: `--env DOWNLOAD_ON=false`
To attach Docker volume, use parameter: `-v groupdocs_comparison_dropwizard_volume:/home/groupdocs/app/MyDocumentSamples`
For example:
```shell
docker run -p 8080:8080 --name my-comparer --env FILES_DIR=/home/groupdocs/app/MyDocumentSamples -v groupdocs_comparison_dropwizard_volume:/home/groupdocs/app/MyDocumentSamples --rm groupdocs_comparison_dropwizard_sample

```

## License
The MIT License (MIT). 

Please have a look at the LICENSE.md for more details

## GroupDocs Comparison on other platforms & frameworks

- [Compare documents](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Demos/Spring) with JAVA Spring 
- [Compare documents](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Demos/Compose) with Kotlin in Compose Desktop application
- [Compare documents](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Demos/Ktor) with JAVA Ktor
- [Compare documents](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET-MVC) with .NET MVC 
- [Compare documents](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET-WebForms) with .NET WebForms 

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/comparison/java) | [Documentation](https://docs.groupdocs.com/comparison/java/) | [Demos](https://products.groupdocs.app/comparison/family) | [API Reference](https://apireference.groupdocs.com/java/comparison) | [Examples](https://github.com/groupdocs-comparison/GroupDocs.comparison-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/comparison/) | [Free Support](https://forum.groupdocs.com/c/comparison) | [Temporary License](https://purchase.groupdocs.com/temporary-license)

<!--
[![Build Status](https://travis-ci.org/HotwireDotCom/image-assert.svg?branch=develop)](https://travis-ci.org/HotwireDotCom/image-assert)
[![Download](https://api.bintray.com/packages/hotwiredotcom/maven/image-assert/images/download.svg)](https://bintray.com/hotwiredotcom/maven/image-assert/_latestVersion)
-->
#### System requirements

ImageMagick 7+ must be installed and added to PATH variable

#### Dependencies

###### Maven
```
<dependency>
	<groupId>com.github.annypatel.image-assert</groupId>
	<artifactId>image-assert-im7</artifactId>
	<version>1.0.6</version>
</dependency>
```
###### Gradle
```
'com.github.annypatel.image-assert:image-assert-im7:1.0.6'
```

#### Usage

Approach and syntax are similar to FEST-Assert library.
Use static method _**assertThat()**_ to create ImageAssert instance.
By default, ImageAssert instance does not report comparison results neither throws an exception,
so you will need to provide one or multiple listeners using _**reportingTo()**_ method.

#### Examples

You can create an ImageAssert instance and use chained calls to compare two images:
```
    ImageAssert.assertThat(screenshot)
            .reportingTo(ThrowExceptionResultListener())
            .isEqualTo(resource);
```

Alternatively, you can create a method to return a pre-configured instance of ImageAssert:
```
    ImageAssert assertThat(Image image) {
        return ImageAssert.assertThat(image)
                .reportingTo(PrintStreamResultListener())
                .reportingTo(ThrowExceptionResultListener())
    }
```
and then use it instead of static method (static methods are awful, right?):
```
    assertThat(screenshot())
        .isEqualTo(resource());
```
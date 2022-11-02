# Phyllo Java Library

![Maven Central](https://img.shields.io/maven-central/v/com.phyllo/phyllo-java)
![Sonatype Nexus (Releases)](https://img.shields.io/nexus/r/com.phyllo/phyllo-java?server=https%3A%2F%2Fs01.oss.sonatype.org)

## Documentation

API documentation is available at <https://docs.getphyllo.com/>.

## Usage

Check out the [sample app](.sample-app/app.java) which consumes this SDK!

```java
String client_id = System.getenv("PHYLLO_CLIENT_ID");
String secret = System.getenv("PHYLLO_SECRET");
BasicAuth auth = BasicAuth.of(client_id, secret);

PhylloConnectApiClient phylloConnectApiClient =
        new PhylloConnectApiClient("api.getphyllo.com", auth);

try {
    User user = phylloConnectApiClient.connect().createUser(CreateUser.Request.builder()
            .body(CreateUserRequest.builder()
                    .name("John Doe")
                    .externalId(ExternalId.valueOf("179a0bb4-c572-4477-9457-7dacf1b84848"))
                    .build())
            .build());
    System.out.println("Created a user! The user ID is " + user.getId());
} catch (CreateUserException e) {
    System.out.println("Failed to create a user" + e.getMessage());
}

```

## Beta status

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning the package version to a specific version in your build.gradle file. This way, you can install the same version each time without breaking changes unless you are intentionally looking for the latest version.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest [opening an issue](https://github.com/fern-phyllo/phyllo-java) first to discuss with us!

On the other hand, contributions to the README are always very welcome!
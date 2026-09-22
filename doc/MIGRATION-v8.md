# Migration from 7.x to 8.x

## Contents
- [CRD Generator v1 has been removed](#crd-generator-v1-removed)
- [Java baseline set to Java 17](#java-17)
  - [Build tooling requires a Java 17 runtime](#java-17-build-tooling)
  - [OSGi bundles require JavaSE 17](#java-17-osgi)
- [Karaf: the bundled `scr` feature has been removed](#karaf-scr)
- [Jackson 3](#jackson-3)
  - [Generated CRDs](#jackson-3-crd-generator)
- [`withShardSelector(null)` is ambiguous](#shard-selector-null)
- [`kubernetes-httpclient-jetty` moved to Jetty 12](#jetty-12)


> [!NOTE]
> If you encounter any problems with the following "Migration from 7.x to 8.x" instructions, please let us know by creating an issue in our [GitHub repository](https://github.com/fabric8io/kubernetes-client/issues).
>
> We value your feedback and will work to address your issue promptly.
> Your contribution is essential to improving our documentation, making our migration process smoother for everyone!

## CRD Generator v1 has been removed <a href="#crd-generator-v1-removed" id="crd-generator-v1-removed"/>

The deprecated CRD Generator v1 modules have been removed in version 8.0.0:
- `io.fabric8:crd-generator-api` - CRD Generator API v1
- `io.fabric8:crd-generator-apt` - CRD Generator annotation processing tool (APT)

These modules were deprecated since 7.0.0 in favor of CRD Generator v2.

**Migration:** If you are still using CRD Generator v1, you must migrate to CRD Generator v2 before upgrading to 8.0.0. See the [CRD Generator v2 documentation](CRD-generator.md) for usage instructions.

> [!WARNING]
> Dropping the dependency without adding a replacement fails silently: an absent annotation
> processor produces no compiler diagnostic, so the build stays green and `META-INF/fabric8/`
> is simply empty. Check that your CRDs are still generated after migrating.

Concretely, remove the `provided`-scope `io.fabric8:crd-generator-apt` dependency (Maven) or the
`annotationProcessor 'io.fabric8:crd-generator-apt'` entry (Gradle), together with any
`-Aio.fabric8.crd.generator.*` compiler argument, and adopt one of the following instead:

- [CRD Generator Maven Plugin](../crd-generator/maven-plugin/README.md) - for Maven builds
- [CRD Generator CLI](../crd-generator/cli/README.md) - command-line tool
- [CRD Generator with Gradle](../crd-generator/gradle/README.md) - build script recipe for Gradle builds

The annotations themselves are unchanged, but v2 applies some of them more strictly: `@Min`/`@Max` are honored only on numeric fields and `@Pattern` only on string fields. See the [Breaking Changes](CRD-generator-migration-v2.md#breaking-changes) section of the migration guide for the full list.

If you called the generator programmatically, the API moved packages: `io.fabric8.crd.generator.CRDGenerator` is now `io.fabric8.crdv2.generator.CRDGenerator` (likewise `CRDInfo` and `CRDGenerationInfo`).

CRD Generator v2 only emits `apiextensions.k8s.io/v1` CRDs. v1 generated both `v1` and `v1beta1` files when no CRD version was configured, so if your build consumed the `*-v1beta1.yml` output, note that `v1beta1` was removed from Kubernetes in 1.22 and is no longer generated; requesting it is ignored with a warning.

## Java baseline set to Java 17 <a href="#java-17" id="java-17"/>

Starting from version 8.0.0, you will need a Java 17+ runtime (using the latest Java release is always encouraged) to use the Fabric8 Kubernetes Client.

Java 11 reached the end of its Oracle Premier Support window and most vendors have moved their free update streams on.
Java 17 is the oldest release still receiving broad support across vendors, so it is where the baseline now sits.

If you are still on Java 11, you have to upgrade your runtime before upgrading to 8.0.0. The 7.x line remains on the Java 11 baseline.

### Build tooling requires a Java 17 runtime <a href="#java-17-build-tooling" id="java-17-build-tooling"/>

This affects you even if your own application targets an older Java release.

The CRD generator and Java generator ship as Maven plugins and a Gradle plugin. They are compiled for Java 17, so the JVM that *runs the build* must be Java 17 or newer:

- **Maven plugins** (`crd-generator-maven-plugin`, `java-generator-maven-plugin`): the JVM running Maven.
- **Gradle plugin** (`io.fabric8.java-generator`): the Gradle daemon. Gradle itself must be a version that supports running on Java 17 (Gradle 7.3+).

Running any of them on an older JVM fails with `UnsupportedClassVersionError`. Note that your *compilation target* is independent of this: you can still set `maven.compiler.release` (or the Gradle toolchain) to an older version for your own sources, as long as the build tool itself runs on Java 17+.

If you need the build JVM to stay on an older release, the CRD generator Maven plugin can fork a separate JVM for generation. See [Cross-JDK version builds](../crd-generator/maven-plugin/README.md#cross-jdk-version-builds-forked-jvm).

### OSGi bundles require JavaSE 17 <a href="#java-17-osgi" id="java-17-osgi"/>

The published bundles now declare `Require-Capability: osgi.ee;filter:="(&(osgi.ee=JavaSE)(version=17))"`, up from `version=11`.

This is a *resolution* requirement, not just a runtime one: on an OSGi framework running Java 11 the bundles will fail to resolve rather than failing later at class load. Karaf users need a container running on Java 17 or newer.

## Karaf: the bundled `scr` feature has been removed <a href="#karaf-scr" id="karaf-scr"/>

The `io.fabric8.kubernetes:kubernetes-karaf` feature repository used to define its own `scr` feature, pinning a single Felix SCR bundle. That definition has been removed, and `kubernetes-client` now depends on the `scr` feature provided by the Karaf distribution.

For most users this needs no action: Karaf provides `scr` out of the box, and installing `kubernetes-client` pulls it in as before.

Two things change if you were relying on the old behaviour:

- **If you installed our `scr` feature explicitly** (`feature:install scr` resolving against our repository, or a `<feature>scr</feature>` reference in your own descriptor), you now get Karaf's. Karaf's is a superset: besides the SCR implementation it also supplies the Declarative Services API bundles and, through its conditionals, the `scr:list` / `scr:info` shell commands and the SCR MBean.
- **If you build a custom Karaf assembly**, make sure the Karaf standard feature repository is on the descriptor list. Our repository no longer carries a `scr` feature to fall back on, so an assembly that registers only the fabric8 repository will now fail to resolve `kubernetes-client` — loudly, at assembly time, rather than silently producing a container where the client cannot activate.

The old definition was not self-contained: Felix SCR 2.0.6 exported the Declarative Services API itself, but 2.2.18 and later import it instead, so a single-bundle `scr` feature no longer carries everything it needs. Because ours was versioned with the project version it also outranked Karaf's, so an unversioned `scr` request selected the incomplete definition.

## Jackson 3 <a href="#jackson-3" id="jackson-3"/>

The client and the model now use Jackson 3. Any code of yours that uses the Jackson types the client exposes, or that configures how your custom resources are (de)serialized, has to move too.

- **Coordinates and packages:** `com.fasterxml.jackson.core` / `com.fasterxml.jackson.dataformat` become `tools.jackson.core` / `tools.jackson.dataformat`, and the `com.fasterxml.jackson.{core,databind,dataformat}` packages become `tools.jackson.*`. Annotations such as `@JsonProperty` are unchanged and still come from `com.fasterxml.jackson.core:jackson-annotations`.
- **`java.time` support is built in:** drop `jackson-datatype-jsr310` and any `JavaTimeModule` registration.
- **Databind annotations moved:** `@JsonDeserialize`, `@JsonSerialize` and friends now live in `tools.jackson.databind.annotation`, and `JsonDeserializer`/`JsonSerializer` are `ValueDeserializer`/`ValueSerializer`. The Jackson 2 variants still compile when Jackson 2 is on your classpath, but the client silently ignores them, so check your custom resource classes.
- **Exposed types:** `Serialization.jsonMapper()`/`yamlMapper()` return Jackson 3 mappers, `unmarshal(..., TypeReference)` takes a `tools.jackson.core.type.TypeReference`, and `JsonNode` model fields (e.g. `JSONSchemaProps` `default`/`example`) are `tools.jackson.databind.JsonNode`.
- **Mappers are immutable:** `registerModule` and `configure` are gone, use the builder or `mapper.rebuild()`. `new KubernetesSerialization(mapper, ...)` configures and uses a copy, the mapper you pass is left untouched. Subclasses overriding `configureMapper` must return the configured mapper.

The default `KubernetesSerialization` (and therefore `KubernetesClientBuilder`) uses `JsonMapper.builderWithJackson2Defaults()` and the new `Jackson2JdkTypesModule`, so your custom types keep their 2.x wire format. If you pass your own mapper, build it the same way:

```java
new KubernetesSerialization(JsonMapper.builderWithJackson2Defaults().addModule(new Jackson2JdkTypesModule()).build(), true);
```

With plain Jackson 3 defaults, properties are sorted alphabetically, enums go through `toString()`, `null` for a primitive fails and getter-only collections are no longer populated. Without the module, `Year` is written as a number, `Month` as its zero-based index, `java.sql.Date` as a UTC date-time and `Locale` as a language tag (`zh-Hant-TW` instead of `zh_TW_#Hant`), and locales written by 7.x lose their script or extension when read.

The module also reads a `yyyy-MM-dd` `java.sql.Date` as a local date. 7.x read it as UTC midnight, which is the previous day west of UTC.

A few differences can't be restored:

- Getters with an upper-case prefix follow the standard bean naming, so `getURL()` is now `URL` instead of `url`. Annotate them with `@JsonProperty` to keep the old name.
- `Map<Enum, V>` and `Set<Enum>` properties are read as an `EnumMap` and an `EnumSet`.
- `Optional` values are written. 7.x failed on them.

### Generated CRDs <a href="#jackson-3-crd-generator" id="jackson-3-crd-generator"/>

The CRD generator now uses the Jackson 3 version of `jackson-module-jsonSchema` (`tools.jackson.module:jackson-module-jsonSchema`). If you embed the generator, `CRDGenerator.withObjectMapper(...)` and `ResolvingContext` now take a `tools.jackson.databind.ObjectMapper`. The generator makes that mapper write dates and durations as strings, whatever its settings, because that's what the client writes. Add the `Jackson2JdkTypesModule` to it as well, like the default mapper does, so that `Year`, `Month`, `java.sql.Date` and `Locale` are described the way the client writes them.

The generated CRDs are the same as in 7.x except for the following:

- **`Optional` fields** now get the schema of their value type. In 7.x they were emitted as `x-kubernetes-preserve-unknown-fields: true`, so an `Optional<Pojo>` field now prunes the fields the POJO doesn't declare, like a plain `Pojo` field.
- **`@JsonUnwrapped` properties** are now flattened into the parent object schema. In 7.x they were incorrectly nested under the field name.
- **`Object` properties, `Map` values of type `Object` and raw `Map`s** are now `x-kubernetes-preserve-unknown-fields: true` instead of `type: object`. They hold arbitrary JSON, and `type: object` made the API server prune it and reject scalars. An `Object` property with `@JsonSerialize(as = SomeType.class)` gets the schema of `SomeType`.
- **`List<Object>` and raw collections** now generate an array whose items are `x-kubernetes-preserve-unknown-fields: true`. Generation used to fail with `Untyped collection <field>`.
- **Polymorphic types** (`@JsonTypeInfo` / `@JsonSubTypes` on the class, on an interface it implements, or on the property) keep the base type's properties and add `x-kubernetes-preserve-unknown-fields: true`, so the subtypes' content and the type id are no longer pruned. A CRD cannot express the discriminated union itself. `@JsonTypeInfo(use = NONE)` opts a subtype or property out.
- **Date and time formats** remain only where the value the client writes matches them, since the API server rejects any value that doesn't (`date-time` requires an offset). `Duration`, `LocalDateTime`, `OffsetTime`, `YearMonth`, `MonthDay`, `Year` and `java.sql.Time` no longer carry `format: date-time` (`PT1H30M`, `2026-01-02T10:15:30`, `10:15:30+01:00`, `2026-01`, `--12-25`, `2024`, `10:15:30`), and `LocalTime` no longer carries `format: time`. `java.sql.Date` carries `format: date` instead of `date-time` (`2024-01-15`). `Instant`, `OffsetDateTime`, `ZonedDateTime`, `Date`, `Timestamp` and `Calendar` keep `date-time`, and `LocalDate` keeps `date`.
- **`@PrinterColumn` on a `LocalDate`** is a `string` column instead of a `date` column. The API server renders a `date` column as the age of an RFC 3339 timestamp, so it showed `<invalid>`. Use `@AdditionalPrinterColumn(type = DATE)` for an age column.
- **`byte[]` and `ByteBuffer`**, including in `Optional`, `List` and `Map` values, are `type: string, format: byte` instead of an array of integers, like Go's `[]byte`: the client writes them as base64, which the array schema rejected. `@Size` on them limits the length of the base64 string, which is only exact for multiples of 3 bytes: `@Size(min = 2, max = 100)` accepts 1 to 102 bytes. `Byte[]` and `List<Byte>` stay arrays of integers, that's how they're written. The API server rejects an empty string for `format: byte`, and the client writes an empty `byte[]` or `ByteBuffer` as `""`, so leave empty values `null` or annotate a `byte[]` field with `@JsonInclude(JsonInclude.Include.NON_EMPTY)`.
- **`char[]`** is `type: string` instead of an array of strings, which rejected the string the client writes.
- **Integers** get the format controller-gen gives their Go counterpart: `int`, `Integer`, `OptionalInt` and `AtomicInteger` get `format: int32`, and `long`, `Long`, `OptionalLong` and `AtomicLong` get `format: int64`, also as list items and map values. `long[]` items change from `type: number` to `integer`. The API server range-checks these formats since Kubernetes 1.36. Java values always fit, but `@Min`/`@Max` bounds have to fit the type too. `short`, `byte` and `BigInteger` get none, and neither does a property with its own serializer or converter (`@JsonSerialize`).

## `withShardSelector(null)` is ambiguous <a href="#shard-selector-null" id="shard-selector-null"/>

`Filterable#withShardSelector` now also accepts a typed `ShardSelector` next to the expression `String`, so passing a literal `null` to clear the selector no longer compiles:

```java
// no longer compiles: reference to withShardSelector is ambiguous
client.pods().withShardSelector(null);

// pick the overload instead
client.pods().withShardSelector((String) null);
```

Passing a `null`-valued variable is unaffected, and either overload still clears the selector.

## `kubernetes-httpclient-jetty` moved to Jetty 12 <a href="#jetty-12" id="jetty-12"/>

`kubernetes-httpclient-jetty` now uses Jetty 12.1. Jetty 11 is end of life and there is no Jetty 11 variant of the module; the 7.x line stays on Jetty 11.

- **Classpath:** Jetty 12 can't share a classpath with Jetty 9, 10 or 11. `jetty-util`, `jetty-io`, `jetty-http` and `jetty-client` keep their coordinates, so only one version is resolved: if your application embeds an older Jetty, upgrade it to 12.1 or use another HTTP client. The WebSocket and HTTP/2 artifacts were renamed (`jetty-websocket-jetty-client`, `jetty-http2-client-transport`), so version pins on the old ones no longer apply.
- **`JettyHttpClientFactory#additionalConfig(HttpClient, WebSocketClient)`** keeps its signature but takes Jetty 12 types. The `WebSocketClient` now runs on the given `HttpClient`, so settings (and the cookie store) apply to both, and proxy or authentication settings you added to both (the workaround for [#8029](https://github.com/fabric8io/kubernetes-client/issues/8029)) are now registered twice. Review what you set on `webSocketClient.getHttpClient()` for WebSockets only, such as a relaxed trust manager or proxy changes: it now applies to every REST request too.
- **401 handling:** Jetty's `WWW-Authenticate` handler is removed from the `HttpClient`, since it failed the 401 responses the API server sends without a challenge. The client authenticates with the credentials from its `Config`; an `Authentication` registered in Jetty's `AuthenticationStore` through `additionalConfig` no longer answers the API server's 401.
- **Exposed types:** `JettyHttpResponse`, `JettyAsyncResponseListener` and `JettyWebSocket` use Jetty 12 types and supertypes (`Response.Listener`, `Session.Listener`). The JPMS module names changed too: `org.eclipse.jetty.websocket.jetty.client` is now `org.eclipse.jetty.websocket.client`, and `org.eclipse.jetty.http2.http.client.transport` is `org.eclipse.jetty.http2.client.transport`.
- **WebSocket back-pressure:** messages that aren't consumed now wait on the socket instead of blocking a Jetty thread, so the "Jetty HttpClient thread is waiting too long for the consumption of previous websocket message" exception is gone.

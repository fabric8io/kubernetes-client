# Migration from 7.x to 8.x

## Contents
- [CRD Generator v1 has been removed](#crd-generator-v1-removed)
- [Java baseline set to Java 17](#java-17)
  - [Build tooling requires a Java 17 runtime](#java-17-build-tooling)
  - [OSGi bundles require JavaSE 17](#java-17-osgi)
- [Karaf: the bundled `scr` feature has been removed](#karaf-scr)
- [Jackson 3](#jackson-3)


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

The default `KubernetesSerialization` (and therefore `KubernetesClientBuilder`) uses `JsonMapper.builderWithJackson2Defaults()`, so your custom types keep their 2.x wire format. If you pass your own mapper, build it the same way: with plain Jackson 3 defaults, properties are sorted alphabetically, enums go through `toString()`, `null` for a primitive fails and getter-only collections are no longer populated.

One difference can't be restored: getters with an upper-case prefix follow the standard bean naming, so `getURL()` is now `URL` instead of `url`. Annotate them with `@JsonProperty` to keep the old name.

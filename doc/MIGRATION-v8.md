# Migration from 7.x to 8.x

## Contents
- [Java baseline set to Java 17](#java-17)
  - [Build tooling requires a Java 17 runtime](#java-17-build-tooling)
  - [OSGi bundles require JavaSE 17](#java-17-osgi)
- [Karaf: the bundled `scr` feature has been removed](#karaf-scr)


> [!NOTE]
> If you encounter any problems with the following "Migration from 7.x to 8.x" instructions, please let us know by creating an issue in our [GitHub repository](https://github.com/fabric8io/kubernetes-client/issues).
>
> We value your feedback and will work to address your issue promptly.
> Your contribution is essential to improving our documentation, making our migration process smoother for everyone!

## Java baseline set to Java 17 <a href="#java-17" id="java-17"/>

Starting from version 8.0.0, you will need a Java 17+ runtime (using the latest Java release is always encouraged) to use the Fabric8 Kubernetes Client.

Java 11 reached the end of its Oracle Premier Support window and most vendors have moved their free update streams on.
Java 17 is the oldest release still receiving broad support across vendors, so it is where the baseline now sits.

If you are still on Java 11, you have to upgrade your runtime before upgrading to 8.0.0. The 7.x line remains on the Java 11 baseline.

### Build tooling requires a Java 17 runtime <a href="#java-17-build-tooling" id="java-17-build-tooling"/>

This affects you even if your own application targets an older Java release.

The CRD generator and Java generator ship as Maven plugins, a Gradle plugin, and an annotation processor. They are compiled for Java 17, so the JVM that *runs the build* must be Java 17 or newer:

- **Maven plugins** (`crd-generator-maven-plugin`, `java-generator-maven-plugin`): the JVM running Maven.
- **Gradle plugin** (`io.fabric8.java-generator`): the Gradle daemon. Gradle itself must be a version that supports running on Java 17 (Gradle 7.3+).
- **Annotation processor** (`crd-generator-apt`): the `javac` that runs annotation processing.

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

# Migration from 6.x to 7.x

## Contents
- [Bouncy Castle is no longer needed](#bouncy-castle)
- [Apache Felix SCR Annotations removed](#apache-felix-scr-annotations)
- [Model Changes](#model-changes)
  - [kubernetes-model artifact removed](#kubernetes-model-artifact-removed)
- [Deprecations and Removals](#deprecations-and-removals)
  - [Service Catalog API removed](#service-catalog) 


> [!NOTE]
> If you encounter any problems with the following "Migration from 6.x to 7.x" instructions, please let us know by creating an issue in our [GitHub repository](https://github.com/fabric8io/kubernetes-client/issues).
>
> We value your feedback and will work to address your issue promptly.
> Your contribution is essential to improving our documentation, making our migration process smoother for everyone!

## Bouncy Castle is no longer needed <a href="#bouncy-castle" id="bouncy-castle"/>

The Bouncy Castle library is no longer needed as a dependency.
In previous versions, this was an optional dependency needed for Elliptic Curve (EC) Keys.
The Kubernetes client now uses the default Java security provider which should be enough to handle all scenarios.

## Apache Felix SCR annotations removed <a href="#apache-felix-scr-annotations" id="apache-felix-scr-annotations" />

[Apache Felix SCR annotations](https://felix.apache.org/documentation/subprojects/apache-felix-maven-scr-plugin/scr-annotations.html) are not supported anymore by community. Fabric8 Kubernetes Client no longer uses Apache Felix SCR annotations for OSGi
Declarative Services. Fabric8 Kubernetes Client is now using official OSGi annotations instead. If you're using Apache Felix SCR
annotations, you need to switch to [Official OSGi Component annotations](https://docs.osgi.org/javadoc/r6/cmpn/org/osgi/service/component/annotations/package-summary.html).

## Model Changes <a href="#model-changes" id="model-changes"/>

### kubernetes-model artifact removed <a href="#kubernetes-model-artifact-removed" id="kubernetes-model-artifact-removed"/>

The Maven artifact `io.fabric8:kubernetes-model` has been removed from the project and is no longer published.

This artifact was just an aggregator of _some_ of the Kubernetes model artifacts and had no specific purpose.
It is no longer published, the `io.fabric8:kubernetes-client-api` or `io.fabric8:kubernetes-openshift-uberjar` artifacts should be used instead.

## Deprecations and Removals <a href="#deprecations-and-removals" id="deprecations-and-removals"/>

### Service Catalog API removed <a href="#service-catalog" id="service-catalog"/>

The Service Catalog API extension has been removed.
The upstream project has been archived since May 6, 2022.
We are no longer supporting it.

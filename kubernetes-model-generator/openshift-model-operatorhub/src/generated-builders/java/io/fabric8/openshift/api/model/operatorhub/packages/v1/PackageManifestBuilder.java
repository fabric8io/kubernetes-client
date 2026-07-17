package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PackageManifestBuilder extends PackageManifestFluent<PackageManifestBuilder> implements VisitableBuilder<PackageManifest,PackageManifestBuilder>{

  PackageManifestFluent<?> fluent;

  public PackageManifestBuilder() {
    this(new PackageManifest());
  }
  
  public PackageManifestBuilder(PackageManifestFluent<?> fluent) {
    this(fluent, new PackageManifest());
  }
  
  public PackageManifestBuilder(PackageManifest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PackageManifestBuilder(PackageManifestFluent<?> fluent,PackageManifest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PackageManifest build() {
    PackageManifest buildable = new PackageManifest(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
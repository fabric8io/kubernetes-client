package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PackageManifestSpecBuilder extends PackageManifestSpecFluent<PackageManifestSpecBuilder> implements VisitableBuilder<PackageManifestSpec,PackageManifestSpecBuilder>{

  PackageManifestSpecFluent<?> fluent;

  public PackageManifestSpecBuilder() {
    this(new PackageManifestSpec());
  }
  
  public PackageManifestSpecBuilder(PackageManifestSpecFluent<?> fluent) {
    this(fluent, new PackageManifestSpec());
  }
  
  public PackageManifestSpecBuilder(PackageManifestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PackageManifestSpecBuilder(PackageManifestSpecFluent<?> fluent,PackageManifestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PackageManifestSpec build() {
    PackageManifestSpec buildable = new PackageManifestSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
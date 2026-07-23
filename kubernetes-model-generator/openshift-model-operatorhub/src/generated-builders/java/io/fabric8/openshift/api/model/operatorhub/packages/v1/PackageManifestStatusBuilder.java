package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PackageManifestStatusBuilder extends PackageManifestStatusFluent<PackageManifestStatusBuilder> implements VisitableBuilder<PackageManifestStatus,PackageManifestStatusBuilder>{

  PackageManifestStatusFluent<?> fluent;

  public PackageManifestStatusBuilder() {
    this(new PackageManifestStatus());
  }
  
  public PackageManifestStatusBuilder(PackageManifestStatusFluent<?> fluent) {
    this(fluent, new PackageManifestStatus());
  }
  
  public PackageManifestStatusBuilder(PackageManifestStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PackageManifestStatusBuilder(PackageManifestStatusFluent<?> fluent,PackageManifestStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PackageManifestStatus build() {
    PackageManifestStatus buildable = new PackageManifestStatus(fluent.getCatalogSource(), fluent.getCatalogSourceDisplayName(), fluent.getCatalogSourceNamespace(), fluent.getCatalogSourcePublisher(), fluent.buildChannels(), fluent.getDefaultChannel(), fluent.buildDeprecation(), fluent.getPackageName(), fluent.buildProvider());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PackageManifestListBuilder extends PackageManifestListFluent<PackageManifestListBuilder> implements VisitableBuilder<PackageManifestList,PackageManifestListBuilder>{

  PackageManifestListFluent<?> fluent;

  public PackageManifestListBuilder() {
    this(new PackageManifestList());
  }
  
  public PackageManifestListBuilder(PackageManifestListFluent<?> fluent) {
    this(fluent, new PackageManifestList());
  }
  
  public PackageManifestListBuilder(PackageManifestList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PackageManifestListBuilder(PackageManifestListFluent<?> fluent,PackageManifestList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PackageManifestList build() {
    PackageManifestList buildable = new PackageManifestList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PackageOverrideBuilder extends PackageOverrideFluent<PackageOverrideBuilder> implements VisitableBuilder<PackageOverride,PackageOverrideBuilder>{

  PackageOverrideFluent<?> fluent;

  public PackageOverrideBuilder() {
    this(new PackageOverride());
  }
  
  public PackageOverrideBuilder(PackageOverrideFluent<?> fluent) {
    this(fluent, new PackageOverride());
  }
  
  public PackageOverrideBuilder(PackageOverride instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PackageOverrideBuilder(PackageOverrideFluent<?> fluent,PackageOverride instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PackageOverride build() {
    PackageOverride buildable = new PackageOverride();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
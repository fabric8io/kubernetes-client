package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PackageFilterBuilder extends PackageFilterFluent<PackageFilterBuilder> implements VisitableBuilder<PackageFilter,PackageFilterBuilder>{

  PackageFilterFluent<?> fluent;

  public PackageFilterBuilder() {
    this(new PackageFilter());
  }
  
  public PackageFilterBuilder(PackageFilterFluent<?> fluent) {
    this(fluent, new PackageFilter());
  }
  
  public PackageFilterBuilder(PackageFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PackageFilterBuilder(PackageFilterFluent<?> fluent,PackageFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PackageFilter build() {
    PackageFilter buildable = new PackageFilter(fluent.getAnnotations(), fluent.buildFilterRef(), fluent.buildLabelSelector(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
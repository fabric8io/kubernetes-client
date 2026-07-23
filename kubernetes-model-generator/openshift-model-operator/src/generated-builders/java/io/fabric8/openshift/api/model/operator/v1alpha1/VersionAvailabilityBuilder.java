package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VersionAvailabilityBuilder extends VersionAvailabilityFluent<VersionAvailabilityBuilder> implements VisitableBuilder<VersionAvailability,VersionAvailabilityBuilder>{

  VersionAvailabilityFluent<?> fluent;

  public VersionAvailabilityBuilder() {
    this(new VersionAvailability());
  }
  
  public VersionAvailabilityBuilder(VersionAvailabilityFluent<?> fluent) {
    this(fluent, new VersionAvailability());
  }
  
  public VersionAvailabilityBuilder(VersionAvailability instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VersionAvailabilityBuilder(VersionAvailabilityFluent<?> fluent,VersionAvailability instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VersionAvailability build() {
    VersionAvailability buildable = new VersionAvailability(fluent.getErrors(), fluent.buildGenerations(), fluent.getReadyReplicas(), fluent.getUpdatedReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
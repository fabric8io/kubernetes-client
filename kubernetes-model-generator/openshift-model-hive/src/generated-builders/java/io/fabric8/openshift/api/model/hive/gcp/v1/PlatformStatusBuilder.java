package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformStatusBuilder extends PlatformStatusFluent<PlatformStatusBuilder> implements VisitableBuilder<PlatformStatus,PlatformStatusBuilder>{

  PlatformStatusFluent<?> fluent;

  public PlatformStatusBuilder() {
    this(new PlatformStatus());
  }
  
  public PlatformStatusBuilder(PlatformStatusFluent<?> fluent) {
    this(fluent, new PlatformStatus());
  }
  
  public PlatformStatusBuilder(PlatformStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformStatusBuilder(PlatformStatusFluent<?> fluent,PlatformStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformStatus build() {
    PlatformStatus buildable = new PlatformStatus(fluent.buildPrivateServiceConnect());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
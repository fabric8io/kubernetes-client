package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RawIptablesBuilder extends RawIptablesFluent<RawIptablesBuilder> implements VisitableBuilder<RawIptables,RawIptablesBuilder>{

  RawIptablesFluent<?> fluent;

  public RawIptablesBuilder() {
    this(new RawIptables());
  }
  
  public RawIptablesBuilder(RawIptablesFluent<?> fluent) {
    this(fluent, new RawIptables());
  }
  
  public RawIptablesBuilder(RawIptables instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RawIptablesBuilder(RawIptablesFluent<?> fluent,RawIptables instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RawIptables build() {
    RawIptables buildable = new RawIptables(fluent.getDevice(), fluent.getDirection(), fluent.getIpsets(), fluent.getName(), fluent.getSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
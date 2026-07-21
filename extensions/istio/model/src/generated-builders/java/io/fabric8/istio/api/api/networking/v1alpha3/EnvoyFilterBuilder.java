package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterBuilder extends EnvoyFilterFluent<EnvoyFilterBuilder> implements VisitableBuilder<EnvoyFilter,EnvoyFilterBuilder>{

  EnvoyFilterFluent<?> fluent;

  public EnvoyFilterBuilder() {
    this(new EnvoyFilter());
  }
  
  public EnvoyFilterBuilder(EnvoyFilterFluent<?> fluent) {
    this(fluent, new EnvoyFilter());
  }
  
  public EnvoyFilterBuilder(EnvoyFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterBuilder(EnvoyFilterFluent<?> fluent,EnvoyFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilter build() {
    EnvoyFilter buildable = new EnvoyFilter(fluent.buildConfigPatches(), fluent.getPriority(), fluent.buildTargetRefs(), fluent.buildWorkloadSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
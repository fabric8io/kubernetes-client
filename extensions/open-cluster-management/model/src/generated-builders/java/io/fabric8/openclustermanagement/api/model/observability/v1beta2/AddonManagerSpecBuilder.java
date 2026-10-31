package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddonManagerSpecBuilder extends AddonManagerSpecFluent<AddonManagerSpecBuilder> implements VisitableBuilder<AddonManagerSpec,AddonManagerSpecBuilder>{

  AddonManagerSpecFluent<?> fluent;

  public AddonManagerSpecBuilder() {
    this(new AddonManagerSpec());
  }
  
  public AddonManagerSpecBuilder(AddonManagerSpecFluent<?> fluent) {
    this(fluent, new AddonManagerSpec());
  }
  
  public AddonManagerSpecBuilder(AddonManagerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddonManagerSpecBuilder(AddonManagerSpecFluent<?> fluent,AddonManagerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddonManagerSpec build() {
    AddonManagerSpec buildable = new AddonManagerSpec(fluent.getLogVerbosity(), fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
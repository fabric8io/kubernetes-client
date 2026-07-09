package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReferenceGrantSpecBuilder extends ReferenceGrantSpecFluent<ReferenceGrantSpecBuilder> implements VisitableBuilder<ReferenceGrantSpec,ReferenceGrantSpecBuilder>{

  ReferenceGrantSpecFluent<?> fluent;

  public ReferenceGrantSpecBuilder() {
    this(new ReferenceGrantSpec());
  }
  
  public ReferenceGrantSpecBuilder(ReferenceGrantSpecFluent<?> fluent) {
    this(fluent, new ReferenceGrantSpec());
  }
  
  public ReferenceGrantSpecBuilder(ReferenceGrantSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReferenceGrantSpecBuilder(ReferenceGrantSpecFluent<?> fluent,ReferenceGrantSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReferenceGrantSpec build() {
    ReferenceGrantSpec buildable = new ReferenceGrantSpec(fluent.buildFrom(), fluent.buildTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
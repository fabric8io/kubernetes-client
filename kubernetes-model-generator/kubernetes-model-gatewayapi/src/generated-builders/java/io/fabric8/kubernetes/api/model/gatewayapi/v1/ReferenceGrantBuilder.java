package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReferenceGrantBuilder extends ReferenceGrantFluent<ReferenceGrantBuilder> implements VisitableBuilder<ReferenceGrant,ReferenceGrantBuilder>{

  ReferenceGrantFluent<?> fluent;

  public ReferenceGrantBuilder() {
    this(new ReferenceGrant());
  }
  
  public ReferenceGrantBuilder(ReferenceGrantFluent<?> fluent) {
    this(fluent, new ReferenceGrant());
  }
  
  public ReferenceGrantBuilder(ReferenceGrant instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReferenceGrantBuilder(ReferenceGrantFluent<?> fluent,ReferenceGrant instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReferenceGrant build() {
    ReferenceGrant buildable = new ReferenceGrant(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
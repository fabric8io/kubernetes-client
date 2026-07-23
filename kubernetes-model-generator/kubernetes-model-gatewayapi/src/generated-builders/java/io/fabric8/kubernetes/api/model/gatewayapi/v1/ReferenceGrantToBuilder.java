package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReferenceGrantToBuilder extends ReferenceGrantToFluent<ReferenceGrantToBuilder> implements VisitableBuilder<ReferenceGrantTo,ReferenceGrantToBuilder>{

  ReferenceGrantToFluent<?> fluent;

  public ReferenceGrantToBuilder() {
    this(new ReferenceGrantTo());
  }
  
  public ReferenceGrantToBuilder(ReferenceGrantToFluent<?> fluent) {
    this(fluent, new ReferenceGrantTo());
  }
  
  public ReferenceGrantToBuilder(ReferenceGrantTo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReferenceGrantToBuilder(ReferenceGrantToFluent<?> fluent,ReferenceGrantTo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReferenceGrantTo build() {
    ReferenceGrantTo buildable = new ReferenceGrantTo(fluent.getGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
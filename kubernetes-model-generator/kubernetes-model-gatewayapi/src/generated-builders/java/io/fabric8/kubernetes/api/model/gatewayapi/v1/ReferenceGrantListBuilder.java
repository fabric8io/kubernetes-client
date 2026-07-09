package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReferenceGrantListBuilder extends ReferenceGrantListFluent<ReferenceGrantListBuilder> implements VisitableBuilder<ReferenceGrantList,ReferenceGrantListBuilder>{

  ReferenceGrantListFluent<?> fluent;

  public ReferenceGrantListBuilder() {
    this(new ReferenceGrantList());
  }
  
  public ReferenceGrantListBuilder(ReferenceGrantListFluent<?> fluent) {
    this(fluent, new ReferenceGrantList());
  }
  
  public ReferenceGrantListBuilder(ReferenceGrantList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReferenceGrantListBuilder(ReferenceGrantListFluent<?> fluent,ReferenceGrantList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReferenceGrantList build() {
    ReferenceGrantList buildable = new ReferenceGrantList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
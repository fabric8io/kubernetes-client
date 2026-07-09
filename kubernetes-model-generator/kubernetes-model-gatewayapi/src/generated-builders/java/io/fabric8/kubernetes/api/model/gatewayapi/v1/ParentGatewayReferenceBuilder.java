package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParentGatewayReferenceBuilder extends ParentGatewayReferenceFluent<ParentGatewayReferenceBuilder> implements VisitableBuilder<ParentGatewayReference,ParentGatewayReferenceBuilder>{

  ParentGatewayReferenceFluent<?> fluent;

  public ParentGatewayReferenceBuilder() {
    this(new ParentGatewayReference());
  }
  
  public ParentGatewayReferenceBuilder(ParentGatewayReferenceFluent<?> fluent) {
    this(fluent, new ParentGatewayReference());
  }
  
  public ParentGatewayReferenceBuilder(ParentGatewayReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParentGatewayReferenceBuilder(ParentGatewayReferenceFluent<?> fluent,ParentGatewayReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParentGatewayReference build() {
    ParentGatewayReference buildable = new ParentGatewayReference(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
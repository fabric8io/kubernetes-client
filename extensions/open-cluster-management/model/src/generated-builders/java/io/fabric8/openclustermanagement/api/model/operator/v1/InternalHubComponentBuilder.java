package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalHubComponentBuilder extends InternalHubComponentFluent<InternalHubComponentBuilder> implements VisitableBuilder<InternalHubComponent,InternalHubComponentBuilder>{

  InternalHubComponentFluent<?> fluent;

  public InternalHubComponentBuilder() {
    this(new InternalHubComponent());
  }
  
  public InternalHubComponentBuilder(InternalHubComponentFluent<?> fluent) {
    this(fluent, new InternalHubComponent());
  }
  
  public InternalHubComponentBuilder(InternalHubComponent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalHubComponentBuilder(InternalHubComponentFluent<?> fluent,InternalHubComponent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalHubComponent build() {
    InternalHubComponent buildable = new InternalHubComponent(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
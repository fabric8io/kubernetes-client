package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InternalHubComponentSpecBuilder extends InternalHubComponentSpecFluent<InternalHubComponentSpecBuilder> implements VisitableBuilder<InternalHubComponentSpec,InternalHubComponentSpecBuilder>{

  InternalHubComponentSpecFluent<?> fluent;

  public InternalHubComponentSpecBuilder() {
    this(new InternalHubComponentSpec());
  }
  
  public InternalHubComponentSpecBuilder(InternalHubComponentSpecFluent<?> fluent) {
    this(fluent, new InternalHubComponentSpec());
  }
  
  public InternalHubComponentSpecBuilder(InternalHubComponentSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InternalHubComponentSpecBuilder(InternalHubComponentSpecFluent<?> fluent,InternalHubComponentSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InternalHubComponentSpec build() {
    InternalHubComponentSpec buildable = new InternalHubComponentSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
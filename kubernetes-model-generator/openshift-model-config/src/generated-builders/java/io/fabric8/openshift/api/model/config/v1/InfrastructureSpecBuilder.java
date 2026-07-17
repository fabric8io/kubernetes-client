package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InfrastructureSpecBuilder extends InfrastructureSpecFluent<InfrastructureSpecBuilder> implements VisitableBuilder<InfrastructureSpec,InfrastructureSpecBuilder>{

  InfrastructureSpecFluent<?> fluent;

  public InfrastructureSpecBuilder() {
    this(new InfrastructureSpec());
  }
  
  public InfrastructureSpecBuilder(InfrastructureSpecFluent<?> fluent) {
    this(fluent, new InfrastructureSpec());
  }
  
  public InfrastructureSpecBuilder(InfrastructureSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InfrastructureSpecBuilder(InfrastructureSpecFluent<?> fluent,InfrastructureSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InfrastructureSpec build() {
    InfrastructureSpec buildable = new InfrastructureSpec(fluent.buildCloudConfig(), fluent.buildPlatformSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
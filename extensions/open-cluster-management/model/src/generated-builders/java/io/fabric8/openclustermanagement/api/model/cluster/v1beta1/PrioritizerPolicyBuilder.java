package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrioritizerPolicyBuilder extends PrioritizerPolicyFluent<PrioritizerPolicyBuilder> implements VisitableBuilder<PrioritizerPolicy,PrioritizerPolicyBuilder>{

  PrioritizerPolicyFluent<?> fluent;

  public PrioritizerPolicyBuilder() {
    this(new PrioritizerPolicy());
  }
  
  public PrioritizerPolicyBuilder(PrioritizerPolicyFluent<?> fluent) {
    this(fluent, new PrioritizerPolicy());
  }
  
  public PrioritizerPolicyBuilder(PrioritizerPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrioritizerPolicyBuilder(PrioritizerPolicyFluent<?> fluent,PrioritizerPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrioritizerPolicy build() {
    PrioritizerPolicy buildable = new PrioritizerPolicy(fluent.buildConfigurations(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
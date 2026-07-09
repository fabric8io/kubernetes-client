package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BackendTLSPolicySpecBuilder extends BackendTLSPolicySpecFluent<BackendTLSPolicySpecBuilder> implements VisitableBuilder<BackendTLSPolicySpec,BackendTLSPolicySpecBuilder>{

  BackendTLSPolicySpecFluent<?> fluent;

  public BackendTLSPolicySpecBuilder() {
    this(new BackendTLSPolicySpec());
  }
  
  public BackendTLSPolicySpecBuilder(BackendTLSPolicySpecFluent<?> fluent) {
    this(fluent, new BackendTLSPolicySpec());
  }
  
  public BackendTLSPolicySpecBuilder(BackendTLSPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BackendTLSPolicySpecBuilder(BackendTLSPolicySpecFluent<?> fluent,BackendTLSPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BackendTLSPolicySpec build() {
    BackendTLSPolicySpec buildable = new BackendTLSPolicySpec(fluent.getOptions(), fluent.buildTargetRefs(), fluent.buildValidation());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
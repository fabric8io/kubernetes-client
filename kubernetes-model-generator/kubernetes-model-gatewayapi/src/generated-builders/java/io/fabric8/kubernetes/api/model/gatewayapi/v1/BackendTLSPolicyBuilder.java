package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BackendTLSPolicyBuilder extends BackendTLSPolicyFluent<BackendTLSPolicyBuilder> implements VisitableBuilder<BackendTLSPolicy,BackendTLSPolicyBuilder>{

  BackendTLSPolicyFluent<?> fluent;

  public BackendTLSPolicyBuilder() {
    this(new BackendTLSPolicy());
  }
  
  public BackendTLSPolicyBuilder(BackendTLSPolicyFluent<?> fluent) {
    this(fluent, new BackendTLSPolicy());
  }
  
  public BackendTLSPolicyBuilder(BackendTLSPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BackendTLSPolicyBuilder(BackendTLSPolicyFluent<?> fluent,BackendTLSPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BackendTLSPolicy build() {
    BackendTLSPolicy buildable = new BackendTLSPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
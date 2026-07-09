package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BackendTLSPolicyListBuilder extends BackendTLSPolicyListFluent<BackendTLSPolicyListBuilder> implements VisitableBuilder<BackendTLSPolicyList,BackendTLSPolicyListBuilder>{

  BackendTLSPolicyListFluent<?> fluent;

  public BackendTLSPolicyListBuilder() {
    this(new BackendTLSPolicyList());
  }
  
  public BackendTLSPolicyListBuilder(BackendTLSPolicyListFluent<?> fluent) {
    this(fluent, new BackendTLSPolicyList());
  }
  
  public BackendTLSPolicyListBuilder(BackendTLSPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BackendTLSPolicyListBuilder(BackendTLSPolicyListFluent<?> fluent,BackendTLSPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BackendTLSPolicyList build() {
    BackendTLSPolicyList buildable = new BackendTLSPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
package io.fabric8.istio.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthorizationPolicyListBuilder extends AuthorizationPolicyListFluent<AuthorizationPolicyListBuilder> implements VisitableBuilder<AuthorizationPolicyList,AuthorizationPolicyListBuilder>{

  AuthorizationPolicyListFluent<?> fluent;

  public AuthorizationPolicyListBuilder() {
    this(new AuthorizationPolicyList());
  }
  
  public AuthorizationPolicyListBuilder(AuthorizationPolicyListFluent<?> fluent) {
    this(fluent, new AuthorizationPolicyList());
  }
  
  public AuthorizationPolicyListBuilder(AuthorizationPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthorizationPolicyListBuilder(AuthorizationPolicyListFluent<?> fluent,AuthorizationPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthorizationPolicyList build() {
    AuthorizationPolicyList buildable = new AuthorizationPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
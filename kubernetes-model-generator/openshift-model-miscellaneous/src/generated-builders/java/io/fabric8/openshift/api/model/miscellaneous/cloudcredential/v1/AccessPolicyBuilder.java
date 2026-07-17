package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AccessPolicyBuilder extends AccessPolicyFluent<AccessPolicyBuilder> implements VisitableBuilder<AccessPolicy,AccessPolicyBuilder>{

  AccessPolicyFluent<?> fluent;

  public AccessPolicyBuilder() {
    this(new AccessPolicy());
  }
  
  public AccessPolicyBuilder(AccessPolicyFluent<?> fluent) {
    this(fluent, new AccessPolicy());
  }
  
  public AccessPolicyBuilder(AccessPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AccessPolicyBuilder(AccessPolicyFluent<?> fluent,AccessPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AccessPolicy build() {
    AccessPolicy buildable = new AccessPolicy(fluent.buildAttributes(), fluent.getRoles());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
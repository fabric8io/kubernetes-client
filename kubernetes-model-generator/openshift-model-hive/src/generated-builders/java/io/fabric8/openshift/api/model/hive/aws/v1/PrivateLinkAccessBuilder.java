package io.fabric8.openshift.api.model.hive.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrivateLinkAccessBuilder extends PrivateLinkAccessFluent<PrivateLinkAccessBuilder> implements VisitableBuilder<PrivateLinkAccess,PrivateLinkAccessBuilder>{

  PrivateLinkAccessFluent<?> fluent;

  public PrivateLinkAccessBuilder() {
    this(new PrivateLinkAccess());
  }
  
  public PrivateLinkAccessBuilder(PrivateLinkAccessFluent<?> fluent) {
    this(fluent, new PrivateLinkAccess());
  }
  
  public PrivateLinkAccessBuilder(PrivateLinkAccess instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrivateLinkAccessBuilder(PrivateLinkAccessFluent<?> fluent,PrivateLinkAccess instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrivateLinkAccess build() {
    PrivateLinkAccess buildable = new PrivateLinkAccess(fluent.getAdditionalAllowedPrincipals(), fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
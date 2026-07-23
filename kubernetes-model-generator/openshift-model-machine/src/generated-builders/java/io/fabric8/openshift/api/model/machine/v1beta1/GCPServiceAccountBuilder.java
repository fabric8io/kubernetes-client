package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPServiceAccountBuilder extends GCPServiceAccountFluent<GCPServiceAccountBuilder> implements VisitableBuilder<GCPServiceAccount,GCPServiceAccountBuilder>{

  GCPServiceAccountFluent<?> fluent;

  public GCPServiceAccountBuilder() {
    this(new GCPServiceAccount());
  }
  
  public GCPServiceAccountBuilder(GCPServiceAccountFluent<?> fluent) {
    this(fluent, new GCPServiceAccount());
  }
  
  public GCPServiceAccountBuilder(GCPServiceAccount instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPServiceAccountBuilder(GCPServiceAccountFluent<?> fluent,GCPServiceAccount instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPServiceAccount build() {
    GCPServiceAccount buildable = new GCPServiceAccount(fluent.getEmail(), fluent.getScopes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
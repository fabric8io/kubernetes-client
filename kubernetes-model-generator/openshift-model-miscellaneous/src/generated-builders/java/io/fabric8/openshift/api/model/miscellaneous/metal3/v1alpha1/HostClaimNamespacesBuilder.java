package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostClaimNamespacesBuilder extends HostClaimNamespacesFluent<HostClaimNamespacesBuilder> implements VisitableBuilder<HostClaimNamespaces,HostClaimNamespacesBuilder>{

  HostClaimNamespacesFluent<?> fluent;

  public HostClaimNamespacesBuilder() {
    this(new HostClaimNamespaces());
  }
  
  public HostClaimNamespacesBuilder(HostClaimNamespacesFluent<?> fluent) {
    this(fluent, new HostClaimNamespaces());
  }
  
  public HostClaimNamespacesBuilder(HostClaimNamespaces instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostClaimNamespacesBuilder(HostClaimNamespacesFluent<?> fluent,HostClaimNamespaces instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostClaimNamespaces build() {
    HostClaimNamespaces buildable = new HostClaimNamespaces(fluent.buildHasLabels(), fluent.getNameMatches(), fluent.getNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
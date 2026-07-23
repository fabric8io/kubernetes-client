package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPProviderStatusBuilder extends GCPProviderStatusFluent<GCPProviderStatusBuilder> implements VisitableBuilder<GCPProviderStatus,GCPProviderStatusBuilder>{

  GCPProviderStatusFluent<?> fluent;

  public GCPProviderStatusBuilder() {
    this(new GCPProviderStatus());
  }
  
  public GCPProviderStatusBuilder(GCPProviderStatusFluent<?> fluent) {
    this(fluent, new GCPProviderStatus());
  }
  
  public GCPProviderStatusBuilder(GCPProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPProviderStatusBuilder(GCPProviderStatusFluent<?> fluent,GCPProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPProviderStatus build() {
    GCPProviderStatus buildable = new GCPProviderStatus(fluent.getApiVersion(), fluent.getKind(), fluent.getRoleID(), fluent.getServiceAccountID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
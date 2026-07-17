package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPProviderSpecBuilder extends GCPProviderSpecFluent<GCPProviderSpecBuilder> implements VisitableBuilder<GCPProviderSpec,GCPProviderSpecBuilder>{

  GCPProviderSpecFluent<?> fluent;

  public GCPProviderSpecBuilder() {
    this(new GCPProviderSpec());
  }
  
  public GCPProviderSpecBuilder(GCPProviderSpecFluent<?> fluent) {
    this(fluent, new GCPProviderSpec());
  }
  
  public GCPProviderSpecBuilder(GCPProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPProviderSpecBuilder(GCPProviderSpecFluent<?> fluent,GCPProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPProviderSpec build() {
    GCPProviderSpec buildable = new GCPProviderSpec(fluent.getApiVersion(), fluent.getAudience(), fluent.getKind(), fluent.getPermissions(), fluent.getPredefinedRoles(), fluent.getServiceAccountEmail(), fluent.getSkipServiceCheck());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
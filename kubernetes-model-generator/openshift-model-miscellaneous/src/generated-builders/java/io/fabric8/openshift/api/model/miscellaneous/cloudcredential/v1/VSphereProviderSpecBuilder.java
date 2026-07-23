package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereProviderSpecBuilder extends VSphereProviderSpecFluent<VSphereProviderSpecBuilder> implements VisitableBuilder<VSphereProviderSpec,VSphereProviderSpecBuilder>{

  VSphereProviderSpecFluent<?> fluent;

  public VSphereProviderSpecBuilder() {
    this(new VSphereProviderSpec());
  }
  
  public VSphereProviderSpecBuilder(VSphereProviderSpecFluent<?> fluent) {
    this(fluent, new VSphereProviderSpec());
  }
  
  public VSphereProviderSpecBuilder(VSphereProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereProviderSpecBuilder(VSphereProviderSpecFluent<?> fluent,VSphereProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereProviderSpec build() {
    VSphereProviderSpec buildable = new VSphereProviderSpec(fluent.getApiVersion(), fluent.getKind(), fluent.buildPermissions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
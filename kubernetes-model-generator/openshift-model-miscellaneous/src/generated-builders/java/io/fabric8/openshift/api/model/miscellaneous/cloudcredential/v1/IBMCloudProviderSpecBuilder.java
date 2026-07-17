package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMCloudProviderSpecBuilder extends IBMCloudProviderSpecFluent<IBMCloudProviderSpecBuilder> implements VisitableBuilder<IBMCloudProviderSpec,IBMCloudProviderSpecBuilder>{

  IBMCloudProviderSpecFluent<?> fluent;

  public IBMCloudProviderSpecBuilder() {
    this(new IBMCloudProviderSpec());
  }
  
  public IBMCloudProviderSpecBuilder(IBMCloudProviderSpecFluent<?> fluent) {
    this(fluent, new IBMCloudProviderSpec());
  }
  
  public IBMCloudProviderSpecBuilder(IBMCloudProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMCloudProviderSpecBuilder(IBMCloudProviderSpecFluent<?> fluent,IBMCloudProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMCloudProviderSpec build() {
    IBMCloudProviderSpec buildable = new IBMCloudProviderSpec(fluent.getApiVersion(), fluent.getKind(), fluent.buildPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
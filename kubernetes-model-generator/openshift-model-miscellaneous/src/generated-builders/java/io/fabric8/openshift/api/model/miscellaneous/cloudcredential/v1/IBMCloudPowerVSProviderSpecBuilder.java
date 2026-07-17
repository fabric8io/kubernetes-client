package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMCloudPowerVSProviderSpecBuilder extends IBMCloudPowerVSProviderSpecFluent<IBMCloudPowerVSProviderSpecBuilder> implements VisitableBuilder<IBMCloudPowerVSProviderSpec,IBMCloudPowerVSProviderSpecBuilder>{

  IBMCloudPowerVSProviderSpecFluent<?> fluent;

  public IBMCloudPowerVSProviderSpecBuilder() {
    this(new IBMCloudPowerVSProviderSpec());
  }
  
  public IBMCloudPowerVSProviderSpecBuilder(IBMCloudPowerVSProviderSpecFluent<?> fluent) {
    this(fluent, new IBMCloudPowerVSProviderSpec());
  }
  
  public IBMCloudPowerVSProviderSpecBuilder(IBMCloudPowerVSProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMCloudPowerVSProviderSpecBuilder(IBMCloudPowerVSProviderSpecFluent<?> fluent,IBMCloudPowerVSProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMCloudPowerVSProviderSpec build() {
    IBMCloudPowerVSProviderSpec buildable = new IBMCloudPowerVSProviderSpec(fluent.getApiVersion(), fluent.getKind(), fluent.buildPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
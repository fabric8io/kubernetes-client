package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMCloudPowerVSProviderStatusBuilder extends IBMCloudPowerVSProviderStatusFluent<IBMCloudPowerVSProviderStatusBuilder> implements VisitableBuilder<IBMCloudPowerVSProviderStatus,IBMCloudPowerVSProviderStatusBuilder>{

  IBMCloudPowerVSProviderStatusFluent<?> fluent;

  public IBMCloudPowerVSProviderStatusBuilder() {
    this(new IBMCloudPowerVSProviderStatus());
  }
  
  public IBMCloudPowerVSProviderStatusBuilder(IBMCloudPowerVSProviderStatusFluent<?> fluent) {
    this(fluent, new IBMCloudPowerVSProviderStatus());
  }
  
  public IBMCloudPowerVSProviderStatusBuilder(IBMCloudPowerVSProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMCloudPowerVSProviderStatusBuilder(IBMCloudPowerVSProviderStatusFluent<?> fluent,IBMCloudPowerVSProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMCloudPowerVSProviderStatus build() {
    IBMCloudPowerVSProviderStatus buildable = new IBMCloudPowerVSProviderStatus(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
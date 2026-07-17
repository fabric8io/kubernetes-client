package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMCloudProviderStatusBuilder extends IBMCloudProviderStatusFluent<IBMCloudProviderStatusBuilder> implements VisitableBuilder<IBMCloudProviderStatus,IBMCloudProviderStatusBuilder>{

  IBMCloudProviderStatusFluent<?> fluent;

  public IBMCloudProviderStatusBuilder() {
    this(new IBMCloudProviderStatus());
  }
  
  public IBMCloudProviderStatusBuilder(IBMCloudProviderStatusFluent<?> fluent) {
    this(fluent, new IBMCloudProviderStatus());
  }
  
  public IBMCloudProviderStatusBuilder(IBMCloudProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMCloudProviderStatusBuilder(IBMCloudProviderStatusFluent<?> fluent,IBMCloudProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMCloudProviderStatus build() {
    IBMCloudProviderStatus buildable = new IBMCloudProviderStatus(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
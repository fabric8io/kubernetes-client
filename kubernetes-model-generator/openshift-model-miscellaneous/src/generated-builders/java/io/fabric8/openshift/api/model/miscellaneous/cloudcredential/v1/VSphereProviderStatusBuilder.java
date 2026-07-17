package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereProviderStatusBuilder extends VSphereProviderStatusFluent<VSphereProviderStatusBuilder> implements VisitableBuilder<VSphereProviderStatus,VSphereProviderStatusBuilder>{

  VSphereProviderStatusFluent<?> fluent;

  public VSphereProviderStatusBuilder() {
    this(new VSphereProviderStatus());
  }
  
  public VSphereProviderStatusBuilder(VSphereProviderStatusFluent<?> fluent) {
    this(fluent, new VSphereProviderStatus());
  }
  
  public VSphereProviderStatusBuilder(VSphereProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereProviderStatusBuilder(VSphereProviderStatusFluent<?> fluent,VSphereProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereProviderStatus build() {
    VSphereProviderStatus buildable = new VSphereProviderStatus(fluent.getApiVersion(), fluent.getKind(), fluent.getSecretLastResourceVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
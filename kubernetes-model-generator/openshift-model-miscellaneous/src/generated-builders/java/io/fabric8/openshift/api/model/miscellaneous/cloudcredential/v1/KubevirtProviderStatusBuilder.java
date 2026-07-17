package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubevirtProviderStatusBuilder extends KubevirtProviderStatusFluent<KubevirtProviderStatusBuilder> implements VisitableBuilder<KubevirtProviderStatus,KubevirtProviderStatusBuilder>{

  KubevirtProviderStatusFluent<?> fluent;

  public KubevirtProviderStatusBuilder() {
    this(new KubevirtProviderStatus());
  }
  
  public KubevirtProviderStatusBuilder(KubevirtProviderStatusFluent<?> fluent) {
    this(fluent, new KubevirtProviderStatus());
  }
  
  public KubevirtProviderStatusBuilder(KubevirtProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubevirtProviderStatusBuilder(KubevirtProviderStatusFluent<?> fluent,KubevirtProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubevirtProviderStatus build() {
    KubevirtProviderStatus buildable = new KubevirtProviderStatus(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
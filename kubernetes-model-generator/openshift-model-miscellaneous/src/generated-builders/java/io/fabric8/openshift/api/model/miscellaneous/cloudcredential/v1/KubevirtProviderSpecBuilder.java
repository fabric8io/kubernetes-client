package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubevirtProviderSpecBuilder extends KubevirtProviderSpecFluent<KubevirtProviderSpecBuilder> implements VisitableBuilder<KubevirtProviderSpec,KubevirtProviderSpecBuilder>{

  KubevirtProviderSpecFluent<?> fluent;

  public KubevirtProviderSpecBuilder() {
    this(new KubevirtProviderSpec());
  }
  
  public KubevirtProviderSpecBuilder(KubevirtProviderSpecFluent<?> fluent) {
    this(fluent, new KubevirtProviderSpec());
  }
  
  public KubevirtProviderSpecBuilder(KubevirtProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubevirtProviderSpecBuilder(KubevirtProviderSpecFluent<?> fluent,KubevirtProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubevirtProviderSpec build() {
    KubevirtProviderSpec buildable = new KubevirtProviderSpec(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
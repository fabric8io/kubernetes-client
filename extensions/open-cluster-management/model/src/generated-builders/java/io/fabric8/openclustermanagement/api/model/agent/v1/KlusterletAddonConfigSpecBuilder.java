package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletAddonConfigSpecBuilder extends KlusterletAddonConfigSpecFluent<KlusterletAddonConfigSpecBuilder> implements VisitableBuilder<KlusterletAddonConfigSpec,KlusterletAddonConfigSpecBuilder>{

  KlusterletAddonConfigSpecFluent<?> fluent;

  public KlusterletAddonConfigSpecBuilder() {
    this(new KlusterletAddonConfigSpec());
  }
  
  public KlusterletAddonConfigSpecBuilder(KlusterletAddonConfigSpecFluent<?> fluent) {
    this(fluent, new KlusterletAddonConfigSpec());
  }
  
  public KlusterletAddonConfigSpecBuilder(KlusterletAddonConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletAddonConfigSpecBuilder(KlusterletAddonConfigSpecFluent<?> fluent,KlusterletAddonConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KlusterletAddonConfigSpec build() {
    KlusterletAddonConfigSpec buildable = new KlusterletAddonConfigSpec(fluent.buildApplicationManager(), fluent.buildCertPolicyController(), fluent.getClusterLabels(), fluent.getClusterName(), fluent.getClusterNamespace(), fluent.buildIamPolicyController(), fluent.buildPolicyController(), fluent.buildProxyConfig(), fluent.buildSearchCollector(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
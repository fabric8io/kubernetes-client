package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletAddonAgentConfigSpecBuilder extends KlusterletAddonAgentConfigSpecFluent<KlusterletAddonAgentConfigSpecBuilder> implements VisitableBuilder<KlusterletAddonAgentConfigSpec,KlusterletAddonAgentConfigSpecBuilder>{

  KlusterletAddonAgentConfigSpecFluent<?> fluent;

  public KlusterletAddonAgentConfigSpecBuilder() {
    this(new KlusterletAddonAgentConfigSpec());
  }
  
  public KlusterletAddonAgentConfigSpecBuilder(KlusterletAddonAgentConfigSpecFluent<?> fluent) {
    this(fluent, new KlusterletAddonAgentConfigSpec());
  }
  
  public KlusterletAddonAgentConfigSpecBuilder(KlusterletAddonAgentConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletAddonAgentConfigSpecBuilder(KlusterletAddonAgentConfigSpecFluent<?> fluent,KlusterletAddonAgentConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KlusterletAddonAgentConfigSpec build() {
    KlusterletAddonAgentConfigSpec buildable = new KlusterletAddonAgentConfigSpec(fluent.getEnabled(), fluent.getProxyPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
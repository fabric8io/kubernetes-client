package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddonAgentConfigBuilder extends AddonAgentConfigFluent<AddonAgentConfigBuilder> implements VisitableBuilder<AddonAgentConfig,AddonAgentConfigBuilder>{

  AddonAgentConfigFluent<?> fluent;

  public AddonAgentConfigBuilder() {
    this(new AddonAgentConfig());
  }
  
  public AddonAgentConfigBuilder(AddonAgentConfigFluent<?> fluent) {
    this(fluent, new AddonAgentConfig());
  }
  
  public AddonAgentConfigBuilder(AddonAgentConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddonAgentConfigBuilder(AddonAgentConfigFluent<?> fluent,AddonAgentConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddonAgentConfig build() {
    AddonAgentConfig buildable = new AddonAgentConfig(fluent.getImagePullPolicy(), fluent.getImagePullSecret(), fluent.getImagePullSecretNamespace(), fluent.buildKlusterletAddonConfig(), fluent.buildManagedCluster(), fluent.getNodeSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
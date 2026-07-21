package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletAddonConfigBuilder extends KlusterletAddonConfigFluent<KlusterletAddonConfigBuilder> implements VisitableBuilder<KlusterletAddonConfig,KlusterletAddonConfigBuilder>{

  KlusterletAddonConfigFluent<?> fluent;

  public KlusterletAddonConfigBuilder() {
    this(new KlusterletAddonConfig());
  }
  
  public KlusterletAddonConfigBuilder(KlusterletAddonConfigFluent<?> fluent) {
    this(fluent, new KlusterletAddonConfig());
  }
  
  public KlusterletAddonConfigBuilder(KlusterletAddonConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletAddonConfigBuilder(KlusterletAddonConfigFluent<?> fluent,KlusterletAddonConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KlusterletAddonConfig build() {
    KlusterletAddonConfig buildable = new KlusterletAddonConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
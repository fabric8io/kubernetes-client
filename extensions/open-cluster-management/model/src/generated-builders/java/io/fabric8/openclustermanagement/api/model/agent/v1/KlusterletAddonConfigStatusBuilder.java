package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletAddonConfigStatusBuilder extends KlusterletAddonConfigStatusFluent<KlusterletAddonConfigStatusBuilder> implements VisitableBuilder<KlusterletAddonConfigStatus,KlusterletAddonConfigStatusBuilder>{

  KlusterletAddonConfigStatusFluent<?> fluent;

  public KlusterletAddonConfigStatusBuilder() {
    this(new KlusterletAddonConfigStatus());
  }
  
  public KlusterletAddonConfigStatusBuilder(KlusterletAddonConfigStatusFluent<?> fluent) {
    this(fluent, new KlusterletAddonConfigStatus());
  }
  
  public KlusterletAddonConfigStatusBuilder(KlusterletAddonConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletAddonConfigStatusBuilder(KlusterletAddonConfigStatusFluent<?> fluent,KlusterletAddonConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KlusterletAddonConfigStatus build() {
    KlusterletAddonConfigStatus buildable = new KlusterletAddonConfigStatus(fluent.getConditions(), fluent.buildOcpGlobalProxy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
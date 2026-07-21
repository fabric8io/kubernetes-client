package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletAddonConfigListBuilder extends KlusterletAddonConfigListFluent<KlusterletAddonConfigListBuilder> implements VisitableBuilder<KlusterletAddonConfigList,KlusterletAddonConfigListBuilder>{

  KlusterletAddonConfigListFluent<?> fluent;

  public KlusterletAddonConfigListBuilder() {
    this(new KlusterletAddonConfigList());
  }
  
  public KlusterletAddonConfigListBuilder(KlusterletAddonConfigListFluent<?> fluent) {
    this(fluent, new KlusterletAddonConfigList());
  }
  
  public KlusterletAddonConfigListBuilder(KlusterletAddonConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletAddonConfigListBuilder(KlusterletAddonConfigListFluent<?> fluent,KlusterletAddonConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KlusterletAddonConfigList build() {
    KlusterletAddonConfigList buildable = new KlusterletAddonConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
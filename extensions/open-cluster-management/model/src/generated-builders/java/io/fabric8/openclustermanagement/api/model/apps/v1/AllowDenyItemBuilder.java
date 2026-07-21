package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllowDenyItemBuilder extends AllowDenyItemFluent<AllowDenyItemBuilder> implements VisitableBuilder<AllowDenyItem,AllowDenyItemBuilder>{

  AllowDenyItemFluent<?> fluent;

  public AllowDenyItemBuilder() {
    this(new AllowDenyItem());
  }
  
  public AllowDenyItemBuilder(AllowDenyItemFluent<?> fluent) {
    this(fluent, new AllowDenyItem());
  }
  
  public AllowDenyItemBuilder(AllowDenyItem instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllowDenyItemBuilder(AllowDenyItemFluent<?> fluent,AllowDenyItem instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllowDenyItem build() {
    AllowDenyItem buildable = new AllowDenyItem(fluent.getApiVersion(), fluent.getKinds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
package io.fabric8.istio.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvoyFilterListBuilder extends EnvoyFilterListFluent<EnvoyFilterListBuilder> implements VisitableBuilder<EnvoyFilterList,EnvoyFilterListBuilder>{

  EnvoyFilterListFluent<?> fluent;

  public EnvoyFilterListBuilder() {
    this(new EnvoyFilterList());
  }
  
  public EnvoyFilterListBuilder(EnvoyFilterListFluent<?> fluent) {
    this(fluent, new EnvoyFilterList());
  }
  
  public EnvoyFilterListBuilder(EnvoyFilterList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvoyFilterListBuilder(EnvoyFilterListFluent<?> fluent,EnvoyFilterList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvoyFilterList build() {
    EnvoyFilterList buildable = new EnvoyFilterList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
package io.fabric8.istio.api.networking.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProxyConfigListBuilder extends ProxyConfigListFluent<ProxyConfigListBuilder> implements VisitableBuilder<ProxyConfigList,ProxyConfigListBuilder>{

  ProxyConfigListFluent<?> fluent;

  public ProxyConfigListBuilder() {
    this(new ProxyConfigList());
  }
  
  public ProxyConfigListBuilder(ProxyConfigListFluent<?> fluent) {
    this(fluent, new ProxyConfigList());
  }
  
  public ProxyConfigListBuilder(ProxyConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProxyConfigListBuilder(ProxyConfigListFluent<?> fluent,ProxyConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProxyConfigList build() {
    ProxyConfigList buildable = new ProxyConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
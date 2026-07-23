package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProxyListBuilder extends ProxyListFluent<ProxyListBuilder> implements VisitableBuilder<ProxyList,ProxyListBuilder>{

  ProxyListFluent<?> fluent;

  public ProxyListBuilder() {
    this(new ProxyList());
  }
  
  public ProxyListBuilder(ProxyListFluent<?> fluent) {
    this(fluent, new ProxyList());
  }
  
  public ProxyListBuilder(ProxyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProxyListBuilder(ProxyListFluent<?> fluent,ProxyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProxyList build() {
    ProxyList buildable = new ProxyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
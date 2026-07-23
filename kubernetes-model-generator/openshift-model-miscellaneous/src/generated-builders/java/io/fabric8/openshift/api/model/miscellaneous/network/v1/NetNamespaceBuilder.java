package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetNamespaceBuilder extends NetNamespaceFluent<NetNamespaceBuilder> implements VisitableBuilder<NetNamespace,NetNamespaceBuilder>{

  NetNamespaceFluent<?> fluent;

  public NetNamespaceBuilder() {
    this(new NetNamespace());
  }
  
  public NetNamespaceBuilder(NetNamespaceFluent<?> fluent) {
    this(fluent, new NetNamespace());
  }
  
  public NetNamespaceBuilder(NetNamespace instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetNamespaceBuilder(NetNamespaceFluent<?> fluent,NetNamespace instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetNamespace build() {
    NetNamespace buildable = new NetNamespace(fluent.getApiVersion(), fluent.getEgressIPs(), fluent.getKind(), fluent.buildMetadata(), fluent.getNetid(), fluent.getNetname());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
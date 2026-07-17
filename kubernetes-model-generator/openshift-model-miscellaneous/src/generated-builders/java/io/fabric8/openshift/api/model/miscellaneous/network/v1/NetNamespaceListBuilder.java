package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetNamespaceListBuilder extends NetNamespaceListFluent<NetNamespaceListBuilder> implements VisitableBuilder<NetNamespaceList,NetNamespaceListBuilder>{

  NetNamespaceListFluent<?> fluent;

  public NetNamespaceListBuilder() {
    this(new NetNamespaceList());
  }
  
  public NetNamespaceListBuilder(NetNamespaceListFluent<?> fluent) {
    this(fluent, new NetNamespaceList());
  }
  
  public NetNamespaceListBuilder(NetNamespaceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetNamespaceListBuilder(NetNamespaceListFluent<?> fluent,NetNamespaceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetNamespaceList build() {
    NetNamespaceList buildable = new NetNamespaceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdBuilder extends EtcdFluent<EtcdBuilder> implements VisitableBuilder<Etcd,EtcdBuilder>{

  EtcdFluent<?> fluent;

  public EtcdBuilder() {
    this(new Etcd());
  }
  
  public EtcdBuilder(EtcdFluent<?> fluent) {
    this(fluent, new Etcd());
  }
  
  public EtcdBuilder(Etcd instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdBuilder(EtcdFluent<?> fluent,Etcd instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Etcd build() {
    Etcd buildable = new Etcd(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
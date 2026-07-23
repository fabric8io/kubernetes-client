package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdListBuilder extends EtcdListFluent<EtcdListBuilder> implements VisitableBuilder<EtcdList,EtcdListBuilder>{

  EtcdListFluent<?> fluent;

  public EtcdListBuilder() {
    this(new EtcdList());
  }
  
  public EtcdListBuilder(EtcdListFluent<?> fluent) {
    this(fluent, new EtcdList());
  }
  
  public EtcdListBuilder(EtcdList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdListBuilder(EtcdListFluent<?> fluent,EtcdList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EtcdList build() {
    EtcdList buildable = new EtcdList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
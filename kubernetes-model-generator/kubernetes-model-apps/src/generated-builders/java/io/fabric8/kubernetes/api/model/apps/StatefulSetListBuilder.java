package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatefulSetListBuilder extends StatefulSetListFluent<StatefulSetListBuilder> implements VisitableBuilder<StatefulSetList,StatefulSetListBuilder>{

  StatefulSetListFluent<?> fluent;

  public StatefulSetListBuilder() {
    this(new StatefulSetList());
  }
  
  public StatefulSetListBuilder(StatefulSetListFluent<?> fluent) {
    this(fluent, new StatefulSetList());
  }
  
  public StatefulSetListBuilder(StatefulSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatefulSetListBuilder(StatefulSetListFluent<?> fluent,StatefulSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatefulSetList build() {
    StatefulSetList buildable = new StatefulSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
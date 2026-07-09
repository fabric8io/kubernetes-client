package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatefulSetBuilder extends StatefulSetFluent<StatefulSetBuilder> implements VisitableBuilder<StatefulSet,StatefulSetBuilder>{

  StatefulSetFluent<?> fluent;

  public StatefulSetBuilder() {
    this(new StatefulSet());
  }
  
  public StatefulSetBuilder(StatefulSetFluent<?> fluent) {
    this(fluent, new StatefulSet());
  }
  
  public StatefulSetBuilder(StatefulSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatefulSetBuilder(StatefulSetFluent<?> fluent,StatefulSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatefulSet build() {
    StatefulSet buildable = new StatefulSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
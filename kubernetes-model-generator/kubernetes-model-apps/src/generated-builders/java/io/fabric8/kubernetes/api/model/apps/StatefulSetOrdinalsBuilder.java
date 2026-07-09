package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatefulSetOrdinalsBuilder extends StatefulSetOrdinalsFluent<StatefulSetOrdinalsBuilder> implements VisitableBuilder<StatefulSetOrdinals,StatefulSetOrdinalsBuilder>{

  StatefulSetOrdinalsFluent<?> fluent;

  public StatefulSetOrdinalsBuilder() {
    this(new StatefulSetOrdinals());
  }
  
  public StatefulSetOrdinalsBuilder(StatefulSetOrdinalsFluent<?> fluent) {
    this(fluent, new StatefulSetOrdinals());
  }
  
  public StatefulSetOrdinalsBuilder(StatefulSetOrdinals instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatefulSetOrdinalsBuilder(StatefulSetOrdinalsFluent<?> fluent,StatefulSetOrdinals instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatefulSetOrdinals build() {
    StatefulSetOrdinals buildable = new StatefulSetOrdinals(fluent.getStart());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
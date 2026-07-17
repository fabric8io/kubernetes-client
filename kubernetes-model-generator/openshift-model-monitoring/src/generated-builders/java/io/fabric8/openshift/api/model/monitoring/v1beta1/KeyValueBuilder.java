package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KeyValueBuilder extends KeyValueFluent<KeyValueBuilder> implements VisitableBuilder<KeyValue,KeyValueBuilder>{

  KeyValueFluent<?> fluent;

  public KeyValueBuilder() {
    this(new KeyValue());
  }
  
  public KeyValueBuilder(KeyValueFluent<?> fluent) {
    this(fluent, new KeyValue());
  }
  
  public KeyValueBuilder(KeyValue instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KeyValueBuilder(KeyValueFluent<?> fluent,KeyValue instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KeyValue build() {
    KeyValue buildable = new KeyValue(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
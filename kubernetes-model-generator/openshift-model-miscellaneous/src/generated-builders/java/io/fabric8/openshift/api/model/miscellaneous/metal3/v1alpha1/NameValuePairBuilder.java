package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NameValuePairBuilder extends NameValuePairFluent<NameValuePairBuilder> implements VisitableBuilder<NameValuePair,NameValuePairBuilder>{

  NameValuePairFluent<?> fluent;

  public NameValuePairBuilder() {
    this(new NameValuePair());
  }
  
  public NameValuePairBuilder(NameValuePairFluent<?> fluent) {
    this(fluent, new NameValuePair());
  }
  
  public NameValuePairBuilder(NameValuePair instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NameValuePairBuilder(NameValuePairFluent<?> fluent,NameValuePair instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NameValuePair build() {
    NameValuePair buildable = new NameValuePair(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
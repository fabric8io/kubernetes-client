package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PerUserAPIRequestCountBuilder extends PerUserAPIRequestCountFluent<PerUserAPIRequestCountBuilder> implements VisitableBuilder<PerUserAPIRequestCount,PerUserAPIRequestCountBuilder>{

  PerUserAPIRequestCountFluent<?> fluent;

  public PerUserAPIRequestCountBuilder() {
    this(new PerUserAPIRequestCount());
  }
  
  public PerUserAPIRequestCountBuilder(PerUserAPIRequestCountFluent<?> fluent) {
    this(fluent, new PerUserAPIRequestCount());
  }
  
  public PerUserAPIRequestCountBuilder(PerUserAPIRequestCount instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PerUserAPIRequestCountBuilder(PerUserAPIRequestCountFluent<?> fluent,PerUserAPIRequestCount instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PerUserAPIRequestCount build() {
    PerUserAPIRequestCount buildable = new PerUserAPIRequestCount(fluent.buildByVerb(), fluent.getRequestCount(), fluent.getUserAgent(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
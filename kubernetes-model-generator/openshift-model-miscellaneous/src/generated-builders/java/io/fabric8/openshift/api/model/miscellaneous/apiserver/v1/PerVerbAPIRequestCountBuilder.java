package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PerVerbAPIRequestCountBuilder extends PerVerbAPIRequestCountFluent<PerVerbAPIRequestCountBuilder> implements VisitableBuilder<PerVerbAPIRequestCount,PerVerbAPIRequestCountBuilder>{

  PerVerbAPIRequestCountFluent<?> fluent;

  public PerVerbAPIRequestCountBuilder() {
    this(new PerVerbAPIRequestCount());
  }
  
  public PerVerbAPIRequestCountBuilder(PerVerbAPIRequestCountFluent<?> fluent) {
    this(fluent, new PerVerbAPIRequestCount());
  }
  
  public PerVerbAPIRequestCountBuilder(PerVerbAPIRequestCount instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PerVerbAPIRequestCountBuilder(PerVerbAPIRequestCountFluent<?> fluent,PerVerbAPIRequestCount instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PerVerbAPIRequestCount build() {
    PerVerbAPIRequestCount buildable = new PerVerbAPIRequestCount(fluent.getRequestCount(), fluent.getVerb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
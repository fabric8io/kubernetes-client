package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPCriteriaBuilder extends HTTPCriteriaFluent<HTTPCriteriaBuilder> implements VisitableBuilder<HTTPCriteria,HTTPCriteriaBuilder>{

  HTTPCriteriaFluent<?> fluent;

  public HTTPCriteriaBuilder() {
    this(new HTTPCriteria());
  }
  
  public HTTPCriteriaBuilder(HTTPCriteriaFluent<?> fluent) {
    this(fluent, new HTTPCriteria());
  }
  
  public HTTPCriteriaBuilder(HTTPCriteria instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPCriteriaBuilder(HTTPCriteriaFluent<?> fluent,HTTPCriteria instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPCriteria build() {
    HTTPCriteria buildable = new HTTPCriteria(fluent.getStatusCode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
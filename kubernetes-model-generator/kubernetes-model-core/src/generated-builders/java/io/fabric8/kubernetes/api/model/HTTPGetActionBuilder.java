package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPGetActionBuilder extends HTTPGetActionFluent<HTTPGetActionBuilder> implements VisitableBuilder<HTTPGetAction,HTTPGetActionBuilder>{

  HTTPGetActionFluent<?> fluent;

  public HTTPGetActionBuilder() {
    this(new HTTPGetAction());
  }
  
  public HTTPGetActionBuilder(HTTPGetActionFluent<?> fluent) {
    this(fluent, new HTTPGetAction());
  }
  
  public HTTPGetActionBuilder(HTTPGetAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPGetActionBuilder(HTTPGetActionFluent<?> fluent,HTTPGetAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPGetAction build() {
    HTTPGetAction buildable = new HTTPGetAction(fluent.getHost(), fluent.buildHttpHeaders(), fluent.getPath(), fluent.buildPort(), fluent.getScheme());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
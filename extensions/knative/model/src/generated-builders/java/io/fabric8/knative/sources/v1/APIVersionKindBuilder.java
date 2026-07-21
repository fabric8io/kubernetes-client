package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIVersionKindBuilder extends APIVersionKindFluent<APIVersionKindBuilder> implements VisitableBuilder<APIVersionKind,APIVersionKindBuilder>{

  APIVersionKindFluent<?> fluent;

  public APIVersionKindBuilder() {
    this(new APIVersionKind());
  }
  
  public APIVersionKindBuilder(APIVersionKindFluent<?> fluent) {
    this(fluent, new APIVersionKind());
  }
  
  public APIVersionKindBuilder(APIVersionKind instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIVersionKindBuilder(APIVersionKindFluent<?> fluent,APIVersionKind instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIVersionKind build() {
    APIVersionKind buildable = new APIVersionKind(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
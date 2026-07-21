package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIVersionKindSelectorBuilder extends APIVersionKindSelectorFluent<APIVersionKindSelectorBuilder> implements VisitableBuilder<APIVersionKindSelector,APIVersionKindSelectorBuilder>{

  APIVersionKindSelectorFluent<?> fluent;

  public APIVersionKindSelectorBuilder() {
    this(new APIVersionKindSelector());
  }
  
  public APIVersionKindSelectorBuilder(APIVersionKindSelectorFluent<?> fluent) {
    this(fluent, new APIVersionKindSelector());
  }
  
  public APIVersionKindSelectorBuilder(APIVersionKindSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIVersionKindSelectorBuilder(APIVersionKindSelectorFluent<?> fluent,APIVersionKindSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIVersionKindSelector build() {
    APIVersionKindSelector buildable = new APIVersionKindSelector(fluent.getApiVersion(), fluent.getKind(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
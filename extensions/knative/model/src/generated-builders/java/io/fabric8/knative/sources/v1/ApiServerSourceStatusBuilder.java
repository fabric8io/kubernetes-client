package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ApiServerSourceStatusBuilder extends ApiServerSourceStatusFluent<ApiServerSourceStatusBuilder> implements VisitableBuilder<ApiServerSourceStatus,ApiServerSourceStatusBuilder>{

  ApiServerSourceStatusFluent<?> fluent;

  public ApiServerSourceStatusBuilder() {
    this(new ApiServerSourceStatus());
  }
  
  public ApiServerSourceStatusBuilder(ApiServerSourceStatusFluent<?> fluent) {
    this(fluent, new ApiServerSourceStatus());
  }
  
  public ApiServerSourceStatusBuilder(ApiServerSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ApiServerSourceStatusBuilder(ApiServerSourceStatusFluent<?> fluent,ApiServerSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ApiServerSourceStatus build() {
    ApiServerSourceStatus buildable = new ApiServerSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getNamespaces(), fluent.getObservedGeneration(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
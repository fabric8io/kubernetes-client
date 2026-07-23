package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ApiServerSourceBuilder extends ApiServerSourceFluent<ApiServerSourceBuilder> implements VisitableBuilder<ApiServerSource,ApiServerSourceBuilder>{

  ApiServerSourceFluent<?> fluent;

  public ApiServerSourceBuilder() {
    this(new ApiServerSource());
  }
  
  public ApiServerSourceBuilder(ApiServerSourceFluent<?> fluent) {
    this(fluent, new ApiServerSource());
  }
  
  public ApiServerSourceBuilder(ApiServerSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ApiServerSourceBuilder(ApiServerSourceFluent<?> fluent,ApiServerSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ApiServerSource build() {
    ApiServerSource buildable = new ApiServerSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
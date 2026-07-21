package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ApiServerSourceSpecBuilder extends ApiServerSourceSpecFluent<ApiServerSourceSpecBuilder> implements VisitableBuilder<ApiServerSourceSpec,ApiServerSourceSpecBuilder>{

  ApiServerSourceSpecFluent<?> fluent;

  public ApiServerSourceSpecBuilder() {
    this(new ApiServerSourceSpec());
  }
  
  public ApiServerSourceSpecBuilder(ApiServerSourceSpecFluent<?> fluent) {
    this(fluent, new ApiServerSourceSpec());
  }
  
  public ApiServerSourceSpecBuilder(ApiServerSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ApiServerSourceSpecBuilder(ApiServerSourceSpecFluent<?> fluent,ApiServerSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ApiServerSourceSpec build() {
    ApiServerSourceSpec buildable = new ApiServerSourceSpec(fluent.buildCeOverrides(), fluent.buildFilters(), fluent.getMode(), fluent.buildNamespaceSelector(), fluent.buildOwner(), fluent.buildResources(), fluent.getServiceAccountName(), fluent.buildSink());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
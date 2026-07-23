package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ApiServerSourceListBuilder extends ApiServerSourceListFluent<ApiServerSourceListBuilder> implements VisitableBuilder<ApiServerSourceList,ApiServerSourceListBuilder>{

  ApiServerSourceListFluent<?> fluent;

  public ApiServerSourceListBuilder() {
    this(new ApiServerSourceList());
  }
  
  public ApiServerSourceListBuilder(ApiServerSourceListFluent<?> fluent) {
    this(fluent, new ApiServerSourceList());
  }
  
  public ApiServerSourceListBuilder(ApiServerSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ApiServerSourceListBuilder(ApiServerSourceListFluent<?> fluent,ApiServerSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ApiServerSourceList build() {
    ApiServerSourceList buildable = new ApiServerSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
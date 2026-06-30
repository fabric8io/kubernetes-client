package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GetOptionsBuilder extends GetOptionsFluent<GetOptionsBuilder> implements VisitableBuilder<GetOptions,GetOptionsBuilder>{

  GetOptionsFluent<?> fluent;

  public GetOptionsBuilder() {
    this(new GetOptions());
  }
  
  public GetOptionsBuilder(GetOptionsFluent<?> fluent) {
    this(fluent, new GetOptions());
  }
  
  public GetOptionsBuilder(GetOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GetOptionsBuilder(GetOptionsFluent<?> fluent,GetOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GetOptions build() {
    GetOptions buildable = new GetOptions(fluent.getApiVersion(), fluent.getKind(), fluent.getResourceVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
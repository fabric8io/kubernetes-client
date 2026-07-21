package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPConfigSpecBuilder extends HTTPConfigSpecFluent<HTTPConfigSpecBuilder> implements VisitableBuilder<HTTPConfigSpec,HTTPConfigSpecBuilder>{

  HTTPConfigSpecFluent<?> fluent;

  public HTTPConfigSpecBuilder() {
    this(new HTTPConfigSpec());
  }
  
  public HTTPConfigSpecBuilder(HTTPConfigSpecFluent<?> fluent) {
    this(fluent, new HTTPConfigSpec());
  }
  
  public HTTPConfigSpecBuilder(HTTPConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPConfigSpecBuilder(HTTPConfigSpecFluent<?> fluent,HTTPConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPConfigSpec build() {
    HTTPConfigSpec buildable = new HTTPConfigSpec(fluent.getFilePath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
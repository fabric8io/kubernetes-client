package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServiceSpecBuilder extends APIServiceSpecFluent<APIServiceSpecBuilder> implements VisitableBuilder<APIServiceSpec,APIServiceSpecBuilder>{

  APIServiceSpecFluent<?> fluent;

  public APIServiceSpecBuilder() {
    this(new APIServiceSpec());
  }
  
  public APIServiceSpecBuilder(APIServiceSpecFluent<?> fluent) {
    this(fluent, new APIServiceSpec());
  }
  
  public APIServiceSpecBuilder(APIServiceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServiceSpecBuilder(APIServiceSpecFluent<?> fluent,APIServiceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServiceSpec build() {
    APIServiceSpec buildable = new APIServiceSpec(fluent.getCaBundle(), fluent.getGroup(), fluent.getGroupPriorityMinimum(), fluent.getInsecureSkipTLSVerify(), fluent.buildService(), fluent.getVersion(), fluent.getVersionPriority());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
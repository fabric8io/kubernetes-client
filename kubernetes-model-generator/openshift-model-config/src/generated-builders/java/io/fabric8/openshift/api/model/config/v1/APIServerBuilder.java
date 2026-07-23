package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServerBuilder extends APIServerFluent<APIServerBuilder> implements VisitableBuilder<APIServer,APIServerBuilder>{

  APIServerFluent<?> fluent;

  public APIServerBuilder() {
    this(new APIServer());
  }
  
  public APIServerBuilder(APIServerFluent<?> fluent) {
    this(fluent, new APIServer());
  }
  
  public APIServerBuilder(APIServer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServerBuilder(APIServerFluent<?> fluent,APIServer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServer build() {
    APIServer buildable = new APIServer(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
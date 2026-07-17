package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildRequestBuilder extends BuildRequestFluent<BuildRequestBuilder> implements VisitableBuilder<BuildRequest,BuildRequestBuilder>{

  BuildRequestFluent<?> fluent;

  public BuildRequestBuilder() {
    this(new BuildRequest());
  }
  
  public BuildRequestBuilder(BuildRequestFluent<?> fluent) {
    this(fluent, new BuildRequest());
  }
  
  public BuildRequestBuilder(BuildRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildRequestBuilder(BuildRequestFluent<?> fluent,BuildRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildRequest build() {
    BuildRequest buildable = new BuildRequest(fluent.getApiVersion(), fluent.buildBinary(), fluent.buildDockerStrategyOptions(), fluent.buildEnv(), fluent.buildFrom(), fluent.getKind(), fluent.getLastVersion(), fluent.buildMetadata(), fluent.buildRevision(), fluent.buildSourceStrategyOptions(), fluent.buildTriggeredBy(), fluent.buildTriggeredByImage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
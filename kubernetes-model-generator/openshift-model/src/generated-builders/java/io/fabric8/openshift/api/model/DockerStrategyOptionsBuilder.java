package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DockerStrategyOptionsBuilder extends DockerStrategyOptionsFluent<DockerStrategyOptionsBuilder> implements VisitableBuilder<DockerStrategyOptions,DockerStrategyOptionsBuilder>{

  DockerStrategyOptionsFluent<?> fluent;

  public DockerStrategyOptionsBuilder() {
    this(new DockerStrategyOptions());
  }
  
  public DockerStrategyOptionsBuilder(DockerStrategyOptionsFluent<?> fluent) {
    this(fluent, new DockerStrategyOptions());
  }
  
  public DockerStrategyOptionsBuilder(DockerStrategyOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DockerStrategyOptionsBuilder(DockerStrategyOptionsFluent<?> fluent,DockerStrategyOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DockerStrategyOptions build() {
    DockerStrategyOptions buildable = new DockerStrategyOptions(fluent.buildBuildArgs(), fluent.getNoCache());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
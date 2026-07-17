package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildLogBuilder extends BuildLogFluent<BuildLogBuilder> implements VisitableBuilder<BuildLog,BuildLogBuilder>{

  BuildLogFluent<?> fluent;

  public BuildLogBuilder() {
    this(new BuildLog());
  }
  
  public BuildLogBuilder(BuildLogFluent<?> fluent) {
    this(fluent, new BuildLog());
  }
  
  public BuildLogBuilder(BuildLog instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildLogBuilder(BuildLogFluent<?> fluent,BuildLog instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildLog build() {
    BuildLog buildable = new BuildLog(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
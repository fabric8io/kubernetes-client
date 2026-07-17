package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildConfigBuilder extends BuildConfigFluent<BuildConfigBuilder> implements VisitableBuilder<BuildConfig,BuildConfigBuilder>{

  BuildConfigFluent<?> fluent;

  public BuildConfigBuilder() {
    this(new BuildConfig());
  }
  
  public BuildConfigBuilder(BuildConfigFluent<?> fluent) {
    this(fluent, new BuildConfig());
  }
  
  public BuildConfigBuilder(BuildConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildConfigBuilder(BuildConfigFluent<?> fluent,BuildConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildConfig build() {
    BuildConfig buildable = new BuildConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
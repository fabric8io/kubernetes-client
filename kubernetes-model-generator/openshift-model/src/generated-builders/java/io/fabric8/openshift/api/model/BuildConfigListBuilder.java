package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildConfigListBuilder extends BuildConfigListFluent<BuildConfigListBuilder> implements VisitableBuilder<BuildConfigList,BuildConfigListBuilder>{

  BuildConfigListFluent<?> fluent;

  public BuildConfigListBuilder() {
    this(new BuildConfigList());
  }
  
  public BuildConfigListBuilder(BuildConfigListFluent<?> fluent) {
    this(fluent, new BuildConfigList());
  }
  
  public BuildConfigListBuilder(BuildConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildConfigListBuilder(BuildConfigListFluent<?> fluent,BuildConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildConfigList build() {
    BuildConfigList buildable = new BuildConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
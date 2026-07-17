package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildListBuilder extends BuildListFluent<BuildListBuilder> implements VisitableBuilder<BuildList,BuildListBuilder>{

  BuildListFluent<?> fluent;

  public BuildListBuilder() {
    this(new BuildList());
  }
  
  public BuildListBuilder(BuildListFluent<?> fluent) {
    this(fluent, new BuildList());
  }
  
  public BuildListBuilder(BuildList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildListBuilder(BuildListFluent<?> fluent,BuildList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildList build() {
    BuildList buildable = new BuildList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
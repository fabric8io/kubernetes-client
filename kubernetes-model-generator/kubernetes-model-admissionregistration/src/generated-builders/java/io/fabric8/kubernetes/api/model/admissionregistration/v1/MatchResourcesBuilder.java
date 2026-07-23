package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MatchResourcesBuilder extends MatchResourcesFluent<MatchResourcesBuilder> implements VisitableBuilder<MatchResources,MatchResourcesBuilder>{

  MatchResourcesFluent<?> fluent;

  public MatchResourcesBuilder() {
    this(new MatchResources());
  }
  
  public MatchResourcesBuilder(MatchResourcesFluent<?> fluent) {
    this(fluent, new MatchResources());
  }
  
  public MatchResourcesBuilder(MatchResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MatchResourcesBuilder(MatchResourcesFluent<?> fluent,MatchResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MatchResources build() {
    MatchResources buildable = new MatchResources(fluent.buildExcludeResourceRules(), fluent.getMatchPolicy(), fluent.buildNamespaceSelector(), fluent.buildObjectSelector(), fluent.buildResourceRules());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
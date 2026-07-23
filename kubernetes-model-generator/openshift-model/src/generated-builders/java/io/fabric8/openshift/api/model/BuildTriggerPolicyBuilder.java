package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildTriggerPolicyBuilder extends BuildTriggerPolicyFluent<BuildTriggerPolicyBuilder> implements VisitableBuilder<BuildTriggerPolicy,BuildTriggerPolicyBuilder>{

  BuildTriggerPolicyFluent<?> fluent;

  public BuildTriggerPolicyBuilder() {
    this(new BuildTriggerPolicy());
  }
  
  public BuildTriggerPolicyBuilder(BuildTriggerPolicyFluent<?> fluent) {
    this(fluent, new BuildTriggerPolicy());
  }
  
  public BuildTriggerPolicyBuilder(BuildTriggerPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildTriggerPolicyBuilder(BuildTriggerPolicyFluent<?> fluent,BuildTriggerPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildTriggerPolicy build() {
    BuildTriggerPolicy buildable = new BuildTriggerPolicy(fluent.buildBitbucket(), fluent.buildGeneric(), fluent.buildGithub(), fluent.buildGitlab(), fluent.buildImageChange(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
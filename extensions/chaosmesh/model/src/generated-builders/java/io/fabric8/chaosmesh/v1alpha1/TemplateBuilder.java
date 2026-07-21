package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateBuilder extends TemplateFluent<TemplateBuilder> implements VisitableBuilder<Template,TemplateBuilder>{

  TemplateFluent<?> fluent;

  public TemplateBuilder() {
    this(new Template());
  }
  
  public TemplateBuilder(TemplateFluent<?> fluent) {
    this(fluent, new Template());
  }
  
  public TemplateBuilder(Template instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateBuilder(TemplateFluent<?> fluent,Template instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Template build() {
    Template buildable = new Template(fluent.getAbortWithStatusCheck(), fluent.buildAwsChaos(), fluent.buildAzureChaos(), fluent.buildBlockChaos(), fluent.getChildren(), fluent.buildConditionalBranches(), fluent.getDeadline(), fluent.buildDnsChaos(), fluent.buildGcpChaos(), fluent.buildHttpChaos(), fluent.buildIoChaos(), fluent.buildJvmChaos(), fluent.buildKernelChaos(), fluent.getName(), fluent.buildNetworkChaos(), fluent.buildPhysicalmachineChaos(), fluent.buildPodChaos(), fluent.buildSchedule(), fluent.buildStatusCheck(), fluent.buildStressChaos(), fluent.buildTask(), fluent.getTemplateType(), fluent.buildTimeChaos());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
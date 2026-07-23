package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkflowNodeSpecBuilder extends WorkflowNodeSpecFluent<WorkflowNodeSpecBuilder> implements VisitableBuilder<WorkflowNodeSpec,WorkflowNodeSpecBuilder>{

  WorkflowNodeSpecFluent<?> fluent;

  public WorkflowNodeSpecBuilder() {
    this(new WorkflowNodeSpec());
  }
  
  public WorkflowNodeSpecBuilder(WorkflowNodeSpecFluent<?> fluent) {
    this(fluent, new WorkflowNodeSpec());
  }
  
  public WorkflowNodeSpecBuilder(WorkflowNodeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkflowNodeSpecBuilder(WorkflowNodeSpecFluent<?> fluent,WorkflowNodeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkflowNodeSpec build() {
    WorkflowNodeSpec buildable = new WorkflowNodeSpec(fluent.getAbortWithStatusCheck(), fluent.buildAwsChaos(), fluent.buildAzureChaos(), fluent.buildBlockChaos(), fluent.getChildren(), fluent.buildConditionalBranches(), fluent.getDeadline(), fluent.buildDnsChaos(), fluent.buildGcpChaos(), fluent.buildHttpChaos(), fluent.buildIoChaos(), fluent.buildJvmChaos(), fluent.buildKernelChaos(), fluent.buildNetworkChaos(), fluent.buildPhysicalmachineChaos(), fluent.buildPodChaos(), fluent.buildSchedule(), fluent.getStartTime(), fluent.buildStatusCheck(), fluent.buildStressChaos(), fluent.buildTask(), fluent.getTemplateName(), fluent.buildTimeChaos(), fluent.getType(), fluent.getWorkflowName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
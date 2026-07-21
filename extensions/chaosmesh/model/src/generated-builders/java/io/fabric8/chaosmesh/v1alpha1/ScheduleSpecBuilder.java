package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScheduleSpecBuilder extends ScheduleSpecFluent<ScheduleSpecBuilder> implements VisitableBuilder<ScheduleSpec,ScheduleSpecBuilder>{

  ScheduleSpecFluent<?> fluent;

  public ScheduleSpecBuilder() {
    this(new ScheduleSpec());
  }
  
  public ScheduleSpecBuilder(ScheduleSpecFluent<?> fluent) {
    this(fluent, new ScheduleSpec());
  }
  
  public ScheduleSpecBuilder(ScheduleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScheduleSpecBuilder(ScheduleSpecFluent<?> fluent,ScheduleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScheduleSpec build() {
    ScheduleSpec buildable = new ScheduleSpec(fluent.buildAwsChaos(), fluent.buildAzureChaos(), fluent.buildBlockChaos(), fluent.getConcurrencyPolicy(), fluent.buildDnsChaos(), fluent.buildGcpChaos(), fluent.getHistoryLimit(), fluent.buildHttpChaos(), fluent.buildIoChaos(), fluent.buildJvmChaos(), fluent.buildKernelChaos(), fluent.buildNetworkChaos(), fluent.buildPhysicalmachineChaos(), fluent.buildPodChaos(), fluent.getSchedule(), fluent.getStartingDeadlineSeconds(), fluent.buildStressChaos(), fluent.buildTimeChaos(), fluent.getType(), fluent.buildWorkflow());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
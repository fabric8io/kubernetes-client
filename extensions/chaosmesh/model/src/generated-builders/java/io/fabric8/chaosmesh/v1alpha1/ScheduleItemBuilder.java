package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScheduleItemBuilder extends ScheduleItemFluent<ScheduleItemBuilder> implements VisitableBuilder<ScheduleItem,ScheduleItemBuilder>{

  ScheduleItemFluent<?> fluent;

  public ScheduleItemBuilder() {
    this(new ScheduleItem());
  }
  
  public ScheduleItemBuilder(ScheduleItemFluent<?> fluent) {
    this(fluent, new ScheduleItem());
  }
  
  public ScheduleItemBuilder(ScheduleItem instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScheduleItemBuilder(ScheduleItemFluent<?> fluent,ScheduleItem instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScheduleItem build() {
    ScheduleItem buildable = new ScheduleItem(fluent.buildAwsChaos(), fluent.buildAzureChaos(), fluent.buildBlockChaos(), fluent.buildDnsChaos(), fluent.buildGcpChaos(), fluent.buildHttpChaos(), fluent.buildIoChaos(), fluent.buildJvmChaos(), fluent.buildKernelChaos(), fluent.buildNetworkChaos(), fluent.buildPhysicalmachineChaos(), fluent.buildPodChaos(), fluent.buildStressChaos(), fluent.buildTimeChaos(), fluent.buildWorkflow());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
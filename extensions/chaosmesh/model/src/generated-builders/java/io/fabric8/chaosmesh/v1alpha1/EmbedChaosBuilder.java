package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmbedChaosBuilder extends EmbedChaosFluent<EmbedChaosBuilder> implements VisitableBuilder<EmbedChaos,EmbedChaosBuilder>{

  EmbedChaosFluent<?> fluent;

  public EmbedChaosBuilder() {
    this(new EmbedChaos());
  }
  
  public EmbedChaosBuilder(EmbedChaosFluent<?> fluent) {
    this(fluent, new EmbedChaos());
  }
  
  public EmbedChaosBuilder(EmbedChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmbedChaosBuilder(EmbedChaosFluent<?> fluent,EmbedChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmbedChaos build() {
    EmbedChaos buildable = new EmbedChaos(fluent.buildAwsChaos(), fluent.buildAzureChaos(), fluent.buildBlockChaos(), fluent.buildDnsChaos(), fluent.buildGcpChaos(), fluent.buildHttpChaos(), fluent.buildIoChaos(), fluent.buildJvmChaos(), fluent.buildKernelChaos(), fluent.buildNetworkChaos(), fluent.buildPhysicalmachineChaos(), fluent.buildPodChaos(), fluent.buildStressChaos(), fluent.buildTimeChaos());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
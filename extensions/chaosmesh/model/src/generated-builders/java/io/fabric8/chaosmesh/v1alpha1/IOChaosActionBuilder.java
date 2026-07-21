package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IOChaosActionBuilder extends IOChaosActionFluent<IOChaosActionBuilder> implements VisitableBuilder<IOChaosAction,IOChaosActionBuilder>{

  IOChaosActionFluent<?> fluent;

  public IOChaosActionBuilder() {
    this(new IOChaosAction());
  }
  
  public IOChaosActionBuilder(IOChaosActionFluent<?> fluent) {
    this(fluent, new IOChaosAction());
  }
  
  public IOChaosActionBuilder(IOChaosAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IOChaosActionBuilder(IOChaosActionFluent<?> fluent,IOChaosAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IOChaosAction build() {
    IOChaosAction buildable = new IOChaosAction(fluent.buildAtime(), fluent.getBlocks(), fluent.buildCtime(), fluent.buildFaults(), fluent.getGid(), fluent.getIno(), fluent.getKind(), fluent.getLatency(), fluent.getMethods(), fluent.buildMistake(), fluent.buildMtime(), fluent.getNlink(), fluent.getPath(), fluent.getPercent(), fluent.getPerm(), fluent.getRdev(), fluent.getSize(), fluent.getSource(), fluent.getType(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
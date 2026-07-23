package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AttrOverrideSpecBuilder extends AttrOverrideSpecFluent<AttrOverrideSpecBuilder> implements VisitableBuilder<AttrOverrideSpec,AttrOverrideSpecBuilder>{

  AttrOverrideSpecFluent<?> fluent;

  public AttrOverrideSpecBuilder() {
    this(new AttrOverrideSpec());
  }
  
  public AttrOverrideSpecBuilder(AttrOverrideSpecFluent<?> fluent) {
    this(fluent, new AttrOverrideSpec());
  }
  
  public AttrOverrideSpecBuilder(AttrOverrideSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AttrOverrideSpecBuilder(AttrOverrideSpecFluent<?> fluent,AttrOverrideSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AttrOverrideSpec build() {
    AttrOverrideSpec buildable = new AttrOverrideSpec(fluent.buildAtime(), fluent.getBlocks(), fluent.buildCtime(), fluent.getGid(), fluent.getIno(), fluent.getKind(), fluent.buildMtime(), fluent.getNlink(), fluent.getPerm(), fluent.getRdev(), fluent.getSize(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
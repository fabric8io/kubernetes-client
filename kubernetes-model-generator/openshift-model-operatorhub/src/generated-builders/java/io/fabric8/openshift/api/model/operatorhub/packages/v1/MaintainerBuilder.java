package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MaintainerBuilder extends MaintainerFluent<MaintainerBuilder> implements VisitableBuilder<Maintainer,MaintainerBuilder>{

  MaintainerFluent<?> fluent;

  public MaintainerBuilder() {
    this(new Maintainer());
  }
  
  public MaintainerBuilder(MaintainerFluent<?> fluent) {
    this(fluent, new Maintainer());
  }
  
  public MaintainerBuilder(Maintainer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MaintainerBuilder(MaintainerFluent<?> fluent,Maintainer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Maintainer build() {
    Maintainer buildable = new Maintainer(fluent.getEmail(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
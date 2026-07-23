package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedBootImagesBuilder extends ManagedBootImagesFluent<ManagedBootImagesBuilder> implements VisitableBuilder<ManagedBootImages,ManagedBootImagesBuilder>{

  ManagedBootImagesFluent<?> fluent;

  public ManagedBootImagesBuilder() {
    this(new ManagedBootImages());
  }
  
  public ManagedBootImagesBuilder(ManagedBootImagesFluent<?> fluent) {
    this(fluent, new ManagedBootImages());
  }
  
  public ManagedBootImagesBuilder(ManagedBootImages instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedBootImagesBuilder(ManagedBootImagesFluent<?> fluent,ManagedBootImages instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedBootImages build() {
    ManagedBootImages buildable = new ManagedBootImages(fluent.buildMachineManagers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
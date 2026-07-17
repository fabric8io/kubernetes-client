package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UpdateBuilder extends UpdateFluent<UpdateBuilder> implements VisitableBuilder<Update,UpdateBuilder>{

  UpdateFluent<?> fluent;

  public UpdateBuilder() {
    this(new Update());
  }
  
  public UpdateBuilder(UpdateFluent<?> fluent) {
    this(fluent, new Update());
  }
  
  public UpdateBuilder(Update instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UpdateBuilder(UpdateFluent<?> fluent,Update instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Update build() {
    Update buildable = new Update(fluent.getArchitecture(), fluent.getForce(), fluent.getImage(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
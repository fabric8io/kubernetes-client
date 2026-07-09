package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MutationBuilder extends MutationFluent<MutationBuilder> implements VisitableBuilder<Mutation,MutationBuilder>{

  MutationFluent<?> fluent;

  public MutationBuilder() {
    this(new Mutation());
  }
  
  public MutationBuilder(MutationFluent<?> fluent) {
    this(fluent, new Mutation());
  }
  
  public MutationBuilder(Mutation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MutationBuilder(MutationFluent<?> fluent,Mutation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Mutation build() {
    Mutation buildable = new Mutation(fluent.buildApplyConfiguration(), fluent.buildJsonPatch(), fluent.getPatchType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
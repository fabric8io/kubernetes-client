package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UpdateHistoryBuilder extends UpdateHistoryFluent<UpdateHistoryBuilder> implements VisitableBuilder<UpdateHistory,UpdateHistoryBuilder>{

  UpdateHistoryFluent<?> fluent;

  public UpdateHistoryBuilder() {
    this(new UpdateHistory());
  }
  
  public UpdateHistoryBuilder(UpdateHistoryFluent<?> fluent) {
    this(fluent, new UpdateHistory());
  }
  
  public UpdateHistoryBuilder(UpdateHistory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UpdateHistoryBuilder(UpdateHistoryFluent<?> fluent,UpdateHistory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UpdateHistory build() {
    UpdateHistory buildable = new UpdateHistory(fluent.getAcceptedRisks(), fluent.getCompletionTime(), fluent.getImage(), fluent.getStartedTime(), fluent.getState(), fluent.getVerified(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
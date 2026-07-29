package io.fabric8.kubernetes.client.extended.run;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;

/**
 * Generated
 */
public class RunConfigBuilder extends RunConfigFluent<RunConfigBuilder> implements VisitableBuilder<RunConfig,RunConfigBuilder>{

  RunConfigFluent<?> fluent;

  public RunConfigBuilder() {
    this.fluent = this;
  }
  
  public RunConfigBuilder(RunConfigFluent<?> fluent) {
    this.fluent = fluent;
  }
  
  public RunConfigBuilder(RunConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RunConfigBuilder(RunConfigFluent<?> fluent,RunConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EditableRunConfig build() {
    EditableRunConfig buildable = new EditableRunConfig(fluent.getName(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.getCommand(), fluent.getArgs(), fluent.getRestartPolicy(), fluent.getServiceAccount(), fluent.getLabels(), fluent.getEnv(), fluent.getLimits(), fluent.getRequests(), fluent.getPort());
    return buildable;
  }
  
}
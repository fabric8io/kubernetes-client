package io.fabric8.volcano.api.model.bus.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CommandBuilder extends CommandFluent<CommandBuilder> implements VisitableBuilder<Command,CommandBuilder>{

  CommandFluent<?> fluent;

  public CommandBuilder() {
    this(new Command());
  }
  
  public CommandBuilder(CommandFluent<?> fluent) {
    this(fluent, new Command());
  }
  
  public CommandBuilder(Command instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CommandBuilder(CommandFluent<?> fluent,Command instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Command build() {
    Command buildable = new Command(fluent.getAction(), fluent.getApiVersion(), fluent.getKind(), fluent.getMessage(), fluent.buildMetadata(), fluent.getReason(), fluent.getTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
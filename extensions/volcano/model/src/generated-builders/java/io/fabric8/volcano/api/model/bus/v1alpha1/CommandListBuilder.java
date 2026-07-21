package io.fabric8.volcano.api.model.bus.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CommandListBuilder extends CommandListFluent<CommandListBuilder> implements VisitableBuilder<CommandList,CommandListBuilder>{

  CommandListFluent<?> fluent;

  public CommandListBuilder() {
    this(new CommandList());
  }
  
  public CommandListBuilder(CommandListFluent<?> fluent) {
    this(fluent, new CommandList());
  }
  
  public CommandListBuilder(CommandList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CommandListBuilder(CommandListFluent<?> fluent,CommandList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CommandList build() {
    CommandList buildable = new CommandList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}
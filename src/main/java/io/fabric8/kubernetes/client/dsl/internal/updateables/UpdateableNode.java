package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeBuilder;
import io.fabric8.kubernetes.api.model.NodeFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableNode extends NodeFluent<UpdateableNode> implements Updateable<Node> {

  private final NodeBuilder builder;
  private final Update<Node> update;

  public UpdateableNode(Node node, Update<Node> update) {
    this.update = update;
    builder = new NodeBuilder(node);
  }

  @Override
  public Node update() {
    return update.apply(builder.build());
  }
}

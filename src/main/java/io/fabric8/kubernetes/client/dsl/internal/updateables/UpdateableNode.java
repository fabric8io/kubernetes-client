package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableNode extends NodeFluent<UpdateableNode> implements Updateable<Node> {

  @Override
  public Node update() {
    return null;
  }
}

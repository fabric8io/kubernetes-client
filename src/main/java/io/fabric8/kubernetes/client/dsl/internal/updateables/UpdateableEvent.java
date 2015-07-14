package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventFluent;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableEvent extends EventFluent<UpdateableEvent> implements Updateable<Event> {

  @Override
  public Event update() {
    return null;
  }
}

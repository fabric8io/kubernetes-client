package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.api.model.EventFluent;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;

public class UpdateableEvent extends EventFluent<UpdateableEvent> implements Updateable<Event> {

  private final EventBuilder builder;
  private final Update<Event> update;

  public UpdateableEvent(Event event, Update<Event> update) {
    this.update = update;
    builder = new EventBuilder(this, event);
  }

  @Override
  public Event update() {
    return update.apply(builder.build());
  }
}

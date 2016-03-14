/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.client.mock.impl.donable;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.DoneableEvent;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.api.model.EventFluent;
import io.fabric8.kubernetes.api.model.EventFluentImpl;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableEvent extends EventFluentImpl<MockDoneableEvent> implements MockDoneable<Event> {

  private interface DelegateInterface extends Doneable<Event>, EventFluent<DoneableEvent> {}
  private final Function<Event, Event> visitor = new Function<Event, Event>() {
    @Override
    public Event apply(Event item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableEvent() {
    super(new EventBuilder()
      .withNewMetadata().endMetadata()
      .withNewSource().endSource()
      .withNewInvolvedObject().endInvolvedObject()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface .class);
  }

  @Override
  public IExpectationSetters<Event> done() {
    return EasyMock.expect(delegate.done());
  }

  @Override
  public Void replay() {
    EasyMock.replay(delegate);
    return null;
  }

  @Override
  public void verify() {
    EasyMock.verify(delegate);
  }

  @Override
  public Doneable<Event> getDelegate() {
    return new DoneableEvent(new EventBuilder(this).build(), visitor) {
      @Override
      public Event done() {
        return delegate.done();
      }
    };
  }
}

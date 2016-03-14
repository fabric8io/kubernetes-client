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
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusBuilder;
import io.fabric8.kubernetes.api.model.ComponentStatusFluent;
import io.fabric8.kubernetes.api.model.ComponentStatusFluentImpl;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.DoneableComponentStatus;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableComponentStatus extends ComponentStatusFluentImpl<MockDoneableComponentStatus> implements MockDoneable<ComponentStatus> {

	  private interface DelegateInterface extends Doneable<ComponentStatus>, ComponentStatusFluent<DoneableComponentStatus> {}
	  private final Function<ComponentStatus, ComponentStatus> visitor = new Function<ComponentStatus, ComponentStatus>() {
	    @Override
	    public ComponentStatus apply(ComponentStatus item) {return item;}
	  };

	  private final DelegateInterface delegate;

	  public MockDoneableComponentStatus() {
	    super(new ComponentStatusBuilder().withNewMetadata().and().build());
	    this.delegate = EasyMock.createMock(DelegateInterface.class);
	  }

	  @Override
	  public IExpectationSetters<ComponentStatus> done() {
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
	  public Doneable<ComponentStatus> getDelegate() {
	    return new DoneableComponentStatus(new ComponentStatusBuilder(this).build(), visitor) {
	      @Override
	      public ComponentStatus done() {
	        return delegate.done();
	      }
	    };
	  }

	}

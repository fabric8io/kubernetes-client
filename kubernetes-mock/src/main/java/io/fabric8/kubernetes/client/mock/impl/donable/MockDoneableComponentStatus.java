package io.fabric8.kubernetes.client.mock.impl.donable;

import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusBuilder;
import io.fabric8.kubernetes.api.model.ComponentStatusFluent;
import io.fabric8.kubernetes.api.model.ComponentStatusFluentImpl;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.DoneableComponentStatus;
import io.fabric8.kubernetes.client.mock.MockDoneable;

public class MockDoneableComponentStatus extends ComponentStatusFluentImpl<MockDoneableComponentStatus> implements MockDoneable<ComponentStatus> {

	  private interface DelegateInterface extends Doneable<ComponentStatus>, ComponentStatusFluent<DoneableComponentStatus> {}
	  private final Visitor<ComponentStatus> visitor = new Visitor<ComponentStatus>() {
	    @Override
	    public void visit(ComponentStatus item) {}
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

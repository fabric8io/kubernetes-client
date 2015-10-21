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

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.DoneableSecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsBuilder;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsFluent;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsFluentImpl;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableSecurityContextConstraints extends SecurityContextConstraintsFluentImpl<MockDoneableSecurityContextConstraints> implements MockDoneable<SecurityContextConstraints> {


  private interface DelegateInterface extends Doneable<SecurityContextConstraints>, SecurityContextConstraintsFluent<DoneableSecurityContextConstraints> {}
  private final Visitor<SecurityContextConstraints> visitor = new Visitor<SecurityContextConstraints>() {
    @Override
    public void visit(SecurityContextConstraints item) {}
  };

  private final DelegateInterface delegate;

  public MockDoneableSecurityContextConstraints() {
    super(new SecurityContextConstraintsBuilder()
      .withNewMetadata().endMetadata()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface .class);
  }

  @Override
  public IExpectationSetters<SecurityContextConstraints> done() {
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
  public Doneable<SecurityContextConstraints> getDelegate() {
    return new DoneableSecurityContextConstraints(new SecurityContextConstraintsBuilder(this).build(), visitor) {
      @Override
      public SecurityContextConstraints done() {
        return delegate.done();
      }
    };
  }
}

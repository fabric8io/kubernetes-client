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

package io.fabric8.kubernetes.client.mock.impl;

import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ContainerResource;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.Execable;
import io.fabric8.kubernetes.client.dsl.TtyExecErrorable;
import io.fabric8.kubernetes.client.dsl.TtyExecOutputErrorable;
import io.fabric8.kubernetes.client.dsl.TtyExecable;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockPodResource;
import io.fabric8.kubernetes.client.mock.Mockable;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneablePod;
import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.easymock.IExpectationSetters;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static io.fabric8.kubernetes.client.mock.util.MockUtils.getArgument;
import static org.easymock.EasyMock.expect;

public class MockPod<C extends Client>  extends BaseMockOperation<Pod, PodList, DoneablePod, MockDoneablePod,
        ClientPodResource<Pod, DoneablePod>,
        MockPodResource<Pod, MockDoneablePod, Boolean>>
  implements MockPodResource<Pod, MockDoneablePod, Boolean> {


  private final Set<Mockable> nested = new LinkedHashSet<>();
  private Map<IArgumentMatcher, MockPod> containerMap = new HashMap<>();

  private Map<IArgumentMatcher, MockPod> inMap = new HashMap<>();
  private Map<IArgumentMatcher, MockPod> outMap = new HashMap<>();
  private Map<IArgumentMatcher, MockPod> errMap = new HashMap<>();

  private MockPod allocatingTerminalMock;


  //Dummy interface to use for mocking.
  private interface PodDelegate
    extends ClientMixedOperation<Pod, PodList, DoneablePod, ClientPodResource<Pod, DoneablePod>>,
          ClientPodResource<Pod, DoneablePod> {
  }

  public MockPod() {
    super(EasyMock.createMock(PodDelegate.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockPod();
  }

  @Override
  public IExpectationSetters<String> getLog() {
    return expect(((ClientPodResource<Pod, DoneablePod>) getDelegate()).getLog());
  }

  @Override
  public IExpectationSetters<String> getLog(String id) {
    return expect(((ClientPodResource<Pod, DoneablePod>) getDelegate()).getLog(id));
  }

  @Override
  public IExpectationSetters<String> getLog(Boolean isPretty) {
    return expect(((ClientPodResource<Pod, DoneablePod>) getDelegate()).getLog(isPretty));
  }

  @Override
  public IExpectationSetters<String> getLog(String id, Boolean isPretty) {
    return expect(((ClientPodResource<Pod, DoneablePod>) getDelegate()).getLog(id, isPretty));
  }


  @Override
  public IExpectationSetters<ExecWatch> exec(String... input) {
    return expect(getDelegate().exec(input));
  }

  @Override
  public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, IExpectationSetters<ExecWatch>> readingInput(InputStream in) {
    IArgumentMatcher matcher = getArgument(in);
    MockPod op = inMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().readingInput(in)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      containerMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, IExpectationSetters<ExecWatch>> writingInput(PipedOutputStream in) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, IExpectationSetters<ExecWatch>> redirectInput() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public TtyExecErrorable<String, OutputStream, PipedInputStream, IExpectationSetters<ExecWatch>> writingOutput(OutputStream out) {
    IArgumentMatcher matcher = getArgument(out);
    MockPod op = outMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().writingOutput(out)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      containerMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public TtyExecErrorable<String, OutputStream, PipedInputStream, IExpectationSetters<ExecWatch>> readingOutput(PipedInputStream in) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public TtyExecErrorable<String, OutputStream, PipedInputStream, IExpectationSetters<ExecWatch>> redirectOutput() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public TtyExecable<String, IExpectationSetters<ExecWatch>> writingError(OutputStream err) {
    IArgumentMatcher matcher = getArgument(err);
    MockPod op = errMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().writingError(err)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      containerMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public TtyExecable<String, IExpectationSetters<ExecWatch>> readingError(PipedInputStream in) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public TtyExecable<String, IExpectationSetters<ExecWatch>> redirectError() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Execable<String, IExpectationSetters<ExecWatch>> withTTY() {
    if (allocatingTerminalMock == null) {
      allocatingTerminalMock = new MockPod();
    }
    expect(getDelegate().withTTY()).andReturn(allocatingTerminalMock.getDelegate()).anyTimes();
    nested.add(allocatingTerminalMock);

    return allocatingTerminalMock;
  }

  @Override
  public ContainerResource<String, InputStream, PipedOutputStream, OutputStream, PipedInputStream, String, IExpectationSetters<ExecWatch>> inContainer(String containerId) {
    IArgumentMatcher matcher = getArgument(containerId);
    MockPod op = containerMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().inContainer(containerId)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      containerMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public PodDelegate getDelegate() {
    return (PodDelegate) super.getDelegate();
  }

  @Override
  public void verify() {
    for (Mockable mockable : nested) {
      mockable.verify();
    }
    super.verify();
  }

  @Override
  public Void replay() {
    for (Mockable mockable : nested) {
      mockable.replay();
    }
    return super.replay();
  }
}

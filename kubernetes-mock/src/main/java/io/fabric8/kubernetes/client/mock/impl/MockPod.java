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
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ContainerResource;
import io.fabric8.kubernetes.client.dsl.ExecListenable;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.Execable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
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

  private Map<IArgumentMatcher, MockPod> inPipeMap = new HashMap<>();
  private Map<IArgumentMatcher, MockPod> outPipeMap = new HashMap<>();
  private Map<IArgumentMatcher, MockPod> errPipeMap = new HashMap<>();

  private final Map<IArgumentMatcher, MockPod>  sinceTimeMap = new HashMap<>();
  private final Map<IArgumentMatcher, MockPod>  sinceSecondsMap = new HashMap<>();
  private final Map<IArgumentMatcher, MockPod>  tailMap = new HashMap<>();
  private final Map<IArgumentMatcher, MockPod>  logOutputMap = new HashMap<>();

  private MockPod redirectIn;
  private MockPod redirectOut;
  private MockPod redirectErr;
  private MockPod allocatingTerminalMock;

  private MockPod terminatedStatusMock;
  private MockPod prettyOutputMock;


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
    return expect((getDelegate()).getLog());
  }

  @Override
  public IExpectationSetters<String> getLog(String id) {
    return expect((getDelegate()).getLog(id));
  }

  @Override
  public IExpectationSetters<String> getLog(Boolean isPretty) {
    return expect((getDelegate()).getLog(isPretty));
  }

  @Override
  public IExpectationSetters<LogWatch> watchLog() {
    return expect((getDelegate()).watchLog());
  }

  @Override
  public IExpectationSetters<LogWatch> watchLog(OutputStream out) {
    IArgumentMatcher matcher = getArgument(out);
    MockPod op = logOutputMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      nested.add(op);
      logOutputMap.put(matcher, op);
    }
    return expect(getDelegate().watchLog(out));
  }

  @Override
  public IExpectationSetters<String> getLog(String id, Boolean isPretty) {
    return expect((getDelegate()).getLog(id, isPretty));
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
  public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, IExpectationSetters<ExecWatch>> writingInput(PipedOutputStream out) {
    IArgumentMatcher matcher = getArgument(out);
    MockPod op = inPipeMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().writingInput(out)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      inPipeMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public TtyExecOutputErrorable<String, OutputStream, PipedInputStream, IExpectationSetters<ExecWatch>> redirectingInput() {
    if (redirectIn == null) {
      redirectIn = new MockPod();
    }
    expect(getDelegate().redirectingInput()).andReturn(redirectIn.getDelegate()).anyTimes();
    return redirectIn;
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
    IArgumentMatcher matcher = getArgument(in);
    MockPod op = outPipeMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().readingOutput(in)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      outPipeMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public TtyExecErrorable<String, OutputStream, PipedInputStream, IExpectationSetters<ExecWatch>> redirectingOutput() {
    if (redirectOut == null) {
      redirectOut = new MockPod();
    }
    expect(getDelegate().redirectingInput()).andReturn(redirectOut.getDelegate()).anyTimes();
    return redirectOut;
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
    IArgumentMatcher matcher = getArgument(in);
    MockPod op = errPipeMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().readingOutput(in)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      errPipeMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public TtyExecable<String, IExpectationSetters<ExecWatch>> redirectingError() {
    if (redirectErr == null) {
      redirectErr = new MockPod();
    }
    expect(getDelegate().redirectingInput()).andReturn(redirectErr.getDelegate()).anyTimes();
    return redirectErr;
  }

  @Override
  public ExecListenable<String, IExpectationSetters<ExecWatch>> withTTY() {
    if (allocatingTerminalMock == null) {
      allocatingTerminalMock = new MockPod();
    }
    expect(getDelegate().withTTY()).andReturn(allocatingTerminalMock.getDelegate()).anyTimes();
    nested.add(allocatingTerminalMock);

    return allocatingTerminalMock;
  }

  @Override
  public ContainerResource<String, LogWatch, InputStream, PipedOutputStream, OutputStream, PipedInputStream, String, IExpectationSetters<ExecWatch>> inContainer(String containerId) {
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
  public Loggable<IExpectationSetters<String>, IExpectationSetters<LogWatch>> withPrettyOutput() {
    if (prettyOutputMock == null) {
      prettyOutputMock = new MockPod();
    }
    expect(getDelegate().withPrettyOutput()).andReturn(prettyOutputMock.getDelegate()).anyTimes();
    nested.add(allocatingTerminalMock);

    return prettyOutputMock;
  }

  @Override
  public PrettyLoggable<IExpectationSetters<String>, IExpectationSetters<LogWatch>> tailingLines(int lines) {
    IArgumentMatcher matcher = getArgument(lines);
    MockPod op = tailMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().tailingLines(lines)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      tailMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public TimeTailPrettyLoggable<IExpectationSetters<String>, IExpectationSetters<LogWatch>> terminated() {
    if (terminatedStatusMock == null) {
      terminatedStatusMock = new MockPod();
    }
    expect(getDelegate().withPrettyOutput()).andReturn(terminatedStatusMock.getDelegate()).anyTimes();
    nested.add(terminatedStatusMock);

    return terminatedStatusMock;
  }

  @Override
  public TailPrettyLoggable<IExpectationSetters<String>, IExpectationSetters<LogWatch>> sinceTime(String timestamp) {
    IArgumentMatcher matcher = getArgument(timestamp);
    MockPod op = sinceTimeMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().sinceTime(timestamp)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      sinceTimeMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public TailPrettyLoggable<IExpectationSetters<String>, IExpectationSetters<LogWatch>> sinceSeconds(int seconds) {
    IArgumentMatcher matcher = getArgument(seconds);
    MockPod op = sinceSecondsMap.get(matcher);
    if (op == null) {
      op = new MockPod();
      expect(getDelegate().sinceSeconds(seconds)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      sinceSecondsMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public Execable<String, IExpectationSetters<ExecWatch>> usingListener(ExecListener listener) {
    expect(getDelegate().usingListener(listener)).andReturn(getDelegate()).once();
    return this;
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

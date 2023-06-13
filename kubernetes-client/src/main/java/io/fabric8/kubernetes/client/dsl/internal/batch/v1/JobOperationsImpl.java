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
package io.fabric8.kubernetes.client.dsl.internal.batch.v1;

import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.BytesLimitTerminateTimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.ScalableResource;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.utils.internal.PodOperationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class JobOperationsImpl extends HasMetadataOperation<Job, JobList, ScalableResource<Job>>
    implements ScalableResource<Job> {

  static final transient Logger LOG = LoggerFactory.getLogger(JobOperationsImpl.class);
  private final PodOperationContext podControllerOperationContext;

  public JobOperationsImpl(Client client) {
    this(new PodOperationContext(), HasMetadataOperationsImpl.defaultContext(client));
  }

  public JobOperationsImpl(PodOperationContext context, OperationContext superContext) {
    super(superContext.withApiGroupName("batch")
        .withApiGroupVersion("v1")
        .withPlural("jobs"), Job.class, JobList.class);
    this.podControllerOperationContext = context;
  }

  @Override
  public JobOperationsImpl newInstance(OperationContext context) {
    return new JobOperationsImpl(podControllerOperationContext, context);
  }

  @Override
  public Job scale(int count) {
    Job res = accept(b -> b.getSpec().setParallelism(count));
    if (context.getTimeout() > 0) {
      waitUntilJobIsScaled();
      res = get();
    }
    return res;
  }

  /**
   * Lets wait until there are enough Ready pods of the given Job
   */
  private void waitUntilJobIsScaled() {
    final AtomicReference<Job> atomicJob = new AtomicReference<>();

    waitUntilCondition(job -> {
      atomicJob.set(job);
      Integer activeJobs = job.getStatus().getActive();
      if (activeJobs == null) {
        activeJobs = 0;
      }
      if (Objects.equals(job.getSpec().getParallelism(), activeJobs)) {
        return true;
      }
      LOG.debug("Only {}/{} pods scheduled for Job: {} in namespace: {} so waiting...",
          job.getStatus().getActive(), job.getSpec().getParallelism(), job.getMetadata().getName(), namespace);
      return false;
    }, context.getTimeout(), context.getTimeoutUnit());
  }

  @Override
  public String getLog() {
    return getLog(podControllerOperationContext.isPrettyOutput());
  }

  @Override
  public String getLog(boolean isPretty) {
    StringBuilder stringBuilder = new StringBuilder();
    List<PodResource> podOperationList = doGetLog();
    for (PodResource podOperation : podOperationList) {
      stringBuilder.append(podOperation.getLog(isPretty));
    }
    return stringBuilder.toString();
  }

  private List<PodResource> doGetLog() {
    Job job = requireFromServer();

    return PodOperationUtil.getPodOperationsForController(context, podControllerOperationContext,
        job.getMetadata().getUid(),
        getJobPodLabels(job));
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   *
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    return PodOperationUtil.getLogReader(doGetLog());
  }

  /**
   * Returns an unclosed InputStream. It's the caller responsibility to close it.
   *
   * @return Reader
   */
  @Override
  public InputStream getLogInputStream() {
    return PodOperationUtil.getLogInputStream(doGetLog());
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    return PodOperationUtil.watchLog(doGetLog(), out);
  }

  @Override
  public Loggable withLogWaitTimeout(Integer logWaitTimeout) {
    return withReadyWaitTimeout(logWaitTimeout);
  }

  @Override
  public Loggable withReadyWaitTimeout(Integer timeout) {
    return new JobOperationsImpl(podControllerOperationContext.withReadyWaitTimeout(timeout), context);
  }

  @Override
  protected Job modifyItemForReplaceOrPatch(Supplier<Job> current, Job job) {
    Job jobFromServer = current.get();
    if (job.getSpec().getSelector() == null) {
      job.getSpec().setSelector(jobFromServer.getSpec().getSelector());
    }
    if (job.getSpec().getTemplate().getMetadata() != null) {
      job.getSpec().getTemplate().getMetadata().setLabels(jobFromServer.getSpec().getTemplate().getMetadata().getLabels());
    } else {
      job.getSpec().getTemplate().setMetadata(jobFromServer.getSpec().getTemplate().getMetadata());
    }
    return job;
  }

  static Map<String, String> getJobPodLabels(Job job) {
    Map<String, String> labels = new HashMap<>();
    if (job != null && job.getMetadata() != null && job.getMetadata().getUid() != null) {
      labels.put("controller-uid", job.getMetadata().getUid());
    }
    return labels;
  }

  @Override
  public Loggable inContainer(String id) {
    return new JobOperationsImpl(podControllerOperationContext.withContainerId(id), context);
  }

  @Override
  public TimeTailPrettyLoggable limitBytes(int limitBytes) {
    return new JobOperationsImpl(podControllerOperationContext.withLimitBytes(limitBytes), context);
  }

  @Override
  public TimeTailPrettyLoggable terminated() {
    return new JobOperationsImpl(podControllerOperationContext.withTerminatedStatus(true), context);
  }

  @Override
  public Loggable withPrettyOutput() {
    return new JobOperationsImpl(podControllerOperationContext.withPrettyOutput(true), context);
  }

  @Override
  public PrettyLoggable tailingLines(int lines) {
    return new JobOperationsImpl(podControllerOperationContext.withTailingLines(lines), context);
  }

  @Override
  public TailPrettyLoggable sinceTime(String timestamp) {
    return new JobOperationsImpl(podControllerOperationContext.withSinceTimestamp(timestamp), context);
  }

  @Override
  public TailPrettyLoggable sinceSeconds(int seconds) {
    return new JobOperationsImpl(podControllerOperationContext.withSinceSeconds(seconds), context);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable usingTimestamps() {
    return new JobOperationsImpl(podControllerOperationContext.withTimestamps(true), context);
  }
}

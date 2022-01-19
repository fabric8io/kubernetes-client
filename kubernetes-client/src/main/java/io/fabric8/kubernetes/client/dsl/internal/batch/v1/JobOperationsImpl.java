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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobList;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.ScalableResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.PodControllerOperationContext;
import io.fabric8.kubernetes.client.utils.PodOperationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class JobOperationsImpl extends HasMetadataOperation<Job, JobList, ScalableResource<Job>>
  implements ScalableResource<Job> {

  static final transient Logger LOG = LoggerFactory.getLogger(JobOperationsImpl.class);
  private final PodControllerOperationContext podControllerOperationContext;

  public JobOperationsImpl(ClientContext clientContext) {
    this(clientContext, null);
  }

  public JobOperationsImpl(ClientContext clientContext, String namespace) {
    this(new PodControllerOperationContext(), HasMetadataOperationsImpl.defaultContext(clientContext).withNamespace(namespace));
  }

  public JobOperationsImpl(PodControllerOperationContext context, OperationContext superContext) {
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
  public ScalableResource<Job> load(InputStream is) {
    try {
      Job item = unmarshal(is, Job.class);
      return newInstance(context.withItem(item));
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ScalableResource<Job> fromServer() {
    return newInstance(context.withReloadingFromServer(true));
  }

  @Override
  public Job scale(int count) {
    return scale(count, false);
  }

  @Override
  public Scale scale() {
    return handleScale(null);
  }

  @Override
  public Scale scale(Scale scale) {
    return handleScale(scale);
  }

  @Override
  public Job scale(int count, boolean wait) {
    Job res = accept(b -> b.getSpec().setParallelism(count));
    if (wait) {
      waitUntilJobIsScaled();
      res = getMandatory();
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
      LOG.debug("Only {}/{} pods scheduled for Job: {} in namespace: {} seconds so waiting...",
          job.getStatus().getActive(), job.getSpec().getParallelism(), job.getMetadata().getName(), namespace);
      return false;
    }, getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS);
  }

  @Override
  public String getLog() {
    return getLog(false);
  }

  @Override
  public String getLog(Boolean isPretty) {
    StringBuilder stringBuilder = new StringBuilder();
    List<PodResource<Pod>> podOperationList = doGetLog(false);
    for (PodResource<Pod> podOperation : podOperationList) {
      stringBuilder.append(podOperation.getLog(isPretty));
    }
    return stringBuilder.toString();
  }

  private List<PodResource<Pod>> doGetLog(boolean isPretty) {
    Job job = requireFromServer();

    return PodOperationUtil.getPodOperationsForController(context, job.getMetadata().getUid(),
      getJobPodLabels(job), isPretty, podControllerOperationContext.getLogWaitTimeout(), podControllerOperationContext.getContainerId());
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    return PodOperationUtil.getLogReader(doGetLog(false));
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    return PodOperationUtil.watchLog(doGetLog(false), out);
  }

  @Override
  public Loggable<LogWatch> withLogWaitTimeout(Integer logWaitTimeout) {
    return new JobOperationsImpl(podControllerOperationContext.withLogWaitTimout(logWaitTimeout), context);
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
  public Loggable<LogWatch> inContainer(String id) {
    return new JobOperationsImpl(podControllerOperationContext.withContainerId(id), context);
  }
}

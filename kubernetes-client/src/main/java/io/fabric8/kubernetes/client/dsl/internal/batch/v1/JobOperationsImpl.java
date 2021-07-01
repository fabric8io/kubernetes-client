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
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.PodOperationUtil;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ScalableResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class JobOperationsImpl extends HasMetadataOperation<Job, JobList, ScalableResource<Job>>
  implements ScalableResource<Job> {

  static final transient Logger LOG = LoggerFactory.getLogger(JobOperationsImpl.class);
  private Integer podLogWaitTimeout;

  public JobOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, null);
  }

  public JobOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config).withNamespace(namespace).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  public JobOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("batch")
      .withApiGroupVersion("v1")
      .withPlural("jobs"));

    this.type = Job.class;
    this.listType = JobList.class;
  }

  private JobOperationsImpl(OperationContext context, Integer podLogWaitTimeout) {
    this(context);
    this.podLogWaitTimeout = podLogWaitTimeout;
  }

  @Override
  public JobOperationsImpl newInstance(OperationContext context) {
    return new JobOperationsImpl(context);
  }

  @Override
  public ScalableResource<Job> load(InputStream is) {
    try {
      Job item = unmarshal(is, Job.class);
      return new JobOperationsImpl(context.withItem(item));
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ScalableResource<Job> fromServer() {
    return new JobOperationsImpl(context.withReloadingFromServer(true));
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
    final CountDownLatch countDownLatch = new CountDownLatch(1);

    final AtomicReference<Job> atomicJob = new AtomicReference<>();

    final Runnable jobPoller = () -> {
      try {
        Job job = getMandatory();
        atomicJob.set(job);
        Integer activeJobs = job.getStatus().getActive();
        if (activeJobs == null) {
          activeJobs = 0;
        }
        if (Objects.equals(job.getSpec().getParallelism(), activeJobs)) {
          countDownLatch.countDown();
        } else {
          LOG.debug("Only {}/{} pods scheduled for Job: {} in namespace: {} seconds so waiting...",
            job.getStatus().getActive(), job.getSpec().getParallelism(), job.getMetadata().getName(), namespace);
        }
      } catch (Throwable t) {
        LOG.error("Error while waiting for Job to be scaled.", t);
      }
    };

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture poller = executor.scheduleWithFixedDelay(jobPoller, 0, POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
    try {
      countDownLatch.await(getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS);
      executor.shutdown();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      poller.cancel(true);
      executor.shutdown();
      LOG.error("Only {}/{} pod(s) ready for Job: {} in namespace: {} - giving up",
        atomicJob.get().getStatus().getActive(), atomicJob.get().getSpec().getParallelism(), atomicJob.get().getMetadata().getName(), namespace);
    }
  }

  public String getLog() {
    return getLog(false);
  }

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
      getJobPodLabels(job), isPretty, podLogWaitTimeout);
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    List<PodResource<Pod>> podResources = doGetLog(false);
    if (podResources.size() > 1) {
      throw new KubernetesClientException("Reading logs is not supported for multicontainer jobs");
    } else if (podResources.size() == 1) {
      return podResources.get(0).getLogReader();
    }
    return null;
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    List<PodResource<Pod>> podResources = doGetLog(false);
    if (podResources.size() > 1) {
      throw new KubernetesClientException("Watching logs is not supported for multicontainer jobs");
    } else if (podResources.size() == 1) {
      return podResources.get(0).watchLog(out);
    }
    return null;
  }

  @Override
  public Loggable<LogWatch> withLogWaitTimeout(Integer logWaitTimeout) {
    return new JobOperationsImpl(context, logWaitTimeout);
  }

  @Override
  public Job replace(Job job) {
    if (job == null) {
      job = getItem();
    }
    // Fetch item from server and patch Selector and PodTemplate
    // metadata in case not present already in order to avoid 422
    Job jobFromServer = requireFromServer();
    if (job.getSpec().getSelector() == null) {
      job.getSpec().setSelector(jobFromServer.getSpec().getSelector());
    }
    if (job.getSpec().getTemplate().getMetadata() != null) {
      job.getSpec().getTemplate().getMetadata().setLabels(jobFromServer.getSpec().getTemplate().getMetadata().getLabels());
    } else {
      job.getSpec().getTemplate().setMetadata(jobFromServer.getSpec().getTemplate().getMetadata());
    }

    return super.replace(job);
  }

  static Map<String, String> getJobPodLabels(Job job) {
    Map<String, String> labels = new HashMap<>();
    if (job != null && job.getMetadata() != null && job.getMetadata().getUid() != null) {
      labels.put("controller-uid", job.getMetadata().getUid());
    }
    return labels;
  }
}

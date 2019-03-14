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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.batch.DoneableJob;
import io.fabric8.kubernetes.api.model.batch.Job;
import io.fabric8.kubernetes.api.model.batch.JobList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ScalableResource;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class JobOperationsImpl extends HasMetadataOperation<Job, JobList, DoneableJob, ScalableResource<Job, DoneableJob>>
  implements ScalableResource<Job, DoneableJob> {

  static final transient Logger LOG = LoggerFactory.getLogger(JobOperationsImpl.class);

  public JobOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public JobOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("batch")
      .withApiGroupVersion("v1")
      .withPlural("jobs"));

    this.type = Job.class;
    this.listType = JobList.class;
    this.doneableType = DoneableJob.class;
  }

  @Override
  public JobOperationsImpl newInstance(OperationContext context) {
    return new JobOperationsImpl(context);
  }

  @Override
  public ScalableResource<Job, DoneableJob> load(InputStream is) {
    try {
      Job item = unmarshal(is, Job.class);
      return new JobOperationsImpl(context.withItem(item));
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public ScalableResource<Job, DoneableJob> fromServer() {
    return new JobOperationsImpl(context.withReloadingFromServer(true));
  }

  @Override
  public Job scale(int count) {
    return scale(count, false);
  }

  @Override
  public Job scale(int count, boolean wait) {
    Job res = cascading(false).edit().editSpec().withParallelism(count).endSpec().done();
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

  private static class JobReaper implements Reaper {
    private JobOperationsImpl oper;

    public JobReaper(JobOperationsImpl oper) {
      this.oper = oper;
    }

    @Override
    public boolean reap() {
      oper.scale(0, true);
      return false;
    }
  }
}

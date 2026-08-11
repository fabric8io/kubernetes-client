---
title: "Jobs and CronJobs"
description: "Run one-off and scheduled batch workloads"
weight: 6
---

# Jobs and CronJobs

## Creating a Job

```java
Job job = new JobBuilder()
    .withNewMetadata()
        .withName("batch-job")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withBackoffLimit(3)
        .withNewTemplate()
            .withNewSpec()
                .addNewContainer()
                    .withName("worker")
                    .withImage("busybox")
                    .withCommand("sh", "-c", "echo Hello && sleep 10")
                .endContainer()
                .withRestartPolicy("Never")
            .endSpec()
        .endTemplate()
    .endSpec()
    .build();

client.batch().v1().jobs().inNamespace("default").resource(job).create();
```

## Waiting for a Job to Complete

```java
client.batch().v1().jobs()
    .inNamespace("default")
    .withName("batch-job")
    .waitUntilCondition(
        j -> j.getStatus() != null
            && j.getStatus().getSucceeded() != null
            && j.getStatus().getSucceeded() > 0,
        5, TimeUnit.MINUTES);
```

## Creating a CronJob

```java
CronJob cronJob = new CronJobBuilder()
    .withNewMetadata()
        .withName("cleanup-job")
        .withNamespace("default")
    .endMetadata()
    .withNewSpec()
        .withSchedule("0 */6 * * *")
        .withNewJobTemplate()
            .withNewSpec()
                .withNewTemplate()
                    .withNewSpec()
                        .addNewContainer()
                            .withName("cleanup")
                            .withImage("busybox")
                            .withCommand("sh", "-c", "echo Cleaning up")
                        .endContainer()
                        .withRestartPolicy("OnFailure")
                    .endSpec()
                .endTemplate()
            .endSpec()
        .endJobTemplate()
    .endSpec()
    .build();

client.batch().v1().cronjobs().inNamespace("default").resource(cronJob).create();
```

## Listing Jobs

```java
JobList jobs = client.batch().v1().jobs().inNamespace("default").list();
for (Job j : jobs.getItems()) {
    System.out.printf("Job %s: succeeded=%d, failed=%d%n",
        j.getMetadata().getName(),
        j.getStatus().getSucceeded(),
        j.getStatus().getFailed());
}
```

package io.fabric8.volcano.scheduling.v1alpha1.builder;

import io.fabric8.volcano.scheduling.v1alpha1.JobStatus;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午5:18
 * @FileName：JobStatusBuilder
 * @Description:
 */
public class JobStatusBuilder extends JobStatusFluent<JobStatusBuilder> implements VisitableBuilder<JobStatus,JobStatusBuilder> {
    public JobStatusBuilder() {
        this(new JobStatus());
    }

    public JobStatusBuilder(JobStatusFluent<?> fluent) {
        this(fluent, new JobStatus());
    }

    public JobStatusBuilder(JobStatusFluent<?> fluent,JobStatus instance) {
        this.fluent = fluent;
        fluent.copyInstance(instance);
    }

    public JobStatusBuilder(JobStatus instance) {
        this.fluent = this;
        this.copyInstance(instance);
    }
    JobStatusFluent<?> fluent;

    public JobStatus build() {
        JobStatus buildable = new JobStatus(fluent.getInqueue(),fluent.getPending(),fluent.getRunning(),fluent.getState(),fluent.getUnknown());
        buildable.setAdditionalProperties(fluent.getAdditionalProperties());
        return buildable;
    }


}

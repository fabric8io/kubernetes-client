package io.fabric8.volcano.scheduling.v1alpha1.builder;

import io.fabric8.volcano.scheduling.v1alpha1.JobSpec;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午5:12
 * @FileName：JobSpecBuilder
 * @Description:
 */
public class JobSpecBuilder extends JobSpecFluent<JobSpecBuilder> implements VisitableBuilder<JobSpec,JobSpecBuilder> {
    public JobSpecBuilder() {
        this(new JobSpec());
    }

    public JobSpecBuilder(JobSpecFluent<?> fluent) {
        this(fluent, new JobSpec());
    }

    public JobSpecBuilder(JobSpecFluent<?> fluent,JobSpec instance) {
        this.fluent = fluent;
        fluent.copyInstance(instance);
    }

    public JobSpecBuilder(JobSpec instance) {
        this.fluent = this;
        this.copyInstance(instance);
    }
    JobSpecFluent<?> fluent;

    public JobSpec build() {
        JobSpec buildable = new JobSpec(fluent.getCapability(),fluent.getReclaimable(),fluent.getWeight(), fluent.getMinAvailable(),fluent.getSchedulerName(),fluent.getQueue(),fluent.buildVolumes(),
                fluent.buildVolumeMounts());
        buildable.setTasks(fluent.getTasks());
        buildable.setPolicies(fluent.getPolicies());
        buildable.setAdditionalProperties(fluent.getAdditionalProperties());
        return buildable;
    }


}

package io.fabric8.volcano.scheduling.v1alpha1.builder;

import io.fabric8.volcano.scheduling.v1alpha1.Job;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午5:05
 * @FileName：JobBuilder
 * @Description:
 */
public class JobBuilder extends JobFluent<JobBuilder> implements VisitableBuilder<Job,JobBuilder> {
    public JobBuilder() {
        this(new Job());
    }

    public JobBuilder(JobFluent<?> fluent) {
        this(fluent, new Job());
    }

    public JobBuilder(JobFluent<?> fluent,Job instance) {
        this.fluent = fluent;
        fluent.copyInstance(instance);
    }

    public JobBuilder(Job instance) {
        this.fluent = this;
        this.copyInstance(instance);
    }
    JobFluent<?> fluent;

    public Job build() {
        Job buildable = new Job(fluent.getApiVersion(),fluent.getKind(),fluent.buildMetadata(),fluent.buildSpec(),fluent.buildStatus());
        buildable.setAdditionalProperties(fluent.getAdditionalProperties());
        return buildable;
    }


}

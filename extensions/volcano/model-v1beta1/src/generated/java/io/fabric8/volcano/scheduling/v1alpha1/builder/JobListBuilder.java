package io.fabric8.volcano.scheduling.v1alpha1.builder;

import io.fabric8.volcano.scheduling.v1alpha1.JobList;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午6:30
 * @FileName：JobListBuilder
 * @Description:
 */
public class JobListBuilder extends JobListFluent<JobListBuilder> implements VisitableBuilder<JobList,JobListBuilder> {
    public JobListBuilder() {
        this(new JobList());
    }

    public JobListBuilder(JobListFluent<?> fluent) {
        this(fluent, new JobList());
    }

    public JobListBuilder(JobListFluent<?> fluent,JobList instance) {
        this.fluent = fluent;
        fluent.copyInstance(instance);
    }

    public JobListBuilder(JobList instance) {
        this.fluent = this;
        this.copyInstance(instance);
    }
    JobListFluent<?> fluent;

    public JobList build() {
        JobList buildable = new JobList(fluent.getApiVersion(),fluent.buildItems(),fluent.getKind(),fluent.getMetadata());
        buildable.setAdditionalProperties(fluent.getAdditionalProperties());
        return buildable;
    }


}

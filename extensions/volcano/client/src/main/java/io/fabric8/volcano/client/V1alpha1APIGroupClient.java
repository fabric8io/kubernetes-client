package io.fabric8.volcano.client;

import io.fabric8.volcano.client.dsl.V1alpha1APIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.volcano.scheduling.v1alpha1.Job;
import io.fabric8.volcano.scheduling.v1alpha1.JobList;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.scheduling.v1beta1.Queue;
import io.fabric8.volcano.scheduling.v1beta1.QueueList;

/**
 * @Author: mf
 * @Date: 2024/6/27  上午9:48
 * @FileName：V1beta1APIGroupClient
 * @Description:
 */
public class V1alpha1APIGroupClient extends ClientAdapter<V1alpha1APIGroupClient> implements V1alpha1APIGroupDSL {

    @Override
    public V1alpha1APIGroupClient newInstance() {
        return new V1alpha1APIGroupClient();
    }

    @Override
    public MixedOperation<PodGroup, PodGroupList, Resource<PodGroup>> podGroups() {
        return resources(PodGroup.class, PodGroupList.class);
    }

    @Override
    public MixedOperation<Queue, QueueList, Resource<Queue>> queues() {
        return resources(Queue.class, QueueList.class);
    }

    @Override
    public MixedOperation<Job, JobList, Resource<Job>> jobs() {
        return resources(Job.class, JobList.class);
    }

}

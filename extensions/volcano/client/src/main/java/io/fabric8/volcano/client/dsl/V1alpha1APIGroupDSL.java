package io.fabric8.volcano.client.dsl;

import io.fabric8.volcano.scheduling.v1alpha1.Job;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.volcano.scheduling.v1alpha1.JobList;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.scheduling.v1beta1.Queue;
import io.fabric8.volcano.scheduling.v1beta1.QueueList;

/**
 * @Author: mf
 * @Date: 2024/6/27  上午9:52
 * @FileName：V1beta1APIGroupDSL
 * @Description:
 */
public interface V1alpha1APIGroupDSL extends Client {

    MixedOperation<PodGroup, PodGroupList, Resource<PodGroup>> podGroups();

    MixedOperation<Queue, QueueList, Resource<Queue>> queues();

    MixedOperation<Job, JobList, Resource<Job>> jobs();

}

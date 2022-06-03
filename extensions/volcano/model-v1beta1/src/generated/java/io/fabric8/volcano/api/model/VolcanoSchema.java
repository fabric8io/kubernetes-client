
package io.fabric8.volcano.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupCondition;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupSpec;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupStatus;
import io.fabric8.volcano.scheduling.v1beta1.Queue;
import io.fabric8.volcano.scheduling.v1beta1.QueueList;
import io.fabric8.volcano.scheduling.v1beta1.QueueSpec;
import io.fabric8.volcano.scheduling.v1beta1.QueueStatus;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroup",
    "volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupCondition",
    "volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupList",
    "volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupSpec",
    "volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupStatus",
    "volcano_sh_apis_pkg_apis_scheduling_v1beta1_Queue",
    "volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueList",
    "volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueSpec",
    "volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueStatus"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class VolcanoSchema {

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroup")
    private PodGroup volcanoShApisPkgApisSchedulingV1beta1PodGroup;
    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupCondition")
    private PodGroupCondition volcanoShApisPkgApisSchedulingV1beta1PodGroupCondition;
    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupList")
    private PodGroupList volcanoShApisPkgApisSchedulingV1beta1PodGroupList;
    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupSpec")
    private PodGroupSpec volcanoShApisPkgApisSchedulingV1beta1PodGroupSpec;
    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupStatus")
    private PodGroupStatus volcanoShApisPkgApisSchedulingV1beta1PodGroupStatus;
    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_Queue")
    private Queue volcanoShApisPkgApisSchedulingV1beta1Queue;
    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueList")
    private QueueList volcanoShApisPkgApisSchedulingV1beta1QueueList;
    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueSpec")
    private QueueSpec volcanoShApisPkgApisSchedulingV1beta1QueueSpec;
    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueStatus")
    private QueueStatus volcanoShApisPkgApisSchedulingV1beta1QueueStatus;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VolcanoSchema() {
    }

    /**
     * 
     * @param volcanoShApisPkgApisSchedulingV1beta1QueueSpec
     * @param volcanoShApisPkgApisSchedulingV1beta1PodGroupCondition
     * @param volcanoShApisPkgApisSchedulingV1beta1PodGroupList
     * @param volcanoShApisPkgApisSchedulingV1beta1PodGroupStatus
     * @param volcanoShApisPkgApisSchedulingV1beta1PodGroup
     * @param volcanoShApisPkgApisSchedulingV1beta1PodGroupSpec
     * @param volcanoShApisPkgApisSchedulingV1beta1Queue
     * @param volcanoShApisPkgApisSchedulingV1beta1QueueStatus
     * @param volcanoShApisPkgApisSchedulingV1beta1QueueList
     */
    public VolcanoSchema(PodGroup volcanoShApisPkgApisSchedulingV1beta1PodGroup, PodGroupCondition volcanoShApisPkgApisSchedulingV1beta1PodGroupCondition, PodGroupList volcanoShApisPkgApisSchedulingV1beta1PodGroupList, PodGroupSpec volcanoShApisPkgApisSchedulingV1beta1PodGroupSpec, PodGroupStatus volcanoShApisPkgApisSchedulingV1beta1PodGroupStatus, Queue volcanoShApisPkgApisSchedulingV1beta1Queue, QueueList volcanoShApisPkgApisSchedulingV1beta1QueueList, QueueSpec volcanoShApisPkgApisSchedulingV1beta1QueueSpec, QueueStatus volcanoShApisPkgApisSchedulingV1beta1QueueStatus) {
        super();
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroup = volcanoShApisPkgApisSchedulingV1beta1PodGroup;
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroupCondition = volcanoShApisPkgApisSchedulingV1beta1PodGroupCondition;
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroupList = volcanoShApisPkgApisSchedulingV1beta1PodGroupList;
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroupSpec = volcanoShApisPkgApisSchedulingV1beta1PodGroupSpec;
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroupStatus = volcanoShApisPkgApisSchedulingV1beta1PodGroupStatus;
        this.volcanoShApisPkgApisSchedulingV1beta1Queue = volcanoShApisPkgApisSchedulingV1beta1Queue;
        this.volcanoShApisPkgApisSchedulingV1beta1QueueList = volcanoShApisPkgApisSchedulingV1beta1QueueList;
        this.volcanoShApisPkgApisSchedulingV1beta1QueueSpec = volcanoShApisPkgApisSchedulingV1beta1QueueSpec;
        this.volcanoShApisPkgApisSchedulingV1beta1QueueStatus = volcanoShApisPkgApisSchedulingV1beta1QueueStatus;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroup")
    public PodGroup getVolcanoShApisPkgApisSchedulingV1beta1PodGroup() {
        return volcanoShApisPkgApisSchedulingV1beta1PodGroup;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroup")
    public void setVolcanoShApisPkgApisSchedulingV1beta1PodGroup(PodGroup volcanoShApisPkgApisSchedulingV1beta1PodGroup) {
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroup = volcanoShApisPkgApisSchedulingV1beta1PodGroup;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupCondition")
    public PodGroupCondition getVolcanoShApisPkgApisSchedulingV1beta1PodGroupCondition() {
        return volcanoShApisPkgApisSchedulingV1beta1PodGroupCondition;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupCondition")
    public void setVolcanoShApisPkgApisSchedulingV1beta1PodGroupCondition(PodGroupCondition volcanoShApisPkgApisSchedulingV1beta1PodGroupCondition) {
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroupCondition = volcanoShApisPkgApisSchedulingV1beta1PodGroupCondition;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupList")
    public PodGroupList getVolcanoShApisPkgApisSchedulingV1beta1PodGroupList() {
        return volcanoShApisPkgApisSchedulingV1beta1PodGroupList;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupList")
    public void setVolcanoShApisPkgApisSchedulingV1beta1PodGroupList(PodGroupList volcanoShApisPkgApisSchedulingV1beta1PodGroupList) {
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroupList = volcanoShApisPkgApisSchedulingV1beta1PodGroupList;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupSpec")
    public PodGroupSpec getVolcanoShApisPkgApisSchedulingV1beta1PodGroupSpec() {
        return volcanoShApisPkgApisSchedulingV1beta1PodGroupSpec;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupSpec")
    public void setVolcanoShApisPkgApisSchedulingV1beta1PodGroupSpec(PodGroupSpec volcanoShApisPkgApisSchedulingV1beta1PodGroupSpec) {
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroupSpec = volcanoShApisPkgApisSchedulingV1beta1PodGroupSpec;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupStatus")
    public PodGroupStatus getVolcanoShApisPkgApisSchedulingV1beta1PodGroupStatus() {
        return volcanoShApisPkgApisSchedulingV1beta1PodGroupStatus;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_PodGroupStatus")
    public void setVolcanoShApisPkgApisSchedulingV1beta1PodGroupStatus(PodGroupStatus volcanoShApisPkgApisSchedulingV1beta1PodGroupStatus) {
        this.volcanoShApisPkgApisSchedulingV1beta1PodGroupStatus = volcanoShApisPkgApisSchedulingV1beta1PodGroupStatus;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_Queue")
    public Queue getVolcanoShApisPkgApisSchedulingV1beta1Queue() {
        return volcanoShApisPkgApisSchedulingV1beta1Queue;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_Queue")
    public void setVolcanoShApisPkgApisSchedulingV1beta1Queue(Queue volcanoShApisPkgApisSchedulingV1beta1Queue) {
        this.volcanoShApisPkgApisSchedulingV1beta1Queue = volcanoShApisPkgApisSchedulingV1beta1Queue;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueList")
    public QueueList getVolcanoShApisPkgApisSchedulingV1beta1QueueList() {
        return volcanoShApisPkgApisSchedulingV1beta1QueueList;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueList")
    public void setVolcanoShApisPkgApisSchedulingV1beta1QueueList(QueueList volcanoShApisPkgApisSchedulingV1beta1QueueList) {
        this.volcanoShApisPkgApisSchedulingV1beta1QueueList = volcanoShApisPkgApisSchedulingV1beta1QueueList;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueSpec")
    public QueueSpec getVolcanoShApisPkgApisSchedulingV1beta1QueueSpec() {
        return volcanoShApisPkgApisSchedulingV1beta1QueueSpec;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueSpec")
    public void setVolcanoShApisPkgApisSchedulingV1beta1QueueSpec(QueueSpec volcanoShApisPkgApisSchedulingV1beta1QueueSpec) {
        this.volcanoShApisPkgApisSchedulingV1beta1QueueSpec = volcanoShApisPkgApisSchedulingV1beta1QueueSpec;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueStatus")
    public QueueStatus getVolcanoShApisPkgApisSchedulingV1beta1QueueStatus() {
        return volcanoShApisPkgApisSchedulingV1beta1QueueStatus;
    }

    @JsonProperty("volcano_sh_apis_pkg_apis_scheduling_v1beta1_QueueStatus")
    public void setVolcanoShApisPkgApisSchedulingV1beta1QueueStatus(QueueStatus volcanoShApisPkgApisSchedulingV1beta1QueueStatus) {
        this.volcanoShApisPkgApisSchedulingV1beta1QueueStatus = volcanoShApisPkgApisSchedulingV1beta1QueueStatus;
    }

}

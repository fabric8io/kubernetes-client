package io.fabric8.volcano.scheduling.v1alpha1;

import io.fabric8.volcano.scheduling.v1alpha1.builder.JobSpecBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.*;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "apiVersion",
        "kind",
        "metadata",
        "capability",
        "reclaimable",
        "weight",
        "minAvailable",
        "schedulerName",
        "queue",
        "volumes",
        "volumeMounts",
        "tasks"
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
@Generated("jsonschema2pojo")
public class JobSpec implements Editable<JobSpecBuilder>, KubernetesResource {

    @JsonProperty("capability")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> capability = new LinkedHashMap<String, Quantity>();
    @JsonProperty("reclaimable")
    private Boolean reclaimable;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("minAvailable")
    private Integer minAvailable;
    @JsonProperty("schedulerName")
    private String schedulerName;
    @JsonProperty("queue")
    private String queue;
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<Volume>();
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeMount> volumeMounts = new ArrayList<VolumeMount>();
    @JsonProperty("tasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> tasks;
//    @JsonIgnore
    @JsonProperty("additionalProperties")
    private Map<String, Object> additionalProperties;
    @JsonProperty("policies")
    private Map<String, Object> policies;


    /**
     * No args constructor for use in serialization
     *
     */
    public JobSpec() {
    }

    public JobSpec(Map<String, Quantity> capability, Boolean reclaimable, Integer weight,Integer minAvailable,String schedulerName,String queue,List<Volume> volumes,List<VolumeMount> volumeMounts) {
        super();
        this.capability = capability;
        this.reclaimable = reclaimable;
        this.weight = weight;
        this.minAvailable = minAvailable;
        this.schedulerName = schedulerName;
        this.queue = queue;
        this.volumes = volumes;
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("capability")
    public Map<String, Quantity> getCapability() {
        return capability;
    }

    @JsonProperty("capability")
    public void setCapability(Map<String, Quantity> capability) {
        this.capability = capability;
    }

    @JsonProperty("reclaimable")
    public Boolean getReclaimable() {
        return reclaimable;
    }

    @JsonProperty("reclaimable")
    public void setReclaimable(Boolean reclaimable) {
        this.reclaimable = reclaimable;
    }

    @JsonProperty("minAvailable")
    public Integer getMinAvailable() {
        return minAvailable;
    }

    @JsonProperty("minAvailable")
    public void setMinAvailable(Integer minAvailable) {
        this.minAvailable = minAvailable;
    }

    @JsonProperty("schedulerName")
    public String getSchedulerName() {
        return schedulerName;
    }

    @JsonProperty("schedulerName")
    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    @JsonProperty("queue")
    public String getQueue() {
        return queue;
    }

    @JsonProperty("queue")
    public void setQueue(String queue) {
        this.queue = queue;
    }

    @JsonProperty("volumes")
    public List<Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    @JsonProperty("tasks")
    public Map<String, Object> getTasks() {
        return tasks;
    }

    @JsonProperty("tasks")
    public void setTasks(Map<String, Object> tasks) {
        this.tasks = tasks;
    }

    @JsonProperty("volumeMounts")
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public JobSpecBuilder edit() {
        return new JobSpecBuilder(this);
    }

    @JsonIgnore
    public JobSpecBuilder toBuilder() {
        return edit();
    }

    @JsonProperty("additionalProperties")
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonProperty("additionalProperties")
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("policies")
    public Map<String, Object> getPolicies() {
        return this.policies;
    }

    @JsonProperty("policies")
    public void setPolicies(String name, Object value) {
        this.policies.put(name, value);
    }

}

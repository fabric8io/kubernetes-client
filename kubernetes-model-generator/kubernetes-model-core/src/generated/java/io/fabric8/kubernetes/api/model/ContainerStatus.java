
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocatedResources",
    "containerID",
    "image",
    "imageID",
    "lastState",
    "name",
    "ready",
    "resources",
    "restartCount",
    "started",
    "state",
    "volumeMounts"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class ContainerStatus implements Editable<ContainerStatusBuilder> , KubernetesResource
{

    @JsonProperty("allocatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> allocatedResources = new LinkedHashMap<String, Quantity>();
    @JsonProperty("containerID")
    private String containerID;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imageID")
    private String imageID;
    @JsonProperty("lastState")
    private ContainerState lastState;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("restartCount")
    private Integer restartCount;
    @JsonProperty("started")
    private Boolean started;
    @JsonProperty("state")
    private ContainerState state;
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeMountStatus> volumeMounts = new ArrayList<VolumeMountStatus>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContainerStatus() {
    }

    public ContainerStatus(Map<String, Quantity> allocatedResources, String containerID, String image, String imageID, ContainerState lastState, String name, Boolean ready, ResourceRequirements resources, Integer restartCount, Boolean started, ContainerState state, List<VolumeMountStatus> volumeMounts) {
        super();
        this.allocatedResources = allocatedResources;
        this.containerID = containerID;
        this.image = image;
        this.imageID = imageID;
        this.lastState = lastState;
        this.name = name;
        this.ready = ready;
        this.resources = resources;
        this.restartCount = restartCount;
        this.started = started;
        this.state = state;
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("allocatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getAllocatedResources() {
        return allocatedResources;
    }

    @JsonProperty("allocatedResources")
    public void setAllocatedResources(Map<String, Quantity> allocatedResources) {
        this.allocatedResources = allocatedResources;
    }

    @JsonProperty("containerID")
    public String getContainerID() {
        return containerID;
    }

    @JsonProperty("containerID")
    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("imageID")
    public String getImageID() {
        return imageID;
    }

    @JsonProperty("imageID")
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    @JsonProperty("lastState")
    public ContainerState getLastState() {
        return lastState;
    }

    @JsonProperty("lastState")
    public void setLastState(ContainerState lastState) {
        this.lastState = lastState;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonProperty("restartCount")
    public Integer getRestartCount() {
        return restartCount;
    }

    @JsonProperty("restartCount")
    public void setRestartCount(Integer restartCount) {
        this.restartCount = restartCount;
    }

    @JsonProperty("started")
    public Boolean getStarted() {
        return started;
    }

    @JsonProperty("started")
    public void setStarted(Boolean started) {
        this.started = started;
    }

    @JsonProperty("state")
    public ContainerState getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(ContainerState state) {
        this.state = state;
    }

    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMountStatus> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMountStatus> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonIgnore
    public ContainerStatusBuilder edit() {
        return new ContainerStatusBuilder(this);
    }

    @JsonIgnore
    public ContainerStatusBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

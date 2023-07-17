
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
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
    "state"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class ContainerStatus implements KubernetesResource
{

    @JsonProperty("allocatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> allocatedResources = new LinkedHashMap<String, Quantity>();
    @JsonProperty("containerID")
    private java.lang.String containerID;
    @JsonProperty("image")
    private java.lang.String image;
    @JsonProperty("imageID")
    private java.lang.String imageID;
    @JsonProperty("lastState")
    private ContainerState lastState;
    @JsonProperty("name")
    private java.lang.String name;
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
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContainerStatus() {
    }

    public ContainerStatus(Map<String, Quantity> allocatedResources, java.lang.String containerID, java.lang.String image, java.lang.String imageID, ContainerState lastState, java.lang.String name, Boolean ready, ResourceRequirements resources, Integer restartCount, Boolean started, ContainerState state) {
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
    }

    @JsonProperty("allocatedResources")
    public Map<String, Quantity> getAllocatedResources() {
        return allocatedResources;
    }

    @JsonProperty("allocatedResources")
    public void setAllocatedResources(Map<String, Quantity> allocatedResources) {
        this.allocatedResources = allocatedResources;
    }

    @JsonProperty("containerID")
    public java.lang.String getContainerID() {
        return containerID;
    }

    @JsonProperty("containerID")
    public void setContainerID(java.lang.String containerID) {
        this.containerID = containerID;
    }

    @JsonProperty("image")
    public java.lang.String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(java.lang.String image) {
        this.image = image;
    }

    @JsonProperty("imageID")
    public java.lang.String getImageID() {
        return imageID;
    }

    @JsonProperty("imageID")
    public void setImageID(java.lang.String imageID) {
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
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


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
    "running",
    "terminated",
    "waiting"
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
public class ContainerState implements KubernetesResource
{

    @JsonProperty("running")
    private ContainerStateRunning running;
    @JsonProperty("terminated")
    private ContainerStateTerminated terminated;
    @JsonProperty("waiting")
    private ContainerStateWaiting waiting;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContainerState() {
    }

    public ContainerState(ContainerStateRunning running, ContainerStateTerminated terminated, ContainerStateWaiting waiting) {
        super();
        this.running = running;
        this.terminated = terminated;
        this.waiting = waiting;
    }

    @JsonProperty("running")
    public ContainerStateRunning getRunning() {
        return running;
    }

    @JsonProperty("running")
    public void setRunning(ContainerStateRunning running) {
        this.running = running;
    }

    @JsonProperty("terminated")
    public ContainerStateTerminated getTerminated() {
        return terminated;
    }

    @JsonProperty("terminated")
    public void setTerminated(ContainerStateTerminated terminated) {
        this.terminated = terminated;
    }

    @JsonProperty("waiting")
    public ContainerStateWaiting getWaiting() {
        return waiting;
    }

    @JsonProperty("waiting")
    public void setWaiting(ContainerStateWaiting waiting) {
        this.waiting = waiting;
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

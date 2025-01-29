
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * NodeConfigStatus describes the status of the config assigned by Node.Spec.ConfigSource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "active",
    "assigned",
    "error",
    "lastKnownGood"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeConfigStatus implements Editable<NodeConfigStatusBuilder>, KubernetesResource
{

    @JsonProperty("active")
    private NodeConfigSource active;
    @JsonProperty("assigned")
    private NodeConfigSource assigned;
    @JsonProperty("error")
    private String error;
    @JsonProperty("lastKnownGood")
    private NodeConfigSource lastKnownGood;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeConfigStatus() {
    }

    public NodeConfigStatus(NodeConfigSource active, NodeConfigSource assigned, String error, NodeConfigSource lastKnownGood) {
        super();
        this.active = active;
        this.assigned = assigned;
        this.error = error;
        this.lastKnownGood = lastKnownGood;
    }

    /**
     * NodeConfigStatus describes the status of the config assigned by Node.Spec.ConfigSource.
     */
    @JsonProperty("active")
    public NodeConfigSource getActive() {
        return active;
    }

    /**
     * NodeConfigStatus describes the status of the config assigned by Node.Spec.ConfigSource.
     */
    @JsonProperty("active")
    public void setActive(NodeConfigSource active) {
        this.active = active;
    }

    /**
     * NodeConfigStatus describes the status of the config assigned by Node.Spec.ConfigSource.
     */
    @JsonProperty("assigned")
    public NodeConfigSource getAssigned() {
        return assigned;
    }

    /**
     * NodeConfigStatus describes the status of the config assigned by Node.Spec.ConfigSource.
     */
    @JsonProperty("assigned")
    public void setAssigned(NodeConfigSource assigned) {
        this.assigned = assigned;
    }

    /**
     * Error describes any problems reconciling the Spec.ConfigSource to the Active config. Errors may occur, for example, attempting to checkpoint Spec.ConfigSource to the local Assigned record, attempting to checkpoint the payload associated with Spec.ConfigSource, attempting to load or validate the Assigned config, etc. Errors may occur at different points while syncing config. Earlier errors (e.g. download or checkpointing errors) will not result in a rollback to LastKnownGood, and may resolve across Kubelet retries. Later errors (e.g. loading or validating a checkpointed config) will result in a rollback to LastKnownGood. In the latter case, it is usually possible to resolve the error by fixing the config assigned in Spec.ConfigSource. You can find additional information for debugging by searching the error message in the Kubelet log. Error is a human-readable description of the error state; machines can check whether or not Error is empty, but should not rely on the stability of the Error text across Kubelet versions.
     */
    @JsonProperty("error")
    public String getError() {
        return error;
    }

    /**
     * Error describes any problems reconciling the Spec.ConfigSource to the Active config. Errors may occur, for example, attempting to checkpoint Spec.ConfigSource to the local Assigned record, attempting to checkpoint the payload associated with Spec.ConfigSource, attempting to load or validate the Assigned config, etc. Errors may occur at different points while syncing config. Earlier errors (e.g. download or checkpointing errors) will not result in a rollback to LastKnownGood, and may resolve across Kubelet retries. Later errors (e.g. loading or validating a checkpointed config) will result in a rollback to LastKnownGood. In the latter case, it is usually possible to resolve the error by fixing the config assigned in Spec.ConfigSource. You can find additional information for debugging by searching the error message in the Kubelet log. Error is a human-readable description of the error state; machines can check whether or not Error is empty, but should not rely on the stability of the Error text across Kubelet versions.
     */
    @JsonProperty("error")
    public void setError(String error) {
        this.error = error;
    }

    /**
     * NodeConfigStatus describes the status of the config assigned by Node.Spec.ConfigSource.
     */
    @JsonProperty("lastKnownGood")
    public NodeConfigSource getLastKnownGood() {
        return lastKnownGood;
    }

    /**
     * NodeConfigStatus describes the status of the config assigned by Node.Spec.ConfigSource.
     */
    @JsonProperty("lastKnownGood")
    public void setLastKnownGood(NodeConfigSource lastKnownGood) {
        this.lastKnownGood = lastKnownGood;
    }

    @JsonIgnore
    public NodeConfigStatusBuilder edit() {
        return new NodeConfigStatusBuilder(this);
    }

    @JsonIgnore
    public NodeConfigStatusBuilder toBuilder() {
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

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}

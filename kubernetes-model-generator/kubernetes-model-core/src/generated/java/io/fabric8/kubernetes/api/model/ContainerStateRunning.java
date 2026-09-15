
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;

/**
 * ContainerStateRunning is a running state of a container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startedAt"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerStateRunning implements Editable<ContainerStateRunningBuilder>, KubernetesResource
{

    @JsonProperty("startedAt")
    private String startedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerStateRunning() {
    }

    public ContainerStateRunning(String startedAt) {
        super();
        this.startedAt = startedAt;
    }

    /**
     * ContainerStateRunning is a running state of a container.
     */
    @JsonProperty("startedAt")
    public String getStartedAt() {
        return startedAt;
    }

    /**
     * ContainerStateRunning is a running state of a container.
     */
    @JsonProperty("startedAt")
    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    @JsonIgnore
    public ContainerStateRunningBuilder edit() {
        return new ContainerStateRunningBuilder(this);
    }

    @JsonIgnore
    public ContainerStateRunningBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContainerStateRunning)) {
            return false;
        }
        ContainerStateRunning other = (ContainerStateRunning) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$startedAt = this.getStartedAt();
        Object other$startedAt = other.getStartedAt();
        if (this$startedAt == null ? other$startedAt != null : !this$startedAt.equals(other$startedAt)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ContainerStateRunning;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $startedAt = this.getStartedAt();
        result = result * prime + ($startedAt == null ? 43 : $startedAt.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerStateRunning(" + "startedAt=" + this.getStartedAt() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

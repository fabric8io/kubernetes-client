
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * UnhealthyCondition represents a Node condition type and value with a timeout specified as a duration.  When the named condition has been in the given status for at least the timeout value, a node is considered unhealthy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "timeout",
    "type"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class UnhealthyCondition implements Editable<UnhealthyConditionBuilder>, KubernetesResource
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("timeout")
    private String timeout;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public UnhealthyCondition() {
    }

    public UnhealthyCondition(String status, String timeout, String type) {
        super();
        this.status = status;
        this.timeout = timeout;
        this.type = type;
    }

    /**
     * UnhealthyCondition represents a Node condition type and value with a timeout specified as a duration.  When the named condition has been in the given status for at least the timeout value, a node is considered unhealthy.
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * UnhealthyCondition represents a Node condition type and value with a timeout specified as a duration.  When the named condition has been in the given status for at least the timeout value, a node is considered unhealthy.
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * UnhealthyCondition represents a Node condition type and value with a timeout specified as a duration.  When the named condition has been in the given status for at least the timeout value, a node is considered unhealthy.
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * UnhealthyCondition represents a Node condition type and value with a timeout specified as a duration.  When the named condition has been in the given status for at least the timeout value, a node is considered unhealthy.
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    /**
     * UnhealthyCondition represents a Node condition type and value with a timeout specified as a duration.  When the named condition has been in the given status for at least the timeout value, a node is considered unhealthy.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * UnhealthyCondition represents a Node condition type and value with a timeout specified as a duration.  When the named condition has been in the given status for at least the timeout value, a node is considered unhealthy.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public UnhealthyConditionBuilder edit() {
        return new UnhealthyConditionBuilder(this);
    }

    @JsonIgnore
    public UnhealthyConditionBuilder toBuilder() {
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

}

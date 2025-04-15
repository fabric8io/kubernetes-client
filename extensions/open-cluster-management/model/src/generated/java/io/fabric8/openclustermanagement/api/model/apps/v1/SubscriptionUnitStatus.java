
package io.fabric8.openclustermanagement.api.model.apps.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
 * SubscriptionUnitStatus defines status of each package in a subscription
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastUpdateTime",
    "message",
    "phase",
    "reason",
    "resourceStatus"
})
@ToString
@EqualsAndHashCode
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SubscriptionUnitStatus implements Editable<SubscriptionUnitStatusBuilder>, KubernetesResource
{

    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("message")
    private String message;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("resourceStatus")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object resourceStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubscriptionUnitStatus() {
    }

    public SubscriptionUnitStatus(String lastUpdateTime, String message, String phase, String reason, Object resourceStatus) {
        super();
        this.lastUpdateTime = lastUpdateTime;
        this.message = message;
        this.phase = phase;
        this.reason = reason;
        this.resourceStatus = resourceStatus;
    }

    /**
     * SubscriptionUnitStatus defines status of each package in a subscription
     */
    @JsonProperty("lastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * SubscriptionUnitStatus defines status of each package in a subscription
     */
    @JsonProperty("lastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * Informational message from the deployment of the package.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Informational message from the deployment of the package.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Phase of the deployment package (Propagated/Subscribed/Failed/PropagationFailed/PreHookSucessful).
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * Phase of the deployment package (Propagated/Subscribed/Failed/PropagationFailed/PreHookSucessful).
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * additional error output from the deployment of the package.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * additional error output from the deployment of the package.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * SubscriptionUnitStatus defines status of each package in a subscription
     */
    @JsonProperty("resourceStatus")
    public Object getResourceStatus() {
        return resourceStatus;
    }

    /**
     * SubscriptionUnitStatus defines status of each package in a subscription
     */
    @JsonProperty("resourceStatus")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setResourceStatus(Object resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    @JsonIgnore
    public SubscriptionUnitStatusBuilder edit() {
        return new SubscriptionUnitStatusBuilder(this);
    }

    @JsonIgnore
    public SubscriptionUnitStatusBuilder toBuilder() {
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

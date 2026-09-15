
package io.fabric8.kubernetes.api.model.ovn.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

/**
 * AdminPolicyBasedRouteStatus contains the observed status of the AdminPolicyBased route types.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastTransitionTime",
    "messages",
    "status"
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
public class AdminPolicyBasedRouteStatus implements Editable<AdminPolicyBasedRouteStatusBuilder>, KubernetesResource
{

    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;
    @JsonProperty("messages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> messages = new ArrayList<>();
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AdminPolicyBasedRouteStatus() {
    }

    public AdminPolicyBasedRouteStatus(String lastTransitionTime, List<String> messages, String status) {
        super();
        this.lastTransitionTime = lastTransitionTime;
        this.messages = messages;
        this.status = status;
    }

    /**
     * AdminPolicyBasedRouteStatus contains the observed status of the AdminPolicyBased route types.
     */
    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    /**
     * AdminPolicyBasedRouteStatus contains the observed status of the AdminPolicyBased route types.
     */
    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    /**
     * An array of Human-readable messages indicating details about the status of the object.
     */
    @JsonProperty("messages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMessages() {
        return messages;
    }

    /**
     * An array of Human-readable messages indicating details about the status of the object.
     */
    @JsonProperty("messages")
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    /**
     * A concise indication of whether the AdminPolicyBasedRoute resource is applied with success
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * A concise indication of whether the AdminPolicyBasedRoute resource is applied with success
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonIgnore
    public AdminPolicyBasedRouteStatusBuilder edit() {
        return new AdminPolicyBasedRouteStatusBuilder(this);
    }

    @JsonIgnore
    public AdminPolicyBasedRouteStatusBuilder toBuilder() {
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
        if (!(o instanceof AdminPolicyBasedRouteStatus)) {
            return false;
        }
        AdminPolicyBasedRouteStatus other = (AdminPolicyBasedRouteStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$lastTransitionTime = this.getLastTransitionTime();
        Object other$lastTransitionTime = other.getLastTransitionTime();
        if (this$lastTransitionTime == null ? other$lastTransitionTime != null : !this$lastTransitionTime.equals(other$lastTransitionTime)) {
            return false;
        }
        Object this$messages = this.getMessages();
        Object other$messages = other.getMessages();
        if (this$messages == null ? other$messages != null : !this$messages.equals(other$messages)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
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
        return other instanceof AdminPolicyBasedRouteStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lastTransitionTime = this.getLastTransitionTime();
        result = result * prime + ($lastTransitionTime == null ? 43 : $lastTransitionTime.hashCode());
        Object $messages = this.getMessages();
        result = result * prime + ($messages == null ? 43 : $messages.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AdminPolicyBasedRouteStatus(" + "lastTransitionTime=" + this.getLastTransitionTime() + ", messages=" + this.getMessages() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

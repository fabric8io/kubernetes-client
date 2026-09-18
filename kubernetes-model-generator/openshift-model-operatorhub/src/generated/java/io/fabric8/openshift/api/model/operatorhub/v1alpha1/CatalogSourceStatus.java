
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Condition;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "configMapReference",
    "connectionState",
    "latestImageRegistryPoll",
    "message",
    "reason",
    "registryService"
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
public class CatalogSourceStatus implements Editable<CatalogSourceStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("configMapReference")
    private ConfigMapResourceReference configMapReference;
    @JsonProperty("connectionState")
    private GRPCConnectionState connectionState;
    @JsonProperty("latestImageRegistryPoll")
    private String latestImageRegistryPoll;
    @JsonProperty("message")
    private String message;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("registryService")
    private RegistryServiceStatus registryService;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CatalogSourceStatus() {
    }

    public CatalogSourceStatus(List<Condition> conditions, ConfigMapResourceReference configMapReference, GRPCConnectionState connectionState, String latestImageRegistryPoll, String message, String reason, RegistryServiceStatus registryService) {
        super();
        this.conditions = conditions;
        this.configMapReference = configMapReference;
        this.connectionState = connectionState;
        this.latestImageRegistryPoll = latestImageRegistryPoll;
        this.message = message;
        this.reason = reason;
        this.registryService = registryService;
    }

    /**
     * Represents the state of a CatalogSource. Note that Message and Reason represent the original status information, which may be migrated to be conditions based in the future. Any new features introduced will use conditions.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Represents the state of a CatalogSource. Note that Message and Reason represent the original status information, which may be migrated to be conditions based in the future. Any new features introduced will use conditions.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("configMapReference")
    public ConfigMapResourceReference getConfigMapReference() {
        return configMapReference;
    }

    @JsonProperty("configMapReference")
    public void setConfigMapReference(ConfigMapResourceReference configMapReference) {
        this.configMapReference = configMapReference;
    }

    @JsonProperty("connectionState")
    public GRPCConnectionState getConnectionState() {
        return connectionState;
    }

    @JsonProperty("connectionState")
    public void setConnectionState(GRPCConnectionState connectionState) {
        this.connectionState = connectionState;
    }

    @JsonProperty("latestImageRegistryPoll")
    public String getLatestImageRegistryPoll() {
        return latestImageRegistryPoll;
    }

    @JsonProperty("latestImageRegistryPoll")
    public void setLatestImageRegistryPoll(String latestImageRegistryPoll) {
        this.latestImageRegistryPoll = latestImageRegistryPoll;
    }

    /**
     * A human readable message indicating details about why the CatalogSource is in this condition.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * A human readable message indicating details about why the CatalogSource is in this condition.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Reason is the reason the CatalogSource was transitioned to its current state.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * Reason is the reason the CatalogSource was transitioned to its current state.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("registryService")
    public RegistryServiceStatus getRegistryService() {
        return registryService;
    }

    @JsonProperty("registryService")
    public void setRegistryService(RegistryServiceStatus registryService) {
        this.registryService = registryService;
    }

    @JsonIgnore
    public CatalogSourceStatusBuilder edit() {
        return new CatalogSourceStatusBuilder(this);
    }

    @JsonIgnore
    public CatalogSourceStatusBuilder toBuilder() {
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
        if (!(o instanceof CatalogSourceStatus)) {
            return false;
        }
        CatalogSourceStatus other = (CatalogSourceStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$configMapReference = this.getConfigMapReference();
        Object other$configMapReference = other.getConfigMapReference();
        if (this$configMapReference == null ? other$configMapReference != null : !this$configMapReference.equals(other$configMapReference)) {
            return false;
        }
        Object this$connectionState = this.getConnectionState();
        Object other$connectionState = other.getConnectionState();
        if (this$connectionState == null ? other$connectionState != null : !this$connectionState.equals(other$connectionState)) {
            return false;
        }
        Object this$latestImageRegistryPoll = this.getLatestImageRegistryPoll();
        Object other$latestImageRegistryPoll = other.getLatestImageRegistryPoll();
        if (this$latestImageRegistryPoll == null ? other$latestImageRegistryPoll != null : !this$latestImageRegistryPoll.equals(other$latestImageRegistryPoll)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$registryService = this.getRegistryService();
        Object other$registryService = other.getRegistryService();
        if (this$registryService == null ? other$registryService != null : !this$registryService.equals(other$registryService)) {
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
        return other instanceof CatalogSourceStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $configMapReference = this.getConfigMapReference();
        result = result * prime + ($configMapReference == null ? 43 : $configMapReference.hashCode());
        Object $connectionState = this.getConnectionState();
        result = result * prime + ($connectionState == null ? 43 : $connectionState.hashCode());
        Object $latestImageRegistryPoll = this.getLatestImageRegistryPoll();
        result = result * prime + ($latestImageRegistryPoll == null ? 43 : $latestImageRegistryPoll.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $registryService = this.getRegistryService();
        result = result * prime + ($registryService == null ? 43 : $registryService.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CatalogSourceStatus(" + "conditions=" + this.getConditions() + ", configMapReference=" + this.getConfigMapReference() + ", connectionState=" + this.getConnectionState() + ", latestImageRegistryPoll=" + this.getLatestImageRegistryPoll() + ", message=" + this.getMessage() + ", reason=" + this.getReason() + ", registryService=" + this.getRegistryService() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

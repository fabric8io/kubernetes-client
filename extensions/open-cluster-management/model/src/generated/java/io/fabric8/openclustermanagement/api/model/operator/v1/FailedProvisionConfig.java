
package io.fabric8.openclustermanagement.api.model.operator.v1;

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

/**
 * FailedProvisionConfig contains settings to control behavior undertaken by Hive when an installation attempt fails.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "skipGatherLogs"
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
public class FailedProvisionConfig implements Editable<FailedProvisionConfigBuilder>, KubernetesResource
{

    @JsonProperty("skipGatherLogs")
    private Boolean skipGatherLogs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FailedProvisionConfig() {
    }

    public FailedProvisionConfig(Boolean skipGatherLogs) {
        super();
        this.skipGatherLogs = skipGatherLogs;
    }

    /**
     * (Deprecated) SkipGatherLogs disables functionality that attempts to gather full logs from the cluster if an installation fails for any reason. The logs will be stored in a persistent volume for up to 7 days.
     */
    @JsonProperty("skipGatherLogs")
    public Boolean getSkipGatherLogs() {
        return skipGatherLogs;
    }

    /**
     * (Deprecated) SkipGatherLogs disables functionality that attempts to gather full logs from the cluster if an installation fails for any reason. The logs will be stored in a persistent volume for up to 7 days.
     */
    @JsonProperty("skipGatherLogs")
    public void setSkipGatherLogs(Boolean skipGatherLogs) {
        this.skipGatherLogs = skipGatherLogs;
    }

    @JsonIgnore
    public FailedProvisionConfigBuilder edit() {
        return new FailedProvisionConfigBuilder(this);
    }

    @JsonIgnore
    public FailedProvisionConfigBuilder toBuilder() {
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
        if (!(o instanceof FailedProvisionConfig)) {
            return false;
        }
        FailedProvisionConfig other = (FailedProvisionConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$skipGatherLogs = this.getSkipGatherLogs();
        Object other$skipGatherLogs = other.getSkipGatherLogs();
        if (this$skipGatherLogs == null ? other$skipGatherLogs != null : !this$skipGatherLogs.equals(other$skipGatherLogs)) {
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
        return other instanceof FailedProvisionConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $skipGatherLogs = this.getSkipGatherLogs();
        result = result * prime + ($skipGatherLogs == null ? 43 : $skipGatherLogs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FailedProvisionConfig(" + "skipGatherLogs=" + this.getSkipGatherLogs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

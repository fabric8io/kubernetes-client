
package io.fabric8.openshift.api.model.hive.gcp.v1;

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
 * PrivateServiceConnectAccess configures access to the cluster API using GCP Private Service Connect
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enabled",
    "serviceAttachment"
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
public class PrivateServiceConnect implements Editable<PrivateServiceConnectBuilder>, KubernetesResource
{

    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("serviceAttachment")
    private ServiceAttachment serviceAttachment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrivateServiceConnect() {
    }

    public PrivateServiceConnect(Boolean enabled, ServiceAttachment serviceAttachment) {
        super();
        this.enabled = enabled;
        this.serviceAttachment = serviceAttachment;
    }

    /**
     * Enabled specifies if Private Service Connect is to be enabled on the cluster.
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Enabled specifies if Private Service Connect is to be enabled on the cluster.
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * PrivateServiceConnectAccess configures access to the cluster API using GCP Private Service Connect
     */
    @JsonProperty("serviceAttachment")
    public ServiceAttachment getServiceAttachment() {
        return serviceAttachment;
    }

    /**
     * PrivateServiceConnectAccess configures access to the cluster API using GCP Private Service Connect
     */
    @JsonProperty("serviceAttachment")
    public void setServiceAttachment(ServiceAttachment serviceAttachment) {
        this.serviceAttachment = serviceAttachment;
    }

    @JsonIgnore
    public PrivateServiceConnectBuilder edit() {
        return new PrivateServiceConnectBuilder(this);
    }

    @JsonIgnore
    public PrivateServiceConnectBuilder toBuilder() {
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
        if (!(o instanceof PrivateServiceConnect)) {
            return false;
        }
        PrivateServiceConnect other = (PrivateServiceConnect) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$enabled = this.getEnabled();
        Object other$enabled = other.getEnabled();
        if (this$enabled == null ? other$enabled != null : !this$enabled.equals(other$enabled)) {
            return false;
        }
        Object this$serviceAttachment = this.getServiceAttachment();
        Object other$serviceAttachment = other.getServiceAttachment();
        if (this$serviceAttachment == null ? other$serviceAttachment != null : !this$serviceAttachment.equals(other$serviceAttachment)) {
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
        return other instanceof PrivateServiceConnect;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $enabled = this.getEnabled();
        result = result * prime + ($enabled == null ? 43 : $enabled.hashCode());
        Object $serviceAttachment = this.getServiceAttachment();
        result = result * prime + ($serviceAttachment == null ? 43 : $serviceAttachment.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrivateServiceConnect(" + "enabled=" + this.getEnabled() + ", serviceAttachment=" + this.getServiceAttachment() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}


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
 * ServiceAttachmentSubnet configures the subnetwork used by the service attachment
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidr",
    "existing"
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
public class ServiceAttachmentSubnet implements Editable<ServiceAttachmentSubnetBuilder>, KubernetesResource
{

    @JsonProperty("cidr")
    private String cidr;
    @JsonProperty("existing")
    private ServiceAttachmentSubnetExisting existing;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServiceAttachmentSubnet() {
    }

    public ServiceAttachmentSubnet(String cidr, ServiceAttachmentSubnetExisting existing) {
        super();
        this.cidr = cidr;
        this.existing = existing;
    }

    /**
     * Cidr specifies the cidr to use when creating a service attachment subnet.
     */
    @JsonProperty("cidr")
    public String getCidr() {
        return cidr;
    }

    /**
     * Cidr specifies the cidr to use when creating a service attachment subnet.
     */
    @JsonProperty("cidr")
    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    /**
     * ServiceAttachmentSubnet configures the subnetwork used by the service attachment
     */
    @JsonProperty("existing")
    public ServiceAttachmentSubnetExisting getExisting() {
        return existing;
    }

    /**
     * ServiceAttachmentSubnet configures the subnetwork used by the service attachment
     */
    @JsonProperty("existing")
    public void setExisting(ServiceAttachmentSubnetExisting existing) {
        this.existing = existing;
    }

    @JsonIgnore
    public ServiceAttachmentSubnetBuilder edit() {
        return new ServiceAttachmentSubnetBuilder(this);
    }

    @JsonIgnore
    public ServiceAttachmentSubnetBuilder toBuilder() {
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
        if (!(o instanceof ServiceAttachmentSubnet)) {
            return false;
        }
        ServiceAttachmentSubnet other = (ServiceAttachmentSubnet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cidr = this.getCidr();
        Object other$cidr = other.getCidr();
        if (this$cidr == null ? other$cidr != null : !this$cidr.equals(other$cidr)) {
            return false;
        }
        Object this$existing = this.getExisting();
        Object other$existing = other.getExisting();
        if (this$existing == null ? other$existing != null : !this$existing.equals(other$existing)) {
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
        return other instanceof ServiceAttachmentSubnet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cidr = this.getCidr();
        result = result * prime + ($cidr == null ? 43 : $cidr.hashCode());
        Object $existing = this.getExisting();
        result = result * prime + ($existing == null ? 43 : $existing.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ServiceAttachmentSubnet(" + "cidr=" + this.getCidr() + ", existing=" + this.getExisting() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

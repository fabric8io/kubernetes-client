
package io.fabric8.openshift.api.model.hive.v1;

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
 * AWSPrivateLinkSubnet defines a subnet in the an AWS VPC.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availabilityZone",
    "subnetID"
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
public class AWSPrivateLinkSubnet implements Editable<AWSPrivateLinkSubnetBuilder>, KubernetesResource
{

    @JsonProperty("availabilityZone")
    private String availabilityZone;
    @JsonProperty("subnetID")
    private String subnetID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSPrivateLinkSubnet() {
    }

    public AWSPrivateLinkSubnet(String availabilityZone, String subnetID) {
        super();
        this.availabilityZone = availabilityZone;
        this.subnetID = subnetID;
    }

    /**
     * AWSPrivateLinkSubnet defines a subnet in the an AWS VPC.
     */
    @JsonProperty("availabilityZone")
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /**
     * AWSPrivateLinkSubnet defines a subnet in the an AWS VPC.
     */
    @JsonProperty("availabilityZone")
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    /**
     * AWSPrivateLinkSubnet defines a subnet in the an AWS VPC.
     */
    @JsonProperty("subnetID")
    public String getSubnetID() {
        return subnetID;
    }

    /**
     * AWSPrivateLinkSubnet defines a subnet in the an AWS VPC.
     */
    @JsonProperty("subnetID")
    public void setSubnetID(String subnetID) {
        this.subnetID = subnetID;
    }

    @JsonIgnore
    public AWSPrivateLinkSubnetBuilder edit() {
        return new AWSPrivateLinkSubnetBuilder(this);
    }

    @JsonIgnore
    public AWSPrivateLinkSubnetBuilder toBuilder() {
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
        if (!(o instanceof AWSPrivateLinkSubnet)) {
            return false;
        }
        AWSPrivateLinkSubnet other = (AWSPrivateLinkSubnet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$availabilityZone = this.getAvailabilityZone();
        Object other$availabilityZone = other.getAvailabilityZone();
        if (this$availabilityZone == null ? other$availabilityZone != null : !this$availabilityZone.equals(other$availabilityZone)) {
            return false;
        }
        Object this$subnetID = this.getSubnetID();
        Object other$subnetID = other.getSubnetID();
        if (this$subnetID == null ? other$subnetID != null : !this$subnetID.equals(other$subnetID)) {
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
        return other instanceof AWSPrivateLinkSubnet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $availabilityZone = this.getAvailabilityZone();
        result = result * prime + ($availabilityZone == null ? 43 : $availabilityZone.hashCode());
        Object $subnetID = this.getSubnetID();
        result = result * prime + ($subnetID == null ? 43 : $subnetID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSPrivateLinkSubnet(" + "availabilityZone=" + this.getAvailabilityZone() + ", subnetID=" + this.getSubnetID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

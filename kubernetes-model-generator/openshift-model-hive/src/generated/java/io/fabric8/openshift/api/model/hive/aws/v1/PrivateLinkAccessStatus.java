
package io.fabric8.openshift.api.model.hive.aws.v1;

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
 * PrivateLinkAccessStatus contains the observed state for PrivateLinkAccess resources.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostedZoneID",
    "vpcEndpointID",
    "vpcEndpointService"
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
public class PrivateLinkAccessStatus implements Editable<PrivateLinkAccessStatusBuilder>, KubernetesResource
{

    @JsonProperty("hostedZoneID")
    private String hostedZoneID;
    @JsonProperty("vpcEndpointID")
    private String vpcEndpointID;
    @JsonProperty("vpcEndpointService")
    private VPCEndpointService vpcEndpointService;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrivateLinkAccessStatus() {
    }

    public PrivateLinkAccessStatus(String hostedZoneID, String vpcEndpointID, VPCEndpointService vpcEndpointService) {
        super();
        this.hostedZoneID = hostedZoneID;
        this.vpcEndpointID = vpcEndpointID;
        this.vpcEndpointService = vpcEndpointService;
    }

    /**
     * PrivateLinkAccessStatus contains the observed state for PrivateLinkAccess resources.
     */
    @JsonProperty("hostedZoneID")
    public String getHostedZoneID() {
        return hostedZoneID;
    }

    /**
     * PrivateLinkAccessStatus contains the observed state for PrivateLinkAccess resources.
     */
    @JsonProperty("hostedZoneID")
    public void setHostedZoneID(String hostedZoneID) {
        this.hostedZoneID = hostedZoneID;
    }

    /**
     * PrivateLinkAccessStatus contains the observed state for PrivateLinkAccess resources.
     */
    @JsonProperty("vpcEndpointID")
    public String getVpcEndpointID() {
        return vpcEndpointID;
    }

    /**
     * PrivateLinkAccessStatus contains the observed state for PrivateLinkAccess resources.
     */
    @JsonProperty("vpcEndpointID")
    public void setVpcEndpointID(String vpcEndpointID) {
        this.vpcEndpointID = vpcEndpointID;
    }

    /**
     * PrivateLinkAccessStatus contains the observed state for PrivateLinkAccess resources.
     */
    @JsonProperty("vpcEndpointService")
    public VPCEndpointService getVpcEndpointService() {
        return vpcEndpointService;
    }

    /**
     * PrivateLinkAccessStatus contains the observed state for PrivateLinkAccess resources.
     */
    @JsonProperty("vpcEndpointService")
    public void setVpcEndpointService(VPCEndpointService vpcEndpointService) {
        this.vpcEndpointService = vpcEndpointService;
    }

    @JsonIgnore
    public PrivateLinkAccessStatusBuilder edit() {
        return new PrivateLinkAccessStatusBuilder(this);
    }

    @JsonIgnore
    public PrivateLinkAccessStatusBuilder toBuilder() {
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
        if (!(o instanceof PrivateLinkAccessStatus)) {
            return false;
        }
        PrivateLinkAccessStatus other = (PrivateLinkAccessStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hostedZoneID = this.getHostedZoneID();
        Object other$hostedZoneID = other.getHostedZoneID();
        if (this$hostedZoneID == null ? other$hostedZoneID != null : !this$hostedZoneID.equals(other$hostedZoneID)) {
            return false;
        }
        Object this$vpcEndpointID = this.getVpcEndpointID();
        Object other$vpcEndpointID = other.getVpcEndpointID();
        if (this$vpcEndpointID == null ? other$vpcEndpointID != null : !this$vpcEndpointID.equals(other$vpcEndpointID)) {
            return false;
        }
        Object this$vpcEndpointService = this.getVpcEndpointService();
        Object other$vpcEndpointService = other.getVpcEndpointService();
        if (this$vpcEndpointService == null ? other$vpcEndpointService != null : !this$vpcEndpointService.equals(other$vpcEndpointService)) {
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
        return other instanceof PrivateLinkAccessStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hostedZoneID = this.getHostedZoneID();
        result = result * prime + ($hostedZoneID == null ? 43 : $hostedZoneID.hashCode());
        Object $vpcEndpointID = this.getVpcEndpointID();
        result = result * prime + ($vpcEndpointID == null ? 43 : $vpcEndpointID.hashCode());
        Object $vpcEndpointService = this.getVpcEndpointService();
        result = result * prime + ($vpcEndpointService == null ? 43 : $vpcEndpointService.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrivateLinkAccessStatus(" + "hostedZoneID=" + this.getHostedZoneID() + ", vpcEndpointID=" + this.getVpcEndpointID() + ", vpcEndpointService=" + this.getVpcEndpointService() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

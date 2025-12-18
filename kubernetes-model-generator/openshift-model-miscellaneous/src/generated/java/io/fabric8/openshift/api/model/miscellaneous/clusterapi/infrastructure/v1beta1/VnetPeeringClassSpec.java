
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

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
 * VnetPeeringClassSpec specifies a virtual network peering class.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "forwardPeeringProperties",
    "remoteVnetName",
    "resourceGroup",
    "reversePeeringProperties"
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
public class VnetPeeringClassSpec implements Editable<VnetPeeringClassSpecBuilder>, KubernetesResource
{

    @JsonProperty("forwardPeeringProperties")
    private VnetPeeringProperties forwardPeeringProperties;
    @JsonProperty("remoteVnetName")
    private String remoteVnetName;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("reversePeeringProperties")
    private VnetPeeringProperties reversePeeringProperties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VnetPeeringClassSpec() {
    }

    public VnetPeeringClassSpec(VnetPeeringProperties forwardPeeringProperties, String remoteVnetName, String resourceGroup, VnetPeeringProperties reversePeeringProperties) {
        super();
        this.forwardPeeringProperties = forwardPeeringProperties;
        this.remoteVnetName = remoteVnetName;
        this.resourceGroup = resourceGroup;
        this.reversePeeringProperties = reversePeeringProperties;
    }

    /**
     * VnetPeeringClassSpec specifies a virtual network peering class.
     */
    @JsonProperty("forwardPeeringProperties")
    public VnetPeeringProperties getForwardPeeringProperties() {
        return forwardPeeringProperties;
    }

    /**
     * VnetPeeringClassSpec specifies a virtual network peering class.
     */
    @JsonProperty("forwardPeeringProperties")
    public void setForwardPeeringProperties(VnetPeeringProperties forwardPeeringProperties) {
        this.forwardPeeringProperties = forwardPeeringProperties;
    }

    /**
     * RemoteVnetName defines name of the remote virtual network.
     */
    @JsonProperty("remoteVnetName")
    public String getRemoteVnetName() {
        return remoteVnetName;
    }

    /**
     * RemoteVnetName defines name of the remote virtual network.
     */
    @JsonProperty("remoteVnetName")
    public void setRemoteVnetName(String remoteVnetName) {
        this.remoteVnetName = remoteVnetName;
    }

    /**
     * ResourceGroup is the resource group name of the remote virtual network.
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * ResourceGroup is the resource group name of the remote virtual network.
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * VnetPeeringClassSpec specifies a virtual network peering class.
     */
    @JsonProperty("reversePeeringProperties")
    public VnetPeeringProperties getReversePeeringProperties() {
        return reversePeeringProperties;
    }

    /**
     * VnetPeeringClassSpec specifies a virtual network peering class.
     */
    @JsonProperty("reversePeeringProperties")
    public void setReversePeeringProperties(VnetPeeringProperties reversePeeringProperties) {
        this.reversePeeringProperties = reversePeeringProperties;
    }

    @JsonIgnore
    public VnetPeeringClassSpecBuilder edit() {
        return new VnetPeeringClassSpecBuilder(this);
    }

    @JsonIgnore
    public VnetPeeringClassSpecBuilder toBuilder() {
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

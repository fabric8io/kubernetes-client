
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * NetworkClassSpec defines the NetworkSpec properties that may be shared across several Azure clusters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "privateDNSZoneName",
    "privateDNSZoneResourceGroup"
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
public class NetworkClassSpec implements Editable<NetworkClassSpecBuilder>, KubernetesResource
{

    @JsonProperty("privateDNSZoneName")
    private String privateDNSZoneName;
    @JsonProperty("privateDNSZoneResourceGroup")
    private String privateDNSZoneResourceGroup;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkClassSpec() {
    }

    public NetworkClassSpec(String privateDNSZoneName, String privateDNSZoneResourceGroup) {
        super();
        this.privateDNSZoneName = privateDNSZoneName;
        this.privateDNSZoneResourceGroup = privateDNSZoneResourceGroup;
    }

    /**
     * PrivateDNSZoneName defines the zone name for the Azure Private DNS.
     */
    @JsonProperty("privateDNSZoneName")
    public String getPrivateDNSZoneName() {
        return privateDNSZoneName;
    }

    /**
     * PrivateDNSZoneName defines the zone name for the Azure Private DNS.
     */
    @JsonProperty("privateDNSZoneName")
    public void setPrivateDNSZoneName(String privateDNSZoneName) {
        this.privateDNSZoneName = privateDNSZoneName;
    }

    /**
     * PrivateDNSZoneResourceGroup defines the resource group to be used for Azure Private DNS Zone. If not specified, the resource group of the cluster will be used to create the Azure Private DNS Zone.
     */
    @JsonProperty("privateDNSZoneResourceGroup")
    public String getPrivateDNSZoneResourceGroup() {
        return privateDNSZoneResourceGroup;
    }

    /**
     * PrivateDNSZoneResourceGroup defines the resource group to be used for Azure Private DNS Zone. If not specified, the resource group of the cluster will be used to create the Azure Private DNS Zone.
     */
    @JsonProperty("privateDNSZoneResourceGroup")
    public void setPrivateDNSZoneResourceGroup(String privateDNSZoneResourceGroup) {
        this.privateDNSZoneResourceGroup = privateDNSZoneResourceGroup;
    }

    @JsonIgnore
    public NetworkClassSpecBuilder edit() {
        return new NetworkClassSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkClassSpecBuilder toBuilder() {
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

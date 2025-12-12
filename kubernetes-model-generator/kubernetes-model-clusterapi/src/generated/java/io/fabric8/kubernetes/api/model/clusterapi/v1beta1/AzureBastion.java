
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
 * AzureBastion specifies how the Azure Bastion cloud component should be configured.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enableTunneling",
    "name",
    "publicIP",
    "sku",
    "subnet"
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
public class AzureBastion implements Editable<AzureBastionBuilder>, KubernetesResource
{

    @JsonProperty("enableTunneling")
    private Boolean enableTunneling;
    @JsonProperty("name")
    private String name;
    @JsonProperty("publicIP")
    private PublicIPSpec publicIP;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("subnet")
    private SubnetSpec subnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureBastion() {
    }

    public AzureBastion(Boolean enableTunneling, String name, PublicIPSpec publicIP, String sku, SubnetSpec subnet) {
        super();
        this.enableTunneling = enableTunneling;
        this.name = name;
        this.publicIP = publicIP;
        this.sku = sku;
        this.subnet = subnet;
    }

    /**
     * EnableTunneling enables the native client support feature for the Azure Bastion Host. Defaults to false.
     */
    @JsonProperty("enableTunneling")
    public Boolean getEnableTunneling() {
        return enableTunneling;
    }

    /**
     * EnableTunneling enables the native client support feature for the Azure Bastion Host. Defaults to false.
     */
    @JsonProperty("enableTunneling")
    public void setEnableTunneling(Boolean enableTunneling) {
        this.enableTunneling = enableTunneling;
    }

    /**
     * AzureBastion specifies how the Azure Bastion cloud component should be configured.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * AzureBastion specifies how the Azure Bastion cloud component should be configured.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * AzureBastion specifies how the Azure Bastion cloud component should be configured.
     */
    @JsonProperty("publicIP")
    public PublicIPSpec getPublicIP() {
        return publicIP;
    }

    /**
     * AzureBastion specifies how the Azure Bastion cloud component should be configured.
     */
    @JsonProperty("publicIP")
    public void setPublicIP(PublicIPSpec publicIP) {
        this.publicIP = publicIP;
    }

    /**
     * BastionHostSkuName configures the tier of the Azure Bastion Host. Can be either Basic or Standard. Defaults to Basic.
     */
    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    /**
     * BastionHostSkuName configures the tier of the Azure Bastion Host. Can be either Basic or Standard. Defaults to Basic.
     */
    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * AzureBastion specifies how the Azure Bastion cloud component should be configured.
     */
    @JsonProperty("subnet")
    public SubnetSpec getSubnet() {
        return subnet;
    }

    /**
     * AzureBastion specifies how the Azure Bastion cloud component should be configured.
     */
    @JsonProperty("subnet")
    public void setSubnet(SubnetSpec subnet) {
        this.subnet = subnet;
    }

    @JsonIgnore
    public AzureBastionBuilder edit() {
        return new AzureBastionBuilder(this);
    }

    @JsonIgnore
    public AzureBastionBuilder toBuilder() {
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

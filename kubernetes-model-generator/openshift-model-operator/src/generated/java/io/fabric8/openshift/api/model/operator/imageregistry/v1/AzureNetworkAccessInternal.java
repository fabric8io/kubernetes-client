
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "networkResourceGroupName",
    "privateEndpointName",
    "subnetName",
    "vnetName"
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
public class AzureNetworkAccessInternal implements Editable<AzureNetworkAccessInternalBuilder>, KubernetesResource
{

    @JsonProperty("networkResourceGroupName")
    private String networkResourceGroupName;
    @JsonProperty("privateEndpointName")
    private String privateEndpointName;
    @JsonProperty("subnetName")
    private String subnetName;
    @JsonProperty("vnetName")
    private String vnetName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureNetworkAccessInternal() {
    }

    public AzureNetworkAccessInternal(String networkResourceGroupName, String privateEndpointName, String subnetName, String vnetName) {
        super();
        this.networkResourceGroupName = networkResourceGroupName;
        this.privateEndpointName = privateEndpointName;
        this.subnetName = subnetName;
        this.vnetName = vnetName;
    }

    /**
     * networkResourceGroupName is the resource group name where the cluster's vnet and subnet are. When omitted, the registry operator will use the cluster resource group (from in the infrastructure status). If you set a networkResourceGroupName on your install-config.yaml, that value will be used automatically (for clusters configured with publish:Internal). Note that both vnet and subnet must be in the same resource group. It must be between 1 and 90 characters in length and must consist only of alphanumeric characters, hyphens (-), periods (.) and underscores (_), and not end with a period.
     */
    @JsonProperty("networkResourceGroupName")
    public String getNetworkResourceGroupName() {
        return networkResourceGroupName;
    }

    /**
     * networkResourceGroupName is the resource group name where the cluster's vnet and subnet are. When omitted, the registry operator will use the cluster resource group (from in the infrastructure status). If you set a networkResourceGroupName on your install-config.yaml, that value will be used automatically (for clusters configured with publish:Internal). Note that both vnet and subnet must be in the same resource group. It must be between 1 and 90 characters in length and must consist only of alphanumeric characters, hyphens (-), periods (.) and underscores (_), and not end with a period.
     */
    @JsonProperty("networkResourceGroupName")
    public void setNetworkResourceGroupName(String networkResourceGroupName) {
        this.networkResourceGroupName = networkResourceGroupName;
    }

    /**
     * privateEndpointName is the name of the private endpoint for the registry. When provided, the registry will use it as the name of the private endpoint it will create for the storage account. When omitted, the registry will generate one. It must be between 2 and 64 characters in length and must consist only of alphanumeric characters, hyphens (-), periods (.) and underscores (_). It must start with an alphanumeric character and end with an alphanumeric character or an underscore.
     */
    @JsonProperty("privateEndpointName")
    public String getPrivateEndpointName() {
        return privateEndpointName;
    }

    /**
     * privateEndpointName is the name of the private endpoint for the registry. When provided, the registry will use it as the name of the private endpoint it will create for the storage account. When omitted, the registry will generate one. It must be between 2 and 64 characters in length and must consist only of alphanumeric characters, hyphens (-), periods (.) and underscores (_). It must start with an alphanumeric character and end with an alphanumeric character or an underscore.
     */
    @JsonProperty("privateEndpointName")
    public void setPrivateEndpointName(String privateEndpointName) {
        this.privateEndpointName = privateEndpointName;
    }

    /**
     * subnetName is the name of the subnet the registry operates in. When omitted, the registry operator will discover and set this by using the `kubernetes.io_cluster.&lt;cluster-id&gt;` tag in the vnet resource, then using one of listed subnets. Advanced cluster network configurations that use network security groups to protect subnets should ensure the provided subnetName has access to Azure Storage service. It must be between 1 and 80 characters in length and must consist only of alphanumeric characters, hyphens (-), periods (.) and underscores (_).
     */
    @JsonProperty("subnetName")
    public String getSubnetName() {
        return subnetName;
    }

    /**
     * subnetName is the name of the subnet the registry operates in. When omitted, the registry operator will discover and set this by using the `kubernetes.io_cluster.&lt;cluster-id&gt;` tag in the vnet resource, then using one of listed subnets. Advanced cluster network configurations that use network security groups to protect subnets should ensure the provided subnetName has access to Azure Storage service. It must be between 1 and 80 characters in length and must consist only of alphanumeric characters, hyphens (-), periods (.) and underscores (_).
     */
    @JsonProperty("subnetName")
    public void setSubnetName(String subnetName) {
        this.subnetName = subnetName;
    }

    /**
     * vnetName is the name of the vnet the registry operates in. When omitted, the registry operator will discover and set this by using the `kubernetes.io_cluster.&lt;cluster-id&gt;` tag in the vnet resource. This tag is set automatically by the installer. Commonly, this will be the same vnet as the cluster. Advanced cluster network configurations should ensure the provided vnetName is the vnet of the nodes where the image registry pods are running from. It must be between 2 and 64 characters in length and must consist only of alphanumeric characters, hyphens (-), periods (.) and underscores (_). It must start with an alphanumeric character and end with an alphanumeric character or an underscore.
     */
    @JsonProperty("vnetName")
    public String getVnetName() {
        return vnetName;
    }

    /**
     * vnetName is the name of the vnet the registry operates in. When omitted, the registry operator will discover and set this by using the `kubernetes.io_cluster.&lt;cluster-id&gt;` tag in the vnet resource. This tag is set automatically by the installer. Commonly, this will be the same vnet as the cluster. Advanced cluster network configurations should ensure the provided vnetName is the vnet of the nodes where the image registry pods are running from. It must be between 2 and 64 characters in length and must consist only of alphanumeric characters, hyphens (-), periods (.) and underscores (_). It must start with an alphanumeric character and end with an alphanumeric character or an underscore.
     */
    @JsonProperty("vnetName")
    public void setVnetName(String vnetName) {
        this.vnetName = vnetName;
    }

    @JsonIgnore
    public AzureNetworkAccessInternalBuilder edit() {
        return new AzureNetworkAccessInternalBuilder(this);
    }

    @JsonIgnore
    public AzureNetworkAccessInternalBuilder toBuilder() {
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

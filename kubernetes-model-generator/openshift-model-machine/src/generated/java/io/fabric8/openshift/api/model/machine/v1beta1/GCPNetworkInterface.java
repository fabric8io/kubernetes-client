
package io.fabric8.openshift.api.model.machine.v1beta1;

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

/**
 * GCPNetworkInterface describes network interfaces for GCP
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "network",
    "projectID",
    "publicIP",
    "subnetwork"
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
public class GCPNetworkInterface implements Editable<GCPNetworkInterfaceBuilder>, KubernetesResource
{

    @JsonProperty("network")
    private String network;
    @JsonProperty("projectID")
    private String projectID;
    @JsonProperty("publicIP")
    private Boolean publicIP;
    @JsonProperty("subnetwork")
    private String subnetwork;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPNetworkInterface() {
    }

    public GCPNetworkInterface(String network, String projectID, Boolean publicIP, String subnetwork) {
        super();
        this.network = network;
        this.projectID = projectID;
        this.publicIP = publicIP;
        this.subnetwork = subnetwork;
    }

    /**
     * network is the network name.
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * network is the network name.
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * projectID is the project in which the GCP machine provider will create the VM.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * projectID is the project in which the GCP machine provider will create the VM.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * publicIP indicates if true a public IP will be used
     */
    @JsonProperty("publicIP")
    public Boolean getPublicIP() {
        return publicIP;
    }

    /**
     * publicIP indicates if true a public IP will be used
     */
    @JsonProperty("publicIP")
    public void setPublicIP(Boolean publicIP) {
        this.publicIP = publicIP;
    }

    /**
     * subnetwork is the subnetwork name.
     */
    @JsonProperty("subnetwork")
    public String getSubnetwork() {
        return subnetwork;
    }

    /**
     * subnetwork is the subnetwork name.
     */
    @JsonProperty("subnetwork")
    public void setSubnetwork(String subnetwork) {
        this.subnetwork = subnetwork;
    }

    @JsonIgnore
    public GCPNetworkInterfaceBuilder edit() {
        return new GCPNetworkInterfaceBuilder(this);
    }

    @JsonIgnore
    public GCPNetworkInterfaceBuilder toBuilder() {
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
        if (!(o instanceof GCPNetworkInterface)) {
            return false;
        }
        GCPNetworkInterface other = (GCPNetworkInterface) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$network = this.getNetwork();
        Object other$network = other.getNetwork();
        if (this$network == null ? other$network != null : !this$network.equals(other$network)) {
            return false;
        }
        Object this$projectID = this.getProjectID();
        Object other$projectID = other.getProjectID();
        if (this$projectID == null ? other$projectID != null : !this$projectID.equals(other$projectID)) {
            return false;
        }
        Object this$publicIP = this.getPublicIP();
        Object other$publicIP = other.getPublicIP();
        if (this$publicIP == null ? other$publicIP != null : !this$publicIP.equals(other$publicIP)) {
            return false;
        }
        Object this$subnetwork = this.getSubnetwork();
        Object other$subnetwork = other.getSubnetwork();
        if (this$subnetwork == null ? other$subnetwork != null : !this$subnetwork.equals(other$subnetwork)) {
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
        return other instanceof GCPNetworkInterface;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $network = this.getNetwork();
        result = result * prime + ($network == null ? 43 : $network.hashCode());
        Object $projectID = this.getProjectID();
        result = result * prime + ($projectID == null ? 43 : $projectID.hashCode());
        Object $publicIP = this.getPublicIP();
        result = result * prime + ($publicIP == null ? 43 : $publicIP.hashCode());
        Object $subnetwork = this.getSubnetwork();
        result = result * prime + ($subnetwork == null ? 43 : $subnetwork.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GCPNetworkInterface(" + "network=" + this.getNetwork() + ", projectID=" + this.getProjectID() + ", publicIP=" + this.getPublicIP() + ", subnetwork=" + this.getSubnetwork() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

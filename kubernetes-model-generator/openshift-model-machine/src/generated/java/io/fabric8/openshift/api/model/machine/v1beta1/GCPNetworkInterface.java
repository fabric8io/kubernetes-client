
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
     * Network is the network name.
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * Network is the network name.
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * ProjectID is the project in which the GCP machine provider will create the VM.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * ProjectID is the project in which the GCP machine provider will create the VM.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * PublicIP indicates if true a public IP will be used
     */
    @JsonProperty("publicIP")
    public Boolean getPublicIP() {
        return publicIP;
    }

    /**
     * PublicIP indicates if true a public IP will be used
     */
    @JsonProperty("publicIP")
    public void setPublicIP(Boolean publicIP) {
        this.publicIP = publicIP;
    }

    /**
     * Subnetwork is the subnetwork name.
     */
    @JsonProperty("subnetwork")
    public String getSubnetwork() {
        return subnetwork;
    }

    /**
     * Subnetwork is the subnetwork name.
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

}

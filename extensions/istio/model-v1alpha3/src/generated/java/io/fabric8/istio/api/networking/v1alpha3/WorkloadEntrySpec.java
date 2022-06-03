
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "address",
    "labels",
    "locality",
    "network",
    "ports",
    "serviceAccount",
    "weight"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class WorkloadEntrySpec implements KubernetesResource
{

    @JsonProperty("address")
    private java.lang.String address;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<String, String>();
    @JsonProperty("locality")
    private java.lang.String locality;
    @JsonProperty("network")
    private java.lang.String network;
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Long> ports = new LinkedHashMap<String, Long>();
    @JsonProperty("serviceAccount")
    private java.lang.String serviceAccount;
    @JsonProperty("weight")
    private Integer weight;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WorkloadEntrySpec() {
    }

    /**
     * 
     * @param address
     * @param locality
     * @param weight
     * @param serviceAccount
     * @param ports
     * @param labels
     * @param network
     */
    public WorkloadEntrySpec(java.lang.String address, Map<String, String> labels, java.lang.String locality, java.lang.String network, Map<String, Long> ports, java.lang.String serviceAccount, Integer weight) {
        super();
        this.address = address;
        this.labels = labels;
        this.locality = locality;
        this.network = network;
        this.ports = ports;
        this.serviceAccount = serviceAccount;
        this.weight = weight;
    }

    @JsonProperty("address")
    public java.lang.String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("locality")
    public java.lang.String getLocality() {
        return locality;
    }

    @JsonProperty("locality")
    public void setLocality(java.lang.String locality) {
        this.locality = locality;
    }

    @JsonProperty("network")
    public java.lang.String getNetwork() {
        return network;
    }

    @JsonProperty("network")
    public void setNetwork(java.lang.String network) {
        this.network = network;
    }

    @JsonProperty("ports")
    public Map<String, Long> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(Map<String, Long> ports) {
        this.ports = ports;
    }

    @JsonProperty("serviceAccount")
    public java.lang.String getServiceAccount() {
        return serviceAccount;
    }

    @JsonProperty("serviceAccount")
    public void setServiceAccount(java.lang.String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

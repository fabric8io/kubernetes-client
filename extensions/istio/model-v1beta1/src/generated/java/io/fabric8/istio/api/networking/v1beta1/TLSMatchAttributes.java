
package io.fabric8.istio.api.networking.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
    "destinationSubnets",
    "gateways",
    "port",
    "sniHosts",
    "sourceLabels",
    "sourceNamespace"
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
public class TLSMatchAttributes implements KubernetesResource
{

    @JsonProperty("destinationSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> destinationSubnets = new ArrayList<java.lang.String>();
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> gateways = new ArrayList<java.lang.String>();
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("sniHosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> sniHosts = new ArrayList<java.lang.String>();
    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> sourceLabels = new LinkedHashMap<String, String>();
    @JsonProperty("sourceNamespace")
    private java.lang.String sourceNamespace;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TLSMatchAttributes() {
    }

    /**
     * 
     * @param gateways
     * @param sniHosts
     * @param destinationSubnets
     * @param port
     * @param sourceLabels
     * @param sourceNamespace
     */
    public TLSMatchAttributes(List<java.lang.String> destinationSubnets, List<java.lang.String> gateways, Integer port, List<java.lang.String> sniHosts, Map<String, String> sourceLabels, java.lang.String sourceNamespace) {
        super();
        this.destinationSubnets = destinationSubnets;
        this.gateways = gateways;
        this.port = port;
        this.sniHosts = sniHosts;
        this.sourceLabels = sourceLabels;
        this.sourceNamespace = sourceNamespace;
    }

    @JsonProperty("destinationSubnets")
    public List<java.lang.String> getDestinationSubnets() {
        return destinationSubnets;
    }

    @JsonProperty("destinationSubnets")
    public void setDestinationSubnets(List<java.lang.String> destinationSubnets) {
        this.destinationSubnets = destinationSubnets;
    }

    @JsonProperty("gateways")
    public List<java.lang.String> getGateways() {
        return gateways;
    }

    @JsonProperty("gateways")
    public void setGateways(List<java.lang.String> gateways) {
        this.gateways = gateways;
    }

    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonProperty("sniHosts")
    public List<java.lang.String> getSniHosts() {
        return sniHosts;
    }

    @JsonProperty("sniHosts")
    public void setSniHosts(List<java.lang.String> sniHosts) {
        this.sniHosts = sniHosts;
    }

    @JsonProperty("sourceLabels")
    public Map<String, String> getSourceLabels() {
        return sourceLabels;
    }

    @JsonProperty("sourceLabels")
    public void setSourceLabels(Map<String, String> sourceLabels) {
        this.sourceLabels = sourceLabels;
    }

    @JsonProperty("sourceNamespace")
    public java.lang.String getSourceNamespace() {
        return sourceNamespace;
    }

    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(java.lang.String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
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

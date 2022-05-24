
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
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
    "applicationProtocols",
    "destinationPort",
    "filter",
    "name",
    "sni",
    "transportProtocol"
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
public class EnvoyFilterListenerMatchFilterChainMatch implements KubernetesResource
{

    @JsonProperty("applicationProtocols")
    private String applicationProtocols;
    @JsonProperty("destinationPort")
    private Integer destinationPort;
    @JsonProperty("filter")
    private EnvoyFilterListenerMatchFilterMatch filter;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sni")
    private String sni;
    @JsonProperty("transportProtocol")
    private String transportProtocol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EnvoyFilterListenerMatchFilterChainMatch() {
    }

    /**
     * 
     * @param destinationPort
     * @param filter
     * @param applicationProtocols
     * @param transportProtocol
     * @param name
     * @param sni
     */
    public EnvoyFilterListenerMatchFilterChainMatch(String applicationProtocols, Integer destinationPort, EnvoyFilterListenerMatchFilterMatch filter, String name, String sni, String transportProtocol) {
        super();
        this.applicationProtocols = applicationProtocols;
        this.destinationPort = destinationPort;
        this.filter = filter;
        this.name = name;
        this.sni = sni;
        this.transportProtocol = transportProtocol;
    }

    @JsonProperty("applicationProtocols")
    public String getApplicationProtocols() {
        return applicationProtocols;
    }

    @JsonProperty("applicationProtocols")
    public void setApplicationProtocols(String applicationProtocols) {
        this.applicationProtocols = applicationProtocols;
    }

    @JsonProperty("destinationPort")
    public Integer getDestinationPort() {
        return destinationPort;
    }

    @JsonProperty("destinationPort")
    public void setDestinationPort(Integer destinationPort) {
        this.destinationPort = destinationPort;
    }

    @JsonProperty("filter")
    public EnvoyFilterListenerMatchFilterMatch getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(EnvoyFilterListenerMatchFilterMatch filter) {
        this.filter = filter;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("sni")
    public String getSni() {
        return sni;
    }

    @JsonProperty("sni")
    public void setSni(String sni) {
        this.sni = sni;
    }

    @JsonProperty("transportProtocol")
    public String getTransportProtocol() {
        return transportProtocol;
    }

    @JsonProperty("transportProtocol")
    public void setTransportProtocol(String transportProtocol) {
        this.transportProtocol = transportProtocol;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

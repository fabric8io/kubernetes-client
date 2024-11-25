
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
    "destinationSubnets",
    "gateways",
    "port",
    "sniHosts",
    "sourceLabels",
    "sourceNamespace"
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
public class TLSMatchAttributes implements Editable<TLSMatchAttributesBuilder>, KubernetesResource
{

    @JsonProperty("destinationSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> destinationSubnets = new ArrayList<>();
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> gateways = new ArrayList<>();
    @JsonProperty("port")
    private Long port;
    @JsonProperty("sniHosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> sniHosts = new ArrayList<>();
    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> sourceLabels = new LinkedHashMap<>();
    @JsonProperty("sourceNamespace")
    private String sourceNamespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TLSMatchAttributes() {
    }

    public TLSMatchAttributes(List<String> destinationSubnets, List<String> gateways, Long port, List<String> sniHosts, Map<String, String> sourceLabels, String sourceNamespace) {
        super();
        this.destinationSubnets = destinationSubnets;
        this.gateways = gateways;
        this.port = port;
        this.sniHosts = sniHosts;
        this.sourceLabels = sourceLabels;
        this.sourceNamespace = sourceNamespace;
    }

    @JsonProperty("destinationSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDestinationSubnets() {
        return destinationSubnets;
    }

    @JsonProperty("destinationSubnets")
    public void setDestinationSubnets(List<String> destinationSubnets) {
        this.destinationSubnets = destinationSubnets;
    }

    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGateways() {
        return gateways;
    }

    @JsonProperty("gateways")
    public void setGateways(List<String> gateways) {
        this.gateways = gateways;
    }

    @JsonProperty("port")
    public Long getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Long port) {
        this.port = port;
    }

    @JsonProperty("sniHosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSniHosts() {
        return sniHosts;
    }

    @JsonProperty("sniHosts")
    public void setSniHosts(List<String> sniHosts) {
        this.sniHosts = sniHosts;
    }

    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSourceLabels() {
        return sourceLabels;
    }

    @JsonProperty("sourceLabels")
    public void setSourceLabels(Map<String, String> sourceLabels) {
        this.sourceLabels = sourceLabels;
    }

    @JsonProperty("sourceNamespace")
    public String getSourceNamespace() {
        return sourceNamespace;
    }

    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
    }

    @JsonIgnore
    public TLSMatchAttributesBuilder edit() {
        return new TLSMatchAttributesBuilder(this);
    }

    @JsonIgnore
    public TLSMatchAttributesBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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

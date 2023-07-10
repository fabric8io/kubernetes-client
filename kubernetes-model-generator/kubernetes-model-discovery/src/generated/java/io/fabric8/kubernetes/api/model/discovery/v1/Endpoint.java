
package io.fabric8.kubernetes.api.model.discovery.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "addresses",
    "conditions",
    "deprecatedTopology",
    "hints",
    "hostname",
    "nodeName",
    "targetRef",
    "zone"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class Endpoint implements KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> addresses = new ArrayList<java.lang.String>();
    @JsonProperty("conditions")
    private EndpointConditions conditions;
    @JsonProperty("deprecatedTopology")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> deprecatedTopology = new LinkedHashMap<String, String>();
    @JsonProperty("hints")
    private EndpointHints hints;
    @JsonProperty("hostname")
    private java.lang.String hostname;
    @JsonProperty("nodeName")
    private java.lang.String nodeName;
    @JsonProperty("targetRef")
    private io.fabric8.kubernetes.api.model.ObjectReference targetRef;
    @JsonProperty("zone")
    private java.lang.String zone;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Endpoint() {
    }

    public Endpoint(List<java.lang.String> addresses, EndpointConditions conditions, Map<String, String> deprecatedTopology, EndpointHints hints, java.lang.String hostname, java.lang.String nodeName, io.fabric8.kubernetes.api.model.ObjectReference targetRef, java.lang.String zone) {
        super();
        this.addresses = addresses;
        this.conditions = conditions;
        this.deprecatedTopology = deprecatedTopology;
        this.hints = hints;
        this.hostname = hostname;
        this.nodeName = nodeName;
        this.targetRef = targetRef;
        this.zone = zone;
    }

    @JsonProperty("addresses")
    public List<java.lang.String> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<java.lang.String> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("conditions")
    public EndpointConditions getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(EndpointConditions conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("deprecatedTopology")
    public Map<String, String> getDeprecatedTopology() {
        return deprecatedTopology;
    }

    @JsonProperty("deprecatedTopology")
    public void setDeprecatedTopology(Map<String, String> deprecatedTopology) {
        this.deprecatedTopology = deprecatedTopology;
    }

    @JsonProperty("hints")
    public EndpointHints getHints() {
        return hints;
    }

    @JsonProperty("hints")
    public void setHints(EndpointHints hints) {
        this.hints = hints;
    }

    @JsonProperty("hostname")
    public java.lang.String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(java.lang.String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("nodeName")
    public java.lang.String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(java.lang.String nodeName) {
        this.nodeName = nodeName;
    }

    @JsonProperty("targetRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getTargetRef() {
        return targetRef;
    }

    @JsonProperty("targetRef")
    public void setTargetRef(io.fabric8.kubernetes.api.model.ObjectReference targetRef) {
        this.targetRef = targetRef;
    }

    @JsonProperty("zone")
    public java.lang.String getZone() {
        return zone;
    }

    @JsonProperty("zone")
    public void setZone(java.lang.String zone) {
        this.zone = zone;
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

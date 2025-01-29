
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
public class Endpoint implements Editable<EndpointBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> addresses = new ArrayList<>();
    @JsonProperty("conditions")
    private EndpointConditions conditions;
    @JsonProperty("deprecatedTopology")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> deprecatedTopology = new LinkedHashMap<>();
    @JsonProperty("hints")
    private EndpointHints hints;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("targetRef")
    private ObjectReference targetRef;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Endpoint() {
    }

    public Endpoint(List<String> addresses, EndpointConditions conditions, Map<String, String> deprecatedTopology, EndpointHints hints, String hostname, String nodeName, ObjectReference targetRef, String zone) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<String> addresses) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @JsonProperty("targetRef")
    public ObjectReference getTargetRef() {
        return targetRef;
    }

    @JsonProperty("targetRef")
    public void setTargetRef(ObjectReference targetRef) {
        this.targetRef = targetRef;
    }

    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public EndpointBuilder edit() {
        return new EndpointBuilder(this);
    }

    @JsonIgnore
    public EndpointBuilder toBuilder() {
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

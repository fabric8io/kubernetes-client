
package io.fabric8.kubernetes.api.model.discovery.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

/**
 * Endpoint represents a single logical "backend" implementing a service.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "conditions",
    "hints",
    "hostname",
    "nodeName",
    "targetRef",
    "topology"
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
    @JsonProperty("hints")
    private EndpointHints hints;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("targetRef")
    private ObjectReference targetRef;
    @JsonProperty("topology")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> topology = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Endpoint() {
    }

    public Endpoint(List<String> addresses, EndpointConditions conditions, EndpointHints hints, String hostname, String nodeName, ObjectReference targetRef, Map<String, String> topology) {
        super();
        this.addresses = addresses;
        this.conditions = conditions;
        this.hints = hints;
        this.hostname = hostname;
        this.nodeName = nodeName;
        this.targetRef = targetRef;
        this.topology = topology;
    }

    /**
     * addresses of this endpoint. The contents of this field are interpreted according to the corresponding EndpointSlice addressType field. Consumers must handle different types of addresses in the context of their own capabilities. This must contain at least one address but no more than 100.
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAddresses() {
        return addresses;
    }

    /**
     * addresses of this endpoint. The contents of this field are interpreted according to the corresponding EndpointSlice addressType field. Consumers must handle different types of addresses in the context of their own capabilities. This must contain at least one address but no more than 100.
     */
    @JsonProperty("addresses")
    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    /**
     * Endpoint represents a single logical "backend" implementing a service.
     */
    @JsonProperty("conditions")
    public EndpointConditions getConditions() {
        return conditions;
    }

    /**
     * Endpoint represents a single logical "backend" implementing a service.
     */
    @JsonProperty("conditions")
    public void setConditions(EndpointConditions conditions) {
        this.conditions = conditions;
    }

    /**
     * Endpoint represents a single logical "backend" implementing a service.
     */
    @JsonProperty("hints")
    public EndpointHints getHints() {
        return hints;
    }

    /**
     * Endpoint represents a single logical "backend" implementing a service.
     */
    @JsonProperty("hints")
    public void setHints(EndpointHints hints) {
        this.hints = hints;
    }

    /**
     * hostname of this endpoint. This field may be used by consumers of endpoints to distinguish endpoints from each other (e.g. in DNS names). Multiple endpoints which use the same hostname should be considered fungible (e.g. multiple A values in DNS). Must be lowercase and pass DNS Label (RFC 1123) validation.
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * hostname of this endpoint. This field may be used by consumers of endpoints to distinguish endpoints from each other (e.g. in DNS names). Multiple endpoints which use the same hostname should be considered fungible (e.g. multiple A values in DNS). Must be lowercase and pass DNS Label (RFC 1123) validation.
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * nodeName represents the name of the Node hosting this endpoint. This can be used to determine endpoints local to a Node. This field can be enabled with the EndpointSliceNodeName feature gate.
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * nodeName represents the name of the Node hosting this endpoint. This can be used to determine endpoints local to a Node. This field can be enabled with the EndpointSliceNodeName feature gate.
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * Endpoint represents a single logical "backend" implementing a service.
     */
    @JsonProperty("targetRef")
    public ObjectReference getTargetRef() {
        return targetRef;
    }

    /**
     * Endpoint represents a single logical "backend" implementing a service.
     */
    @JsonProperty("targetRef")
    public void setTargetRef(ObjectReference targetRef) {
        this.targetRef = targetRef;
    }

    /**
     * topology contains arbitrary topology information associated with the endpoint. These key/value pairs must conform with the label format. https://kubernetes.io/docs/concepts/overview/working-with-objects/labels Topology may include a maximum of 16 key/value pairs. This includes, but is not limited to the following well known keys: &#42; kubernetes.io/hostname: the value indicates the hostname of the node<br><p>   where the endpoint is located. This should match the corresponding<br><p>   node label.<br><p> &#42; topology.kubernetes.io/zone: the value indicates the zone where the<br><p>   endpoint is located. This should match the corresponding node label.<br><p> &#42; topology.kubernetes.io/region: the value indicates the region where the<br><p>   endpoint is located. This should match the corresponding node label.<br><p> This field is deprecated and will be removed in future api versions.
     */
    @JsonProperty("topology")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getTopology() {
        return topology;
    }

    /**
     * topology contains arbitrary topology information associated with the endpoint. These key/value pairs must conform with the label format. https://kubernetes.io/docs/concepts/overview/working-with-objects/labels Topology may include a maximum of 16 key/value pairs. This includes, but is not limited to the following well known keys: &#42; kubernetes.io/hostname: the value indicates the hostname of the node<br><p>   where the endpoint is located. This should match the corresponding<br><p>   node label.<br><p> &#42; topology.kubernetes.io/zone: the value indicates the zone where the<br><p>   endpoint is located. This should match the corresponding node label.<br><p> &#42; topology.kubernetes.io/region: the value indicates the region where the<br><p>   endpoint is located. This should match the corresponding node label.<br><p> This field is deprecated and will be removed in future api versions.
     */
    @JsonProperty("topology")
    public void setTopology(Map<String, String> topology) {
        this.topology = topology;
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

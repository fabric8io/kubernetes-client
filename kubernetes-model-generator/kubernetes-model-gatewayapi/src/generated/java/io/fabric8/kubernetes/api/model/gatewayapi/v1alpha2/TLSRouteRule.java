
package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

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
import io.fabric8.kubernetes.api.model.gatewayapi.v1.BackendRef;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TLSRouteRule is the configuration for a given rule.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backendRefs",
    "name"
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
public class TLSRouteRule implements Editable<TLSRouteRuleBuilder>, KubernetesResource
{

    @JsonProperty("backendRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BackendRef> backendRefs = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TLSRouteRule() {
    }

    public TLSRouteRule(List<BackendRef> backendRefs, String name) {
        super();
        this.backendRefs = backendRefs;
        this.name = name;
    }

    /**
     * BackendRefs defines the backend(s) where matching requests should be sent. If unspecified or invalid (refers to a non-existent resource or a Service with no endpoints), the rule performs no forwarding; if no filters are specified that would result in a response being sent, the underlying implementation must actively reject request attempts to this backend, by rejecting the connection or returning a 500 status code. Request rejections must respect weight; if an invalid backend is requested to have 80% of requests, then 80% of requests must be rejected instead.<br><p> <br><p> Support: Core for Kubernetes Service<br><p> <br><p> Support: Extended for Kubernetes ServiceImport<br><p> <br><p> Support: Implementation-specific for any other resource<br><p> <br><p> Support for weight: Extended
     */
    @JsonProperty("backendRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BackendRef> getBackendRefs() {
        return backendRefs;
    }

    /**
     * BackendRefs defines the backend(s) where matching requests should be sent. If unspecified or invalid (refers to a non-existent resource or a Service with no endpoints), the rule performs no forwarding; if no filters are specified that would result in a response being sent, the underlying implementation must actively reject request attempts to this backend, by rejecting the connection or returning a 500 status code. Request rejections must respect weight; if an invalid backend is requested to have 80% of requests, then 80% of requests must be rejected instead.<br><p> <br><p> Support: Core for Kubernetes Service<br><p> <br><p> Support: Extended for Kubernetes ServiceImport<br><p> <br><p> Support: Implementation-specific for any other resource<br><p> <br><p> Support for weight: Extended
     */
    @JsonProperty("backendRefs")
    public void setBackendRefs(List<BackendRef> backendRefs) {
        this.backendRefs = backendRefs;
    }

    /**
     * Name is the name of the route rule. This name MUST be unique within a Route if it is set.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the route rule. This name MUST be unique within a Route if it is set.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public TLSRouteRuleBuilder edit() {
        return new TLSRouteRuleBuilder(this);
    }

    @JsonIgnore
    public TLSRouteRuleBuilder toBuilder() {
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

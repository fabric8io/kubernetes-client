
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
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
    "backendRefs",
    "filters",
    "matches"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class GRPCRouteRule implements KubernetesResource
{

    @JsonProperty("backendRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GRPCBackendRef> backendRefs = new ArrayList<GRPCBackendRef>();
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GRPCRouteFilter> filters = new ArrayList<GRPCRouteFilter>();
    @JsonProperty("matches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GRPCRouteMatch> matches = new ArrayList<GRPCRouteMatch>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GRPCRouteRule() {
    }

    public GRPCRouteRule(List<GRPCBackendRef> backendRefs, List<GRPCRouteFilter> filters, List<GRPCRouteMatch> matches) {
        super();
        this.backendRefs = backendRefs;
        this.filters = filters;
        this.matches = matches;
    }

    @JsonProperty("backendRefs")
    public List<GRPCBackendRef> getBackendRefs() {
        return backendRefs;
    }

    @JsonProperty("backendRefs")
    public void setBackendRefs(List<GRPCBackendRef> backendRefs) {
        this.backendRefs = backendRefs;
    }

    @JsonProperty("filters")
    public List<GRPCRouteFilter> getFilters() {
        return filters;
    }

    @JsonProperty("filters")
    public void setFilters(List<GRPCRouteFilter> filters) {
        this.filters = filters;
    }

    @JsonProperty("matches")
    public List<GRPCRouteMatch> getMatches() {
        return matches;
    }

    @JsonProperty("matches")
    public void setMatches(List<GRPCRouteMatch> matches) {
        this.matches = matches;
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

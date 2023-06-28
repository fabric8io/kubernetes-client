
package io.fabric8.kubernetes.api.model.gatewayapi.v1beta1;

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
    "hostnames",
    "parentRefs",
    "rules"
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
public class HTTPRouteSpec implements KubernetesResource
{

    @JsonProperty("hostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hostnames = new ArrayList<String>();
    @JsonProperty("parentRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParentReference> parentRefs = new ArrayList<ParentReference>();
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPRouteRule> rules = new ArrayList<HTTPRouteRule>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HTTPRouteSpec() {
    }

    public HTTPRouteSpec(List<String> hostnames, List<ParentReference> parentRefs, List<HTTPRouteRule> rules) {
        super();
        this.hostnames = hostnames;
        this.parentRefs = parentRefs;
        this.rules = rules;
    }

    @JsonProperty("hostnames")
    public List<String> getHostnames() {
        return hostnames;
    }

    @JsonProperty("hostnames")
    public void setHostnames(List<String> hostnames) {
        this.hostnames = hostnames;
    }

    @JsonProperty("parentRefs")
    public List<ParentReference> getParentRefs() {
        return parentRefs;
    }

    @JsonProperty("parentRefs")
    public void setParentRefs(List<ParentReference> parentRefs) {
        this.parentRefs = parentRefs;
    }

    @JsonProperty("rules")
    public List<HTTPRouteRule> getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(List<HTTPRouteRule> rules) {
        this.rules = rules;
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

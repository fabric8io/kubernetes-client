
package io.fabric8.openshift.api.model.operator.v1;

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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableReplicas",
    "conditions",
    "domain",
    "endpointPublishingStrategy",
    "namespaceSelector",
    "observedGeneration",
    "routeSelector",
    "selector",
    "tlsProfile"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class IngressControllerStatus implements Editable<IngressControllerStatusBuilder> , KubernetesResource
{

    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressControllerStatusConditions> conditions = new ArrayList<>();
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("endpointPublishingStrategy")
    private IngressControllerStatusEndpointPublishingStrategy endpointPublishingStrategy;
    @JsonProperty("namespaceSelector")
    private IngressControllerStatusNamespaceSelector namespaceSelector;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("routeSelector")
    private IngressControllerStatusRouteSelector routeSelector;
    @JsonProperty("selector")
    private String selector;
    @JsonProperty("tlsProfile")
    private IngressControllerStatusTlsProfile tlsProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressControllerStatus() {
    }

    public IngressControllerStatus(Integer availableReplicas, List<IngressControllerStatusConditions> conditions, String domain, IngressControllerStatusEndpointPublishingStrategy endpointPublishingStrategy, IngressControllerStatusNamespaceSelector namespaceSelector, Long observedGeneration, IngressControllerStatusRouteSelector routeSelector, String selector, IngressControllerStatusTlsProfile tlsProfile) {
        super();
        this.availableReplicas = availableReplicas;
        this.conditions = conditions;
        this.domain = domain;
        this.endpointPublishingStrategy = endpointPublishingStrategy;
        this.namespaceSelector = namespaceSelector;
        this.observedGeneration = observedGeneration;
        this.routeSelector = routeSelector;
        this.selector = selector;
        this.tlsProfile = tlsProfile;
    }

    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressControllerStatusConditions> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<IngressControllerStatusConditions> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonProperty("endpointPublishingStrategy")
    public IngressControllerStatusEndpointPublishingStrategy getEndpointPublishingStrategy() {
        return endpointPublishingStrategy;
    }

    @JsonProperty("endpointPublishingStrategy")
    public void setEndpointPublishingStrategy(IngressControllerStatusEndpointPublishingStrategy endpointPublishingStrategy) {
        this.endpointPublishingStrategy = endpointPublishingStrategy;
    }

    @JsonProperty("namespaceSelector")
    public IngressControllerStatusNamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(IngressControllerStatusNamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("routeSelector")
    public IngressControllerStatusRouteSelector getRouteSelector() {
        return routeSelector;
    }

    @JsonProperty("routeSelector")
    public void setRouteSelector(IngressControllerStatusRouteSelector routeSelector) {
        this.routeSelector = routeSelector;
    }

    @JsonProperty("selector")
    public String getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(String selector) {
        this.selector = selector;
    }

    @JsonProperty("tlsProfile")
    public IngressControllerStatusTlsProfile getTlsProfile() {
        return tlsProfile;
    }

    @JsonProperty("tlsProfile")
    public void setTlsProfile(IngressControllerStatusTlsProfile tlsProfile) {
        this.tlsProfile = tlsProfile;
    }

    @JsonIgnore
    public IngressControllerStatusBuilder edit() {
        return new IngressControllerStatusBuilder(this);
    }

    @JsonIgnore
    public IngressControllerStatusBuilder toBuilder() {
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


package io.fabric8.openshift.api.model.config.v1;

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
    "appsDomain",
    "componentRoutes",
    "domain",
    "loadBalancer",
    "requiredHSTSPolicies"
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
public class IngressSpec implements KubernetesResource
{

    @JsonProperty("appsDomain")
    private String appsDomain;
    @JsonProperty("componentRoutes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ComponentRouteSpec> componentRoutes = new ArrayList<ComponentRouteSpec>();
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("loadBalancer")
    private LoadBalancer loadBalancer;
    @JsonProperty("requiredHSTSPolicies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RequiredHSTSPolicy> requiredHSTSPolicies = new ArrayList<RequiredHSTSPolicy>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressSpec() {
    }

    public IngressSpec(String appsDomain, List<ComponentRouteSpec> componentRoutes, String domain, LoadBalancer loadBalancer, List<RequiredHSTSPolicy> requiredHSTSPolicies) {
        super();
        this.appsDomain = appsDomain;
        this.componentRoutes = componentRoutes;
        this.domain = domain;
        this.loadBalancer = loadBalancer;
        this.requiredHSTSPolicies = requiredHSTSPolicies;
    }

    @JsonProperty("appsDomain")
    public String getAppsDomain() {
        return appsDomain;
    }

    @JsonProperty("appsDomain")
    public void setAppsDomain(String appsDomain) {
        this.appsDomain = appsDomain;
    }

    @JsonProperty("componentRoutes")
    public List<ComponentRouteSpec> getComponentRoutes() {
        return componentRoutes;
    }

    @JsonProperty("componentRoutes")
    public void setComponentRoutes(List<ComponentRouteSpec> componentRoutes) {
        this.componentRoutes = componentRoutes;
    }

    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonProperty("loadBalancer")
    public LoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    @JsonProperty("loadBalancer")
    public void setLoadBalancer(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @JsonProperty("requiredHSTSPolicies")
    public List<RequiredHSTSPolicy> getRequiredHSTSPolicies() {
        return requiredHSTSPolicies;
    }

    @JsonProperty("requiredHSTSPolicies")
    public void setRequiredHSTSPolicies(List<RequiredHSTSPolicy> requiredHSTSPolicies) {
        this.requiredHSTSPolicies = requiredHSTSPolicies;
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

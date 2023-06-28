
package io.fabric8.openshift.api.model;

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
    "conditions",
    "host",
    "routerCanonicalHostname",
    "routerName",
    "wildcardPolicy"
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
public class RouteIngress implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteIngressCondition> conditions = new ArrayList<RouteIngressCondition>();
    @JsonProperty("host")
    private String host;
    @JsonProperty("routerCanonicalHostname")
    private String routerCanonicalHostname;
    @JsonProperty("routerName")
    private String routerName;
    @JsonProperty("wildcardPolicy")
    private String wildcardPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RouteIngress() {
    }

    public RouteIngress(List<RouteIngressCondition> conditions, String host, String routerCanonicalHostname, String routerName, String wildcardPolicy) {
        super();
        this.conditions = conditions;
        this.host = host;
        this.routerCanonicalHostname = routerCanonicalHostname;
        this.routerName = routerName;
        this.wildcardPolicy = wildcardPolicy;
    }

    @JsonProperty("conditions")
    public List<RouteIngressCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<RouteIngressCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("routerCanonicalHostname")
    public String getRouterCanonicalHostname() {
        return routerCanonicalHostname;
    }

    @JsonProperty("routerCanonicalHostname")
    public void setRouterCanonicalHostname(String routerCanonicalHostname) {
        this.routerCanonicalHostname = routerCanonicalHostname;
    }

    @JsonProperty("routerName")
    public String getRouterName() {
        return routerName;
    }

    @JsonProperty("routerName")
    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    @JsonProperty("wildcardPolicy")
    public String getWildcardPolicy() {
        return wildcardPolicy;
    }

    @JsonProperty("wildcardPolicy")
    public void setWildcardPolicy(String wildcardPolicy) {
        this.wildcardPolicy = wildcardPolicy;
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

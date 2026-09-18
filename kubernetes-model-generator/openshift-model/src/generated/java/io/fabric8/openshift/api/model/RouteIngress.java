
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * RouteIngress holds information about the places where a route is exposed.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "host",
    "routerCanonicalHostname",
    "routerName",
    "wildcardPolicy"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RouteIngress implements Editable<RouteIngressBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteIngressCondition> conditions = new ArrayList<>();
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

    /**
     * conditions is the state of the route, may be empty.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RouteIngressCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions is the state of the route, may be empty.
     */
    @JsonProperty("conditions")
    public void setConditions(List<RouteIngressCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * host is the host string under which the route is exposed; this value is required
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * host is the host string under which the route is exposed; this value is required
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * CanonicalHostname is the external host name for the router that can be used as a CNAME for the host requested for this route. This value is optional and may not be set in all cases.
     */
    @JsonProperty("routerCanonicalHostname")
    public String getRouterCanonicalHostname() {
        return routerCanonicalHostname;
    }

    /**
     * CanonicalHostname is the external host name for the router that can be used as a CNAME for the host requested for this route. This value is optional and may not be set in all cases.
     */
    @JsonProperty("routerCanonicalHostname")
    public void setRouterCanonicalHostname(String routerCanonicalHostname) {
        this.routerCanonicalHostname = routerCanonicalHostname;
    }

    /**
     * Name is a name chosen by the router to identify itself; this value is required
     */
    @JsonProperty("routerName")
    public String getRouterName() {
        return routerName;
    }

    /**
     * Name is a name chosen by the router to identify itself; this value is required
     */
    @JsonProperty("routerName")
    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    /**
     * Wildcard policy is the wildcard policy that was allowed where this route is exposed.
     */
    @JsonProperty("wildcardPolicy")
    public String getWildcardPolicy() {
        return wildcardPolicy;
    }

    /**
     * Wildcard policy is the wildcard policy that was allowed where this route is exposed.
     */
    @JsonProperty("wildcardPolicy")
    public void setWildcardPolicy(String wildcardPolicy) {
        this.wildcardPolicy = wildcardPolicy;
    }

    @JsonIgnore
    public RouteIngressBuilder edit() {
        return new RouteIngressBuilder(this);
    }

    @JsonIgnore
    public RouteIngressBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RouteIngress)) {
            return false;
        }
        RouteIngress other = (RouteIngress) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$host = this.getHost();
        Object other$host = other.getHost();
        if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
            return false;
        }
        Object this$routerCanonicalHostname = this.getRouterCanonicalHostname();
        Object other$routerCanonicalHostname = other.getRouterCanonicalHostname();
        if (this$routerCanonicalHostname == null ? other$routerCanonicalHostname != null : !this$routerCanonicalHostname.equals(other$routerCanonicalHostname)) {
            return false;
        }
        Object this$routerName = this.getRouterName();
        Object other$routerName = other.getRouterName();
        if (this$routerName == null ? other$routerName != null : !this$routerName.equals(other$routerName)) {
            return false;
        }
        Object this$wildcardPolicy = this.getWildcardPolicy();
        Object other$wildcardPolicy = other.getWildcardPolicy();
        if (this$wildcardPolicy == null ? other$wildcardPolicy != null : !this$wildcardPolicy.equals(other$wildcardPolicy)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RouteIngress;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $host = this.getHost();
        result = result * prime + ($host == null ? 43 : $host.hashCode());
        Object $routerCanonicalHostname = this.getRouterCanonicalHostname();
        result = result * prime + ($routerCanonicalHostname == null ? 43 : $routerCanonicalHostname.hashCode());
        Object $routerName = this.getRouterName();
        result = result * prime + ($routerName == null ? 43 : $routerName.hashCode());
        Object $wildcardPolicy = this.getWildcardPolicy();
        result = result * prime + ($wildcardPolicy == null ? 43 : $wildcardPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RouteIngress(" + "conditions=" + this.getConditions() + ", host=" + this.getHost() + ", routerCanonicalHostname=" + this.getRouterCanonicalHostname() + ", routerName=" + this.getRouterName() + ", wildcardPolicy=" + this.getWildcardPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

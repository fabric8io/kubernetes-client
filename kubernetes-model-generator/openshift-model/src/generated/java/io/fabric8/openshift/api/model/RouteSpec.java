
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
    "alternateBackends",
    "host",
    "path",
    "port",
    "subdomain",
    "tls",
    "to",
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
public class RouteSpec implements KubernetesResource
{

    @JsonProperty("alternateBackends")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteTargetReference> alternateBackends = new ArrayList<RouteTargetReference>();
    @JsonProperty("host")
    private String host;
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private RoutePort port;
    @JsonProperty("subdomain")
    private String subdomain;
    @JsonProperty("tls")
    private TLSConfig tls;
    @JsonProperty("to")
    private RouteTargetReference to;
    @JsonProperty("wildcardPolicy")
    private String wildcardPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RouteSpec() {
    }

    public RouteSpec(List<RouteTargetReference> alternateBackends, String host, String path, RoutePort port, String subdomain, TLSConfig tls, RouteTargetReference to, String wildcardPolicy) {
        super();
        this.alternateBackends = alternateBackends;
        this.host = host;
        this.path = path;
        this.port = port;
        this.subdomain = subdomain;
        this.tls = tls;
        this.to = to;
        this.wildcardPolicy = wildcardPolicy;
    }

    @JsonProperty("alternateBackends")
    public List<RouteTargetReference> getAlternateBackends() {
        return alternateBackends;
    }

    @JsonProperty("alternateBackends")
    public void setAlternateBackends(List<RouteTargetReference> alternateBackends) {
        this.alternateBackends = alternateBackends;
    }

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("port")
    public RoutePort getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(RoutePort port) {
        this.port = port;
    }

    @JsonProperty("subdomain")
    public String getSubdomain() {
        return subdomain;
    }

    @JsonProperty("subdomain")
    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    @JsonProperty("tls")
    public TLSConfig getTls() {
        return tls;
    }

    @JsonProperty("tls")
    public void setTls(TLSConfig tls) {
        this.tls = tls;
    }

    @JsonProperty("to")
    public RouteTargetReference getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(RouteTargetReference to) {
        this.to = to;
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

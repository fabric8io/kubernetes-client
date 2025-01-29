
package io.fabric8.istio.api.api.security.v1beta1;

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

/**
 * Operation specifies the operations of a request. Fields in the operation are ANDed together.<br><p> <br><p> For example, the following operation matches if the host has suffix `.example.com` and the method is `GET` or `HEAD` and the path doesn't have prefix `/admin`.<br><p> <br><p> ```yaml hosts: ["&#42;.example.com"] methods: ["GET", "HEAD"] notPaths: ["/admin&#42;"] ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hosts",
    "methods",
    "notHosts",
    "notMethods",
    "notPaths",
    "notPorts",
    "paths",
    "ports"
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
public class Operation implements Editable<OperationBuilder>, KubernetesResource
{

    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hosts = new ArrayList<>();
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> methods = new ArrayList<>();
    @JsonProperty("notHosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notHosts = new ArrayList<>();
    @JsonProperty("notMethods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notMethods = new ArrayList<>();
    @JsonProperty("notPaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notPaths = new ArrayList<>();
    @JsonProperty("notPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notPorts = new ArrayList<>();
    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> paths = new ArrayList<>();
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ports = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Operation() {
    }

    public Operation(List<String> hosts, List<String> methods, List<String> notHosts, List<String> notMethods, List<String> notPaths, List<String> notPorts, List<String> paths, List<String> ports) {
        super();
        this.hosts = hosts;
        this.methods = methods;
        this.notHosts = notHosts;
        this.notMethods = notMethods;
        this.notPaths = notPaths;
        this.notPorts = notPorts;
        this.paths = paths;
        this.ports = ports;
    }

    /**
     * Optional. A list of hosts as specified in the HTTP request. The match is case-insensitive. See the [security best practices](https://istio.io/latest/docs/ops/best-practices/security/#writing-host-match-policies) for recommended usage of this field.<br><p> <br><p> If not set, any host is allowed. Must be used only with HTTP.
     */
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHosts() {
        return hosts;
    }

    /**
     * Optional. A list of hosts as specified in the HTTP request. The match is case-insensitive. See the [security best practices](https://istio.io/latest/docs/ops/best-practices/security/#writing-host-match-policies) for recommended usage of this field.<br><p> <br><p> If not set, any host is allowed. Must be used only with HTTP.
     */
    @JsonProperty("hosts")
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    /**
     * Optional. A list of methods as specified in the HTTP request. For gRPC service, this will always be `POST`.<br><p> <br><p> If not set, any method is allowed. Must be used only with HTTP.
     */
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMethods() {
        return methods;
    }

    /**
     * Optional. A list of methods as specified in the HTTP request. For gRPC service, this will always be `POST`.<br><p> <br><p> If not set, any method is allowed. Must be used only with HTTP.
     */
    @JsonProperty("methods")
    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    /**
     * Optional. A list of negative match of hosts as specified in the HTTP request. The match is case-insensitive.
     */
    @JsonProperty("notHosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotHosts() {
        return notHosts;
    }

    /**
     * Optional. A list of negative match of hosts as specified in the HTTP request. The match is case-insensitive.
     */
    @JsonProperty("notHosts")
    public void setNotHosts(List<String> notHosts) {
        this.notHosts = notHosts;
    }

    /**
     * Optional. A list of negative match of methods as specified in the HTTP request.
     */
    @JsonProperty("notMethods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotMethods() {
        return notMethods;
    }

    /**
     * Optional. A list of negative match of methods as specified in the HTTP request.
     */
    @JsonProperty("notMethods")
    public void setNotMethods(List<String> notMethods) {
        this.notMethods = notMethods;
    }

    /**
     * Optional. A list of negative match of paths.
     */
    @JsonProperty("notPaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotPaths() {
        return notPaths;
    }

    /**
     * Optional. A list of negative match of paths.
     */
    @JsonProperty("notPaths")
    public void setNotPaths(List<String> notPaths) {
        this.notPaths = notPaths;
    }

    /**
     * Optional. A list of negative match of ports as specified in the connection.
     */
    @JsonProperty("notPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotPorts() {
        return notPorts;
    }

    /**
     * Optional. A list of negative match of ports as specified in the connection.
     */
    @JsonProperty("notPorts")
    public void setNotPorts(List<String> notPorts) {
        this.notPorts = notPorts;
    }

    /**
     * Optional. A list of paths as specified in the HTTP request. See the [Authorization Policy Normalization](https://istio.io/latest/docs/reference/config/security/normalization/) for details of the path normalization. For gRPC service, this will be the fully-qualified name in the form of `/package.service/method`.<br><p> <br><p> If a path in the list contains the `{&#42;}` or `{&#42;&#42;}` path template operator, it will be interpreted as an [Envoy Uri Template](https://www.envoyproxy.io/docs/envoy/latest/api-v3/extensions/path/match/uri_template/v3/uri_template_match.proto). To be a valid path template, the path must not contain `&#42;`, `{`, or `}` outside of a supported operator. No other characters are allowed in the path segment with the path template operator. - `{&#42;}` matches a single glob that cannot extend beyond a path segment. - `{&#42;&#42;}` matches zero or more globs. If a path contains `{&#42;&#42;}`, it must be the last operator.<br><p> <br><p> Examples: - `/foo/{&#42;}` matches `/foo/bar` but not `/foo/bar/baz` - `/foo/{&#42;&#42;}/` matches `/foo/bar/`, `/foo/bar/baz.txt`, and `/foo//` but not `/foo/bar` - `/foo/{&#42;}/bar/{&#42;&#42;}` matches `/foo/buzz/bar/` and `/foo/buzz/bar/baz` - `/&#42;/baz/{&#42;}` is not a valid path template since it includes `&#42;` outside of a supported operator - `/&#42;&#42;/baz/{&#42;}` is not a valid path template since it includes `&#42;&#42;` outside of a supported operator - `/{&#42;&#42;}/foo/{&#42;}` is not a valid path template since `{&#42;&#42;}` is not the last operator - `/foo/{&#42;}.txt` is invalid since there are characters other than `{&#42;}` in the path segment<br><p> <br><p> If not set, any path is allowed. Must be used only with HTTP.
     */
    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPaths() {
        return paths;
    }

    /**
     * Optional. A list of paths as specified in the HTTP request. See the [Authorization Policy Normalization](https://istio.io/latest/docs/reference/config/security/normalization/) for details of the path normalization. For gRPC service, this will be the fully-qualified name in the form of `/package.service/method`.<br><p> <br><p> If a path in the list contains the `{&#42;}` or `{&#42;&#42;}` path template operator, it will be interpreted as an [Envoy Uri Template](https://www.envoyproxy.io/docs/envoy/latest/api-v3/extensions/path/match/uri_template/v3/uri_template_match.proto). To be a valid path template, the path must not contain `&#42;`, `{`, or `}` outside of a supported operator. No other characters are allowed in the path segment with the path template operator. - `{&#42;}` matches a single glob that cannot extend beyond a path segment. - `{&#42;&#42;}` matches zero or more globs. If a path contains `{&#42;&#42;}`, it must be the last operator.<br><p> <br><p> Examples: - `/foo/{&#42;}` matches `/foo/bar` but not `/foo/bar/baz` - `/foo/{&#42;&#42;}/` matches `/foo/bar/`, `/foo/bar/baz.txt`, and `/foo//` but not `/foo/bar` - `/foo/{&#42;}/bar/{&#42;&#42;}` matches `/foo/buzz/bar/` and `/foo/buzz/bar/baz` - `/&#42;/baz/{&#42;}` is not a valid path template since it includes `&#42;` outside of a supported operator - `/&#42;&#42;/baz/{&#42;}` is not a valid path template since it includes `&#42;&#42;` outside of a supported operator - `/{&#42;&#42;}/foo/{&#42;}` is not a valid path template since `{&#42;&#42;}` is not the last operator - `/foo/{&#42;}.txt` is invalid since there are characters other than `{&#42;}` in the path segment<br><p> <br><p> If not set, any path is allowed. Must be used only with HTTP.
     */
    @JsonProperty("paths")
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    /**
     * Optional. A list of ports as specified in the connection.<br><p> <br><p> If not set, any port is allowed.
     */
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPorts() {
        return ports;
    }

    /**
     * Optional. A list of ports as specified in the connection.<br><p> <br><p> If not set, any port is allowed.
     */
    @JsonProperty("ports")
    public void setPorts(List<String> ports) {
        this.ports = ports;
    }

    @JsonIgnore
    public OperationBuilder edit() {
        return new OperationBuilder(this);
    }

    @JsonIgnore
    public OperationBuilder toBuilder() {
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

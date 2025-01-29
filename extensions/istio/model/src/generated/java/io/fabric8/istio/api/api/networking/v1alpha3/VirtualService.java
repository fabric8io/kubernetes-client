
package io.fabric8.istio.api.api.networking.v1alpha3;

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
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Configuration affecting traffic routing.<br><p> <br><p> &lt;!-- crd generation tags that should apply these routes" representing the server time when this object was created. It is not guaranteed to be set in happens-before order across separate operations. Clients may not set this value. It is represented in RFC3339 form and is in UTC. Populated by the system. Read-only. Null for lists. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#metadata" --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exportTo",
    "gateways",
    "hosts",
    "http",
    "tcp",
    "tls"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1alpha3")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VirtualService implements Editable<VirtualServiceBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("exportTo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> exportTo = new ArrayList<>();
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> gateways = new ArrayList<>();
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hosts = new ArrayList<>();
    @JsonProperty("http")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPRoute> http = new ArrayList<>();
    @JsonProperty("tcp")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TCPRoute> tcp = new ArrayList<>();
    @JsonProperty("tls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TLSRoute> tls = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VirtualService() {
    }

    public VirtualService(List<String> exportTo, List<String> gateways, List<String> hosts, List<HTTPRoute> http, List<TCPRoute> tcp, List<TLSRoute> tls) {
        super();
        this.exportTo = exportTo;
        this.gateways = gateways;
        this.hosts = hosts;
        this.http = http;
        this.tcp = tcp;
        this.tls = tls;
    }

    /**
     * A list of namespaces to which this virtual service is exported. Exporting a virtual service allows it to be used by sidecars and gateways defined in other namespaces. This feature provides a mechanism for service owners and mesh administrators to control the visibility of virtual services across namespace boundaries.<br><p> <br><p> If no namespaces are specified then the virtual service is exported to all namespaces by default.<br><p> <br><p> The value "." is reserved and defines an export to the same namespace that the virtual service is declared in. Similarly the value "&#42;" is reserved and defines an export to all namespaces.
     */
    @JsonProperty("exportTo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExportTo() {
        return exportTo;
    }

    /**
     * A list of namespaces to which this virtual service is exported. Exporting a virtual service allows it to be used by sidecars and gateways defined in other namespaces. This feature provides a mechanism for service owners and mesh administrators to control the visibility of virtual services across namespace boundaries.<br><p> <br><p> If no namespaces are specified then the virtual service is exported to all namespaces by default.<br><p> <br><p> The value "." is reserved and defines an export to the same namespace that the virtual service is declared in. Similarly the value "&#42;" is reserved and defines an export to all namespaces.
     */
    @JsonProperty("exportTo")
    public void setExportTo(List<String> exportTo) {
        this.exportTo = exportTo;
    }

    /**
     * The names of gateways and sidecars that should apply these routes. Gateways in other namespaces may be referred to by `&lt;gateway namespace&gt;/&lt;gateway name&gt;`; specifying a gateway with no namespace qualifier is the same as specifying the VirtualService's namespace. A single VirtualService is used for sidecars inside the mesh as well as for one or more gateways. The selection condition imposed by this field can be overridden using the source field in the match conditions of protocol-specific routes. The reserved word `mesh` is used to imply all the sidecars in the mesh. When this field is omitted, the default gateway (`mesh`) will be used, which would apply the rule to all sidecars in the mesh. If a list of gateway names is provided, the rules will apply only to the gateways. To apply the rules to both gateways and sidecars, specify `mesh` as one of the gateway names.
     */
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGateways() {
        return gateways;
    }

    /**
     * The names of gateways and sidecars that should apply these routes. Gateways in other namespaces may be referred to by `&lt;gateway namespace&gt;/&lt;gateway name&gt;`; specifying a gateway with no namespace qualifier is the same as specifying the VirtualService's namespace. A single VirtualService is used for sidecars inside the mesh as well as for one or more gateways. The selection condition imposed by this field can be overridden using the source field in the match conditions of protocol-specific routes. The reserved word `mesh` is used to imply all the sidecars in the mesh. When this field is omitted, the default gateway (`mesh`) will be used, which would apply the rule to all sidecars in the mesh. If a list of gateway names is provided, the rules will apply only to the gateways. To apply the rules to both gateways and sidecars, specify `mesh` as one of the gateway names.
     */
    @JsonProperty("gateways")
    public void setGateways(List<String> gateways) {
        this.gateways = gateways;
    }

    /**
     * The destination hosts to which traffic is being sent. Could be a DNS name with wildcard prefix or an IP address.  Depending on the platform, short-names can also be used instead of a FQDN (i.e. has no dots in the name). In such a scenario, the FQDN of the host would be derived based on the underlying platform.<br><p> <br><p> A single VirtualService can be used to describe all the traffic properties of the corresponding hosts, including those for multiple HTTP and TCP ports. Alternatively, the traffic properties of a host can be defined using more than one VirtualService, with certain caveats. Refer to the [Operations Guide](https://istio.io/docs/ops/best-practices/traffic-management/#split-virtual-services) for details.<br><p> <br><p> &#42;Note for Kubernetes users&#42;: When short names are used (e.g. "reviews" instead of "reviews.default.svc.cluster.local"), Istio will interpret the short name based on the namespace of the rule, not the service. A rule in the "default" namespace containing a host "reviews" will be interpreted as "reviews.default.svc.cluster.local", irrespective of the actual namespace associated with the reviews service. _To avoid potential misconfigurations, it is recommended to always use fully qualified domain names over short names._<br><p> <br><p> The hosts field applies to both HTTP and TCP services. Service inside the mesh, i.e., those found in the service registry, must always be referred to using their alphanumeric names. IP addresses are allowed only for services defined via the Gateway.<br><p> <br><p> &#42;Note&#42;: It must be empty for a delegate VirtualService.
     */
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHosts() {
        return hosts;
    }

    /**
     * The destination hosts to which traffic is being sent. Could be a DNS name with wildcard prefix or an IP address.  Depending on the platform, short-names can also be used instead of a FQDN (i.e. has no dots in the name). In such a scenario, the FQDN of the host would be derived based on the underlying platform.<br><p> <br><p> A single VirtualService can be used to describe all the traffic properties of the corresponding hosts, including those for multiple HTTP and TCP ports. Alternatively, the traffic properties of a host can be defined using more than one VirtualService, with certain caveats. Refer to the [Operations Guide](https://istio.io/docs/ops/best-practices/traffic-management/#split-virtual-services) for details.<br><p> <br><p> &#42;Note for Kubernetes users&#42;: When short names are used (e.g. "reviews" instead of "reviews.default.svc.cluster.local"), Istio will interpret the short name based on the namespace of the rule, not the service. A rule in the "default" namespace containing a host "reviews" will be interpreted as "reviews.default.svc.cluster.local", irrespective of the actual namespace associated with the reviews service. _To avoid potential misconfigurations, it is recommended to always use fully qualified domain names over short names._<br><p> <br><p> The hosts field applies to both HTTP and TCP services. Service inside the mesh, i.e., those found in the service registry, must always be referred to using their alphanumeric names. IP addresses are allowed only for services defined via the Gateway.<br><p> <br><p> &#42;Note&#42;: It must be empty for a delegate VirtualService.
     */
    @JsonProperty("hosts")
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    /**
     * An ordered list of route rules for HTTP traffic. HTTP routes will be applied to platform service ports using HTTP/HTTP2/GRPC protocols, gateway ports with protocol HTTP/HTTP2/GRPC/TLS-terminated-HTTPS and service entry ports using HTTP/HTTP2/GRPC protocols.  The first rule matching an incoming request is used.
     */
    @JsonProperty("http")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPRoute> getHttp() {
        return http;
    }

    /**
     * An ordered list of route rules for HTTP traffic. HTTP routes will be applied to platform service ports using HTTP/HTTP2/GRPC protocols, gateway ports with protocol HTTP/HTTP2/GRPC/TLS-terminated-HTTPS and service entry ports using HTTP/HTTP2/GRPC protocols.  The first rule matching an incoming request is used.
     */
    @JsonProperty("http")
    public void setHttp(List<HTTPRoute> http) {
        this.http = http;
    }

    /**
     * An ordered list of route rules for opaque TCP traffic. TCP routes will be applied to any port that is not a HTTP or TLS port. The first rule matching an incoming request is used.
     */
    @JsonProperty("tcp")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TCPRoute> getTcp() {
        return tcp;
    }

    /**
     * An ordered list of route rules for opaque TCP traffic. TCP routes will be applied to any port that is not a HTTP or TLS port. The first rule matching an incoming request is used.
     */
    @JsonProperty("tcp")
    public void setTcp(List<TCPRoute> tcp) {
        this.tcp = tcp;
    }

    /**
     * An ordered list of route rule for non-terminated TLS &amp; HTTPS traffic. Routing is typically performed using the SNI value presented by the ClientHello message. TLS routes will be applied to platform service ports named 'https-&#42;', 'tls-&#42;', unterminated gateway ports using HTTPS/TLS protocols (i.e. with "passthrough" TLS mode) and service entry ports using HTTPS/TLS protocols.  The first rule matching an incoming request is used.  NOTE: Traffic 'https-&#42;' or 'tls-&#42;' ports without associated virtual service will be treated as opaque TCP traffic.
     */
    @JsonProperty("tls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TLSRoute> getTls() {
        return tls;
    }

    /**
     * An ordered list of route rule for non-terminated TLS &amp; HTTPS traffic. Routing is typically performed using the SNI value presented by the ClientHello message. TLS routes will be applied to platform service ports named 'https-&#42;', 'tls-&#42;', unterminated gateway ports using HTTPS/TLS protocols (i.e. with "passthrough" TLS mode) and service entry ports using HTTPS/TLS protocols.  The first rule matching an incoming request is used.  NOTE: Traffic 'https-&#42;' or 'tls-&#42;' ports without associated virtual service will be treated as opaque TCP traffic.
     */
    @JsonProperty("tls")
    public void setTls(List<TLSRoute> tls) {
        this.tls = tls;
    }

    @JsonIgnore
    public VirtualServiceBuilder edit() {
        return new VirtualServiceBuilder(this);
    }

    @JsonIgnore
    public VirtualServiceBuilder toBuilder() {
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

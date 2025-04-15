
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
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
 * Destination indicates the network addressable service to which the request/connection will be sent after processing a routing rule. The destination.host should unambiguously refer to a service in the service registry. Istio's service registry is composed of all the services found in the platform's service registry (e.g., Kubernetes services, Consul services), as well as services declared through the [ServiceEntry](https://istio.io/docs/reference/config/networking/service-entry/#ServiceEntry) resource.<br><p> <br><p> &#42;Note for Kubernetes users&#42;: When short names are used (e.g. "reviews" instead of "reviews.default.svc.cluster.local"), Istio will interpret the short name based on the namespace of the rule, not the service. A rule in the "default" namespace containing a host "reviews" will be interpreted as "reviews.default.svc.cluster.local", irrespective of the actual namespace associated with the reviews service. _To avoid potential misconfigurations, it is recommended to always use fully qualified domain names over short names._<br><p> <br><p> The following Kubernetes example routes all traffic by default to pods of the reviews service with label "version: v1" (i.e., subset v1), and some to subset v2, in a Kubernetes environment.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      prefix: "/wpcatalog"<br><p> 	  - uri:<br><p> 	      prefix: "/consumercatalog"<br><p> 	  rewrite:<br><p> 	    uri: "/newcatalog"<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	      subset: v2<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	      subset: v1<br><p> <br><p> ```<br><p> <br><p> # And the associated DestinationRule<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-destination<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	subsets:<br><p> 	- name: v1<br><p> 	  labels:<br><p> 	    version: v1<br><p> 	- name: v2<br><p> 	  labels:<br><p> 	    version: v2<br><p> <br><p> ```<br><p> <br><p> The following VirtualService sets a timeout of 5s for all calls to productpage.prod.svc.cluster.local service in Kubernetes. Notice that there are no subsets defined in this rule. Istio will fetch all instances of productpage.prod.svc.cluster.local service from the service registry and populate the sidecar's load balancing pool. Also, notice that this rule is set in the istio-system namespace but uses the fully qualified domain name of the productpage service, productpage.prod.svc.cluster.local. Therefore the rule's namespace does not have an impact in resolving the name of the productpage service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: my-productpage-rule<br><p> 	namespace: istio-system<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- productpage.prod.svc.cluster.local # ignores rule namespace<br><p> 	http:<br><p> 	- timeout: 5s<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: productpage.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> To control routing for traffic bound to services outside the mesh, external services must first be added to Istio's internal service registry using the ServiceEntry resource. VirtualServices can then be defined to control traffic bound to these external services. For example, the following rules define a Service for wikipedia.org and set a timeout of 5s for HTTP requests.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: ServiceEntry metadata:<br><p> <br><p> 	name: external-svc-wikipedia<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- wikipedia.org<br><p> 	location: MESH_EXTERNAL<br><p> 	ports:<br><p> 	- number: 80<br><p> 	  name: example-http<br><p> 	  protocol: HTTP<br><p> 	resolution: DNS
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "host",
    "port",
    "subset"
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
public class Destination implements Editable<DestinationBuilder>, KubernetesResource
{

    @JsonProperty("host")
    private String host;
    @JsonProperty("port")
    private PortSelector port;
    @JsonProperty("subset")
    private String subset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Destination() {
    }

    public Destination(String host, PortSelector port, String subset) {
        super();
        this.host = host;
        this.port = port;
        this.subset = subset;
    }

    /**
     * The name of a service from the service registry. Service names are looked up from the platform's service registry (e.g., Kubernetes services, Consul services, etc.) and from the hosts declared by [ServiceEntry](https://istio.io/docs/reference/config/networking/service-entry/#ServiceEntry). Traffic forwarded to destinations that are not found in either of the two, will be dropped.<br><p> <br><p> &#42;Note for Kubernetes users&#42;: When short names are used (e.g. "reviews" instead of "reviews.default.svc.cluster.local"), Istio will interpret the short name based on the namespace of the rule, not the service. A rule in the "default" namespace containing a host "reviews" will be interpreted as "reviews.default.svc.cluster.local", irrespective of the actual namespace associated with the reviews service. To avoid potential misconfiguration, it is recommended to always use fully qualified domain names over short names.
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * The name of a service from the service registry. Service names are looked up from the platform's service registry (e.g., Kubernetes services, Consul services, etc.) and from the hosts declared by [ServiceEntry](https://istio.io/docs/reference/config/networking/service-entry/#ServiceEntry). Traffic forwarded to destinations that are not found in either of the two, will be dropped.<br><p> <br><p> &#42;Note for Kubernetes users&#42;: When short names are used (e.g. "reviews" instead of "reviews.default.svc.cluster.local"), Istio will interpret the short name based on the namespace of the rule, not the service. A rule in the "default" namespace containing a host "reviews" will be interpreted as "reviews.default.svc.cluster.local", irrespective of the actual namespace associated with the reviews service. To avoid potential misconfiguration, it is recommended to always use fully qualified domain names over short names.
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Destination indicates the network addressable service to which the request/connection will be sent after processing a routing rule. The destination.host should unambiguously refer to a service in the service registry. Istio's service registry is composed of all the services found in the platform's service registry (e.g., Kubernetes services, Consul services), as well as services declared through the [ServiceEntry](https://istio.io/docs/reference/config/networking/service-entry/#ServiceEntry) resource.<br><p> <br><p> &#42;Note for Kubernetes users&#42;: When short names are used (e.g. "reviews" instead of "reviews.default.svc.cluster.local"), Istio will interpret the short name based on the namespace of the rule, not the service. A rule in the "default" namespace containing a host "reviews" will be interpreted as "reviews.default.svc.cluster.local", irrespective of the actual namespace associated with the reviews service. _To avoid potential misconfigurations, it is recommended to always use fully qualified domain names over short names._<br><p> <br><p> The following Kubernetes example routes all traffic by default to pods of the reviews service with label "version: v1" (i.e., subset v1), and some to subset v2, in a Kubernetes environment.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      prefix: "/wpcatalog"<br><p> 	  - uri:<br><p> 	      prefix: "/consumercatalog"<br><p> 	  rewrite:<br><p> 	    uri: "/newcatalog"<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	      subset: v2<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	      subset: v1<br><p> <br><p> ```<br><p> <br><p> # And the associated DestinationRule<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-destination<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	subsets:<br><p> 	- name: v1<br><p> 	  labels:<br><p> 	    version: v1<br><p> 	- name: v2<br><p> 	  labels:<br><p> 	    version: v2<br><p> <br><p> ```<br><p> <br><p> The following VirtualService sets a timeout of 5s for all calls to productpage.prod.svc.cluster.local service in Kubernetes. Notice that there are no subsets defined in this rule. Istio will fetch all instances of productpage.prod.svc.cluster.local service from the service registry and populate the sidecar's load balancing pool. Also, notice that this rule is set in the istio-system namespace but uses the fully qualified domain name of the productpage service, productpage.prod.svc.cluster.local. Therefore the rule's namespace does not have an impact in resolving the name of the productpage service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: my-productpage-rule<br><p> 	namespace: istio-system<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- productpage.prod.svc.cluster.local # ignores rule namespace<br><p> 	http:<br><p> 	- timeout: 5s<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: productpage.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> To control routing for traffic bound to services outside the mesh, external services must first be added to Istio's internal service registry using the ServiceEntry resource. VirtualServices can then be defined to control traffic bound to these external services. For example, the following rules define a Service for wikipedia.org and set a timeout of 5s for HTTP requests.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: ServiceEntry metadata:<br><p> <br><p> 	name: external-svc-wikipedia<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- wikipedia.org<br><p> 	location: MESH_EXTERNAL<br><p> 	ports:<br><p> 	- number: 80<br><p> 	  name: example-http<br><p> 	  protocol: HTTP<br><p> 	resolution: DNS
     */
    @JsonProperty("port")
    public PortSelector getPort() {
        return port;
    }

    /**
     * Destination indicates the network addressable service to which the request/connection will be sent after processing a routing rule. The destination.host should unambiguously refer to a service in the service registry. Istio's service registry is composed of all the services found in the platform's service registry (e.g., Kubernetes services, Consul services), as well as services declared through the [ServiceEntry](https://istio.io/docs/reference/config/networking/service-entry/#ServiceEntry) resource.<br><p> <br><p> &#42;Note for Kubernetes users&#42;: When short names are used (e.g. "reviews" instead of "reviews.default.svc.cluster.local"), Istio will interpret the short name based on the namespace of the rule, not the service. A rule in the "default" namespace containing a host "reviews" will be interpreted as "reviews.default.svc.cluster.local", irrespective of the actual namespace associated with the reviews service. _To avoid potential misconfigurations, it is recommended to always use fully qualified domain names over short names._<br><p> <br><p> The following Kubernetes example routes all traffic by default to pods of the reviews service with label "version: v1" (i.e., subset v1), and some to subset v2, in a Kubernetes environment.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      prefix: "/wpcatalog"<br><p> 	  - uri:<br><p> 	      prefix: "/consumercatalog"<br><p> 	  rewrite:<br><p> 	    uri: "/newcatalog"<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	      subset: v2<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	      subset: v1<br><p> <br><p> ```<br><p> <br><p> # And the associated DestinationRule<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-destination<br><p> 	namespace: foo<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews # interpreted as reviews.foo.svc.cluster.local<br><p> 	subsets:<br><p> 	- name: v1<br><p> 	  labels:<br><p> 	    version: v1<br><p> 	- name: v2<br><p> 	  labels:<br><p> 	    version: v2<br><p> <br><p> ```<br><p> <br><p> The following VirtualService sets a timeout of 5s for all calls to productpage.prod.svc.cluster.local service in Kubernetes. Notice that there are no subsets defined in this rule. Istio will fetch all instances of productpage.prod.svc.cluster.local service from the service registry and populate the sidecar's load balancing pool. Also, notice that this rule is set in the istio-system namespace but uses the fully qualified domain name of the productpage service, productpage.prod.svc.cluster.local. Therefore the rule's namespace does not have an impact in resolving the name of the productpage service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: my-productpage-rule<br><p> 	namespace: istio-system<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- productpage.prod.svc.cluster.local # ignores rule namespace<br><p> 	http:<br><p> 	- timeout: 5s<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: productpage.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> To control routing for traffic bound to services outside the mesh, external services must first be added to Istio's internal service registry using the ServiceEntry resource. VirtualServices can then be defined to control traffic bound to these external services. For example, the following rules define a Service for wikipedia.org and set a timeout of 5s for HTTP requests.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: ServiceEntry metadata:<br><p> <br><p> 	name: external-svc-wikipedia<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- wikipedia.org<br><p> 	location: MESH_EXTERNAL<br><p> 	ports:<br><p> 	- number: 80<br><p> 	  name: example-http<br><p> 	  protocol: HTTP<br><p> 	resolution: DNS
     */
    @JsonProperty("port")
    public void setPort(PortSelector port) {
        this.port = port;
    }

    /**
     * The name of a subset within the service. Applicable only to services within the mesh. The subset must be defined in a corresponding DestinationRule.
     */
    @JsonProperty("subset")
    public String getSubset() {
        return subset;
    }

    /**
     * The name of a subset within the service. Applicable only to services within the mesh. The subset must be defined in a corresponding DestinationRule.
     */
    @JsonProperty("subset")
    public void setSubset(String subset) {
        this.subset = subset;
    }

    @JsonIgnore
    public DestinationBuilder edit() {
        return new DestinationBuilder(this);
    }

    @JsonIgnore
    public DestinationBuilder toBuilder() {
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

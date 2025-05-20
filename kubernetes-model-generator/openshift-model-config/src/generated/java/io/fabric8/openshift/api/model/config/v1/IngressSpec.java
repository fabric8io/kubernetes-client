
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appsDomain",
    "componentRoutes",
    "domain",
    "loadBalancer",
    "requiredHSTSPolicies"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class IngressSpec implements Editable<IngressSpecBuilder>, KubernetesResource
{

    @JsonProperty("appsDomain")
    private String appsDomain;
    @JsonProperty("componentRoutes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ComponentRouteSpec> componentRoutes = new ArrayList<>();
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("loadBalancer")
    private LoadBalancer loadBalancer;
    @JsonProperty("requiredHSTSPolicies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RequiredHSTSPolicy> requiredHSTSPolicies = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
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

    /**
     * appsDomain is an optional domain to use instead of the one specified in the domain field when a Route is created without specifying an explicit host. If appsDomain is nonempty, this value is used to generate default host values for Route. Unlike domain, appsDomain may be modified after installation. This assumes a new ingresscontroller has been setup with a wildcard certificate.
     */
    @JsonProperty("appsDomain")
    public String getAppsDomain() {
        return appsDomain;
    }

    /**
     * appsDomain is an optional domain to use instead of the one specified in the domain field when a Route is created without specifying an explicit host. If appsDomain is nonempty, this value is used to generate default host values for Route. Unlike domain, appsDomain may be modified after installation. This assumes a new ingresscontroller has been setup with a wildcard certificate.
     */
    @JsonProperty("appsDomain")
    public void setAppsDomain(String appsDomain) {
        this.appsDomain = appsDomain;
    }

    /**
     * componentRoutes is an optional list of routes that are managed by OpenShift components that a cluster-admin is able to configure the hostname and serving certificate for. The namespace and name of each route in this list should match an existing entry in the status.componentRoutes list.<br><p> <br><p> To determine the set of configurable Routes, look at namespace and name of entries in the .status.componentRoutes list, where participating operators write the status of configurable routes.
     */
    @JsonProperty("componentRoutes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ComponentRouteSpec> getComponentRoutes() {
        return componentRoutes;
    }

    /**
     * componentRoutes is an optional list of routes that are managed by OpenShift components that a cluster-admin is able to configure the hostname and serving certificate for. The namespace and name of each route in this list should match an existing entry in the status.componentRoutes list.<br><p> <br><p> To determine the set of configurable Routes, look at namespace and name of entries in the .status.componentRoutes list, where participating operators write the status of configurable routes.
     */
    @JsonProperty("componentRoutes")
    public void setComponentRoutes(List<ComponentRouteSpec> componentRoutes) {
        this.componentRoutes = componentRoutes;
    }

    /**
     * domain is used to generate a default host name for a route when the route's host name is empty. The generated host name will follow this pattern: "&lt;route-name&gt;.&lt;route-namespace&gt;.&lt;domain&gt;".<br><p> <br><p> It is also used as the default wildcard domain suffix for ingress. The default ingresscontroller domain will follow this pattern: "&#42;.&lt;domain&gt;".<br><p> <br><p> Once set, changing domain is not currently supported.
     */
    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    /**
     * domain is used to generate a default host name for a route when the route's host name is empty. The generated host name will follow this pattern: "&lt;route-name&gt;.&lt;route-namespace&gt;.&lt;domain&gt;".<br><p> <br><p> It is also used as the default wildcard domain suffix for ingress. The default ingresscontroller domain will follow this pattern: "&#42;.&lt;domain&gt;".<br><p> <br><p> Once set, changing domain is not currently supported.
     */
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

    /**
     * requiredHSTSPolicies specifies HSTS policies that are required to be set on newly created  or updated routes matching the domainPattern/s and namespaceSelector/s that are specified in the policy. Each requiredHSTSPolicy must have at least a domainPattern and a maxAge to validate a route HSTS Policy route annotation, and affect route admission.<br><p> <br><p> A candidate route is checked for HSTS Policies if it has the HSTS Policy route annotation: "haproxy.router.openshift.io/hsts_header" E.g. haproxy.router.openshift.io/hsts_header: max-age=31536000;preload;includeSubDomains<br><p> <br><p> - For each candidate route, if it matches a requiredHSTSPolicy domainPattern and optional namespaceSelector, then the maxAge, preloadPolicy, and includeSubdomainsPolicy must be valid to be admitted.  Otherwise, the route is rejected. - The first match, by domainPattern and optional namespaceSelector, in the ordering of the RequiredHSTSPolicies determines the route's admission status. - If the candidate route doesn't match any requiredHSTSPolicy domainPattern and optional namespaceSelector, then it may use any HSTS Policy annotation.<br><p> <br><p> The HSTS policy configuration may be changed after routes have already been created. An update to a previously admitted route may then fail if the updated route does not conform to the updated HSTS policy configuration. However, changing the HSTS policy configuration will not cause a route that is already admitted to stop working.<br><p> <br><p> Note that if there are no RequiredHSTSPolicies, any HSTS Policy annotation on the route is valid.
     */
    @JsonProperty("requiredHSTSPolicies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RequiredHSTSPolicy> getRequiredHSTSPolicies() {
        return requiredHSTSPolicies;
    }

    /**
     * requiredHSTSPolicies specifies HSTS policies that are required to be set on newly created  or updated routes matching the domainPattern/s and namespaceSelector/s that are specified in the policy. Each requiredHSTSPolicy must have at least a domainPattern and a maxAge to validate a route HSTS Policy route annotation, and affect route admission.<br><p> <br><p> A candidate route is checked for HSTS Policies if it has the HSTS Policy route annotation: "haproxy.router.openshift.io/hsts_header" E.g. haproxy.router.openshift.io/hsts_header: max-age=31536000;preload;includeSubDomains<br><p> <br><p> - For each candidate route, if it matches a requiredHSTSPolicy domainPattern and optional namespaceSelector, then the maxAge, preloadPolicy, and includeSubdomainsPolicy must be valid to be admitted.  Otherwise, the route is rejected. - The first match, by domainPattern and optional namespaceSelector, in the ordering of the RequiredHSTSPolicies determines the route's admission status. - If the candidate route doesn't match any requiredHSTSPolicy domainPattern and optional namespaceSelector, then it may use any HSTS Policy annotation.<br><p> <br><p> The HSTS policy configuration may be changed after routes have already been created. An update to a previously admitted route may then fail if the updated route does not conform to the updated HSTS policy configuration. However, changing the HSTS policy configuration will not cause a route that is already admitted to stop working.<br><p> <br><p> Note that if there are no RequiredHSTSPolicies, any HSTS Policy annotation on the route is valid.
     */
    @JsonProperty("requiredHSTSPolicies")
    public void setRequiredHSTSPolicies(List<RequiredHSTSPolicy> requiredHSTSPolicies) {
        this.requiredHSTSPolicies = requiredHSTSPolicies;
    }

    @JsonIgnore
    public IngressSpecBuilder edit() {
        return new IngressSpecBuilder(this);
    }

    @JsonIgnore
    public IngressSpecBuilder toBuilder() {
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

}

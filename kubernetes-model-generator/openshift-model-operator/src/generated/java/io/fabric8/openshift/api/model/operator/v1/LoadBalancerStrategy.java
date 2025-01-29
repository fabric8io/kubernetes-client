
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
 * LoadBalancerStrategy holds parameters for a load balancer.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedSourceRanges",
    "dnsManagementPolicy",
    "providerParameters",
    "scope"
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
public class LoadBalancerStrategy implements Editable<LoadBalancerStrategyBuilder>, KubernetesResource
{

    @JsonProperty("allowedSourceRanges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedSourceRanges = new ArrayList<>();
    @JsonProperty("dnsManagementPolicy")
    private String dnsManagementPolicy;
    @JsonProperty("providerParameters")
    private ProviderLoadBalancerParameters providerParameters;
    @JsonProperty("scope")
    private String scope;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoadBalancerStrategy() {
    }

    public LoadBalancerStrategy(List<String> allowedSourceRanges, String dnsManagementPolicy, ProviderLoadBalancerParameters providerParameters, String scope) {
        super();
        this.allowedSourceRanges = allowedSourceRanges;
        this.dnsManagementPolicy = dnsManagementPolicy;
        this.providerParameters = providerParameters;
        this.scope = scope;
    }

    /**
     * allowedSourceRanges specifies an allowlist of IP address ranges to which access to the load balancer should be restricted.  Each range must be specified using CIDR notation (e.g. "10.0.0.0/8" or "fd00::/8"). If no range is specified, "0.0.0.0/0" for IPv4 and "::/0" for IPv6 are used by default, which allows all source addresses.<br><p> <br><p> To facilitate migration from earlier versions of OpenShift that did not have the allowedSourceRanges field, you may set the service.beta.kubernetes.io/load-balancer-source-ranges annotation on the "router-&lt;ingresscontroller name&gt;" service in the "openshift-ingress" namespace, and this annotation will take effect if allowedSourceRanges is empty on OpenShift 4.12.
     */
    @JsonProperty("allowedSourceRanges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedSourceRanges() {
        return allowedSourceRanges;
    }

    /**
     * allowedSourceRanges specifies an allowlist of IP address ranges to which access to the load balancer should be restricted.  Each range must be specified using CIDR notation (e.g. "10.0.0.0/8" or "fd00::/8"). If no range is specified, "0.0.0.0/0" for IPv4 and "::/0" for IPv6 are used by default, which allows all source addresses.<br><p> <br><p> To facilitate migration from earlier versions of OpenShift that did not have the allowedSourceRanges field, you may set the service.beta.kubernetes.io/load-balancer-source-ranges annotation on the "router-&lt;ingresscontroller name&gt;" service in the "openshift-ingress" namespace, and this annotation will take effect if allowedSourceRanges is empty on OpenShift 4.12.
     */
    @JsonProperty("allowedSourceRanges")
    public void setAllowedSourceRanges(List<String> allowedSourceRanges) {
        this.allowedSourceRanges = allowedSourceRanges;
    }

    /**
     * dnsManagementPolicy indicates if the lifecycle of the wildcard DNS record associated with the load balancer service will be managed by the ingress operator. It defaults to Managed. Valid values are: Managed and Unmanaged.
     */
    @JsonProperty("dnsManagementPolicy")
    public String getDnsManagementPolicy() {
        return dnsManagementPolicy;
    }

    /**
     * dnsManagementPolicy indicates if the lifecycle of the wildcard DNS record associated with the load balancer service will be managed by the ingress operator. It defaults to Managed. Valid values are: Managed and Unmanaged.
     */
    @JsonProperty("dnsManagementPolicy")
    public void setDnsManagementPolicy(String dnsManagementPolicy) {
        this.dnsManagementPolicy = dnsManagementPolicy;
    }

    /**
     * LoadBalancerStrategy holds parameters for a load balancer.
     */
    @JsonProperty("providerParameters")
    public ProviderLoadBalancerParameters getProviderParameters() {
        return providerParameters;
    }

    /**
     * LoadBalancerStrategy holds parameters for a load balancer.
     */
    @JsonProperty("providerParameters")
    public void setProviderParameters(ProviderLoadBalancerParameters providerParameters) {
        this.providerParameters = providerParameters;
    }

    /**
     * scope indicates the scope at which the load balancer is exposed. Possible values are "External" and "Internal".
     */
    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    /**
     * scope indicates the scope at which the load balancer is exposed. Possible values are "External" and "Internal".
     */
    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonIgnore
    public LoadBalancerStrategyBuilder edit() {
        return new LoadBalancerStrategyBuilder(this);
    }

    @JsonIgnore
    public LoadBalancerStrategyBuilder toBuilder() {
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

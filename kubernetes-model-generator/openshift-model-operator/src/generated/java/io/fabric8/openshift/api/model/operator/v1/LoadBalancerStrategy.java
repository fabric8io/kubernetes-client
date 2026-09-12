
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
        if (!(o instanceof LoadBalancerStrategy)) {
            return false;
        }
        LoadBalancerStrategy other = (LoadBalancerStrategy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowedSourceRanges = this.getAllowedSourceRanges();
        Object other$allowedSourceRanges = other.getAllowedSourceRanges();
        if (this$allowedSourceRanges == null ? other$allowedSourceRanges != null : !this$allowedSourceRanges.equals(other$allowedSourceRanges)) {
            return false;
        }
        Object this$dnsManagementPolicy = this.getDnsManagementPolicy();
        Object other$dnsManagementPolicy = other.getDnsManagementPolicy();
        if (this$dnsManagementPolicy == null ? other$dnsManagementPolicy != null : !this$dnsManagementPolicy.equals(other$dnsManagementPolicy)) {
            return false;
        }
        Object this$providerParameters = this.getProviderParameters();
        Object other$providerParameters = other.getProviderParameters();
        if (this$providerParameters == null ? other$providerParameters != null : !this$providerParameters.equals(other$providerParameters)) {
            return false;
        }
        Object this$scope = this.getScope();
        Object other$scope = other.getScope();
        if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) {
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
        return other instanceof LoadBalancerStrategy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowedSourceRanges = this.getAllowedSourceRanges();
        result = result * prime + ($allowedSourceRanges == null ? 43 : $allowedSourceRanges.hashCode());
        Object $dnsManagementPolicy = this.getDnsManagementPolicy();
        result = result * prime + ($dnsManagementPolicy == null ? 43 : $dnsManagementPolicy.hashCode());
        Object $providerParameters = this.getProviderParameters();
        result = result * prime + ($providerParameters == null ? 43 : $providerParameters.hashCode());
        Object $scope = this.getScope();
        result = result * prime + ($scope == null ? 43 : $scope.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LoadBalancerStrategy(" + "allowedSourceRanges=" + this.getAllowedSourceRanges() + ", dnsManagementPolicy=" + this.getDnsManagementPolicy() + ", providerParameters=" + this.getProviderParameters() + ", scope=" + this.getScope() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

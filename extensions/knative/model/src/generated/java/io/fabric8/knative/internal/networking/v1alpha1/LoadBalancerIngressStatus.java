
package io.fabric8.knative.internal.networking.v1alpha1;

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

/**
 * LoadBalancerIngressStatus represents the status of a load-balancer ingress point: traffic intended for the service should be sent to an ingress point.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "domain",
    "domainInternal",
    "ip",
    "meshOnly"
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
public class LoadBalancerIngressStatus implements Editable<LoadBalancerIngressStatusBuilder>, KubernetesResource
{

    @JsonProperty("domain")
    private String domain;
    @JsonProperty("domainInternal")
    private String domainInternal;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("meshOnly")
    private Boolean meshOnly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoadBalancerIngressStatus() {
    }

    public LoadBalancerIngressStatus(String domain, String domainInternal, String ip, Boolean meshOnly) {
        super();
        this.domain = domain;
        this.domainInternal = domainInternal;
        this.ip = ip;
        this.meshOnly = meshOnly;
    }

    /**
     * Domain is set for load-balancer ingress points that are DNS based (typically AWS load-balancers)
     */
    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    /**
     * Domain is set for load-balancer ingress points that are DNS based (typically AWS load-balancers)
     */
    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * DomainInternal is set if there is a cluster-local DNS name to access the Ingress.<br><p> <br><p> NOTE: This differs from K8s Ingress, since we also desire to have a cluster-local<br><p>       DNS name to allow routing in case of not having a mesh.
     */
    @JsonProperty("domainInternal")
    public String getDomainInternal() {
        return domainInternal;
    }

    /**
     * DomainInternal is set if there is a cluster-local DNS name to access the Ingress.<br><p> <br><p> NOTE: This differs from K8s Ingress, since we also desire to have a cluster-local<br><p>       DNS name to allow routing in case of not having a mesh.
     */
    @JsonProperty("domainInternal")
    public void setDomainInternal(String domainInternal) {
        this.domainInternal = domainInternal;
    }

    /**
     * IP is set for load-balancer ingress points that are IP based (typically GCE or OpenStack load-balancers)
     */
    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    /**
     * IP is set for load-balancer ingress points that are IP based (typically GCE or OpenStack load-balancers)
     */
    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * MeshOnly is set if the Ingress is only load-balanced through a Service mesh.
     */
    @JsonProperty("meshOnly")
    public Boolean getMeshOnly() {
        return meshOnly;
    }

    /**
     * MeshOnly is set if the Ingress is only load-balanced through a Service mesh.
     */
    @JsonProperty("meshOnly")
    public void setMeshOnly(Boolean meshOnly) {
        this.meshOnly = meshOnly;
    }

    @JsonIgnore
    public LoadBalancerIngressStatusBuilder edit() {
        return new LoadBalancerIngressStatusBuilder(this);
    }

    @JsonIgnore
    public LoadBalancerIngressStatusBuilder toBuilder() {
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
        if (!(o instanceof LoadBalancerIngressStatus)) {
            return false;
        }
        LoadBalancerIngressStatus other = (LoadBalancerIngressStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$domain = this.getDomain();
        Object other$domain = other.getDomain();
        if (this$domain == null ? other$domain != null : !this$domain.equals(other$domain)) {
            return false;
        }
        Object this$domainInternal = this.getDomainInternal();
        Object other$domainInternal = other.getDomainInternal();
        if (this$domainInternal == null ? other$domainInternal != null : !this$domainInternal.equals(other$domainInternal)) {
            return false;
        }
        Object this$ip = this.getIp();
        Object other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
            return false;
        }
        Object this$meshOnly = this.getMeshOnly();
        Object other$meshOnly = other.getMeshOnly();
        if (this$meshOnly == null ? other$meshOnly != null : !this$meshOnly.equals(other$meshOnly)) {
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
        return other instanceof LoadBalancerIngressStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $domain = this.getDomain();
        result = result * prime + ($domain == null ? 43 : $domain.hashCode());
        Object $domainInternal = this.getDomainInternal();
        result = result * prime + ($domainInternal == null ? 43 : $domainInternal.hashCode());
        Object $ip = this.getIp();
        result = result * prime + ($ip == null ? 43 : $ip.hashCode());
        Object $meshOnly = this.getMeshOnly();
        result = result * prime + ($meshOnly == null ? 43 : $meshOnly.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LoadBalancerIngressStatus(" + "domain=" + this.getDomain() + ", domainInternal=" + this.getDomainInternal() + ", ip=" + this.getIp() + ", meshOnly=" + this.getMeshOnly() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

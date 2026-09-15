
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1.FailureDomainSpec;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Metal3ClusterSpec defines the desired state of Metal3Cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloudProviderEnabled",
    "controlPlaneEndpoint",
    "failureDomains",
    "noCloudProvider"
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
public class Metal3ClusterSpec implements Editable<Metal3ClusterSpecBuilder>, KubernetesResource
{

    @JsonProperty("cloudProviderEnabled")
    private Boolean cloudProviderEnabled;
    @JsonProperty("controlPlaneEndpoint")
    private APIEndpoint controlPlaneEndpoint;
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, FailureDomainSpec> failureDomains = new LinkedHashMap<>();
    @JsonProperty("noCloudProvider")
    private Boolean noCloudProvider;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metal3ClusterSpec() {
    }

    public Metal3ClusterSpec(Boolean cloudProviderEnabled, APIEndpoint controlPlaneEndpoint, Map<String, FailureDomainSpec> failureDomains, Boolean noCloudProvider) {
        super();
        this.cloudProviderEnabled = cloudProviderEnabled;
        this.controlPlaneEndpoint = controlPlaneEndpoint;
        this.failureDomains = failureDomains;
        this.noCloudProvider = noCloudProvider;
    }

    /**
     * Determines if the cluster is to be deployed with an external cloud provider. If set to false, CAPM3 will use node labels to set providerID on the kubernetes nodes. If set to true, providerID is set on nodes by other entities and CAPM3 uses the value of the providerID on the m3m resource. Default value is true, it is set in the webhook.
     */
    @JsonProperty("cloudProviderEnabled")
    public Boolean getCloudProviderEnabled() {
        return cloudProviderEnabled;
    }

    /**
     * Determines if the cluster is to be deployed with an external cloud provider. If set to false, CAPM3 will use node labels to set providerID on the kubernetes nodes. If set to true, providerID is set on nodes by other entities and CAPM3 uses the value of the providerID on the m3m resource. Default value is true, it is set in the webhook.
     */
    @JsonProperty("cloudProviderEnabled")
    public void setCloudProviderEnabled(Boolean cloudProviderEnabled) {
        this.cloudProviderEnabled = cloudProviderEnabled;
    }

    /**
     * Metal3ClusterSpec defines the desired state of Metal3Cluster.
     */
    @JsonProperty("controlPlaneEndpoint")
    public APIEndpoint getControlPlaneEndpoint() {
        return controlPlaneEndpoint;
    }

    /**
     * Metal3ClusterSpec defines the desired state of Metal3Cluster.
     */
    @JsonProperty("controlPlaneEndpoint")
    public void setControlPlaneEndpoint(APIEndpoint controlPlaneEndpoint) {
        this.controlPlaneEndpoint = controlPlaneEndpoint;
    }

    /**
     * FailureDomains specifies a list fo failure zones that can be used
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, FailureDomainSpec> getFailureDomains() {
        return failureDomains;
    }

    /**
     * FailureDomains specifies a list fo failure zones that can be used
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(Map<String, FailureDomainSpec> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * Determines if the cluster is not to be deployed with an external cloud provider. If set to true, CAPM3 will use node labels to set providerID on the kubernetes nodes. If set to false, providerID is set on nodes by other entities and CAPM3 uses the value of the providerID on the m3m resource.<br><p> <br><p> Deprecated: This field is deprecated, use cloudProviderEnabled instead
     */
    @JsonProperty("noCloudProvider")
    public Boolean getNoCloudProvider() {
        return noCloudProvider;
    }

    /**
     * Determines if the cluster is not to be deployed with an external cloud provider. If set to true, CAPM3 will use node labels to set providerID on the kubernetes nodes. If set to false, providerID is set on nodes by other entities and CAPM3 uses the value of the providerID on the m3m resource.<br><p> <br><p> Deprecated: This field is deprecated, use cloudProviderEnabled instead
     */
    @JsonProperty("noCloudProvider")
    public void setNoCloudProvider(Boolean noCloudProvider) {
        this.noCloudProvider = noCloudProvider;
    }

    @JsonIgnore
    public Metal3ClusterSpecBuilder edit() {
        return new Metal3ClusterSpecBuilder(this);
    }

    @JsonIgnore
    public Metal3ClusterSpecBuilder toBuilder() {
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
        if (!(o instanceof Metal3ClusterSpec)) {
            return false;
        }
        Metal3ClusterSpec other = (Metal3ClusterSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cloudProviderEnabled = this.getCloudProviderEnabled();
        Object other$cloudProviderEnabled = other.getCloudProviderEnabled();
        if (this$cloudProviderEnabled == null ? other$cloudProviderEnabled != null : !this$cloudProviderEnabled.equals(other$cloudProviderEnabled)) {
            return false;
        }
        Object this$controlPlaneEndpoint = this.getControlPlaneEndpoint();
        Object other$controlPlaneEndpoint = other.getControlPlaneEndpoint();
        if (this$controlPlaneEndpoint == null ? other$controlPlaneEndpoint != null : !this$controlPlaneEndpoint.equals(other$controlPlaneEndpoint)) {
            return false;
        }
        Object this$failureDomains = this.getFailureDomains();
        Object other$failureDomains = other.getFailureDomains();
        if (this$failureDomains == null ? other$failureDomains != null : !this$failureDomains.equals(other$failureDomains)) {
            return false;
        }
        Object this$noCloudProvider = this.getNoCloudProvider();
        Object other$noCloudProvider = other.getNoCloudProvider();
        if (this$noCloudProvider == null ? other$noCloudProvider != null : !this$noCloudProvider.equals(other$noCloudProvider)) {
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
        return other instanceof Metal3ClusterSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cloudProviderEnabled = this.getCloudProviderEnabled();
        result = result * prime + ($cloudProviderEnabled == null ? 43 : $cloudProviderEnabled.hashCode());
        Object $controlPlaneEndpoint = this.getControlPlaneEndpoint();
        result = result * prime + ($controlPlaneEndpoint == null ? 43 : $controlPlaneEndpoint.hashCode());
        Object $failureDomains = this.getFailureDomains();
        result = result * prime + ($failureDomains == null ? 43 : $failureDomains.hashCode());
        Object $noCloudProvider = this.getNoCloudProvider();
        result = result * prime + ($noCloudProvider == null ? 43 : $noCloudProvider.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metal3ClusterSpec(" + "cloudProviderEnabled=" + this.getCloudProviderEnabled() + ", controlPlaneEndpoint=" + this.getControlPlaneEndpoint() + ", failureDomains=" + this.getFailureDomains() + ", noCloudProvider=" + this.getNoCloudProvider() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

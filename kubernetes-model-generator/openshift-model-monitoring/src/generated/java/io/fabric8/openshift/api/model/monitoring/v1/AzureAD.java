
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AzureAD defines the configuration for remote write's azuread parameters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloud",
    "managedIdentity",
    "oauth",
    "scope",
    "sdk",
    "workloadIdentity"
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
public class AzureAD implements Editable<AzureADBuilder>, KubernetesResource
{

    @JsonProperty("cloud")
    private String cloud;
    @JsonProperty("managedIdentity")
    private ManagedIdentity managedIdentity;
    @JsonProperty("oauth")
    private AzureOAuth oauth;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("sdk")
    private AzureSDK sdk;
    @JsonProperty("workloadIdentity")
    private AzureWorkloadIdentity workloadIdentity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureAD() {
    }

    public AzureAD(String cloud, ManagedIdentity managedIdentity, AzureOAuth oauth, String scope, AzureSDK sdk, AzureWorkloadIdentity workloadIdentity) {
        super();
        this.cloud = cloud;
        this.managedIdentity = managedIdentity;
        this.oauth = oauth;
        this.scope = scope;
        this.sdk = sdk;
        this.workloadIdentity = workloadIdentity;
    }

    /**
     * cloud defines the Azure Cloud. Options are 'AzurePublic', 'AzureChina', or 'AzureGovernment'.
     */
    @JsonProperty("cloud")
    public String getCloud() {
        return cloud;
    }

    /**
     * cloud defines the Azure Cloud. Options are 'AzurePublic', 'AzureChina', or 'AzureGovernment'.
     */
    @JsonProperty("cloud")
    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("managedIdentity")
    public ManagedIdentity getManagedIdentity() {
        return managedIdentity;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("managedIdentity")
    public void setManagedIdentity(ManagedIdentity managedIdentity) {
        this.managedIdentity = managedIdentity;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("oauth")
    public AzureOAuth getOauth() {
        return oauth;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("oauth")
    public void setOauth(AzureOAuth oauth) {
        this.oauth = oauth;
    }

    /**
     * scope is the custom OAuth 2.0 scope to request when acquiring tokens. It requires Prometheus &gt;= 3.9.0. Currently not supported by Thanos.
     */
    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    /**
     * scope is the custom OAuth 2.0 scope to request when acquiring tokens. It requires Prometheus &gt;= 3.9.0. Currently not supported by Thanos.
     */
    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("sdk")
    public AzureSDK getSdk() {
        return sdk;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("sdk")
    public void setSdk(AzureSDK sdk) {
        this.sdk = sdk;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("workloadIdentity")
    public AzureWorkloadIdentity getWorkloadIdentity() {
        return workloadIdentity;
    }

    /**
     * AzureAD defines the configuration for remote write's azuread parameters.
     */
    @JsonProperty("workloadIdentity")
    public void setWorkloadIdentity(AzureWorkloadIdentity workloadIdentity) {
        this.workloadIdentity = workloadIdentity;
    }

    @JsonIgnore
    public AzureADBuilder edit() {
        return new AzureADBuilder(this);
    }

    @JsonIgnore
    public AzureADBuilder toBuilder() {
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
        if (!(o instanceof AzureAD)) {
            return false;
        }
        AzureAD other = (AzureAD) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cloud = this.getCloud();
        Object other$cloud = other.getCloud();
        if (this$cloud == null ? other$cloud != null : !this$cloud.equals(other$cloud)) {
            return false;
        }
        Object this$managedIdentity = this.getManagedIdentity();
        Object other$managedIdentity = other.getManagedIdentity();
        if (this$managedIdentity == null ? other$managedIdentity != null : !this$managedIdentity.equals(other$managedIdentity)) {
            return false;
        }
        Object this$oauth = this.getOauth();
        Object other$oauth = other.getOauth();
        if (this$oauth == null ? other$oauth != null : !this$oauth.equals(other$oauth)) {
            return false;
        }
        Object this$scope = this.getScope();
        Object other$scope = other.getScope();
        if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) {
            return false;
        }
        Object this$sdk = this.getSdk();
        Object other$sdk = other.getSdk();
        if (this$sdk == null ? other$sdk != null : !this$sdk.equals(other$sdk)) {
            return false;
        }
        Object this$workloadIdentity = this.getWorkloadIdentity();
        Object other$workloadIdentity = other.getWorkloadIdentity();
        if (this$workloadIdentity == null ? other$workloadIdentity != null : !this$workloadIdentity.equals(other$workloadIdentity)) {
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
        return other instanceof AzureAD;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cloud = this.getCloud();
        result = result * prime + ($cloud == null ? 43 : $cloud.hashCode());
        Object $managedIdentity = this.getManagedIdentity();
        result = result * prime + ($managedIdentity == null ? 43 : $managedIdentity.hashCode());
        Object $oauth = this.getOauth();
        result = result * prime + ($oauth == null ? 43 : $oauth.hashCode());
        Object $scope = this.getScope();
        result = result * prime + ($scope == null ? 43 : $scope.hashCode());
        Object $sdk = this.getSdk();
        result = result * prime + ($sdk == null ? 43 : $sdk.hashCode());
        Object $workloadIdentity = this.getWorkloadIdentity();
        result = result * prime + ($workloadIdentity == null ? 43 : $workloadIdentity.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureAD(" + "cloud=" + this.getCloud() + ", managedIdentity=" + this.getManagedIdentity() + ", oauth=" + this.getOauth() + ", scope=" + this.getScope() + ", sdk=" + this.getSdk() + ", workloadIdentity=" + this.getWorkloadIdentity() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

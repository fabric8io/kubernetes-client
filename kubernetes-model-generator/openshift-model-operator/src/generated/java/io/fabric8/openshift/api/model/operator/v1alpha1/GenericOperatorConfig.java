
package io.fabric8.openshift.api.model.operator.v1alpha1;

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
import io.fabric8.openshift.api.model.config.v1.HTTPServingInfo;
import io.fabric8.openshift.api.model.config.v1.LeaderElection;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GenericOperatorConfig provides information to configure an operator<br><p> <br><p> Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "authentication",
    "authorization",
    "leaderElection",
    "servingInfo"
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
@Version("v1alpha1")
@Group("operator.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GenericOperatorConfig implements Editable<GenericOperatorConfigBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "operator.openshift.io/v1alpha1";
    @JsonProperty("authentication")
    private DelegatedAuthentication authentication;
    @JsonProperty("authorization")
    private DelegatedAuthorization authorization;
    @JsonProperty("kind")
    private String kind = "GenericOperatorConfig";
    @JsonProperty("leaderElection")
    private LeaderElection leaderElection;
    @JsonProperty("servingInfo")
    private HTTPServingInfo servingInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GenericOperatorConfig() {
    }

    public GenericOperatorConfig(String apiVersion, DelegatedAuthentication authentication, DelegatedAuthorization authorization, String kind, LeaderElection leaderElection, HTTPServingInfo servingInfo) {
        super();
        this.apiVersion = apiVersion;
        this.authentication = authentication;
        this.authorization = authorization;
        this.kind = kind;
        this.leaderElection = leaderElection;
        this.servingInfo = servingInfo;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * GenericOperatorConfig provides information to configure an operator<br><p> <br><p> Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("authentication")
    public DelegatedAuthentication getAuthentication() {
        return authentication;
    }

    /**
     * GenericOperatorConfig provides information to configure an operator<br><p> <br><p> Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("authentication")
    public void setAuthentication(DelegatedAuthentication authentication) {
        this.authentication = authentication;
    }

    /**
     * GenericOperatorConfig provides information to configure an operator<br><p> <br><p> Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("authorization")
    public DelegatedAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * GenericOperatorConfig provides information to configure an operator<br><p> <br><p> Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("authorization")
    public void setAuthorization(DelegatedAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * GenericOperatorConfig provides information to configure an operator<br><p> <br><p> Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("leaderElection")
    public LeaderElection getLeaderElection() {
        return leaderElection;
    }

    /**
     * GenericOperatorConfig provides information to configure an operator<br><p> <br><p> Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("leaderElection")
    public void setLeaderElection(LeaderElection leaderElection) {
        this.leaderElection = leaderElection;
    }

    /**
     * GenericOperatorConfig provides information to configure an operator<br><p> <br><p> Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("servingInfo")
    public HTTPServingInfo getServingInfo() {
        return servingInfo;
    }

    /**
     * GenericOperatorConfig provides information to configure an operator<br><p> <br><p> Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("servingInfo")
    public void setServingInfo(HTTPServingInfo servingInfo) {
        this.servingInfo = servingInfo;
    }

    @JsonIgnore
    public GenericOperatorConfigBuilder edit() {
        return new GenericOperatorConfigBuilder(this);
    }

    @JsonIgnore
    public GenericOperatorConfigBuilder toBuilder() {
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
        if (!(o instanceof GenericOperatorConfig)) {
            return false;
        }
        GenericOperatorConfig other = (GenericOperatorConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$authentication = this.getAuthentication();
        Object other$authentication = other.getAuthentication();
        if (this$authentication == null ? other$authentication != null : !this$authentication.equals(other$authentication)) {
            return false;
        }
        Object this$authorization = this.getAuthorization();
        Object other$authorization = other.getAuthorization();
        if (this$authorization == null ? other$authorization != null : !this$authorization.equals(other$authorization)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$leaderElection = this.getLeaderElection();
        Object other$leaderElection = other.getLeaderElection();
        if (this$leaderElection == null ? other$leaderElection != null : !this$leaderElection.equals(other$leaderElection)) {
            return false;
        }
        Object this$servingInfo = this.getServingInfo();
        Object other$servingInfo = other.getServingInfo();
        if (this$servingInfo == null ? other$servingInfo != null : !this$servingInfo.equals(other$servingInfo)) {
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
        return other instanceof GenericOperatorConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $authentication = this.getAuthentication();
        result = result * prime + ($authentication == null ? 43 : $authentication.hashCode());
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $leaderElection = this.getLeaderElection();
        result = result * prime + ($leaderElection == null ? 43 : $leaderElection.hashCode());
        Object $servingInfo = this.getServingInfo();
        result = result * prime + ($servingInfo == null ? 43 : $servingInfo.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GenericOperatorConfig(" + "apiVersion=" + this.getApiVersion() + ", authentication=" + this.getAuthentication() + ", authorization=" + this.getAuthorization() + ", kind=" + this.getKind() + ", leaderElection=" + this.getLeaderElection() + ", servingInfo=" + this.getServingInfo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

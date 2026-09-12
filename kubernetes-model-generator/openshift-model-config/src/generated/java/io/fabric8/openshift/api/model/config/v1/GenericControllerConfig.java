
package io.fabric8.openshift.api.model.config.v1;

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
 * GenericControllerConfig provides information to configure a controller
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GenericControllerConfig implements Editable<GenericControllerConfigBuilder>, KubernetesResource
{

    @JsonProperty("authentication")
    private DelegatedAuthentication authentication;
    @JsonProperty("authorization")
    private DelegatedAuthorization authorization;
    @JsonProperty("leaderElection")
    private LeaderElection leaderElection;
    @JsonProperty("servingInfo")
    private HTTPServingInfo servingInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GenericControllerConfig() {
    }

    public GenericControllerConfig(DelegatedAuthentication authentication, DelegatedAuthorization authorization, LeaderElection leaderElection, HTTPServingInfo servingInfo) {
        super();
        this.authentication = authentication;
        this.authorization = authorization;
        this.leaderElection = leaderElection;
        this.servingInfo = servingInfo;
    }

    /**
     * GenericControllerConfig provides information to configure a controller
     */
    @JsonProperty("authentication")
    public DelegatedAuthentication getAuthentication() {
        return authentication;
    }

    /**
     * GenericControllerConfig provides information to configure a controller
     */
    @JsonProperty("authentication")
    public void setAuthentication(DelegatedAuthentication authentication) {
        this.authentication = authentication;
    }

    /**
     * GenericControllerConfig provides information to configure a controller
     */
    @JsonProperty("authorization")
    public DelegatedAuthorization getAuthorization() {
        return authorization;
    }

    /**
     * GenericControllerConfig provides information to configure a controller
     */
    @JsonProperty("authorization")
    public void setAuthorization(DelegatedAuthorization authorization) {
        this.authorization = authorization;
    }

    /**
     * GenericControllerConfig provides information to configure a controller
     */
    @JsonProperty("leaderElection")
    public LeaderElection getLeaderElection() {
        return leaderElection;
    }

    /**
     * GenericControllerConfig provides information to configure a controller
     */
    @JsonProperty("leaderElection")
    public void setLeaderElection(LeaderElection leaderElection) {
        this.leaderElection = leaderElection;
    }

    /**
     * GenericControllerConfig provides information to configure a controller
     */
    @JsonProperty("servingInfo")
    public HTTPServingInfo getServingInfo() {
        return servingInfo;
    }

    /**
     * GenericControllerConfig provides information to configure a controller
     */
    @JsonProperty("servingInfo")
    public void setServingInfo(HTTPServingInfo servingInfo) {
        this.servingInfo = servingInfo;
    }

    @JsonIgnore
    public GenericControllerConfigBuilder edit() {
        return new GenericControllerConfigBuilder(this);
    }

    @JsonIgnore
    public GenericControllerConfigBuilder toBuilder() {
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
        if (!(o instanceof GenericControllerConfig)) {
            return false;
        }
        GenericControllerConfig other = (GenericControllerConfig) o;
        if (!other.canEqual(this)) {
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
        return other instanceof GenericControllerConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authentication = this.getAuthentication();
        result = result * prime + ($authentication == null ? 43 : $authentication.hashCode());
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
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
        return "GenericControllerConfig(" + "authentication=" + this.getAuthentication() + ", authorization=" + this.getAuthorization() + ", leaderElection=" + this.getLeaderElection() + ", servingInfo=" + this.getServingInfo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

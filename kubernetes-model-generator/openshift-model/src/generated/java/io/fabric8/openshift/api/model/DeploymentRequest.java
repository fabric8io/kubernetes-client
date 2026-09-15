
package io.fabric8.openshift.api.model;

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

/**
 * DeploymentRequest is a request to a deployment config for a new deployment.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "excludeTriggers",
    "force",
    "latest",
    "name"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Version("v1")
@Group("apps.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DeploymentRequest implements Editable<DeploymentRequestBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "apps.openshift.io/v1";
    @JsonProperty("excludeTriggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> excludeTriggers = new ArrayList<>();
    @JsonProperty("force")
    private Boolean force;
    @JsonProperty("kind")
    private String kind = "DeploymentRequest";
    @JsonProperty("latest")
    private Boolean latest;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeploymentRequest() {
    }

    public DeploymentRequest(String apiVersion, List<String> excludeTriggers, Boolean force, String kind, Boolean latest, String name) {
        super();
        this.apiVersion = apiVersion;
        this.excludeTriggers = excludeTriggers;
        this.force = force;
        this.kind = kind;
        this.latest = latest;
        this.name = name;
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
     * excludeTriggers instructs the instantiator to avoid processing the specified triggers. This field overrides the triggers from latest and allows clients to control specific logic. This field is ignored if not specified.
     */
    @JsonProperty("excludeTriggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExcludeTriggers() {
        return excludeTriggers;
    }

    /**
     * excludeTriggers instructs the instantiator to avoid processing the specified triggers. This field overrides the triggers from latest and allows clients to control specific logic. This field is ignored if not specified.
     */
    @JsonProperty("excludeTriggers")
    public void setExcludeTriggers(List<String> excludeTriggers) {
        this.excludeTriggers = excludeTriggers;
    }

    /**
     * force will try to force a new deployment to run. If the deployment config is paused, then setting this to true will return an Invalid error.
     */
    @JsonProperty("force")
    public Boolean getForce() {
        return force;
    }

    /**
     * force will try to force a new deployment to run. If the deployment config is paused, then setting this to true will return an Invalid error.
     */
    @JsonProperty("force")
    public void setForce(Boolean force) {
        this.force = force;
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
     * latest will update the deployment config with the latest state from all triggers.
     */
    @JsonProperty("latest")
    public Boolean getLatest() {
        return latest;
    }

    /**
     * latest will update the deployment config with the latest state from all triggers.
     */
    @JsonProperty("latest")
    public void setLatest(Boolean latest) {
        this.latest = latest;
    }

    /**
     * name of the deployment config for requesting a new deployment.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of the deployment config for requesting a new deployment.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public DeploymentRequestBuilder edit() {
        return new DeploymentRequestBuilder(this);
    }

    @JsonIgnore
    public DeploymentRequestBuilder toBuilder() {
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
        if (!(o instanceof DeploymentRequest)) {
            return false;
        }
        DeploymentRequest other = (DeploymentRequest) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$excludeTriggers = this.getExcludeTriggers();
        Object other$excludeTriggers = other.getExcludeTriggers();
        if (this$excludeTriggers == null ? other$excludeTriggers != null : !this$excludeTriggers.equals(other$excludeTriggers)) {
            return false;
        }
        Object this$force = this.getForce();
        Object other$force = other.getForce();
        if (this$force == null ? other$force != null : !this$force.equals(other$force)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$latest = this.getLatest();
        Object other$latest = other.getLatest();
        if (this$latest == null ? other$latest != null : !this$latest.equals(other$latest)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof DeploymentRequest;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $excludeTriggers = this.getExcludeTriggers();
        result = result * prime + ($excludeTriggers == null ? 43 : $excludeTriggers.hashCode());
        Object $force = this.getForce();
        result = result * prime + ($force == null ? 43 : $force.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $latest = this.getLatest();
        result = result * prime + ($latest == null ? 43 : $latest.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeploymentRequest(" + "apiVersion=" + this.getApiVersion() + ", excludeTriggers=" + this.getExcludeTriggers() + ", force=" + this.getForce() + ", kind=" + this.getKind() + ", latest=" + this.getLatest() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

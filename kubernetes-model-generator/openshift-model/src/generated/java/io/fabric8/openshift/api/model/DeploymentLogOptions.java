
package io.fabric8.openshift.api.model;

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
 * DeploymentLogOptions is the REST options for a deployment log<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "container",
    "follow",
    "limitBytes",
    "nowait",
    "previous",
    "sinceSeconds",
    "sinceTime",
    "tailLines",
    "timestamps",
    "version"
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
public class DeploymentLogOptions implements Editable<DeploymentLogOptionsBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "apps.openshift.io/v1";
    @JsonProperty("container")
    private String container;
    @JsonProperty("follow")
    private Boolean follow;
    @JsonProperty("kind")
    private String kind = "DeploymentLogOptions";
    @JsonProperty("limitBytes")
    private Long limitBytes;
    @JsonProperty("nowait")
    private Boolean nowait;
    @JsonProperty("previous")
    private Boolean previous;
    @JsonProperty("sinceSeconds")
    private Long sinceSeconds;
    @JsonProperty("sinceTime")
    private String sinceTime;
    @JsonProperty("tailLines")
    private Long tailLines;
    @JsonProperty("timestamps")
    private Boolean timestamps;
    @JsonProperty("version")
    private Long version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeploymentLogOptions() {
    }

    public DeploymentLogOptions(String apiVersion, String container, Boolean follow, String kind, Long limitBytes, Boolean nowait, Boolean previous, Long sinceSeconds, String sinceTime, Long tailLines, Boolean timestamps, Long version) {
        super();
        this.apiVersion = apiVersion;
        this.container = container;
        this.follow = follow;
        this.kind = kind;
        this.limitBytes = limitBytes;
        this.nowait = nowait;
        this.previous = previous;
        this.sinceSeconds = sinceSeconds;
        this.sinceTime = sinceTime;
        this.tailLines = tailLines;
        this.timestamps = timestamps;
        this.version = version;
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
     * The container for which to stream logs. Defaults to only container if there is one container in the pod.
     */
    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    /**
     * The container for which to stream logs. Defaults to only container if there is one container in the pod.
     */
    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * follow if true indicates that the build log should be streamed until the build terminates.
     */
    @JsonProperty("follow")
    public Boolean getFollow() {
        return follow;
    }

    /**
     * follow if true indicates that the build log should be streamed until the build terminates.
     */
    @JsonProperty("follow")
    public void setFollow(Boolean follow) {
        this.follow = follow;
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
     * If set, the number of bytes to read from the server before terminating the log output. This may not display a complete final line of logging, and may return slightly more or slightly less than the specified limit.
     */
    @JsonProperty("limitBytes")
    public Long getLimitBytes() {
        return limitBytes;
    }

    /**
     * If set, the number of bytes to read from the server before terminating the log output. This may not display a complete final line of logging, and may return slightly more or slightly less than the specified limit.
     */
    @JsonProperty("limitBytes")
    public void setLimitBytes(Long limitBytes) {
        this.limitBytes = limitBytes;
    }

    /**
     * nowait if true causes the call to return immediately even if the deployment is not available yet. Otherwise the server will wait until the deployment has started.
     */
    @JsonProperty("nowait")
    public Boolean getNowait() {
        return nowait;
    }

    /**
     * nowait if true causes the call to return immediately even if the deployment is not available yet. Otherwise the server will wait until the deployment has started.
     */
    @JsonProperty("nowait")
    public void setNowait(Boolean nowait) {
        this.nowait = nowait;
    }

    /**
     * Return previous deployment logs. Defaults to false.
     */
    @JsonProperty("previous")
    public Boolean getPrevious() {
        return previous;
    }

    /**
     * Return previous deployment logs. Defaults to false.
     */
    @JsonProperty("previous")
    public void setPrevious(Boolean previous) {
        this.previous = previous;
    }

    /**
     * A relative time in seconds before the current time from which to show logs. If this value precedes the time a pod was started, only logs since the pod start will be returned. If this value is in the future, no logs will be returned. Only one of sinceSeconds or sinceTime may be specified.
     */
    @JsonProperty("sinceSeconds")
    public Long getSinceSeconds() {
        return sinceSeconds;
    }

    /**
     * A relative time in seconds before the current time from which to show logs. If this value precedes the time a pod was started, only logs since the pod start will be returned. If this value is in the future, no logs will be returned. Only one of sinceSeconds or sinceTime may be specified.
     */
    @JsonProperty("sinceSeconds")
    public void setSinceSeconds(Long sinceSeconds) {
        this.sinceSeconds = sinceSeconds;
    }

    /**
     * DeploymentLogOptions is the REST options for a deployment log<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("sinceTime")
    public String getSinceTime() {
        return sinceTime;
    }

    /**
     * DeploymentLogOptions is the REST options for a deployment log<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("sinceTime")
    public void setSinceTime(String sinceTime) {
        this.sinceTime = sinceTime;
    }

    /**
     * If set, the number of lines from the end of the logs to show. If not specified, logs are shown from the creation of the container or sinceSeconds or sinceTime
     */
    @JsonProperty("tailLines")
    public Long getTailLines() {
        return tailLines;
    }

    /**
     * If set, the number of lines from the end of the logs to show. If not specified, logs are shown from the creation of the container or sinceSeconds or sinceTime
     */
    @JsonProperty("tailLines")
    public void setTailLines(Long tailLines) {
        this.tailLines = tailLines;
    }

    /**
     * If true, add an RFC3339 or RFC3339Nano timestamp at the beginning of every line of log output. Defaults to false.
     */
    @JsonProperty("timestamps")
    public Boolean getTimestamps() {
        return timestamps;
    }

    /**
     * If true, add an RFC3339 or RFC3339Nano timestamp at the beginning of every line of log output. Defaults to false.
     */
    @JsonProperty("timestamps")
    public void setTimestamps(Boolean timestamps) {
        this.timestamps = timestamps;
    }

    /**
     * version of the deployment for which to view logs.
     */
    @JsonProperty("version")
    public Long getVersion() {
        return version;
    }

    /**
     * version of the deployment for which to view logs.
     */
    @JsonProperty("version")
    public void setVersion(Long version) {
        this.version = version;
    }

    @JsonIgnore
    public DeploymentLogOptionsBuilder edit() {
        return new DeploymentLogOptionsBuilder(this);
    }

    @JsonIgnore
    public DeploymentLogOptionsBuilder toBuilder() {
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
        if (!(o instanceof DeploymentLogOptions)) {
            return false;
        }
        DeploymentLogOptions other = (DeploymentLogOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$container = this.getContainer();
        Object other$container = other.getContainer();
        if (this$container == null ? other$container != null : !this$container.equals(other$container)) {
            return false;
        }
        Object this$follow = this.getFollow();
        Object other$follow = other.getFollow();
        if (this$follow == null ? other$follow != null : !this$follow.equals(other$follow)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$limitBytes = this.getLimitBytes();
        Object other$limitBytes = other.getLimitBytes();
        if (this$limitBytes == null ? other$limitBytes != null : !this$limitBytes.equals(other$limitBytes)) {
            return false;
        }
        Object this$nowait = this.getNowait();
        Object other$nowait = other.getNowait();
        if (this$nowait == null ? other$nowait != null : !this$nowait.equals(other$nowait)) {
            return false;
        }
        Object this$previous = this.getPrevious();
        Object other$previous = other.getPrevious();
        if (this$previous == null ? other$previous != null : !this$previous.equals(other$previous)) {
            return false;
        }
        Object this$sinceSeconds = this.getSinceSeconds();
        Object other$sinceSeconds = other.getSinceSeconds();
        if (this$sinceSeconds == null ? other$sinceSeconds != null : !this$sinceSeconds.equals(other$sinceSeconds)) {
            return false;
        }
        Object this$sinceTime = this.getSinceTime();
        Object other$sinceTime = other.getSinceTime();
        if (this$sinceTime == null ? other$sinceTime != null : !this$sinceTime.equals(other$sinceTime)) {
            return false;
        }
        Object this$tailLines = this.getTailLines();
        Object other$tailLines = other.getTailLines();
        if (this$tailLines == null ? other$tailLines != null : !this$tailLines.equals(other$tailLines)) {
            return false;
        }
        Object this$timestamps = this.getTimestamps();
        Object other$timestamps = other.getTimestamps();
        if (this$timestamps == null ? other$timestamps != null : !this$timestamps.equals(other$timestamps)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof DeploymentLogOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $container = this.getContainer();
        result = result * prime + ($container == null ? 43 : $container.hashCode());
        Object $follow = this.getFollow();
        result = result * prime + ($follow == null ? 43 : $follow.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $limitBytes = this.getLimitBytes();
        result = result * prime + ($limitBytes == null ? 43 : $limitBytes.hashCode());
        Object $nowait = this.getNowait();
        result = result * prime + ($nowait == null ? 43 : $nowait.hashCode());
        Object $previous = this.getPrevious();
        result = result * prime + ($previous == null ? 43 : $previous.hashCode());
        Object $sinceSeconds = this.getSinceSeconds();
        result = result * prime + ($sinceSeconds == null ? 43 : $sinceSeconds.hashCode());
        Object $sinceTime = this.getSinceTime();
        result = result * prime + ($sinceTime == null ? 43 : $sinceTime.hashCode());
        Object $tailLines = this.getTailLines();
        result = result * prime + ($tailLines == null ? 43 : $tailLines.hashCode());
        Object $timestamps = this.getTimestamps();
        result = result * prime + ($timestamps == null ? 43 : $timestamps.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeploymentLogOptions(" + "apiVersion=" + this.getApiVersion() + ", container=" + this.getContainer() + ", follow=" + this.getFollow() + ", kind=" + this.getKind() + ", limitBytes=" + this.getLimitBytes() + ", nowait=" + this.getNowait() + ", previous=" + this.getPrevious() + ", sinceSeconds=" + this.getSinceSeconds() + ", sinceTime=" + this.getSinceTime() + ", tailLines=" + this.getTailLines() + ", timestamps=" + this.getTimestamps() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

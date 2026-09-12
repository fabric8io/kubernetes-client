
package io.fabric8.chaosmesh.v1alpha1;

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
 * GCPChaosSpec is the content of the specification for a GCPChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "deviceNames",
    "duration",
    "instance",
    "project",
    "remoteCluster",
    "secretName",
    "zone"
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
public class GCPChaosSpec implements Editable<GCPChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("deviceNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> deviceNames = new ArrayList<>();
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("instance")
    private String instance;
    @JsonProperty("project")
    private String project;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("secretName")
    private String secretName;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPChaosSpec() {
    }

    public GCPChaosSpec(String action, List<String> deviceNames, String duration, String instance, String project, String remoteCluster, String secretName, String zone) {
        super();
        this.action = action;
        this.deviceNames = deviceNames;
        this.duration = duration;
        this.instance = instance;
        this.project = project;
        this.remoteCluster = remoteCluster;
        this.secretName = secretName;
        this.zone = zone;
    }

    /**
     * Action defines the specific gcp chaos action. Supported action: node-stop / node-reset / disk-loss Default action: node-stop
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * Action defines the specific gcp chaos action. Supported action: node-stop / node-reset / disk-loss Default action: node-stop
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * The device name of disks to detach. Needed in disk-loss.
     */
    @JsonProperty("deviceNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDeviceNames() {
        return deviceNames;
    }

    /**
     * The device name of disks to detach. Needed in disk-loss.
     */
    @JsonProperty("deviceNames")
    public void setDeviceNames(List<String> deviceNames) {
        this.deviceNames = deviceNames;
    }

    /**
     * Duration represents the duration of the chaos action.
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration represents the duration of the chaos action.
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Instance defines the name of the instance
     */
    @JsonProperty("instance")
    public String getInstance() {
        return instance;
    }

    /**
     * Instance defines the name of the instance
     */
    @JsonProperty("instance")
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     * Project defines the ID of gcp project.
     */
    @JsonProperty("project")
    public String getProject() {
        return project;
    }

    /**
     * Project defines the ID of gcp project.
     */
    @JsonProperty("project")
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    /**
     * SecretName defines the name of kubernetes secret. It is used for GCP credentials.
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    /**
     * SecretName defines the name of kubernetes secret. It is used for GCP credentials.
     */
    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    /**
     * Zone defines the zone of gcp project.
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * Zone defines the zone of gcp project.
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public GCPChaosSpecBuilder edit() {
        return new GCPChaosSpecBuilder(this);
    }

    @JsonIgnore
    public GCPChaosSpecBuilder toBuilder() {
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
        if (!(o instanceof GCPChaosSpec)) {
            return false;
        }
        GCPChaosSpec other = (GCPChaosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$action = this.getAction();
        Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) {
            return false;
        }
        Object this$deviceNames = this.getDeviceNames();
        Object other$deviceNames = other.getDeviceNames();
        if (this$deviceNames == null ? other$deviceNames != null : !this$deviceNames.equals(other$deviceNames)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$instance = this.getInstance();
        Object other$instance = other.getInstance();
        if (this$instance == null ? other$instance != null : !this$instance.equals(other$instance)) {
            return false;
        }
        Object this$project = this.getProject();
        Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) {
            return false;
        }
        Object this$remoteCluster = this.getRemoteCluster();
        Object other$remoteCluster = other.getRemoteCluster();
        if (this$remoteCluster == null ? other$remoteCluster != null : !this$remoteCluster.equals(other$remoteCluster)) {
            return false;
        }
        Object this$secretName = this.getSecretName();
        Object other$secretName = other.getSecretName();
        if (this$secretName == null ? other$secretName != null : !this$secretName.equals(other$secretName)) {
            return false;
        }
        Object this$zone = this.getZone();
        Object other$zone = other.getZone();
        if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) {
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
        return other instanceof GCPChaosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $action = this.getAction();
        result = result * prime + ($action == null ? 43 : $action.hashCode());
        Object $deviceNames = this.getDeviceNames();
        result = result * prime + ($deviceNames == null ? 43 : $deviceNames.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $instance = this.getInstance();
        result = result * prime + ($instance == null ? 43 : $instance.hashCode());
        Object $project = this.getProject();
        result = result * prime + ($project == null ? 43 : $project.hashCode());
        Object $remoteCluster = this.getRemoteCluster();
        result = result * prime + ($remoteCluster == null ? 43 : $remoteCluster.hashCode());
        Object $secretName = this.getSecretName();
        result = result * prime + ($secretName == null ? 43 : $secretName.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GCPChaosSpec(" + "action=" + this.getAction() + ", deviceNames=" + this.getDeviceNames() + ", duration=" + this.getDuration() + ", instance=" + this.getInstance() + ", project=" + this.getProject() + ", remoteCluster=" + this.getRemoteCluster() + ", secretName=" + this.getSecretName() + ", zone=" + this.getZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

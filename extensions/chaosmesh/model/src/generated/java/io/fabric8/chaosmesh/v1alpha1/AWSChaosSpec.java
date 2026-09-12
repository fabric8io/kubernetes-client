
package io.fabric8.chaosmesh.v1alpha1;

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
 * AWSChaosSpec is the content of the specification for an AWSChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "awsRegion",
    "deviceName",
    "duration",
    "ec2Instance",
    "endpoint",
    "remoteCluster",
    "secretName",
    "volumeID"
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
public class AWSChaosSpec implements Editable<AWSChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("awsRegion")
    private String awsRegion;
    @JsonProperty("deviceName")
    private String deviceName;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("ec2Instance")
    private String ec2Instance;
    @JsonProperty("endpoint")
    private String endpoint;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("secretName")
    private String secretName;
    @JsonProperty("volumeID")
    private String volumeID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSChaosSpec() {
    }

    public AWSChaosSpec(String action, String awsRegion, String deviceName, String duration, String ec2Instance, String endpoint, String remoteCluster, String secretName, String volumeID) {
        super();
        this.action = action;
        this.awsRegion = awsRegion;
        this.deviceName = deviceName;
        this.duration = duration;
        this.ec2Instance = ec2Instance;
        this.endpoint = endpoint;
        this.remoteCluster = remoteCluster;
        this.secretName = secretName;
        this.volumeID = volumeID;
    }

    /**
     * Action defines the specific aws chaos action. Supported action: ec2-stop / ec2-restart / detach-volume Default action: ec2-stop
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * Action defines the specific aws chaos action. Supported action: ec2-stop / ec2-restart / detach-volume Default action: ec2-stop
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * AWSRegion defines the region of aws.
     */
    @JsonProperty("awsRegion")
    public String getAwsRegion() {
        return awsRegion;
    }

    /**
     * AWSRegion defines the region of aws.
     */
    @JsonProperty("awsRegion")
    public void setAwsRegion(String awsRegion) {
        this.awsRegion = awsRegion;
    }

    /**
     * DeviceName indicates the name of the device. Needed in detach-volume.
     */
    @JsonProperty("deviceName")
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * DeviceName indicates the name of the device. Needed in detach-volume.
     */
    @JsonProperty("deviceName")
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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
     * Ec2Instance indicates the ID of the ec2 instance.
     */
    @JsonProperty("ec2Instance")
    public String getEc2Instance() {
        return ec2Instance;
    }

    /**
     * Ec2Instance indicates the ID of the ec2 instance.
     */
    @JsonProperty("ec2Instance")
    public void setEc2Instance(String ec2Instance) {
        this.ec2Instance = ec2Instance;
    }

    /**
     * Endpoint indicates the endpoint of the aws server. Just used it in test now.
     */
    @JsonProperty("endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Endpoint indicates the endpoint of the aws server. Just used it in test now.
     */
    @JsonProperty("endpoint")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
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
     * SecretName defines the name of kubernetes secret.
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    /**
     * SecretName defines the name of kubernetes secret.
     */
    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    /**
     * EbsVolume indicates the ID of the EBS volume. Needed in detach-volume.
     */
    @JsonProperty("volumeID")
    public String getVolumeID() {
        return volumeID;
    }

    /**
     * EbsVolume indicates the ID of the EBS volume. Needed in detach-volume.
     */
    @JsonProperty("volumeID")
    public void setVolumeID(String volumeID) {
        this.volumeID = volumeID;
    }

    @JsonIgnore
    public AWSChaosSpecBuilder edit() {
        return new AWSChaosSpecBuilder(this);
    }

    @JsonIgnore
    public AWSChaosSpecBuilder toBuilder() {
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
        if (!(o instanceof AWSChaosSpec)) {
            return false;
        }
        AWSChaosSpec other = (AWSChaosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$action = this.getAction();
        Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) {
            return false;
        }
        Object this$awsRegion = this.getAwsRegion();
        Object other$awsRegion = other.getAwsRegion();
        if (this$awsRegion == null ? other$awsRegion != null : !this$awsRegion.equals(other$awsRegion)) {
            return false;
        }
        Object this$deviceName = this.getDeviceName();
        Object other$deviceName = other.getDeviceName();
        if (this$deviceName == null ? other$deviceName != null : !this$deviceName.equals(other$deviceName)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$ec2Instance = this.getEc2Instance();
        Object other$ec2Instance = other.getEc2Instance();
        if (this$ec2Instance == null ? other$ec2Instance != null : !this$ec2Instance.equals(other$ec2Instance)) {
            return false;
        }
        Object this$endpoint = this.getEndpoint();
        Object other$endpoint = other.getEndpoint();
        if (this$endpoint == null ? other$endpoint != null : !this$endpoint.equals(other$endpoint)) {
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
        Object this$volumeID = this.getVolumeID();
        Object other$volumeID = other.getVolumeID();
        if (this$volumeID == null ? other$volumeID != null : !this$volumeID.equals(other$volumeID)) {
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
        return other instanceof AWSChaosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $action = this.getAction();
        result = result * prime + ($action == null ? 43 : $action.hashCode());
        Object $awsRegion = this.getAwsRegion();
        result = result * prime + ($awsRegion == null ? 43 : $awsRegion.hashCode());
        Object $deviceName = this.getDeviceName();
        result = result * prime + ($deviceName == null ? 43 : $deviceName.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $ec2Instance = this.getEc2Instance();
        result = result * prime + ($ec2Instance == null ? 43 : $ec2Instance.hashCode());
        Object $endpoint = this.getEndpoint();
        result = result * prime + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $remoteCluster = this.getRemoteCluster();
        result = result * prime + ($remoteCluster == null ? 43 : $remoteCluster.hashCode());
        Object $secretName = this.getSecretName();
        result = result * prime + ($secretName == null ? 43 : $secretName.hashCode());
        Object $volumeID = this.getVolumeID();
        result = result * prime + ($volumeID == null ? 43 : $volumeID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSChaosSpec(" + "action=" + this.getAction() + ", awsRegion=" + this.getAwsRegion() + ", deviceName=" + this.getDeviceName() + ", duration=" + this.getDuration() + ", ec2Instance=" + this.getEc2Instance() + ", endpoint=" + this.getEndpoint() + ", remoteCluster=" + this.getRemoteCluster() + ", secretName=" + this.getSecretName() + ", volumeID=" + this.getVolumeID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

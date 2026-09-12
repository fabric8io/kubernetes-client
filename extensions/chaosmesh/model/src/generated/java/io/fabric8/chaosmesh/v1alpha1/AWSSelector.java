
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "awsRegion",
    "deviceName",
    "ec2Instance",
    "endpoint",
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
public class AWSSelector implements Editable<AWSSelectorBuilder>, KubernetesResource
{

    @JsonProperty("awsRegion")
    private String awsRegion;
    @JsonProperty("deviceName")
    private String deviceName;
    @JsonProperty("ec2Instance")
    private String ec2Instance;
    @JsonProperty("endpoint")
    private String endpoint;
    @JsonProperty("volumeID")
    private String volumeID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSSelector() {
    }

    public AWSSelector(String awsRegion, String deviceName, String ec2Instance, String endpoint, String volumeID) {
        super();
        this.awsRegion = awsRegion;
        this.deviceName = deviceName;
        this.ec2Instance = ec2Instance;
        this.endpoint = endpoint;
        this.volumeID = volumeID;
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
    public AWSSelectorBuilder edit() {
        return new AWSSelectorBuilder(this);
    }

    @JsonIgnore
    public AWSSelectorBuilder toBuilder() {
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
        if (!(o instanceof AWSSelector)) {
            return false;
        }
        AWSSelector other = (AWSSelector) o;
        if (!other.canEqual(this)) {
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
        return other instanceof AWSSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $awsRegion = this.getAwsRegion();
        result = result * prime + ($awsRegion == null ? 43 : $awsRegion.hashCode());
        Object $deviceName = this.getDeviceName();
        result = result * prime + ($deviceName == null ? 43 : $deviceName.hashCode());
        Object $ec2Instance = this.getEc2Instance();
        result = result * prime + ($ec2Instance == null ? 43 : $ec2Instance.hashCode());
        Object $endpoint = this.getEndpoint();
        result = result * prime + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $volumeID = this.getVolumeID();
        result = result * prime + ($volumeID == null ? 43 : $volumeID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSSelector(" + "awsRegion=" + this.getAwsRegion() + ", deviceName=" + this.getDeviceName() + ", ec2Instance=" + this.getEc2Instance() + ", endpoint=" + this.getEndpoint() + ", volumeID=" + this.getVolumeID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

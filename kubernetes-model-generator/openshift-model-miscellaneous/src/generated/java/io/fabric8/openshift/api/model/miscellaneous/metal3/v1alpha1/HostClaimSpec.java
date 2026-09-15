
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * HostClaimSpec defines the desired state of HostClaim.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "consumerRef",
    "customDeploy",
    "failureDomain",
    "hostSelector",
    "image",
    "metaData",
    "networkData",
    "poweredOn",
    "userData"
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
public class HostClaimSpec implements Editable<HostClaimSpecBuilder>, KubernetesResource
{

    @JsonProperty("consumerRef")
    private ObjectReference consumerRef;
    @JsonProperty("customDeploy")
    private CustomDeploy customDeploy;
    @JsonProperty("failureDomain")
    private String failureDomain;
    @JsonProperty("hostSelector")
    private HostSelector hostSelector;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("metaData")
    private SecretReference metaData;
    @JsonProperty("networkData")
    private SecretReference networkData;
    @JsonProperty("poweredOn")
    private Boolean poweredOn;
    @JsonProperty("userData")
    private SecretReference userData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostClaimSpec() {
    }

    public HostClaimSpec(ObjectReference consumerRef, CustomDeploy customDeploy, String failureDomain, HostSelector hostSelector, Image image, SecretReference metaData, SecretReference networkData, Boolean poweredOn, SecretReference userData) {
        super();
        this.consumerRef = consumerRef;
        this.customDeploy = customDeploy;
        this.failureDomain = failureDomain;
        this.hostSelector = hostSelector;
        this.image = image;
        this.metaData = metaData;
        this.networkData = networkData;
        this.poweredOn = poweredOn;
        this.userData = userData;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("consumerRef")
    public ObjectReference getConsumerRef() {
        return consumerRef;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("consumerRef")
    public void setConsumerRef(ObjectReference consumerRef) {
        this.consumerRef = consumerRef;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("customDeploy")
    public CustomDeploy getCustomDeploy() {
        return customDeploy;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("customDeploy")
    public void setCustomDeploy(CustomDeploy customDeploy) {
        this.customDeploy = customDeploy;
    }

    /**
     * FailureDomain is the failure domain unique identifier this HostClaim should be attached to, as defined in Cluster API. It is implemented when set as a preference for binding BareMetalHost having the label infrastructure.cluster.x-k8s.io/failure-domain set to the value of the field.
     */
    @JsonProperty("failureDomain")
    public String getFailureDomain() {
        return failureDomain;
    }

    /**
     * FailureDomain is the failure domain unique identifier this HostClaim should be attached to, as defined in Cluster API. It is implemented when set as a preference for binding BareMetalHost having the label infrastructure.cluster.x-k8s.io/failure-domain set to the value of the field.
     */
    @JsonProperty("failureDomain")
    public void setFailureDomain(String failureDomain) {
        this.failureDomain = failureDomain;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("hostSelector")
    public HostSelector getHostSelector() {
        return hostSelector;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("hostSelector")
    public void setHostSelector(HostSelector hostSelector) {
        this.hostSelector = hostSelector;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("metaData")
    public SecretReference getMetaData() {
        return metaData;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("metaData")
    public void setMetaData(SecretReference metaData) {
        this.metaData = metaData;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("networkData")
    public SecretReference getNetworkData() {
        return networkData;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("networkData")
    public void setNetworkData(SecretReference networkData) {
        this.networkData = networkData;
    }

    /**
     * Should the compute resource be powered on? Changing this value will trigger a change in power state of the targeted host.
     */
    @JsonProperty("poweredOn")
    public Boolean getPoweredOn() {
        return poweredOn;
    }

    /**
     * Should the compute resource be powered on? Changing this value will trigger a change in power state of the targeted host.
     */
    @JsonProperty("poweredOn")
    public void setPoweredOn(Boolean poweredOn) {
        this.poweredOn = poweredOn;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("userData")
    public SecretReference getUserData() {
        return userData;
    }

    /**
     * HostClaimSpec defines the desired state of HostClaim.
     */
    @JsonProperty("userData")
    public void setUserData(SecretReference userData) {
        this.userData = userData;
    }

    @JsonIgnore
    public HostClaimSpecBuilder edit() {
        return new HostClaimSpecBuilder(this);
    }

    @JsonIgnore
    public HostClaimSpecBuilder toBuilder() {
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
        if (!(o instanceof HostClaimSpec)) {
            return false;
        }
        HostClaimSpec other = (HostClaimSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$consumerRef = this.getConsumerRef();
        Object other$consumerRef = other.getConsumerRef();
        if (this$consumerRef == null ? other$consumerRef != null : !this$consumerRef.equals(other$consumerRef)) {
            return false;
        }
        Object this$customDeploy = this.getCustomDeploy();
        Object other$customDeploy = other.getCustomDeploy();
        if (this$customDeploy == null ? other$customDeploy != null : !this$customDeploy.equals(other$customDeploy)) {
            return false;
        }
        Object this$failureDomain = this.getFailureDomain();
        Object other$failureDomain = other.getFailureDomain();
        if (this$failureDomain == null ? other$failureDomain != null : !this$failureDomain.equals(other$failureDomain)) {
            return false;
        }
        Object this$hostSelector = this.getHostSelector();
        Object other$hostSelector = other.getHostSelector();
        if (this$hostSelector == null ? other$hostSelector != null : !this$hostSelector.equals(other$hostSelector)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$metaData = this.getMetaData();
        Object other$metaData = other.getMetaData();
        if (this$metaData == null ? other$metaData != null : !this$metaData.equals(other$metaData)) {
            return false;
        }
        Object this$networkData = this.getNetworkData();
        Object other$networkData = other.getNetworkData();
        if (this$networkData == null ? other$networkData != null : !this$networkData.equals(other$networkData)) {
            return false;
        }
        Object this$poweredOn = this.getPoweredOn();
        Object other$poweredOn = other.getPoweredOn();
        if (this$poweredOn == null ? other$poweredOn != null : !this$poweredOn.equals(other$poweredOn)) {
            return false;
        }
        Object this$userData = this.getUserData();
        Object other$userData = other.getUserData();
        if (this$userData == null ? other$userData != null : !this$userData.equals(other$userData)) {
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
        return other instanceof HostClaimSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $consumerRef = this.getConsumerRef();
        result = result * prime + ($consumerRef == null ? 43 : $consumerRef.hashCode());
        Object $customDeploy = this.getCustomDeploy();
        result = result * prime + ($customDeploy == null ? 43 : $customDeploy.hashCode());
        Object $failureDomain = this.getFailureDomain();
        result = result * prime + ($failureDomain == null ? 43 : $failureDomain.hashCode());
        Object $hostSelector = this.getHostSelector();
        result = result * prime + ($hostSelector == null ? 43 : $hostSelector.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $metaData = this.getMetaData();
        result = result * prime + ($metaData == null ? 43 : $metaData.hashCode());
        Object $networkData = this.getNetworkData();
        result = result * prime + ($networkData == null ? 43 : $networkData.hashCode());
        Object $poweredOn = this.getPoweredOn();
        result = result * prime + ($poweredOn == null ? 43 : $poweredOn.hashCode());
        Object $userData = this.getUserData();
        result = result * prime + ($userData == null ? 43 : $userData.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HostClaimSpec(" + "consumerRef=" + this.getConsumerRef() + ", customDeploy=" + this.getCustomDeploy() + ", failureDomain=" + this.getFailureDomain() + ", hostSelector=" + this.getHostSelector() + ", image=" + this.getImage() + ", metaData=" + this.getMetaData() + ", networkData=" + this.getNetworkData() + ", poweredOn=" + this.getPoweredOn() + ", userData=" + this.getUserData() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

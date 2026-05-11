
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}

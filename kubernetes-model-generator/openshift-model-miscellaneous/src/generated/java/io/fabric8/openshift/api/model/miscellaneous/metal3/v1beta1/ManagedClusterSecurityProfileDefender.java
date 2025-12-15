
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ManagedClusterSecurityProfileDefender defines Microsoft Defender settings for the security profile. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/defender-for-cloud/defender-for-containers-enable
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "logAnalyticsWorkspaceResourceID",
    "securityMonitoring"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ManagedClusterSecurityProfileDefender implements Editable<ManagedClusterSecurityProfileDefenderBuilder>, KubernetesResource
{

    @JsonProperty("logAnalyticsWorkspaceResourceID")
    private String logAnalyticsWorkspaceResourceID;
    @JsonProperty("securityMonitoring")
    private ManagedClusterSecurityProfileDefenderSecurityMonitoring securityMonitoring;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManagedClusterSecurityProfileDefender() {
    }

    public ManagedClusterSecurityProfileDefender(String logAnalyticsWorkspaceResourceID, ManagedClusterSecurityProfileDefenderSecurityMonitoring securityMonitoring) {
        super();
        this.logAnalyticsWorkspaceResourceID = logAnalyticsWorkspaceResourceID;
        this.securityMonitoring = securityMonitoring;
    }

    /**
     * LogAnalyticsWorkspaceResourceID is the ID of the Log Analytics workspace that has to be associated with Microsoft Defender. When Microsoft Defender is enabled, this field is required and must be a valid workspace resource ID.
     */
    @JsonProperty("logAnalyticsWorkspaceResourceID")
    public String getLogAnalyticsWorkspaceResourceID() {
        return logAnalyticsWorkspaceResourceID;
    }

    /**
     * LogAnalyticsWorkspaceResourceID is the ID of the Log Analytics workspace that has to be associated with Microsoft Defender. When Microsoft Defender is enabled, this field is required and must be a valid workspace resource ID.
     */
    @JsonProperty("logAnalyticsWorkspaceResourceID")
    public void setLogAnalyticsWorkspaceResourceID(String logAnalyticsWorkspaceResourceID) {
        this.logAnalyticsWorkspaceResourceID = logAnalyticsWorkspaceResourceID;
    }

    /**
     * ManagedClusterSecurityProfileDefender defines Microsoft Defender settings for the security profile. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/defender-for-cloud/defender-for-containers-enable
     */
    @JsonProperty("securityMonitoring")
    public ManagedClusterSecurityProfileDefenderSecurityMonitoring getSecurityMonitoring() {
        return securityMonitoring;
    }

    /**
     * ManagedClusterSecurityProfileDefender defines Microsoft Defender settings for the security profile. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/defender-for-cloud/defender-for-containers-enable
     */
    @JsonProperty("securityMonitoring")
    public void setSecurityMonitoring(ManagedClusterSecurityProfileDefenderSecurityMonitoring securityMonitoring) {
        this.securityMonitoring = securityMonitoring;
    }

    @JsonIgnore
    public ManagedClusterSecurityProfileDefenderBuilder edit() {
        return new ManagedClusterSecurityProfileDefenderBuilder(this);
    }

    @JsonIgnore
    public ManagedClusterSecurityProfileDefenderBuilder toBuilder() {
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

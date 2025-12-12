
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * AKSExtension represents the configuration for an AKS cluster extension. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/en-us/azure/aks/cluster-extensions
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aksAssignedIdentityType",
    "autoUpgradeMinorVersion",
    "configurationSettings",
    "extensionType",
    "identity",
    "name",
    "plan",
    "releaseTrain",
    "scope",
    "version"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class AKSExtension implements Editable<AKSExtensionBuilder>, KubernetesResource
{

    @JsonProperty("aksAssignedIdentityType")
    private String aksAssignedIdentityType;
    @JsonProperty("autoUpgradeMinorVersion")
    private Boolean autoUpgradeMinorVersion;
    @JsonProperty("configurationSettings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> configurationSettings = new LinkedHashMap<>();
    @JsonProperty("extensionType")
    private String extensionType;
    @JsonProperty("identity")
    private String identity;
    @JsonProperty("name")
    private String name;
    @JsonProperty("plan")
    private ExtensionPlan plan;
    @JsonProperty("releaseTrain")
    private String releaseTrain;
    @JsonProperty("scope")
    private ExtensionScope scope;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AKSExtension() {
    }

    public AKSExtension(String aksAssignedIdentityType, Boolean autoUpgradeMinorVersion, Map<String, String> configurationSettings, String extensionType, String identity, String name, ExtensionPlan plan, String releaseTrain, ExtensionScope scope, String version) {
        super();
        this.aksAssignedIdentityType = aksAssignedIdentityType;
        this.autoUpgradeMinorVersion = autoUpgradeMinorVersion;
        this.configurationSettings = configurationSettings;
        this.extensionType = extensionType;
        this.identity = identity;
        this.name = name;
        this.plan = plan;
        this.releaseTrain = releaseTrain;
        this.scope = scope;
        this.version = version;
    }

    /**
     * AKSAssignedIdentityType is the type of the AKS assigned identity.
     */
    @JsonProperty("aksAssignedIdentityType")
    public String getAksAssignedIdentityType() {
        return aksAssignedIdentityType;
    }

    /**
     * AKSAssignedIdentityType is the type of the AKS assigned identity.
     */
    @JsonProperty("aksAssignedIdentityType")
    public void setAksAssignedIdentityType(String aksAssignedIdentityType) {
        this.aksAssignedIdentityType = aksAssignedIdentityType;
    }

    /**
     * AutoUpgradeMinorVersion is a flag to note if this extension participates in auto upgrade of minor version, or not.
     */
    @JsonProperty("autoUpgradeMinorVersion")
    public Boolean getAutoUpgradeMinorVersion() {
        return autoUpgradeMinorVersion;
    }

    /**
     * AutoUpgradeMinorVersion is a flag to note if this extension participates in auto upgrade of minor version, or not.
     */
    @JsonProperty("autoUpgradeMinorVersion")
    public void setAutoUpgradeMinorVersion(Boolean autoUpgradeMinorVersion) {
        this.autoUpgradeMinorVersion = autoUpgradeMinorVersion;
    }

    /**
     * ConfigurationSettings are the name-value pairs for configuring this extension.
     */
    @JsonProperty("configurationSettings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getConfigurationSettings() {
        return configurationSettings;
    }

    /**
     * ConfigurationSettings are the name-value pairs for configuring this extension.
     */
    @JsonProperty("configurationSettings")
    public void setConfigurationSettings(Map<String, String> configurationSettings) {
        this.configurationSettings = configurationSettings;
    }

    /**
     * ExtensionType is the type of the Extension of which this resource is an instance. It must be one of the Extension Types registered with Microsoft.KubernetesConfiguration by the Extension publisher.
     */
    @JsonProperty("extensionType")
    public String getExtensionType() {
        return extensionType;
    }

    /**
     * ExtensionType is the type of the Extension of which this resource is an instance. It must be one of the Extension Types registered with Microsoft.KubernetesConfiguration by the Extension publisher.
     */
    @JsonProperty("extensionType")
    public void setExtensionType(String extensionType) {
        this.extensionType = extensionType;
    }

    /**
     * Identity is the identity type of the Extension resource in an AKS cluster.
     */
    @JsonProperty("identity")
    public String getIdentity() {
        return identity;
    }

    /**
     * Identity is the identity type of the Extension resource in an AKS cluster.
     */
    @JsonProperty("identity")
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * Name is the name of the extension.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the extension.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * AKSExtension represents the configuration for an AKS cluster extension. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/en-us/azure/aks/cluster-extensions
     */
    @JsonProperty("plan")
    public ExtensionPlan getPlan() {
        return plan;
    }

    /**
     * AKSExtension represents the configuration for an AKS cluster extension. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/en-us/azure/aks/cluster-extensions
     */
    @JsonProperty("plan")
    public void setPlan(ExtensionPlan plan) {
        this.plan = plan;
    }

    /**
     * ReleaseTrain is the release train this extension participates in for auto-upgrade (e.g. Stable, Preview, etc.) This is only used if autoUpgradeMinorVersion is ‘true’.
     */
    @JsonProperty("releaseTrain")
    public String getReleaseTrain() {
        return releaseTrain;
    }

    /**
     * ReleaseTrain is the release train this extension participates in for auto-upgrade (e.g. Stable, Preview, etc.) This is only used if autoUpgradeMinorVersion is ‘true’.
     */
    @JsonProperty("releaseTrain")
    public void setReleaseTrain(String releaseTrain) {
        this.releaseTrain = releaseTrain;
    }

    /**
     * AKSExtension represents the configuration for an AKS cluster extension. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/en-us/azure/aks/cluster-extensions
     */
    @JsonProperty("scope")
    public ExtensionScope getScope() {
        return scope;
    }

    /**
     * AKSExtension represents the configuration for an AKS cluster extension. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/en-us/azure/aks/cluster-extensions
     */
    @JsonProperty("scope")
    public void setScope(ExtensionScope scope) {
        this.scope = scope;
    }

    /**
     * Version is the version of the extension.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version is the version of the extension.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public AKSExtensionBuilder edit() {
        return new AKSExtensionBuilder(this);
    }

    @JsonIgnore
    public AKSExtensionBuilder toBuilder() {
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

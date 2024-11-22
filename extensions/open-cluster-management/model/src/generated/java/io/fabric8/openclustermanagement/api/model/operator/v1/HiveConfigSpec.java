
package io.fabric8.openclustermanagement.api.model.operator.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalCertificateAuthorities",
    "backup",
    "externalDNS",
    "failedProvisionConfig",
    "globalPullSecret",
    "maintenanceMode"
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
public class HiveConfigSpec implements Editable<HiveConfigSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalCertificateAuthorities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> additionalCertificateAuthorities = new ArrayList<>();
    @JsonProperty("backup")
    private BackupConfig backup;
    @JsonProperty("externalDNS")
    private ExternalDNSConfig externalDNS;
    @JsonProperty("failedProvisionConfig")
    private FailedProvisionConfig failedProvisionConfig;
    @JsonProperty("globalPullSecret")
    private LocalObjectReference globalPullSecret;
    @JsonProperty("maintenanceMode")
    private Boolean maintenanceMode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HiveConfigSpec() {
    }

    public HiveConfigSpec(List<LocalObjectReference> additionalCertificateAuthorities, BackupConfig backup, ExternalDNSConfig externalDNS, FailedProvisionConfig failedProvisionConfig, LocalObjectReference globalPullSecret, Boolean maintenanceMode) {
        super();
        this.additionalCertificateAuthorities = additionalCertificateAuthorities;
        this.backup = backup;
        this.externalDNS = externalDNS;
        this.failedProvisionConfig = failedProvisionConfig;
        this.globalPullSecret = globalPullSecret;
        this.maintenanceMode = maintenanceMode;
    }

    @JsonProperty("additionalCertificateAuthorities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getAdditionalCertificateAuthorities() {
        return additionalCertificateAuthorities;
    }

    @JsonProperty("additionalCertificateAuthorities")
    public void setAdditionalCertificateAuthorities(List<LocalObjectReference> additionalCertificateAuthorities) {
        this.additionalCertificateAuthorities = additionalCertificateAuthorities;
    }

    @JsonProperty("backup")
    public BackupConfig getBackup() {
        return backup;
    }

    @JsonProperty("backup")
    public void setBackup(BackupConfig backup) {
        this.backup = backup;
    }

    @JsonProperty("externalDNS")
    public ExternalDNSConfig getExternalDNS() {
        return externalDNS;
    }

    @JsonProperty("externalDNS")
    public void setExternalDNS(ExternalDNSConfig externalDNS) {
        this.externalDNS = externalDNS;
    }

    @JsonProperty("failedProvisionConfig")
    public FailedProvisionConfig getFailedProvisionConfig() {
        return failedProvisionConfig;
    }

    @JsonProperty("failedProvisionConfig")
    public void setFailedProvisionConfig(FailedProvisionConfig failedProvisionConfig) {
        this.failedProvisionConfig = failedProvisionConfig;
    }

    @JsonProperty("globalPullSecret")
    public LocalObjectReference getGlobalPullSecret() {
        return globalPullSecret;
    }

    @JsonProperty("globalPullSecret")
    public void setGlobalPullSecret(LocalObjectReference globalPullSecret) {
        this.globalPullSecret = globalPullSecret;
    }

    @JsonProperty("maintenanceMode")
    public Boolean getMaintenanceMode() {
        return maintenanceMode;
    }

    @JsonProperty("maintenanceMode")
    public void setMaintenanceMode(Boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
    }

    @JsonIgnore
    public HiveConfigSpecBuilder edit() {
        return new HiveConfigSpecBuilder(this);
    }

    @JsonIgnore
    public HiveConfigSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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

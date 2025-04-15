
package io.fabric8.openshift.api.model.hive.v1;

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
 * BackupConfig contains settings for the Velero backup integration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minBackupPeriodSeconds",
    "velero"
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
public class BackupConfig implements Editable<BackupConfigBuilder>, KubernetesResource
{

    @JsonProperty("minBackupPeriodSeconds")
    private Integer minBackupPeriodSeconds;
    @JsonProperty("velero")
    private VeleroBackupConfig velero;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BackupConfig() {
    }

    public BackupConfig(Integer minBackupPeriodSeconds, VeleroBackupConfig velero) {
        super();
        this.minBackupPeriodSeconds = minBackupPeriodSeconds;
        this.velero = velero;
    }

    /**
     * MinBackupPeriodSeconds specifies that a minimum of MinBackupPeriodSeconds will occur in between each backup. This is used to rate limit backups. This potentially batches together multiple changes into 1 backup. No backups will be lost as changes that happen during this interval are queued up and will result in a backup happening once the interval has been completed.
     */
    @JsonProperty("minBackupPeriodSeconds")
    public Integer getMinBackupPeriodSeconds() {
        return minBackupPeriodSeconds;
    }

    /**
     * MinBackupPeriodSeconds specifies that a minimum of MinBackupPeriodSeconds will occur in between each backup. This is used to rate limit backups. This potentially batches together multiple changes into 1 backup. No backups will be lost as changes that happen during this interval are queued up and will result in a backup happening once the interval has been completed.
     */
    @JsonProperty("minBackupPeriodSeconds")
    public void setMinBackupPeriodSeconds(Integer minBackupPeriodSeconds) {
        this.minBackupPeriodSeconds = minBackupPeriodSeconds;
    }

    /**
     * BackupConfig contains settings for the Velero backup integration.
     */
    @JsonProperty("velero")
    public VeleroBackupConfig getVelero() {
        return velero;
    }

    /**
     * BackupConfig contains settings for the Velero backup integration.
     */
    @JsonProperty("velero")
    public void setVelero(VeleroBackupConfig velero) {
        this.velero = velero;
    }

    @JsonIgnore
    public BackupConfigBuilder edit() {
        return new BackupConfigBuilder(this);
    }

    @JsonIgnore
    public BackupConfigBuilder toBuilder() {
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

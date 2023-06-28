
package io.fabric8.openshift.api.model.hive.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "lastBackupChecksum",
    "lastBackupRef",
    "lastBackupTime"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class CheckpointSpec implements KubernetesResource
{

    @JsonProperty("lastBackupChecksum")
    private java.lang.String lastBackupChecksum;
    @JsonProperty("lastBackupRef")
    private BackupReference lastBackupRef;
    @JsonProperty("lastBackupTime")
    private String lastBackupTime;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CheckpointSpec() {
    }

    public CheckpointSpec(java.lang.String lastBackupChecksum, BackupReference lastBackupRef, String lastBackupTime) {
        super();
        this.lastBackupChecksum = lastBackupChecksum;
        this.lastBackupRef = lastBackupRef;
        this.lastBackupTime = lastBackupTime;
    }

    @JsonProperty("lastBackupChecksum")
    public java.lang.String getLastBackupChecksum() {
        return lastBackupChecksum;
    }

    @JsonProperty("lastBackupChecksum")
    public void setLastBackupChecksum(java.lang.String lastBackupChecksum) {
        this.lastBackupChecksum = lastBackupChecksum;
    }

    @JsonProperty("lastBackupRef")
    public BackupReference getLastBackupRef() {
        return lastBackupRef;
    }

    @JsonProperty("lastBackupRef")
    public void setLastBackupRef(BackupReference lastBackupRef) {
        this.lastBackupRef = lastBackupRef;
    }

    @JsonProperty("lastBackupTime")
    public String getLastBackupTime() {
        return lastBackupTime;
    }

    @JsonProperty("lastBackupTime")
    public void setLastBackupTime(String lastBackupTime) {
        this.lastBackupTime = lastBackupTime;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

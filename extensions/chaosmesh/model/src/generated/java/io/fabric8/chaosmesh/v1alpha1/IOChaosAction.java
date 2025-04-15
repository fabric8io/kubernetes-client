
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * IOChaosAction defines a possible action of IOChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "atime",
    "blocks",
    "ctime",
    "faults",
    "gid",
    "ino",
    "latency",
    "methods",
    "mistake",
    "mtime",
    "nlink",
    "path",
    "percent",
    "perm",
    "rdev",
    "size",
    "source",
    "type",
    "uid"
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
public class IOChaosAction implements Editable<IOChaosActionBuilder>, KubernetesResource
{

    @JsonProperty("atime")
    private Timespec atime;
    @JsonProperty("blocks")
    private Long blocks;
    @JsonProperty("ctime")
    private Timespec ctime;
    @JsonProperty("faults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IoFault> faults = new ArrayList<>();
    @JsonProperty("gid")
    private Long gid;
    @JsonProperty("ino")
    private Long ino;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("latency")
    private String latency;
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> methods = new ArrayList<>();
    @JsonProperty("mistake")
    private MistakeSpec mistake;
    @JsonProperty("mtime")
    private Timespec mtime;
    @JsonProperty("nlink")
    private Long nlink;
    @JsonProperty("path")
    private String path;
    @JsonProperty("percent")
    private Integer percent;
    @JsonProperty("perm")
    private Integer perm;
    @JsonProperty("rdev")
    private Long rdev;
    @JsonProperty("size")
    private Long size;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uid")
    private Long uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IOChaosAction() {
    }

    public IOChaosAction(Timespec atime, Long blocks, Timespec ctime, List<IoFault> faults, Long gid, Long ino, String kind, String latency, List<String> methods, MistakeSpec mistake, Timespec mtime, Long nlink, String path, Integer percent, Integer perm, Long rdev, Long size, String source, String type, Long uid) {
        super();
        this.atime = atime;
        this.blocks = blocks;
        this.ctime = ctime;
        this.faults = faults;
        this.gid = gid;
        this.ino = ino;
        this.kind = kind;
        this.latency = latency;
        this.methods = methods;
        this.mistake = mistake;
        this.mtime = mtime;
        this.nlink = nlink;
        this.path = path;
        this.percent = percent;
        this.perm = perm;
        this.rdev = rdev;
        this.size = size;
        this.source = source;
        this.type = type;
        this.uid = uid;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("atime")
    public Timespec getAtime() {
        return atime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("atime")
    public void setAtime(Timespec atime) {
        this.atime = atime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("blocks")
    public Long getBlocks() {
        return blocks;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("blocks")
    public void setBlocks(Long blocks) {
        this.blocks = blocks;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("ctime")
    public Timespec getCtime() {
        return ctime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("ctime")
    public void setCtime(Timespec ctime) {
        this.ctime = ctime;
    }

    /**
     * Faults represents the fault to inject
     */
    @JsonProperty("faults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IoFault> getFaults() {
        return faults;
    }

    /**
     * Faults represents the fault to inject
     */
    @JsonProperty("faults")
    public void setFaults(List<IoFault> faults) {
        this.faults = faults;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("gid")
    public Long getGid() {
        return gid;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("gid")
    public void setGid(Long gid) {
        this.gid = gid;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("ino")
    public Long getIno() {
        return ino;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("ino")
    public void setIno(Long ino) {
        this.ino = ino;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Latency represents the latency to inject
     */
    @JsonProperty("latency")
    public String getLatency() {
        return latency;
    }

    /**
     * Latency represents the latency to inject
     */
    @JsonProperty("latency")
    public void setLatency(String latency) {
        this.latency = latency;
    }

    /**
     * Methods represents the method that the action will inject in
     */
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMethods() {
        return methods;
    }

    /**
     * Methods represents the method that the action will inject in
     */
    @JsonProperty("methods")
    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("mistake")
    public MistakeSpec getMistake() {
        return mistake;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("mistake")
    public void setMistake(MistakeSpec mistake) {
        this.mistake = mistake;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("mtime")
    public Timespec getMtime() {
        return mtime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("mtime")
    public void setMtime(Timespec mtime) {
        this.mtime = mtime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("nlink")
    public Long getNlink() {
        return nlink;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("nlink")
    public void setNlink(Long nlink) {
        this.nlink = nlink;
    }

    /**
     * Path represents a glob of injecting path
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path represents a glob of injecting path
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Percent represents the percent probability of injecting this action
     */
    @JsonProperty("percent")
    public Integer getPercent() {
        return percent;
    }

    /**
     * Percent represents the percent probability of injecting this action
     */
    @JsonProperty("percent")
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("perm")
    public Integer getPerm() {
        return perm;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("perm")
    public void setPerm(Integer perm) {
        this.perm = perm;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("rdev")
    public Long getRdev() {
        return rdev;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("rdev")
    public void setRdev(Long rdev) {
        this.rdev = rdev;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("size")
    public Long getSize() {
        return size;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("size")
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * Source represents the source of current rules
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * Source represents the source of current rules
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("uid")
    public Long getUid() {
        return uid;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("uid")
    public void setUid(Long uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public IOChaosActionBuilder edit() {
        return new IOChaosActionBuilder(this);
    }

    @JsonIgnore
    public IOChaosActionBuilder toBuilder() {
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

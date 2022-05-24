
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class IoChaosAction implements KubernetesResource
{

    @JsonProperty("atime")
    private Timespec atime;
    @JsonProperty("blocks")
    private Long blocks;
    @JsonProperty("ctime")
    private Timespec ctime;
    @JsonProperty("faults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IoFault> faults = new ArrayList<IoFault>();
    @JsonProperty("gid")
    private Long gid;
    @JsonProperty("ino")
    private Long ino;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("latency")
    private java.lang.String latency;
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> methods = new ArrayList<java.lang.String>();
    @JsonProperty("mistake")
    private MistakeSpec mistake;
    @JsonProperty("mtime")
    private Timespec mtime;
    @JsonProperty("nlink")
    private Long nlink;
    @JsonProperty("path")
    private java.lang.String path;
    @JsonProperty("percent")
    private java.lang.Integer percent;
    @JsonProperty("perm")
    private Integer perm;
    @JsonProperty("rdev")
    private Long rdev;
    @JsonProperty("size")
    private Long size;
    @JsonProperty("source")
    private java.lang.String source;
    @JsonProperty("type")
    private java.lang.String type;
    @JsonProperty("uid")
    private Long uid;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IoChaosAction() {
    }

    /**
     * 
     * @param mistake
     * @param atime
     * @param gid
     * @param perm
     * @param blocks
     * @param kind
     * @param methods
     * @param latency
     * @param nlink
     * @param ino
     * @param source
     * @param mtime
     * @param type
     * @param faults
     * @param percent
     * @param path
     * @param uid
     * @param size
     * @param rdev
     * @param ctime
     */
    public IoChaosAction(Timespec atime, Long blocks, Timespec ctime, List<IoFault> faults, Long gid, Long ino, String kind, java.lang.String latency, List<java.lang.String> methods, MistakeSpec mistake, Timespec mtime, Long nlink, java.lang.String path, java.lang.Integer percent, Integer perm, Long rdev, Long size, java.lang.String source, java.lang.String type, Long uid) {
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

    @JsonProperty("atime")
    public Timespec getAtime() {
        return atime;
    }

    @JsonProperty("atime")
    public void setAtime(Timespec atime) {
        this.atime = atime;
    }

    @JsonProperty("blocks")
    public Long getBlocks() {
        return blocks;
    }

    @JsonProperty("blocks")
    public void setBlocks(Long blocks) {
        this.blocks = blocks;
    }

    @JsonProperty("ctime")
    public Timespec getCtime() {
        return ctime;
    }

    @JsonProperty("ctime")
    public void setCtime(Timespec ctime) {
        this.ctime = ctime;
    }

    @JsonProperty("faults")
    public List<IoFault> getFaults() {
        return faults;
    }

    @JsonProperty("faults")
    public void setFaults(List<IoFault> faults) {
        this.faults = faults;
    }

    @JsonProperty("gid")
    public Long getGid() {
        return gid;
    }

    @JsonProperty("gid")
    public void setGid(Long gid) {
        this.gid = gid;
    }

    @JsonProperty("ino")
    public Long getIno() {
        return ino;
    }

    @JsonProperty("ino")
    public void setIno(Long ino) {
        this.ino = ino;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("latency")
    public java.lang.String getLatency() {
        return latency;
    }

    @JsonProperty("latency")
    public void setLatency(java.lang.String latency) {
        this.latency = latency;
    }

    @JsonProperty("methods")
    public List<java.lang.String> getMethods() {
        return methods;
    }

    @JsonProperty("methods")
    public void setMethods(List<java.lang.String> methods) {
        this.methods = methods;
    }

    @JsonProperty("mistake")
    public MistakeSpec getMistake() {
        return mistake;
    }

    @JsonProperty("mistake")
    public void setMistake(MistakeSpec mistake) {
        this.mistake = mistake;
    }

    @JsonProperty("mtime")
    public Timespec getMtime() {
        return mtime;
    }

    @JsonProperty("mtime")
    public void setMtime(Timespec mtime) {
        this.mtime = mtime;
    }

    @JsonProperty("nlink")
    public Long getNlink() {
        return nlink;
    }

    @JsonProperty("nlink")
    public void setNlink(Long nlink) {
        this.nlink = nlink;
    }

    @JsonProperty("path")
    public java.lang.String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(java.lang.String path) {
        this.path = path;
    }

    @JsonProperty("percent")
    public java.lang.Integer getPercent() {
        return percent;
    }

    @JsonProperty("percent")
    public void setPercent(java.lang.Integer percent) {
        this.percent = percent;
    }

    @JsonProperty("perm")
    public Integer getPerm() {
        return perm;
    }

    @JsonProperty("perm")
    public void setPerm(Integer perm) {
        this.perm = perm;
    }

    @JsonProperty("rdev")
    public Long getRdev() {
        return rdev;
    }

    @JsonProperty("rdev")
    public void setRdev(Long rdev) {
        this.rdev = rdev;
    }

    @JsonProperty("size")
    public Long getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Long size) {
        this.size = size;
    }

    @JsonProperty("source")
    public java.lang.String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(java.lang.String source) {
        this.source = source;
    }

    @JsonProperty("type")
    public java.lang.String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(java.lang.String type) {
        this.type = type;
    }

    @JsonProperty("uid")
    public Long getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(Long uid) {
        this.uid = uid;
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

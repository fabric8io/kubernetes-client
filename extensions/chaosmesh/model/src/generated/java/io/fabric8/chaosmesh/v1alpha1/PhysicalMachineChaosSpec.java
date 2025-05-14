
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
 * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "address",
    "clock",
    "disk-fill",
    "disk-read-payload",
    "disk-write-payload",
    "duration",
    "file-append",
    "file-create",
    "file-delete",
    "file-modify",
    "file-rename",
    "file-replace",
    "http-abort",
    "http-config",
    "http-delay",
    "http-request",
    "jvm-exception",
    "jvm-gc",
    "jvm-latency",
    "jvm-mysql",
    "jvm-return",
    "jvm-rule-data",
    "jvm-stress",
    "kafka-fill",
    "kafka-flood",
    "kafka-io",
    "mode",
    "network-bandwidth",
    "network-corrupt",
    "network-delay",
    "network-dns",
    "network-down",
    "network-duplicate",
    "network-flood",
    "network-loss",
    "network-partition",
    "process",
    "redis-cacheLimit",
    "redis-expiration",
    "redis-penetration",
    "redis-restart",
    "redis-stop",
    "remoteCluster",
    "selector",
    "stress-cpu",
    "stress-mem",
    "user_defined",
    "value",
    "vm"
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
public class PhysicalMachineChaosSpec implements Editable<PhysicalMachineChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("address")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> address = new ArrayList<>();
    @JsonProperty("clock")
    private ClockSpec clock;
    @JsonProperty("disk-fill")
    private DiskFillSpec diskFill;
    @JsonProperty("disk-read-payload")
    private DiskPayloadSpec diskReadPayload;
    @JsonProperty("disk-write-payload")
    private DiskPayloadSpec diskWritePayload;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("file-append")
    private FileAppendSpec fileAppend;
    @JsonProperty("file-create")
    private FileCreateSpec fileCreate;
    @JsonProperty("file-delete")
    private FileDeleteSpec fileDelete;
    @JsonProperty("file-modify")
    private FileModifyPrivilegeSpec fileModify;
    @JsonProperty("file-rename")
    private FileRenameSpec fileRename;
    @JsonProperty("file-replace")
    private FileReplaceSpec fileReplace;
    @JsonProperty("http-abort")
    private HTTPAbortSpec httpAbort;
    @JsonProperty("http-config")
    private HTTPConfigSpec httpConfig;
    @JsonProperty("http-delay")
    private HTTPDelaySpec httpDelay;
    @JsonProperty("http-request")
    private HTTPRequestSpec httpRequest;
    @JsonProperty("jvm-exception")
    private JVMExceptionSpec jvmException;
    @JsonProperty("jvm-gc")
    private JVMGCSpec jvmGc;
    @JsonProperty("jvm-latency")
    private JVMLatencySpec jvmLatency;
    @JsonProperty("jvm-mysql")
    private PMJVMMySQLSpec jvmMysql;
    @JsonProperty("jvm-return")
    private JVMReturnSpec jvmReturn;
    @JsonProperty("jvm-rule-data")
    private JVMRuleDataSpec jvmRuleData;
    @JsonProperty("jvm-stress")
    private JVMStressSpec jvmStress;
    @JsonProperty("kafka-fill")
    private KafkaFillSpec kafkaFill;
    @JsonProperty("kafka-flood")
    private KafkaFloodSpec kafkaFlood;
    @JsonProperty("kafka-io")
    private KafkaIOSpec kafkaIo;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("network-bandwidth")
    private NetworkBandwidthSpec networkBandwidth;
    @JsonProperty("network-corrupt")
    private NetworkCorruptSpec networkCorrupt;
    @JsonProperty("network-delay")
    private NetworkDelaySpec networkDelay;
    @JsonProperty("network-dns")
    private NetworkDNSSpec networkDns;
    @JsonProperty("network-down")
    private NetworkDownSpec networkDown;
    @JsonProperty("network-duplicate")
    private NetworkDuplicateSpec networkDuplicate;
    @JsonProperty("network-flood")
    private NetworkFloodSpec networkFlood;
    @JsonProperty("network-loss")
    private NetworkLossSpec networkLoss;
    @JsonProperty("network-partition")
    private NetworkPartitionSpec networkPartition;
    @JsonProperty("process")
    private ProcessSpec process;
    @JsonProperty("redis-cacheLimit")
    private RedisCacheLimitSpec redisCacheLimit;
    @JsonProperty("redis-expiration")
    private RedisExpirationSpec redisExpiration;
    @JsonProperty("redis-penetration")
    private RedisPenetrationSpec redisPenetration;
    @JsonProperty("redis-restart")
    private RedisSentinelRestartSpec redisRestart;
    @JsonProperty("redis-stop")
    private RedisSentinelStopSpec redisStop;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("selector")
    private PhysicalMachineSelectorSpec selector;
    @JsonProperty("stress-cpu")
    private StressCPUSpec stressCpu;
    @JsonProperty("stress-mem")
    private StressMemorySpec stressMem;
    @JsonProperty("user_defined")
    private UserDefinedSpec userDefined;
    @JsonProperty("value")
    private String value;
    @JsonProperty("vm")
    private VMSpec vm;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PhysicalMachineChaosSpec() {
    }

    public PhysicalMachineChaosSpec(String action, List<String> address, ClockSpec clock, DiskFillSpec diskFill, DiskPayloadSpec diskReadPayload, DiskPayloadSpec diskWritePayload, String duration, FileAppendSpec fileAppend, FileCreateSpec fileCreate, FileDeleteSpec fileDelete, FileModifyPrivilegeSpec fileModify, FileRenameSpec fileRename, FileReplaceSpec fileReplace, HTTPAbortSpec httpAbort, HTTPConfigSpec httpConfig, HTTPDelaySpec httpDelay, HTTPRequestSpec httpRequest, JVMExceptionSpec jvmException, JVMGCSpec jvmGc, JVMLatencySpec jvmLatency, PMJVMMySQLSpec jvmMysql, JVMReturnSpec jvmReturn, JVMRuleDataSpec jvmRuleData, JVMStressSpec jvmStress, KafkaFillSpec kafkaFill, KafkaFloodSpec kafkaFlood, KafkaIOSpec kafkaIo, String mode, NetworkBandwidthSpec networkBandwidth, NetworkCorruptSpec networkCorrupt, NetworkDelaySpec networkDelay, NetworkDNSSpec networkDns, NetworkDownSpec networkDown, NetworkDuplicateSpec networkDuplicate, NetworkFloodSpec networkFlood, NetworkLossSpec networkLoss, NetworkPartitionSpec networkPartition, ProcessSpec process, RedisCacheLimitSpec redisCacheLimit, RedisExpirationSpec redisExpiration, RedisPenetrationSpec redisPenetration, RedisSentinelRestartSpec redisRestart, RedisSentinelStopSpec redisStop, String remoteCluster, PhysicalMachineSelectorSpec selector, StressCPUSpec stressCpu, StressMemorySpec stressMem, UserDefinedSpec userDefined, String value, VMSpec vm) {
        super();
        this.action = action;
        this.address = address;
        this.clock = clock;
        this.diskFill = diskFill;
        this.diskReadPayload = diskReadPayload;
        this.diskWritePayload = diskWritePayload;
        this.duration = duration;
        this.fileAppend = fileAppend;
        this.fileCreate = fileCreate;
        this.fileDelete = fileDelete;
        this.fileModify = fileModify;
        this.fileRename = fileRename;
        this.fileReplace = fileReplace;
        this.httpAbort = httpAbort;
        this.httpConfig = httpConfig;
        this.httpDelay = httpDelay;
        this.httpRequest = httpRequest;
        this.jvmException = jvmException;
        this.jvmGc = jvmGc;
        this.jvmLatency = jvmLatency;
        this.jvmMysql = jvmMysql;
        this.jvmReturn = jvmReturn;
        this.jvmRuleData = jvmRuleData;
        this.jvmStress = jvmStress;
        this.kafkaFill = kafkaFill;
        this.kafkaFlood = kafkaFlood;
        this.kafkaIo = kafkaIo;
        this.mode = mode;
        this.networkBandwidth = networkBandwidth;
        this.networkCorrupt = networkCorrupt;
        this.networkDelay = networkDelay;
        this.networkDns = networkDns;
        this.networkDown = networkDown;
        this.networkDuplicate = networkDuplicate;
        this.networkFlood = networkFlood;
        this.networkLoss = networkLoss;
        this.networkPartition = networkPartition;
        this.process = process;
        this.redisCacheLimit = redisCacheLimit;
        this.redisExpiration = redisExpiration;
        this.redisPenetration = redisPenetration;
        this.redisRestart = redisRestart;
        this.redisStop = redisStop;
        this.remoteCluster = remoteCluster;
        this.selector = selector;
        this.stressCpu = stressCpu;
        this.stressMem = stressMem;
        this.userDefined = userDefined;
        this.value = value;
        this.vm = vm;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * DEPRECATED: Use Selector instead. Only one of Address and Selector could be specified.
     */
    @JsonProperty("address")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAddress() {
        return address;
    }

    /**
     * DEPRECATED: Use Selector instead. Only one of Address and Selector could be specified.
     */
    @JsonProperty("address")
    public void setAddress(List<String> address) {
        this.address = address;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("clock")
    public ClockSpec getClock() {
        return clock;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("clock")
    public void setClock(ClockSpec clock) {
        this.clock = clock;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("disk-fill")
    public DiskFillSpec getDiskFill() {
        return diskFill;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("disk-fill")
    public void setDiskFill(DiskFillSpec diskFill) {
        this.diskFill = diskFill;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("disk-read-payload")
    public DiskPayloadSpec getDiskReadPayload() {
        return diskReadPayload;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("disk-read-payload")
    public void setDiskReadPayload(DiskPayloadSpec diskReadPayload) {
        this.diskReadPayload = diskReadPayload;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("disk-write-payload")
    public DiskPayloadSpec getDiskWritePayload() {
        return diskWritePayload;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("disk-write-payload")
    public void setDiskWritePayload(DiskPayloadSpec diskWritePayload) {
        this.diskWritePayload = diskWritePayload;
    }

    /**
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-append")
    public FileAppendSpec getFileAppend() {
        return fileAppend;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-append")
    public void setFileAppend(FileAppendSpec fileAppend) {
        this.fileAppend = fileAppend;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-create")
    public FileCreateSpec getFileCreate() {
        return fileCreate;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-create")
    public void setFileCreate(FileCreateSpec fileCreate) {
        this.fileCreate = fileCreate;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-delete")
    public FileDeleteSpec getFileDelete() {
        return fileDelete;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-delete")
    public void setFileDelete(FileDeleteSpec fileDelete) {
        this.fileDelete = fileDelete;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-modify")
    public FileModifyPrivilegeSpec getFileModify() {
        return fileModify;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-modify")
    public void setFileModify(FileModifyPrivilegeSpec fileModify) {
        this.fileModify = fileModify;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-rename")
    public FileRenameSpec getFileRename() {
        return fileRename;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-rename")
    public void setFileRename(FileRenameSpec fileRename) {
        this.fileRename = fileRename;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-replace")
    public FileReplaceSpec getFileReplace() {
        return fileReplace;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("file-replace")
    public void setFileReplace(FileReplaceSpec fileReplace) {
        this.fileReplace = fileReplace;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("http-abort")
    public HTTPAbortSpec getHttpAbort() {
        return httpAbort;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("http-abort")
    public void setHttpAbort(HTTPAbortSpec httpAbort) {
        this.httpAbort = httpAbort;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("http-config")
    public HTTPConfigSpec getHttpConfig() {
        return httpConfig;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("http-config")
    public void setHttpConfig(HTTPConfigSpec httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("http-delay")
    public HTTPDelaySpec getHttpDelay() {
        return httpDelay;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("http-delay")
    public void setHttpDelay(HTTPDelaySpec httpDelay) {
        this.httpDelay = httpDelay;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("http-request")
    public HTTPRequestSpec getHttpRequest() {
        return httpRequest;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("http-request")
    public void setHttpRequest(HTTPRequestSpec httpRequest) {
        this.httpRequest = httpRequest;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-exception")
    public JVMExceptionSpec getJvmException() {
        return jvmException;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-exception")
    public void setJvmException(JVMExceptionSpec jvmException) {
        this.jvmException = jvmException;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-gc")
    public JVMGCSpec getJvmGc() {
        return jvmGc;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-gc")
    public void setJvmGc(JVMGCSpec jvmGc) {
        this.jvmGc = jvmGc;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-latency")
    public JVMLatencySpec getJvmLatency() {
        return jvmLatency;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-latency")
    public void setJvmLatency(JVMLatencySpec jvmLatency) {
        this.jvmLatency = jvmLatency;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-mysql")
    public PMJVMMySQLSpec getJvmMysql() {
        return jvmMysql;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-mysql")
    public void setJvmMysql(PMJVMMySQLSpec jvmMysql) {
        this.jvmMysql = jvmMysql;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-return")
    public JVMReturnSpec getJvmReturn() {
        return jvmReturn;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-return")
    public void setJvmReturn(JVMReturnSpec jvmReturn) {
        this.jvmReturn = jvmReturn;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-rule-data")
    public JVMRuleDataSpec getJvmRuleData() {
        return jvmRuleData;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-rule-data")
    public void setJvmRuleData(JVMRuleDataSpec jvmRuleData) {
        this.jvmRuleData = jvmRuleData;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-stress")
    public JVMStressSpec getJvmStress() {
        return jvmStress;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("jvm-stress")
    public void setJvmStress(JVMStressSpec jvmStress) {
        this.jvmStress = jvmStress;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("kafka-fill")
    public KafkaFillSpec getKafkaFill() {
        return kafkaFill;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("kafka-fill")
    public void setKafkaFill(KafkaFillSpec kafkaFill) {
        this.kafkaFill = kafkaFill;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("kafka-flood")
    public KafkaFloodSpec getKafkaFlood() {
        return kafkaFlood;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("kafka-flood")
    public void setKafkaFlood(KafkaFloodSpec kafkaFlood) {
        this.kafkaFlood = kafkaFlood;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("kafka-io")
    public KafkaIOSpec getKafkaIo() {
        return kafkaIo;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("kafka-io")
    public void setKafkaIo(KafkaIOSpec kafkaIo) {
        this.kafkaIo = kafkaIo;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-bandwidth")
    public NetworkBandwidthSpec getNetworkBandwidth() {
        return networkBandwidth;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-bandwidth")
    public void setNetworkBandwidth(NetworkBandwidthSpec networkBandwidth) {
        this.networkBandwidth = networkBandwidth;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-corrupt")
    public NetworkCorruptSpec getNetworkCorrupt() {
        return networkCorrupt;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-corrupt")
    public void setNetworkCorrupt(NetworkCorruptSpec networkCorrupt) {
        this.networkCorrupt = networkCorrupt;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-delay")
    public NetworkDelaySpec getNetworkDelay() {
        return networkDelay;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-delay")
    public void setNetworkDelay(NetworkDelaySpec networkDelay) {
        this.networkDelay = networkDelay;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-dns")
    public NetworkDNSSpec getNetworkDns() {
        return networkDns;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-dns")
    public void setNetworkDns(NetworkDNSSpec networkDns) {
        this.networkDns = networkDns;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-down")
    public NetworkDownSpec getNetworkDown() {
        return networkDown;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-down")
    public void setNetworkDown(NetworkDownSpec networkDown) {
        this.networkDown = networkDown;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-duplicate")
    public NetworkDuplicateSpec getNetworkDuplicate() {
        return networkDuplicate;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-duplicate")
    public void setNetworkDuplicate(NetworkDuplicateSpec networkDuplicate) {
        this.networkDuplicate = networkDuplicate;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-flood")
    public NetworkFloodSpec getNetworkFlood() {
        return networkFlood;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-flood")
    public void setNetworkFlood(NetworkFloodSpec networkFlood) {
        this.networkFlood = networkFlood;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-loss")
    public NetworkLossSpec getNetworkLoss() {
        return networkLoss;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-loss")
    public void setNetworkLoss(NetworkLossSpec networkLoss) {
        this.networkLoss = networkLoss;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-partition")
    public NetworkPartitionSpec getNetworkPartition() {
        return networkPartition;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("network-partition")
    public void setNetworkPartition(NetworkPartitionSpec networkPartition) {
        this.networkPartition = networkPartition;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("process")
    public ProcessSpec getProcess() {
        return process;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("process")
    public void setProcess(ProcessSpec process) {
        this.process = process;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-cacheLimit")
    public RedisCacheLimitSpec getRedisCacheLimit() {
        return redisCacheLimit;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-cacheLimit")
    public void setRedisCacheLimit(RedisCacheLimitSpec redisCacheLimit) {
        this.redisCacheLimit = redisCacheLimit;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-expiration")
    public RedisExpirationSpec getRedisExpiration() {
        return redisExpiration;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-expiration")
    public void setRedisExpiration(RedisExpirationSpec redisExpiration) {
        this.redisExpiration = redisExpiration;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-penetration")
    public RedisPenetrationSpec getRedisPenetration() {
        return redisPenetration;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-penetration")
    public void setRedisPenetration(RedisPenetrationSpec redisPenetration) {
        this.redisPenetration = redisPenetration;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-restart")
    public RedisSentinelRestartSpec getRedisRestart() {
        return redisRestart;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-restart")
    public void setRedisRestart(RedisSentinelRestartSpec redisRestart) {
        this.redisRestart = redisRestart;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-stop")
    public RedisSentinelStopSpec getRedisStop() {
        return redisStop;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("redis-stop")
    public void setRedisStop(RedisSentinelStopSpec redisStop) {
        this.redisStop = redisStop;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("selector")
    public PhysicalMachineSelectorSpec getSelector() {
        return selector;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("selector")
    public void setSelector(PhysicalMachineSelectorSpec selector) {
        this.selector = selector;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("stress-cpu")
    public StressCPUSpec getStressCpu() {
        return stressCpu;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("stress-cpu")
    public void setStressCpu(StressCPUSpec stressCpu) {
        this.stressCpu = stressCpu;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("stress-mem")
    public StressMemorySpec getStressMem() {
        return stressMem;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("stress-mem")
    public void setStressMem(StressMemorySpec stressMem) {
        this.stressMem = stressMem;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("user_defined")
    public UserDefinedSpec getUserDefined() {
        return userDefined;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("user_defined")
    public void setUserDefined(UserDefinedSpec userDefined) {
        this.userDefined = userDefined;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of physical machines to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of physical machines the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of physical machines to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of physical machines the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("vm")
    public VMSpec getVm() {
        return vm;
    }

    /**
     * PhysicalMachineChaosSpec defines the desired state of PhysicalMachineChaos
     */
    @JsonProperty("vm")
    public void setVm(VMSpec vm) {
        this.vm = vm;
    }

    @JsonIgnore
    public PhysicalMachineChaosSpecBuilder edit() {
        return new PhysicalMachineChaosSpecBuilder(this);
    }

    @JsonIgnore
    public PhysicalMachineChaosSpecBuilder toBuilder() {
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


package io.fabric8.chaosmesh.v1alpha1;

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
    "clock",
    "disk-fill",
    "disk-read-payload",
    "disk-write-payload",
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
    "stress-cpu",
    "stress-mem",
    "user_defined",
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
@Generated("jsonschema2pojo")
public class ExpInfo implements Editable<ExpInfoBuilder> , KubernetesResource
{

    @JsonProperty("clock")
    private ClockSpec clock;
    @JsonProperty("disk-fill")
    private DiskFillSpec diskFill;
    @JsonProperty("disk-read-payload")
    private DiskPayloadSpec diskReadPayload;
    @JsonProperty("disk-write-payload")
    private DiskPayloadSpec diskWritePayload;
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
    @JsonProperty("stress-cpu")
    private StressCPUSpec stressCpu;
    @JsonProperty("stress-mem")
    private StressMemorySpec stressMem;
    @JsonProperty("user_defined")
    private UserDefinedSpec user_defined;
    @JsonProperty("vm")
    private VMSpec vm;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExpInfo() {
    }

    public ExpInfo(ClockSpec clock, DiskFillSpec diskFill, DiskPayloadSpec diskReadPayload, DiskPayloadSpec diskWritePayload, FileAppendSpec fileAppend, FileCreateSpec fileCreate, FileDeleteSpec fileDelete, FileModifyPrivilegeSpec fileModify, FileRenameSpec fileRename, FileReplaceSpec fileReplace, HTTPAbortSpec httpAbort, HTTPConfigSpec httpConfig, HTTPDelaySpec httpDelay, HTTPRequestSpec httpRequest, JVMExceptionSpec jvmException, JVMGCSpec jvmGc, JVMLatencySpec jvmLatency, PMJVMMySQLSpec jvmMysql, JVMReturnSpec jvmReturn, JVMRuleDataSpec jvmRuleData, JVMStressSpec jvmStress, KafkaFillSpec kafkaFill, KafkaFloodSpec kafkaFlood, KafkaIOSpec kafkaIo, NetworkBandwidthSpec networkBandwidth, NetworkCorruptSpec networkCorrupt, NetworkDelaySpec networkDelay, NetworkDNSSpec networkDns, NetworkDownSpec networkDown, NetworkDuplicateSpec networkDuplicate, NetworkFloodSpec networkFlood, NetworkLossSpec networkLoss, NetworkPartitionSpec networkPartition, ProcessSpec process, RedisCacheLimitSpec redisCacheLimit, RedisExpirationSpec redisExpiration, RedisPenetrationSpec redisPenetration, RedisSentinelRestartSpec redisRestart, RedisSentinelStopSpec redisStop, StressCPUSpec stressCpu, StressMemorySpec stressMem, UserDefinedSpec user_defined, VMSpec vm) {
        super();
        this.clock = clock;
        this.diskFill = diskFill;
        this.diskReadPayload = diskReadPayload;
        this.diskWritePayload = diskWritePayload;
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
        this.stressCpu = stressCpu;
        this.stressMem = stressMem;
        this.user_defined = user_defined;
        this.vm = vm;
    }

    @JsonProperty("clock")
    public ClockSpec getClock() {
        return clock;
    }

    @JsonProperty("clock")
    public void setClock(ClockSpec clock) {
        this.clock = clock;
    }

    @JsonProperty("disk-fill")
    public DiskFillSpec getDiskFill() {
        return diskFill;
    }

    @JsonProperty("disk-fill")
    public void setDiskFill(DiskFillSpec diskFill) {
        this.diskFill = diskFill;
    }

    @JsonProperty("disk-read-payload")
    public DiskPayloadSpec getDiskReadPayload() {
        return diskReadPayload;
    }

    @JsonProperty("disk-read-payload")
    public void setDiskReadPayload(DiskPayloadSpec diskReadPayload) {
        this.diskReadPayload = diskReadPayload;
    }

    @JsonProperty("disk-write-payload")
    public DiskPayloadSpec getDiskWritePayload() {
        return diskWritePayload;
    }

    @JsonProperty("disk-write-payload")
    public void setDiskWritePayload(DiskPayloadSpec diskWritePayload) {
        this.diskWritePayload = diskWritePayload;
    }

    @JsonProperty("file-append")
    public FileAppendSpec getFileAppend() {
        return fileAppend;
    }

    @JsonProperty("file-append")
    public void setFileAppend(FileAppendSpec fileAppend) {
        this.fileAppend = fileAppend;
    }

    @JsonProperty("file-create")
    public FileCreateSpec getFileCreate() {
        return fileCreate;
    }

    @JsonProperty("file-create")
    public void setFileCreate(FileCreateSpec fileCreate) {
        this.fileCreate = fileCreate;
    }

    @JsonProperty("file-delete")
    public FileDeleteSpec getFileDelete() {
        return fileDelete;
    }

    @JsonProperty("file-delete")
    public void setFileDelete(FileDeleteSpec fileDelete) {
        this.fileDelete = fileDelete;
    }

    @JsonProperty("file-modify")
    public FileModifyPrivilegeSpec getFileModify() {
        return fileModify;
    }

    @JsonProperty("file-modify")
    public void setFileModify(FileModifyPrivilegeSpec fileModify) {
        this.fileModify = fileModify;
    }

    @JsonProperty("file-rename")
    public FileRenameSpec getFileRename() {
        return fileRename;
    }

    @JsonProperty("file-rename")
    public void setFileRename(FileRenameSpec fileRename) {
        this.fileRename = fileRename;
    }

    @JsonProperty("file-replace")
    public FileReplaceSpec getFileReplace() {
        return fileReplace;
    }

    @JsonProperty("file-replace")
    public void setFileReplace(FileReplaceSpec fileReplace) {
        this.fileReplace = fileReplace;
    }

    @JsonProperty("http-abort")
    public HTTPAbortSpec getHttpAbort() {
        return httpAbort;
    }

    @JsonProperty("http-abort")
    public void setHttpAbort(HTTPAbortSpec httpAbort) {
        this.httpAbort = httpAbort;
    }

    @JsonProperty("http-config")
    public HTTPConfigSpec getHttpConfig() {
        return httpConfig;
    }

    @JsonProperty("http-config")
    public void setHttpConfig(HTTPConfigSpec httpConfig) {
        this.httpConfig = httpConfig;
    }

    @JsonProperty("http-delay")
    public HTTPDelaySpec getHttpDelay() {
        return httpDelay;
    }

    @JsonProperty("http-delay")
    public void setHttpDelay(HTTPDelaySpec httpDelay) {
        this.httpDelay = httpDelay;
    }

    @JsonProperty("http-request")
    public HTTPRequestSpec getHttpRequest() {
        return httpRequest;
    }

    @JsonProperty("http-request")
    public void setHttpRequest(HTTPRequestSpec httpRequest) {
        this.httpRequest = httpRequest;
    }

    @JsonProperty("jvm-exception")
    public JVMExceptionSpec getJvmException() {
        return jvmException;
    }

    @JsonProperty("jvm-exception")
    public void setJvmException(JVMExceptionSpec jvmException) {
        this.jvmException = jvmException;
    }

    @JsonProperty("jvm-gc")
    public JVMGCSpec getJvmGc() {
        return jvmGc;
    }

    @JsonProperty("jvm-gc")
    public void setJvmGc(JVMGCSpec jvmGc) {
        this.jvmGc = jvmGc;
    }

    @JsonProperty("jvm-latency")
    public JVMLatencySpec getJvmLatency() {
        return jvmLatency;
    }

    @JsonProperty("jvm-latency")
    public void setJvmLatency(JVMLatencySpec jvmLatency) {
        this.jvmLatency = jvmLatency;
    }

    @JsonProperty("jvm-mysql")
    public PMJVMMySQLSpec getJvmMysql() {
        return jvmMysql;
    }

    @JsonProperty("jvm-mysql")
    public void setJvmMysql(PMJVMMySQLSpec jvmMysql) {
        this.jvmMysql = jvmMysql;
    }

    @JsonProperty("jvm-return")
    public JVMReturnSpec getJvmReturn() {
        return jvmReturn;
    }

    @JsonProperty("jvm-return")
    public void setJvmReturn(JVMReturnSpec jvmReturn) {
        this.jvmReturn = jvmReturn;
    }

    @JsonProperty("jvm-rule-data")
    public JVMRuleDataSpec getJvmRuleData() {
        return jvmRuleData;
    }

    @JsonProperty("jvm-rule-data")
    public void setJvmRuleData(JVMRuleDataSpec jvmRuleData) {
        this.jvmRuleData = jvmRuleData;
    }

    @JsonProperty("jvm-stress")
    public JVMStressSpec getJvmStress() {
        return jvmStress;
    }

    @JsonProperty("jvm-stress")
    public void setJvmStress(JVMStressSpec jvmStress) {
        this.jvmStress = jvmStress;
    }

    @JsonProperty("kafka-fill")
    public KafkaFillSpec getKafkaFill() {
        return kafkaFill;
    }

    @JsonProperty("kafka-fill")
    public void setKafkaFill(KafkaFillSpec kafkaFill) {
        this.kafkaFill = kafkaFill;
    }

    @JsonProperty("kafka-flood")
    public KafkaFloodSpec getKafkaFlood() {
        return kafkaFlood;
    }

    @JsonProperty("kafka-flood")
    public void setKafkaFlood(KafkaFloodSpec kafkaFlood) {
        this.kafkaFlood = kafkaFlood;
    }

    @JsonProperty("kafka-io")
    public KafkaIOSpec getKafkaIo() {
        return kafkaIo;
    }

    @JsonProperty("kafka-io")
    public void setKafkaIo(KafkaIOSpec kafkaIo) {
        this.kafkaIo = kafkaIo;
    }

    @JsonProperty("network-bandwidth")
    public NetworkBandwidthSpec getNetworkBandwidth() {
        return networkBandwidth;
    }

    @JsonProperty("network-bandwidth")
    public void setNetworkBandwidth(NetworkBandwidthSpec networkBandwidth) {
        this.networkBandwidth = networkBandwidth;
    }

    @JsonProperty("network-corrupt")
    public NetworkCorruptSpec getNetworkCorrupt() {
        return networkCorrupt;
    }

    @JsonProperty("network-corrupt")
    public void setNetworkCorrupt(NetworkCorruptSpec networkCorrupt) {
        this.networkCorrupt = networkCorrupt;
    }

    @JsonProperty("network-delay")
    public NetworkDelaySpec getNetworkDelay() {
        return networkDelay;
    }

    @JsonProperty("network-delay")
    public void setNetworkDelay(NetworkDelaySpec networkDelay) {
        this.networkDelay = networkDelay;
    }

    @JsonProperty("network-dns")
    public NetworkDNSSpec getNetworkDns() {
        return networkDns;
    }

    @JsonProperty("network-dns")
    public void setNetworkDns(NetworkDNSSpec networkDns) {
        this.networkDns = networkDns;
    }

    @JsonProperty("network-down")
    public NetworkDownSpec getNetworkDown() {
        return networkDown;
    }

    @JsonProperty("network-down")
    public void setNetworkDown(NetworkDownSpec networkDown) {
        this.networkDown = networkDown;
    }

    @JsonProperty("network-duplicate")
    public NetworkDuplicateSpec getNetworkDuplicate() {
        return networkDuplicate;
    }

    @JsonProperty("network-duplicate")
    public void setNetworkDuplicate(NetworkDuplicateSpec networkDuplicate) {
        this.networkDuplicate = networkDuplicate;
    }

    @JsonProperty("network-flood")
    public NetworkFloodSpec getNetworkFlood() {
        return networkFlood;
    }

    @JsonProperty("network-flood")
    public void setNetworkFlood(NetworkFloodSpec networkFlood) {
        this.networkFlood = networkFlood;
    }

    @JsonProperty("network-loss")
    public NetworkLossSpec getNetworkLoss() {
        return networkLoss;
    }

    @JsonProperty("network-loss")
    public void setNetworkLoss(NetworkLossSpec networkLoss) {
        this.networkLoss = networkLoss;
    }

    @JsonProperty("network-partition")
    public NetworkPartitionSpec getNetworkPartition() {
        return networkPartition;
    }

    @JsonProperty("network-partition")
    public void setNetworkPartition(NetworkPartitionSpec networkPartition) {
        this.networkPartition = networkPartition;
    }

    @JsonProperty("process")
    public ProcessSpec getProcess() {
        return process;
    }

    @JsonProperty("process")
    public void setProcess(ProcessSpec process) {
        this.process = process;
    }

    @JsonProperty("redis-cacheLimit")
    public RedisCacheLimitSpec getRedisCacheLimit() {
        return redisCacheLimit;
    }

    @JsonProperty("redis-cacheLimit")
    public void setRedisCacheLimit(RedisCacheLimitSpec redisCacheLimit) {
        this.redisCacheLimit = redisCacheLimit;
    }

    @JsonProperty("redis-expiration")
    public RedisExpirationSpec getRedisExpiration() {
        return redisExpiration;
    }

    @JsonProperty("redis-expiration")
    public void setRedisExpiration(RedisExpirationSpec redisExpiration) {
        this.redisExpiration = redisExpiration;
    }

    @JsonProperty("redis-penetration")
    public RedisPenetrationSpec getRedisPenetration() {
        return redisPenetration;
    }

    @JsonProperty("redis-penetration")
    public void setRedisPenetration(RedisPenetrationSpec redisPenetration) {
        this.redisPenetration = redisPenetration;
    }

    @JsonProperty("redis-restart")
    public RedisSentinelRestartSpec getRedisRestart() {
        return redisRestart;
    }

    @JsonProperty("redis-restart")
    public void setRedisRestart(RedisSentinelRestartSpec redisRestart) {
        this.redisRestart = redisRestart;
    }

    @JsonProperty("redis-stop")
    public RedisSentinelStopSpec getRedisStop() {
        return redisStop;
    }

    @JsonProperty("redis-stop")
    public void setRedisStop(RedisSentinelStopSpec redisStop) {
        this.redisStop = redisStop;
    }

    @JsonProperty("stress-cpu")
    public StressCPUSpec getStressCpu() {
        return stressCpu;
    }

    @JsonProperty("stress-cpu")
    public void setStressCpu(StressCPUSpec stressCpu) {
        this.stressCpu = stressCpu;
    }

    @JsonProperty("stress-mem")
    public StressMemorySpec getStressMem() {
        return stressMem;
    }

    @JsonProperty("stress-mem")
    public void setStressMem(StressMemorySpec stressMem) {
        this.stressMem = stressMem;
    }

    @JsonProperty("user_defined")
    public UserDefinedSpec getUser_defined() {
        return user_defined;
    }

    @JsonProperty("user_defined")
    public void setUser_defined(UserDefinedSpec user_defined) {
        this.user_defined = user_defined;
    }

    @JsonProperty("vm")
    public VMSpec getVm() {
        return vm;
    }

    @JsonProperty("vm")
    public void setVm(VMSpec vm) {
        this.vm = vm;
    }

    @JsonIgnore
    public ExpInfoBuilder edit() {
        return new ExpInfoBuilder(this);
    }

    @JsonIgnore
    public ExpInfoBuilder toBuilder() {
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

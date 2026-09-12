
package io.fabric8.chaosmesh.v1alpha1;

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
public class ExpInfo implements Editable<ExpInfoBuilder>, KubernetesResource
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
    private UserDefinedSpec userDefined;
    @JsonProperty("vm")
    private VMSpec vm;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExpInfo() {
    }

    public ExpInfo(ClockSpec clock, DiskFillSpec diskFill, DiskPayloadSpec diskReadPayload, DiskPayloadSpec diskWritePayload, FileAppendSpec fileAppend, FileCreateSpec fileCreate, FileDeleteSpec fileDelete, FileModifyPrivilegeSpec fileModify, FileRenameSpec fileRename, FileReplaceSpec fileReplace, HTTPAbortSpec httpAbort, HTTPConfigSpec httpConfig, HTTPDelaySpec httpDelay, HTTPRequestSpec httpRequest, JVMExceptionSpec jvmException, JVMGCSpec jvmGc, JVMLatencySpec jvmLatency, PMJVMMySQLSpec jvmMysql, JVMReturnSpec jvmReturn, JVMRuleDataSpec jvmRuleData, JVMStressSpec jvmStress, KafkaFillSpec kafkaFill, KafkaFloodSpec kafkaFlood, KafkaIOSpec kafkaIo, NetworkBandwidthSpec networkBandwidth, NetworkCorruptSpec networkCorrupt, NetworkDelaySpec networkDelay, NetworkDNSSpec networkDns, NetworkDownSpec networkDown, NetworkDuplicateSpec networkDuplicate, NetworkFloodSpec networkFlood, NetworkLossSpec networkLoss, NetworkPartitionSpec networkPartition, ProcessSpec process, RedisCacheLimitSpec redisCacheLimit, RedisExpirationSpec redisExpiration, RedisPenetrationSpec redisPenetration, RedisSentinelRestartSpec redisRestart, RedisSentinelStopSpec redisStop, StressCPUSpec stressCpu, StressMemorySpec stressMem, UserDefinedSpec userDefined, VMSpec vm) {
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
        this.userDefined = userDefined;
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
    public UserDefinedSpec getUserDefined() {
        return userDefined;
    }

    @JsonProperty("user_defined")
    public void setUserDefined(UserDefinedSpec userDefined) {
        this.userDefined = userDefined;
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ExpInfo)) {
            return false;
        }
        ExpInfo other = (ExpInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clock = this.getClock();
        Object other$clock = other.getClock();
        if (this$clock == null ? other$clock != null : !this$clock.equals(other$clock)) {
            return false;
        }
        Object this$diskFill = this.getDiskFill();
        Object other$diskFill = other.getDiskFill();
        if (this$diskFill == null ? other$diskFill != null : !this$diskFill.equals(other$diskFill)) {
            return false;
        }
        Object this$diskReadPayload = this.getDiskReadPayload();
        Object other$diskReadPayload = other.getDiskReadPayload();
        if (this$diskReadPayload == null ? other$diskReadPayload != null : !this$diskReadPayload.equals(other$diskReadPayload)) {
            return false;
        }
        Object this$diskWritePayload = this.getDiskWritePayload();
        Object other$diskWritePayload = other.getDiskWritePayload();
        if (this$diskWritePayload == null ? other$diskWritePayload != null : !this$diskWritePayload.equals(other$diskWritePayload)) {
            return false;
        }
        Object this$fileAppend = this.getFileAppend();
        Object other$fileAppend = other.getFileAppend();
        if (this$fileAppend == null ? other$fileAppend != null : !this$fileAppend.equals(other$fileAppend)) {
            return false;
        }
        Object this$fileCreate = this.getFileCreate();
        Object other$fileCreate = other.getFileCreate();
        if (this$fileCreate == null ? other$fileCreate != null : !this$fileCreate.equals(other$fileCreate)) {
            return false;
        }
        Object this$fileDelete = this.getFileDelete();
        Object other$fileDelete = other.getFileDelete();
        if (this$fileDelete == null ? other$fileDelete != null : !this$fileDelete.equals(other$fileDelete)) {
            return false;
        }
        Object this$fileModify = this.getFileModify();
        Object other$fileModify = other.getFileModify();
        if (this$fileModify == null ? other$fileModify != null : !this$fileModify.equals(other$fileModify)) {
            return false;
        }
        Object this$fileRename = this.getFileRename();
        Object other$fileRename = other.getFileRename();
        if (this$fileRename == null ? other$fileRename != null : !this$fileRename.equals(other$fileRename)) {
            return false;
        }
        Object this$fileReplace = this.getFileReplace();
        Object other$fileReplace = other.getFileReplace();
        if (this$fileReplace == null ? other$fileReplace != null : !this$fileReplace.equals(other$fileReplace)) {
            return false;
        }
        Object this$httpAbort = this.getHttpAbort();
        Object other$httpAbort = other.getHttpAbort();
        if (this$httpAbort == null ? other$httpAbort != null : !this$httpAbort.equals(other$httpAbort)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$httpDelay = this.getHttpDelay();
        Object other$httpDelay = other.getHttpDelay();
        if (this$httpDelay == null ? other$httpDelay != null : !this$httpDelay.equals(other$httpDelay)) {
            return false;
        }
        Object this$httpRequest = this.getHttpRequest();
        Object other$httpRequest = other.getHttpRequest();
        if (this$httpRequest == null ? other$httpRequest != null : !this$httpRequest.equals(other$httpRequest)) {
            return false;
        }
        Object this$jvmException = this.getJvmException();
        Object other$jvmException = other.getJvmException();
        if (this$jvmException == null ? other$jvmException != null : !this$jvmException.equals(other$jvmException)) {
            return false;
        }
        Object this$jvmGc = this.getJvmGc();
        Object other$jvmGc = other.getJvmGc();
        if (this$jvmGc == null ? other$jvmGc != null : !this$jvmGc.equals(other$jvmGc)) {
            return false;
        }
        Object this$jvmLatency = this.getJvmLatency();
        Object other$jvmLatency = other.getJvmLatency();
        if (this$jvmLatency == null ? other$jvmLatency != null : !this$jvmLatency.equals(other$jvmLatency)) {
            return false;
        }
        Object this$jvmMysql = this.getJvmMysql();
        Object other$jvmMysql = other.getJvmMysql();
        if (this$jvmMysql == null ? other$jvmMysql != null : !this$jvmMysql.equals(other$jvmMysql)) {
            return false;
        }
        Object this$jvmReturn = this.getJvmReturn();
        Object other$jvmReturn = other.getJvmReturn();
        if (this$jvmReturn == null ? other$jvmReturn != null : !this$jvmReturn.equals(other$jvmReturn)) {
            return false;
        }
        Object this$jvmRuleData = this.getJvmRuleData();
        Object other$jvmRuleData = other.getJvmRuleData();
        if (this$jvmRuleData == null ? other$jvmRuleData != null : !this$jvmRuleData.equals(other$jvmRuleData)) {
            return false;
        }
        Object this$jvmStress = this.getJvmStress();
        Object other$jvmStress = other.getJvmStress();
        if (this$jvmStress == null ? other$jvmStress != null : !this$jvmStress.equals(other$jvmStress)) {
            return false;
        }
        Object this$kafkaFill = this.getKafkaFill();
        Object other$kafkaFill = other.getKafkaFill();
        if (this$kafkaFill == null ? other$kafkaFill != null : !this$kafkaFill.equals(other$kafkaFill)) {
            return false;
        }
        Object this$kafkaFlood = this.getKafkaFlood();
        Object other$kafkaFlood = other.getKafkaFlood();
        if (this$kafkaFlood == null ? other$kafkaFlood != null : !this$kafkaFlood.equals(other$kafkaFlood)) {
            return false;
        }
        Object this$kafkaIo = this.getKafkaIo();
        Object other$kafkaIo = other.getKafkaIo();
        if (this$kafkaIo == null ? other$kafkaIo != null : !this$kafkaIo.equals(other$kafkaIo)) {
            return false;
        }
        Object this$networkBandwidth = this.getNetworkBandwidth();
        Object other$networkBandwidth = other.getNetworkBandwidth();
        if (this$networkBandwidth == null ? other$networkBandwidth != null : !this$networkBandwidth.equals(other$networkBandwidth)) {
            return false;
        }
        Object this$networkCorrupt = this.getNetworkCorrupt();
        Object other$networkCorrupt = other.getNetworkCorrupt();
        if (this$networkCorrupt == null ? other$networkCorrupt != null : !this$networkCorrupt.equals(other$networkCorrupt)) {
            return false;
        }
        Object this$networkDelay = this.getNetworkDelay();
        Object other$networkDelay = other.getNetworkDelay();
        if (this$networkDelay == null ? other$networkDelay != null : !this$networkDelay.equals(other$networkDelay)) {
            return false;
        }
        Object this$networkDns = this.getNetworkDns();
        Object other$networkDns = other.getNetworkDns();
        if (this$networkDns == null ? other$networkDns != null : !this$networkDns.equals(other$networkDns)) {
            return false;
        }
        Object this$networkDown = this.getNetworkDown();
        Object other$networkDown = other.getNetworkDown();
        if (this$networkDown == null ? other$networkDown != null : !this$networkDown.equals(other$networkDown)) {
            return false;
        }
        Object this$networkDuplicate = this.getNetworkDuplicate();
        Object other$networkDuplicate = other.getNetworkDuplicate();
        if (this$networkDuplicate == null ? other$networkDuplicate != null : !this$networkDuplicate.equals(other$networkDuplicate)) {
            return false;
        }
        Object this$networkFlood = this.getNetworkFlood();
        Object other$networkFlood = other.getNetworkFlood();
        if (this$networkFlood == null ? other$networkFlood != null : !this$networkFlood.equals(other$networkFlood)) {
            return false;
        }
        Object this$networkLoss = this.getNetworkLoss();
        Object other$networkLoss = other.getNetworkLoss();
        if (this$networkLoss == null ? other$networkLoss != null : !this$networkLoss.equals(other$networkLoss)) {
            return false;
        }
        Object this$networkPartition = this.getNetworkPartition();
        Object other$networkPartition = other.getNetworkPartition();
        if (this$networkPartition == null ? other$networkPartition != null : !this$networkPartition.equals(other$networkPartition)) {
            return false;
        }
        Object this$process = this.getProcess();
        Object other$process = other.getProcess();
        if (this$process == null ? other$process != null : !this$process.equals(other$process)) {
            return false;
        }
        Object this$redisCacheLimit = this.getRedisCacheLimit();
        Object other$redisCacheLimit = other.getRedisCacheLimit();
        if (this$redisCacheLimit == null ? other$redisCacheLimit != null : !this$redisCacheLimit.equals(other$redisCacheLimit)) {
            return false;
        }
        Object this$redisExpiration = this.getRedisExpiration();
        Object other$redisExpiration = other.getRedisExpiration();
        if (this$redisExpiration == null ? other$redisExpiration != null : !this$redisExpiration.equals(other$redisExpiration)) {
            return false;
        }
        Object this$redisPenetration = this.getRedisPenetration();
        Object other$redisPenetration = other.getRedisPenetration();
        if (this$redisPenetration == null ? other$redisPenetration != null : !this$redisPenetration.equals(other$redisPenetration)) {
            return false;
        }
        Object this$redisRestart = this.getRedisRestart();
        Object other$redisRestart = other.getRedisRestart();
        if (this$redisRestart == null ? other$redisRestart != null : !this$redisRestart.equals(other$redisRestart)) {
            return false;
        }
        Object this$redisStop = this.getRedisStop();
        Object other$redisStop = other.getRedisStop();
        if (this$redisStop == null ? other$redisStop != null : !this$redisStop.equals(other$redisStop)) {
            return false;
        }
        Object this$stressCpu = this.getStressCpu();
        Object other$stressCpu = other.getStressCpu();
        if (this$stressCpu == null ? other$stressCpu != null : !this$stressCpu.equals(other$stressCpu)) {
            return false;
        }
        Object this$stressMem = this.getStressMem();
        Object other$stressMem = other.getStressMem();
        if (this$stressMem == null ? other$stressMem != null : !this$stressMem.equals(other$stressMem)) {
            return false;
        }
        Object this$userDefined = this.getUserDefined();
        Object other$userDefined = other.getUserDefined();
        if (this$userDefined == null ? other$userDefined != null : !this$userDefined.equals(other$userDefined)) {
            return false;
        }
        Object this$vm = this.getVm();
        Object other$vm = other.getVm();
        if (this$vm == null ? other$vm != null : !this$vm.equals(other$vm)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ExpInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clock = this.getClock();
        result = result * prime + ($clock == null ? 43 : $clock.hashCode());
        Object $diskFill = this.getDiskFill();
        result = result * prime + ($diskFill == null ? 43 : $diskFill.hashCode());
        Object $diskReadPayload = this.getDiskReadPayload();
        result = result * prime + ($diskReadPayload == null ? 43 : $diskReadPayload.hashCode());
        Object $diskWritePayload = this.getDiskWritePayload();
        result = result * prime + ($diskWritePayload == null ? 43 : $diskWritePayload.hashCode());
        Object $fileAppend = this.getFileAppend();
        result = result * prime + ($fileAppend == null ? 43 : $fileAppend.hashCode());
        Object $fileCreate = this.getFileCreate();
        result = result * prime + ($fileCreate == null ? 43 : $fileCreate.hashCode());
        Object $fileDelete = this.getFileDelete();
        result = result * prime + ($fileDelete == null ? 43 : $fileDelete.hashCode());
        Object $fileModify = this.getFileModify();
        result = result * prime + ($fileModify == null ? 43 : $fileModify.hashCode());
        Object $fileRename = this.getFileRename();
        result = result * prime + ($fileRename == null ? 43 : $fileRename.hashCode());
        Object $fileReplace = this.getFileReplace();
        result = result * prime + ($fileReplace == null ? 43 : $fileReplace.hashCode());
        Object $httpAbort = this.getHttpAbort();
        result = result * prime + ($httpAbort == null ? 43 : $httpAbort.hashCode());
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $httpDelay = this.getHttpDelay();
        result = result * prime + ($httpDelay == null ? 43 : $httpDelay.hashCode());
        Object $httpRequest = this.getHttpRequest();
        result = result * prime + ($httpRequest == null ? 43 : $httpRequest.hashCode());
        Object $jvmException = this.getJvmException();
        result = result * prime + ($jvmException == null ? 43 : $jvmException.hashCode());
        Object $jvmGc = this.getJvmGc();
        result = result * prime + ($jvmGc == null ? 43 : $jvmGc.hashCode());
        Object $jvmLatency = this.getJvmLatency();
        result = result * prime + ($jvmLatency == null ? 43 : $jvmLatency.hashCode());
        Object $jvmMysql = this.getJvmMysql();
        result = result * prime + ($jvmMysql == null ? 43 : $jvmMysql.hashCode());
        Object $jvmReturn = this.getJvmReturn();
        result = result * prime + ($jvmReturn == null ? 43 : $jvmReturn.hashCode());
        Object $jvmRuleData = this.getJvmRuleData();
        result = result * prime + ($jvmRuleData == null ? 43 : $jvmRuleData.hashCode());
        Object $jvmStress = this.getJvmStress();
        result = result * prime + ($jvmStress == null ? 43 : $jvmStress.hashCode());
        Object $kafkaFill = this.getKafkaFill();
        result = result * prime + ($kafkaFill == null ? 43 : $kafkaFill.hashCode());
        Object $kafkaFlood = this.getKafkaFlood();
        result = result * prime + ($kafkaFlood == null ? 43 : $kafkaFlood.hashCode());
        Object $kafkaIo = this.getKafkaIo();
        result = result * prime + ($kafkaIo == null ? 43 : $kafkaIo.hashCode());
        Object $networkBandwidth = this.getNetworkBandwidth();
        result = result * prime + ($networkBandwidth == null ? 43 : $networkBandwidth.hashCode());
        Object $networkCorrupt = this.getNetworkCorrupt();
        result = result * prime + ($networkCorrupt == null ? 43 : $networkCorrupt.hashCode());
        Object $networkDelay = this.getNetworkDelay();
        result = result * prime + ($networkDelay == null ? 43 : $networkDelay.hashCode());
        Object $networkDns = this.getNetworkDns();
        result = result * prime + ($networkDns == null ? 43 : $networkDns.hashCode());
        Object $networkDown = this.getNetworkDown();
        result = result * prime + ($networkDown == null ? 43 : $networkDown.hashCode());
        Object $networkDuplicate = this.getNetworkDuplicate();
        result = result * prime + ($networkDuplicate == null ? 43 : $networkDuplicate.hashCode());
        Object $networkFlood = this.getNetworkFlood();
        result = result * prime + ($networkFlood == null ? 43 : $networkFlood.hashCode());
        Object $networkLoss = this.getNetworkLoss();
        result = result * prime + ($networkLoss == null ? 43 : $networkLoss.hashCode());
        Object $networkPartition = this.getNetworkPartition();
        result = result * prime + ($networkPartition == null ? 43 : $networkPartition.hashCode());
        Object $process = this.getProcess();
        result = result * prime + ($process == null ? 43 : $process.hashCode());
        Object $redisCacheLimit = this.getRedisCacheLimit();
        result = result * prime + ($redisCacheLimit == null ? 43 : $redisCacheLimit.hashCode());
        Object $redisExpiration = this.getRedisExpiration();
        result = result * prime + ($redisExpiration == null ? 43 : $redisExpiration.hashCode());
        Object $redisPenetration = this.getRedisPenetration();
        result = result * prime + ($redisPenetration == null ? 43 : $redisPenetration.hashCode());
        Object $redisRestart = this.getRedisRestart();
        result = result * prime + ($redisRestart == null ? 43 : $redisRestart.hashCode());
        Object $redisStop = this.getRedisStop();
        result = result * prime + ($redisStop == null ? 43 : $redisStop.hashCode());
        Object $stressCpu = this.getStressCpu();
        result = result * prime + ($stressCpu == null ? 43 : $stressCpu.hashCode());
        Object $stressMem = this.getStressMem();
        result = result * prime + ($stressMem == null ? 43 : $stressMem.hashCode());
        Object $userDefined = this.getUserDefined();
        result = result * prime + ($userDefined == null ? 43 : $userDefined.hashCode());
        Object $vm = this.getVm();
        result = result * prime + ($vm == null ? 43 : $vm.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExpInfo(" + "clock=" + this.getClock() + ", diskFill=" + this.getDiskFill() + ", diskReadPayload=" + this.getDiskReadPayload() + ", diskWritePayload=" + this.getDiskWritePayload() + ", fileAppend=" + this.getFileAppend() + ", fileCreate=" + this.getFileCreate() + ", fileDelete=" + this.getFileDelete() + ", fileModify=" + this.getFileModify() + ", fileRename=" + this.getFileRename() + ", fileReplace=" + this.getFileReplace() + ", httpAbort=" + this.getHttpAbort() + ", httpConfig=" + this.getHttpConfig() + ", httpDelay=" + this.getHttpDelay() + ", httpRequest=" + this.getHttpRequest() + ", jvmException=" + this.getJvmException() + ", jvmGc=" + this.getJvmGc() + ", jvmLatency=" + this.getJvmLatency() + ", jvmMysql=" + this.getJvmMysql() + ", jvmReturn=" + this.getJvmReturn() + ", jvmRuleData=" + this.getJvmRuleData() + ", jvmStress=" + this.getJvmStress() + ", kafkaFill=" + this.getKafkaFill() + ", kafkaFlood=" + this.getKafkaFlood() + ", kafkaIo=" + this.getKafkaIo() + ", networkBandwidth=" + this.getNetworkBandwidth() + ", networkCorrupt=" + this.getNetworkCorrupt() + ", networkDelay=" + this.getNetworkDelay() + ", networkDns=" + this.getNetworkDns() + ", networkDown=" + this.getNetworkDown() + ", networkDuplicate=" + this.getNetworkDuplicate() + ", networkFlood=" + this.getNetworkFlood() + ", networkLoss=" + this.getNetworkLoss() + ", networkPartition=" + this.getNetworkPartition() + ", process=" + this.getProcess() + ", redisCacheLimit=" + this.getRedisCacheLimit() + ", redisExpiration=" + this.getRedisExpiration() + ", redisPenetration=" + this.getRedisPenetration() + ", redisRestart=" + this.getRedisRestart() + ", redisStop=" + this.getRedisStop() + ", stressCpu=" + this.getStressCpu() + ", stressMem=" + this.getStressMem() + ", userDefined=" + this.getUserDefined() + ", vm=" + this.getVm() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}

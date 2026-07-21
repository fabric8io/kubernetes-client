package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ExpInfoFluent<A extends io.fabric8.chaosmesh.v1alpha1.ExpInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClockSpecBuilder clock;
  private DiskFillSpecBuilder diskFill;
  private DiskPayloadSpecBuilder diskReadPayload;
  private DiskPayloadSpecBuilder diskWritePayload;
  private FileAppendSpecBuilder fileAppend;
  private FileCreateSpecBuilder fileCreate;
  private FileDeleteSpecBuilder fileDelete;
  private FileModifyPrivilegeSpecBuilder fileModify;
  private FileRenameSpecBuilder fileRename;
  private FileReplaceSpecBuilder fileReplace;
  private HTTPAbortSpecBuilder httpAbort;
  private HTTPConfigSpecBuilder httpConfig;
  private HTTPDelaySpecBuilder httpDelay;
  private HTTPRequestSpecBuilder httpRequest;
  private JVMExceptionSpecBuilder jvmException;
  private JVMGCSpecBuilder jvmGc;
  private JVMLatencySpecBuilder jvmLatency;
  private PMJVMMySQLSpecBuilder jvmMysql;
  private JVMReturnSpecBuilder jvmReturn;
  private JVMRuleDataSpecBuilder jvmRuleData;
  private JVMStressSpecBuilder jvmStress;
  private KafkaFillSpecBuilder kafkaFill;
  private KafkaFloodSpecBuilder kafkaFlood;
  private KafkaIOSpecBuilder kafkaIo;
  private NetworkBandwidthSpecBuilder networkBandwidth;
  private NetworkCorruptSpecBuilder networkCorrupt;
  private NetworkDelaySpecBuilder networkDelay;
  private NetworkDNSSpecBuilder networkDns;
  private NetworkDownSpecBuilder networkDown;
  private NetworkDuplicateSpecBuilder networkDuplicate;
  private NetworkFloodSpecBuilder networkFlood;
  private NetworkLossSpecBuilder networkLoss;
  private NetworkPartitionSpecBuilder networkPartition;
  private ProcessSpecBuilder process;
  private RedisCacheLimitSpecBuilder redisCacheLimit;
  private RedisExpirationSpecBuilder redisExpiration;
  private RedisPenetrationSpecBuilder redisPenetration;
  private RedisSentinelRestartSpecBuilder redisRestart;
  private RedisSentinelStopSpecBuilder redisStop;
  private StressCPUSpecBuilder stressCpu;
  private StressMemorySpecBuilder stressMem;
  private UserDefinedSpecBuilder userDefined;
  private VMSpecBuilder vm;

  public ExpInfoFluent() {
  }
  
  public ExpInfoFluent(ExpInfo instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public ClockSpec buildClock() {
    return this.clock != null ? this.clock.build() : null;
  }
  
  public DiskFillSpec buildDiskFill() {
    return this.diskFill != null ? this.diskFill.build() : null;
  }
  
  public DiskPayloadSpec buildDiskReadPayload() {
    return this.diskReadPayload != null ? this.diskReadPayload.build() : null;
  }
  
  public DiskPayloadSpec buildDiskWritePayload() {
    return this.diskWritePayload != null ? this.diskWritePayload.build() : null;
  }
  
  public FileAppendSpec buildFileAppend() {
    return this.fileAppend != null ? this.fileAppend.build() : null;
  }
  
  public FileCreateSpec buildFileCreate() {
    return this.fileCreate != null ? this.fileCreate.build() : null;
  }
  
  public FileDeleteSpec buildFileDelete() {
    return this.fileDelete != null ? this.fileDelete.build() : null;
  }
  
  public FileModifyPrivilegeSpec buildFileModify() {
    return this.fileModify != null ? this.fileModify.build() : null;
  }
  
  public FileRenameSpec buildFileRename() {
    return this.fileRename != null ? this.fileRename.build() : null;
  }
  
  public FileReplaceSpec buildFileReplace() {
    return this.fileReplace != null ? this.fileReplace.build() : null;
  }
  
  public HTTPAbortSpec buildHttpAbort() {
    return this.httpAbort != null ? this.httpAbort.build() : null;
  }
  
  public HTTPConfigSpec buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  public HTTPDelaySpec buildHttpDelay() {
    return this.httpDelay != null ? this.httpDelay.build() : null;
  }
  
  public HTTPRequestSpec buildHttpRequest() {
    return this.httpRequest != null ? this.httpRequest.build() : null;
  }
  
  public JVMExceptionSpec buildJvmException() {
    return this.jvmException != null ? this.jvmException.build() : null;
  }
  
  public JVMGCSpec buildJvmGc() {
    return this.jvmGc != null ? this.jvmGc.build() : null;
  }
  
  public JVMLatencySpec buildJvmLatency() {
    return this.jvmLatency != null ? this.jvmLatency.build() : null;
  }
  
  public PMJVMMySQLSpec buildJvmMysql() {
    return this.jvmMysql != null ? this.jvmMysql.build() : null;
  }
  
  public JVMReturnSpec buildJvmReturn() {
    return this.jvmReturn != null ? this.jvmReturn.build() : null;
  }
  
  public JVMRuleDataSpec buildJvmRuleData() {
    return this.jvmRuleData != null ? this.jvmRuleData.build() : null;
  }
  
  public JVMStressSpec buildJvmStress() {
    return this.jvmStress != null ? this.jvmStress.build() : null;
  }
  
  public KafkaFillSpec buildKafkaFill() {
    return this.kafkaFill != null ? this.kafkaFill.build() : null;
  }
  
  public KafkaFloodSpec buildKafkaFlood() {
    return this.kafkaFlood != null ? this.kafkaFlood.build() : null;
  }
  
  public KafkaIOSpec buildKafkaIo() {
    return this.kafkaIo != null ? this.kafkaIo.build() : null;
  }
  
  public NetworkBandwidthSpec buildNetworkBandwidth() {
    return this.networkBandwidth != null ? this.networkBandwidth.build() : null;
  }
  
  public NetworkCorruptSpec buildNetworkCorrupt() {
    return this.networkCorrupt != null ? this.networkCorrupt.build() : null;
  }
  
  public NetworkDelaySpec buildNetworkDelay() {
    return this.networkDelay != null ? this.networkDelay.build() : null;
  }
  
  public NetworkDNSSpec buildNetworkDns() {
    return this.networkDns != null ? this.networkDns.build() : null;
  }
  
  public NetworkDownSpec buildNetworkDown() {
    return this.networkDown != null ? this.networkDown.build() : null;
  }
  
  public NetworkDuplicateSpec buildNetworkDuplicate() {
    return this.networkDuplicate != null ? this.networkDuplicate.build() : null;
  }
  
  public NetworkFloodSpec buildNetworkFlood() {
    return this.networkFlood != null ? this.networkFlood.build() : null;
  }
  
  public NetworkLossSpec buildNetworkLoss() {
    return this.networkLoss != null ? this.networkLoss.build() : null;
  }
  
  public NetworkPartitionSpec buildNetworkPartition() {
    return this.networkPartition != null ? this.networkPartition.build() : null;
  }
  
  public ProcessSpec buildProcess() {
    return this.process != null ? this.process.build() : null;
  }
  
  public RedisCacheLimitSpec buildRedisCacheLimit() {
    return this.redisCacheLimit != null ? this.redisCacheLimit.build() : null;
  }
  
  public RedisExpirationSpec buildRedisExpiration() {
    return this.redisExpiration != null ? this.redisExpiration.build() : null;
  }
  
  public RedisPenetrationSpec buildRedisPenetration() {
    return this.redisPenetration != null ? this.redisPenetration.build() : null;
  }
  
  public RedisSentinelRestartSpec buildRedisRestart() {
    return this.redisRestart != null ? this.redisRestart.build() : null;
  }
  
  public RedisSentinelStopSpec buildRedisStop() {
    return this.redisStop != null ? this.redisStop.build() : null;
  }
  
  public StressCPUSpec buildStressCpu() {
    return this.stressCpu != null ? this.stressCpu.build() : null;
  }
  
  public StressMemorySpec buildStressMem() {
    return this.stressMem != null ? this.stressMem.build() : null;
  }
  
  public UserDefinedSpec buildUserDefined() {
    return this.userDefined != null ? this.userDefined.build() : null;
  }
  
  public VMSpec buildVm() {
    return this.vm != null ? this.vm.build() : null;
  }
  
  protected void copyInstance(ExpInfo instance) {
    instance = instance != null ? instance : new ExpInfo();
    if (instance != null) {
        this.withClock(instance.getClock());
        this.withDiskFill(instance.getDiskFill());
        this.withDiskReadPayload(instance.getDiskReadPayload());
        this.withDiskWritePayload(instance.getDiskWritePayload());
        this.withFileAppend(instance.getFileAppend());
        this.withFileCreate(instance.getFileCreate());
        this.withFileDelete(instance.getFileDelete());
        this.withFileModify(instance.getFileModify());
        this.withFileRename(instance.getFileRename());
        this.withFileReplace(instance.getFileReplace());
        this.withHttpAbort(instance.getHttpAbort());
        this.withHttpConfig(instance.getHttpConfig());
        this.withHttpDelay(instance.getHttpDelay());
        this.withHttpRequest(instance.getHttpRequest());
        this.withJvmException(instance.getJvmException());
        this.withJvmGc(instance.getJvmGc());
        this.withJvmLatency(instance.getJvmLatency());
        this.withJvmMysql(instance.getJvmMysql());
        this.withJvmReturn(instance.getJvmReturn());
        this.withJvmRuleData(instance.getJvmRuleData());
        this.withJvmStress(instance.getJvmStress());
        this.withKafkaFill(instance.getKafkaFill());
        this.withKafkaFlood(instance.getKafkaFlood());
        this.withKafkaIo(instance.getKafkaIo());
        this.withNetworkBandwidth(instance.getNetworkBandwidth());
        this.withNetworkCorrupt(instance.getNetworkCorrupt());
        this.withNetworkDelay(instance.getNetworkDelay());
        this.withNetworkDns(instance.getNetworkDns());
        this.withNetworkDown(instance.getNetworkDown());
        this.withNetworkDuplicate(instance.getNetworkDuplicate());
        this.withNetworkFlood(instance.getNetworkFlood());
        this.withNetworkLoss(instance.getNetworkLoss());
        this.withNetworkPartition(instance.getNetworkPartition());
        this.withProcess(instance.getProcess());
        this.withRedisCacheLimit(instance.getRedisCacheLimit());
        this.withRedisExpiration(instance.getRedisExpiration());
        this.withRedisPenetration(instance.getRedisPenetration());
        this.withRedisRestart(instance.getRedisRestart());
        this.withRedisStop(instance.getRedisStop());
        this.withStressCpu(instance.getStressCpu());
        this.withStressMem(instance.getStressMem());
        this.withUserDefined(instance.getUserDefined());
        this.withVm(instance.getVm());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClockNested<A> editClock() {
    return this.withNewClockLike(Optional.ofNullable(this.buildClock()).orElse(null));
  }
  
  public DiskFillNested<A> editDiskFill() {
    return this.withNewDiskFillLike(Optional.ofNullable(this.buildDiskFill()).orElse(null));
  }
  
  public DiskReadPayloadNested<A> editDiskReadPayload() {
    return this.withNewDiskReadPayloadLike(Optional.ofNullable(this.buildDiskReadPayload()).orElse(null));
  }
  
  public DiskWritePayloadNested<A> editDiskWritePayload() {
    return this.withNewDiskWritePayloadLike(Optional.ofNullable(this.buildDiskWritePayload()).orElse(null));
  }
  
  public FileAppendNested<A> editFileAppend() {
    return this.withNewFileAppendLike(Optional.ofNullable(this.buildFileAppend()).orElse(null));
  }
  
  public FileCreateNested<A> editFileCreate() {
    return this.withNewFileCreateLike(Optional.ofNullable(this.buildFileCreate()).orElse(null));
  }
  
  public FileDeleteNested<A> editFileDelete() {
    return this.withNewFileDeleteLike(Optional.ofNullable(this.buildFileDelete()).orElse(null));
  }
  
  public FileModifyNested<A> editFileModify() {
    return this.withNewFileModifyLike(Optional.ofNullable(this.buildFileModify()).orElse(null));
  }
  
  public FileRenameNested<A> editFileRename() {
    return this.withNewFileRenameLike(Optional.ofNullable(this.buildFileRename()).orElse(null));
  }
  
  public FileReplaceNested<A> editFileReplace() {
    return this.withNewFileReplaceLike(Optional.ofNullable(this.buildFileReplace()).orElse(null));
  }
  
  public HttpAbortNested<A> editHttpAbort() {
    return this.withNewHttpAbortLike(Optional.ofNullable(this.buildHttpAbort()).orElse(null));
  }
  
  public HttpConfigNested<A> editHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(null));
  }
  
  public HttpDelayNested<A> editHttpDelay() {
    return this.withNewHttpDelayLike(Optional.ofNullable(this.buildHttpDelay()).orElse(null));
  }
  
  public HttpRequestNested<A> editHttpRequest() {
    return this.withNewHttpRequestLike(Optional.ofNullable(this.buildHttpRequest()).orElse(null));
  }
  
  public JvmExceptionNested<A> editJvmException() {
    return this.withNewJvmExceptionLike(Optional.ofNullable(this.buildJvmException()).orElse(null));
  }
  
  public JvmGcNested<A> editJvmGc() {
    return this.withNewJvmGcLike(Optional.ofNullable(this.buildJvmGc()).orElse(null));
  }
  
  public JvmLatencyNested<A> editJvmLatency() {
    return this.withNewJvmLatencyLike(Optional.ofNullable(this.buildJvmLatency()).orElse(null));
  }
  
  public JvmMysqlNested<A> editJvmMysql() {
    return this.withNewJvmMysqlLike(Optional.ofNullable(this.buildJvmMysql()).orElse(null));
  }
  
  public JvmReturnNested<A> editJvmReturn() {
    return this.withNewJvmReturnLike(Optional.ofNullable(this.buildJvmReturn()).orElse(null));
  }
  
  public JvmRuleDataNested<A> editJvmRuleData() {
    return this.withNewJvmRuleDataLike(Optional.ofNullable(this.buildJvmRuleData()).orElse(null));
  }
  
  public JvmStressNested<A> editJvmStress() {
    return this.withNewJvmStressLike(Optional.ofNullable(this.buildJvmStress()).orElse(null));
  }
  
  public KafkaFillNested<A> editKafkaFill() {
    return this.withNewKafkaFillLike(Optional.ofNullable(this.buildKafkaFill()).orElse(null));
  }
  
  public KafkaFloodNested<A> editKafkaFlood() {
    return this.withNewKafkaFloodLike(Optional.ofNullable(this.buildKafkaFlood()).orElse(null));
  }
  
  public KafkaIoNested<A> editKafkaIo() {
    return this.withNewKafkaIoLike(Optional.ofNullable(this.buildKafkaIo()).orElse(null));
  }
  
  public NetworkBandwidthNested<A> editNetworkBandwidth() {
    return this.withNewNetworkBandwidthLike(Optional.ofNullable(this.buildNetworkBandwidth()).orElse(null));
  }
  
  public NetworkCorruptNested<A> editNetworkCorrupt() {
    return this.withNewNetworkCorruptLike(Optional.ofNullable(this.buildNetworkCorrupt()).orElse(null));
  }
  
  public NetworkDelayNested<A> editNetworkDelay() {
    return this.withNewNetworkDelayLike(Optional.ofNullable(this.buildNetworkDelay()).orElse(null));
  }
  
  public NetworkDnsNested<A> editNetworkDns() {
    return this.withNewNetworkDnsLike(Optional.ofNullable(this.buildNetworkDns()).orElse(null));
  }
  
  public NetworkDownNested<A> editNetworkDown() {
    return this.withNewNetworkDownLike(Optional.ofNullable(this.buildNetworkDown()).orElse(null));
  }
  
  public NetworkDuplicateNested<A> editNetworkDuplicate() {
    return this.withNewNetworkDuplicateLike(Optional.ofNullable(this.buildNetworkDuplicate()).orElse(null));
  }
  
  public NetworkFloodNested<A> editNetworkFlood() {
    return this.withNewNetworkFloodLike(Optional.ofNullable(this.buildNetworkFlood()).orElse(null));
  }
  
  public NetworkLossNested<A> editNetworkLoss() {
    return this.withNewNetworkLossLike(Optional.ofNullable(this.buildNetworkLoss()).orElse(null));
  }
  
  public NetworkPartitionNested<A> editNetworkPartition() {
    return this.withNewNetworkPartitionLike(Optional.ofNullable(this.buildNetworkPartition()).orElse(null));
  }
  
  public ClockNested<A> editOrNewClock() {
    return this.withNewClockLike(Optional.ofNullable(this.buildClock()).orElse(new ClockSpecBuilder().build()));
  }
  
  public ClockNested<A> editOrNewClockLike(ClockSpec item) {
    return this.withNewClockLike(Optional.ofNullable(this.buildClock()).orElse(item));
  }
  
  public DiskFillNested<A> editOrNewDiskFill() {
    return this.withNewDiskFillLike(Optional.ofNullable(this.buildDiskFill()).orElse(new DiskFillSpecBuilder().build()));
  }
  
  public DiskFillNested<A> editOrNewDiskFillLike(DiskFillSpec item) {
    return this.withNewDiskFillLike(Optional.ofNullable(this.buildDiskFill()).orElse(item));
  }
  
  public DiskReadPayloadNested<A> editOrNewDiskReadPayload() {
    return this.withNewDiskReadPayloadLike(Optional.ofNullable(this.buildDiskReadPayload()).orElse(new DiskPayloadSpecBuilder().build()));
  }
  
  public DiskReadPayloadNested<A> editOrNewDiskReadPayloadLike(DiskPayloadSpec item) {
    return this.withNewDiskReadPayloadLike(Optional.ofNullable(this.buildDiskReadPayload()).orElse(item));
  }
  
  public DiskWritePayloadNested<A> editOrNewDiskWritePayload() {
    return this.withNewDiskWritePayloadLike(Optional.ofNullable(this.buildDiskWritePayload()).orElse(new DiskPayloadSpecBuilder().build()));
  }
  
  public DiskWritePayloadNested<A> editOrNewDiskWritePayloadLike(DiskPayloadSpec item) {
    return this.withNewDiskWritePayloadLike(Optional.ofNullable(this.buildDiskWritePayload()).orElse(item));
  }
  
  public FileAppendNested<A> editOrNewFileAppend() {
    return this.withNewFileAppendLike(Optional.ofNullable(this.buildFileAppend()).orElse(new FileAppendSpecBuilder().build()));
  }
  
  public FileAppendNested<A> editOrNewFileAppendLike(FileAppendSpec item) {
    return this.withNewFileAppendLike(Optional.ofNullable(this.buildFileAppend()).orElse(item));
  }
  
  public FileCreateNested<A> editOrNewFileCreate() {
    return this.withNewFileCreateLike(Optional.ofNullable(this.buildFileCreate()).orElse(new FileCreateSpecBuilder().build()));
  }
  
  public FileCreateNested<A> editOrNewFileCreateLike(FileCreateSpec item) {
    return this.withNewFileCreateLike(Optional.ofNullable(this.buildFileCreate()).orElse(item));
  }
  
  public FileDeleteNested<A> editOrNewFileDelete() {
    return this.withNewFileDeleteLike(Optional.ofNullable(this.buildFileDelete()).orElse(new FileDeleteSpecBuilder().build()));
  }
  
  public FileDeleteNested<A> editOrNewFileDeleteLike(FileDeleteSpec item) {
    return this.withNewFileDeleteLike(Optional.ofNullable(this.buildFileDelete()).orElse(item));
  }
  
  public FileModifyNested<A> editOrNewFileModify() {
    return this.withNewFileModifyLike(Optional.ofNullable(this.buildFileModify()).orElse(new FileModifyPrivilegeSpecBuilder().build()));
  }
  
  public FileModifyNested<A> editOrNewFileModifyLike(FileModifyPrivilegeSpec item) {
    return this.withNewFileModifyLike(Optional.ofNullable(this.buildFileModify()).orElse(item));
  }
  
  public FileRenameNested<A> editOrNewFileRename() {
    return this.withNewFileRenameLike(Optional.ofNullable(this.buildFileRename()).orElse(new FileRenameSpecBuilder().build()));
  }
  
  public FileRenameNested<A> editOrNewFileRenameLike(FileRenameSpec item) {
    return this.withNewFileRenameLike(Optional.ofNullable(this.buildFileRename()).orElse(item));
  }
  
  public FileReplaceNested<A> editOrNewFileReplace() {
    return this.withNewFileReplaceLike(Optional.ofNullable(this.buildFileReplace()).orElse(new FileReplaceSpecBuilder().build()));
  }
  
  public FileReplaceNested<A> editOrNewFileReplaceLike(FileReplaceSpec item) {
    return this.withNewFileReplaceLike(Optional.ofNullable(this.buildFileReplace()).orElse(item));
  }
  
  public HttpAbortNested<A> editOrNewHttpAbort() {
    return this.withNewHttpAbortLike(Optional.ofNullable(this.buildHttpAbort()).orElse(new HTTPAbortSpecBuilder().build()));
  }
  
  public HttpAbortNested<A> editOrNewHttpAbortLike(HTTPAbortSpec item) {
    return this.withNewHttpAbortLike(Optional.ofNullable(this.buildHttpAbort()).orElse(item));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(new HTTPConfigSpecBuilder().build()));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfigLike(HTTPConfigSpec item) {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(item));
  }
  
  public HttpDelayNested<A> editOrNewHttpDelay() {
    return this.withNewHttpDelayLike(Optional.ofNullable(this.buildHttpDelay()).orElse(new HTTPDelaySpecBuilder().build()));
  }
  
  public HttpDelayNested<A> editOrNewHttpDelayLike(HTTPDelaySpec item) {
    return this.withNewHttpDelayLike(Optional.ofNullable(this.buildHttpDelay()).orElse(item));
  }
  
  public HttpRequestNested<A> editOrNewHttpRequest() {
    return this.withNewHttpRequestLike(Optional.ofNullable(this.buildHttpRequest()).orElse(new HTTPRequestSpecBuilder().build()));
  }
  
  public HttpRequestNested<A> editOrNewHttpRequestLike(HTTPRequestSpec item) {
    return this.withNewHttpRequestLike(Optional.ofNullable(this.buildHttpRequest()).orElse(item));
  }
  
  public JvmExceptionNested<A> editOrNewJvmException() {
    return this.withNewJvmExceptionLike(Optional.ofNullable(this.buildJvmException()).orElse(new JVMExceptionSpecBuilder().build()));
  }
  
  public JvmExceptionNested<A> editOrNewJvmExceptionLike(JVMExceptionSpec item) {
    return this.withNewJvmExceptionLike(Optional.ofNullable(this.buildJvmException()).orElse(item));
  }
  
  public JvmGcNested<A> editOrNewJvmGc() {
    return this.withNewJvmGcLike(Optional.ofNullable(this.buildJvmGc()).orElse(new JVMGCSpecBuilder().build()));
  }
  
  public JvmGcNested<A> editOrNewJvmGcLike(JVMGCSpec item) {
    return this.withNewJvmGcLike(Optional.ofNullable(this.buildJvmGc()).orElse(item));
  }
  
  public JvmLatencyNested<A> editOrNewJvmLatency() {
    return this.withNewJvmLatencyLike(Optional.ofNullable(this.buildJvmLatency()).orElse(new JVMLatencySpecBuilder().build()));
  }
  
  public JvmLatencyNested<A> editOrNewJvmLatencyLike(JVMLatencySpec item) {
    return this.withNewJvmLatencyLike(Optional.ofNullable(this.buildJvmLatency()).orElse(item));
  }
  
  public JvmMysqlNested<A> editOrNewJvmMysql() {
    return this.withNewJvmMysqlLike(Optional.ofNullable(this.buildJvmMysql()).orElse(new PMJVMMySQLSpecBuilder().build()));
  }
  
  public JvmMysqlNested<A> editOrNewJvmMysqlLike(PMJVMMySQLSpec item) {
    return this.withNewJvmMysqlLike(Optional.ofNullable(this.buildJvmMysql()).orElse(item));
  }
  
  public JvmReturnNested<A> editOrNewJvmReturn() {
    return this.withNewJvmReturnLike(Optional.ofNullable(this.buildJvmReturn()).orElse(new JVMReturnSpecBuilder().build()));
  }
  
  public JvmReturnNested<A> editOrNewJvmReturnLike(JVMReturnSpec item) {
    return this.withNewJvmReturnLike(Optional.ofNullable(this.buildJvmReturn()).orElse(item));
  }
  
  public JvmRuleDataNested<A> editOrNewJvmRuleData() {
    return this.withNewJvmRuleDataLike(Optional.ofNullable(this.buildJvmRuleData()).orElse(new JVMRuleDataSpecBuilder().build()));
  }
  
  public JvmRuleDataNested<A> editOrNewJvmRuleDataLike(JVMRuleDataSpec item) {
    return this.withNewJvmRuleDataLike(Optional.ofNullable(this.buildJvmRuleData()).orElse(item));
  }
  
  public JvmStressNested<A> editOrNewJvmStress() {
    return this.withNewJvmStressLike(Optional.ofNullable(this.buildJvmStress()).orElse(new JVMStressSpecBuilder().build()));
  }
  
  public JvmStressNested<A> editOrNewJvmStressLike(JVMStressSpec item) {
    return this.withNewJvmStressLike(Optional.ofNullable(this.buildJvmStress()).orElse(item));
  }
  
  public KafkaFillNested<A> editOrNewKafkaFill() {
    return this.withNewKafkaFillLike(Optional.ofNullable(this.buildKafkaFill()).orElse(new KafkaFillSpecBuilder().build()));
  }
  
  public KafkaFillNested<A> editOrNewKafkaFillLike(KafkaFillSpec item) {
    return this.withNewKafkaFillLike(Optional.ofNullable(this.buildKafkaFill()).orElse(item));
  }
  
  public KafkaFloodNested<A> editOrNewKafkaFlood() {
    return this.withNewKafkaFloodLike(Optional.ofNullable(this.buildKafkaFlood()).orElse(new KafkaFloodSpecBuilder().build()));
  }
  
  public KafkaFloodNested<A> editOrNewKafkaFloodLike(KafkaFloodSpec item) {
    return this.withNewKafkaFloodLike(Optional.ofNullable(this.buildKafkaFlood()).orElse(item));
  }
  
  public KafkaIoNested<A> editOrNewKafkaIo() {
    return this.withNewKafkaIoLike(Optional.ofNullable(this.buildKafkaIo()).orElse(new KafkaIOSpecBuilder().build()));
  }
  
  public KafkaIoNested<A> editOrNewKafkaIoLike(KafkaIOSpec item) {
    return this.withNewKafkaIoLike(Optional.ofNullable(this.buildKafkaIo()).orElse(item));
  }
  
  public NetworkBandwidthNested<A> editOrNewNetworkBandwidth() {
    return this.withNewNetworkBandwidthLike(Optional.ofNullable(this.buildNetworkBandwidth()).orElse(new NetworkBandwidthSpecBuilder().build()));
  }
  
  public NetworkBandwidthNested<A> editOrNewNetworkBandwidthLike(NetworkBandwidthSpec item) {
    return this.withNewNetworkBandwidthLike(Optional.ofNullable(this.buildNetworkBandwidth()).orElse(item));
  }
  
  public NetworkCorruptNested<A> editOrNewNetworkCorrupt() {
    return this.withNewNetworkCorruptLike(Optional.ofNullable(this.buildNetworkCorrupt()).orElse(new NetworkCorruptSpecBuilder().build()));
  }
  
  public NetworkCorruptNested<A> editOrNewNetworkCorruptLike(NetworkCorruptSpec item) {
    return this.withNewNetworkCorruptLike(Optional.ofNullable(this.buildNetworkCorrupt()).orElse(item));
  }
  
  public NetworkDelayNested<A> editOrNewNetworkDelay() {
    return this.withNewNetworkDelayLike(Optional.ofNullable(this.buildNetworkDelay()).orElse(new NetworkDelaySpecBuilder().build()));
  }
  
  public NetworkDelayNested<A> editOrNewNetworkDelayLike(NetworkDelaySpec item) {
    return this.withNewNetworkDelayLike(Optional.ofNullable(this.buildNetworkDelay()).orElse(item));
  }
  
  public NetworkDnsNested<A> editOrNewNetworkDns() {
    return this.withNewNetworkDnsLike(Optional.ofNullable(this.buildNetworkDns()).orElse(new NetworkDNSSpecBuilder().build()));
  }
  
  public NetworkDnsNested<A> editOrNewNetworkDnsLike(NetworkDNSSpec item) {
    return this.withNewNetworkDnsLike(Optional.ofNullable(this.buildNetworkDns()).orElse(item));
  }
  
  public NetworkDownNested<A> editOrNewNetworkDown() {
    return this.withNewNetworkDownLike(Optional.ofNullable(this.buildNetworkDown()).orElse(new NetworkDownSpecBuilder().build()));
  }
  
  public NetworkDownNested<A> editOrNewNetworkDownLike(NetworkDownSpec item) {
    return this.withNewNetworkDownLike(Optional.ofNullable(this.buildNetworkDown()).orElse(item));
  }
  
  public NetworkDuplicateNested<A> editOrNewNetworkDuplicate() {
    return this.withNewNetworkDuplicateLike(Optional.ofNullable(this.buildNetworkDuplicate()).orElse(new NetworkDuplicateSpecBuilder().build()));
  }
  
  public NetworkDuplicateNested<A> editOrNewNetworkDuplicateLike(NetworkDuplicateSpec item) {
    return this.withNewNetworkDuplicateLike(Optional.ofNullable(this.buildNetworkDuplicate()).orElse(item));
  }
  
  public NetworkFloodNested<A> editOrNewNetworkFlood() {
    return this.withNewNetworkFloodLike(Optional.ofNullable(this.buildNetworkFlood()).orElse(new NetworkFloodSpecBuilder().build()));
  }
  
  public NetworkFloodNested<A> editOrNewNetworkFloodLike(NetworkFloodSpec item) {
    return this.withNewNetworkFloodLike(Optional.ofNullable(this.buildNetworkFlood()).orElse(item));
  }
  
  public NetworkLossNested<A> editOrNewNetworkLoss() {
    return this.withNewNetworkLossLike(Optional.ofNullable(this.buildNetworkLoss()).orElse(new NetworkLossSpecBuilder().build()));
  }
  
  public NetworkLossNested<A> editOrNewNetworkLossLike(NetworkLossSpec item) {
    return this.withNewNetworkLossLike(Optional.ofNullable(this.buildNetworkLoss()).orElse(item));
  }
  
  public NetworkPartitionNested<A> editOrNewNetworkPartition() {
    return this.withNewNetworkPartitionLike(Optional.ofNullable(this.buildNetworkPartition()).orElse(new NetworkPartitionSpecBuilder().build()));
  }
  
  public NetworkPartitionNested<A> editOrNewNetworkPartitionLike(NetworkPartitionSpec item) {
    return this.withNewNetworkPartitionLike(Optional.ofNullable(this.buildNetworkPartition()).orElse(item));
  }
  
  public ProcessNested<A> editOrNewProcess() {
    return this.withNewProcessLike(Optional.ofNullable(this.buildProcess()).orElse(new ProcessSpecBuilder().build()));
  }
  
  public ProcessNested<A> editOrNewProcessLike(ProcessSpec item) {
    return this.withNewProcessLike(Optional.ofNullable(this.buildProcess()).orElse(item));
  }
  
  public RedisCacheLimitNested<A> editOrNewRedisCacheLimit() {
    return this.withNewRedisCacheLimitLike(Optional.ofNullable(this.buildRedisCacheLimit()).orElse(new RedisCacheLimitSpecBuilder().build()));
  }
  
  public RedisCacheLimitNested<A> editOrNewRedisCacheLimitLike(RedisCacheLimitSpec item) {
    return this.withNewRedisCacheLimitLike(Optional.ofNullable(this.buildRedisCacheLimit()).orElse(item));
  }
  
  public RedisExpirationNested<A> editOrNewRedisExpiration() {
    return this.withNewRedisExpirationLike(Optional.ofNullable(this.buildRedisExpiration()).orElse(new RedisExpirationSpecBuilder().build()));
  }
  
  public RedisExpirationNested<A> editOrNewRedisExpirationLike(RedisExpirationSpec item) {
    return this.withNewRedisExpirationLike(Optional.ofNullable(this.buildRedisExpiration()).orElse(item));
  }
  
  public RedisPenetrationNested<A> editOrNewRedisPenetration() {
    return this.withNewRedisPenetrationLike(Optional.ofNullable(this.buildRedisPenetration()).orElse(new RedisPenetrationSpecBuilder().build()));
  }
  
  public RedisPenetrationNested<A> editOrNewRedisPenetrationLike(RedisPenetrationSpec item) {
    return this.withNewRedisPenetrationLike(Optional.ofNullable(this.buildRedisPenetration()).orElse(item));
  }
  
  public RedisRestartNested<A> editOrNewRedisRestart() {
    return this.withNewRedisRestartLike(Optional.ofNullable(this.buildRedisRestart()).orElse(new RedisSentinelRestartSpecBuilder().build()));
  }
  
  public RedisRestartNested<A> editOrNewRedisRestartLike(RedisSentinelRestartSpec item) {
    return this.withNewRedisRestartLike(Optional.ofNullable(this.buildRedisRestart()).orElse(item));
  }
  
  public RedisStopNested<A> editOrNewRedisStop() {
    return this.withNewRedisStopLike(Optional.ofNullable(this.buildRedisStop()).orElse(new RedisSentinelStopSpecBuilder().build()));
  }
  
  public RedisStopNested<A> editOrNewRedisStopLike(RedisSentinelStopSpec item) {
    return this.withNewRedisStopLike(Optional.ofNullable(this.buildRedisStop()).orElse(item));
  }
  
  public StressCpuNested<A> editOrNewStressCpu() {
    return this.withNewStressCpuLike(Optional.ofNullable(this.buildStressCpu()).orElse(new StressCPUSpecBuilder().build()));
  }
  
  public StressCpuNested<A> editOrNewStressCpuLike(StressCPUSpec item) {
    return this.withNewStressCpuLike(Optional.ofNullable(this.buildStressCpu()).orElse(item));
  }
  
  public StressMemNested<A> editOrNewStressMem() {
    return this.withNewStressMemLike(Optional.ofNullable(this.buildStressMem()).orElse(new StressMemorySpecBuilder().build()));
  }
  
  public StressMemNested<A> editOrNewStressMemLike(StressMemorySpec item) {
    return this.withNewStressMemLike(Optional.ofNullable(this.buildStressMem()).orElse(item));
  }
  
  public UserDefinedNested<A> editOrNewUserDefined() {
    return this.withNewUserDefinedLike(Optional.ofNullable(this.buildUserDefined()).orElse(new UserDefinedSpecBuilder().build()));
  }
  
  public UserDefinedNested<A> editOrNewUserDefinedLike(UserDefinedSpec item) {
    return this.withNewUserDefinedLike(Optional.ofNullable(this.buildUserDefined()).orElse(item));
  }
  
  public VmNested<A> editOrNewVm() {
    return this.withNewVmLike(Optional.ofNullable(this.buildVm()).orElse(new VMSpecBuilder().build()));
  }
  
  public VmNested<A> editOrNewVmLike(VMSpec item) {
    return this.withNewVmLike(Optional.ofNullable(this.buildVm()).orElse(item));
  }
  
  public ProcessNested<A> editProcess() {
    return this.withNewProcessLike(Optional.ofNullable(this.buildProcess()).orElse(null));
  }
  
  public RedisCacheLimitNested<A> editRedisCacheLimit() {
    return this.withNewRedisCacheLimitLike(Optional.ofNullable(this.buildRedisCacheLimit()).orElse(null));
  }
  
  public RedisExpirationNested<A> editRedisExpiration() {
    return this.withNewRedisExpirationLike(Optional.ofNullable(this.buildRedisExpiration()).orElse(null));
  }
  
  public RedisPenetrationNested<A> editRedisPenetration() {
    return this.withNewRedisPenetrationLike(Optional.ofNullable(this.buildRedisPenetration()).orElse(null));
  }
  
  public RedisRestartNested<A> editRedisRestart() {
    return this.withNewRedisRestartLike(Optional.ofNullable(this.buildRedisRestart()).orElse(null));
  }
  
  public RedisStopNested<A> editRedisStop() {
    return this.withNewRedisStopLike(Optional.ofNullable(this.buildRedisStop()).orElse(null));
  }
  
  public StressCpuNested<A> editStressCpu() {
    return this.withNewStressCpuLike(Optional.ofNullable(this.buildStressCpu()).orElse(null));
  }
  
  public StressMemNested<A> editStressMem() {
    return this.withNewStressMemLike(Optional.ofNullable(this.buildStressMem()).orElse(null));
  }
  
  public UserDefinedNested<A> editUserDefined() {
    return this.withNewUserDefinedLike(Optional.ofNullable(this.buildUserDefined()).orElse(null));
  }
  
  public VmNested<A> editVm() {
    return this.withNewVmLike(Optional.ofNullable(this.buildVm()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ExpInfoFluent that = (ExpInfoFluent) o;
    if (!(Objects.equals(clock, that.clock))) {
      return false;
    }
    if (!(Objects.equals(diskFill, that.diskFill))) {
      return false;
    }
    if (!(Objects.equals(diskReadPayload, that.diskReadPayload))) {
      return false;
    }
    if (!(Objects.equals(diskWritePayload, that.diskWritePayload))) {
      return false;
    }
    if (!(Objects.equals(fileAppend, that.fileAppend))) {
      return false;
    }
    if (!(Objects.equals(fileCreate, that.fileCreate))) {
      return false;
    }
    if (!(Objects.equals(fileDelete, that.fileDelete))) {
      return false;
    }
    if (!(Objects.equals(fileModify, that.fileModify))) {
      return false;
    }
    if (!(Objects.equals(fileRename, that.fileRename))) {
      return false;
    }
    if (!(Objects.equals(fileReplace, that.fileReplace))) {
      return false;
    }
    if (!(Objects.equals(httpAbort, that.httpAbort))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(httpDelay, that.httpDelay))) {
      return false;
    }
    if (!(Objects.equals(httpRequest, that.httpRequest))) {
      return false;
    }
    if (!(Objects.equals(jvmException, that.jvmException))) {
      return false;
    }
    if (!(Objects.equals(jvmGc, that.jvmGc))) {
      return false;
    }
    if (!(Objects.equals(jvmLatency, that.jvmLatency))) {
      return false;
    }
    if (!(Objects.equals(jvmMysql, that.jvmMysql))) {
      return false;
    }
    if (!(Objects.equals(jvmReturn, that.jvmReturn))) {
      return false;
    }
    if (!(Objects.equals(jvmRuleData, that.jvmRuleData))) {
      return false;
    }
    if (!(Objects.equals(jvmStress, that.jvmStress))) {
      return false;
    }
    if (!(Objects.equals(kafkaFill, that.kafkaFill))) {
      return false;
    }
    if (!(Objects.equals(kafkaFlood, that.kafkaFlood))) {
      return false;
    }
    if (!(Objects.equals(kafkaIo, that.kafkaIo))) {
      return false;
    }
    if (!(Objects.equals(networkBandwidth, that.networkBandwidth))) {
      return false;
    }
    if (!(Objects.equals(networkCorrupt, that.networkCorrupt))) {
      return false;
    }
    if (!(Objects.equals(networkDelay, that.networkDelay))) {
      return false;
    }
    if (!(Objects.equals(networkDns, that.networkDns))) {
      return false;
    }
    if (!(Objects.equals(networkDown, that.networkDown))) {
      return false;
    }
    if (!(Objects.equals(networkDuplicate, that.networkDuplicate))) {
      return false;
    }
    if (!(Objects.equals(networkFlood, that.networkFlood))) {
      return false;
    }
    if (!(Objects.equals(networkLoss, that.networkLoss))) {
      return false;
    }
    if (!(Objects.equals(networkPartition, that.networkPartition))) {
      return false;
    }
    if (!(Objects.equals(process, that.process))) {
      return false;
    }
    if (!(Objects.equals(redisCacheLimit, that.redisCacheLimit))) {
      return false;
    }
    if (!(Objects.equals(redisExpiration, that.redisExpiration))) {
      return false;
    }
    if (!(Objects.equals(redisPenetration, that.redisPenetration))) {
      return false;
    }
    if (!(Objects.equals(redisRestart, that.redisRestart))) {
      return false;
    }
    if (!(Objects.equals(redisStop, that.redisStop))) {
      return false;
    }
    if (!(Objects.equals(stressCpu, that.stressCpu))) {
      return false;
    }
    if (!(Objects.equals(stressMem, that.stressMem))) {
      return false;
    }
    if (!(Objects.equals(userDefined, that.userDefined))) {
      return false;
    }
    if (!(Objects.equals(vm, that.vm))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClock() {
    return this.clock != null;
  }
  
  public boolean hasDiskFill() {
    return this.diskFill != null;
  }
  
  public boolean hasDiskReadPayload() {
    return this.diskReadPayload != null;
  }
  
  public boolean hasDiskWritePayload() {
    return this.diskWritePayload != null;
  }
  
  public boolean hasFileAppend() {
    return this.fileAppend != null;
  }
  
  public boolean hasFileCreate() {
    return this.fileCreate != null;
  }
  
  public boolean hasFileDelete() {
    return this.fileDelete != null;
  }
  
  public boolean hasFileModify() {
    return this.fileModify != null;
  }
  
  public boolean hasFileRename() {
    return this.fileRename != null;
  }
  
  public boolean hasFileReplace() {
    return this.fileReplace != null;
  }
  
  public boolean hasHttpAbort() {
    return this.httpAbort != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasHttpDelay() {
    return this.httpDelay != null;
  }
  
  public boolean hasHttpRequest() {
    return this.httpRequest != null;
  }
  
  public boolean hasJvmException() {
    return this.jvmException != null;
  }
  
  public boolean hasJvmGc() {
    return this.jvmGc != null;
  }
  
  public boolean hasJvmLatency() {
    return this.jvmLatency != null;
  }
  
  public boolean hasJvmMysql() {
    return this.jvmMysql != null;
  }
  
  public boolean hasJvmReturn() {
    return this.jvmReturn != null;
  }
  
  public boolean hasJvmRuleData() {
    return this.jvmRuleData != null;
  }
  
  public boolean hasJvmStress() {
    return this.jvmStress != null;
  }
  
  public boolean hasKafkaFill() {
    return this.kafkaFill != null;
  }
  
  public boolean hasKafkaFlood() {
    return this.kafkaFlood != null;
  }
  
  public boolean hasKafkaIo() {
    return this.kafkaIo != null;
  }
  
  public boolean hasNetworkBandwidth() {
    return this.networkBandwidth != null;
  }
  
  public boolean hasNetworkCorrupt() {
    return this.networkCorrupt != null;
  }
  
  public boolean hasNetworkDelay() {
    return this.networkDelay != null;
  }
  
  public boolean hasNetworkDns() {
    return this.networkDns != null;
  }
  
  public boolean hasNetworkDown() {
    return this.networkDown != null;
  }
  
  public boolean hasNetworkDuplicate() {
    return this.networkDuplicate != null;
  }
  
  public boolean hasNetworkFlood() {
    return this.networkFlood != null;
  }
  
  public boolean hasNetworkLoss() {
    return this.networkLoss != null;
  }
  
  public boolean hasNetworkPartition() {
    return this.networkPartition != null;
  }
  
  public boolean hasProcess() {
    return this.process != null;
  }
  
  public boolean hasRedisCacheLimit() {
    return this.redisCacheLimit != null;
  }
  
  public boolean hasRedisExpiration() {
    return this.redisExpiration != null;
  }
  
  public boolean hasRedisPenetration() {
    return this.redisPenetration != null;
  }
  
  public boolean hasRedisRestart() {
    return this.redisRestart != null;
  }
  
  public boolean hasRedisStop() {
    return this.redisStop != null;
  }
  
  public boolean hasStressCpu() {
    return this.stressCpu != null;
  }
  
  public boolean hasStressMem() {
    return this.stressMem != null;
  }
  
  public boolean hasUserDefined() {
    return this.userDefined != null;
  }
  
  public boolean hasVm() {
    return this.vm != null;
  }
  
  public int hashCode() {
    return Objects.hash(clock, diskFill, diskReadPayload, diskWritePayload, fileAppend, fileCreate, fileDelete, fileModify, fileRename, fileReplace, httpAbort, httpConfig, httpDelay, httpRequest, jvmException, jvmGc, jvmLatency, jvmMysql, jvmReturn, jvmRuleData, jvmStress, kafkaFill, kafkaFlood, kafkaIo, networkBandwidth, networkCorrupt, networkDelay, networkDns, networkDown, networkDuplicate, networkFlood, networkLoss, networkPartition, process, redisCacheLimit, redisExpiration, redisPenetration, redisRestart, redisStop, stressCpu, stressMem, userDefined, vm, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clock == null)) {
        sb.append("clock:");
        sb.append(clock);
        sb.append(",");
    }
    if (!(diskFill == null)) {
        sb.append("diskFill:");
        sb.append(diskFill);
        sb.append(",");
    }
    if (!(diskReadPayload == null)) {
        sb.append("diskReadPayload:");
        sb.append(diskReadPayload);
        sb.append(",");
    }
    if (!(diskWritePayload == null)) {
        sb.append("diskWritePayload:");
        sb.append(diskWritePayload);
        sb.append(",");
    }
    if (!(fileAppend == null)) {
        sb.append("fileAppend:");
        sb.append(fileAppend);
        sb.append(",");
    }
    if (!(fileCreate == null)) {
        sb.append("fileCreate:");
        sb.append(fileCreate);
        sb.append(",");
    }
    if (!(fileDelete == null)) {
        sb.append("fileDelete:");
        sb.append(fileDelete);
        sb.append(",");
    }
    if (!(fileModify == null)) {
        sb.append("fileModify:");
        sb.append(fileModify);
        sb.append(",");
    }
    if (!(fileRename == null)) {
        sb.append("fileRename:");
        sb.append(fileRename);
        sb.append(",");
    }
    if (!(fileReplace == null)) {
        sb.append("fileReplace:");
        sb.append(fileReplace);
        sb.append(",");
    }
    if (!(httpAbort == null)) {
        sb.append("httpAbort:");
        sb.append(httpAbort);
        sb.append(",");
    }
    if (!(httpConfig == null)) {
        sb.append("httpConfig:");
        sb.append(httpConfig);
        sb.append(",");
    }
    if (!(httpDelay == null)) {
        sb.append("httpDelay:");
        sb.append(httpDelay);
        sb.append(",");
    }
    if (!(httpRequest == null)) {
        sb.append("httpRequest:");
        sb.append(httpRequest);
        sb.append(",");
    }
    if (!(jvmException == null)) {
        sb.append("jvmException:");
        sb.append(jvmException);
        sb.append(",");
    }
    if (!(jvmGc == null)) {
        sb.append("jvmGc:");
        sb.append(jvmGc);
        sb.append(",");
    }
    if (!(jvmLatency == null)) {
        sb.append("jvmLatency:");
        sb.append(jvmLatency);
        sb.append(",");
    }
    if (!(jvmMysql == null)) {
        sb.append("jvmMysql:");
        sb.append(jvmMysql);
        sb.append(",");
    }
    if (!(jvmReturn == null)) {
        sb.append("jvmReturn:");
        sb.append(jvmReturn);
        sb.append(",");
    }
    if (!(jvmRuleData == null)) {
        sb.append("jvmRuleData:");
        sb.append(jvmRuleData);
        sb.append(",");
    }
    if (!(jvmStress == null)) {
        sb.append("jvmStress:");
        sb.append(jvmStress);
        sb.append(",");
    }
    if (!(kafkaFill == null)) {
        sb.append("kafkaFill:");
        sb.append(kafkaFill);
        sb.append(",");
    }
    if (!(kafkaFlood == null)) {
        sb.append("kafkaFlood:");
        sb.append(kafkaFlood);
        sb.append(",");
    }
    if (!(kafkaIo == null)) {
        sb.append("kafkaIo:");
        sb.append(kafkaIo);
        sb.append(",");
    }
    if (!(networkBandwidth == null)) {
        sb.append("networkBandwidth:");
        sb.append(networkBandwidth);
        sb.append(",");
    }
    if (!(networkCorrupt == null)) {
        sb.append("networkCorrupt:");
        sb.append(networkCorrupt);
        sb.append(",");
    }
    if (!(networkDelay == null)) {
        sb.append("networkDelay:");
        sb.append(networkDelay);
        sb.append(",");
    }
    if (!(networkDns == null)) {
        sb.append("networkDns:");
        sb.append(networkDns);
        sb.append(",");
    }
    if (!(networkDown == null)) {
        sb.append("networkDown:");
        sb.append(networkDown);
        sb.append(",");
    }
    if (!(networkDuplicate == null)) {
        sb.append("networkDuplicate:");
        sb.append(networkDuplicate);
        sb.append(",");
    }
    if (!(networkFlood == null)) {
        sb.append("networkFlood:");
        sb.append(networkFlood);
        sb.append(",");
    }
    if (!(networkLoss == null)) {
        sb.append("networkLoss:");
        sb.append(networkLoss);
        sb.append(",");
    }
    if (!(networkPartition == null)) {
        sb.append("networkPartition:");
        sb.append(networkPartition);
        sb.append(",");
    }
    if (!(process == null)) {
        sb.append("process:");
        sb.append(process);
        sb.append(",");
    }
    if (!(redisCacheLimit == null)) {
        sb.append("redisCacheLimit:");
        sb.append(redisCacheLimit);
        sb.append(",");
    }
    if (!(redisExpiration == null)) {
        sb.append("redisExpiration:");
        sb.append(redisExpiration);
        sb.append(",");
    }
    if (!(redisPenetration == null)) {
        sb.append("redisPenetration:");
        sb.append(redisPenetration);
        sb.append(",");
    }
    if (!(redisRestart == null)) {
        sb.append("redisRestart:");
        sb.append(redisRestart);
        sb.append(",");
    }
    if (!(redisStop == null)) {
        sb.append("redisStop:");
        sb.append(redisStop);
        sb.append(",");
    }
    if (!(stressCpu == null)) {
        sb.append("stressCpu:");
        sb.append(stressCpu);
        sb.append(",");
    }
    if (!(stressMem == null)) {
        sb.append("stressMem:");
        sb.append(stressMem);
        sb.append(",");
    }
    if (!(userDefined == null)) {
        sb.append("userDefined:");
        sb.append(userDefined);
        sb.append(",");
    }
    if (!(vm == null)) {
        sb.append("vm:");
        sb.append(vm);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withClock(ClockSpec clock) {
    this._visitables.remove("clock");
    if (clock != null) {
        this.clock = new ClockSpecBuilder(clock);
        this._visitables.get("clock").add(this.clock);
    } else {
        this.clock = null;
        this._visitables.get("clock").remove(this.clock);
    }
    return (A) this;
  }
  
  public A withDiskFill(DiskFillSpec diskFill) {
    this._visitables.remove("diskFill");
    if (diskFill != null) {
        this.diskFill = new DiskFillSpecBuilder(diskFill);
        this._visitables.get("diskFill").add(this.diskFill);
    } else {
        this.diskFill = null;
        this._visitables.get("diskFill").remove(this.diskFill);
    }
    return (A) this;
  }
  
  public A withDiskReadPayload(DiskPayloadSpec diskReadPayload) {
    this._visitables.remove("diskReadPayload");
    if (diskReadPayload != null) {
        this.diskReadPayload = new DiskPayloadSpecBuilder(diskReadPayload);
        this._visitables.get("diskReadPayload").add(this.diskReadPayload);
    } else {
        this.diskReadPayload = null;
        this._visitables.get("diskReadPayload").remove(this.diskReadPayload);
    }
    return (A) this;
  }
  
  public A withDiskWritePayload(DiskPayloadSpec diskWritePayload) {
    this._visitables.remove("diskWritePayload");
    if (diskWritePayload != null) {
        this.diskWritePayload = new DiskPayloadSpecBuilder(diskWritePayload);
        this._visitables.get("diskWritePayload").add(this.diskWritePayload);
    } else {
        this.diskWritePayload = null;
        this._visitables.get("diskWritePayload").remove(this.diskWritePayload);
    }
    return (A) this;
  }
  
  public A withFileAppend(FileAppendSpec fileAppend) {
    this._visitables.remove("fileAppend");
    if (fileAppend != null) {
        this.fileAppend = new FileAppendSpecBuilder(fileAppend);
        this._visitables.get("fileAppend").add(this.fileAppend);
    } else {
        this.fileAppend = null;
        this._visitables.get("fileAppend").remove(this.fileAppend);
    }
    return (A) this;
  }
  
  public A withFileCreate(FileCreateSpec fileCreate) {
    this._visitables.remove("fileCreate");
    if (fileCreate != null) {
        this.fileCreate = new FileCreateSpecBuilder(fileCreate);
        this._visitables.get("fileCreate").add(this.fileCreate);
    } else {
        this.fileCreate = null;
        this._visitables.get("fileCreate").remove(this.fileCreate);
    }
    return (A) this;
  }
  
  public A withFileDelete(FileDeleteSpec fileDelete) {
    this._visitables.remove("fileDelete");
    if (fileDelete != null) {
        this.fileDelete = new FileDeleteSpecBuilder(fileDelete);
        this._visitables.get("fileDelete").add(this.fileDelete);
    } else {
        this.fileDelete = null;
        this._visitables.get("fileDelete").remove(this.fileDelete);
    }
    return (A) this;
  }
  
  public A withFileModify(FileModifyPrivilegeSpec fileModify) {
    this._visitables.remove("fileModify");
    if (fileModify != null) {
        this.fileModify = new FileModifyPrivilegeSpecBuilder(fileModify);
        this._visitables.get("fileModify").add(this.fileModify);
    } else {
        this.fileModify = null;
        this._visitables.get("fileModify").remove(this.fileModify);
    }
    return (A) this;
  }
  
  public A withFileRename(FileRenameSpec fileRename) {
    this._visitables.remove("fileRename");
    if (fileRename != null) {
        this.fileRename = new FileRenameSpecBuilder(fileRename);
        this._visitables.get("fileRename").add(this.fileRename);
    } else {
        this.fileRename = null;
        this._visitables.get("fileRename").remove(this.fileRename);
    }
    return (A) this;
  }
  
  public A withFileReplace(FileReplaceSpec fileReplace) {
    this._visitables.remove("fileReplace");
    if (fileReplace != null) {
        this.fileReplace = new FileReplaceSpecBuilder(fileReplace);
        this._visitables.get("fileReplace").add(this.fileReplace);
    } else {
        this.fileReplace = null;
        this._visitables.get("fileReplace").remove(this.fileReplace);
    }
    return (A) this;
  }
  
  public A withHttpAbort(HTTPAbortSpec httpAbort) {
    this._visitables.remove("httpAbort");
    if (httpAbort != null) {
        this.httpAbort = new HTTPAbortSpecBuilder(httpAbort);
        this._visitables.get("httpAbort").add(this.httpAbort);
    } else {
        this.httpAbort = null;
        this._visitables.get("httpAbort").remove(this.httpAbort);
    }
    return (A) this;
  }
  
  public A withHttpConfig(HTTPConfigSpec httpConfig) {
    this._visitables.remove("httpConfig");
    if (httpConfig != null) {
        this.httpConfig = new HTTPConfigSpecBuilder(httpConfig);
        this._visitables.get("httpConfig").add(this.httpConfig);
    } else {
        this.httpConfig = null;
        this._visitables.get("httpConfig").remove(this.httpConfig);
    }
    return (A) this;
  }
  
  public A withHttpDelay(HTTPDelaySpec httpDelay) {
    this._visitables.remove("httpDelay");
    if (httpDelay != null) {
        this.httpDelay = new HTTPDelaySpecBuilder(httpDelay);
        this._visitables.get("httpDelay").add(this.httpDelay);
    } else {
        this.httpDelay = null;
        this._visitables.get("httpDelay").remove(this.httpDelay);
    }
    return (A) this;
  }
  
  public A withHttpRequest(HTTPRequestSpec httpRequest) {
    this._visitables.remove("httpRequest");
    if (httpRequest != null) {
        this.httpRequest = new HTTPRequestSpecBuilder(httpRequest);
        this._visitables.get("httpRequest").add(this.httpRequest);
    } else {
        this.httpRequest = null;
        this._visitables.get("httpRequest").remove(this.httpRequest);
    }
    return (A) this;
  }
  
  public A withJvmException(JVMExceptionSpec jvmException) {
    this._visitables.remove("jvmException");
    if (jvmException != null) {
        this.jvmException = new JVMExceptionSpecBuilder(jvmException);
        this._visitables.get("jvmException").add(this.jvmException);
    } else {
        this.jvmException = null;
        this._visitables.get("jvmException").remove(this.jvmException);
    }
    return (A) this;
  }
  
  public A withJvmGc(JVMGCSpec jvmGc) {
    this._visitables.remove("jvmGc");
    if (jvmGc != null) {
        this.jvmGc = new JVMGCSpecBuilder(jvmGc);
        this._visitables.get("jvmGc").add(this.jvmGc);
    } else {
        this.jvmGc = null;
        this._visitables.get("jvmGc").remove(this.jvmGc);
    }
    return (A) this;
  }
  
  public A withJvmLatency(JVMLatencySpec jvmLatency) {
    this._visitables.remove("jvmLatency");
    if (jvmLatency != null) {
        this.jvmLatency = new JVMLatencySpecBuilder(jvmLatency);
        this._visitables.get("jvmLatency").add(this.jvmLatency);
    } else {
        this.jvmLatency = null;
        this._visitables.get("jvmLatency").remove(this.jvmLatency);
    }
    return (A) this;
  }
  
  public A withJvmMysql(PMJVMMySQLSpec jvmMysql) {
    this._visitables.remove("jvmMysql");
    if (jvmMysql != null) {
        this.jvmMysql = new PMJVMMySQLSpecBuilder(jvmMysql);
        this._visitables.get("jvmMysql").add(this.jvmMysql);
    } else {
        this.jvmMysql = null;
        this._visitables.get("jvmMysql").remove(this.jvmMysql);
    }
    return (A) this;
  }
  
  public A withJvmReturn(JVMReturnSpec jvmReturn) {
    this._visitables.remove("jvmReturn");
    if (jvmReturn != null) {
        this.jvmReturn = new JVMReturnSpecBuilder(jvmReturn);
        this._visitables.get("jvmReturn").add(this.jvmReturn);
    } else {
        this.jvmReturn = null;
        this._visitables.get("jvmReturn").remove(this.jvmReturn);
    }
    return (A) this;
  }
  
  public A withJvmRuleData(JVMRuleDataSpec jvmRuleData) {
    this._visitables.remove("jvmRuleData");
    if (jvmRuleData != null) {
        this.jvmRuleData = new JVMRuleDataSpecBuilder(jvmRuleData);
        this._visitables.get("jvmRuleData").add(this.jvmRuleData);
    } else {
        this.jvmRuleData = null;
        this._visitables.get("jvmRuleData").remove(this.jvmRuleData);
    }
    return (A) this;
  }
  
  public A withJvmStress(JVMStressSpec jvmStress) {
    this._visitables.remove("jvmStress");
    if (jvmStress != null) {
        this.jvmStress = new JVMStressSpecBuilder(jvmStress);
        this._visitables.get("jvmStress").add(this.jvmStress);
    } else {
        this.jvmStress = null;
        this._visitables.get("jvmStress").remove(this.jvmStress);
    }
    return (A) this;
  }
  
  public A withKafkaFill(KafkaFillSpec kafkaFill) {
    this._visitables.remove("kafkaFill");
    if (kafkaFill != null) {
        this.kafkaFill = new KafkaFillSpecBuilder(kafkaFill);
        this._visitables.get("kafkaFill").add(this.kafkaFill);
    } else {
        this.kafkaFill = null;
        this._visitables.get("kafkaFill").remove(this.kafkaFill);
    }
    return (A) this;
  }
  
  public A withKafkaFlood(KafkaFloodSpec kafkaFlood) {
    this._visitables.remove("kafkaFlood");
    if (kafkaFlood != null) {
        this.kafkaFlood = new KafkaFloodSpecBuilder(kafkaFlood);
        this._visitables.get("kafkaFlood").add(this.kafkaFlood);
    } else {
        this.kafkaFlood = null;
        this._visitables.get("kafkaFlood").remove(this.kafkaFlood);
    }
    return (A) this;
  }
  
  public A withKafkaIo(KafkaIOSpec kafkaIo) {
    this._visitables.remove("kafkaIo");
    if (kafkaIo != null) {
        this.kafkaIo = new KafkaIOSpecBuilder(kafkaIo);
        this._visitables.get("kafkaIo").add(this.kafkaIo);
    } else {
        this.kafkaIo = null;
        this._visitables.get("kafkaIo").remove(this.kafkaIo);
    }
    return (A) this;
  }
  
  public A withNetworkBandwidth(NetworkBandwidthSpec networkBandwidth) {
    this._visitables.remove("networkBandwidth");
    if (networkBandwidth != null) {
        this.networkBandwidth = new NetworkBandwidthSpecBuilder(networkBandwidth);
        this._visitables.get("networkBandwidth").add(this.networkBandwidth);
    } else {
        this.networkBandwidth = null;
        this._visitables.get("networkBandwidth").remove(this.networkBandwidth);
    }
    return (A) this;
  }
  
  public A withNetworkCorrupt(NetworkCorruptSpec networkCorrupt) {
    this._visitables.remove("networkCorrupt");
    if (networkCorrupt != null) {
        this.networkCorrupt = new NetworkCorruptSpecBuilder(networkCorrupt);
        this._visitables.get("networkCorrupt").add(this.networkCorrupt);
    } else {
        this.networkCorrupt = null;
        this._visitables.get("networkCorrupt").remove(this.networkCorrupt);
    }
    return (A) this;
  }
  
  public A withNetworkDelay(NetworkDelaySpec networkDelay) {
    this._visitables.remove("networkDelay");
    if (networkDelay != null) {
        this.networkDelay = new NetworkDelaySpecBuilder(networkDelay);
        this._visitables.get("networkDelay").add(this.networkDelay);
    } else {
        this.networkDelay = null;
        this._visitables.get("networkDelay").remove(this.networkDelay);
    }
    return (A) this;
  }
  
  public A withNetworkDns(NetworkDNSSpec networkDns) {
    this._visitables.remove("networkDns");
    if (networkDns != null) {
        this.networkDns = new NetworkDNSSpecBuilder(networkDns);
        this._visitables.get("networkDns").add(this.networkDns);
    } else {
        this.networkDns = null;
        this._visitables.get("networkDns").remove(this.networkDns);
    }
    return (A) this;
  }
  
  public A withNetworkDown(NetworkDownSpec networkDown) {
    this._visitables.remove("networkDown");
    if (networkDown != null) {
        this.networkDown = new NetworkDownSpecBuilder(networkDown);
        this._visitables.get("networkDown").add(this.networkDown);
    } else {
        this.networkDown = null;
        this._visitables.get("networkDown").remove(this.networkDown);
    }
    return (A) this;
  }
  
  public A withNetworkDuplicate(NetworkDuplicateSpec networkDuplicate) {
    this._visitables.remove("networkDuplicate");
    if (networkDuplicate != null) {
        this.networkDuplicate = new NetworkDuplicateSpecBuilder(networkDuplicate);
        this._visitables.get("networkDuplicate").add(this.networkDuplicate);
    } else {
        this.networkDuplicate = null;
        this._visitables.get("networkDuplicate").remove(this.networkDuplicate);
    }
    return (A) this;
  }
  
  public A withNetworkFlood(NetworkFloodSpec networkFlood) {
    this._visitables.remove("networkFlood");
    if (networkFlood != null) {
        this.networkFlood = new NetworkFloodSpecBuilder(networkFlood);
        this._visitables.get("networkFlood").add(this.networkFlood);
    } else {
        this.networkFlood = null;
        this._visitables.get("networkFlood").remove(this.networkFlood);
    }
    return (A) this;
  }
  
  public A withNetworkLoss(NetworkLossSpec networkLoss) {
    this._visitables.remove("networkLoss");
    if (networkLoss != null) {
        this.networkLoss = new NetworkLossSpecBuilder(networkLoss);
        this._visitables.get("networkLoss").add(this.networkLoss);
    } else {
        this.networkLoss = null;
        this._visitables.get("networkLoss").remove(this.networkLoss);
    }
    return (A) this;
  }
  
  public A withNetworkPartition(NetworkPartitionSpec networkPartition) {
    this._visitables.remove("networkPartition");
    if (networkPartition != null) {
        this.networkPartition = new NetworkPartitionSpecBuilder(networkPartition);
        this._visitables.get("networkPartition").add(this.networkPartition);
    } else {
        this.networkPartition = null;
        this._visitables.get("networkPartition").remove(this.networkPartition);
    }
    return (A) this;
  }
  
  public ClockNested<A> withNewClock() {
    return new ClockNested(null);
  }
  
  public A withNewClock(String clockIdsSlice,Integer pid,String timeOffset) {
    return (A) this.withClock(new ClockSpec(clockIdsSlice, pid, timeOffset));
  }
  
  public ClockNested<A> withNewClockLike(ClockSpec item) {
    return new ClockNested(item);
  }
  
  public DiskFillNested<A> withNewDiskFill() {
    return new DiskFillNested(null);
  }
  
  public A withNewDiskFill(Boolean fillByFallocate,String path,String size) {
    return (A) this.withDiskFill(new DiskFillSpec(fillByFallocate, path, size));
  }
  
  public DiskFillNested<A> withNewDiskFillLike(DiskFillSpec item) {
    return new DiskFillNested(item);
  }
  
  public DiskReadPayloadNested<A> withNewDiskReadPayload() {
    return new DiskReadPayloadNested(null);
  }
  
  public A withNewDiskReadPayload(String path,Integer payloadProcessNum,String size) {
    return (A) this.withDiskReadPayload(new DiskPayloadSpec(path, payloadProcessNum, size));
  }
  
  public DiskReadPayloadNested<A> withNewDiskReadPayloadLike(DiskPayloadSpec item) {
    return new DiskReadPayloadNested(item);
  }
  
  public DiskWritePayloadNested<A> withNewDiskWritePayload() {
    return new DiskWritePayloadNested(null);
  }
  
  public A withNewDiskWritePayload(String path,Integer payloadProcessNum,String size) {
    return (A) this.withDiskWritePayload(new DiskPayloadSpec(path, payloadProcessNum, size));
  }
  
  public DiskWritePayloadNested<A> withNewDiskWritePayloadLike(DiskPayloadSpec item) {
    return new DiskWritePayloadNested(item);
  }
  
  public FileAppendNested<A> withNewFileAppend() {
    return new FileAppendNested(null);
  }
  
  public A withNewFileAppend(Integer count,String data,String fileName) {
    return (A) this.withFileAppend(new FileAppendSpec(count, data, fileName));
  }
  
  public FileAppendNested<A> withNewFileAppendLike(FileAppendSpec item) {
    return new FileAppendNested(item);
  }
  
  public FileCreateNested<A> withNewFileCreate() {
    return new FileCreateNested(null);
  }
  
  public A withNewFileCreate(String dirName,String fileName) {
    return (A) this.withFileCreate(new FileCreateSpec(dirName, fileName));
  }
  
  public FileCreateNested<A> withNewFileCreateLike(FileCreateSpec item) {
    return new FileCreateNested(item);
  }
  
  public FileDeleteNested<A> withNewFileDelete() {
    return new FileDeleteNested(null);
  }
  
  public A withNewFileDelete(String dirName,String fileName) {
    return (A) this.withFileDelete(new FileDeleteSpec(dirName, fileName));
  }
  
  public FileDeleteNested<A> withNewFileDeleteLike(FileDeleteSpec item) {
    return new FileDeleteNested(item);
  }
  
  public FileModifyNested<A> withNewFileModify() {
    return new FileModifyNested(null);
  }
  
  public A withNewFileModify(String fileName,Long privilege) {
    return (A) this.withFileModify(new FileModifyPrivilegeSpec(fileName, privilege));
  }
  
  public FileModifyNested<A> withNewFileModifyLike(FileModifyPrivilegeSpec item) {
    return new FileModifyNested(item);
  }
  
  public FileRenameNested<A> withNewFileRename() {
    return new FileRenameNested(null);
  }
  
  public A withNewFileRename(String destFile,String sourceFile) {
    return (A) this.withFileRename(new FileRenameSpec(destFile, sourceFile));
  }
  
  public FileRenameNested<A> withNewFileRenameLike(FileRenameSpec item) {
    return new FileRenameNested(item);
  }
  
  public FileReplaceNested<A> withNewFileReplace() {
    return new FileReplaceNested(null);
  }
  
  public A withNewFileReplace(String destString,String fileName,Integer line,String originString) {
    return (A) this.withFileReplace(new FileReplaceSpec(destString, fileName, line, originString));
  }
  
  public FileReplaceNested<A> withNewFileReplaceLike(FileReplaceSpec item) {
    return new FileReplaceNested(item);
  }
  
  public HttpAbortNested<A> withNewHttpAbort() {
    return new HttpAbortNested(null);
  }
  
  public HttpAbortNested<A> withNewHttpAbortLike(HTTPAbortSpec item) {
    return new HttpAbortNested(item);
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public A withNewHttpConfig(String filePath) {
    return (A) this.withHttpConfig(new HTTPConfigSpec(filePath));
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfigSpec item) {
    return new HttpConfigNested(item);
  }
  
  public HttpDelayNested<A> withNewHttpDelay() {
    return new HttpDelayNested(null);
  }
  
  public HttpDelayNested<A> withNewHttpDelayLike(HTTPDelaySpec item) {
    return new HttpDelayNested(item);
  }
  
  public HttpRequestNested<A> withNewHttpRequest() {
    return new HttpRequestNested(null);
  }
  
  public A withNewHttpRequest(Integer count,Boolean enableConnPool,String url) {
    return (A) this.withHttpRequest(new HTTPRequestSpec(count, enableConnPool, url));
  }
  
  public HttpRequestNested<A> withNewHttpRequestLike(HTTPRequestSpec item) {
    return new HttpRequestNested(item);
  }
  
  public JvmExceptionNested<A> withNewJvmException() {
    return new JvmExceptionNested(null);
  }
  
  public A withNewJvmException(String className,String exception,String method,Integer pid,Integer port) {
    return (A) this.withJvmException(new JVMExceptionSpec(className, exception, method, pid, port));
  }
  
  public JvmExceptionNested<A> withNewJvmExceptionLike(JVMExceptionSpec item) {
    return new JvmExceptionNested(item);
  }
  
  public JvmGcNested<A> withNewJvmGc() {
    return new JvmGcNested(null);
  }
  
  public A withNewJvmGc(Integer pid,Integer port) {
    return (A) this.withJvmGc(new JVMGCSpec(pid, port));
  }
  
  public JvmGcNested<A> withNewJvmGcLike(JVMGCSpec item) {
    return new JvmGcNested(item);
  }
  
  public JvmLatencyNested<A> withNewJvmLatency() {
    return new JvmLatencyNested(null);
  }
  
  public A withNewJvmLatency(String className,Integer latency,String method,Integer pid,Integer port) {
    return (A) this.withJvmLatency(new JVMLatencySpec(className, latency, method, pid, port));
  }
  
  public JvmLatencyNested<A> withNewJvmLatencyLike(JVMLatencySpec item) {
    return new JvmLatencyNested(item);
  }
  
  public JvmMysqlNested<A> withNewJvmMysql() {
    return new JvmMysqlNested(null);
  }
  
  public JvmMysqlNested<A> withNewJvmMysqlLike(PMJVMMySQLSpec item) {
    return new JvmMysqlNested(item);
  }
  
  public JvmReturnNested<A> withNewJvmReturn() {
    return new JvmReturnNested(null);
  }
  
  public A withNewJvmReturn(String className,String method,Integer pid,Integer port,String value) {
    return (A) this.withJvmReturn(new JVMReturnSpec(className, method, pid, port, value));
  }
  
  public JvmReturnNested<A> withNewJvmReturnLike(JVMReturnSpec item) {
    return new JvmReturnNested(item);
  }
  
  public JvmRuleDataNested<A> withNewJvmRuleData() {
    return new JvmRuleDataNested(null);
  }
  
  public A withNewJvmRuleData(Integer pid,Integer port,String ruleData) {
    return (A) this.withJvmRuleData(new JVMRuleDataSpec(pid, port, ruleData));
  }
  
  public JvmRuleDataNested<A> withNewJvmRuleDataLike(JVMRuleDataSpec item) {
    return new JvmRuleDataNested(item);
  }
  
  public JvmStressNested<A> withNewJvmStress() {
    return new JvmStressNested(null);
  }
  
  public A withNewJvmStress(Integer cpuCount,String memType,Integer pid,Integer port) {
    return (A) this.withJvmStress(new JVMStressSpec(cpuCount, memType, pid, port));
  }
  
  public JvmStressNested<A> withNewJvmStressLike(JVMStressSpec item) {
    return new JvmStressNested(item);
  }
  
  public KafkaFillNested<A> withNewKafkaFill() {
    return new KafkaFillNested(null);
  }
  
  public KafkaFillNested<A> withNewKafkaFillLike(KafkaFillSpec item) {
    return new KafkaFillNested(item);
  }
  
  public KafkaFloodNested<A> withNewKafkaFlood() {
    return new KafkaFloodNested(null);
  }
  
  public KafkaFloodNested<A> withNewKafkaFloodLike(KafkaFloodSpec item) {
    return new KafkaFloodNested(item);
  }
  
  public KafkaIoNested<A> withNewKafkaIo() {
    return new KafkaIoNested(null);
  }
  
  public A withNewKafkaIo(String configFile,Boolean nonReadable,Boolean nonWritable,String topic) {
    return (A) this.withKafkaIo(new KafkaIOSpec(configFile, nonReadable, nonWritable, topic));
  }
  
  public KafkaIoNested<A> withNewKafkaIoLike(KafkaIOSpec item) {
    return new KafkaIoNested(item);
  }
  
  public NetworkBandwidthNested<A> withNewNetworkBandwidth() {
    return new NetworkBandwidthNested(null);
  }
  
  public NetworkBandwidthNested<A> withNewNetworkBandwidthLike(NetworkBandwidthSpec item) {
    return new NetworkBandwidthNested(item);
  }
  
  public NetworkCorruptNested<A> withNewNetworkCorrupt() {
    return new NetworkCorruptNested(null);
  }
  
  public NetworkCorruptNested<A> withNewNetworkCorruptLike(NetworkCorruptSpec item) {
    return new NetworkCorruptNested(item);
  }
  
  public NetworkDelayNested<A> withNewNetworkDelay() {
    return new NetworkDelayNested(null);
  }
  
  public NetworkDelayNested<A> withNewNetworkDelayLike(NetworkDelaySpec item) {
    return new NetworkDelayNested(item);
  }
  
  public NetworkDnsNested<A> withNewNetworkDns() {
    return new NetworkDnsNested(null);
  }
  
  public A withNewNetworkDns(String dnsDomainName,String dnsIp,String dnsServer) {
    return (A) this.withNetworkDns(new NetworkDNSSpec(dnsDomainName, dnsIp, dnsServer));
  }
  
  public NetworkDnsNested<A> withNewNetworkDnsLike(NetworkDNSSpec item) {
    return new NetworkDnsNested(item);
  }
  
  public NetworkDownNested<A> withNewNetworkDown() {
    return new NetworkDownNested(null);
  }
  
  public A withNewNetworkDown(String device,String duration) {
    return (A) this.withNetworkDown(new NetworkDownSpec(device, duration));
  }
  
  public NetworkDownNested<A> withNewNetworkDownLike(NetworkDownSpec item) {
    return new NetworkDownNested(item);
  }
  
  public NetworkDuplicateNested<A> withNewNetworkDuplicate() {
    return new NetworkDuplicateNested(null);
  }
  
  public NetworkDuplicateNested<A> withNewNetworkDuplicateLike(NetworkDuplicateSpec item) {
    return new NetworkDuplicateNested(item);
  }
  
  public NetworkFloodNested<A> withNewNetworkFlood() {
    return new NetworkFloodNested(null);
  }
  
  public A withNewNetworkFlood(String duration,String ipAddress,Integer parallel,String port,String rate) {
    return (A) this.withNetworkFlood(new NetworkFloodSpec(duration, ipAddress, parallel, port, rate));
  }
  
  public NetworkFloodNested<A> withNewNetworkFloodLike(NetworkFloodSpec item) {
    return new NetworkFloodNested(item);
  }
  
  public NetworkLossNested<A> withNewNetworkLoss() {
    return new NetworkLossNested(null);
  }
  
  public NetworkLossNested<A> withNewNetworkLossLike(NetworkLossSpec item) {
    return new NetworkLossNested(item);
  }
  
  public NetworkPartitionNested<A> withNewNetworkPartition() {
    return new NetworkPartitionNested(null);
  }
  
  public NetworkPartitionNested<A> withNewNetworkPartitionLike(NetworkPartitionSpec item) {
    return new NetworkPartitionNested(item);
  }
  
  public ProcessNested<A> withNewProcess() {
    return new ProcessNested(null);
  }
  
  public A withNewProcess(String process,String recoverCmd,Integer signal) {
    return (A) this.withProcess(new ProcessSpec(process, recoverCmd, signal));
  }
  
  public ProcessNested<A> withNewProcessLike(ProcessSpec item) {
    return new ProcessNested(item);
  }
  
  public RedisCacheLimitNested<A> withNewRedisCacheLimit() {
    return new RedisCacheLimitNested(null);
  }
  
  public A withNewRedisCacheLimit(String addr,String cacheSize,String password,String percent) {
    return (A) this.withRedisCacheLimit(new RedisCacheLimitSpec(addr, cacheSize, password, percent));
  }
  
  public RedisCacheLimitNested<A> withNewRedisCacheLimitLike(RedisCacheLimitSpec item) {
    return new RedisCacheLimitNested(item);
  }
  
  public RedisExpirationNested<A> withNewRedisExpiration() {
    return new RedisExpirationNested(null);
  }
  
  public A withNewRedisExpiration(String addr,String expiration,String key,String option,String password) {
    return (A) this.withRedisExpiration(new RedisExpirationSpec(addr, expiration, key, option, password));
  }
  
  public RedisExpirationNested<A> withNewRedisExpirationLike(RedisExpirationSpec item) {
    return new RedisExpirationNested(item);
  }
  
  public RedisPenetrationNested<A> withNewRedisPenetration() {
    return new RedisPenetrationNested(null);
  }
  
  public A withNewRedisPenetration(String addr,String password,Integer requestNum) {
    return (A) this.withRedisPenetration(new RedisPenetrationSpec(addr, password, requestNum));
  }
  
  public RedisPenetrationNested<A> withNewRedisPenetrationLike(RedisPenetrationSpec item) {
    return new RedisPenetrationNested(item);
  }
  
  public RedisRestartNested<A> withNewRedisRestart() {
    return new RedisRestartNested(null);
  }
  
  public A withNewRedisRestart(String addr,String conf,Boolean flushConfig,String password,Boolean redisPath) {
    return (A) this.withRedisRestart(new RedisSentinelRestartSpec(addr, conf, flushConfig, password, redisPath));
  }
  
  public RedisRestartNested<A> withNewRedisRestartLike(RedisSentinelRestartSpec item) {
    return new RedisRestartNested(item);
  }
  
  public RedisStopNested<A> withNewRedisStop() {
    return new RedisStopNested(null);
  }
  
  public A withNewRedisStop(String addr,String conf,Boolean flushConfig,String password,Boolean redisPath) {
    return (A) this.withRedisStop(new RedisSentinelStopSpec(addr, conf, flushConfig, password, redisPath));
  }
  
  public RedisStopNested<A> withNewRedisStopLike(RedisSentinelStopSpec item) {
    return new RedisStopNested(item);
  }
  
  public StressCpuNested<A> withNewStressCpu() {
    return new StressCpuNested(null);
  }
  
  public StressCpuNested<A> withNewStressCpuLike(StressCPUSpec item) {
    return new StressCpuNested(item);
  }
  
  public StressMemNested<A> withNewStressMem() {
    return new StressMemNested(null);
  }
  
  public StressMemNested<A> withNewStressMemLike(StressMemorySpec item) {
    return new StressMemNested(item);
  }
  
  public UserDefinedNested<A> withNewUserDefined() {
    return new UserDefinedNested(null);
  }
  
  public A withNewUserDefined(String attackCmd,String recoverCmd) {
    return (A) this.withUserDefined(new UserDefinedSpec(attackCmd, recoverCmd));
  }
  
  public UserDefinedNested<A> withNewUserDefinedLike(UserDefinedSpec item) {
    return new UserDefinedNested(item);
  }
  
  public VmNested<A> withNewVm() {
    return new VmNested(null);
  }
  
  public A withNewVm(String vmName) {
    return (A) this.withVm(new VMSpec(vmName));
  }
  
  public VmNested<A> withNewVmLike(VMSpec item) {
    return new VmNested(item);
  }
  
  public A withProcess(ProcessSpec process) {
    this._visitables.remove("process");
    if (process != null) {
        this.process = new ProcessSpecBuilder(process);
        this._visitables.get("process").add(this.process);
    } else {
        this.process = null;
        this._visitables.get("process").remove(this.process);
    }
    return (A) this;
  }
  
  public A withRedisCacheLimit(RedisCacheLimitSpec redisCacheLimit) {
    this._visitables.remove("redisCacheLimit");
    if (redisCacheLimit != null) {
        this.redisCacheLimit = new RedisCacheLimitSpecBuilder(redisCacheLimit);
        this._visitables.get("redisCacheLimit").add(this.redisCacheLimit);
    } else {
        this.redisCacheLimit = null;
        this._visitables.get("redisCacheLimit").remove(this.redisCacheLimit);
    }
    return (A) this;
  }
  
  public A withRedisExpiration(RedisExpirationSpec redisExpiration) {
    this._visitables.remove("redisExpiration");
    if (redisExpiration != null) {
        this.redisExpiration = new RedisExpirationSpecBuilder(redisExpiration);
        this._visitables.get("redisExpiration").add(this.redisExpiration);
    } else {
        this.redisExpiration = null;
        this._visitables.get("redisExpiration").remove(this.redisExpiration);
    }
    return (A) this;
  }
  
  public A withRedisPenetration(RedisPenetrationSpec redisPenetration) {
    this._visitables.remove("redisPenetration");
    if (redisPenetration != null) {
        this.redisPenetration = new RedisPenetrationSpecBuilder(redisPenetration);
        this._visitables.get("redisPenetration").add(this.redisPenetration);
    } else {
        this.redisPenetration = null;
        this._visitables.get("redisPenetration").remove(this.redisPenetration);
    }
    return (A) this;
  }
  
  public A withRedisRestart(RedisSentinelRestartSpec redisRestart) {
    this._visitables.remove("redisRestart");
    if (redisRestart != null) {
        this.redisRestart = new RedisSentinelRestartSpecBuilder(redisRestart);
        this._visitables.get("redisRestart").add(this.redisRestart);
    } else {
        this.redisRestart = null;
        this._visitables.get("redisRestart").remove(this.redisRestart);
    }
    return (A) this;
  }
  
  public A withRedisStop(RedisSentinelStopSpec redisStop) {
    this._visitables.remove("redisStop");
    if (redisStop != null) {
        this.redisStop = new RedisSentinelStopSpecBuilder(redisStop);
        this._visitables.get("redisStop").add(this.redisStop);
    } else {
        this.redisStop = null;
        this._visitables.get("redisStop").remove(this.redisStop);
    }
    return (A) this;
  }
  
  public A withStressCpu(StressCPUSpec stressCpu) {
    this._visitables.remove("stressCpu");
    if (stressCpu != null) {
        this.stressCpu = new StressCPUSpecBuilder(stressCpu);
        this._visitables.get("stressCpu").add(this.stressCpu);
    } else {
        this.stressCpu = null;
        this._visitables.get("stressCpu").remove(this.stressCpu);
    }
    return (A) this;
  }
  
  public A withStressMem(StressMemorySpec stressMem) {
    this._visitables.remove("stressMem");
    if (stressMem != null) {
        this.stressMem = new StressMemorySpecBuilder(stressMem);
        this._visitables.get("stressMem").add(this.stressMem);
    } else {
        this.stressMem = null;
        this._visitables.get("stressMem").remove(this.stressMem);
    }
    return (A) this;
  }
  
  public A withUserDefined(UserDefinedSpec userDefined) {
    this._visitables.remove("userDefined");
    if (userDefined != null) {
        this.userDefined = new UserDefinedSpecBuilder(userDefined);
        this._visitables.get("userDefined").add(this.userDefined);
    } else {
        this.userDefined = null;
        this._visitables.get("userDefined").remove(this.userDefined);
    }
    return (A) this;
  }
  
  public A withVm(VMSpec vm) {
    this._visitables.remove("vm");
    if (vm != null) {
        this.vm = new VMSpecBuilder(vm);
        this._visitables.get("vm").add(this.vm);
    } else {
        this.vm = null;
        this._visitables.get("vm").remove(this.vm);
    }
    return (A) this;
  }
  public class ClockNested<N> extends ClockSpecFluent<ClockNested<N>> implements Nested<N>{
  
    ClockSpecBuilder builder;
  
    ClockNested(ClockSpec item) {
      this.builder = new ClockSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withClock(builder.build());
    }
    
    public N endClock() {
      return and();
    }
    
  }
  public class DiskFillNested<N> extends DiskFillSpecFluent<DiskFillNested<N>> implements Nested<N>{
  
    DiskFillSpecBuilder builder;
  
    DiskFillNested(DiskFillSpec item) {
      this.builder = new DiskFillSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withDiskFill(builder.build());
    }
    
    public N endDiskFill() {
      return and();
    }
    
  }
  public class DiskReadPayloadNested<N> extends DiskPayloadSpecFluent<DiskReadPayloadNested<N>> implements Nested<N>{
  
    DiskPayloadSpecBuilder builder;
  
    DiskReadPayloadNested(DiskPayloadSpec item) {
      this.builder = new DiskPayloadSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withDiskReadPayload(builder.build());
    }
    
    public N endDiskReadPayload() {
      return and();
    }
    
  }
  public class DiskWritePayloadNested<N> extends DiskPayloadSpecFluent<DiskWritePayloadNested<N>> implements Nested<N>{
  
    DiskPayloadSpecBuilder builder;
  
    DiskWritePayloadNested(DiskPayloadSpec item) {
      this.builder = new DiskPayloadSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withDiskWritePayload(builder.build());
    }
    
    public N endDiskWritePayload() {
      return and();
    }
    
  }
  public class FileAppendNested<N> extends FileAppendSpecFluent<FileAppendNested<N>> implements Nested<N>{
  
    FileAppendSpecBuilder builder;
  
    FileAppendNested(FileAppendSpec item) {
      this.builder = new FileAppendSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withFileAppend(builder.build());
    }
    
    public N endFileAppend() {
      return and();
    }
    
  }
  public class FileCreateNested<N> extends FileCreateSpecFluent<FileCreateNested<N>> implements Nested<N>{
  
    FileCreateSpecBuilder builder;
  
    FileCreateNested(FileCreateSpec item) {
      this.builder = new FileCreateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withFileCreate(builder.build());
    }
    
    public N endFileCreate() {
      return and();
    }
    
  }
  public class FileDeleteNested<N> extends FileDeleteSpecFluent<FileDeleteNested<N>> implements Nested<N>{
  
    FileDeleteSpecBuilder builder;
  
    FileDeleteNested(FileDeleteSpec item) {
      this.builder = new FileDeleteSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withFileDelete(builder.build());
    }
    
    public N endFileDelete() {
      return and();
    }
    
  }
  public class FileModifyNested<N> extends FileModifyPrivilegeSpecFluent<FileModifyNested<N>> implements Nested<N>{
  
    FileModifyPrivilegeSpecBuilder builder;
  
    FileModifyNested(FileModifyPrivilegeSpec item) {
      this.builder = new FileModifyPrivilegeSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withFileModify(builder.build());
    }
    
    public N endFileModify() {
      return and();
    }
    
  }
  public class FileRenameNested<N> extends FileRenameSpecFluent<FileRenameNested<N>> implements Nested<N>{
  
    FileRenameSpecBuilder builder;
  
    FileRenameNested(FileRenameSpec item) {
      this.builder = new FileRenameSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withFileRename(builder.build());
    }
    
    public N endFileRename() {
      return and();
    }
    
  }
  public class FileReplaceNested<N> extends FileReplaceSpecFluent<FileReplaceNested<N>> implements Nested<N>{
  
    FileReplaceSpecBuilder builder;
  
    FileReplaceNested(FileReplaceSpec item) {
      this.builder = new FileReplaceSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withFileReplace(builder.build());
    }
    
    public N endFileReplace() {
      return and();
    }
    
  }
  public class HttpAbortNested<N> extends HTTPAbortSpecFluent<HttpAbortNested<N>> implements Nested<N>{
  
    HTTPAbortSpecBuilder builder;
  
    HttpAbortNested(HTTPAbortSpec item) {
      this.builder = new HTTPAbortSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withHttpAbort(builder.build());
    }
    
    public N endHttpAbort() {
      return and();
    }
    
  }
  public class HttpConfigNested<N> extends HTTPConfigSpecFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigSpecBuilder builder;
  
    HttpConfigNested(HTTPConfigSpec item) {
      this.builder = new HTTPConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
  public class HttpDelayNested<N> extends HTTPDelaySpecFluent<HttpDelayNested<N>> implements Nested<N>{
  
    HTTPDelaySpecBuilder builder;
  
    HttpDelayNested(HTTPDelaySpec item) {
      this.builder = new HTTPDelaySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withHttpDelay(builder.build());
    }
    
    public N endHttpDelay() {
      return and();
    }
    
  }
  public class HttpRequestNested<N> extends HTTPRequestSpecFluent<HttpRequestNested<N>> implements Nested<N>{
  
    HTTPRequestSpecBuilder builder;
  
    HttpRequestNested(HTTPRequestSpec item) {
      this.builder = new HTTPRequestSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withHttpRequest(builder.build());
    }
    
    public N endHttpRequest() {
      return and();
    }
    
  }
  public class JvmExceptionNested<N> extends JVMExceptionSpecFluent<JvmExceptionNested<N>> implements Nested<N>{
  
    JVMExceptionSpecBuilder builder;
  
    JvmExceptionNested(JVMExceptionSpec item) {
      this.builder = new JVMExceptionSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withJvmException(builder.build());
    }
    
    public N endJvmException() {
      return and();
    }
    
  }
  public class JvmGcNested<N> extends JVMGCSpecFluent<JvmGcNested<N>> implements Nested<N>{
  
    JVMGCSpecBuilder builder;
  
    JvmGcNested(JVMGCSpec item) {
      this.builder = new JVMGCSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withJvmGc(builder.build());
    }
    
    public N endJvmGc() {
      return and();
    }
    
  }
  public class JvmLatencyNested<N> extends JVMLatencySpecFluent<JvmLatencyNested<N>> implements Nested<N>{
  
    JVMLatencySpecBuilder builder;
  
    JvmLatencyNested(JVMLatencySpec item) {
      this.builder = new JVMLatencySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withJvmLatency(builder.build());
    }
    
    public N endJvmLatency() {
      return and();
    }
    
  }
  public class JvmMysqlNested<N> extends PMJVMMySQLSpecFluent<JvmMysqlNested<N>> implements Nested<N>{
  
    PMJVMMySQLSpecBuilder builder;
  
    JvmMysqlNested(PMJVMMySQLSpec item) {
      this.builder = new PMJVMMySQLSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withJvmMysql(builder.build());
    }
    
    public N endJvmMysql() {
      return and();
    }
    
  }
  public class JvmReturnNested<N> extends JVMReturnSpecFluent<JvmReturnNested<N>> implements Nested<N>{
  
    JVMReturnSpecBuilder builder;
  
    JvmReturnNested(JVMReturnSpec item) {
      this.builder = new JVMReturnSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withJvmReturn(builder.build());
    }
    
    public N endJvmReturn() {
      return and();
    }
    
  }
  public class JvmRuleDataNested<N> extends JVMRuleDataSpecFluent<JvmRuleDataNested<N>> implements Nested<N>{
  
    JVMRuleDataSpecBuilder builder;
  
    JvmRuleDataNested(JVMRuleDataSpec item) {
      this.builder = new JVMRuleDataSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withJvmRuleData(builder.build());
    }
    
    public N endJvmRuleData() {
      return and();
    }
    
  }
  public class JvmStressNested<N> extends JVMStressSpecFluent<JvmStressNested<N>> implements Nested<N>{
  
    JVMStressSpecBuilder builder;
  
    JvmStressNested(JVMStressSpec item) {
      this.builder = new JVMStressSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withJvmStress(builder.build());
    }
    
    public N endJvmStress() {
      return and();
    }
    
  }
  public class KafkaFillNested<N> extends KafkaFillSpecFluent<KafkaFillNested<N>> implements Nested<N>{
  
    KafkaFillSpecBuilder builder;
  
    KafkaFillNested(KafkaFillSpec item) {
      this.builder = new KafkaFillSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withKafkaFill(builder.build());
    }
    
    public N endKafkaFill() {
      return and();
    }
    
  }
  public class KafkaFloodNested<N> extends KafkaFloodSpecFluent<KafkaFloodNested<N>> implements Nested<N>{
  
    KafkaFloodSpecBuilder builder;
  
    KafkaFloodNested(KafkaFloodSpec item) {
      this.builder = new KafkaFloodSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withKafkaFlood(builder.build());
    }
    
    public N endKafkaFlood() {
      return and();
    }
    
  }
  public class KafkaIoNested<N> extends KafkaIOSpecFluent<KafkaIoNested<N>> implements Nested<N>{
  
    KafkaIOSpecBuilder builder;
  
    KafkaIoNested(KafkaIOSpec item) {
      this.builder = new KafkaIOSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withKafkaIo(builder.build());
    }
    
    public N endKafkaIo() {
      return and();
    }
    
  }
  public class NetworkBandwidthNested<N> extends NetworkBandwidthSpecFluent<NetworkBandwidthNested<N>> implements Nested<N>{
  
    NetworkBandwidthSpecBuilder builder;
  
    NetworkBandwidthNested(NetworkBandwidthSpec item) {
      this.builder = new NetworkBandwidthSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withNetworkBandwidth(builder.build());
    }
    
    public N endNetworkBandwidth() {
      return and();
    }
    
  }
  public class NetworkCorruptNested<N> extends NetworkCorruptSpecFluent<NetworkCorruptNested<N>> implements Nested<N>{
  
    NetworkCorruptSpecBuilder builder;
  
    NetworkCorruptNested(NetworkCorruptSpec item) {
      this.builder = new NetworkCorruptSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withNetworkCorrupt(builder.build());
    }
    
    public N endNetworkCorrupt() {
      return and();
    }
    
  }
  public class NetworkDelayNested<N> extends NetworkDelaySpecFluent<NetworkDelayNested<N>> implements Nested<N>{
  
    NetworkDelaySpecBuilder builder;
  
    NetworkDelayNested(NetworkDelaySpec item) {
      this.builder = new NetworkDelaySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withNetworkDelay(builder.build());
    }
    
    public N endNetworkDelay() {
      return and();
    }
    
  }
  public class NetworkDnsNested<N> extends NetworkDNSSpecFluent<NetworkDnsNested<N>> implements Nested<N>{
  
    NetworkDNSSpecBuilder builder;
  
    NetworkDnsNested(NetworkDNSSpec item) {
      this.builder = new NetworkDNSSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withNetworkDns(builder.build());
    }
    
    public N endNetworkDns() {
      return and();
    }
    
  }
  public class NetworkDownNested<N> extends NetworkDownSpecFluent<NetworkDownNested<N>> implements Nested<N>{
  
    NetworkDownSpecBuilder builder;
  
    NetworkDownNested(NetworkDownSpec item) {
      this.builder = new NetworkDownSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withNetworkDown(builder.build());
    }
    
    public N endNetworkDown() {
      return and();
    }
    
  }
  public class NetworkDuplicateNested<N> extends NetworkDuplicateSpecFluent<NetworkDuplicateNested<N>> implements Nested<N>{
  
    NetworkDuplicateSpecBuilder builder;
  
    NetworkDuplicateNested(NetworkDuplicateSpec item) {
      this.builder = new NetworkDuplicateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withNetworkDuplicate(builder.build());
    }
    
    public N endNetworkDuplicate() {
      return and();
    }
    
  }
  public class NetworkFloodNested<N> extends NetworkFloodSpecFluent<NetworkFloodNested<N>> implements Nested<N>{
  
    NetworkFloodSpecBuilder builder;
  
    NetworkFloodNested(NetworkFloodSpec item) {
      this.builder = new NetworkFloodSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withNetworkFlood(builder.build());
    }
    
    public N endNetworkFlood() {
      return and();
    }
    
  }
  public class NetworkLossNested<N> extends NetworkLossSpecFluent<NetworkLossNested<N>> implements Nested<N>{
  
    NetworkLossSpecBuilder builder;
  
    NetworkLossNested(NetworkLossSpec item) {
      this.builder = new NetworkLossSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withNetworkLoss(builder.build());
    }
    
    public N endNetworkLoss() {
      return and();
    }
    
  }
  public class NetworkPartitionNested<N> extends NetworkPartitionSpecFluent<NetworkPartitionNested<N>> implements Nested<N>{
  
    NetworkPartitionSpecBuilder builder;
  
    NetworkPartitionNested(NetworkPartitionSpec item) {
      this.builder = new NetworkPartitionSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withNetworkPartition(builder.build());
    }
    
    public N endNetworkPartition() {
      return and();
    }
    
  }
  public class ProcessNested<N> extends ProcessSpecFluent<ProcessNested<N>> implements Nested<N>{
  
    ProcessSpecBuilder builder;
  
    ProcessNested(ProcessSpec item) {
      this.builder = new ProcessSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withProcess(builder.build());
    }
    
    public N endProcess() {
      return and();
    }
    
  }
  public class RedisCacheLimitNested<N> extends RedisCacheLimitSpecFluent<RedisCacheLimitNested<N>> implements Nested<N>{
  
    RedisCacheLimitSpecBuilder builder;
  
    RedisCacheLimitNested(RedisCacheLimitSpec item) {
      this.builder = new RedisCacheLimitSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withRedisCacheLimit(builder.build());
    }
    
    public N endRedisCacheLimit() {
      return and();
    }
    
  }
  public class RedisExpirationNested<N> extends RedisExpirationSpecFluent<RedisExpirationNested<N>> implements Nested<N>{
  
    RedisExpirationSpecBuilder builder;
  
    RedisExpirationNested(RedisExpirationSpec item) {
      this.builder = new RedisExpirationSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withRedisExpiration(builder.build());
    }
    
    public N endRedisExpiration() {
      return and();
    }
    
  }
  public class RedisPenetrationNested<N> extends RedisPenetrationSpecFluent<RedisPenetrationNested<N>> implements Nested<N>{
  
    RedisPenetrationSpecBuilder builder;
  
    RedisPenetrationNested(RedisPenetrationSpec item) {
      this.builder = new RedisPenetrationSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withRedisPenetration(builder.build());
    }
    
    public N endRedisPenetration() {
      return and();
    }
    
  }
  public class RedisRestartNested<N> extends RedisSentinelRestartSpecFluent<RedisRestartNested<N>> implements Nested<N>{
  
    RedisSentinelRestartSpecBuilder builder;
  
    RedisRestartNested(RedisSentinelRestartSpec item) {
      this.builder = new RedisSentinelRestartSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withRedisRestart(builder.build());
    }
    
    public N endRedisRestart() {
      return and();
    }
    
  }
  public class RedisStopNested<N> extends RedisSentinelStopSpecFluent<RedisStopNested<N>> implements Nested<N>{
  
    RedisSentinelStopSpecBuilder builder;
  
    RedisStopNested(RedisSentinelStopSpec item) {
      this.builder = new RedisSentinelStopSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withRedisStop(builder.build());
    }
    
    public N endRedisStop() {
      return and();
    }
    
  }
  public class StressCpuNested<N> extends StressCPUSpecFluent<StressCpuNested<N>> implements Nested<N>{
  
    StressCPUSpecBuilder builder;
  
    StressCpuNested(StressCPUSpec item) {
      this.builder = new StressCPUSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withStressCpu(builder.build());
    }
    
    public N endStressCpu() {
      return and();
    }
    
  }
  public class StressMemNested<N> extends StressMemorySpecFluent<StressMemNested<N>> implements Nested<N>{
  
    StressMemorySpecBuilder builder;
  
    StressMemNested(StressMemorySpec item) {
      this.builder = new StressMemorySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withStressMem(builder.build());
    }
    
    public N endStressMem() {
      return and();
    }
    
  }
  public class UserDefinedNested<N> extends UserDefinedSpecFluent<UserDefinedNested<N>> implements Nested<N>{
  
    UserDefinedSpecBuilder builder;
  
    UserDefinedNested(UserDefinedSpec item) {
      this.builder = new UserDefinedSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withUserDefined(builder.build());
    }
    
    public N endUserDefined() {
      return and();
    }
    
  }
  public class VmNested<N> extends VMSpecFluent<VmNested<N>> implements Nested<N>{
  
    VMSpecBuilder builder;
  
    VmNested(VMSpec item) {
      this.builder = new VMSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ExpInfoFluent.this.withVm(builder.build());
    }
    
    public N endVm() {
      return and();
    }
    
  }
}
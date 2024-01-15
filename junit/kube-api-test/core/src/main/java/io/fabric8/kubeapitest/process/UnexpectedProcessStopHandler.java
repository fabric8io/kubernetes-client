package io.fabric8.kubeapitest.process;

public interface UnexpectedProcessStopHandler {

  void processStopped(Process process);

}

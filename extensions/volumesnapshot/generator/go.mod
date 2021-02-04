module github.com/fabric8io/kubernetes-client/extensions/volumesnapshot/generator

  require (
  github.com/fabric8io/kubernetes-client/generator v0.0.0
  github.com/kubernetes-csi/external-snapshotter/client/v4 v4.0.0
  k8s.io/apimachinery v0.20.0
  )

  replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

  go 1.15

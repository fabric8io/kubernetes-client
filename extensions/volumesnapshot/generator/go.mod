module github.com/fabric8io/kubernetes-client/extensions/volumesnapshot/generator

  require (
  github.com/fabric8io/kubernetes-client/generator v0.0.0
  github.com/kubernetes-csi/external-snapshotter/v2 v2.1.1
  k8s.io/apimachinery v0.18.2
  )

  replace github.com/fabric8io/kubernetes-client/generator v0.0.0 => ./../../../generator

  go 1.13

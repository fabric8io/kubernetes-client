package packages

import "github.com/kudobuilder/kudo/pkg/kudoctl/verifier"

// Verifier defines the interface for all parameter verifiers
type Verifier interface {
	Verify(pf *Files) verifier.Result
}

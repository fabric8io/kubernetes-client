/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package policy

import (
	"io"

	"github.com/spf13/cobra"
	cmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	adminpolicy "github.com/openshift/origin/pkg/oc/admin/policy"
	"github.com/openshift/origin/pkg/oc/cli/util/clientcmd"
)

const PolicyRecommendedName = "policy"

func NewCmdPolicy(name, fullName string, f *clientcmd.Factory, out, errOut io.Writer) *cobra.Command {
	// Parent command to which all subcommands are added.
	cmds := &cobra.Command{
		Use:   name,
		Short: "Manage authorization policy",
		Long:  `Manage authorization policy`,
		Run:   cmdutil.DefaultSubCommandRun(errOut),
	}

	cmds.AddCommand(adminpolicy.NewCmdWhoCan(adminpolicy.WhoCanRecommendedName, fullName+" "+adminpolicy.WhoCanRecommendedName, f, out))
	cmds.AddCommand(adminpolicy.NewCmdCanI(adminpolicy.CanIRecommendedName, fullName+" "+adminpolicy.CanIRecommendedName, f, out))
	cmds.AddCommand(adminpolicy.NewCmdSccSubjectReview(adminpolicy.SubjectReviewRecommendedName, fullName+" "+adminpolicy.SubjectReviewRecommendedName, f, out))
	cmds.AddCommand(adminpolicy.NewCmdSccReview(adminpolicy.ReviewRecommendedName, fullName+" "+adminpolicy.ReviewRecommendedName, f, out))

	cmds.AddCommand(adminpolicy.NewCmdAddRoleToUser(adminpolicy.AddRoleToUserRecommendedName, fullName+" "+adminpolicy.AddRoleToUserRecommendedName, f, out))
	cmds.AddCommand(adminpolicy.NewCmdRemoveRoleFromUser(adminpolicy.RemoveRoleFromUserRecommendedName, fullName+" "+adminpolicy.RemoveRoleFromUserRecommendedName, f, out))
	cmds.AddCommand(adminpolicy.NewCmdRemoveUserFromProject(adminpolicy.RemoveUserRecommendedName, fullName+" "+adminpolicy.RemoveUserRecommendedName, f, out))
	cmds.AddCommand(adminpolicy.NewCmdAddRoleToGroup(adminpolicy.AddRoleToGroupRecommendedName, fullName+" "+adminpolicy.AddRoleToGroupRecommendedName, f, out))
	cmds.AddCommand(adminpolicy.NewCmdRemoveRoleFromGroup(adminpolicy.RemoveRoleFromGroupRecommendedName, fullName+" "+adminpolicy.RemoveRoleFromGroupRecommendedName, f, out))
	cmds.AddCommand(adminpolicy.NewCmdRemoveGroupFromProject(adminpolicy.RemoveGroupRecommendedName, fullName+" "+adminpolicy.RemoveGroupRecommendedName, f, out))

	return cmds
}

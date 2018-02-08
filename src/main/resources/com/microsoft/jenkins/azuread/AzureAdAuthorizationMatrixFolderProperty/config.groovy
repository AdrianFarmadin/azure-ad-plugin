package com.microsoft.jenkins.azuread.AzureAdAuthorizationMatrixFolderProperty

import lib.FormTagLib
import org.jenkinsci.plugins.matrixauth.inheritance.InheritanceStrategyDescriptor

import lib.FormTagLib
import org.jenkinsci.plugins.matrixauth.inheritance.InheritanceStrategyDescriptor

def f = namespace(FormTagLib)
def st = namespace("jelly:stapler")

f.optionalBlock(name: 'useProjectSecurity', checked: instance != null, title: _("Enable project-based security")) {
    f.nested {
        table(style: "width: 100%") {
            f.dropdownDescriptorSelector(title: _("Inheritance Strategy"), descriptors: InheritanceStrategyDescriptor.getApplicableDescriptors(my.class), field: 'inheritanceStrategy')
            st.include(class: "com.microsoft.jenkins.azuread.AzureAdMatrixAuthorizationStrategy", page: "config")
        }
    }
}
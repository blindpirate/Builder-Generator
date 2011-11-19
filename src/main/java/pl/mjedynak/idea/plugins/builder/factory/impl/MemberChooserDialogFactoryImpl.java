package pl.mjedynak.idea.plugins.builder.factory.impl;

import com.intellij.codeInsight.generation.PsiElementClassMember;
import com.intellij.ide.util.MemberChooser;
import com.intellij.openapi.project.Project;
import pl.mjedynak.idea.plugins.builder.factory.MemberChooserDialogFactory;

import java.util.List;

public class MemberChooserDialogFactoryImpl implements MemberChooserDialogFactory {
    public static final String TITLE = "Select fields to be available in builder";

    public MemberChooser getMemberChooserDialog(List<PsiElementClassMember> elements, Project project) {
        PsiElementClassMember[] array = new PsiElementClassMember[0];
        PsiElementClassMember[] psiElementClassMembers = elements.toArray(array);
        MemberChooser<PsiElementClassMember> memberChooserDialog = new MemberChooser<PsiElementClassMember>(psiElementClassMembers, false, true, project, false);
        memberChooserDialog.setCopyJavadocVisible(false);
        memberChooserDialog.selectElements(psiElementClassMembers);
        memberChooserDialog.setTitle("Select fields to be available in builder");
        return memberChooserDialog;
    }
}
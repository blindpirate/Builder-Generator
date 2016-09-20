package pl.mjedynak.idea.plugins.builder.factory;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiPackage;
import pl.mjedynak.idea.plugins.builder.gui.CreateBuilderDialog;
import pl.mjedynak.idea.plugins.builder.gui.helper.GuiHelper;
import pl.mjedynak.idea.plugins.builder.psi.PsiHelper;

import java.util.Locale;

import static com.intellij.openapi.util.text.StringUtil.isVowel;

public class CreateBuilderDialogFactory {

    static final String BUILDER_SUFFIX = "Builder";
    static final String METHOD_PREFIX = "with";
    static final String A_PREFIX = "a";
    static final String AN_PREFIX = "an";

    private static final String DIALOG_NAME = "CreateBuilder";
    private PsiHelper psiHelper;
    private ReferenceEditorComboWithBrowseButtonFactory referenceEditorComboWithBrowseButtonFactory;
    private GuiHelper guiHelper;


    public CreateBuilderDialogFactory(PsiHelper psiHelper, ReferenceEditorComboWithBrowseButtonFactory referenceEditorComboWithBrowseButtonFactory, GuiHelper guiHelper) {
        this.psiHelper = psiHelper;
        this.referenceEditorComboWithBrowseButtonFactory = referenceEditorComboWithBrowseButtonFactory;
        this.guiHelper = guiHelper;
    }

    public CreateBuilderDialog createBuilderDialog(PsiClass sourceClass, Project project, PsiPackage srcPackage) {
        return new CreateBuilderDialog(project, DIALOG_NAME, sourceClass, sourceClass.getName() + BUILDER_SUFFIX, METHOD_PREFIX,
                getDefaultInitMethodName(sourceClass), srcPackage, psiHelper, guiHelper,
                referenceEditorComboWithBrowseButtonFactory);
    }

    private String getDefaultInitMethodName(PsiClass sourceClass) {
        return isVowel(sourceClass.getName().toLowerCase(Locale.ENGLISH).charAt(0)) ? AN_PREFIX : A_PREFIX + sourceClass.getName();
    }
}

package org.eclipse.xtext.parser.fragments.idea.lang.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExElementTypeProvider;
import org.eclipse.xtext.parser.fragments.idea.parser.antlr.internal.PsiInternalFragmentTestLanguageExParser;
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageExGrammarAccess;

import com.google.inject.Inject;
import com.intellij.lang.PsiBuilder;

public class FragmentTestLanguageExPsiParser extends AbstractXtextPsiParser {

	private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT"));

	@Inject 
	private FragmentTestLanguageExGrammarAccess grammarAccess;

	@Inject 
	private FragmentTestLanguageExElementTypeProvider elementTypeProvider;

	@Override
	protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {
		return new PsiInternalFragmentTestLanguageExParser(builder, tokenStream, elementTypeProvider, grammarAccess);
	}

	@Override
	protected Set<String> getInitialHiddenTokens() {
		return INITIAL_HIDDEN_TOKENS;
	}

}
